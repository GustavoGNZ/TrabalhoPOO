package bd;

import base.Assinatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AssinaturaDAO {

    public void inserirAssinatura(Assinatura assinatura) throws Exception {
        String sql = "INSERT INTO ASSINATURA(ID_Assinatura, tipoAssinatura, Valor) "
                + "VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, assinatura.getID_Assinatura());
            pstm.setString(2, assinatura.getTipoAssinatura());
            pstm.setDouble(3, assinatura.getValor());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Assinatura salva com sucesso!");

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

    public void deletarAssinatura(int ID_Assinatura) throws Exception {
        String sql = "DELETE FROM ASSINATURA WHERE ID_Assinatura = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Assinatura);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Assinatura deletada com sucesso!");

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

    public void atualizarAssinatura(Assinatura assinatura) throws Exception {
        String sql = "UPDATE ASSINATURA SET tipoAssinatura = ?, Valor = ? WHERE ID_Assinatura = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, assinatura.getTipoAssinatura());
            pstm.setDouble(2, assinatura.getValor());
            pstm.setInt(3, assinatura.getID_Assinatura());

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Assinatura atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma assinatura foi atualizada.");
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

    public Assinatura buscarAssinatura(int ID_Assinatura) throws Exception {
        String sql = "SELECT * FROM ASSINATURA WHERE ID_Assinatura = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Assinatura assinaturaEncontrada = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID_Assinatura);
            rs = pstm.executeQuery();

            if (rs.next()) {
                assinaturaEncontrada = new Assinatura();
                assinaturaEncontrada.setID_Assinatura(rs.getInt("ID_Assinatura"));
                assinaturaEncontrada.setTipoAssinatura(rs.getString("tipoAssinatura"));
                assinaturaEncontrada.setValor(rs.getDouble("valor"));
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
        return assinaturaEncontrada;
    }
}
