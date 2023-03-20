package com.example.trainease.servlet;

import com.example.trainease.dao.DomaineDAO;
import com.example.trainease.dao.FormateurDAO;
import com.example.trainease.dao.FormationDAO;
import com.example.trainease.model.Domaine;
import com.example.trainease.model.Formateur;
import com.example.trainease.model.Formation;
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
        Formation formation = new Formation();
        FormationDAO formationDAO = new FormationDAO();

        String intitule = request.getParameter("intitule");
        int daynumber = Integer.parseInt(request.getParameter("daynumber"));
        int month = Integer.parseInt(request.getParameter("month"));
        int year = Integer.parseInt(request.getParameter("year"));
        int idFormateur = Integer.parseInt(request.getParameter("formateur"));
        int idDomaine = Integer.parseInt(request.getParameter("domaine"));

        formation.setIntitule(intitule);
        formation.setNombre_jours(daynumber);
        formation.setMois(month);
        formation.setAnnee(year);
        formation.setCode_formateur(idFormateur);
        formation.setCode_domaine(idDomaine);

        int result = formationDAO.addFormation(formation);

        if (result == 1) {
            System.out.println("Success addCourse !");
            response.sendRedirect("ServletAddCourse");
        }else {
            System.out.println("Error addCourse !");
            response.sendRedirect("ServletAddCourse");
        }

    }
}
