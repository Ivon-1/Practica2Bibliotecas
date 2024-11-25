/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
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
        mostrarTrabajadores();
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
            buscarTrabajadores();
        }
        
        if(e.getSource() == this.vista_trabajador.getBtn_volverTrabajador()){
            this.vista_trabajador.setVisible(false);
            this.vista_menu.setVisible(true);
        }
    }
    
    
    /**
     * funciones busqueda
     */
    public void buscarTrabajadores() {
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
    
    /**
     * funcion cargar de BD
     * @return 
     */
    public ArrayList<Trabajador> cargarTrabajadoresBBDD() {
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        Connection con = ConexionBD.conectar();

        if (con == null) {
            System.err.println("Error al conectar a la base de datos");
            return trabajadores;
        }

        String sql = "SELECT idTrabajador, nombre, apellido, correo, telefono, id_mobiliario FROM trabajadores";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {
            while (resultado.next()) {
                Trabajador trabajador = new Trabajador(
                    resultado.getInt("idTrabajador"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("correo"),
                    resultado.getInt("telefono"),
                    resultado.getInt("id_mobiliario")
                );
                trabajadores.add(trabajador);
            }
        } catch (Exception e) {
            System.err.println("Error al realizar la consulta de trabajadores");
            e.printStackTrace();
        }

        return trabajadores;
    }
    
    /**
     * funcion para pintar un trabajador en la tabla
     */
    public void pintarTrabajador(Trabajador trabajador) {
        datos_tabla_trabajador.addRow(new Object[]{
            trabajador.getIdTrabajador(),
            trabajador.getNombre(),
            trabajador.getApellido(),
            trabajador.getCorreo(),
            trabajador.getTelefono(),
            trabajador.getId_mobiliario()
        });
    }
    
    /**
     * funcion para mostrar todos los trabajadores en la tabla
     */
    public void mostrarTrabajadores() {
        ArrayList<Trabajador> trabajadores = cargarTrabajadoresBBDD();
        datos_tabla_trabajador.setRowCount(0);
        for (Trabajador trabajador : trabajadores) {
            pintarTrabajador(trabajador);
        }
    }
}
