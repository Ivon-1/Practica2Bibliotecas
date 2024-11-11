/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sergi
 */
public class UsuarioModelo {

    public boolean validateUser(String userType, String password) {
        String sql = "SELECT * FROM mobiliario WHERE tipo_usuario = ? AND password = ?";
        
        try (Connection con = ConexionBD.conectar(); // Usar la conexión de ConexionBD
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, userType);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            return rs.next(); // Retorna true si encuentra un registro que coincide
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }   
}
