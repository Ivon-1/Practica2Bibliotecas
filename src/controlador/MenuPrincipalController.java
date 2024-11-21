/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.LibroModelo;
import modelo.SocioModelo;
import modelo.UsuarioModelo;
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

    // Instancias necesarias para conectar todo
    private ConexionBD conexionBD;
    private UsuarioModelo modeloUsuario;
    private LibroModelo modelo_libros;
    private SocioModelo modelo_socio;
    // vistas
    private LoginView loginVista;
    private SociosView vista_principalSocios;
    private AgregarLibroView agregar_libro;
    private SocioAgregarView socioVista;
    private LibrosView vista_libros;
    private MenuView vista_menu;
    private ComprobarIncidenciasView vista_incidencias;

    // controladores
    private MostrarLibroController controladorLibros;
    private LoginController controladorLogin;
    private MenuPrincipalController controladorPrincipal;
    private SocioController controladorSocio;
    private MostrarSocioController controladorPrincipalSocios;
    private IncidenciaController controladorIncidencia;

    /*
    controlador del menu principal
     */
    public MenuPrincipalController() {
        // modelos
        this.conexionBD = new ConexionBD();
        this.modeloUsuario = new UsuarioModelo();
        this.modelo_libros = new LibroModelo();
        this.modelo_socio = new SocioModelo();
        // vistas
        this.loginVista = new LoginView();
        this.vista_principalSocios = new SociosView();
        this.socioVista = new SocioAgregarView();

        this.agregar_libro = new AgregarLibroView();
        this.vista_libros = new LibrosView();
        this.vista_incidencias = new ComprobarIncidenciasView();

        this.vista_menu = new MenuView();

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
        this.vista_menu.getBtn_GestionPrincipal().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object button = e.getSource();

        if (button == this.vista_menu.getBtn_consultarBibilioteca()) { // mostrar libros
            this.vista_menu.setVisible(false); // ocultamos
            this.vista_libros.setVisible(true);
            if (controladorLibros == null) {
                controladorLibros = new MostrarLibroController(modelo_libros, vista_libros, agregar_libro, vista_menu);
            }
        } else if (button == this.vista_menu.getBtn_ConsultarSocio()) {// mostrar socios
            this.vista_menu.setVisible(false);
            this.vista_principalSocios.setVisible(true);
            if (controladorPrincipalSocios == null) {
                controladorPrincipalSocios = new MostrarSocioController(modelo_socio, vista_principalSocios, socioVista, vista_menu,vista_incidencias);
            }
            
            
        }

    }
}
