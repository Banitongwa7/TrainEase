package com.example.trainease.servlet;

import com.example.trainease.dao.UtilisateurDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletUtilisateurs", value = "/ServletUtilisateurs")
public class ServletUtilisateurs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurDAO daoUser = new UtilisateurDAO();
        request.setAttribute("utilisateurs", daoUser.getAllUsers());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/liste_utilisateurs.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
