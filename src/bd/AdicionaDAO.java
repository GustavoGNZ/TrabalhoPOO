package bd;

import base.Adiciona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdicionaDAO {

    public void adicionaPlaylist(Adiciona adiciona) throws Exception {
        String sql = "INSERT INTO ADICIONA(ID_Musica, ID_Playlist) "
                + "VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, adiciona.getID_Musica());
            pstm.setInt(2, adiciona.getID_Playlist());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Musica Adicionada com Sucesso!");

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

    public void removePlaylist(Adiciona adiciona) throws Exception {
        String sql = "DELETE FROM ADICIONA WHERE ID_Musica = ? AND ID_Playlist = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, adiciona.getID_Musica());
            pstm.setInt(2, adiciona.getID_Playlist());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Musica Removida com Sucesso!");

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
