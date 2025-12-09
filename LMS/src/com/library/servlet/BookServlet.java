package com.library.servlet;

import com.library.dao.LibraryDAO;
import com.library.model.Book;

import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LibraryDAO dao = new LibraryDAO();
        List<Book> books = dao.getAllBooks();

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        StringBuilder json = new StringBuilder("[");
        for (Book b : books) {
            json.append("{\"id\":")
                .append(b.getId())
                .append(",\"title\":\"")
                .append(b.getTitle())
                .append("\",\"issued\":")
                .append(b.isIssued())
                .append("},");
        }

        if (json.length() > 1 && json.charAt(json.length() - 1) == ',')
            json.deleteCharAt(json.length() - 1);

        json.append("]");
        out.print(json.toString());
    }
}
