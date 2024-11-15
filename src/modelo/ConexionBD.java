/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IvanA
 */
public class ConexionBD {
    // conexion
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;// creamos la conexion

    // establecer conexion
    public static Connection conectar(){
        try {
            // establecer conexion 
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            System.err.println("Error, conexion fallida");
            ex.printStackTrace();
        }
        return connection;
    }
    
    // cerrar conexion
    public static void cerrarConexion(){
        if (connection != null) {
            try{
                connection.close();
                System.err.println("Conexion cerrada");
            } catch (SQLException ex) {
                System.err.println("Error al cerrar conexion");
                ex.printStackTrace();
            }
        }
    }
}




