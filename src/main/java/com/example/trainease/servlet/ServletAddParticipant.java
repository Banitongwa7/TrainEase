package com.example.trainease.servlet;

import com.example.trainease.dao.ParticipantDAO;
import com.example.trainease.dao.ProfilDAO;
import com.example.trainease.model.Participant;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ServletAddParticipant", urlPatterns = "/ServletAddParticipant")
public class ServletAddParticipant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfilDAO daoProfil = new ProfilDAO();
        request.setAttribute("profils", daoProfil.getAllProfil());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addParticipant.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String date = request.getParameter("date");
        int profil = Integer.parseInt(request.getParameter("profil"));
        ParticipantDAO participantDAO = new ParticipantDAO();
        boolean test = false;

        try {
            Participant participant = new Participant(nom, prenom, date, profil);
            test = participantDAO.addParticipant(participant);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (test) {
            response.sendRedirect("ServletAddParticipant");
        }else {
            request.setAttribute("error", "Impossible d'ajouter le participant");
            response.sendRedirect("ServletAddParticipant");
        }
    }
}
