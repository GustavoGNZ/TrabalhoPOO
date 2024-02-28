    package bd;

import base.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class MusicaDAO {

    public void inserirMusica(Musica musica) {
        String sql = "INSERT INTO MUSICA(Nome, Duracao, ID_Musica, ID_Album) "
                + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, musica.getNome());
            pstm.setDouble(2, musica.getDuracao());
            pstm.setInt(3, musica.getID_Musica());
            pstm.setInt(4, musica.getID_Album());
     
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
    
    public Musica buscarMusica(String term) {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet resultSet = null;
    String sql = "SELECT * FROM MUSICA WHERE Nome = ?";
    Musica musicaEncontrada = null;

    try {
        conn = ConexaoBD.criarConexao();
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, term);
        resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            musicaEncontrada = new Musica();
            musicaEncontrada.setNome(resultSet.getString("Nome"));
            musicaEncontrada.setDuracao(resultSet.getDouble("Duracao"));
            musicaEncontrada.setID_Musica(resultSet.getInt("ID_Musica"));
            musicaEncontrada.setID_Album(resultSet.getInt("ID_Album"));
        }
    } catch (Exception ex) {
        ex.printStackTrace();
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
    
    return musicaEncontrada;
}

    
    
    public void deletarMusica(int ID_Musica) {
        String sql = "DELETE FROM MUSICA WHERE ID_Musica = ?";
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
    
    
    public void inserirMusicaAlbum(Musica musica) {
        String sql = "UPDATE MUSICA SET ID_Album = ? WHERE ID_Musica = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, musica.getID_Album());
            pstm.setInt(2, musica.getID_Musica());
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
    
}
