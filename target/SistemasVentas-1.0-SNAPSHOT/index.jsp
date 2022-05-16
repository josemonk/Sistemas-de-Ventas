<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>
<div class="container center-block" >
    <div class="row justify-content-center">
        <div class="card" style="width: 18rem;">
            <img src="login.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <form method="POST" action="Validar">
                    <div class="form-group">
                        <label>No de Documento</label>
                        <input type="text" class="form-control" name="txtusuario">
                        <small id="emailHelp" class="form-text text-muted">Ingrese su documento sin espacios ni puntos</small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Contraseña</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="txtpassword">
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Permanecer loggeado</label>
                    </div>
                    <button type="submit" class="btn btn-primary" name="accion" value="Ingresar">Ingresar</button>
                </form>
            </div>
        </div>
    </div>
</div>

