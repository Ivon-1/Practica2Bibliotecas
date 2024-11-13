package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sergi
 */
public class UsuarioModelo {

    public boolean validarUsuario(String idSofa, String descSofa, String tipo) {
        String query = "SELECT * FROM mobiliario WHERE id_sofa = ? AND desc_sofa = ?";
        
        try (Connection con = ConexionBD.conectar(); // Usar la conexión de ConexionBD
             PreparedStatement ps = con.prepareStatement(query)) {
             
            ps.setString(1, idSofa);
            ps.setString(2, descSofa);
            ps.setString(3, tipo);
            ResultSet rs = ps.executeQuery();
            
            return rs.next(); // devuelve true si encuentra un registro que coincide
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }   
}