/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.LibroModelo;
import vista.LibrosView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libro;

/**
 *
 * @author IvanA
 */
public class MostrarLibroController implements ActionListener {

    // instancias de modelo y vista
    private LibroModelo modelo_libro;
    private LibrosView vista_libros;
    private DefaultTableModel datos_tabla;

    // funcion para mostrar
    public MostrarLibroController(LibroModelo modelo_libro, LibrosView vista_libro) {
        this.modelo_libro = modelo_libro;
        this.vista_libros = vista_libro;
        // casteo tabla
        datos_tabla = (DefaultTableModel) this.vista_libros.getTable_libros().getModel();
        // boton
        this.vista_libros.getBtn_agregarLibro();
        this.vista_libros.getBtn_buscar();
        this.vista_libros.getBtn_eliminarLibro();
        this.vista_libros.getBtn_modificar_libro();
        this.vista_libros.getCmb_filtro_libros();
        this.vista_libros.getTxt_espbusquedaLibro();
        // funcion para mostrar los libros . RECORDARRRRRR
        mostrarPublicaciones();
        //----------
        this.vista_libros.setVisible(true);
    }

    // funcion para cargar datos bbdd
    public ArrayList<Libro> cargarLibrosBBDD() {
        ArrayList<Libro> array_libros = new ArrayList<>();
        Connection con = ConexionBD.conectar();
        if (con == null) {
            System.err.println("Error al conectar a la base de datos");
        }

        // consulta
        String sql = "Select * from libros";
        try {
            PreparedStatement stmt = con.prepareStatement(sql); // consulta preparada
            ResultSet resultado = stmt.executeQuery(); // resultado consulta
            while (resultado.next()) {
                String isbn = resultado.getString("isbn");
                String titulo = resultado.getString("titulo");
                int numSerie = resultado.getInt("numSerie");
                float precio = resultado.getFloat("precio");
                String estado = resultado.getString("estado");
                int idAutor = resultado.getInt("idAutor");
                String editorial = resultado.getString("editorial");
                int idBiblioteca = resultado.getInt("idBiblioteca");

                System.out.println("ISBN: " + isbn);
                System.out.println("Titulo: " + titulo);
                System.out.println("Numero de serie" + numSerie);
                System.out.println("Precio" + precio);
                System.out.println("Estado" + estado);
                System.out.println("idAutor" + idAutor);
                System.out.println("Editorial" + editorial);
                System.out.println("IdBliblioteca" + idBiblioteca);
                Libro libros = new Libro(isbn, titulo, numSerie, precio, estado, editorial);
                array_libros.add(libros);
            }

            // error por aqui proseguir despues
        } catch (Exception e) {
            System.err.println("Error al realizar la consulta");
            e.printStackTrace();
        } finally {
            ConexionBD.cerrarConexion();
        }
        return array_libros;
    }

    // funcion para pintar libro
    public void pintarLibro(Libro pintar_libro) {
        if (pintar_libro != null) {
            datos_tabla.addRow(new Object[]{pintar_libro.getISBN(),
                pintar_libro.getTitulo(),
                pintar_libro.getNumSerie(),
                pintar_libro.getPrecio(),
                pintar_libro.getEstado(),
                pintar_libro.getEditorial()}); // faltaria campos de las otras tablas....
        }
    }

    public void mostrarPublicaciones() {
        ArrayList<Libro> libros = cargarLibrosBBDD();
        datos_tabla.setRowCount(0);
        for (Libro libro_actual : libros) {
            pintarLibro(libro_actual);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarPublicaciones();
    }

}
