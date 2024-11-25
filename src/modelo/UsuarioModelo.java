package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sergi
 */
public class UsuarioModelo {

    public boolean validarUsuario(String idSofa, String descSofa, int tipo) {
        String query = "SELECT * FROM mobiliario WHERE id_sofa = ? AND desc_sofa = ? AND tipo = ?";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, idSofa);
            ps.setString(2, descSofa);
            ps.setInt(3, tipo);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();  // devuelve true si existe un registro que coincide
            }

        } catch (SQLException e) {
            System.err.println("Error al validar usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }   
}