/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.SocioModelo;
import vista.SocioView;


/**
 *
 * @author jguti
 */

public class SocioController implements ActionListener{
    
    private SocioModelo modelo;
    private SocioView vista;
    
    
    public SocioController(SocioModelo modelo, SocioView vista){
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.getBtn_agregar().addActionListener(this);
        this.vista.setVisible(true);
        
    }

    //Controlador donde se encontraran los metodos(funcionalidades).
    @Override
    public void actionPerformed(ActionEvent e) {
        agregarSocios();
        
        if (e.getSource()== this.vista.getBtn_agregar()) {
           new SocioController(modelo, vista);
        } 
        
    }
    
    public void agregarSocios(){
        if (validarDatos()){
            if(this.modelo.agregar_socio(this.vista.getTxt_nombre().getText(), 
                                          this.vista.getTxt_apellido().getText(), 
                                          this.vista.getTxt_correo().getText(), 
                                          this.vista.getTxt_dni().getText(),
                                          this.vista.getTxt_telefono().getText(),
                                          this.vista.getTxt_direccion().getText())){
            
                JOptionPane.showMessageDialog(vista,"Agregado correctamente.");
                this.vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar.");    
            }  
        }
    }
        
    public boolean validarDatos(){
        boolean resultado = true;
        String mensaje = "";
        
        if (this.vista.getTxt_nombre().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un nombre. \n";
            return false;
        }
        
        if (this.vista.getTxt_apellido().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un apellido. \n";
            return false;
        }
        
        if (this.vista.getTxt_dni().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un dni. \n";
            return false;
        }
        
        if (this.vista.getTxt_correo().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un correo electronico. \n";
            return false;
        }
        
        if (this.vista.getTxt_telefono().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca un telefono. \n";
            return false;
        }
        
        if (this.vista.getTxt_direccion().getText().trim().length() == 0) {
            mensaje = mensaje + "Introduzca una direccion. \n";
            return false;
        }
        
        if (!resultado) {
            JOptionPane.showMessageDialog(vista,
                                          mensaje,
                                          "Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }
}
