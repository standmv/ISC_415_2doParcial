package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

    private static DBService instancia;
    private String URL = "jdbc:h2:tcp://localhost/~/parcial2";

    private DBService(){
        registrarDriver();
    }

    public static DBService getInstancia(){
        if(instancia==null){
            instancia = new DBService();
        }
        return instancia;
    }

    private void registrarDriver() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
        }
    }

    public Connection getConexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, "", "");
        } catch (SQLException ex) {
        }
        return con;
    }

    public void testConexion() {
        try {
            getConexion().close();
            System.out.println("Conexión realizado con exito...");
        } catch (SQLException ex) {
        }
    }
}
