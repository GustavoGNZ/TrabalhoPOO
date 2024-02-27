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
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setDate(1, new Date(usuario.getDataNasc().getTime()));
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getNome());
            pstm.setString(4, usuario.getSenha());
            pstm.setString(5, usuario.getUsuario());
            pstm.setDouble(6, usuario.getID_Usuario());
            pstm.setDate(7, new Date(usuario.getDataInicio().getTime()));
            pstm.setDate(8, new Date(usuario.getDataFim().getTime()));
            pstm.setInt(9, usuario.getID_Assinatura());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");

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

    public void deletarUsuario(double id) {
        String sql = "DELETE FROM USUARIO WHERE ID_Usuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, id);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");

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

    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE USUARIO SET DataNascimento = ?, Email = ?, Nome = ?, Senha = ?, usuario = ?, dataInicio = ?, dataFim = ?, ID_Assinatura = ? WHERE ID_Usuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.criarConexao();
            pstm = conn.prepareStatement(sql);

            pstm.setDate(1, new Date(usuario.getDataNasc().getTime()));
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getNome());
            pstm.setString(4, usuario.getSenha());
            pstm.setString(5, usuario.getUsuario());
            pstm.setDate(6, new Date(usuario.getDataInicio().getTime()));
            pstm.setDate(7, new Date(usuario.getDataFim().getTime()));
            pstm.setInt(8, usuario.getID_Assinatura());
            pstm.setDouble(9, usuario.getID_Usuario());

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
                usuarioEncontrado.setID_Usuario(rs.getDouble("ID_Usuario"));
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