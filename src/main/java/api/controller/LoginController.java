package api.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname=req.getParameter("uname");
        String password=req.getParameter("pass");
        if("MOH".equals(uname) && "123".equals(password)){
            HttpSession session=req.getSession();
            session.setAttribute("user",uname);
            Cookie cookie=new Cookie("user",uname);
            cookie.setMaxAge(24*60*60);
            resp.addCookie(cookie);
            resp.sendRedirect("index.jsp");
        }
        else{
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out=resp.getWriter();
            out.print("Wrong Credentials");
            rd.include(req,resp);
        }
    }
}
