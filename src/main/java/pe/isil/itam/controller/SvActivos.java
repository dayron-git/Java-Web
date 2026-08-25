package pe.isil.itam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.isil.itam.dao.ActivoDAO;
import pe.isil.itam.dao.UsuarioDAO;
import pe.isil.itam.model.Activo;
import pe.isil.itam.model.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SvActivos")
public class SvActivos extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ActivoDAO activoDAO;
    private UsuarioDAO usuarioDAO;

    public SvActivos() {
        super();
        activoDAO = new ActivoDAO();
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("vista-editar".equals(accion)) {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro id");
                return;
            }

            try {
                int id = Integer.parseInt(idParam);
                Activo activo = activoDAO.getById(id);
                if (activo == null) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Activo no encontrado");
                    return;
                }
                request.setAttribute("activo", activo);
                request.getRequestDispatcher("editarActivo.jsp").forward(request, response);
                return; 
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El id debe ser numérico");
                return;
            }
        }

        List<Activo> listaActivos = activoDAO.getAll();
        List<String> listaCodigos = new ArrayList<>();

        for (Activo a : listaActivos) {
            if (a.getId_usuario() == 0) {
                listaCodigos.add("NO ASIGNADO");
            } else {
                Usuario u = usuarioDAO.getById(a.getId_usuario());
                listaCodigos.add(u != null ? u.getCodigo() : "NO ASIGNADO");
            }
        }

        request.setAttribute("listaActivos", listaActivos);
        request.setAttribute("listaCodigos", listaCodigos);
        request.getRequestDispatcher("activos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no especificada");
            return;
        }

        String nombre, tipo, marca, modelo, numero_serie, estado, codigo;
        int id_usuario;
        Usuario usuario;

        switch (accion) {
            case "crear":
                nombre = request.getParameter("nombre");
                tipo = request.getParameter("tipo");
                marca = request.getParameter("marca");
                modelo = request.getParameter("modelo");
                numero_serie = request.getParameter("numero_serie");
                estado = request.getParameter("estado");
                codigo = request.getParameter("codigo");

                if (codigo == null || codigo.isEmpty()) {
                    id_usuario = 0;
                } else {
                    usuario = usuarioDAO.getByCodigo(codigo);
                    id_usuario = (usuario != null) ? usuario.getIdUsuario() : 0;
                }

                Activo nuevo = new Activo(nombre, tipo, marca, modelo, numero_serie, estado, id_usuario);
                if (activoDAO.insert(nuevo)) {
                    System.out.println("Activo creado");
                } else {
                    System.out.println("Activo no creado");
                }
                break;

            case "editar":
                try {
                    int id_activo = Integer.parseInt(request.getParameter("id_activo"));

                    Activo actual = activoDAO.getById(id_activo);
                    if (actual == null) {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Activo no encontrado");
                        return;
                    }
                    int idUsuarioActual = actual.getId_usuario(); 

                    nombre = request.getParameter("nombre");
                    tipo = request.getParameter("tipo");
                    marca = request.getParameter("marca");
                    modelo = request.getParameter("modelo");
                    numero_serie = request.getParameter("numero_serie");
                    estado = request.getParameter("estado");

                    Activo editado = new Activo(id_activo, nombre, tipo, marca, modelo, numero_serie, estado, idUsuarioActual);

                    boolean ok = activoDAO.update(editado);
                    System.out.println(ok ? "Activo actualizado" : "No se pudo actualizar");

                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "id_activo inválido");
                    return;
                }
                break;

            case "eliminar":
                break;

            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
                return;
        }

        response.sendRedirect("SvActivos");
    }
}
