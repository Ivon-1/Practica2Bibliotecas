/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import vista.LibrosView;

/**
 *
 * @author IvanA
 */
public class LibroModelo {

    //Almacenamos libros
    private HashMap<String, Libro> lista_libros;
    //Conexion BD INSERTAR.
    private Connection conexion;
    private PreparedStatement preparar;
    private LibrosView libros;

    public LibroModelo() {
        this.lista_libros = new HashMap<>();
        //Conexion base datos Aaron insertar.
        this.conexion = (Connection) ConexionBD.conectar();
    }

    /**
     * funcion mostrar todos
     * @return 
     */
    public ArrayList<Libro> mostrarResultados() {
    ArrayList<Libro> libros = new ArrayList<>();
    String consulta = "SELECT * FROM libros";  // Consulta para obtener todos los libros
    try {
        PreparedStatement preparar = conexion.prepareStatement(consulta);
        ResultSet rs = preparar.executeQuery(consulta);

        while (rs.next()) {
            libros.add(new Libro(
                rs.getString("isbn"), rs.getString("titulo"),
                rs.getInt("numSerie"), rs.getFloat("precio"),
                rs.getString("estado"), rs.getInt("idAutor"),
                rs.getString("editorial"), rs.getInt("idBiblioteca")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return libros;
    }
    
    /**
     * funcion para buscar por ISBN
     * @param ISBN
     * @return 
     */
    public Libro buscarPorISBN(String isbn) {
        String consulta = "SELECT * FROM libros WHERE isbn = ?";
        try {
            PreparedStatement preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, isbn);
            ResultSet rs = preparar.executeQuery();

            if (rs.next()) {
                return new Libro(rs.getString("isbn"), rs.getString("titulo"),
                                 rs.getInt("numSerie"), rs.getFloat("precio"),
                                 rs.getString("estado"), rs.getInt("idAutor"),
                                 rs.getString("editorial"), rs.getInt("idBiblioteca")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * funcion para buscar por titulo
     * @param titulo
     * @return 
     */
    public ArrayList<Libro> buscarPorTitulo(String titulo) {
        String consulta = "SELECT * FROM libros WHERE titulo LIKE ?";
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            PreparedStatement preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, "%" + titulo + "%");
            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                libros.add(new Libro(rs.getString("isbn"), rs.getString("titulo"),
                                     rs.getInt("numSerie"), rs.getFloat("precio"),
                                     rs.getString("estado"), rs.getInt("idAutor"),
                                     rs.getString("editorial"), rs.getInt("idBiblioteca")
                                     ));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return libros;
    }
    
    /**
     * funcion buscar por estado
     * @param estado
     * @return 
     */
    public ArrayList<Libro> buscarPorEstado(String estado) {
        String consulta = "SELECT * FROM libros WHERE estado LIKE ?";
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            PreparedStatement preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, "%" + estado + "%");
            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                libros.add(new Libro(rs.getString("isbn"), rs.getString("titulo"),
                                     rs.getInt("numSerie"), rs.getFloat("precio"),
                                     rs.getString("estado"), rs.getInt("idAutor"),
                                     rs.getString("editorial"), rs.getInt("idBiblioteca")
                                     ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return libros;
    }
    
    /**
     * funcion buscar por editorial
     * @param editorial
     * @return 
     */
    public ArrayList<Libro> buscarPorEditorial(String editorial) {
        String consulta = "SELECT * FROM libros WHERE editorial LIKE ?";
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            PreparedStatement preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, "%" + editorial + "%");
            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                libros.add(new Libro(rs.getString("isbn"), rs.getString("titulo"),
                                     rs.getInt("numSerie"), rs.getFloat("precio"),
                                     rs.getString("estado"), rs.getInt("idAutor"),
                                     rs.getString("editorial"), rs.getInt("idBiblioteca")
                                     ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return libros;
    }

    

    // funcion para eliminar por isbn.
    public void eliminarPorIsbn(String isbn){
        String consulta = "DELETE FROM libros WHERE isbn= ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, isbn);
            preparar.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    /*
    Verifica si el isbn ya existe.
    */
    public boolean existeEnPrestamos(String isbn){
        String consulta = "SELECT 1 FROM prestamos WHERE isbn = ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setString(1,isbn);
            preparar.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // insertar libros -- aaron
    public void insertarLibro(Libro libro) {
        String consulta = "INSERT INTO libros (isbn,titulo,numSerie,precio,estado,editorial) values (?,?,?,?,?,?)";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, libro.getIsbn());
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
    public boolean agregar_libro(String isbn, String titulo, int numSerie, float precio, String estado, String editorial) {
        Libro agregarLibro = new Libro(isbn, titulo, numSerie, precio, estado, editorial);
        try {
            insertarLibro(agregarLibro);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
