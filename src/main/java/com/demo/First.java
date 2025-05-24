package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/register")
public class First extends HttpServlet {

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.getWriter().println("Servlet OK!");
//
//        String url = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC";
//        String username = "java_db";
//        String password = "$Stelios1234567890";
//
//        try {
//            Connection conn = DriverManager.getConnection(url, username, password);
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
//
//            while (rs.next()) {
//                String email = rs.getString("email");
//                String pass = rs.getString("pass");
//                System.out.println("Email: " + email + ", Pass: " + pass);
//            }
//
//            // Κλείσιμο πόρων
//            rs.close();
//            stmt.close();
//            conn.close();
//
//        } catch (Exception e) {
//            System.out.println("❌ Σφάλμα:");
//            e.printStackTrace();
//        }
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        response.getWriter().println("waiting");

        String url = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC";
        String username = "java_db";
        String password = "$Stelios1234567890";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");

            while (rs.next()) {
                if (rs.getString("email").equals(email)) {
                    if  (rs.getString("pass").equals(pass)) {
                        response.getWriter().println("true");
                    }
                    else
                        response.getWriter().println("false pass");
                }
                else
                    response.getWriter().println("false email");
                System.out.println("Email: " + email + ", Pass: " + pass);
            }

            // Κλείσιμο πόρων
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("❌ Σφάλμα:");
            e.printStackTrace();
        }

//        request.getRequestDispatcher("Info.jsp").forward(request, response);
    }
}

