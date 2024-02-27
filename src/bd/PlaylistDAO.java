package bd;

import base.Playlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PlaylistDAO {

    public void inserirPlaylist(Playlist playlist) throws Exception {
        String sql = "INSERT INTO playlist(ID_Playlist, ID_Usuario, nome, descricao) "
                + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, playlist.getID_Playlist());
            pstm.setInt(2, playlist.getID_Usuario());
            pstm.setString(3, playlist.getNome());
            pstm.setString(4, playlist.getDescricao());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Playlist salva com sucesso ID Playlist: " + playlist.getID_Playlist());

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

    public void deletarPlaylist(int ID_Playlist) throws Exception {
        String sql = "DELETE FROM Playlist WHERE ID_Playlist = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Playlist);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Playlist deletada com sucesso!");

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

    public void atualizarPlaylist(Playlist playlist) throws Exception {
        String sql = "UPDATE Playlist SET ID_Usuario = ?, nome = ?, descricao = ? WHERE ID_Playlist = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, playlist.getID_Usuario());
            pstm.setString(2, playlist.getNome());
            pstm.setString(3, playlist.getDescricao());
            pstm.setInt(4, playlist.getID_Playlist());

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Playlist atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma playlist foi atualizada.");
            }
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

    public Playlist buscarPlaylist(int ID_Playlist) throws Exception {
        String sql = "SELECT * FROM Playlist WHERE ID_Playlist = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Playlist playlistEncontrada = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Playlist);
            rs = pstm.executeQuery();

            if (rs.next()) {
                playlistEncontrada = new Playlist();
                playlistEncontrada.setID_Playlist(rs.getInt("ID_Playlist"));
                playlistEncontrada.setID_Usuario(rs.getInt("ID_Usuario"));
                playlistEncontrada.setNome(rs.getString("nome"));
                playlistEncontrada.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return playlistEncontrada;
    }
}
