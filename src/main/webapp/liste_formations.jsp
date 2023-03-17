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
				<img src="Assets/img/TrainEaseLogo.png" class="position-relative mx-auto d-block img-fluid w-50 float-left img-3d">
			</div>
			<div class="col-sm-9">
				<div class="d-inline-block border-left pl-3">
					<h1 class="text-center float-left" style="color: #008ad3;">liste des formations</span></h1>
				</div>
		    </div>
	    </div>
</div>




<!-- navbar -->



    <div class="navbar mt-3">
            <%@ include file="navbar.jsp" %>
    </div>




<hr class="my-4">

<div class="container">
  <div class="row">
    <div class="col-md-8">
      <h2 style="color: #008ad3;">Liste des Formations</h2>
      <table class="table">
        <thead>
          <tr>
            <th>Nom de la formation</th>
            <th>Date de début</th>
            <th>Date de fin</th>
            <th>Nombre d'heures</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Formation en développement web</td>
            <td>01/01/2022</td>
            <td>31/01/2022</td>
            <td>60 heures</td>
            <td>
              <button type="button" class="btn btn-primary">Edit</button>
              <button type="button" class="btn btn-danger">Supprimer</button>
            </td>
          </tr>
          <tr>
            <td>Formation en Power BI</td>
            <td>01/02/2022</td>
            <td>28/02/2022</td>
            <td>40 heures</td>
            <td>
              <button type="button" class="btn btn-primary">Edit</button>
              <button type="button" class="btn btn-danger">Supprimer</button>
            </td>
          </tr>
          <tr>
            <td>Formation en Azure Cloud</td>
            <td>01/03/2022</td>
            <td>31/03/2022</td>
            <td>30 heures</td>
            <td>
              <button type="button" class="btn btn-primary">Edit</button>
              <button type="button" class="btn btn-danger">Supprimer</button>
            </td>
          </tr>
        </tbody>
      </table>
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

