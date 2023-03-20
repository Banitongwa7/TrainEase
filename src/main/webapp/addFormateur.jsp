<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Ajouter formateur</title>
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
        <h1 class="text-center float-left" style="color: #008ad3;">Ajouter des formateurs</h1>
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



<div class="container-fluid">
  <div class="row justify-content-center mt-3">
    <div class="col-md-6">
      <div class="card">

        <div class="card-body">
          <form action="ServletAddFormateur" method="post">

            <div class="form-group">
              <label for="nom">Nom :</label>
              <input type="text" class="form-control" id="nom" name="nom" placeholder="Entrez le nom du formateur">
            </div>

            <div class="form-group">
              <label for="prenom">Prenom :</label>
              <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Entrez le prénom du formateur">
            </div>

            <div class="form-group">
              <label for="email">Email : </label>
              <input type="email" class="form-control" id="email" name="email" placeholder="Entrez l'email du formateur">
            </div>

            <div class="form-group">
              <label for="phone">Téléphone : </label>
              <input type="number" class="form-control" id="phone" name="phone" placeholder="Entrez le numero de téléphone du formateur">
            </div>

            <% String error = (String) request.getAttribute("error"); %>
            <% if (error != null) { %>
            <div class="alert alert-danger" role="alert">
              <strong>Erreur!</strong> <%= error %>
            </div>
            <% } %>

            <div class="text-center">
              <button type="submit" class="btn btn-primary">Ajouter</button>
              <a href="ServletFormateur" class="btn btn-secondary">Annuler</a>
            </div>

          </form>
        </div>
      </div>
    </div>
  </div>
</div>


<!-- Ajouter les liens vers les fichiers JavaScript de Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
