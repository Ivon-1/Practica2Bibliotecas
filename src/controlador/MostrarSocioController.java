/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.SocioModelo;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelo.ConexionBD;
import modelo.Socio;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.IncidenciasModelo;
import vista.AgregarLibroView;
import vista.ComprobarIncidenciasView;
import vista.MenuView;
import vista.SocioAgregarView;
import vista.SociosView;

/**
 *
 * @author IvanA
 */
public class MostrarSocioController implements ActionListener {

    // instancias de modelo y vista
    private SocioModelo modelo_socio;
    private SociosView vista_socio;
    private DefaultTableModel datos_tabla_socio;
    private SocioAgregarView socio_view;
    private MenuView vista_menu;
    private IncidenciasModelo modelo_incidencias;
    private ComprobarIncidenciasView vista_incidencias;

    // funcion para mostrar
    public MostrarSocioController(SocioModelo modelo_socio, SociosView vista_socio, SocioAgregarView socio_view, MenuView vista_menu, ComprobarIncidenciasView vista_incidencias, IncidenciasModelo modelo_incidencias) {
        this.modelo_socio = modelo_socio;
        this.vista_socio = vista_socio;
        this.socio_view = socio_view;
        this.vista_menu = vista_menu;
        this.vista_incidencias = vista_incidencias;
        this.modelo_incidencias = modelo_incidencias;
        datos_tabla_socio = (DefaultTableModel) this.vista_socio.getTable_socios().getModel();
        // funcion activar botones
        addButtons();
        // funcion para mostrar socios
        mostrarSocios();
        //--------
        this.vista_socio.setVisible(true);
    }
    
    /**
     * funcion para activar botones
     */
    public void addButtons(){
        this.vista_socio.getBtn_agregarSocio().addActionListener(this);
        this.vista_socio.getBtn_eliminarSocio().addActionListener(this);
        this.vista_socio.getBtn_buscarSocios().addActionListener(this);
        this.vista_socio.getBtn_modificar_socio().addActionListener(this);
        this.vista_socio.getBtn_incidencias().addActionListener(this);
        this.socio_view.getBtn_agregar().addActionListener(this);
        this.vista_socio.getBtn_volver_socio().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verificar cuál botón fue presionado
        if (e.getSource() == this.vista_socio.getBtn_agregarSocio()) {
            // Mostrar la vista de agregar socio
            this.socio_view.setVisible(true);
        }

        if (e.getSource() == this.socio_view.getBtn_agregar()) {
            agregarSocios();// Llamar al método para agregar el socio cuando se presione el botón en la ventana de agregar

        }

        if (e.getSource() == this.vista_socio.getBtn_eliminarSocio()) {
            // Llamar al método de eliminar cuando se presione el botón de eliminar
            eliminar_socios();
        }

        if (e.getSource() == this.vista_socio.getBtn_buscarSocios()) {
            buscarSocios();
        }
        
        if (e.getSource() == this.vista_socio.getBtn_incidencias()) {
           this.vista_incidencias.setVisible(true);
           
           
        }

        if (e.getSource() == this.vista_socio.getBtn_volver_socio()) {
            this.vista_socio.setVisible(false);
            this.vista_menu.setVisible(true);
        }
        
       

        // Otros botones (modificar, buscar) pueden ser manejados aquí de la misma manera
    }

    public void agregarSocios() {
        if (validarDatos()) {
            if (this.modelo_socio.agregar_socio(
                    this.socio_view.getTxt_nombre().getText(),
                    this.socio_view.getTxt_apellido().getText(),
                    this.socio_view.getTxt_correo().getText(),
                    this.socio_view.getTxt_dni().getText(),
                    Integer.parseInt(this.socio_view.getTxt_telefono().getText()),
                    this.socio_view.getTxt_direccion().getText())) {

                JOptionPane.showMessageDialog(socio_view, "Agregado correctamente.");
                this.socio_view.dispose();
            } else {
                JOptionPane.showMessageDialog(socio_view, "Error al agregar.");
            }
        }
    }

