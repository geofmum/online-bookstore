package api.controller;

import api.domain.Book;
import api.domain.Cart;
import api.domain.CartItem;
import api.domain.query.QBook;
import api.domain.query.QCart;
import api.domain.query.QCartItem;
import com.fasterxml.jackson.core.JsonGenerationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CartController extends BaseController {
    protected List<String> scripts = new ArrayList<String>() {{
        add("resources/js/shopping-cart.js");
    }};

    protected List<String> styles = new ArrayList<String>() {{
        add("resources/css/shopping-cart.css");
    }};

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Cart cart = getUserCart(session);
        cart.setStatus(true);
        cart.save();

        session.removeAttribute("cart-id");

        resp.setStatus(200);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Cart cart = getUserCart(session);
        req.setAttribute("items", cart.getCart_items());
        req.setAttribute("cartTotal", cart.getTotal());

        req.getRequestDispatcher("views/shoppingCart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // extract request data
        String jsonString = req.getParameter("data");
        CartItem cartItem = mapper.readValue(jsonString, CartItem.class);

        // get user's session
        HttpSession session = req.getSession(true);

        Cart cart = getUserCart(session);

        cart.addCart_items(cartItem);
        cart.save();

        session.setAttribute("cartTotalItems", cart.getCart_items().size());
        cartItem.setCart(cart);

        try {
            cartItem.save();
        } catch (Exception e){}

        cartItem.setCart(null); // @hack to prevent jackson circular references

        PrintWriter out = resp.getWriter();

        try {
            out.print(mapper.writeValueAsString(cartItem));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    protected Cart getUserCart(HttpSession session) {
        String cartId = String.valueOf(session.getAttribute("cart-id"));
        Cart cart = null;

        if (cartId != null && cartId != "null") {
            cart = new QCart().id.eq(Long.valueOf(cartId))
                    .cart_items.fetchQuery()
                    .cart_items.book.fetch()
                    .findOne();
        }

        if (cart == null) {
            cart = new Cart();
            cart.setTotal(0);
            cart.setStatus(false);
            cart.save();

            session.setAttribute("cart-id", cart.getId());
        }

        return cart;
    }

    @Override
    protected List<String> getStyles() {
        return styles;
    }

    @Override
    protected List<String> getScripts() {
        return scripts;
    }
}
