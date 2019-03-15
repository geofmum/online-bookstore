package api.controller;

import api.providers.Database;
import io.ebean.EbeanServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BaseController")
public class BaseController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

        Database.INSTANCE.initialize("app.db");
    }
}
