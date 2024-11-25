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

    public ArrayList<Trabajador> mostrarTodos() {
        String consulta = "SELECT * FROM socios";
        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        try {
            preparar = conexion.prepareStatement(consulta);
            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                trabajadores.add(new Trabajador(
                        rs.getInt("idTrabajador"), rs.getString("nombre"),
                        rs.getString("apellido"), rs.getString("correo"),
                        rs.getInt("telefono"), rs.getInt("id_mobiliario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trabajadores;
    }

    //Consulta para agregar un trabajador.
    public void insertarTrabajador(Trabajador trabajador) {
        String consulta = "INSERT INTO trabajadores (nombre , apellido , correo , telefono , id_mobiliario) VALUES (?,?,?,?,?)";
        try {

            preparar = conexion.prepareStatement(consulta);
            preparar = conexion.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS); // añadir retorno keys
            preparar.setString(1, trabajador.getNombre());
            preparar.setString(2, trabajador.getApellido());
            preparar.setString(3, trabajador.getCorreo());
            preparar.setInt(4, trabajador.getTelefono());
            preparar.setInt(5, trabajador.getId_mobiliario());

            int filasAfectadas = preparar.executeUpdate();
            if (filasAfectadas > 0) {
                ResultSet generatedKeys = preparar.getGeneratedKeys();// obtencion id autoincremental
                if (generatedKeys.next()) {
                    int id_generado = generatedKeys.getInt(1);
                    trabajador.setIdTrabajador(id_generado);
                }
            }

            System.out.println("Trabajador agregado con exito.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    //Consulta  para eliminar por id
    public void eliminarPorId(int idTrabajador) {
        String consulta = "DELETE FROM trabajadores WHERE idTrabajador = ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setInt(1, idTrabajador);
            preparar.execute();

            System.out.println("Trabajador eliminado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Funcion para buscar por ID.
    
    public Trabajador buscarPorId(int idTrabajador){
        String consulta = "SELECT * FROM trabajadores WHERE idTrabajador= ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setInt(1, idTrabajador);
            ResultSet rs = preparar.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                int telefono = rs.getInt("telefono");
                int  id_mobiliario = rs.getInt("id_mobiliario");
                
                Trabajador trabajador = new Trabajador(nombre, apellido, correo, telefono, id_mobiliario);
                trabajador.setIdTrabajador(idTrabajador);
                return trabajador;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean agregar_trabajador(String nombre, String apellido, String correo, int telefono, int id_mobiliario){
        Trabajador agregarTrabajador = new Trabajador(nombre, apellido, correo, telefono, id_mobiliario);
        try {
            insertarTrabajador(agregarTrabajador);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Trabajador> buscarTrabajadores(String filtro, String valor) {
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
