package api.controller;

import api.domain.Book;
import api.domain.query.QBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryController extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // new

        req.setAttribute("category", category);
        int index=Integer.valueOf( req.getParameter("c"));
        String cat=category[index-1];
        List<Book> books = new QBook().where().category.eq(cat).findList();
        req.setAttribute("cat", cat);
        req.setAttribute("books", books);
        req.getRequestDispatcher("views/category.jsp").forward(req, resp);
    }
}
