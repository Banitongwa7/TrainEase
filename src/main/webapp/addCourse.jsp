<%@ page import="com.example.trainease.model.Formateur" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.trainease.model.Domaine" %>
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
                <h1 class="text-center float-left" style="color: #008ad3;">Ajouter des formations</h1>
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
		<h1>Ajouter une formation</h1>
		<!-- Formulaire pour ajouter une formation -->
		<form action="ServletAddCourse" method="post">
			<div class="form-group">
				<label for="intitule">Intitulé :</label>
				<input type="text" class="form-control" id="intitule" name="intitule" required>
			</div>
			<div class="form-group">
				<label for="daynumber">Nombre de jours :</label>
				<input type="number" class="form-control" id="daynumber" name="daynumber" required>
			</div>
			<div class="form-group">
				<label for="numberparticipant">Nombre de participant : </label>
				<input type="number" class="form-control" id="numberparticipant" name="numberparticipant" required>
			</div>
			<div class="form-group">
				<label for="year">L'année :</label>
				<input type="number" class="form-control" id="year" name="year" required>
			</div>
			<div class="form-group">
				<label for="month">Le mois :</label>
				<input type="number" class="form-control" id="month" name="month" required>
			</div>

			<div class="form-group">
				<label for="formateur">Formateur : </label>

				<%
					List<Formateur> f = (List<Formateur>) request.getAttribute("formateurs");
					List<Domaine> d = (List<Domaine>) request.getAttribute("domaine");
				%>

				<% for(Formateur form : f) { %>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="formateur" id="formateur" value="<%=form.getCode_formateur()%>"> <label class="form-check-label" for="formateur"><%= form.getNom() %></label>
				</div>
				<% } %>

			</div>

			<div class="form-group">
				<label for="domaine">Domaine :</label>
				<% for(Domaine dom : d) { %>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="domaine" id="domaine" value="<%= dom.getCode_domaine() %>"> <label class="form-check-label" for="domaine"> <%= dom.getLibelle() %> </label>
				</div>
				<% } %>
			</div>

			<div class="text-center">
				<button type="submit" class="btn btn-primary">Ajouter</button>
				<a href="ServletFormation" class="btn btn-secondary">Annuler</a>
			</div>

		</form>
	</div>
	<!-- Ajouter les liens vers les fichiers JavaScript de Bootstrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
