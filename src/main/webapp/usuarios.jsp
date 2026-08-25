<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="pe.isil.itam.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITAM: Usuarios</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="dashboard.jsp">ITAM - Usuarios</a>
    <div class="d-flex">
      <a href="dashboard.jsp" class="btn btn-outline-light btn-sm me-2">Dashboard</a>
      <a href="SvLogout" class="btn btn-outline-danger btn-sm">Cerrar Sesión</a>
    </div>
  </div>
</nav>

<div class="container mt-4">

    <!-- TABLA DE USUARIOS -->
    <div class="card shadow mb-4">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Lista de Usuarios</h4>
        </div>
        <div class="card-body">
            <table class="table table-bordered table-hover table-striped text-center">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Área</th>
                        <th>Contraseña</th>
                        <th>Activo</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
                    for (Usuario u : listaUsuarios) {
                %>
                    <tr>
                        <td><%=u.getIdUsuario()%></td>
                        <td><%=u.getCodigo()%></td>
                        <td><%=u.getNombre()%></td>
                        <td><%=u.getApellido()%></td>
                        <td><%=u.getArea()%></td>
                        <td><%=u.getContrasena()%></td>
                        <td><%=u.isActivo() ? "Sí" : "No"%></td>
                        <td class="d-flex justify-content-center gap-2">

                            <form action="SvUsuarios" method="POST" class="d-inline">
                                <input type="hidden" name="accion" value="vista-editar">
                                <input type="hidden" name="codigo" value="<%=u.getCodigo()%>">
                                <button type="submit" class="btn btn-warning btn-sm">Editar</button>
                            </form>

                            <form action="SvUsuarios" method="POST" class="d-inline">
                                <input type="hidden" name="accion" value="eliminar">
                                <input type="hidden" name="codigo" value="<%=u.getCodigo()%>">
                                <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                            </form>

                        </td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- FORM CREAR USUARIO -->
    <div class="card shadow mb-5">
        <div class="card-header bg-success text-white">
            <h4 class="mb-0">Crear Nuevo Usuario</h4>
        </div>
        <div class="card-body">
            <form action="SvUsuarios" method="POST" class="row g-3">
                <input type="hidden" name="accion" value="crear">

                <div class="col-md-4">
                    <label class="form-label">Código</label>
                    <input type="text" name="codigo" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Apellido</label>
                    <input type="text" name="apellido" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Área</label>
                    <input type="text" name="area" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Contraseña</label>
                    <input type="text" name="contrasena" class="form-control">
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-success">Crear Usuario</button>
                </div>
            </form>
        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
