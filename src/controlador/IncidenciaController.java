/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.IncidenciasModelo;
import vista.AgregarIncidenciaView;
import vista.ComprobarIncidenciasView;
import vista.MenuView;

/**
 *
 * @author IvanA
 */
public class IncidenciaController  implements ActionListener{

    private IncidenciasModelo modelo_incidencias;
    private ComprobarIncidenciasView vista_incidencias;
    private DefaultTableModel tabla_incidencias;
    private AgregarIncidenciaView vista_agregar_incidencia;
    // instancia vista agregar incidencia

    public IncidenciaController(IncidenciasModelo modelo_incidencias, ComprobarIncidenciasView vista_incidencias, DefaultTableModel tabla_incidencias, AgregarIncidenciaView vista_agregar_incidencia) {
        this.modelo_incidencias = modelo_incidencias;
        this.vista_incidencias = vista_incidencias;
        this.tabla_incidencias = tabla_incidencias;
        this.vista_agregar_incidencia = vista_agregar_incidencia;
        this.tabla_incidencias = (DefaultTableModel) this.vista_incidencias.getTable_socios_incidencias().getModel();
        // escucha botones
        addButtones();
        // funcion para mostrar incidencias
        
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
        
    }
    
    

}
