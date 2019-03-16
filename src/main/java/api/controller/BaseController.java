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

@WebServlet(name = "BaseController")
public abstract class BaseController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

        String rootDir = getProjectRootDir();

        Database.INSTANCE.initialize(rootDir + "/app.db");
        DatabaseFixtures.INSTANCE.initialize();
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
}
