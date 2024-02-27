/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import base.Musica;
import bd.MusicaDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class TelaCadastroMusica extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastroMusica() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TNome = new javax.swing.JTextField();
        TDuracao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BVoltar = new javax.swing.JButton();
        BCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("CADASTRO MUSICA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 530, 60));
        jPanel1.add(TNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 260, 30));
        jPanel1.add(TDuracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 260, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("NOME:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("DURACAO (segundos):");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 50));

        BVoltar.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BVoltar.setText("VOLTAR");
        BVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(BVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, 190, 40));

        BCadastro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BCadastro.setText("CADASTRAR");
        BCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCadastroActionPerformed(evt);
            }
        });
        jPanel1.add(BCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 260, -1));

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

        // TODO add your handling code here:
        TelaMenuArtista tMArtista = new TelaMenuArtista();
        tMArtista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BVoltarActionPerformed

    private void BCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCadastroActionPerformed

        MusicaDAO musicaDao = new MusicaDAO();

        int idMus = (int) Math.round(Math.random() * 100);
        
        Musica musica = new Musica();

        String duracaoStr = TDuracao.getText();
        double duracao = 0.0; // Valor padrão caso a conversão falhe

        try {
            duracao = Double.parseDouble(duracaoStr);
        } catch (NumberFormatException e) {
            // Se houver um erro na conversão, você pode lidar com isso aqui
            System.out.println("Erro ao converter para double: " + e.getMessage());
        }

        musica.setID_Musica(idMus);
        musica.setID_Album(0);
        musica.setNome(TNome.getText());
        musica.setDuracao(duracao);

        musicaDao.inserirMusica(musica);
        
        
    }//GEN-LAST:event_BCadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMusica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroMusica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCadastro;
    private javax.swing.JButton BVoltar;
    private javax.swing.JTextField TDuracao;
    private javax.swing.JTextField TNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
