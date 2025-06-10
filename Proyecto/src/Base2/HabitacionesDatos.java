package Base2;

import Principal1.Habitaciones;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionesDatos {

    public boolean insertar(Habitaciones h) {
        String sql = "INSERT INTO habitaciones (numero, tipo, valorPorNoche, disponible, descuento_aplicado) VALUES (?, ?, ?, ?, 0)";
        try (Connection c = Conexion.getConexion(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, h.getNumero());
            p.setString(2, h.getTipo());
            p.setDouble(3, h.getValorpopNoche());
            p.setBoolean(4, h.isDisponoble());
            return p.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Insertar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int numero) {
        String sql = "DELETE FROM habitaciones WHERE numero = ? AND disponible = true";
        try (Connection c = Conexion.getConexion(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, numero);
            return p.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Eliminar: " + e.getMessage());
            return false;
        }
    }

    public boolean aplicarDescuento(int numero, double porcentaje) {
        String sql = "UPDATE habitaciones SET valorPorNoche = valorPorNoche * ?, descuento_aplicado = ? WHERE numero = ?";
        try (Connection c = Conexion.getConexion(); PreparedStatement p = c.prepareStatement(sql)) {
            double factor = 1 - (porcentaje / 100);
            p.setDouble(1, factor);
            p.setDouble(2, porcentaje);
            p.setInt(3, numero);
            return p.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Descuento: " + e.getMessage());
            return false;
        }
    }

    public boolean cambiarDisponibilidad(int numero, boolean disponible) {
        String sql = "UPDATE habitaciones SET disponible = ? WHERE numero = ?";
        try (Connection c = Conexion.getConexion(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setBoolean(1, disponible);
            p.setInt(2, numero);
            return p.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Disponibilidad: " + e.getMessage());
            return false;
        }
    }

    public List<Habitaciones> obtener(boolean soloDisponibles) {
        List<Habitaciones> lista = new ArrayList<>();
        String sql = soloDisponibles ?
                "SELECT * FROM habitaciones WHERE disponible = true" :
                "SELECT * FROM habitaciones";
        try (Connection c = Conexion.getConexion(); Statement s = c.createStatement(); ResultSet r = s.executeQuery(sql)) {
            while (r.next()) {
                lista.add(new Habitaciones(
                        r.getInt("numero"),
                        r.getString("tipo"),
                        r.getDouble("valorPorNoche"),
                        r.getBoolean("disponible")
                ));
            }
        } catch (Exception e) {
            System.err.println("Obtener: " + e.getMessage());
        }
        return lista;
    }
}

