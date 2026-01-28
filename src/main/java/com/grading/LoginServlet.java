package com.grading;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        String u = req.getParameter("username");
        String p = req.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, u);
            ps.setString(2, p);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                res.sendRedirect("dashboard.jsp");
            } else {
                res.sendRedirect("login.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
