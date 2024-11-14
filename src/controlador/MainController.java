/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.ModeloLibro;
import modelo.SocioModelo;
import modelo.UsuarioModelo;
import vista.LibrosView;
import vista.LoginView;
import vista.MenuView;
import vista.SocioView;

/**
 *
 * @author IvanA
 */
public class MainController implements ActionListener{

    // Instancias necesarias para conectar todo
    private ConexionBD conexionBD;
    private UsuarioModelo modeloUsuario;
    private ModeloLibro modelo_libros;
    private SocioModelo modelo_socio;
    // vistas
    private LoginView loginVista;
    private SocioView socioVista;
    private LibrosView vista_libros;
    private MenuView vista_menu;
    // controladores
    private MostrarLibroController controladorLibros;
    private LoginController controladorLogin;
    private MainController controladorPrincipal;
    private SocioController controladorSocio;

    public MainController() {
        // modelos
        this.conexionBD = new ConexionBD();
        this.modeloUsuario = new UsuarioModelo();
        this.modelo_libros = new ModeloLibro();
        this.modelo_socio = new SocioModelo();
        // vistas
        this.loginVista = new LoginView();
        this.socioVista = new SocioView();
        this.vista_libros = new LibrosView();
        this.vista_menu = new MenuView();
        // controladores añadir posteriormente en el action performed
        this.controladorLibros = new MostrarLibroController(modelo_libros, vista_libros);
        this.controladorLogin = new LoginController(loginVista, modeloUsuario);
        this.controladorSocio = new SocioController(modelo_socio, socioVista);
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
        if (button == this.vista_menu.getBtn_agregar_principal()) { // agregar???
            
        }else if(button == this.vista_menu.getBtn_consultarBibilioteca()){ // mostrar libros
            new MostrarLibroController(modelo_libros, vista_libros);
        }
    }

}
