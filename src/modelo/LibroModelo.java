/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author IvanA
 */
public class LibroModelo {

    // almacenamos libros
    private HashMap<String, Libro> lista_libros;
    //Conexion BD INSERTAR.
    private Connection conexion;
    private PreparedStatement preparar;

    public LibroModelo() {
        this.lista_libros = new HashMap<>();
        //Conexion base datos Aaron insertar.
        this.conexion = (Connection) ConexionBD.conectar();
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
    public void insertarLibro(Libro libro) {
        String consulta = "INSERT INTO libros (isbn,titulo,numSerie,precio,estado,editorial) values (?,?,?,?,?,?)";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, libro.getISBN());
            preparar.setString(2, libro.getTitulo());
            preparar.setInt(3, libro.getNumSerie());
            preparar.setFloat(4, libro.getPrecio());
            preparar.setString(5, libro.getEstado());
            preparar.setString(6, libro.getEditorial());

            preparar.execute();
            System.out.println("Libro agregado con exito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // consultar
    public boolean agregar_libro(String ISBN, String titulo, int numSerie, float precio, String estado, String editorial) {
        Libro agregarLibro = new Libro(ISBN, titulo, numSerie, precio, estado, editorial);
        try {
            insertarLibro(agregarLibro);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
