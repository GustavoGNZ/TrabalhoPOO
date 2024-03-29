/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import base.Album;
import bd.AlbumDAO;

/**
 *
 * @author gusta
 */
public class TelaCadastroAlbum extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastroAlbum() {
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
        TAno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BVoltar = new javax.swing.JButton();
        BInserir = new javax.swing.JButton();
        BCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("CADASTRO ALBUM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 510, 60));
        jPanel1.add(TNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 260, 30));
        jPanel1.add(TAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 260, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("ANO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("NOME:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        BVoltar.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BVoltar.setText("VOLTAR");
        BVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(BVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 220, 40));

        BInserir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BInserir.setText("INSERIR MUSICAS");
        BInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInserirActionPerformed(evt);
            }
        });
        jPanel1.add(BInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 220, 40));

        BCadastro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        BCadastro.setText("CADASTRAR");
        BCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCadastroActionPerformed(evt);
            }
        });
        jPanel1.add(BCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 380, -1));

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

    private void BInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInserirActionPerformed

        TelaCadastroMusicaAlbum tMusica = new TelaCadastroMusicaAlbum();
        tMusica.setVisible(true);   
        
    }//GEN-LAST:event_BInserirActionPerformed

    private void BCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCadastroActionPerformed
        // TODO add your handling code here:

        AlbumDAO albumDAO = new AlbumDAO();

        int idAlbum = (int) Math.round(Math.random() * 100);
        
        Album alb = new Album();
        
        String anoString = TAno.getText();
        int anoAlb = 0;
        
        try {
            anoAlb = Integer.parseInt(anoString);
        } catch (NumberFormatException e) {
            // Se houver um erro na conversão, você pode lidar com isso aqui
            System.out.println("Erro ao converter para int: " + e.getMessage());
        }
        
        alb.setID_Album(idAlbum);
        alb.setNome(TNome.getText());
        alb.setAno(anoAlb);

     
        try {
            albumDAO.inserirAlbum(alb);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
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
            java.util.logging.Logger.getLogger(TelaCadastroAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroAlbum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCadastro;
    private javax.swing.JButton BInserir;
    private javax.swing.JButton BVoltar;
    private javax.swing.JTextField TAno;
    private javax.swing.JTextField TNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
