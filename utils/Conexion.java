package utils;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/sismed";
    public static final String USER = "root";
    public static final String PASSWD = "root";

    public Connection getConnection(){

        Connection conexion = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWD);

        }catch(Exception e) {

            System.err.println("Error " + e);

        }
        return conexion;
    }

}
