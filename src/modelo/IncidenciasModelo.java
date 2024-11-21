/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import vista.ComprobarIncidenciasView;

/**
 *
 * @author jguti
 */
public class IncidenciasModelo {
    private HashMap<String , Incidencias> lista_incidencia;
    private Connection conexion;
    private PreparedStatement preparar;
    private ComprobarIncidenciasView incidencias;
    
    public IncidenciasModelo(){
        this.lista_incidencia = new HashMap<>();
        this.conexion = (Connection) ConexionBD.conectar();
    }
    
    
    public void agregarIncidencia(Incidencias incidencia){
        String consulta = "INSERT INTO incidencias (id_incidencia,estado_incidencia,tipo_incidencia) values (?,?,?)";
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}
