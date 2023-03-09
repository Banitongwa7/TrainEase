package com.example.trainease.servlet;

import com.example.trainease.dao.RoleDAO;
import com.example.trainease.dao.UtilisateurDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAddUser", value = "/ServletAddUser")
public class ServletAddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        String role = (String) request.getParameter("role");
        UtilisateurDAO daoUser = new UtilisateurDAO();
        RoleDAO daoRole = new RoleDAO();

        response.sendRedirect("addUser.jsp");
    }
}
