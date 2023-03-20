<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mon Site Web</title>
	<!-- CSS de Bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light ">

	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="ServletHomeSimpleUser" style="font-size: 15px;">Accueil <span class="sr-only">(current)</span></a>
	      </li>
			<li class="nav-item">
				<a class="nav-link" href="ServletInscription" style="font-size: 15px;">Inscriptions</a>
			</li>
	      <li class="nav-item">
	        <a class="nav-link" href="ServletUsersList" style="font-size: 15px;">Participants</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="ServletFormation" style="font-size: 15px;">Formations</a>
	      </li>
			<li class="nav-item">
				<a class="nav-link" href="ServletFormateur" style="font-size: 15px;">Formateurs</a>
			</li>
	      <li class="nav-item">
	        <a class="nav-link" href="ServletProfil" style="font-size: 15px;">Mon Profil</a>
	      </li>
	    </ul>
	  </div>
	</nav>

	<!-- JS de Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi+TuS" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNSL0ul" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
