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
        List<Book> romanceBooks = new QBook().where().category.eq("Romance").setMaxRows(4).findList();
        List<Book> FantasyBooks = new QBook().where().category.eq("Fantasy").setMaxRows(4).findList();
        List<Book> DramaBooks = new QBook().where().category.eq("Drama").setMaxRows(4).findList();
        System.out.println(romanceBooks.size());

        req.getSession().setAttribute("category", category);
        req.setAttribute("books",books);
        req.setAttribute("romanceBooks",romanceBooks);
        req.setAttribute("FantasyBooks",FantasyBooks);
        req.setAttribute("DramaBooks",DramaBooks);
        req.getRequestDispatcher("views/index.jsp").forward(req, resp);
    }
}
