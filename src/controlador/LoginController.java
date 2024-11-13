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
        
        this.loginVista.getBtn_login().addActionListener(this);
        this.loginVista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        manejoLogin();
    }
    
    private void manejoLogin() {
        String userType = loginVista.getCmb_login().getSelectedItem().toString();
        String password = new String(loginVista.getTxt_pass().getPassword());
        String tipo = (String) loginVista.getCmb_login().getSelectedItem().toString();

        boolean isValid = modeloUsuario.validarUsuario(userType, password, tipo);
        
        if (isValid) {
            JOptionPane.showMessageDialog(loginVista, "Inicio de sesión exitoso", "Login", JOptionPane.INFORMATION_MESSAGE);
            // Aquí podrías redirigir al usuario a otra vista o pantalla.
        } else {
            JOptionPane.showMessageDialog(loginVista, "Credenciales incorrectas", "Login", JOptionPane.ERROR_MESSAGE);
        }
    }


    
    
}
