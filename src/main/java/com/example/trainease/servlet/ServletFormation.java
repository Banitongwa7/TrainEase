package com.example.trainease.servlet;

import com.example.trainease.dao.FormationDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletFormation", urlPatterns = "/ServletFormation")
public class ServletFormation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormationDAO formationDAO = new FormationDAO();
        request.setAttribute("formations", formationDAO.getAllFormation());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/liste_formations.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
