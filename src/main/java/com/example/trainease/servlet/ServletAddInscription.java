package com.example.trainease.servlet;

import com.example.trainease.dao.FormationDAO;
import com.example.trainease.dao.InscriptionDAO;
import com.example.trainease.dao.ParticipantDAO;
import com.example.trainease.model.Inscription;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAddInscription", value = "/ServletAddInscription")
public class ServletAddInscription extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormationDAO formationDAO = new FormationDAO();
        ParticipantDAO participantDAO = new ParticipantDAO();

        request.setAttribute("formations", formationDAO.getAllFormation());
        request.setAttribute("participants", participantDAO.getAllParticipant());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addInscription.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int formation = Integer.parseInt(request.getParameter("formation"));
        int particpant = Integer.parseInt(request.getParameter("participant"));
        InscriptionDAO inscriptionDAO = new InscriptionDAO();
        Inscription inscription = new Inscription(formation, particpant);

        int test = inscriptionDAO.addInscription(inscription);

        if (test == 1) {
            response.sendRedirect("ServletAddInscription");
        }else {
            request.setAttribute("error", "Impossible d'ajouter l'inscription");
            response.sendRedirect("ServletAddInscription");
        }


    }
}
