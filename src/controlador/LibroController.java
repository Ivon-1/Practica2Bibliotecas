/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Libro;

/**
 *
 * @author IvanA
 */
public class LibroController {
    // funcion para insertar libro nombre
    public Libro insertarLibro(String isbn, String titulo, int numSerie, float precio, String estado, String editorial) {
        
        String sql = "insert into libros(isbn,titulo,numSerie,precio,estado,idAutor,editorial) VALUES (?,?,?,?,?,?,?)";
        return null;
    }
}
