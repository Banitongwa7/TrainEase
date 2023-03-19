package com.example.trainease.servlet;

import com.example.trainease.dao.FormateurDAO;
import com.example.trainease.model.Formateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAddFormateur", value = "/ServletAddFormateur")
public class ServletAddFormateur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addFormateur.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        FormateurDAO formateurDAO = new FormateurDAO();
        Formateur formateur = new Formateur(nom, prenom, email, phone);

        int test = formateurDAO.addFormateur(formateur);
        if (test == 1) {
            response.sendRedirect("ServletAddFormateur");
        }else {
            request.setAttribute("error", "Impossible d'ajouter le formateur");
            response.sendRedirect("ServletAddFormateur");
        }

    }
}
