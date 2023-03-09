<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des utilisateurs</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>



<!-- header -->




<div class="container text-center">
    <div class="row align-items-center">
        <div class="col-sm-3 mt-3">
            <img src="Assets/img/TrainEaseLogo.png"
                 class="position-relative mx-auto d-block img-fluid w-50 float-left">
        </div>
        <div class="col-sm-9">
            <div class="d-inline-block border-left pl-3">
                <h1 class="text-center float-left" style="color: #008ad3;">Liste des participants</h1>
            </div>
        </div>
    </div>
</div>




<!-- navbar -->



    <div class="navbar mt-3">
            <%@ include file="navbar.jsp" %>
    </div>



<!-- liste des participants -->



    <div class="container">
        <h1>Liste des participants</h1>
        <table class="table table-striped mt-3">
            <thead>
                <tr>
                    <th style="color: #008ad3;">ID</th>
                    <th style="color: #008ad3;">Nom</th>
                    <th style="color: #008ad3;">Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.nom}</td>
                        <td>${user.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>