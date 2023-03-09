package com.example.trainease.servlet;

import com.example.trainease.dao.UtilisateurDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        UtilisateurDAO dao = new UtilisateurDAO();
       // check username and password
        if(dao.getUserForLogin(username, password) != null){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
