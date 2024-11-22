/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Trabajador;
import modelo.TrabajadorModelo;
import vista.AdministracionView;
import vista.MenuView;

/**
 *
 * @author sergi
 */
public class MostrarTrabajadorController implements ActionListener{
    private TrabajadorModelo modelo_trabajador;
    private AdministracionView vista_trabajador;
    private DefaultTableModel datos_tabla_trabajador;
    private MenuView vista_menu;

    public MostrarTrabajadorController(TrabajadorModelo modelo_trabajador, AdministracionView vista_trabajador, MenuView vista_menu) {
        this.modelo_trabajador = modelo_trabajador;
        this.vista_trabajador = vista_trabajador;
        this.vista_menu = vista_menu;
        
        datos_tabla_trabajador = (DefaultTableModel) this.vista_trabajador.getTable_trabajadores().getModel();
        addButtons();
        this.vista_trabajador.setVisible(true);

    }
    
    public void addButtons(){
        this.vista_trabajador.getBtn_agregarTrabajador().addActionListener(this);
        this.vista_trabajador.getBtn_buscarTrabajador().addActionListener(this);
        this.vista_trabajador.getBtn_eliminarTrabajador().addActionListener(this);
        this.vista_trabajador.getBtn_volverTrabajador().addActionListener(this);
        this.vista_trabajador.getBtn_modificarTrabajador().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista_trabajador.getBtn_agregarTrabajador()){
            
        }
        
        if(e.getSource() == this.vista_trabajador.getBtn_eliminarTrabajador()){
            
        }
        
        if(e.getSource() == this.vista_trabajador.getBtn_buscarTrabajador()){
            buscarSocios();
        }
        
        if(e.getSource() == this.vista_trabajador.getBtn_volverTrabajador()){
            this.vista_trabajador.setVisible(false);
            this.vista_menu.setVisible(true);
        }
    }
    
    
    /**
     * funciones busqueda
     */
    public void buscarSocios() {
        String filtro = vista_trabajador.getCmb_trabajador().getSelectedItem().toString();
        String valor = vista_trabajador.getTxt_busquedaTrabajador().getText();

        ArrayList<Trabajador> listaTrabajadores = modelo_trabajador.buscarTrabajadores(filtro, valor);
        llenarTabla(listaTrabajadores);
    }

    private void llenarTabla(ArrayList<Trabajador> listaTrabajadores) {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista_trabajador.getTable_trabajadores().getModel();
        modeloTabla.setRowCount(0);

        for (Trabajador trabajador : listaTrabajadores) {
            Object[] fila = {
                trabajador.getIdTrabajador(),
                trabajador.getNombre(),
                trabajador.getApellido(),
                trabajador.getCorreo(),
                trabajador.getTelefono(),
                trabajador.getId_mobiliario(),
            };
            modeloTabla.addRow(fila);
        }
    }
}
