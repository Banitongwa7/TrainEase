package com.example.trainease.servlet;

import com.example.trainease.dao.FormationDAO;
import com.example.trainease.dao.InscriptionDAO;
import com.example.trainease.model.Formation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletFormation", urlPatterns = "/ServletFormation")
public class ServletFormation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormationDAO formationDAO = new FormationDAO();
        InscriptionDAO inscriptionDAO = new InscriptionDAO();
        List<Formation> formations = formationDAO.getAllFormation();

        for(Formation f : formations) {
            f.setNombre_participants(inscriptionDAO.getNumberOfParticipantsByFormation(f.getCode_formation()));
            formationDAO.updateFormation(f);
        }

        request.setAttribute("formations", formations);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/liste_formations.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
