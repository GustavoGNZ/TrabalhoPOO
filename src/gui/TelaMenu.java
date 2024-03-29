/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

/**
 *
 * @author gusta
 */
public class TelaMenu extends javax.swing.JFrame {

    /**
     * Creates new form TelaMenu
     */
    public TelaMenu() {
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
        BEPlaylist = new javax.swing.JButton();
        BAtualizar = new javax.swing.JButton();
        BBuscar = new javax.swing.JButton();
        BSerArtista = new javax.swing.JButton();
        BMenuArtista2 = new javax.swing.JButton();
        BDeletar1 = new javax.swing.JButton();
        BDeletarP1 = new javax.swing.JButton();
        BCPlaylist1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("MENU");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, 60));

        BEPlaylist.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BEPlaylist.setText("EDITAR PLAYLIST");
        BEPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEPlaylistActionPerformed(evt);
            }
        });
        jPanel1.add(BEPlaylist, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 310, -1));

        BAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BAtualizar.setText("ATUALIZAR USUARIO");
        BAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(BAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 310, -1));

        BBuscar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BBuscar.setText("BUSCAR ");
        BBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 310, -1));

        BSerArtista.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BSerArtista.setText("SER ARTISTA");
        BSerArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSerArtistaActionPerformed(evt);
            }
        });
        jPanel1.add(BSerArtista, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 310, -1));

        BMenuArtista2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BMenuArtista2.setText("MENU ARTISTA");
        BMenuArtista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMenuArtista2ActionPerformed(evt);
            }
        });
        jPanel1.add(BMenuArtista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 310, -1));

        BDeletar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BDeletar1.setText("EXCLUIR PLAYLIST");
        BDeletar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeletar1ActionPerformed(evt);
            }
        });
        jPanel1.add(BDeletar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 310, -1));

        BDeletarP1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BDeletarP1.setText("EXCLUIR PERFIL");
        BDeletarP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeletarP1ActionPerformed(evt);
            }
        });
        jPanel1.add(BDeletarP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 550, 310, -1));

        BCPlaylist1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BCPlaylist1.setText("CRIAR PLAYLIST");
        BCPlaylist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCPlaylist1ActionPerformed(evt);
            }
        });
        jPanel1.add(BCPlaylist1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 310, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAtualizarActionPerformed
        TelaCadastroAtualizar tDelete = new TelaCadastroAtualizar();
        tDelete.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BAtualizarActionPerformed

    private void BEPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEPlaylistActionPerformed

        TelaEditarPlaylist tPlaylist = new TelaEditarPlaylist();
        tPlaylist.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BEPlaylistActionPerformed

    private void BBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarActionPerformed

        TelaBusca tBusca = new TelaBusca();
        tBusca.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BBuscarActionPerformed

    private void BSerArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSerArtistaActionPerformed
        // TODO add your handling code here:
        TelaSerArtista tArtista = new TelaSerArtista();
        tArtista.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_BSerArtistaActionPerformed

    private void BMenuArtista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMenuArtista2ActionPerformed
        TelaLoginArtista tMArtista = new TelaLoginArtista();
        tMArtista.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_BMenuArtista2ActionPerformed

    private void BDeletar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeletar1ActionPerformed
        // TODO add your handling code here:
        
        TelaDeletarPlaylist tDeletar = new TelaDeletarPlaylist();
        tDeletar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BDeletar1ActionPerformed

    private void BDeletarP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeletarP1ActionPerformed
        // TODO add your handling code here:
        
        TelaDeletarUsuario tDeletar = new TelaDeletarUsuario();
        tDeletar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BDeletarP1ActionPerformed

    private void BCPlaylist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCPlaylist1ActionPerformed
        // TODO add your handling code here:
        
        TelaCadastroPlaylist tPlaylist = new TelaCadastroPlaylist();
        tPlaylist.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_BCPlaylist1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAtualizar;
    private javax.swing.JButton BBuscar;
    private javax.swing.JButton BCPlaylist1;
    private javax.swing.JButton BDeletar1;
    private javax.swing.JButton BDeletarP1;
    private javax.swing.JButton BEPlaylist;
    private javax.swing.JButton BMenuArtista2;
    private javax.swing.JButton BSerArtista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
