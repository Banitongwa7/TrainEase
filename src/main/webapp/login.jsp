<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Connexion</title>
  <!-- Inclure les fichiers Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  <!-- SweetAlert 2 -->
  <link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css" rel="stylesheet">
</head>
<body>
  <div class="container-fluid">
    <div class="row justify-content-center mt-3">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header text-center">
            <img src="assets/img/TrainEaseLogo.png" class="position-relative mx-auto d-block img-fluid w-50">
            <h1 class="text-center mt-3" style="color: #008ad3;">Bienvenue</h1>
          </div>
          <div class="card-body">
            <form action="ServletLogin" method="post">
                  <div class="form-group">
                    <label for="username">Email</label>
                    <input type="email" class="form-control" id="username" placeholder="Entrez votre adresse email" name="email">
                  </div>
                  <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input type="password" class="form-control" id="password" placeholder="Entrez votre mot de passe" name="password">
                  </div>
                  <button type="submit" class="btn btn-primary">Connexion</button>
                </form>
          </div>
        </div>
      </div>
    </div>
  </div>


<!-- SweetAlert 2 -->
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
</body>
</html>


