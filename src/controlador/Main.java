/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.LoginController;
import modelo.ConexionBD;
import modelo.UsuarioModelo;
import vista.LoginView;

/**
 *
 * @author sergi
 */
public class Main {
    public static void main(String[] args) {
        ConexionBD.conectar();
        UsuarioModelo modeloUsuario = new UsuarioModelo();
        LoginView loginVista = new LoginView();
        new LoginController(loginVista, modeloUsuario);
    }
}
