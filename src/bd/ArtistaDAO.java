package bd;

import base.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ArtistaDAO {

    public void inserirArtista(Artista artista) throws Exception {
        String sql = "INSERT INTO Artista(ID_Usuario, genero, remuneracao) "
                + "VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, artista.getID_Usuario());
            pstm.setString(2, artista.getGenero());
            pstm.setDouble(3, artista.getRemuneracao());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Artista salvo com sucesso!");

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

    public void deletarArtista(int ID_Usuario) throws Exception {
        String sql = "DELETE FROM Artista WHERE ID_Usuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Usuario);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Artista deletado com sucesso!");

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

    public void atualizarArtista(Artista artista) throws Exception {
        String sql = "UPDATE Artista SET genero = ?, remuneracao = ? WHERE ID_Usuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, artista.getGenero());
            pstm.setDouble(2, artista.getRemuneracao());
            pstm.setInt(3, artista.getID_Usuario());

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Artista atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum artista foi atualizado.");
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

    public Artista buscarArtista(int ID_Usuario) throws Exception {
        String sql = "SELECT * FROM Artista WHERE ID_Usuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Artista artistaEncontrado = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Usuario);
            rs = pstm.executeQuery();

            if (rs.next()) {
                artistaEncontrado = new Artista();
                artistaEncontrado.setID_Usuario(rs.getInt("ID_Usuario"));
                artistaEncontrado.setGenero(rs.getString("genero"));
                artistaEncontrado.setRemuneracao(rs.getDouble("remuneracao"));
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
        return artistaEncontrado;
    }
}
