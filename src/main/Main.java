/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controlador.LoginController;
import controlador.MainController;
import controlador.MostrarLibroController;
import modelo.ConexionBD;

import modelo.ModeloLibro;

import modelo.SocioModelo;
import modelo.UsuarioModelo;
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
    }
}
