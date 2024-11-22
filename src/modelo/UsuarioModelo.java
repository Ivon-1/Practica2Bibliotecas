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
                return rs.next();  // Retorna true si existe un registro que coincide
            }

        } catch (SQLException e) {
            System.err.println("Error al validar usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }   
    
    
    public static boolean verificarCredenciales(String id_sofa, String desc_sofa, int tipo) {
        Connection connection = ConexionBD.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM mobiliario WHERE id_sofa = ? AND desc_sofa = ? AND tipo = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, id_sofa);
            ps.setString(2, desc_sofa);
            ps.setInt(3, tipo);

            rs = ps.executeQuery();

            // Si se encuentra una fila, las credenciales son correctas
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.err.println("Error al verificar credenciales: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return false;
    }
}