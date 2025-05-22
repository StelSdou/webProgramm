package com.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/register")
public class First extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");



        response.setContentType("text/html");
        response.getWriter().println("<h1>Login info:</h1>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("<p>Password: " + pass + "</p>");
    }
}
