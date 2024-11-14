/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author IvanA
 */
public class ModeloLibro {

    // almacenamos libros
    private HashMap<String, Libro> lista_libros;

    public ModeloLibro() {
        this.lista_libros = new HashMap<>();
    }

    public HashMap<String, Libro> getListaLibros() {
        return this.lista_libros;
    }

    // funcion para buscar por titulo
    public ArrayList<Libro> buscarPorTitulo(String titulo) {
        ArrayList<Libro> busqueda_libro = new ArrayList<>();
        for (String titulo_actual : this.lista_libros.keySet()) {
            if (this.lista_libros.get(titulo_actual).getTitulo().contains(titulo)) {
                busqueda_libro.add(this.lista_libros.get(titulo_actual));
            }
        }
        return busqueda_libro;
    }
   
    // funcion para buscar por id
    public Libro buscarPorId(int id) {
        return this.lista_libros.get(id);
    }

   // funcion para eliminar por id
    public Libro eliminarPorId(int id) {
        return this.lista_libros.remove(id);
    }
   
    // insertar libros -- aaron
    // consultar
}
