<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Page d'accueil</title>
    <!-- Lien vers la feuille de style Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        /* CSS pour centrer la page */
        html, body {
            height: 100%;
        }



        h1 {
            margin-bottom: 1rem;
        }

        .card {
            margin: 1rem;
            max-width: 400px;
            background-color: #f8f9fa;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .card-header {
            background-color: #007bff;
            color: #fff;
        }

        .card-body {
            padding: 1rem;
        }
    </style>
</head>
<body>


<!-- header -->



<div class="container text-center">
    <div class="row align-items-center">

        <div class="col-sm-3 mt-3">
            <img src="assets/img/TrainEaseLogo.png"
                 class="position-relative mx-auto d-block img-fluid w-50 float-left">
        </div>

    </div>
</div>


<!-- navbar -->


<div class="navbar mt-3 d-flex justify-content-center" style="text-align: center; margin: 0 auto;">
    <%@ include file="navbar.jsp" %>
</div>



<!-- cards -->


<div class="container text-center">

    <h3 style="color: #008ad3;"> Bienvenue <%=session.getAttribute("email") %> !</h3>

        <%
			Map<String, Integer> data = (Map<String, Integer>) request.getAttribute("data");
		%>

    <div class="row">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-header" style="color: #008ad3;">Formateurs</div>
                <div class="card-body">
                    <p>Nombre de formateurs : <%= data.get("nbFormateur") %></p>
                    <a href="ServletFormateur" class="btn btn-primary">Liste des formateurs</a>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="card">
                <div class="card-header" style="color: #008ad3;">Participants</div>
                <div class="card-body">
                    <p>Nombre de participants : <%= data.get("nbParticipant") %></p>
                    <a href="ServletUsersList" class="btn btn-primary">Liste des participants</a>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="card">
                <div class="card-header" style="color: #008ad3;">Formations</div>
                <div class="card-body">
                    <p>Nombre de formations : <%= data.get("nbFormation") %></p>
                    <a href="ServletFormation" class="btn btn-primary">Liste des formations</a>
                </div>
            </div>
        </div>
    </div>


    <a href="ServletLogin" class="btn btn-danger">Déconnexion</a>
</body>
</html>
