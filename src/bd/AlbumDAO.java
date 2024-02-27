package bd;

import base.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlbumDAO {

    public void inserirAlbum(Album album) throws Exception {
        String sql = "INSERT INTO Album(ID_Album, nome, ano) "
                + "VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, album.getID_Album());
            pstm.setString(2, album.getNome());
            pstm.setInt(3, album.getAno());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Album salvo com sucesso!");

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

    public void deletarAlbum(int ID_Album) throws Exception {
        String sql = "DELETE FROM Album WHERE ID_Album = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Album);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Album deletado com sucesso!");

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

    public void atualizarAlbum(Album album) throws Exception {
        String sql = "UPDATE Album SET nome = ?, ano = ? WHERE ID_Album = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, album.getNome());
            pstm.setInt(2, album.getAno());
            pstm.setInt(3, album.getID_Album());

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Album atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum album foi atualizado.");
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

    public Album buscarAlbum(int ID_Album) throws Exception {
        String sql = "SELECT * FROM Album WHERE ID_Album = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Album albumEncontrado = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Album);
            rs = pstm.executeQuery();

            if (rs.next()) {
                albumEncontrado = new Album();
                albumEncontrado.setID_Album(rs.getInt("ID_Album"));
                albumEncontrado.setNome(rs.getString("nome"));
                albumEncontrado.setAno(rs.getInt("ano"));
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
        return albumEncontrado;
    }
}
