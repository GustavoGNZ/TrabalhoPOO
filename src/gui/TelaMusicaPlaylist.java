/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import base.Adiciona;
import bd.AdicionaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gusta
 */
public class TelaMusicaPlaylist extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaMusicaPlaylist() {
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
        jLabel5 = new javax.swing.JLabel();
        BVoltar = new javax.swing.JButton();
        BRemover = new javax.swing.JButton();
        TIDMusica = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TIDPlaylist = new javax.swing.JTextField();
        BAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("MUSICA NA PLAYLIST");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 550, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("ID_MUSICA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        BVoltar.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BVoltar.setText("VOLTAR");
        BVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(BVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 220, 40));

        BRemover.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BRemover.setText("REMOVER");
        BRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(BRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 330, -1));
        jPanel1.add(TIDMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 260, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("ID_PLAYLIST:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));
        jPanel1.add(TIDPlaylist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 260, 30));

        BAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BAdicionar.setText("ADICIONAR");
        BAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(BAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 330, -1));

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

        TelaMenu tMenu = new TelaMenu();
        tMenu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BVoltarActionPerformed

    private void BRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRemoverActionPerformed

        AdicionaDAO adicionaDAO = new AdicionaDAO();

        String idPlay = TIDPlaylist.getText();
        int idPlayInt = 0;
        String idMus = TIDMusica.getText();
        int idMusInt = 0;

        try {
            idPlayInt = Integer.parseInt(idPlay);
            idMusInt = Integer.parseInt(idMus);
        } catch (NumberFormatException e) {
            // Se houver um erro na conversão, você pode lidar com isso aqui
            System.out.println("Erro ao converter para int: " + e.getMessage());
        }

        Adiciona adiciona = new Adiciona();
        adiciona.setID_Musica(idMusInt);
        adiciona.setID_Playlist(idPlayInt);

        try {
            adicionaDAO.removePlaylist(adiciona);
        } catch (Exception ex) {
            Logger.getLogger(TelaMusicaPlaylist.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BRemoverActionPerformed

    private void BAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAdicionarActionPerformed

        AdicionaDAO adicionaDAO = new AdicionaDAO();

        String idPlay = TIDPlaylist.getText();
        int idPlayInt = 0;
        String idMus = TIDMusica.getText();
        int idMusInt = 0;

        try {
            idPlayInt = Integer.parseInt(idPlay);
            idMusInt = Integer.parseInt(idMus);
        } catch (NumberFormatException e) {
            // Se houver um erro na conversão, você pode lidar com isso aqui
            System.out.println("Erro ao converter para int: " + e.getMessage());
        }

        Adiciona adiciona = new Adiciona();
        adiciona.setID_Musica(idMusInt);
        adiciona.setID_Playlist(idPlayInt);

        try {
            adicionaDAO.adicionaPlaylist(adiciona);
        } catch (Exception ex) {
            Logger.getLogger(TelaMusicaPlaylist.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BAdicionarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMusicaPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMusicaPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMusicaPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMusicaPlaylist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMusicaPlaylist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAdicionar;
    private javax.swing.JButton BRemover;
    private javax.swing.JButton BVoltar;
    private javax.swing.JTextField TIDMusica;
    private javax.swing.JTextField TIDPlaylist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}