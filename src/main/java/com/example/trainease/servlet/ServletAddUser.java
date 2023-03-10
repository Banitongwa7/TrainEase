package com.example.trainease.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAddUser", value = "/ServletAddUser")
public class ServletAddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        String role = (String) request.getParameter("role");

        System.out.println("****************************************");
        System.out.println(username);
        System.out.println(password);
        System.out.println(role);
        System.out.println("****************************************");

        response.sendRedirect("addUser.jsp");
    }
}
