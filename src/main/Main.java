/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controlador.LoginController;
import controlador.MostrarLibroController;
import modelo.ConexionBD;
import modelo.ModeloLibro;
import modelo.UsuarioModelo;
import vista.LibrosView;
import vista.LoginView;

/**
 *
 * @author sergi
 */
public class Main {

    public static void main(String[] args) {
        ConexionBD.conectar(); // conexion bbdd
        //instancias usuario - login 
        UsuarioModelo modeloUsuario = new UsuarioModelo();
        LoginView loginVista = new LoginView();
        // instancias libro y controlador
        
        // mostrar datos libros
        ModeloLibro modelo_libros = new ModeloLibro();
        LibrosView vista_libros = new LibrosView();
        MostrarLibroController controlador = new MostrarLibroController(modelo_libros, vista_libros);
        
        //new LoginController(loginVista, modeloUsuario);

    }
}
