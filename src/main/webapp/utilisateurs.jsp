<!DOCTYPE html>
<html>
<head>
  <title>Partcipants</title>
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
                <h1 class="text-center float-left" style="color: #008ad3;">Liste des partcipants</h1>
            </div>
        </div>
    </div>
</div>




<!-- navbar -->



    <div class="navbar mt-3 d-flex align-items-center justify-content-center">
            <%@ include file="adminNavbar.jsp" %>
    </div>




	<div class="container">




		<!-- Section daffichage de la liste des participants -->
		<div class="card mt-4">
			<div class="card-header" style="color: #008ad3;">
				<strong>Liste des participants </strong>
			</div>
			<div class="card-body">
				<table class="table table-striped">
                  <thead>
                    <tr>
                      <th style="color: #008ad3;">Nom</th>
                      <th style="color: #008ad3;">Adresse e-mail</th>
                      <th style="color: #008ad3;">Telephone</th>
                      <th style="color: #008ad3;">Actions</th> <!-- Ajout de la colonne pour les actions -->
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>David Banitongwa</td>
                      <td>example@example.com</td>
                      <td>1234567890</td>
                      <td> <!-- Ajout des boutons d'édition et de suppression -->
                        <a href="#" class="btn btn-primary">Editer</a>
                        <a href="#" class="btn btn-danger">Supprimer</a>
                      </td>
                    </tr>
                    <tr>
                      <td>Moutii Marzouki</td>
                      <td>example@example.com</td>
                      <td>0987654321</td>
                      <td>
                        <a href="#" class="btn btn-primary">Editer</a>
                        <a href="#" class="btn btn-danger">Supprimer</a>
                      </td>
                    </tr>
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
