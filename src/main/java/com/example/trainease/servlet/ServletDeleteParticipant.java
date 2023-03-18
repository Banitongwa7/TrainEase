package com.example.trainease.servlet;

import com.example.trainease.dao.ParticipantDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletDeleteParticipant", value = "/ServletDeleteParticipant")
public class ServletDeleteParticipant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_row"));

        ParticipantDAO participantDAO = new ParticipantDAO();
        boolean test = participantDAO.deleteParticipant(id);

        if (test) {
            response.sendRedirect("ServletUsersList");
        } else {
            request.setAttribute("error", "Impossible de supprimer le participant");
            response.sendRedirect("ServletUsersList");
        }
    }
}
