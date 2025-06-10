package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    // SOLO conexión al servidor MySQL (sin BD aún)
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConexion() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
