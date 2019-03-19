package api.controller;

import api.domain.Address;
import api.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ajaxAuth")
public class ajaxAuthController extends BaseController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonUser=req.getParameter("user");
        User user=mapper.readValue(jsonUser,User.class);

        String jsonaddress=req.getParameter("address");
        Address address=mapper.readValue(jsonaddress,Address.class);
        String flag="";
        if((user.getName()==null || user.getName().trim().length()==0 )||(user.getEmail()==null || user.getEmail().trim().length()==0) ||(user.getPassword()==null || user.getPassword().trim().length()==0)){
            flag="Please fill up required fields!";

        }

           else{
            user.save();

            address.setUser(user);
            address.save();

        HttpSession session = req.getSession(false);
        String cartId = String.valueOf(session.getAttribute("cart-id"));

        session.invalidate();

        session = req.getSession(true);
        session.setAttribute("userid", user.getId());
          session.setAttribute("user", user.getName());

        if (cartId != null && cartId == "null") {
            session.setAttribute("cart-id", cartId);

        }
flag="success";
        }
        PrintWriter p=resp.getWriter();
        p.print(flag);
    }
}
