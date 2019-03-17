package api.controller;

import api.fixtures.DatabaseFixtures;
import api.providers.Database;
import io.ebean.EbeanServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BaseController")
public abstract class BaseController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

        String rootDir = getProjectRootDir();

        Database.INSTANCE.initialize(rootDir + "/app.db");
       // DatabaseFixtures.INSTANCE.initialize();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registerStyles(req);
        registerScripts(req);

        super.service(req, resp);
    }

    protected String getProjectRootDir() {
        String currentWorkingDir = getServletContext().getRealPath("/");
        String rootDir = Paths.get(currentWorkingDir)
                .getParent()
                .getParent()
                .getParent()
                .toString();

        return rootDir;
    }

    protected List<String> getStyles(){
        return new ArrayList<>();
    }

    protected List<String> getScripts(){
        return new ArrayList<>();
    }

    protected void registerStyles(HttpServletRequest req){
        req.setAttribute("styles", getStyles());
    }

    protected void  registerScripts(HttpServletRequest req){
        req.setAttribute("scripts", getScripts());
    }

    protected void NotFound(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/404.jsp").forward(request, response);
    }
}
