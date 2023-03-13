package com.example.trainease.servlet;

import com.example.trainease.dao.RoleDAO;
import com.example.trainease.dao.UtilisateurDAO;
import com.example.trainease.model.Role;
import com.example.trainease.model.Utilisateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAddUser", urlPatterns = "/ServletAddUser")
public class ServletAddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        String libelle = (String) request.getParameter("role");
        UtilisateurDAO daoUser = new UtilisateurDAO();
        RoleDAO daoRole = new RoleDAO();
        Utilisateur user = new Utilisateur();
        Role r = daoRole.getRoleWithLibelle(libelle);

        // user
        user.setEmail(email);
        user.setPassword(password);
        user.setCode_role(r.getCode_role());

        // add user
        boolean checkAdd = daoUser.addUser(user);

        if (checkAdd) {
            response.sendRedirect("login.jsp");
        }else {
            response.sendRedirect("addUser.jsp");
        }

    }
}
