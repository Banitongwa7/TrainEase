package com.example.trainease.servlet;

import com.example.trainease.dao.FormationDAO;
import com.example.trainease.dao.InscriptionDAO;
import com.example.trainease.model.Formation;
import com.example.trainease.model.Participant;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletInscription", value = "/ServletInscription")
public class ServletInscription extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormationDAO formationDAO = new FormationDAO();
        List<Formation> formations = formationDAO.getAllFormation();
        InscriptionDAO inscriptionDAO = new InscriptionDAO();
        Map<Formation, List<Participant>> data = new HashMap<>();

        for(Formation f : formations) {
            List<Participant> participants = inscriptionDAO.getParticipantsByFormation(f.getCode_formation());
            data.put(f, participants);
        }

        request.setAttribute("data", data);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/liste_inscription.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
