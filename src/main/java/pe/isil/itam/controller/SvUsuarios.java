package pe.isil.itam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import pe.isil.itam.dao.UsuarioDAO;
import pe.isil.itam.model.Usuario;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class SvUsuarios
 */
@WebServlet("/SvUsuarios")
public class SvUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvUsuarios() {
        super();
        this.usuarioDAO = new UsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> listaUsuarios = usuarioDAO.getAll();
		
		request.setAttribute("listaUsuarios", listaUsuarios);
		
		request.getRequestDispatcher("usuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		String codigo;
		String nombre;
		String apellido;
		String area;
		String contrasena;

		
		
		if (accion != null) {
			switch (accion) {
			case "crear":
				//DAO para INSERT
				codigo = request.getParameter("codigo");
				nombre = request.getParameter("nombre");
				apellido = request.getParameter("apellido");
				area = request.getParameter("area");
				contrasena = request.getParameter("contrasena");
				
				Usuario usuario = new Usuario(codigo,nombre,apellido,area,contrasena);
				
				if (usuarioDAO.insert(usuario)) {
					System.out.println("Usuario creado");
				}
				else {
					System.out.println("Usuario no creado");
				}
				
				response.sendRedirect("SvUsuarios");
				
				break;
			case "vista-editar":
				//Redirección a la vista editarUsuario.jsp
				break;
			case "editar":
				//DAO para UPDATE
				break;
			case "eliminar":
				//DAO para DELETE
				codigo = request.getParameter("codigo");
				usuarioDAO.delete(codigo);
				
				response.sendRedirect("SvUsuarios");
				break;
			default:
				// Si la acción no es reconocida, maneja el error
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
                break;
			}
		}
		
		
	}

}
