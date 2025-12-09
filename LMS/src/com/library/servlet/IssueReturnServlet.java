package com.library.servlet;

import com.library.dao.LibraryDAO;

import jakarta.servlet.http.*;
import java.io.IOException;

public class IssueReturnServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));

        LibraryDAO dao = new LibraryDAO();

        try {
            if ("issue".equals(action)) {
                dao.issueBook(id);
            } else if ("return".equals(action)) {
                dao.returnBook(id);
            }
        } catch (Exception e) {}

        resp.sendRedirect("index.html");
    }
}
