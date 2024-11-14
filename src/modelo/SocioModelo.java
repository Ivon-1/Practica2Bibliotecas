/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import javax.swing.JPopupMenu;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author jguti
 */
public class SocioModelo {
    //private ConexionBD bd_conexion;
    private Connection conexion;
    private PreparedStatement preparar;
    
    public SocioModelo() {
        //this.bd_conexion =  new ConexionBD();
        this.conexion = ConexionBD.conectar();
       
    }
    
    public void insertarSocio(Socio socio){
        String consulta = "INSERT INTO socio (nombre , apellido , correo , dni , telefono , direccion) VALUES (?,?,?,?,?,?)";
        try {
            
            preparar = conexion.prepareStatement(consulta);          
            preparar.setString(1, socio.getNombre());
            preparar.setString(2, socio.getApellido());
            preparar.setString(3, socio.getCorreo());
            preparar.setString(4, socio.getDni());
            preparar.setString(5, socio.getTelefono());
            preparar.setString(6, socio.getDireccion());
            
            preparar.execute();
            
            System.out.println("Socio agregado con exito");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    
    public boolean agregar_socio(String nombre, String apellido, String correo, String dni, String telefono, String direccion){
        Socio agregarSocio = new Socio(nombre, apellido, correo, dni, telefono, direccion);
        return false;
    }
}
