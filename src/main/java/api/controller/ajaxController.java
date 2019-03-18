package api.controller;
import api.domain.Book;
import api.domain.query.QBook;
import com.fasterxml.jackson.core.JsonGenerationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ajax")
public class ajaxController extends BaseController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=req.getParameter("name");
        data=data.trim();
        int type=Integer.valueOf(req.getParameter("type"));
        //System.out.println(data);
        List<Book> books=null;
        if(type==1){
            books = new QBook().where().author.eq(data).findList();
        }
        if(type==2){
            books = new QBook().where().publisher.eq(data).findList();
        }
       // System.out.println(books.size());
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try {
            out.print(mapper.writeValueAsString(books));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        }
    }
}
