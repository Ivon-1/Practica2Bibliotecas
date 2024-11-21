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
    }

    public void agregarIncidencia(Incidencias incidencia) {
        String consulta = "INSERT INTO incidencias (id_incidencia,estado_incidencia,tipo_incidencia) values (?,?,?)";
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                incidencias.add(new Incidencias(rs.getInt("id_incidencia"),
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
