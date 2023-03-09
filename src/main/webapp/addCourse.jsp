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
            <img src="Assets/img/TrainEaseLogo.png"
                 class="position-relative mx-auto d-block img-fluid w-50 float-left">
        </div>
        <div class="col-sm-9">
            <div class="d-inline-block border-left pl-3">
                <h1 class="text-center float-left" style="color: #008ad3;">Ajouter des formations</h1>
            </div>
        </div>
    </div>
</div>




	<!-- navbar -->


	    <div class="navbar mt-3 d-flex justify-content-center" style="text-align: center; margin: 0 auto;">
                    <%@ include file="navbar.jsp" %>
                </div>



    <!-- Formulaire d ajout de la formation -->



	<div class="container">
		<h1>Ajouter une formation</h1>
		<!-- Formulaire pour ajouter une formation -->
		<form action="ajouterFormationServlet" method="post">
			<div class="form-group">
				<label for="nomFormation">Nom de la formation:</label>
				<input type="text" class="form-control" id="nomFormation" name="nomFormation" required>
			</div>
			<div class="form-group">
				<label for="dateDebut">Date de début:</label>
				<input type="date" class="form-control" id="dateDebut" name="dateDebut" required>
			</div>
			<div class="form-group">
				<label for="dateFin">Date de fin:</label>
				<input type="date" class="form-control" id="dateFin" name="dateFin" required>
			</div>
			<div class="form-group">
				<label for="lieu">Lieu:</label>
				<input type="text" class="form-control" id="lieu" name="lieu" required>
			</div>
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
	</div>
	<!-- Ajouter les liens vers les fichiers JavaScript de Bootstrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
