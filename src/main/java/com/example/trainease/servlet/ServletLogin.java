package com.example.trainease.servlet;

import com.example.trainease.dao.UtilisateurDAO;
import com.example.trainease.database.DatabaseConnect;
import com.example.trainease.model.Utilisateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        UtilisateurDAO dao = new UtilisateurDAO();
        Utilisateur user = dao.getUserForLogin(email, password);
       // check username and password
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("username", email);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
    }
}
