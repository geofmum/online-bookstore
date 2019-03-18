package api.controller;

import api.domain.Book;
import api.domain.Cart;
import api.domain.CartItem;
import api.domain.query.QBook;
import api.domain.query.QCart;
import com.fasterxml.jackson.core.JsonGenerationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CartController extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/shoppingCart.jsp").forward(req, resp);
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

        cartItem.setCart(cart);
        cartItem.save();
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
            cart = new QCart().id.eq(Long.valueOf(cartId)).findOne();
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
}
