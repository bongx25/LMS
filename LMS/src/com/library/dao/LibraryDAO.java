package com.library.dao;

import com.library.model.Book;
import com.library.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                books.add(new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getBoolean("is_issued")
                ));
            }
            con.close();
        } catch (Exception e) {}

        return books;
    }

    public void issueBook(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "UPDATE books SET is_issued = 1 WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    public void returnBook(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "UPDATE books SET is_issued = 0 WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
