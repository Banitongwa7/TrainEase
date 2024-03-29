package com.example.trainease.servlet;

import com.example.trainease.dao.ParticipantDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletUsersList", urlPatterns = "/ServletUsersList")
public class ServletUsersList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ParticipantDAO participantDAO = new ParticipantDAO();
        request.setAttribute("participants", participantDAO.getAllParticipant());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UsersList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
