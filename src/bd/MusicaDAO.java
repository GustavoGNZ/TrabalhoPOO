package bd;

import base.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class MusicaDAO {

    public void inserirMusica(Musica musica) {
        String sql = "INSERT INTO musica(ID_Musica,ID_Album,nome,duracao) "
                + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, musica.getID_Musica());
            pstm.setInt(2, musica.getID_Album());
            pstm.setString(3, musica.getNome());
            pstm.setDouble(4, musica.getDuracao());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
            }
        }

    }
    
    public boolean buscarMusica(String term) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM Musica WHERE nome = ?";

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, term);
            resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                conn.close();
                return true; // Found
            } else {
                conn.close();
                return false; // Not found
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false; // Error occurred
        } finally {
            // Close resources in finally block to ensure they're always closed
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void deletarMusica(int ID_Musica) {
        String sql = "DELETE FROM musica WHERE ID_Musica = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Musica);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Musica deletada com sucesso!");

        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("Erro: " + ex);
            }
        }
    }
    
    
    
    
}
