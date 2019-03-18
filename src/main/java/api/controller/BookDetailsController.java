package api.controller;

import api.domain.Book;
import api.domain.query.QBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookDetailsController")
public class BookDetailsController extends BaseController {
    protected List<String> scripts = new ArrayList<String>(){{
        add("resources/js/book-details.js");
    }};

    protected List<String> styles = new ArrayList<String>(){{
        add("resources/css/book-details.css");
    }};

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("id");
        int id = bookId != null ? Integer.valueOf(bookId) : 0;

        Book book = new QBook().id.eq(id)
                .findOne();

        if (book == null) {
            NotFound(request, response);
            return;
        }

        request.setAttribute("book", book);
        request.setAttribute("percent_discount", Math.round(book.getDiscount() * 100));
        request.setAttribute("discount_amount", Math.round(book.getPrice() * book.getDiscount()));

        request.getRequestDispatcher("views/book-details.jsp").forward(request, response);
    }

    @Override
    protected List<String> getStyles() {
        return styles;
    }

    @Override
    protected List<String> getScripts() {
        return scripts;
    }
}
