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
import vista.AgregarSocioView;

/**
 *
 * @author jguti
 */
/*
public class SocioController implements ActionListener{
    
    private SocioModelo modelo_socio;
    private AgregarSocioView vista_agregar_socio;
    
    
    public SocioController(SocioModelo modelo_socio , AgregarSocioView vista_agregar_socio){
        this.modelo_socio = modelo_socio;
        this.vista_agregar_socio = vista_agregar_socio;
        
        /**
         * IMPLEMENTACION DE LOS BOTONES.
         */
    //}
    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        agregarSocios();
    }*/
    
    
    
    /**
     * Funcion para agregar socios.
     */
    /*
    public void agregarSocios(){
        if (validarDatos()){
            if(this.modelo_socio.agregar_socio(this.vista_agregar_socio.getTxt_nombre().getText(), 
                                                this.vista_agregar_socio.getTxt_apellido().getText(),
                                                this.vista_agregar_socio.getTxt_correo().getText(),
                                                this.vista_agregar_socio.getTxt_dni().getText(),
                                                this.vista_agregar_socio.getTxt_telefono().getText(),
                                                this.vista_agregar_socio.getTxt_direccion().getText())) {
                JOptionPane.showMessageDialog(vista_agregar_socio, "Socio " + this.vista_agregar_socio.getTxt_nombre().getText(), "REGISTRO USUARIO",0);
                this.vista_agregar_socio.dispose();
            }else{
                JOptionPane.showMessageDialog(vista_agregar_socio, "No se pudo registrar el socio" , "ERROR REGISTRO" , JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    
    
    /**
     * Funcion para la validacion de datos.
 
    
    public boolean validarDatos(){
        boolean resultado = true;
        String mensaje = "";
        
        if (this.vista_agregar_socio.getTxt_nombre().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un nombre. \n";
            return false;
        }
        
        if (this.vista_agregar_socio.getTxt_apellido().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un apellido. \n";
            return false;
        }
        
        if (this.vista_agregar_socio.getTxt_dni().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un dni. \n";
            return false;
        }
        
        if (this.vista_agregar_socio.getTxt_correo().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un correo electronico. \n";
            return false;
        }
        
        if (this.vista_agregar_socio.getTxt_telefono().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un telefono. \n";
            return false;
        }
        
        if (this.vista_agregar_socio.getTxt_direccion().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca una direccion. \n";
            return false;
        }
        
        if (!resultado) {
            JOptionPane.showMessageDialog(vista_agregar_socio,
                                          mensaje,
                                          "Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }
}    */
