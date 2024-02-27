package bd;

import base.Compoe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CompoeDAO {

    public void inserirCompoe(Compoe compoe) throws Exception {
        String sql = "INSERT INTO COMPOE (ID_Musica, ID_Usuario) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, compoe.getID_Musica());
            pstm.setInt(2, compoe.getID_Usuario());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Composição inserida com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex);
            }
        }
    }
}
