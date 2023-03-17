<!DOCTYPE html>
<html>
<head>
  <title>Participant</title>
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
            <img src="Assets/img/TrainEaseLogo.png"
                 class="position-relative mx-auto d-block img-fluid w-50 float-left">
        </div>
        <div class="col-sm-9">
            <div class="d-inline-block border-left pl-3">
                <h1 class="text-center float-left" style="color: #008ad3;">Ajouter des participants</h1>
            </div>
        </div>
    </div>
</div>




	<!-- navbar -->


	    <div class="navbar mt-3 d-flex justify-content-center" style="text-align: center; margin: 0 auto;">
                    <%@ include file="navbar.jsp" %>
                </div>



    <!-- Formulaire d ajout de la formation -->



	<div class="container-fluid">
      <div class="row justify-content-center mt-3">
        <div class="col-md-6">
          <div class="card">

            <div class="card-body">
              <form action="addParticipant.jsp" method="post">
                <div class="form-group">
                  <label for="nom">Nom :</label>
                  <input type="text" class="form-control" id="nom" name="nom" placeholder="Entrez le nom du participant">
                </div>
                <div class="form-group">
                  <label for="prenom">Prenom :</label>
                  <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Entrez le prénom du participant">
                </div>
                <div class="form-group">
                  <label for="email">Email :</label>
                  <input type="email" class="form-control" id="email" name="email" placeholder="Entrez l'email du participant">
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Ajouter</button>
                  <a href="listeParticipants.jsp" class="btn btn-secondary">Annuler</a>
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
