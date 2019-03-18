package api.controller;

import api.domain.Address;
import api.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignUp extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pagename", "signup");
        req.getRequestDispatcher("views/signUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("name");
        String  email=req.getParameter("email");
        String password=req.getParameter("pass");
        String phone=req.getParameter("phone");
        String street=req.getParameter("street");
        String apt=req.getParameter("apt");
        String city=req.getParameter("city");
        String state=req.getParameter("state");
        String  zip=req.getParameter("zip");

        if((name==null || name.trim().length() == 0) && (email==null || email.trim().length() == 0) && (password==null || password.trim().length() == 0)){
            resp.sendRedirect("signup");
        }
        else{
            User user = new User();
            Address address = new Address();

            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);


            // ----- set the user object attributes
            address.setPhonenumber(phone);
            address.setStreet(street);
            address.setAppartment(apt);
            address.setCity(city);
            address.setState(state);
            address.setZipcode(zip);
            // -- set all address attributes

            user.save();

            address.setUser(user);
            address.save();

            // capture existing cart-id from the session before invalidating to create a new
            HttpSession session = req.getSession(false);
            String cartId = String.valueOf(session.getAttribute("cart-id"));

            session.invalidate();

            session = req.getSession(true);
            session.setAttribute("userid", user.getId());

            if (cartId != null && cartId == "null") {
                session.setAttribute("cart-id", cartId);
            }

            resp.sendRedirect("/");
        }

    }
}

