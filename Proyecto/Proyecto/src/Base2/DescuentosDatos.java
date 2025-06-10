package Base2;

import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DescuentosDatos {

    // Aqui aplico un descuento a una habitación si está disponible
    public boolean aplicarDescuento(int numeroHabitacion, double porcentajeDescuento) throws Exception {
        String sql = "UPDATE habitaciones SET valorPorNoche = valorPorNoche * (1 - ?), descuento_aplicado = true WHERE numero = ? AND disponible = true";

        try (Connection c = Conexion.getConexion();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setDouble(1, porcentajeDescuento); // Por ejemplo: 0.15 para 15% o no sé Aguirre
            p.setInt(2, numeroHabitacion);

            return p.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al aplicar descuento: " + e.getMessage());
            return false;
        }
    }

    // Y aqui Quito el descuento restaurando el valor original
    public boolean quitarDescuento(int numeroHabitacion, double valorOriginal) {
        String sql = "UPDATE habitaciones SET valorPorNoche = ?, descuento_aplicado = false WHERE numero = ?";

        try (Connection c = Conexion.getConexion();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setDouble(1, valorOriginal); // Aguirre pasar el valor original manualmente
            p.setInt(2, numeroHabitacion);

            return p.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error al quitar descuento: " + e.getMessage());
            return false;
        }
    }
}
