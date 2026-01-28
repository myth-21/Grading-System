package com.grading;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String subject = request.getParameter("subject");
        int marks = Integer.parseInt(request.getParameter("marks"));

        String grade = calculateGrade(marks);

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name, roll_no, subject, marks, grade) VALUES(?,?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, roll);
            ps.setString(3, subject);
            ps.setInt(4, marks);
            ps.setString(5, grade);

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("name", name);
        request.setAttribute("roll", roll);
        request.setAttribute("subject", subject);
        request.setAttribute("marks", marks);
        request.setAttribute("grade", grade);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    private String calculateGrade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }
}
