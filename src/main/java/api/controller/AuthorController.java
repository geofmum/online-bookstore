package api.controller;

import api.domain.Book;
import api.domain.query.QBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/author")
public class AuthorController extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> authors = new QBook().setDistinct(true).select("author").findSingleAttributeList();

        String firstAuthor=String.valueOf(authors.get(0));

        List<Book> books = new QBook().where().author.eq(firstAuthor).findList();
        req.setAttribute("authors",authors);
        req.setAttribute("books",books);
        req.setAttribute("ajaxChange",firstAuthor);
        req.getRequestDispatcher("views/author.jsp").forward(req,resp);


    }
}
