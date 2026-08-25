package pe.isil.itam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.isil.itam.dao.UsuarioDAO;
import pe.isil.itam.model.Usuario;

import java.io.IOException;

/**
 * Servlet implementation class SvLogin
 */
@WebServlet("/SvLogin")
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioDAO usuarioDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvLogin() {
        super();
        this.usuarioDAO = new UsuarioDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(); 
		
		String codigo = request.getParameter("codigo");
		String contrasena = request.getParameter("contrasena");
		String mensaje = "";
		Boolean esValido = false;
		
		Usuario usuario = usuarioDAO.getByCodigo(codigo);
		
		if (codigo == null || codigo.isEmpty() || contrasena == null || contrasena.isEmpty() || usuario == null) {
			mensaje = "Debe ingresar valores correctos para usuario y/o contraseña.";
		}
		else {
			if (usuario.getContrasena().equals(contrasena)) {
				
				esValido = true;
			}
			
			if (!esValido) {
				mensaje = "Usuario y/o contraseña incorrectos.";
			}
		}
		
		if(esValido) {
			sesion.setAttribute("usuario", usuario);
			response.sendRedirect("dashboard.jsp");
		}
		else {
			request.setAttribute("mensajeError", mensaje);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

}
