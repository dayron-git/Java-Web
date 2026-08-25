<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Sistema ITAM</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons (opcional) -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        body {
            background: linear-gradient(135deg, #1e3c72, #2a5298);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: "Segoe UI", sans-serif;
        }
        .login-card {
            width: 380px;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            padding: 25px;
            background: #fff;
        }
        .logo {
            font-size: 45px;
            color: #2a5298;
        }
    </style>
</head>
<body>

<div class="login-card">
    <div class="text-center mb-3">
        <i class="bi bi-shield-lock-fill logo"></i>
        <h4 class="mt-2">Sistema ITAM</h4>
        <p class="text-muted">Inicie sesión para continuar</p>
    </div>

    <!-- Mostrar mensaje de error si lo hay -->
    <%
        String error = (String) request.getAttribute("mensajeError");
        if (error != null) {
    %>
    <div class="alert alert-danger text-center py-2"><%= error %></div>
    <% } %>

    <form action="SvLogin" method="POST">
        <div class="mb-3">
            <label class="form-label">Código de usuario</label>
            <input type="text" name="codigo" class="form-control" placeholder="00000000" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Contraseña</label>
            <input type="password" name="contrasena" class="form-control" placeholder="Ingrese su contraseña" required>
        </div>

        <button type="submit" class="btn btn-primary w-100">
            <i class="bi bi-box-arrow-in-right"></i> Ingresar
        </button>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
