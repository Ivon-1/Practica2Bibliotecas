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
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import vista.MenuView;
import vista.SociosView;

/**
 *
 * @author IvanA
 */
public class IncidenciaController implements ActionListener {

    private IncidenciasModelo modelo_incidencias;
    private MostrarSocioController controlador_mostrarSocio;
    private ComprobarIncidenciasView vista_incidencias;
    private SociosView vista_socios;
    private DefaultTableModel datos_tabla;
    private AgregarIncidenciaView vista_agregar_incidencia;
    // instancia vista agregar incidencia

    public IncidenciaController(IncidenciasModelo modelo_incidencias, SociosView vista_socios, ComprobarIncidenciasView vista_incidencias, DefaultTableModel tabla_incidencias, AgregarIncidenciaView vista_agregar_incidencia) {
        this.modelo_incidencias = modelo_incidencias;
        this.vista_incidencias = vista_incidencias;
        this.datos_tabla = tabla_incidencias;
        this.vista_agregar_incidencia = vista_agregar_incidencia;//Referencia al boton del form.
        this.vista_socios = vista_socios;
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
        this.vista_incidencias.getBtn_agregarIncidencia().addActionListener(this);
        this.vista_incidencias.getBtn_buscarSocios().addActionListener(this);
        this.vista_incidencias.getBtn_eliminarIncidencia().addActionListener(this);
        this.vista_incidencias.getBtn_modificar_incidencia().addActionListener(this);
        this.vista_incidencias.getBtn_volver_incidencia().addActionListener(this);
        this.vista_agregar_incidencia.getBtn_agregar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista_incidencias.getBtn_agregarIncidencia()) {
            this.vista_agregar_incidencia.setVisible(true);
        }

        if (e.getSource() == this.vista_agregar_incidencia.getBtn_agregar()) { // agregar incidencia
            agregarIncidencia();
        }

        if (e.getSource() == this.vista_incidencias.getBtn_eliminarIncidencia()) { // eliminar incidencia
            eliminarIncidencia();
        }

        if (e.getSource() == this.vista_incidencias.getBtn_eliminarIncidencia()) { // buscar incidencia -- corregir eliminar

        }

        if (e.getSource() == this.vista_incidencias.getBtn_volver_incidencia()) { // volver menu
            this.vista_socios.setVisible(true);
            this.vista_incidencias.setVisible(false);
        }
    }

//Funcion para agregar incidencia.
    public void agregarIncidencia() {

        int filaSeleccionada = this.vista_incidencias.getTable_socios_incidencias().getSelectedRow();

        // Si hay una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener el idSocio de la fila seleccionada (columna 0 tiene el id del socio)
            int idSocio = (int) this.datos_tabla.getValueAt(filaSeleccionada, 0);
            if (validarDatos()) {
                boolean resultado = this.modelo_incidencias.agregar_incidencia(
                        this.vista_agregar_incidencia.getCmb_estadoIncidencia().getSelectedItem().toString(),
                        this.vista_agregar_incidencia.getCmb_tipoIncidencia().getSelectedItem().toString(),
                        idSocio
                );

                if (resultado) {
                    JOptionPane.showMessageDialog(vista_agregar_incidencia, "Incidencia agregada correctamente.");
                    this.vista_agregar_incidencia.dispose();
                    mostrarIncidencias();
                } else {
                    JOptionPane.showMessageDialog(vista_agregar_incidencia, "Error al agregar");
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista_agregar_incidencia,
                    "Selecciona un socio para agregar incidencias",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    //Funcion para eliminar incidencias.

    public void eliminarIncidencia() {
        // obtenemos la fila seleccionada en la tabla
        int filSeleccionada = this.vista_incidencias.getTable_socios_incidencias().getSelectedRow();
        if (filSeleccionada != -1) {
            // obtenemos valor primera columna (0)
            int idSocio = (int) this.datos_tabla.getValueAt(filSeleccionada, 0);

            if (this.modelo_incidencias.buscarPorIdIncidencias(idSocio) != null) {
                int resultado = JOptionPane.showConfirmDialog(vista_agregar_incidencia,
                        "Estas seguro de eliminar esta incidencia del socio con id : " + idSocio,
                        "Eliminar",
                        JOptionPane.YES_NO_OPTION);
                if (resultado == JOptionPane.YES_OPTION) {
                    this.modelo_incidencias.eliminarPorIdIncidencia(idSocio);
                    JOptionPane.showMessageDialog(vista_agregar_incidencia,
                            "El socio con id " + idSocio,
                            "eliminado con exito.",
                            JOptionPane.INFORMATION_MESSAGE);
                    mostrarIncidencias();
                }
            } else {
                JOptionPane.showMessageDialog(vista_agregar_incidencia,
                        "No existe la id" + idSocio,
                        "No se puede borrar",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    //FUNCION PARA VALIDAR LOS DATOS.
    public boolean validarDatos() {
        boolean resultado = true;
        String mensaje = "";

        if (this.vista_agregar_incidencia.getCmb_estadoIncidencia().getSelectedIndex() == 0) {
            mensaje += "Selecciona un estado de incidencia.\n";
            resultado = false;
        }
        if (this.vista_agregar_incidencia.getCmb_tipoIncidencia().getSelectedIndex() == 0) {
            mensaje += "Selecciona un tipo de incidencia.\n";
            resultado = false;
        }

        if (!resultado) {
            JOptionPane.showMessageDialog(vista_agregar_incidencia, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    // funcion para cargar datos bbdd
    public ArrayList<Incidencias> cargarIncidencias() {
        ArrayList<Incidencias> array_incidencias = new ArrayList<>();
        Connection con = ConexionBD.conectar();
        if (con == null) {
            System.err.println("Error al conectar a la base de datos");
        }

        // consulta
        String sql = "SELECT s.idSocio, "
                + "s.nombre, "
                + "s.apellido, "
                + "i.id_incidencia, "
                + "i.estado_incidencia, "
                + "i.tipo_incidencia "
                + "FROM socios s "
                + "LEFT JOIN "
                + "incidencias i ON s.idSocio = i.idSocio;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql); // consulta preparada
            ResultSet resultado = stmt.executeQuery(); // resultado consulta
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int id_incidencia = resultado.getInt("id_incidencia");
                String estado_incidencia = resultado.getString("estado_incidencia");
                String tipo_incidencia = resultado.getString("tipo_incidencia");
                int idSocio = resultado.getInt("idSocio");

                Incidencias incidencias = new Incidencias(nombre, apellido, id_incidencia, estado_incidencia, tipo_incidencia, idSocio);
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
                pintar_incidencias.getIdSocio(),
                pintar_incidencias.getNombreSocio(),
                pintar_incidencias.getApellidosSocio(),
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
