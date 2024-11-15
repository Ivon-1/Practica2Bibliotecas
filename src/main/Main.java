/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controlador.LibroController;
import controlador.LoginController;
import controlador.MainController;
import controlador.MostrarLibroController;
import controlador.SocioController;
import modelo.ConexionBD;
import modelo.LibroModelo;
import modelo.SocioModelo;
import modelo.UsuarioModelo;
import vista.AgregarLibroView;
import vista.LibrosView;
import vista.LoginView;
import vista.SocioView;

/**
 *
 * @author sergi
 */
public class Main {

    public static void main(String[] args) {

        new MainController();

        ConexionBD.conectar(); // conexion bbdd
        // instancias usuario - login
        // UsuarioModelo modeloUsuario = new UsuarioModelo();
        // LoginView loginVista = new LoginView();
        //SocioView vista = new SocioView();
        //SocioModelo modelo = new SocioModelo();
        //SocioController controlador = new SocioController(modelo, vista);
        //vista.setVisible(true);
        // SocioView socioVista = new SocioView();
        // socioVista.setVisible(true);

        // instancias libro y controlador

        // mostrar datos libros
         //ModeloLibro modelo_libros = new ModeloLibro();
         LibroModelo modelo = new LibroModelo();
         AgregarLibroView agregar = new AgregarLibroView();
         LibrosView libros = new LibrosView();
         LibroController controlador =  new LibroController(modelo, agregar, libros);
         //MostrarLibroController controlador = new
         //MostrarLibroController(modelo_libros, vista_libros);

        // new LoginController(loginVista, modeloUsuario);

    }
}
