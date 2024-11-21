/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.SQLException;
import vista.ComprobarIncidenciasView;

/**
 *
 * @author jguti
 */
public class IncidenciasModelo {

    private HashMap<String, Incidencias> lista_incidencia;
    private Connection conexion;
    private PreparedStatement preparar;
    private ComprobarIncidenciasView incidencias;

    public IncidenciasModelo() {
        this.lista_incidencia = new HashMap<>();
        this.conexion = (Connection) ConexionBD.conectar();
        this.lista_incidencia = new HashMap<>();
    }

    //Consulta agregar incidencia.
    public void insertarIncidencia(Incidencias incidencia) {
        String consulta = "INSERT INTO incidencias (estado_incidencia,tipo_incidencia, idSocio) values (?,?,?)";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setString(1, incidencia.getEstado_incidencia());
            preparar.setString(2, incidencia.getTipo_incidencia());
            preparar.setInt(3, incidencia.getIdSocio());

            int filasAfectadas = preparar.executeUpdate();
            if (filasAfectadas > 0) {
                ResultSet generatedKeys = preparar.getGeneratedKeys();// obtencion id autoincremental
                if (generatedKeys.next()) {
                    int id_generado = generatedKeys.getInt(1);
                    incidencia.setId_incidencia(id_generado);
                }
            }

            System.out.println("Incidencia agregada con exito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Consulta para eliminar por id.
    public void eliminarPorIdIncidencia(int idSocio) {
        String consulta = "DELETE FROM incidencias WHERE idSocio = ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setInt(1, idSocio);
            preparar.execute();

            System.out.println("Socio eliminado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Consulta para buscar por id.
    public Incidencias buscarPorIdIncidencias(int idSocio) {
        String consulta = "SELECT * FROM incidencias WHERE idSocio = ?";
        try {
            preparar = conexion.prepareStatement(consulta);
            preparar.setInt(1, idSocio);
            ResultSet rs = preparar.executeQuery();  // Usar executeQuery() para obtener los resultados

            if (rs.next()) {  // Si hay resultados
                // Recuperar los datos del ResultSet y crear un objeto incidencias
                String estado_incidencia = rs.getString("estado_incidencia");
                String tipo_incidencia = rs.getString("tipo_incidencia");
                int id_incidencia = rs.getInt("id_incidencia");

                Incidencias incidencia = new Incidencias(consulta, tipo_incidencia, id_incidencia, estado_incidencia, tipo_incidencia, idSocio);
                return incidencia;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean agregar_incidencia(int id_incidencia, String estado_incidencia, String tipo_incidencia, int idSocio) {
        Incidencias agregarIncidencia = new Incidencias(tipo_incidencia, tipo_incidencia, id_incidencia, estado_incidencia, tipo_incidencia, idSocio);
        try {
            insertarIncidencia(agregarIncidencia);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * funcion mostrar incidencias
     *
     * @return
     */
    public ArrayList<Incidencias> mostrarIncidencias() {
        ArrayList<Incidencias> incidencias = new ArrayList<>();
        String consulta = "SELECT * FROM incidencias";  // posteriormente añadir JOIN para enlazar con sus foraneas
        try {
            PreparedStatement preparar = conexion.prepareStatement(consulta);
            ResultSet rs = preparar.executeQuery(consulta);

            while (rs.next()) {
                incidencias.add(new Incidencias(rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("id_incidencia"),
                        rs.getString("estado_incidencia"),
                        rs.getString("tipo_incidencia"),
                        rs.getInt("idSocio"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidencias;
    }
}
