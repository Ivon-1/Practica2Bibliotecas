/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.UsuarioModelo;
import vista.LoginView;

/**
 *
 * @author sergi
 */
public class LoginController implements ActionListener{
    private LoginView loginVista;
    private UsuarioModelo modeloUsuario;

    public LoginController(LoginView loginVista, UsuarioModelo modeloUsuario) {
        this.loginVista = loginVista;
        this.modeloUsuario = modeloUsuario;
        this.loginVista.setVisible(true);
        
        
        this.loginVista.getBtn_login().addActionListener(this);
        this.loginVista.setTitle("Hola");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.loginVista.getBtn_login()){
            System.out.println("HOLAAAAAAAAAAA");
            manejoLogin();
        }
    }
    
    private void manejoLogin() {
        String userType = loginVista.getCmb_login().getSelectedItem().toString().toLowerCase();
        String password = new String(loginVista.getTxt_pass().getPassword());

        // Si no se ha seleccionado un tipo de usuario
        if (userType.equalsIgnoreCase("seleccione una opcion")) {
            JOptionPane.showMessageDialog(loginVista, "Por favor, selecciona un tipo de usuario.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // El tipo de usuario es 1 si es "usuario", 2 si es "administrador"
        int tipo = userType.equals("usuario") ? 1 : 2;

        // Verificamos las credenciales usando el modeloUsuario
        boolean isValid = modeloUsuario.validarUsuario(userType, password, tipo);

        // Dependiendo de si las credenciales son válidas o no
        if (isValid) {
            JOptionPane.showMessageDialog(loginVista, "Inicio de sesión exitoso.", "Login", JOptionPane.INFORMATION_MESSAGE);
            // Aquí podrías redirigir a otra vista o cambiar la ventana
        } else {
            JOptionPane.showMessageDialog(loginVista, "Credenciales incorrectas.", "Login", JOptionPane.ERROR_MESSAGE);
        }
    }
}
