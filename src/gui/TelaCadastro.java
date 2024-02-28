package gui;

import base.Usuario;
import bd.UsuarioDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class TelaCadastro extends javax.swing.JFrame {

    public TelaCadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TNome = new javax.swing.JTextField();
        TEmail = new javax.swing.JTextField();
        TData = new javax.swing.JTextField();
        TUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PCSenha = new javax.swing.JPasswordField();
        PSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BVoltar = new javax.swing.JButton();
        BCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("CADASTRO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 290, 60));
        jPanel1.add(TNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 260, 30));
        jPanel1.add(TEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 260, 30));
        jPanel1.add(TData, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 260, 30));
        jPanel1.add(TUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 260, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("DATA DE NASCIMENTO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("CONFIRMAR SENHA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("NOME:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("EMAIL:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));
        jPanel1.add(PCSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 260, 30));
        jPanel1.add(PSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 260, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("USUÁRIO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("SENHA:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        BVoltar.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BVoltar.setText("VOLTAR");
        BVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(BVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 210, 40));

        BCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BCadastrar.setText("CADASTRAR");
        BCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(BCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVoltarActionPerformed

        TelaInicial tInicial = new TelaInicial();
        tInicial.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BVoltarActionPerformed

    private void BCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCadastrarActionPerformed

        
        String senha, confirmarSenha;
        senha = String.valueOf(PSenha.getPassword());
        confirmarSenha = String.valueOf(PCSenha.getPassword());
        
        if (senha.equals(confirmarSenha)){
            Usuario user = new Usuario();
            user.setNome(TNome.getText());
            user.setEmail(TEmail.getText());
            user.setUsuario(TUsuario.getText());
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            
            try {
                Date data = (Date)format.parse(TData.getText());
                user.setDataNasc(data);
            } catch (ParseException ex) {
                System.out.println("Erro: "+ex);
            }
            
            user.setSenha(senha);
            
            UsuarioDAO userDAO = new UsuarioDAO();
            
            userDAO.inserirUsuario(user);
            
        } else {
            JOptionPane.showMessageDialog(null, "Senha e confirmar senha não conferem!");
        }
        
        TelaInicial tInicial = new TelaInicial();
        tInicial.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_BCadastrarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCadastrar;
    private javax.swing.JButton BVoltar;
    private javax.swing.JPasswordField PCSenha;
    private javax.swing.JPasswordField PSenha;
    private javax.swing.JTextField TData;
    private javax.swing.JTextField TEmail;
    private javax.swing.JTextField TNome;
    private javax.swing.JTextField TUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
