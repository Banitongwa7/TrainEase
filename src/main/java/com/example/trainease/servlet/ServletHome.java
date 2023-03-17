package com.example.trainease.servlet;

import com.example.trainease.dao.FormateurDAO;
import com.example.trainease.dao.FormationDAO;
import com.example.trainease.dao.ParticipantDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletHome", urlPatterns = "/ServletHome")
public class ServletHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // statistique
        FormationDAO daoFormation = new FormationDAO();
        FormateurDAO daoFormateur = new FormateurDAO();
        ParticipantDAO daoParticipant = new ParticipantDAO();
        // number
        int nbFormation = daoFormation.getNbFormation();
        int nbFormateur = daoFormateur.getNbFormateur();
        int nbParticipant = daoParticipant.getNbParticipant();
        // dictionnaire
        Map<String, Integer> dictionnaire = new HashMap<>();

        dictionnaire.put("nbFormation", nbFormation);
        dictionnaire.put("nbFormateur", nbFormateur);
        dictionnaire.put("nbParticipant", nbParticipant);

        // statistique
        request.setAttribute("data", dictionnaire);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
