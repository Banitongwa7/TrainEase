<%@ page import="com.example.trainease.model.Formateur" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.trainease.model.Utilisateur" %>
<%@ page import="com.example.trainease.dao.RoleDAO" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Utilisateurs</title>
  <!-- Inclure les fichiers Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
        <h1 class="text-center float-left" style="color: #008ad3;">Liste des utilisateurs</h1>
      </div>
    </div>
  </div>
</div>

<!-- navbar -->
<div class="navbar mt-3 d-flex align-items-center justify-content-center">
    <%@ include file="adminNavbar.jsp" %>
</div>

<div class="container">
  <!-- Section d'affichage de la liste des participants -->
  <div class="card mt-4">
    <div class="card-header" style="color: #008ad3;">
      <strong>Liste des formateurs</strong>
      <a href="ServletAddUser" class="btn btn-success">Ajouter un utilisateur</a>
    </div>
    <div class="card-body">
      <table class="table table-striped">
        <thead>
        <tr>
          <th style="color: #008ad3;">E-mail</th>
          <th style="color: #008ad3;">Rôle</th>
          <th style="color: #008ad3;">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%

          List<Utilisateur> utili = (List<Utilisateur>) request.getAttribute("utilisateurs");
          RoleDAO roledao = new RoleDAO();

        %>
        <% for(Utilisateur user : utili) { %>
        <tr>
          <td><%= user.getEmail() %></td>
          <td><%= roledao.getRoleOfLibelle(user.getCode_role()) %></td>
          <td>
            <form action="#" method="post">
              <input type="hidden" name="id_row" value="">
              <button type="submit" class="btn btn-primary">Modifier</button>
            </form>

            <form action="ServletDeleteUtilisateur" method="post">
              <input type="hidden" name="id_row" value="">
              <button class="btn btn-sm btn-danger delete-button">Supprimer</button>
            </form>
          </td>
        </tr>
        <% } %>
        </tbody>
      </table>
    </div>
  </div>
</div>

<!-- Lien vers le script Bootstrap -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
