package pe.isil.itam.model;

public class Usuario {
	private int idUsuario;
	private String codigo;
	private String nombre;
	private String apellido;
	private String area;
	private String contrasena;
	private boolean activo;
	
	public Usuario () {
	}
	
	public Usuario (String codigo, String nombre, String apellido, String area , String contrasena) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.area = area;
		this.contrasena = contrasena;
	}
	
	public Usuario (int idUsuario, String codigo, String nombre, String apellido, String area , String contrasena, boolean activo) {
		this.idUsuario = idUsuario;
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.area = area;
		this.contrasena = contrasena;
		this.activo = activo;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
