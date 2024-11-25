/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author sergi
 */
public class TrabajadorModelo {
    private Connection conexion;
    private PreparedStatement preparar;
    private HashMap<String, Trabajador> lista_trabajadores;

    public TrabajadorModelo() {
        this.lista_trabajadores = new HashMap<>();
        this.conexion = (Connection) ConexionBD.conectar();
    }
    
    public ArrayList<Trabajador> mostrarTodos(){
        String consulta = "SELECT * FROM socios";
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        
        try{
            preparar = conexion.prepareStatement(consulta);
            ResultSet rs = preparar.executeQuery();
            
            while(rs.next()){
                trabajadores.add(new Trabajador(
                                 rs.getInt("idTrabajador"), rs.getString("nombre"),
                                 rs.getString("apellido"), rs.getString("correo"),
                                 rs.getInt("telefono"), rs.getInt("id_mobiliario")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return trabajadores;
    }
    
    
    public ArrayList<Trabajador> buscarTrabajadores(String filtro, String valor){
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();
        String consulta = "";

        switch (filtro) {
            case "Todos":
                consulta = "SELECT * FROM trabajadores";
                break;
            case "Nombre":
                consulta = "SELECT * FROM trabajadores WHERE nombre LIKE ?";
                break;
            case "Apellido":
                consulta = "SELECT * FROM trabajadores WHERE apellido LIKE ?";
                break;
            case "ID":
                consulta = "SELECT * FROM trabajadores WHERE idTrabajador LIKE ?";
                break;
        }

        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);

            if (!filtro.equals("Todos")) {
                ps.setString(1, "%" + valor + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Trabajador trabajador = new Trabajador(
                    rs.getInt("idTrabajador"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getInt("telefono"),
                    rs.getInt("id_mobiliario")
                );
                listaTrabajadores.add(trabajador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTrabajadores;
    }
}
