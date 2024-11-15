/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.ModeloLibro;
import modelo.SocioModelo;
import modelo.UsuarioModelo;
import vista.LibrosView;
import vista.LoginView;
import vista.MenuView;
import vista.SocioAgregarView;
import vista.SociosView;

/**
 *
 * @author IvanA
 */
public class MenuPrincipalController implements ActionListener{

    // Instancias necesarias para conectar todo
    private ConexionBD conexionBD;
    private UsuarioModelo modeloUsuario;
    private ModeloLibro modelo_libros;
    private SocioModelo modelo_socio;
    // vistas
    private LoginView loginVista;
    private SociosView vista_principalSocios;
    private SocioAgregarView socioVista;
    private LibrosView vista_libros;
    private MenuView vista_menu;
    
    // controladores
    private MostrarLibroController controladorLibros;
    private LoginController controladorLogin;
    private MenuPrincipalController controladorPrincipal;
    private SocioController controladorSocio;
    private MostrarSocioController controladorPrincipalSocios;

    public MenuPrincipalController() {
        // modelos
        this.conexionBD = new ConexionBD();
        this.modeloUsuario = new UsuarioModelo();
        this.modelo_libros = new ModeloLibro();
        this.modelo_socio = new SocioModelo();
        // vistas
        this.loginVista = new LoginView();
        this.socioVista = new SocioAgregarView();
        this.vista_libros = new LibrosView();
        this.vista_menu = new MenuView();
        this.vista_principalSocios = new SociosView();
        // controladores añadir posteriormente en el action performed
        this.controladorLibros = new MostrarLibroController(modelo_libros, vista_libros);
        this.controladorLogin = new LoginController(loginVista, modeloUsuario);
        this.controladorSocio = new SocioController(modelo_socio, socioVista);
        this.controladorPrincipalSocios = new MostrarSocioController(modelo_socio, vista_principalSocios);
        // activacion de botones cuando los haya en la pantalla principal
        addButtones();
        //--------------- poner en true sobre la vista principal
        this.vista_menu.setVisible(true);
    }

    // funcion en la que activar los botones de la pagina principal
    public void addButtones() {
        this.vista_menu.getBtn_agregar_principal().addActionListener(this);
        this.vista_menu.getBtn_consultarBibilioteca().addActionListener(this);
        this.vista_menu.getBtn_ConsultarSocio().addActionListener(this);
        this.vista_menu.getBtn_Administracion().addActionListener(this);
        this.vista_menu.getBtn_GestionPrincipal().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object button = e.getSource();
        if (e.getSource() == this.vista_menu.getBtn_agregar_principal()) {
            
        }
        if(button == this.vista_menu.getBtn_consultarBibilioteca()){ // mostrar libros
            new MostrarLibroController(modelo_libros, vista_libros);
        }
        if (button == this.vista_menu.getBtn_ConsultarSocio()) {// mostrar socios
            new MostrarSocioController(modelo_socio, vista_principalSocios);
        }
    }

}
