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
                <h1 class="text-center float-left" style="color: #008ad3;">Ajouter des utilisateurs</h1>
            </div>
        </div>
    </div>
</div>
	
	
	<!-- navbar -->


	    <div class="navbar mt-3 d-flex justify-content-center" style="text-align: center; margin: 0 auto;">
            <%@ include file="adminNavbar.jsp" %>
        </div>



    <!-- Ajout des utilisateurs -->

	
	<div class="container mt-5">
        
        <form action="ServletAddUser" method="post">
            <div class="form-group">
                <label for="username">Email</label>
                <input type="text" class="form-control" id="username" name="email">
            </div>

            <div class="form-group">
                <label for="password">Mot de passe</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>

			<div class="form-group">
				<label for="role">Role :</label>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="role" id="admin"
						value="Administrateur"> <label class="form-check-label"
						for="admin"> Administrateur </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="role" id="user"
						value="Simple Utilisateur"> <label class="form-check-label"
						for="user"> Simple Utilisateur </label>
				</div>
			</div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a href="ServletUtilisateurs" class="btn btn-secondary">Annuler</a>
            </div>

        </form>
    </div>
    <!-- Inclure les fichiers JavaScript de Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>




