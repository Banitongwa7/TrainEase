<%@ page import="com.example.trainease.model.Participant" %>
<%@ page import="java.util.List" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des utilisateurs</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>



<!-- header -->




<div class="container text-center">
    <div class="row align-items-center">
        <div class="col-sm-3 mt-3">
            <img src="assets/img/TrainEaseLogo.png"
                 class="position-relative mx-auto d-block img-fluid w-50 float-left">
        </div>
        <div class="col-sm-9">
            <div class="d-inline-block border-left pl-3">
                <h1 class="text-center float-left" style="color: #008ad3;">Liste des participants</h1>
            </div>
        </div>
    </div>
</div>




<!-- navbar -->



    <div class="navbar mt-3">
        <% if (session.getAttribute("role").equals("Administrateur")) {%>
            <%@ include file="adminNavbar.jsp" %>
        <% } else { %>
            <%@ include file="navbar.jsp" %>
        <% } %>
    </div>



<!-- liste des utilisateurs -->



    <div class="container">
        <h1>Liste des participants</h1>
        <a href="ServletAddParticipant" class="btn btn-success">Ajouter un participant</a>
        <table class="table table-striped mt-3">
            <thead>
                <tr>
                    <th style="color: #008ad3;">Nom</th>
                    <th style="color: #008ad3;">Prénom</th>
                    <th style="color: #008ad3;">Date de naissance</th>
                    <th style="color: #008ad3;">Action</th>
                </tr>
            </thead>
            <tbody>
            <% List<Participant> participant = (List<Participant>) request.getAttribute("participants"); %>
            <% for( Participant p : participant ) { %>
                    <tr>
                        <td><%= p.getNom() %></td>
                        <td><%= p.getPrenom() %></td>
                        <td><%= p.getDate_naissance() %></td>
                        <td>
                            <form action="#" method="post">
                                <input type="hidden" name="id_row" value="<%= p.getMatricule_participant() %>">
                                <button type="submit" class="btn btn-primary">Modifier</button>
                            </form>
                            <form action="ServletDeleteParticipant" method="post">
                                <input type="hidden" name="id_row" value="<%= p.getMatricule_participant() %>">
                                <button type="submit" class="btn btn-danger">Supprimer</button>
                            </form>
                        </td>
                    </tr>
<% } %>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>