package Base2;

import Principal1.Cliente;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDatos {

    // Insertar un nuevo cliente
    public boolean insertar(Cliente cte) {
        String sql = "INSERT INTO clientes (nombre, cedula, correo) VALUES (?, ?, ?)";
        try (Connection c = Conexion.getConexion();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setString(1, cte.getNombre());
            p.setString(2, String.valueOf(cte.getID()));
            p.setString(3, cte.getCorreo());

            return p.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Insertar cliente: " + e.getMessage());
            return false;
        }
    }

    // Eliminar cliente por cédula
    public boolean eliminar(String cedula) {
        String sql = "DELETE FROM clientes WHERE cedula = ?";
        try (Connection c = Conexion.getConexion();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setString(1, cedula);
            return p.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Eliminar cliente: " + e.getMessage());
            return false;
        }
    }

    // Listar todos los clientes
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection c = Conexion.getConexion();
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet rs = p.executeQuery()) {

            while (rs.next()) {
                Cliente cte = new Cliente();
                cte.setNombre(rs.getString("nombre"));
                cte.setID(Integer.parseInt(rs.getString("cedula")));
                cte.setCorreo(rs.getString("correo"));
                lista.add(cte);
            }

        } catch (Exception e) {
            System.err.println("Listar clientes: " + e.getMessage());
        }
        return lista;
    }
}
