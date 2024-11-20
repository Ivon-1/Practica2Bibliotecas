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
import javax.swing.JOptionPane;
import modelo.Libro;
import vista.AgregarLibroView;
import vista.MenuView;

/**
 *
 * @author IvanA
 */
public class MostrarLibroController implements ActionListener {

    // instancias de modelo y vista
    private LibroModelo modelo_libro;
    private LibrosView vista_libros;
    private DefaultTableModel datos_tabla;
    private AgregarLibroView libro_agregar;
    private MenuView vista_menu;

    // funcion para mostrar
    public MostrarLibroController(LibroModelo modelo_libro, LibrosView vista_libros, AgregarLibroView libro_agregar, MenuView vista_menu) {
        this.modelo_libro = modelo_libro;
        this.vista_libros = vista_libros;
        this.libro_agregar = libro_agregar;
        this.vista_menu = vista_menu;

        // casteo tabla
        datos_tabla = (DefaultTableModel) this.vista_libros.getTable_libros().getModel();
        // boton
        this.vista_libros.getBtn_agregarLibro().addActionListener(this);
        this.vista_libros.getBtn_buscar().addActionListener(this);
        this.vista_libros.getBtn_eliminarLibro().addActionListener(this);
        this.vista_libros.getBtn_modificar_libro().addActionListener(this);
        this.vista_libros.getCmb_filtro_libros().addActionListener(this);
        this.vista_libros.getTxt_espbusquedaLibro().addActionListener(this);
        this.vista_libros.getBtn_volver_libro().addActionListener(this);
        // boton agregar
        this.libro_agregar.getBtn_agregar().addActionListener(this);
        // funcion para mostrar los libros . RECORDARRRRRR
        mostrarLibros();
        //------------
        this.vista_libros.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vista_libros.getBtn_agregarLibro()) {
            this.libro_agregar.setVisible(true);
        }

        if (e.getSource() == this.libro_agregar.getBtn_agregar()) {
            agregar_libros();
        }

        if (e.getSource() == this.vista_libros.getBtn_eliminarLibro()) {
            eliminar_libros();
        }

        if (e.getSource() == this.vista_libros.getBtn_buscar()) {
            buscarLibros();
        }

