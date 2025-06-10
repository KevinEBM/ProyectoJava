package util;

import java.sql.Connection;
import java.sql.Statement;

public class InstaladorBD {

    public static void main(String[] args) {
        try (Connection con = Conexion.getConexion();
             Statement stmt = con.createStatement()) {

            // Crear la base de datos
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS hotel");

            // Usar la base de datos
            stmt.execute("USE hotel");

            // Crear tabla habitaciones
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS habitaciones (
                    numero INT PRIMARY KEY,
                    tipo VARCHAR(50),
                    valorPorNoche DOUBLE,
                    disponible BOOLEAN,
                    descuento_aplicado BOOLEAN DEFAULT false
                )
            """);

            // Crear tabla clientes
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS clientes (
                    nombre VARCHAR(100),
                    cedula VARCHAR(20) PRIMARY KEY,
                    correo VARCHAR(100)
                )
            """);

            // Crear tabla reservas
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS reservas (
                    numero_habitacion INT,
                    cliente VARCHAR(100),
                    fecha_entrada DATE,
                    fecha_salida DATE
                )
            """);

            System.out.println("✅ Base de datos y tablas creadas correctamente.");

        } catch (Exception e) {
            System.err.println("❌ Error al crear la base de datos: " + e.getMessage());
        }
    }
}
