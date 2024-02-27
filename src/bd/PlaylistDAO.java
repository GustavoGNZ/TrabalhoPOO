package bd;

import base.Playlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PlaylistDAO {

    public void inserirPlaylist(Playlist playlist) throws Exception {
        String sql = "INSERT INTO PLAYLIST(Nome, Descricao, ID_Playlist, ID_Usuario) "
                + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, playlist.getNome());
            pstm.setString(2, playlist.getDescricao());
            pstm.setInt(3, playlist.getID_Playlist());
            pstm.setInt(4, playlist.getID_Usuario());

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
    String deleteAdicionaSql = "DELETE FROM ADICIONA WHERE ID_Playlist = ?";
    String deletePlaylistSql = "DELETE FROM PLAYLIST WHERE ID_Playlist = ?";
    Connection conn = null;
    PreparedStatement deleteAdicionaPstm = null;
    PreparedStatement deletePlaylistPstm = null;

    try {
        conn = ConexaoBD.criarConexao();
        conn.setAutoCommit(false); // Start a transaction

        // Delete associated rows in the ADICIONA table
        deleteAdicionaPstm = conn.prepareStatement(deleteAdicionaSql);
        deleteAdicionaPstm.setInt(1, ID_Playlist);
        deleteAdicionaPstm.executeUpdate();

        // Delete the playlist
        deletePlaylistPstm = conn.prepareStatement(deletePlaylistSql);
        deletePlaylistPstm.setInt(1, ID_Playlist);
        deletePlaylistPstm.executeUpdate();

        conn.commit(); // Commit the transaction
        JOptionPane.showMessageDialog(null, "Playlist deletada com sucesso!");
    } catch (SQLException ex) {
        if (conn != null) {
            try {
                conn.rollback(); // Rollback the transaction if an error occurs
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Erro: " + ex);
    } finally {
        try {
            if (deleteAdicionaPstm != null) {
                deleteAdicionaPstm.close();
            }
            if (deletePlaylistPstm != null) {
                deletePlaylistPstm.close();
            }
            if (conn != null) {
                conn.setAutoCommit(true); // Restore auto-commit mode
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
    }
}


    public void atualizarPlaylist(Playlist playlist) throws Exception {
        String sql = "UPDATE PLAYLIST Nome = ?, Descricao = ? WHERE ID_Playlist = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, playlist.getNome());
            pstm.setString(2, playlist.getDescricao());
            pstm.setInt(3, playlist.getID_Playlist());

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
