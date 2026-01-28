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

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String roll = req.getParameter("roll");
        String subject = req.getParameter("subject");
        int marks = Integer.parseInt(req.getParameter("marks"));

        String grade = calculateGrade(marks);

        try {
            Connection con = DBConnection.getConnection();

            // Insert student
            PreparedStatement ps1 = con.prepareStatement(
                "INSERT INTO students(name, roll_no) VALUES(?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS);

            ps1.setString(1, name);
            ps1.setString(2, roll);
            ps1.executeUpdate();

            // Get generated student ID
            ResultSet rs = ps1.getGeneratedKeys();
            rs.next();
            int studentId = rs.getInt(1);

            // Insert subject
            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO subjects(student_id, subject_name, marks, grade) VALUES(?,?,?,?)");

            ps2.setInt(1, studentId);
            ps2.setString(2, subject);
            ps2.setInt(3, marks);
            ps2.setString(4, grade);

            ps2.executeUpdate();

            con.close();

            res.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String calculateGrade(int m) {
        if (m >= 90) return "A+";
        else if (m >= 80) return "A";
        else if (m >= 70) return "B+";
        else if (m >= 60) return "B";
        else if (m >= 50) return "C";
        else if (m >= 40) return "D";
        else return "F";
    }
}
