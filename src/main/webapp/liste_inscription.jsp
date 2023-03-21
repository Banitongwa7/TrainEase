<%@ page import="com.example.trainease.model.Formation" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.trainease.model.Participant" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>liste des formations</title>
  <!-- Liens vers les fichiers CSS de Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <style>
    /* CSS pour leffet 3D */
    .img-3d {
      transition: transform 0.5s;
    }

    .img-3d:hover {
      transform: rotateY(20deg);
    }
  </style>
</head>
<body>



<div class="container text-center">
  <div class="row align-items-center">
    <div class="col-sm-3 mt-3">
      <img src="assets/img/TrainEaseLogo.png" class="position-relative mx-auto d-block img-fluid w-50 float-left img-3d">
    </div>
    <div class="col-sm-9">
      <div class="d-inline-block border-left pl-3">
        <h1 class="text-center float-left" style="color: #008ad3;">liste des inscriptions</h1>
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




<hr class="my-4">

<div class="container">
  <div class="row">

    <div class="col-md-8">
      <!-- Formations du participant -->
      <h2 style="color: #008ad3;">Liste des inscriptions</h2>
      <a href="ServletAddInscription" class="btn btn-success">Ajouter un participant dans une formation</a>
      <table class="table">
        <thead>
        <tr>
          <th>Formation</th>
          <th>Les participants</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% Map<Formation, List<Participant>> data = (Map<Formation, List<Participant>>) request.getAttribute("data"); %>
        <% for( Formation f : data.keySet() ) {%>
        <tr>
          <td><%= f.getIntitule() %></td>
          <% List<Participant> parts = data.get(f); %>
          <td><%
            for(Participant p : parts) {
          %>
            <span class="badge badge-secondary"><%= p.getNom() %> <%= p.getPrenom() %></span>
            <%}%>
          </td>

          <td>
            <form action="#" method="post">
              <input type="hidden" name="id_row" value="<%= f.getCode_formation() %>">
              <button type="submit" class="btn btn-primary">Modifier</button>
            </form>

            <form action="#" method="post">
              <input type="hidden" name="id_row" value="<%= f.getCode_formation() %>">
              <button type="submit" class="btn btn-danger">Supprimer</button>
            </form>

          </td>
        </tr>
        <% } %>

        </tbody>
      </table>
    </div>
  </div>
</div>
</div>


<!-- Liens vers les fichiers JavaScript de Bootstrap -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</body>
</html>

