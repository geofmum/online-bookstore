package api.controller;

import api.domain.Book;
import api.domain.query.QBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexController extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // new
        List<Book> books = new QBook().setMaxRows(4).findList();
        System.out.println(books.size());
        req.setAttribute("books",books);
        req.getRequestDispatcher("views/index.jsp").forward(req, resp);
    }
}
