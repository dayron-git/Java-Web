package pe.isil.itam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.isil.itam.model.Activo;
import pe.isil.itam.util.ConnectionFactory;

public class ActivoDAO {

    public boolean insert(Activo activo) {
        String sql = "INSERT INTO Activo (nombre, tipo, marca, modelo, numero_serie, estado, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, activo.getNombre());
            ps.setString(2, activo.getTipo());
            ps.setString(3, activo.getMarca());
            ps.setString(4, activo.getModelo());
            ps.setString(5, activo.getNumero_serie());
            ps.setString(6, activo.getEstado());

            if (activo.getId_usuario() == 0) {
                ps.setNull(7, java.sql.Types.INTEGER);
            } else {
                ps.setInt(7, activo.getId_usuario());
            }

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Activo> getAll() {
        List<Activo> activos = new ArrayList<>();
        String sql = "SELECT * FROM Activo";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Activo activo = new Activo();
                activo.setId_activo(rs.getInt("id_activo"));
                activo.setNombre(rs.getString("nombre"));
                activo.setTipo(rs.getString("tipo"));
                activo.setMarca(rs.getString("marca"));
                activo.setModelo(rs.getString("modelo"));
                activo.setNumero_serie(rs.getString("numero_serie"));
                activo.setEstado(rs.getString("estado"));

                Object idUsuarioObj = rs.getObject("id_usuario");
                int idUsuario = (idUsuarioObj == null) ? 0 : rs.getInt("id_usuario");
                activo.setId_usuario(idUsuario);

                activos.add(activo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activos;
    }

    public Activo getById(int id) {
        String sql = "SELECT * FROM Activo WHERE id_activo = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Activo activo = new Activo();
                    activo.setId_activo(rs.getInt("id_activo"));
                    activo.setNombre(rs.getString("nombre"));
                    activo.setTipo(rs.getString("tipo"));
                    activo.setMarca(rs.getString("marca"));
                    activo.setModelo(rs.getString("modelo"));
                    activo.setNumero_serie(rs.getString("numero_serie"));
                    activo.setEstado(rs.getString("estado"));

                    Object idUsuarioObj = rs.getObject("id_usuario");
                    int idUsuario = (idUsuarioObj == null) ? 0 : rs.getInt("id_usuario");
                    activo.setId_usuario(idUsuario);

                    return activo;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public boolean update(Activo a) {
        String sql = "UPDATE Activo SET nombre=?, tipo=?, marca=?, modelo=?, numero_serie=?, estado=?, id_usuario=? WHERE id_activo=?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, a.getNombre());
            ps.setString(2, a.getTipo());
            ps.setString(3, a.getMarca());
            ps.setString(4, a.getModelo());
            ps.setString(5, a.getNumero_serie());
            ps.setString(6, a.getEstado());

            if (a.getId_usuario() == 0) {
                ps.setNull(7, java.sql.Types.INTEGER);
            } else {
                ps.setInt(7, a.getId_usuario());
            }

            ps.setInt(8, a.getId_activo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
