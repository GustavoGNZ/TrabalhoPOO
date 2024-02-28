// Done

package gui;

import base.Artista;
import bd.ArtistaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gusta
 */
public class TelaSerArtista extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaSerArtista() {
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
        TGenero = new javax.swing.JTextField();
        TUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BVoltar = new javax.swing.JButton();
        BCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("SER ARTISTA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 350, 60));
        jPanel1.add(TGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 260, 30));
        jPanel1.add(TUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 260, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Genero Musical:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("ID_Usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

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

        // TODO add your handling code here:
        TelaInicial tInicial = new TelaInicial();
        tInicial.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BVoltarActionPerformed

    private void BCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCadastrarActionPerformed

      
            Artista user = new Artista();
            user.setGenero(TGenero.getText());

            // Convertendo a string em um inteiro
            String idString = TUsuario.getText();
            int idUsuario = Integer.parseInt(idString);
            user.setID_Usuario(idUsuario);

            ArtistaDAO userDAO = new ArtistaDAO();
            try {
                userDAO.inserirArtista(user);
            } catch (Exception ex) {
                Logger.getLogger(TelaSerArtista.class.getName()).log(Level.SEVERE, null, ex);
            }

            TelaInicial tInicial = new TelaInicial();
            tInicial.setVisible(true);
            this.dispose();

        
    }//GEN-LAST:event_BCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaSerArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSerArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSerArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSerArtista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSerArtista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCadastrar;
    private javax.swing.JButton BVoltar;
    private javax.swing.JTextField TGenero;
    private javax.swing.JTextField TUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}