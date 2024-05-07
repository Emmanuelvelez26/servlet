package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class connector {
    private static final String URL = "jdbc:mysql://localhost:3308/registroweb";
    private static final String USUARIO = "admin";
    private static final String CONTRASEÑA = "admin";

    public static Connection conectar(){
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        
        return conexion;
    }
}
