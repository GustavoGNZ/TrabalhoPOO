package bd;

import base.Produz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProduzDAO {

    // Apenas insercao na producao 
    public void inserirProduz(Produz produz) throws Exception {
        String sql = "INSERT INTO PRODUZ (ID_Usuario, ID_Album) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, produz.getID_Usuario());
            pstm.setInt(2, produz.getID_Album());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produção inserida com sucesso!");

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

