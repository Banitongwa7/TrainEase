package com.example.trainease.servlet;

import com.example.trainease.dao.FormateurDAO;
import com.example.trainease.dao.FormationDAO;
import com.example.trainease.dao.ParticipantDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletStatistique", urlPatterns = "/ServletStatistique")
public class ServletStatistique extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
