package com.example.trainease.servlet;

import com.example.trainease.dao.DomaineDAO;
import com.example.trainease.dao.FormateurDAO;
import com.example.trainease.model.Domaine;
import com.example.trainease.model.Formateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletAddCourse", urlPatterns = "/ServletAddCourse")
public class ServletAddCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormateurDAO formateurDAO = new FormateurDAO();
        DomaineDAO domaineDAO = new DomaineDAO();

        List<Formateur> formateurs = formateurDAO.getAllFormateurs();
        List<Domaine> domaine = domaineDAO.getAllDomaine();

       request.setAttribute("domaine", domaine);
       request.setAttribute("formateurs", formateurs);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addCourse.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String intitule = request.getParameter("intitule");
        String daynumber = request.getParameter("daynumber");
        String month = request.getParameter("month");
        String year = request.getParameter("year");

    }
}
