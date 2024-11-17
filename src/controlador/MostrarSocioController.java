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

    // funcion para mostrar
    public MostrarSocioController(SocioModelo modelo_socio, SociosView vista_socio) {
        this.modelo_socio = modelo_socio;
        this.vista_socio = vista_socio;
        datos_tabla_socio = (DefaultTableModel) this.vista_socio.getTable_socios().getModel();
        // botones
        this.vista_socio.getBtn_agregarSocio();
        this.vista_socio.getBtn_eliminarSocio();
        this.vista_socio.getBtn_buscarSocios();
        this.vista_socio.getBtn_modificarSocio();
        // funcion para mostrar libros
        mostrarSocios();
        //---------
        this.vista_socio.setVisible(true);
    }

    // funcion para cargar datos BBDD
    // funcion para cargar datos bbdd
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
                String id_incidencia = resultado.getString("id_incidencia");
                String dni = resultado.getString("dni");

                Socio socios = new Socio(idSocio, nombre, apellido, correo, dni, telefono, direccion); // PENDIENTE DE AÑADIR COSAS?
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
                pintar_socio.getDireccion()}); // faltaria campos de las otras tablas.... PENDIENTE
        }
    }

    public void mostrarSocios() {
        ArrayList<Socio> socios = cargarSociosBBDD();
        datos_tabla_socio.setRowCount(0);
        for (Socio socio_actual : socios) {
            pintarSocio(socio_actual);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarSocios();
    }
}
