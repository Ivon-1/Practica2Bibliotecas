/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Socio;
import modelo.SocioModelo;
import vista.SocioAgregarView;

/**
 *
 * @author jguti
 */
public class SocioController implements ActionListener {

    private SocioModelo modelo;
    private SocioAgregarView vista;

    public SocioController(SocioModelo modelo, SocioAgregarView vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.getBtn_agregar().addActionListener(this);
        this.vista.getBtn_eliminar().addActionListener(this);
        //this.vista.getBtn_eliminar().addActionListener(this);
        this.vista.setVisible(true);

    }

    //Controlador donde se encontraran los metodos(funcionalidades).
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.getBtn_agregar()) {
            agregarSocios();  // Llamamos al método que procesa el formulario
        }
        
        if(e.getSource() == this.vista.getBtn_eliminar()){
            eliminar_socios();
        }
    }

    //FUNCION PARA AGREGAR SOCIOS.
    public void agregarSocios() {
        if (validarDatos()) {
            if (this.modelo.agregar_socio(
                    this.vista.getTxt_nombre().getText(),
                    this.vista.getTxt_apellido().getText(),
                    this.vista.getTxt_correo().getText(),
                    this.vista.getTxt_dni().getText(),
                    Integer.parseInt(this.vista.getTxt_telefono().getText()),
                    this.vista.getTxt_direccion().getText())) {

                JOptionPane.showMessageDialog(vista, "Agregado correctamente.");
                this.vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar.");
            }
        }
    }

    //Funcion para eliminar socios.
    
        public void eliminar_socios() {
        String idSocio = JOptionPane.showInputDialog(vista,
                "Introduzca la id  que desea eliminar ",
                "Eliminar",
                JOptionPane.ERROR_MESSAGE);

        if (idSocio != null) {
            if (this.modelo.buscarPorId(Integer.parseInt(idSocio)) != null) {
                int resultado = JOptionPane.showConfirmDialog(vista,
                        "Estas seguro de eliminar esta id : " + idSocio,
                        "Eliminar",
                        JOptionPane.YES_NO_OPTION);

                if (resultado == JOptionPane.YES_OPTION) {
                    this.modelo.eliminarPorId(Integer.parseInt(idSocio));
                    JOptionPane.showMessageDialog(vista,
                            "El socio con id " + idSocio,
                            " eliminado con exito.",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vista,
                        "No existe la id" + idSocio,
                        "No se puede borrar",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //FUNCION PARA VALIDAR LOS DATOS.
    public boolean validarDatos() {
        boolean resultado = true;
        String mensaje = "";
        
        if (this.vista.getTxt_nombre().getText().trim().length() == 0) {
            mensaje += "Introduzca un nombre.\n";
            resultado = false;
        }
        if (this.vista.getTxt_apellido().getText().trim().length() == 0) {
            mensaje += "Introduzca un apellido.\n";
            resultado = false;
        }
        if (this.vista.getTxt_dni().getText().trim().length() == 0) {
            mensaje += "Introduzca un DNI.\n";
            resultado = false;
        }
        if (this.vista.getTxt_correo().getText().trim().length() == 0) {
            mensaje += "Introduzca un correo electrónico.\n";
            resultado = false;
        }
        if (this.vista.getTxt_telefono().getText().trim().length() == 0) {
            mensaje += "Introduzca un teléfono.\n";
            resultado = false;
        }
        if (this.vista.getTxt_direccion().getText().trim().length() == 0) {
            mensaje += "Introduzca una dirección.\n";
            resultado = false;
        }

        if (!resultado) {
            JOptionPane.showMessageDialog(vista, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }
}
