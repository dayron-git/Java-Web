package pe.isil.itam.model;

public class Activo {
	private int id_activo;
	private String nombre;
	private String tipo;
	private String marca;
	private String modelo;
	private String numero_serie;
	private String estado;
	private int id_usuario; //puede ser nulo
	
	public Activo() {
		
	}
	
	public Activo(int id_activo, String nombre, String tipo, String marca, String modelo, String numero_serie, String estado,
			int id_usuario) {
		this.id_activo = id_activo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numero_serie = numero_serie;
		this.estado = estado;
		this.id_usuario = id_usuario;
	}
	
	public Activo(int id_activo, String nombre, String tipo, String marca, String modelo, String numero_serie, String estado) {
		this.id_activo = id_activo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numero_serie = numero_serie;
		this.estado = estado;
		
	}
	
	public Activo(String nombre, String tipo, String marca, String modelo, String numero_serie, String estado, int id_usuario) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numero_serie = numero_serie;
		this.estado = estado;
		this.id_usuario = id_usuario;
	}
	
	public int getId_activo() {
		return id_activo;
	}
	public void setId_activo(int id_activo) {
		this.id_activo = id_activo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumero_serie() {
		return numero_serie;
	}
	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
}
