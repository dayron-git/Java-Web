package pe.isil.itam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.isil.itam.model.Usuario;
import pe.isil.itam.util.ConnectionFactory;

public class UsuarioDAO {
	public boolean insert(Usuario usuario) {
		String sql = "INSERT INTO Usuario (codigo, nombre, apellido, area, contrasena, activo) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionFactory.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getCodigo());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getArea());
            ps.setString(5, usuario.getContrasena());
            ps.setBoolean(6, true);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
    		//System.out.println("Conexión exitosa");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setCodigo(rs.getString("codigo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setArea(rs.getString("area"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setActivo(rs.getBoolean("activo"));
                
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
	
	public Usuario getByCodigo(String codigo) {
        String sql = "SELECT * FROM Usuario WHERE codigo = ?";
        Usuario usuario = null;

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setCodigo(rs.getString("codigo"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setArea(rs.getString("area"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setActivo(rs.getBoolean("activo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
	
	public Usuario getById(int id_usuario) {
        String sql = "SELECT * FROM Usuario WHERE id_usuario = ?";
        Usuario usuario = null;

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id_usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setCodigo(rs.getString("codigo"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setArea(rs.getString("area"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setActivo(rs.getBoolean("activo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
	
	public boolean update(Usuario usuario) {
		String sql = "UPDATE Usuario SET nombre = ?, apellido = ?, area = ?, contrasena = ? WHERE codigo = ?";
		
		try (Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getArea());
			ps.setString(4, usuario.getContrasena());
			ps.setString(5, usuario.getCodigo());
			
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(String codigo) {
		String sql = "UPDATE Usuario SET activo = 0 WHERE codigo = ?";
		
		try (Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			
			//ps.setString(1, usuario.getCodigo());
			ps.setString(1, codigo);
			
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
