/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Incidencias;
import modelo.IncidenciasModelo;
import vista.AgregarIncidenciaView;
import vista.ComprobarIncidenciasView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import modelo.ConexionBD;
import vista.MenuView;

/**
 *
 * @author IvanA
 */
public class IncidenciaController implements ActionListener {

    private IncidenciasModelo modelo_incidencias;
    private ComprobarIncidenciasView vista_incidencias;
    private DefaultTableModel datos_tabla;
    private AgregarIncidenciaView vista_agregar_incidencia;
    // instancia vista agregar incidencia

    public IncidenciaController(IncidenciasModelo modelo_incidencias, ComprobarIncidenciasView vista_incidencias, DefaultTableModel tabla_incidencias, AgregarIncidenciaView vista_agregar_incidencia) {
        this.modelo_incidencias = modelo_incidencias;
        this.vista_incidencias = vista_incidencias;
        this.datos_tabla = tabla_incidencias;
        this.vista_agregar_incidencia = vista_agregar_incidencia;
        // casteo tabla
        this.datos_tabla = (DefaultTableModel) this.vista_incidencias.getTable_socios_incidencias().getModel();
        // escucha botones
        addButtones();
        // funcion para mostrar incidencias
        mostrarIncidencias();
        //----------
        this.vista_incidencias.setVisible(true);
    }

    /**
     * funcion para añadir botones
     */
    public void addButtones() {
        this.vista_incidencias.getBtn_agregarIncidencia();
        this.vista_incidencias.getBtn_buscarSocios();
        this.vista_incidencias.getBtn_eliminarIncidencia();
        this.vista_incidencias.getBtn_modificar_incidencia();
        this.vista_incidencias.getBtn_volver_incidencia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista_incidencias.getBtn_agregarIncidencia()) {
            this.vista_agregar_incidencia.setVisible(true);
        }

        if (e.getSource() == this.vista_incidencias.getBtn_agregarIncidencia()) { // agregar incidencia

        }

        if (e.getSource() == this.vista_incidencias.getBtn_eliminarIncidencia()) { // eliminar incidencia

        }

        if (e.getSource() == this.vista_incidencias.getBtn_eliminarIncidencia()) { // buscar incidencia

        }

        if (e.getSource() == this.vista_incidencias.getBtn_volver_incidencia()) { // volver menu
            this.vista_agregar_incidencia.setVisible(false);
            this.vista_incidencias.setVisible(true);

        }
    }

    // funcion para cargar datos bbdd
    public ArrayList<Incidencias> cargarIncidencias() {
        ArrayList<Incidencias> array_incidencias = new ArrayList<>();
        Connection con = ConexionBD.conectar();
        if (con == null) {
            System.err.println("Error al conectar a la base de datos");
        }

        // consulta
        String sql = "SELECT \n"
                + "    i.id_incidencia, \n"
                + "    i.estado_incidencia, \n"
                + "    i.tipo_incidencia, \n"
                + "    i.idSocio,\n"
                + "    s.nombre, \n"
                + "    s.apellidos \n"
                + "FROM \n"
                + "    incidencias i\n"
                + "JOIN \n"
                + "    socios s ON i.idSocio = s.idSocio;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql); // consulta preparada
            ResultSet resultado = stmt.executeQuery(); // resultado consulta
            while (resultado.next()) {
                int id_incidencia = resultado.getInt("id_incidencia");
                String estado_incidencia = resultado.getString("estado_incidencia");
                String tipo_incidencia = resultado.getString("tipo_incidencia");
                int idSocio = resultado.getInt("idSocio");

                Incidencias incidencias = new Incidencias(id_incidencia, estado_incidencia, tipo_incidencia, idSocio);
                array_incidencias.add(incidencias);
            }

            // error por aqui proseguir despues
        } catch (Exception e) {
            System.err.println("Error al realizar la consulta");
            e.printStackTrace();
        } finally {
            //ConexionBD.cerrarConexion();
        }
        return array_incidencias;
    }

    // funcion para pintar incidencias
    public void pintarIncidencias(Incidencias pintar_incidencias) {
        if (pintar_incidencias != null) {
            datos_tabla.addRow(new Object[]{
                pintar_incidencias.getId_incidencia(),
                pintar_incidencias.getEstado_incidencia(),
                pintar_incidencias.getTipo_incidencia(),
                pintar_incidencias.getIdSocio()});
        }
    }

    public void mostrarIncidencias() {
        ArrayList<Incidencias> incidencias = cargarIncidencias();
        datos_tabla.setRowCount(0);
        for (Incidencias incidencia_actual : incidencias) {
            pintarIncidencias(incidencia_actual);
        }
    }

}
