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
        System.out.println("Methode doGet !!!!!!!!!!!!");

        try {
            Connection connection = DatabaseConnect.getConnection();
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        UtilisateurDAO dao = new UtilisateurDAO();
        Utilisateur user = dao.getUserForLogin(username, password);
        System.out.println("************************************");
        System.out.println(user);
        System.out.println("************************************");
       // check username and password
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
    }
}
