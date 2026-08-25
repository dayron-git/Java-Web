<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pe.isil.itam.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">ITAM Dashboard</a>
    <div class="d-flex">
      <a href="SvLogout" class="btn btn-outline-light btn-sm">Cerrar Sesión</a>
    </div>
  </div>
</nav>

<div class="container mt-5">

    <div class="card shadow p-4">
        <h1 class="text-center mb-3">Bienvenido al Panel de Control</h1>

        <h4 class="text-center">
            Hola, 
            <span class="text-primary fw-bold"><%=usuario.getNombre()%> <%=usuario.getApellido()%></span> 
            (<%=usuario.getArea()%>)
        </h4>

        <p class="text-center text-muted">Selecciona una opción para continuar</p>

        <div class="d-flex justify-content-center gap-3 mt-4">
            <a href="SvUsuarios" class="btn btn-primary btn-lg">Gestionar Usuarios</a>
            <a href="SvActivos" class="btn btn-success btn-lg">Gestionar Activos</a>
        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
