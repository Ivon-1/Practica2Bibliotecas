/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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

    public LibroController(LibroModelo modelo, AgregarLibroView vista, LibrosView libros) {
        this.modelo = modelo;
        this.vista = vista;
        this.libros = libros;

        this.libros.getBtn_agregarLibro().addActionListener(this);
        this.vista.getBtn_agregar().addActionListener(this);
        this.vista.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {   
        if(e.getSource() == this.libros.getBtn_agregarLibro()){
            this.vista.setVisible(true);
        }
        if(e.getSource() == this.vista.getBtn_agregar()){
            agregar_libros();
        }
    }
    
    public void agregar_libros(){
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
