package Base2;

import Principal1.Reserva;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDatos {

    // Insertar una nueva reserva
    public boolean insertar(Reserva r) {
        String sql = "INSERT INTO reservas (numero_habitacion, cliente, fecha_entrada, fecha_salida) VALUES (?, ?, ?, ?)";
        try (Connection c = Conexion.getConexion();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, r.getNumeroHabitacion());
            p.setString(2, String.valueOf(r.getCliente()));
            p.setDate(3, Date.valueOf(r.getFechaEntrada()));
            p.setDate(4, Date.valueOf(r.getFechaSalida()));

            return p.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Insertar reserva: " + e.getMessage());
            return false;
        }
    }

    // Eliminar una reserva por número de habitación
    public boolean eliminar(int numeroHabitacion) {
        String sql = "DELETE FROM reservas WHERE numero_habitacion = ?";
        try (Connection c = Conexion.getConexion();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, numeroHabitacion);
            return p.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Eliminar reserva: " + e.getMessage());
            return false;
        }
    }

    // Listar todas las reservas
    public List<Reserva> listar() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection c = Conexion.getConexion();
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet rs = p.executeQuery()) {

            while (rs.next()) {
                Reserva r = new Reserva();
                r.setNumeroHabitacion(rs.getInt("numero_habitacion"));
                r.setCliente(rs.getString("cliente"));
                r.setFechaEntrada(rs.getDate("fecha_entrada").toLocalDate());
                r.setFechaSalida(rs.getDate("fecha_salida").toLocalDate());
                lista.add(r);
            }

        } catch (Exception e) {
            System.err.println("Listar reservas: " + e.getMessage());
        }
        return lista;
    }
}
