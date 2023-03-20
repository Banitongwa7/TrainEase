<%@ page import="java.util.List" %>
<%@ page import="com.example.trainease.model.Formation" %>
<%@ page import="com.example.trainease.model.Participant" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Ajouter une formation</title>
  <!-- Ajouter les liens vers les fichiers CSS de Bootstrap -->

  <link href='https://fonts.googleapis.com/css?family=Nunito'
        rel='stylesheet'>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

<div class="container text-center">
  <div class="row align-items-center">
    <div class="col-sm-3 mt-3">
      <img src="assets/img/TrainEaseLogo.png"
           class="position-relative mx-auto d-block img-fluid w-50 float-left">
    </div>
    <div class="col-sm-9">
      <div class="d-inline-block border-left pl-3">
        <h1 class="text-center float-left" style="color: #008ad3;">Inscription</h1>
      </div>
    </div>
  </div>
</div>




<!-- navbar -->


<div class="navbar mt-3 d-flex justify-content-center" style="text-align: center; margin: 0 auto;">
  <% if (session.getAttribute("role").equals("Administrateur")) {%>
  <%@ include file="adminNavbar.jsp" %>
  <% } else { %>
  <%@ include file="navbar.jsp" %>
  <% } %>
</div>



<!-- Formulaire d ajout de la formation -->



<div class="container">
  <h1>Ajouter un participant dans une formation</h1>
  <!-- Formulaire pour ajouter une formation -->
  <form action="ServletAddInscription" method="post">

    <div class="form-group">
      <label for="formation">Choisir la formation : </label>

      <%
        List<Formation> f = (List<Formation>) request.getAttribute("formations");
        List<Participant> p = (List<Participant>) request.getAttribute("participants");
      %>

      <% for(Formation form : f) { %>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="formation" id="formation" value="<%=form.getCode_formation()%>"> <label class="form-check-label" for="formateur"><%= form.getIntitule() %></label>
      </div>
      <% } %>

    </div>

    <div class="form-group">
      <label for="participant">Choisir le participant :</label>
      <% for(Participant part : p) { %>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="participant" id="participant" value="<%= part.getMatricule_participant() %>"> <label class="form-check-label" for="participant"> <%= part.getNom() %> <%= part.getPrenom() %> </label>
      </div>
      <% } %>
    </div>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <div class="alert alert-danger" role="alert">
      <strong>Erreur!</strong> <%= error %>
    </div>
    <% } %>

    <div class="text-center">
      <button type="submit" class="btn btn-primary">Ajouter</button>
      <a href="ServletInscription" class="btn btn-secondary">Annuler</a>
    </div>

  </form>
</div>
<!-- Ajouter les liens vers les fichiers JavaScript de Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
