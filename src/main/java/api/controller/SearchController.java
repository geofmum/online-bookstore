package api.controller;

import api.domain.Book;
import api.domain.query.QBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchController extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // new

        req.setAttribute("category", category);
        int index=Integer.valueOf( req.getParameter("c"));
        String search= req.getParameter("s");
        List<Book> books;
        if(index>0){
            String cat=category[index-1];
            books = new QBook().where().category.eq(cat).title.contains(search).findList();
        }
        else{
            books = new QBook().where().title.contains(search).findList();
        }

        req.setAttribute("books", books);
        req.setAttribute("searchVal", search);
        req.setAttribute("catindex", index);
        req.getRequestDispatcher("views/category.jsp").forward(req, resp);
    }
}
