<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un utilisateur</title>
<!-- Inclure les fichiers CSS de Bootstrap -->
<link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
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
                <h1 class="text-center float-left" style="color: #008ad3;">Formateur</h1>
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


<div class="container">


		<!-- Section d'affichage des informations du formateur -->
		<div class="card mt-4">
			<div class="card-header">
				Informations sur le formateur
			</div>
			<div class="card-body">
				<p>Nom : foulen ben falten</p>
				<p>Adresse e-mail : example@example.com</p>
				<p>Téléphone : 1234567890</p>
				<p>Expérience : 5 ans</p>
			</div>
		</div>

		<!-- Section d'affichage de la liste des formations -->
		<div class="card mt-4">
			<div class="card-header">
				Liste des formations à venir
			</div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nom de la formation</th>
							<th>Date de début</th>
							<th>Date de fin</th>
							<th>Nombre d'heures</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Formation sur Java</td>
							<td>01/05/2023</td>
							<td>30/05/2023</td>
							<td>50 heures</td>
						</tr>
						<tr>
							<td>Formation sur le développement web</td>
							<td>01/06/2023</td>
							<td>30/06/2023</td>
							<td>60 heures</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>


	</div>

	<!-- Lien vers le script Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>