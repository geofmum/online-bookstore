package api.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(Cookie c: req.getCookies()){
            c.setMaxAge(0);
            resp.addCookie(c);
        }

        req.getSession().invalidate();
        resp.sendRedirect("/");
    }
}
