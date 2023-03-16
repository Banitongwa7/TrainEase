package com.example.trainease.servlet;

import com.example.trainease.dao.FormateurDAO;
import com.example.trainease.dao.FormationDAO;
import com.example.trainease.dao.ParticipantDAO;
import com.example.trainease.dao.UtilisateurDAO;
import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Utilisateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletLogin", urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        UtilisateurDAO dao = new UtilisateurDAO();
        Utilisateur user = dao.getUserForLogin(email, password);
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

       // check username and password
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            // statistique
            request.setAttribute("data", dictionnaire);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
            dispatcher.forward(request, response);
            // redirect
            response.sendRedirect("Home.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
    }
}
