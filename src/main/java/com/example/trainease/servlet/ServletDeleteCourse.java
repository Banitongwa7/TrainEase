package com.example.trainease.servlet;

import com.example.trainease.dao.FormationDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletDeleteCourse", value = "/ServletDeleteCourse")
public class ServletDeleteCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_row"));
        FormationDAO formationDAO = new FormationDAO();
        boolean test = formationDAO.deleteFormation(id);

        if (test) {
            response.sendRedirect("ServletFormation");
        } else {
            request.setAttribute("error", "Impossible de supprimer la formation");
            response.sendRedirect("ServletFormation");
        }

    }
}
