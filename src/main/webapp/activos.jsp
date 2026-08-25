<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="pe.isil.itam.model.Activo" %>
<%@ page import="pe.isil.itam.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITAM: Activos</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="dashboard.jsp">ITAM - Activos</a>
    <div class="d-flex">
      <a href="dashboard.jsp" class="btn btn-outline-light btn-sm me-2">Dashboard</a>
      <a href="SvLogout" class="btn btn-outline-danger btn-sm">Cerrar Sesión</a>
    </div>
  </div>
</nav>

<div class="container mt-4">

    <!-- TABLA DE ACTIVOS -->
    <div class="card shadow mb-4">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Lista de Activos</h4>
        </div>
        <div class="card-body">
            <table class="table table-bordered table-hover table-striped text-center">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Tipo</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>N° Serie</th>
                        <th>Estado</th>
                        <th>Código Usuario</th>
                        <th>Acciones</th> 
                    </tr>
                </thead>
                <tbody>
                <%
                    List<Activo> listaActivos = (List<Activo>) request.getAttribute("listaActivos");
                    List<String> listaCodigos = (List<String>) request.getAttribute("listaCodigos");
                    int cont = 1;
                    for (Activo a : listaActivos) {
                        String codigoUsr = (listaCodigos != null && (cont - 1) < listaCodigos.size())
                                           ? listaCodigos.get(cont - 1)
                                           : "NO ASIGNADO";
                %>
                    <tr>
                        <td><%= a.getId_activo() %></td>
                        <td><%= a.getNombre() %></td>
                        <td><%= a.getTipo() %></td>
                        <td><%= a.getMarca() %></td>
                        <td><%= a.getModelo() %></td>
                        <td><%= a.getNumero_serie() %></td>
                        <td><%= a.getEstado() %></td>
                        <td><%= codigoUsr %></td>
                        <td>
                            <form action="SvActivos" method="GET" class="d-inline">
                                <input type="hidden" name="accion" value="vista-editar">
                                <input type="hidden" name="id" value="<%= a.getId_activo() %>">
                                <button type="submit" class="btn btn-warning btn-sm">Editar</button>
                            </form>
                        </td>
                    </tr>
                <%
                        cont++;
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- FORM CREAR ACTIVO -->
    <div class="card shadow mb-5">
        <div class="card-header bg-success text-white">
            <h4 class="mb-0">Crear Nuevo Activo</h4>
        </div>
        <div class="card-body">
            <form action="SvActivos" method="POST" class="row g-3">
                <input type="hidden" name="accion" value="crear">

                <div class="col-md-4">
                    <label class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Tipo</label>
                    <input type="text" name="tipo" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Marca</label>
                    <input type="text" name="marca" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Modelo</label>
                    <input type="text" name="modelo" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">N° Serie</label>
                    <input type="text" name="numero_serie" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Estado</label>
                    <input type="text" name="estado" class="form-control">
                </div>

                <div class="col-md-4">
                    <label class="form-label">Código Usuario</label>
                    <input type="text" name="codigo" class="form-control">
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-success">Crear Activo</button>
                </div>
            </form>
        </div>
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
