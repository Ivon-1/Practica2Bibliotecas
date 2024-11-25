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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.Trabajador;
import modelo.TrabajadorModelo;
import vista.AdministracionView;
import vista.AgregarTrabajadorView;
import vista.MenuView;

/**
 *
 * @author sergi
 */
public class MostrarTrabajadorController implements ActionListener {

    private TrabajadorModelo modelo_trabajador;
    private AdministracionView vista_trabajador;
    private DefaultTableModel datos_tabla_trabajador;
    private AgregarTrabajadorView trabajadorAgregar_view; // Vista de aaron agregartrabajadorView.
    private MenuView vista_menu;

    public MostrarTrabajadorController(TrabajadorModelo modelo_trabajador, AdministracionView vista_trabajador, AgregarTrabajadorView trabajadorAgregar_view, MenuView vista_menu) {
        this.modelo_trabajador = modelo_trabajador;
        this.vista_trabajador = vista_trabajador;
        this.vista_menu = vista_menu;
        this.trabajadorAgregar_view = trabajadorAgregar_view; // Vista de aaron agregarTrabajadorView.

        datos_tabla_trabajador = (DefaultTableModel) this.vista_trabajador.getTable_trabajadores().getModel();
        addButtons();
        mostrarTrabajadores();
        this.vista_trabajador.setVisible(true);

    }

    public void addButtons() {
        this.vista_trabajador.getBtn_agregarTrabajador().addActionListener(this);
        this.vista_trabajador.getBtn_buscarTrabajador().addActionListener(this);
        this.vista_trabajador.getBtn_eliminarTrabajador().addActionListener(this);
        this.vista_trabajador.getBtn_volverTrabajador().addActionListener(this);
        this.vista_trabajador.getBtn_modificarTrabajador().addActionListener(this);
        this.trabajadorAgregar_view.getBtn_agregarTrabajador2().addActionListener(this); // agregar vista agregar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista_trabajador.getBtn_agregarTrabajador()) {
            trabajadorAgregar_view.setVisible(true);
        }

        if (e.getSource() == this.vista_trabajador.getBtn_eliminarTrabajador()) {
            eliminar_trabajador();
        }

        if (e.getSource() == this.vista_trabajador.getBtn_buscarTrabajador()) {
            buscarTrabajadores();
        }

        if (e.getSource() == this.vista_trabajador.getBtn_volverTrabajador()) {
            this.vista_trabajador.setVisible(false);
            this.vista_menu.setVisible(true);
        }
        
        if (e.getSource() == this.trabajadorAgregar_view.getBtn_agregarTrabajador2()) {
            agregarTrabajadores();
        }
    }

    /**
     * Agregar trabajadores
     */
    public void agregarTrabajadores() {
        if (validarDatos()) {
            if (this.modelo_trabajador.agregar_trabajador(this.trabajadorAgregar_view.getTxt_nombreTrabajador().getText(),
                    this.trabajadorAgregar_view.getTxt_apellidoTrabajador().getText(),
                    this.trabajadorAgregar_view.getTxt_correoTrabajador().getText(),
                    Integer.parseInt(this.trabajadorAgregar_view.getTxt_telefonoTrabajador().getText()))) {
                JOptionPane.showMessageDialog(trabajadorAgregar_view, "Agregado correctamente.");
                this.trabajadorAgregar_view.dispose();
            } else {
                JOptionPane.showMessageDialog(trabajadorAgregar_view, "Error al agregar.");
            }
        }
    }

    //Funcion para eliminar trabajadores.
    public void eliminar_trabajador() {
        String idTrabajador = JOptionPane.showInputDialog(trabajadorAgregar_view,
                "Introduzca la id  que desea eliminar ",
                "Eliminar",
                JOptionPane.ERROR_MESSAGE);

        if (idTrabajador != null) {
            if (this.modelo_trabajador.buscarPorId(Integer.parseInt(idTrabajador)) != null) {
                int resultado = JOptionPane.showConfirmDialog(trabajadorAgregar_view,
                        "Estas seguro de eliminar esta id : " + idTrabajador,
                        "Eliminar",
                        JOptionPane.YES_NO_OPTION);

                if (resultado == JOptionPane.YES_OPTION) {
                    this.modelo_trabajador.eliminarPorId(Integer.parseInt(idTrabajador));
                    JOptionPane.showMessageDialog(trabajadorAgregar_view,
                            "El trabajador con id " + idTrabajador,
                            " eliminado con exito.",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(trabajadorAgregar_view,
                        "No existe la id" + idTrabajador,
                        "No se puede borrar",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //FUNCION PARA VALIDAR LOS DATOS.
    public boolean validarDatos() {
        boolean resultado = true;
        String mensaje = "";

        if (this.trabajadorAgregar_view.getTxt_nombreTrabajador().getText().trim().length() == 0) {
            mensaje += "Introduzca un nombre.\n";
            resultado = false;
        }
        if (this.trabajadorAgregar_view.getTxt_apellidoTrabajador().getText().trim().length() == 0) {
            mensaje += "Introduzca un apellido.\n";
            resultado = false;
        }
        if (this.trabajadorAgregar_view.getTxt_correoTrabajador().getText().trim().length() == 0) {
            mensaje += "Introduzca un correo electrónico.\n";
            resultado = false;
        }
        if (this.trabajadorAgregar_view.getTxt_telefonoTrabajador().getText().trim().length() == 0) {
            mensaje += "Introduzca un teléfono.\n";
            resultado = false;
        }

        /*if (this.trabajadorAgregar_view.getTxt_mobiliarioTrabajador().getText().trim().length() == 0) {
            mensaje += "Introduzca una id .\n";
            resultado = false;
        }*/
        if (!resultado) {
            JOptionPane.showMessageDialog(trabajadorAgregar_view, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
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
                trabajador.getTelefono()};
            modeloTabla.addRow(fila);
        }
    }

    /**
     * funcion cargar de BD
     *
     * @return
     */
    public ArrayList<Trabajador> cargarTrabajadoresBBDD() {
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        Connection con = ConexionBD.conectar();

        if (con == null) {
            System.err.println("Error al conectar a la base de datos");
            return trabajadores;
        }

        String sql = "SELECT idTrabajador, nombre, apellido, correo, telefono  FROM trabajadores";

        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet resultado = stmt.executeQuery()) {
            while (resultado.next()) {
                Trabajador trabajador = new Trabajador(
                        resultado.getInt("idTrabajador"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("correo"),
                        resultado.getInt("telefono")
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
            trabajador.getTelefono()
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
