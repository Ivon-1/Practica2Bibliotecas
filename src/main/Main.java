/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controlador.LibroController;
import controlador.LoginController;
import controlador.MenuPrincipalController;
import controlador.MostrarLibroController;
//import controlador.SocioController;
import modelo.ConexionBD;
import modelo.LibroModelo;
import modelo.SocioModelo;
import modelo.UsuarioModelo;
import vista.AgregarLibroView;
import vista.LibrosView;
import vista.LoginView;
import vista.SocioAgregarView;

/**
 *
 * @author sergi
 */
public class Main {

    public static void main(String[] args) {
        new MenuPrincipalController();
    }
}
