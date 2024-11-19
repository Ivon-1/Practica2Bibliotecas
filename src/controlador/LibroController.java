/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;
import modelo.LibroModelo;
import vista.AgregarLibroView;
import vista.LibrosView;

/**
 *
 * @author IvanA
 */
public class LibroController implements ActionListener {

    private LibroModelo modelo;
    private AgregarLibroView vista;
    private LibrosView libros;
    private Libro libro;

    public LibroController(LibroModelo modelo, AgregarLibroView vista, LibrosView libros) {
        this.modelo = modelo;
        this.vista = vista;
        this.libros = libros;
        this.modelo.mostrarResultados();
        this.libros.getBtn_agregarLibro().addActionListener(this);
        this.vista.getBtn_agregar().addActionListener(this);
        this.libros.getBtn_buscar().addActionListener(this);
        this.libros.getBtn_eliminarLibro().addActionListener(this);
        this.vista.setVisible(true);
        this.libros.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.libros.getBtn_agregarLibro()) {
            agregar_libros();
        }
        if (e.getSource() == this.vista.getBtn_agregar()) {
            agregar_libros();
        }
        if (e.getSource() == this.libros.getBtn_buscar()) {
            buscarLibros();
        }
        if(e.getSource() == this.libros.getBtn_eliminarLibro()){
            eliminar_libros();
        }
    }

    public void agregar_libros() {
        if (validarDatos()) {
            if (this.modelo.agregar_libro(this.vista.getTxt_isbn().getText(),
                    this.vista.getTxt_titulo().getText(),
                    Integer.parseInt(this.vista.getTxt_Nserie().getText()),
                    Float.parseFloat(this.vista.getTxt_precio().getText()),
                    this.vista.getTxt_estado().getText(),
                    this.vista.getTxt_editorial().getText())) {
                JOptionPane.showMessageDialog(vista, "Agregado correctamente.");
                this.vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar.");
            }
        }
    }

    public void eliminar_libros() {
        String isbn = JOptionPane.showInputDialog(vista,
                "Introduzca la isbn  que desea eliminar ",
                "Eliminar",
                JOptionPane.ERROR_MESSAGE);

        if (isbn != null) {
            if (this.modelo.buscarPorISBN(isbn) != null) {
                int resultado = JOptionPane.showConfirmDialog(vista,
                        "Estas seguro de eliminar esta isbn : " + isbn,
                        "Eliminar",
                        JOptionPane.YES_NO_OPTION);

                if (resultado == JOptionPane.YES_NO_OPTION) {
                    this.modelo.eliminarPorIsbn(isbn);
                    JOptionPane.showMessageDialog(vista,
                            "El libro con isbn " + isbn,
                            " eliminado con exito.",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vista,
                        "No existe la isbn" + isbn,
                        "No se puede borrar",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

public void buscarLibros() {
        String combo = this.libros.getCmb_filtro_libros().getSelectedItem().toString();
        String busqueda = this.libros.getTxt_espbusquedaLibro().getText().trim();
        ArrayList<Libro> resultados = new ArrayList<>();

        boolean buscarPorDisponible = this.libros.getCheck_disponible().isSelected();

        if (buscarPorDisponible && busqueda.isEmpty() && !combo.equals("Todos")) {
            JOptionPane.showMessageDialog(libros, "Por favor, ingrese un valor para buscar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        switch (combo.toLowerCase()) {
            case "isbn":
                Libro libro = this.modelo.buscarPorISBN(busqueda);
                if (libro != null) {
                    if (!buscarPorDisponible || libro.getEstado().equals("disponible")) {
                        resultados.add(libro);
                    }
                } else {
                    JOptionPane.showMessageDialog(libros, "No se encontraron resultados para el ISBN proporcionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "titulo":
                resultados = this.modelo.buscarPorTitulo(busqueda);
                break;

            case "editorial":
                resultados = this.modelo.buscarPorEditorial(busqueda);
                break;

            case "todos":
                // Si el combo es "Todos"
                if (buscarPorDisponible) {
                    // Si está marcado el checkbox, solo buscamos los libros disponibles
                    resultados = this.modelo.buscarPorEstado("disponible");
                } else {
                    // Si no está marcado el checkbox, buscamos todos los libros
                    resultados = this.modelo.mostrarResultados();
                }
                break;

            default:
                JOptionPane.showMessageDialog(libros, "Filtro no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

        if (buscarPorDisponible) {
            resultados.removeIf(libro -> !libro.getEstado().equals("disponible"));
        }

        // Si no se encuentran resultados, muestra un mensaje y retorna
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(libros, "No se encontraron resultados.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultTableModel model = (DefaultTableModel) this.libros.getTable_libros().getModel();
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

        if (this.vista.getTxt_isbn().getText().trim().length() == 0) {
            mensaje += "Introduzca un isbn.\n";
            resultado = false;
        }
        if (this.vista.getTxt_titulo().getText().trim().length() == 0) {
            mensaje += "Introduzca un apellido.\n";
            resultado = false;
        }
        if (this.vista.getTxt_Nserie().getText().trim().length() == 0) {
            mensaje += "Introduzca un DNI.\n";
            resultado = false;
        }
        if (this.vista.getTxt_precio().getText().trim().length() == 0) {
            mensaje += "Introduzca un precio.\n";
            resultado = false;
        }
        if (this.vista.getTxt_estado().getText().trim().length() == 0) {
            mensaje += "Introduzca un estado.\n";
            resultado = false;
        }
        if (this.vista.getTxt_editorial().getText().trim().length() == 0) {
            mensaje += "Introduzca una editorial.\n";
            resultado = false;
        }

        if (!resultado) {
            JOptionPane.showMessageDialog(vista, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }
}