    //Funcion para eliminar socios.
    public void eliminar_socios() {
        String idSocio = JOptionPane.showInputDialog(socio_view,
                "Introduzca la id  que desea eliminar ",
                "Eliminar",
                JOptionPane.ERROR_MESSAGE);

        if (idSocio != null) {
            if (this.modelo_socio.buscarPorId(Integer.parseInt(idSocio)) != null) {
                int resultado = JOptionPane.showConfirmDialog(socio_view,
                        "Estas seguro de eliminar esta id : " + idSocio,
                        "Eliminar",
                        JOptionPane.YES_NO_OPTION);

                if (resultado == JOptionPane.YES_OPTION) {
                    this.modelo_socio.eliminarPorId(Integer.parseInt(idSocio));
                    JOptionPane.showMessageDialog(socio_view,
                            "El socio con id " + idSocio,
                            " eliminado con exito.",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(socio_view,
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

        if (this.socio_view.getTxt_nombre().getText().trim().length() == 0) {
            mensaje += "Introduzca un nombre.\n";
            resultado = false;
        }
        if (this.socio_view.getTxt_apellido().getText().trim().length() == 0) {
            mensaje += "Introduzca un apellido.\n";
            resultado = false;
        }
        if (this.socio_view.getTxt_dni().getText().trim().length() == 0) {
            mensaje += "Introduzca un DNI.\n";
            resultado = false;
        }
        if (this.socio_view.getTxt_correo().getText().trim().length() == 0) {
            mensaje += "Introduzca un correo electrónico.\n";
            resultado = false;
        }
        if (this.socio_view.getTxt_telefono().getText().trim().length() == 0) {
            mensaje += "Introduzca un teléfono.\n";
            resultado = false;
        }
        if (this.socio_view.getTxt_direccion().getText().trim().length() == 0) {
            mensaje += "Introduzca una dirección.\n";
            resultado = false;
        }

        if (!resultado) {
            JOptionPane.showMessageDialog(socio_view, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    // funcion para cargar datos BBDD
    public ArrayList<Socio> cargarSociosBBDD() {
        ArrayList<Socio> array_socios = new ArrayList<>();
        Connection con = ConexionBD.conectar();
        if (con == null) {
            System.err.println("Error al conectar a la base de datos");
        }

        // consulta
        String sql = "Select * from socios";
        try {
            PreparedStatement stmt = con.prepareStatement(sql); // consulta preparada
            ResultSet resultado = stmt.executeQuery(); // resultado consulta

            while (resultado.next()) {
                int idSocio = resultado.getInt("idSocio");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String correo = resultado.getString("correo");
                int telefono = resultado.getInt("telefono");
                String direccion = resultado.getString("direccion");
                String dni = resultado.getString("dni");

                Socio socios = new Socio(nombre, apellido, correo, dni, telefono, direccion); // PENDIENTE DE AÑADIR COSAS?
                socios.setIdSocio(idSocio);
                array_socios.add(socios);
            }
            // error por aqui proseguir despues
        } catch (Exception e) {
            System.err.println("Error al realizar la consulta");
            e.printStackTrace();
        } finally {
            //ConexionBD.cerrarConexion();
        }
        return array_socios;
    }

    // funcion para pintar libro
    public void pintarSocio(Socio pintar_socio) {
        if (pintar_socio != null) {
            datos_tabla_socio.addRow(new Object[]{
                pintar_socio.getIdSocio(),
                pintar_socio.getNombre(),
                pintar_socio.getApellido(),
                pintar_socio.getCorreo(),
                pintar_socio.getTelefono(),
                pintar_socio.getDireccion(),
                pintar_socio.getDni()}); // faltaria campos de las otras tablas.... PENDIENTE
        }
    }

    public void mostrarSocios() {
        ArrayList<Socio> socios = cargarSociosBBDD();
        datos_tabla_socio.setRowCount(0);
        for (Socio socio_actual : socios) {
            pintarSocio(socio_actual);
        }
    }

    /**
     * funciones busqueda
     */
    public void buscarSocios() {
        String filtro = vista_socio.getCmb_filtro_socios().getSelectedItem().toString();
        String valor = vista_socio.getTxt_espbusquedaSocio().getText();

        ArrayList<Socio> listaSocios = modelo_socio.buscarSocios(filtro, valor);
        llenarTabla(listaSocios);
    }

    private void llenarTabla(ArrayList<Socio> listaSocios) {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista_socio.getTable_socios().getModel();
        modeloTabla.setRowCount(0);

        for (Socio socio : listaSocios) {
            Object[] fila = {
                socio.getIdSocio(),
                socio.getNombre(),
                socio.getApellido(),
                socio.getCorreo(),
                socio.getTelefono(),
                socio.getDireccion(),
                socio.getDni()
            };
            modeloTabla.addRow(fila);
        }
    }
    
    
    
    
}
/**
 * funcion para volver al menuPrincipal
 */
