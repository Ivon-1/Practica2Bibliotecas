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

    /* funcion para buscar por dni
    public ArrayList<Socio> buscarPorTitulo(String dni) {
        ArrayList<Socio> busqueda_socio = new ArrayList<>();
        for (String dni_actual : this.lista_socios.keySet()) {
            if (this.lista_socios.get(dni_actual).getDni().contains(dni)) {
                busqueda_socio.add(this.lista_socios.get(dni_actual));
            }
        }
        return busqueda_socio;
    }*/
    //Consulta para agregar un socio.
    public void insertarSocio(Socio socio) {
        String consulta = "INSERT INTO socios (nombre , apellido , correo , dni , telefono , direccion) VALUES (?,?,?,?,?,?)";
        try {

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
    public boolean eliminarPorId(int idSocio) {
        String consulta = "DELETE FROM socios WHERE idSocio = ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setInt(1, idSocio);
            preparar.execute();

            System.out.println("Socio eliminado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // funcion para buscar por id
    public Socio buscarPorId(int idSocio) {
        return this.lista_socios.get(idSocio);
    }

    public boolean agregar_socio(String nombre, String apellido, String correo, String dni, int telefono, String direccion) {
        Socio agregarSocio = new Socio( nombre, apellido, correo, dni, telefono, direccion);
        try {
            insertarSocio(agregarSocio);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
