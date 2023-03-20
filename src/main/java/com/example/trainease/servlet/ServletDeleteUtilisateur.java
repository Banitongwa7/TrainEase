package com.example.trainease.servlet;

import com.example.trainease.dao.ParticipantDAO;
import com.example.trainease.dao.UtilisateurDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDeleteUtilisateur", value = "/ServletDeleteUtilisateur")
public class ServletDeleteUtilisateur extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_row"));

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        boolean test = utilisateurDAO.deleteUser(id);

        if (test) {
            response.sendRedirect("ServletUtilisateurs");
        } else {
            request.setAttribute("error", "Impossible de supprimer le participant");
            response.sendRedirect("ServletUtilisateurs");
        }
    }
}
