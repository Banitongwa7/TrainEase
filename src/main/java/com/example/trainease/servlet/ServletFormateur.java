package com.example.trainease.servlet;

import com.example.trainease.dao.FormateurDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletFormateur", urlPatterns = "/ServletFormateur")
public class ServletFormateur extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FormateurDAO formateurDAO = new FormateurDAO();
        request.setAttribute("formateurs", formateurDAO.getAllFormateurs());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/liste_formateurs.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
