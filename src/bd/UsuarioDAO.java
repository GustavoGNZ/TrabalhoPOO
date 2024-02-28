package bd;

import base.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (DataNascimento, Email, Nome, Senha, usuario, ID_Usuario, dataInicio, dataFim, ID_Assinatura)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            double idIns = Math.round(Math.random()*100);
            
            int id = (int) idIns;
            
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setDate(1, new Date(usuario.getDataNasc().getTime()));
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getNome());
            pstm.setString(4, usuario.getSenha());
            pstm.setString(5, usuario.getUsuario());
            pstm.setInt(6, id);
            pstm.setDate(7, null);
            pstm.setDate(8, null);
            pstm.setInt(9, 0);

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso! Seu ID Usuario:" + id);

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
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex);
            }
        }
    }

    public void deletarUsuario(int id) {
    Connection conn = null;
    PreparedStatement pstm = null;

    try {
        conn = ConexaoBD.criarConexao();
        conn.setAutoCommit(false); // Inicia uma transação

        // Em seguida, exclui o usuário na tabela USUARIO
        String deleteUsuarioSql = "DELETE FROM USUARIO WHERE ID_Usuario = ?";
        pstm = conn.prepareStatement(deleteUsuarioSql);
        pstm.setInt(1, id);
        pstm.executeUpdate();

        conn.commit(); // Confirma a transação
        JOptionPane.showMessageDialog(null, "Usuário e seus dados relacionados deletados com sucesso!");
    } catch (Exception ex) {
        if (conn != null) {
            try {
                conn.rollback(); // Desfaz a transação se ocorrer um erro
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Erro: " + ex);
    } finally {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.setAutoCommit(true); // Restaura o modo de auto-commit
                conn.close();
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
        }
    }
}


    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE USUARIO SET Email = ?, Senha = ? WHERE ID_Usuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getSenha());
            pstm.setInt(3, usuario.getID_Usuario());

            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum usuário foi atualizado.");
            }
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
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex);
            }
        }
    }

    public Usuario buscarUsuario(String usuario) {
        String sql = "SELECT * FROM USUARIO WHERE usuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Usuario usuarioEncontrado = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario);
            rs = pstm.executeQuery();

            if (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setID_Usuario(rs.getInt("ID_Usuario"));
                usuarioEncontrado.setNome(rs.getString("Nome"));
                usuarioEncontrado.setEmail(rs.getString("Email"));
                usuarioEncontrado.setUsuario(rs.getString("usuario"));
                usuarioEncontrado.setSenha(rs.getString("Senha"));
                usuarioEncontrado.setDataNasc(rs.getDate("DataNascimento"));
                usuarioEncontrado.setDataInicio(rs.getDate("dataInicio"));
                usuarioEncontrado.setDataFim(rs.getDate("dataFim"));
                usuarioEncontrado.setID_Assinatura(rs.getInt("ID_Assinatura"));
            }
        } catch (Exception ex) {
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
            }catch (SQLException ex) {
                System.out.println("Erro: " + ex);
            }
        }
        return usuarioEncontrado;
    }
}