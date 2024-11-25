/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import controlador.LoginController;
import controlador.MenuPrincipalController;
import modelo.UsuarioModelo;
import vista.LoginView;
/**
 *
 * @author ivanA
 */
public class Main {

    public static void main(String[] args) {
        //new MenuPrincipalController();
        
        UsuarioModelo modeloUsuario = new UsuarioModelo();
        LoginView loginView = new LoginView();
        
        new LoginController(loginView, modeloUsuario);
    }
}
