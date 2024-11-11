/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelo.ConexionBD;
import com.mysql.cj.jdbc.PreparedStatementWrapper;

/**
 *
 * @author IvanA
 */
public class ModeloLibro {

    // almacenamos libros
    private ArrayList<Libro> libros;

    public ModeloLibro(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
        // funcion para insertar libro nombre
    public Libro insertarLibro(String isbn, String titulo, int numSerie, float precio, String estado, String editorial) {
        // metemos consulta en una variable
        String sql = "insert into libros(isbn,titulo,numSerie,precio,estado,idAutor,editorial) VALUES (?,?,?,?,?,?,?)";

        // asignacion de valores stmt
        // ejecucion consulta --> 
        return null;
    }

}
