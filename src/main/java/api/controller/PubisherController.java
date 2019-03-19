package api.controller;

import api.domain.Book;
import api.domain.query.QBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/publisher")
public class PubisherController extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> publishers = new QBook().setDistinct(true).select("publisher").findSingleAttributeList();

        String firstAuthor=String.valueOf(publishers.get(0));

        List<Book> books = new QBook().where().publisher.eq(firstAuthor).findList();
        req.setAttribute("publishers",publishers);
        req.setAttribute("books",books);
        req.setAttribute("ajaxChange",firstAuthor);
        req.getRequestDispatcher("views/publisher.jsp").forward(req,resp);

    }
}
