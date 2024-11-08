/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.sun.jdi.connect.spi.Connection;
import modelo.Libro;
import modelo.ConexionBD;

/**
 *
 * @author IvanA
 */
public class ModeloLibro {

    private ConexionBD conexion;
    private Libro libro_modelo;

    public ModeloLibro(ConexionBD conexion, Libro modeloLibro) {
        this.conexion = this.conexion;
        this.libro_modelo = libro_modelo;
    }

    // funcion para insertar libro nombre
    public static void insertarLibro(String isbn, String titulo, int numSerie, float precio,String estado, String editorial) {
        // metemos consulta en una variable
        String sql = "insert into libros(isbn,titulo,numSerie,precio,estado,idAutor,editorial) VALUES (?,?,?,?,?,?,?)";
        // try catch 
         try(){
             
         }catch(){
             
         }
        
        
       
        // asignacion de valores stmt
        
        
        
        // ejecucion consulta --> 
    }
    
    
}
