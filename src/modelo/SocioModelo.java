/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import javax.swing.JPopupMenu;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet; // Importar ResultSet

/**
 *
 * @author jguti
 */
public class SocioModelo {

    // private ConexionBD bd_conexion;
    private Connection conexion;
    private PreparedStatement preparar;

    // almacenamos libros
    private HashMap<Integer, Socio> lista_socios;

    public HashMap<Integer, Socio> getListaSocios() {
        return this.lista_socios;
    }

    public SocioModelo() {
        // this.bd_conexion = new ConexionBD();
        this.conexion = ConexionBD.conectar();
        this.conexion = (Connection) ConexionBD.conectar();
        this.lista_socios = new HashMap<>();
    }
    
    /**
     * funcion mostrar todos
     * @return 
     */
    public ArrayList<Socio> mostrarTodos(){
        String consulta = "SELECT * FROM socios";
        ArrayList<Socio> socios = new ArrayList<>();
        try{
            preparar = conexion.prepareStatement(consulta);
            ResultSet rs = preparar.executeQuery();
            
            while(rs.next()){
                socios.add(new Socio(
                    rs.getString("nombre"), rs.getString("apellido"),
                    rs.getString("correo"), rs.getString("dni"),
                    rs.getInt("telefono"), rs.getString("direccion")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return socios;
    }
    
    

    /**
     * funcion para buscar por nombre
     * @param nombre
     * @return 
     */
    public ArrayList<Socio> buscarPorNombre(String nombre) {
        String consulta = "SELECT * FROM socios WHERE nombre LIKE ?";
        ArrayList<Socio> socios = new ArrayList<>();
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, "%" + nombre + "%");
            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                Socio socio = new Socio(
                rs.getString("nombre"), rs.getString("apellido"),
                rs.getString("correo"), rs.getString("dni"),
                rs.getInt("telefono"), rs.getString("direccion")
            );
            socios.add(socio);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return socios;
    }
    
    /**
     * funcion para buscar por apellido
     * @param apellido
     * @return 
     */
    public ArrayList<Socio> buscarPorApellido(String apellido) {
        String consulta = "SELECT * FROM socios WHERE apellido LIKE ?";
        ArrayList<Socio> socios = new ArrayList<>();
        try {
            PreparedStatement preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, "%" + apellido + "%");
            ResultSet rs = preparar.executeQuery();

            while (rs.next()) {
                Socio socio = new Socio(
                rs.getString("nombre"), rs.getString("apellido"),
                rs.getString("correo"), rs.getString("dni"),
                rs.getInt("telefono"), rs.getString("direccion")
            );
            socios.add(socio);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return socios;
    }
    
    /**
     * funcion para buscar por DNI
     * @param dni
     * @return 
     */
    public Socio buscarPorDNI(String dni) {
        String consulta = "SELECT * FROM socios WHERE dni LIKE ?";
        ArrayList<Socio> socios = new ArrayList<>();
        try {
            PreparedStatement preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, "%" + dni + "%");
            ResultSet rs = preparar.executeQuery();

            if (rs.next()) {
                return new Socio(
                rs.getString("nombre"), rs.getString("apellido"),
                rs.getString("correo"), rs.getString("dni"),
                rs.getInt("telefono"), rs.getString("direccion")
            );
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    //Consulta para agregar un socio.
    public void insertarSocio(Socio socio) {
        String consulta = "INSERT INTO socios (nombre , apellido , correo , dni , telefono , direccion) VALUES (?,?,?,?,?,?)";
        try {

            preparar = conexion.prepareStatement(consulta);
            preparar = conexion.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS); // añadir retorno keys
            preparar.setString(1, socio.getNombre());
            preparar.setString(2, socio.getApellido());
            preparar.setString(3, socio.getCorreo());
            preparar.setString(4, socio.getDni());
            preparar.setInt(5, socio.getTelefono());
            preparar.setString(6, socio.getDireccion());

            int filasAfectadas = preparar.executeUpdate();
            if (filasAfectadas > 0) {
                ResultSet generatedKeys = preparar.getGeneratedKeys();// obtencion id autoincremental
                if (generatedKeys.next()) {
                    int id_generado = generatedKeys.getInt(1);
                    socio.setIdSocio(id_generado);
                }
            }

            System.out.println("Socio agregado con exito.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Consulta  para eliminar por id
    public void eliminarPorId(int idSocio) {
        String consulta = "DELETE FROM socios WHERE idSocio = ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setInt(1, idSocio);
            preparar.execute();

            System.out.println("Socio eliminado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // funcion para buscar por id
    public Socio buscarPorId(int idSocio) {
        String consulta = "SELECT * FROM socios WHERE idSocio = ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setInt(1, idSocio);
            ResultSet rs = preparar.executeQuery();  // Usar executeQuery() para obtener los resultados

            if (rs.next()) {  // Si hay resultados
                // Recuperar los datos del ResultSet y crear un objeto Socio
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String dni = rs.getString("dni");
                int telefono = rs.getInt("telefono");
                String direccion = rs.getString("direccion");

                // Crear un objeto Socio con los datos obtenidos
                Socio socio = new Socio(nombre, apellido, correo, dni, telefono, direccion);
                socio.setIdSocio(idSocio); // Asegúrate de establecer el ID
                return socio;  // Devuelve el socio encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Si no se encontró el socio, devuelve null
    }

    public boolean agregar_socio(String nombre, String apellido, String correo, String dni, int telefono, String direccion) {
        Socio agregarSocio = new Socio(nombre, apellido, correo, dni, telefono, direccion);
        try {
            insertarSocio(agregarSocio);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
