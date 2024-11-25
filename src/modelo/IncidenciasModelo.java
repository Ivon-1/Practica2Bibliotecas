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
import java.sql.Statement;
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
        String consulta = "INSERT INTO incidencias (estado_incidencia, tipo_incidencia, idSocio) values (?,?, ?)";
        try {
            preparar = conexion.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
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
            mostrarIncidencias();

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

    public boolean agregar_incidencia(String estado_incidencia, String tipo_incidencia, int idSocio) {
        Incidencias agregarIncidencia = new Incidencias(estado_incidencia, tipo_incidencia, idSocio);
        try {
            insertarIncidencia(agregarIncidencia);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * funcion mostrar incidencias
     * @return
     */
    public ArrayList<Incidencias> mostrarIncidencias() {
        ArrayList<Incidencias> incidencias = new ArrayList<>();
        String consulta = "SELECT * FROM incidencias";
        try {
            PreparedStatement preparar = conexion.prepareStatement(consulta);
            ResultSet rs = preparar.executeQuery();

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
    
    /**
     * funcion buscar incidencia radiobutton y combobox
     * @param criterio
     * @param valorBusqueda
     * @param tipoIncidencia
     * @return 
     */
    
    public ArrayList<Incidencias> buscarIncidencias(String criterio, String valorBusqueda, String tipoIncidencia) {
        ArrayList<Incidencias> incidencias = new ArrayList<>();
        Connection con = ConexionBD.conectar();

        if (con == null) {
            System.err.println("Error al conectar a la base de datos");
            return incidencias;
        }

        String sql = "SELECT s.idSocio, s.nombre, s.apellido, i.id_incidencia, i.estado_incidencia, i.tipo_incidencia "
                   + "FROM socios s LEFT JOIN incidencias i ON s.idSocio = i.idSocio ";

        if (criterio.equals("ID") && valorBusqueda != null && !valorBusqueda.isEmpty()) {
            sql += "WHERE s.idSocio = ?";
        } else if (criterio.equals("Nombre") && valorBusqueda != null && !valorBusqueda.isEmpty()) {
            sql += "WHERE s.nombre LIKE ?";
        }

        // Añadir el filtro de tipo de incidencia (Leve o Grave) si se ha seleccionado
        if (tipoIncidencia != null && !tipoIncidencia.isEmpty()) {
            if (sql.contains("WHERE")) {
                sql += " AND i.tipo_incidencia = ?";
            } else {
                sql += "WHERE i.tipo_incidencia = ?";
            }
        }

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            int parameterIndex = 1;

            // Asignar parámetros de búsqueda
            if (criterio.equals("ID") && valorBusqueda != null && !valorBusqueda.trim().isEmpty()) {
                // Validar que valorBusqueda es un número válido
                try {
                    int idSocio = Integer.parseInt(valorBusqueda.trim());  // Eliminar espacios antes y después y convertir
                    stmt.setInt(parameterIndex++, idSocio);
                } catch (NumberFormatException e) {
                    System.err.println("Error: El valor de ID debe ser un número válido.");
                    return incidencias;  // Retornar lista vacía si la conversión falla
                }
            } else if (criterio.equals("Nombre") && valorBusqueda != null && !valorBusqueda.isEmpty()) {
                stmt.setString(parameterIndex++, "%" + valorBusqueda + "%");  // Uso de LIKE para la búsqueda por nombre
            }

            // Filtro de tipo de incidencia
            if (tipoIncidencia != null && !tipoIncidencia.isEmpty()) {
                stmt.setString(parameterIndex++, tipoIncidencia);  // Añadimos el tipo de incidencia
            }

            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int id_incidencia = resultado.getInt("id_incidencia");
                String estado_incidencia = resultado.getString("estado_incidencia");
                String tipo_incidencia = resultado.getString("tipo_incidencia");
                int idSocio = resultado.getInt("idSocio");

                Incidencias incidencia = new Incidencias(nombre, apellido, id_incidencia, estado_incidencia, tipo_incidencia, idSocio);
                incidencias.add(incidencia);
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta");
            e.printStackTrace();
        } finally {
            // Cerrar conexión si es necesario
        }

        return incidencias;
    } 
}
