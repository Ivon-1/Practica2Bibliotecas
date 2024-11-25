/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.IncidenciasModelo;
import modelo.LibroModelo;
import modelo.SocioModelo;
import modelo.TrabajadorModelo;
import modelo.UsuarioModelo;
import vista.AdministracionView;
import vista.AgregarIncidenciaView;
import vista.AgregarLibroView;
import vista.ComprobarIncidenciasView;
import vista.LibrosView;
import vista.LoginView;
import vista.MenuView;
import vista.SocioAgregarView;
import vista.SociosView;

/**
 *
 * @author IvanA
 */
public class MenuPrincipalController implements ActionListener {
    //login
    private int tipoUsuario;
    // Instancias necesarias para conectar todo
    private ConexionBD conexionBD;
    private UsuarioModelo modeloUsuario;
    private LibroModelo modelo_libros;
    private SocioModelo modelo_socio;
    private TrabajadorModelo modelo_trabajador;
    // vistas
    private LoginView loginVista;
    private SociosView vista_principalSocios;
    private AgregarLibroView agregar_libro;
    private SocioAgregarView socioVista;
    private LibrosView vista_libros;
    private MenuView vista_menu;
    private ComprobarIncidenciasView vista_incidencias;
    private IncidenciasModelo modelo_incidencias;
    private DefaultTableModel tabla_incidencias;
    private AgregarIncidenciaView agregar_incidencias;
    private AdministracionView view_administracion;

    // controladores
    private MostrarLibroController controladorLibros;
    private LoginController controladorLogin;
    private MenuPrincipalController controladorPrincipal;
    private SocioController controladorSocio;
    private MostrarSocioController controladorPrincipalSocios;
    private IncidenciaController controladorIncidencia;
    private MostrarTrabajadorController controladorTrabajador;

    /*
    controlador del menu principal
     */
    public MenuPrincipalController(int tipoUsuario) {
        // modelos
        this.conexionBD = new ConexionBD();
        this.modeloUsuario = new UsuarioModelo();
        this.modelo_libros = new LibroModelo();
        this.modelo_socio = new SocioModelo();
        this.modelo_incidencias = new IncidenciasModelo();
        this.modelo_trabajador = new TrabajadorModelo();
        // vistas
        this.loginVista = new LoginView();
        this.vista_principalSocios = new SociosView();
        this.socioVista = new SocioAgregarView();
        this.tabla_incidencias = new DefaultTableModel(); // O tu lógica de inicialización
        this.agregar_incidencias = new AgregarIncidenciaView();
        
        this.vista_incidencias = new ComprobarIncidenciasView();
        this.view_administracion = new AdministracionView();
        this.agregar_libro = new AgregarLibroView();
        this.vista_libros = new LibrosView();

        this.vista_menu = new MenuView();
        
        this.tipoUsuario = tipoUsuario;
        restriccionUsuario(); //bloquear acceso del btn_administracion
        this.agregar_libro.setVisible(false);
        this.vista_menu.setVisible(true);
        // activacion de botones cuando los haya en la pantalla principal
        addButtones();
        //--------------- poner en true sobre la vista principal
        this.vista_menu.setVisible(true);
        this.agregar_libro.setVisible(false);
     
        
    }

    /*
    funcion para activar los botones
     */
    public void addButtones() {
        this.vista_menu.getBtn_consultarBibilioteca().addActionListener(this);
        this.vista_menu.getBtn_ConsultarSocio().addActionListener(this);
        this.vista_menu.getBtn_Administracion().addActionListener(this);
        this.vista_menu.getBtn_GestionPrincipal().addActionListener(this);
        this.vista_menu.getBtn_cerrarSesion().addActionListener(this);
        //this.vista_menu.getBtn_GestionPrincipal().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object button = e.getSource();
        
        // login
        
        
        if (button == this.vista_menu.getBtn_Administracion()) {
            this.vista_menu.setVisible(false);
            this.view_administracion.setVisible(true);
            
            if(controladorTrabajador == null){
                controladorTrabajador = new MostrarTrabajadorController(
                        modelo_trabajador, 
                        view_administracion, 
                        vista_menu);
            }
        }

        
        if (button == this.vista_menu.getBtn_consultarBibilioteca()) { // mostrar libros
            this.vista_menu.setVisible(false); // ocultamos
            this.vista_libros.setVisible(true);
            if (controladorLibros == null) {
                controladorLibros = new MostrarLibroController(
                        modelo_libros,
                        vista_libros,
                        agregar_libro,
                        vista_menu);
            }
        } else if (button == this.vista_menu.getBtn_ConsultarSocio()) {// mostrar socios e incidencias
            this.vista_menu.setVisible(false);
            this.vista_principalSocios.setVisible(true);

            if (controladorIncidencia == null) {
                controladorIncidencia = new IncidenciaController(modelo_incidencias,
                        vista_principalSocios, 
                        vista_incidencias, 
                        tabla_incidencias,
                        agregar_incidencias);
            }

            if (controladorPrincipalSocios == null) {
                controladorPrincipalSocios = new MostrarSocioController(modelo_socio,
                        vista_principalSocios,
                        socioVista,
                        vista_menu,
                        vista_incidencias,
                        modelo_incidencias,
                        controladorIncidencia);
            }
        }
        
        if(e.getSource() == this.vista_menu.getBtn_cerrarSesion()){
            cerrarSesion();
        }
    }
    
    private void restriccionUsuario() {
        if (tipoUsuario == 1) { // Si es "usuario"
            this.vista_menu.getBtn_Administracion().setEnabled(false);
        }
    }
    
    private void cerrarSesion() {
        this.vista_menu.dispose();
        new LoginController(new LoginView(), new UsuarioModelo());
}
}
