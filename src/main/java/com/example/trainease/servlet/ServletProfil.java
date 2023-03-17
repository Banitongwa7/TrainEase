package com.example.trainease.servlet;

import com.example.trainease.dao.ProfilDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletProfil", urlPatterns = "/ServletProfil")
public class ServletProfil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfilDAO profilDAO = new ProfilDAO();
        request.setAttribute("profils", profilDAO.getAllProfil());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profil.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