        if (e.getSource() == this.vista_libros.getBtn_volver_libro()) { // volver menu
            this.vista_libros.setVisible(false);
            this.vista_menu.setVisible(true);

        }
    }

    //Funcion para agregar libros.
    public void agregar_libros() {
        if (validarDatos()) {
            if (this.modelo_libro.agregar_libro(this.libro_agregar.getTxt_isbn().getText(),
                    this.libro_agregar.getTxt_titulo().getText(),
                    Integer.parseInt(this.libro_agregar.getTxt_Nserie().getText()),
                    Float.parseFloat(this.libro_agregar.getTxt_precio().getText()),
                    this.libro_agregar.getTxt_estado().getText(),
                    this.libro_agregar.getTxt_editorial().getText())) {
                JOptionPane.showMessageDialog(libro_agregar, "Agregado correctamente.");
                this.libro_agregar.dispose();
            } else {
                JOptionPane.showMessageDialog(libro_agregar, "Error al agregar.");
            }
        }
    }

    //Funcion para eliminar libros.
    public void eliminar_libros() {
        String isbn = JOptionPane.showInputDialog(libro_agregar,
                "Introduzca la isbn  que desea eliminar ",
                "Eliminar",
                JOptionPane.ERROR_MESSAGE);

        if (isbn != null) {
            if (this.modelo_libro.buscarPorISBN(isbn) != null) {
                int resultado = JOptionPane.showConfirmDialog(libro_agregar,
                        "Estas seguro de eliminar esta isbn : " + isbn,
                        "Eliminar",
                        JOptionPane.YES_NO_OPTION);

                if (resultado == JOptionPane.YES_NO_OPTION) {
                    this.modelo_libro.eliminarPorIsbn(isbn);
                    JOptionPane.showMessageDialog(libro_agregar,
                            "El libro con isbn " + isbn,
                            " eliminado con exito.",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(libro_agregar,
                        "No existe la isbn" + isbn,
                        "No se puede borrar",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void buscarLibros() {
        String combo = this.vista_libros.getCmb_filtro_libros().getSelectedItem().toString();
        String busqueda = this.vista_libros.getTxt_espbusquedaLibro().getText().trim();
        ArrayList<Libro> resultados = new ArrayList<>();

        boolean buscarPorDisponible = this.vista_libros.getCheck_disponible().isSelected();

        if (buscarPorDisponible && busqueda.isEmpty() && !combo.equals("Todos")) {
            JOptionPane.showMessageDialog(vista_libros, "Por favor, ingrese un valor para buscar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        switch (combo.toLowerCase()) {
            case "isbn":
                Libro libro = this.modelo_libro.buscarPorISBN(busqueda);
                if (libro != null) {
                    if (!buscarPorDisponible || libro.getEstado().equals("disponible")) {
                        resultados.add(libro);
                    }
                } else {
                    JOptionPane.showMessageDialog(vista_libros, "No se encontraron resultados para el ISBN proporcionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "titulo":
                resultados = this.modelo_libro.buscarPorTitulo(busqueda);
                break;

            case "editorial":
                resultados = this.modelo_libro.buscarPorEditorial(busqueda);
                break;

            case "todos":
                if (buscarPorDisponible) {
                    resultados = this.modelo_libro.buscarPorEstado("disponible");
                } else {
                    resultados = this.modelo_libro.mostrarResultados();
                }
                break;

            default:
                JOptionPane.showMessageDialog(vista_libros, "Filtro no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

        if (buscarPorDisponible) {
            resultados.removeIf(libro -> !libro.getEstado().equals("disponible"));
        }

        // Si no se encuentran resultados, muestra un mensaje y retorna
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(vista_libros, "No se encontraron resultados.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultTableModel model = (DefaultTableModel) this.vista_libros.getTable_libros().getModel();
            model.setRowCount(0);

            for (Libro libro : resultados) {
                model.addRow(new Object[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getNumSerie(),
                    libro.getPrecio(),
                    libro.getEstado(),
                    libro.getIdAutor(),
                    libro.getEditorial(),
                    libro.getIdBiblioteca()
                });
            }
        }
    }

    public boolean validarDatos() {
        boolean resultado = true;
        String mensaje = "";

        if (this.libro_agregar.getTxt_isbn().getText().trim().length() == 0) {
            mensaje += "Introduzca un isbn.\n";
            resultado = false;
        }
        if (this.libro_agregar.getTxt_titulo().getText().trim().length() == 0) {
            mensaje += "Introduzca un apellido.\n";
            resultado = false;
        }
        if (this.libro_agregar.getTxt_Nserie().getText().trim().length() == 0) {
            mensaje += "Introduzca un DNI.\n";
            resultado = false;
        }
        if (this.libro_agregar.getTxt_precio().getText().trim().length() == 0) {
            mensaje += "Introduzca un precio.\n";
            resultado = false;
        }
        if (this.libro_agregar.getTxt_estado().getText().trim().length() == 0) {
            mensaje += "Introduzca un estado.\n";
            resultado = false;
        }
        if (this.libro_agregar.getTxt_editorial().getText().trim().length() == 0) {
            mensaje += "Introduzca una editorial.\n";
            resultado = false;
        }

        if (!resultado) {
            JOptionPane.showMessageDialog(libro_agregar, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    // funcion para cargar datos bbdd
    public ArrayList<Libro> cargarLibrosBBDD() {
        ArrayList<Libro> array_libros = new ArrayList<>();
        Connection con = ConexionBD.conectar();
        if (con == null) {
            System.err.println("Error al conectar a la base de datos");
        }

        // consulta
        String sql = "SELECT \n"
                + "    libros.isbn,\n"
                + "    libros.titulo,\n"
                + "    libros.numSerie,\n"
                + "    libros.precio,\n"
                + "    libros.estado,\n"
                + "    libros.idAutor,\n"
                + "    autores.nombre AS autor,\n"
                + "    libros.idBiblioteca,\n"
                + "    biblioteca.nombre AS biblioteca,\n"
                + "    libros.editorial\n"
                + "FROM \n"
                + "    libros\n"
                + "JOIN \n"
                + "    autores ON libros.idAutor = autores.idAutor\n"
                + "JOIN \n"
                + "    biblioteca ON libros.idBiblioteca = biblioteca.idBiblioteca;";
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

                Libro libros = new Libro(isbn, titulo, numSerie, precio, estado, idAutor, editorial, idBiblioteca);
                array_libros.add(libros);
            }

            // error por aqui proseguir despues
        } catch (Exception e) {
            System.err.println("Error al realizar la consulta");
            e.printStackTrace();
        } finally {
            //ConexionBD.cerrarConexion();
        }
        return array_libros;
    }

    // funcion para pintar libro
    public void pintarLibro(Libro pintar_libro) {
        if (pintar_libro != null) {
            datos_tabla.addRow(new Object[]{pintar_libro.getIsbn(),
                pintar_libro.getTitulo(),
                pintar_libro.getNumSerie(),
                pintar_libro.getPrecio(),
                pintar_libro.getEstado(),
                pintar_libro.getIdAutor(),
                pintar_libro.getEditorial(),
                pintar_libro.getIdBiblioteca(),}); // faltaria campos de las otras tablas....
        }
    }

    /**
     * funcion para mostrar libros
     */
    public void mostrarLibros() {
        ArrayList<Libro> libros = cargarLibrosBBDD();
        datos_tabla.setRowCount(0);
        for (Libro libro_actual : libros) {
            pintarLibro(libro_actual);
        }
    }
}
