/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.view;

/**
 *
 * @author Heitor
 */
public class Inicial extends javax.swing.JFrame {

    /**
     * Creates new form inicial
     */
    public Inicial() {
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
        lbl_tit_sdro = new javax.swing.JLabel();
        cmb_tipo = new javax.swing.JComboBox();
        lbl_login = new javax.swing.JLabel();
        lbl_senha = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        lbl_tipo = new javax.swing.JLabel();
        txp_senha = new javax.swing.JPasswordField();
        btn_logar = new javax.swing.JButton();
        btn_config = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N

        lbl_tit_sdro.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_tit_sdro.setText("SDRO-CBMES");

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Diretoria", "Unidade", "SCO" }));
        cmb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoActionPerformed(evt);
            }
        });

        lbl_login.setText("login");

        lbl_senha.setText("senha");

        txt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loginActionPerformed(evt);
            }
        });

        lbl_tipo.setText("tipo");

        txp_senha.setText("jPasswordField1");
        txp_senha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txp_senhaFocusGained(evt);
            }
        });
        txp_senha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txp_senhaMouseClicked(evt);
            }
        });

        btn_logar.setText("logar");
        btn_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logarActionPerformed(evt);
            }
        });

        btn_config.setText("Configurações");
        btn_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configActionPerformed(evt);
            }
        });

        jLabel1.setText("versão: 0.0.1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_senha)
                                .addComponent(lbl_tipo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_login)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_login)
                            .addComponent(cmb_tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txp_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                    .addComponent(lbl_tit_sdro, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(btn_logar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(btn_config)))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbl_tit_sdro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_login)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_senha)
                    .addComponent(txp_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_logar)
                    .addComponent(btn_config))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loginActionPerformed

    private void txp_senhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txp_senhaMouseClicked
        
    }//GEN-LAST:event_txp_senhaMouseClicked

    private void txp_senhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txp_senhaFocusGained
        txp_senha.setText("");
    }//GEN-LAST:event_txp_senhaFocusGained

    private void cmb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipoActionPerformed

    private void btn_logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logarActionPerformed
        //validação de login e senha!
        new Principal().setVisible(true);
        this.setVisible(false);
       
    }//GEN-LAST:event_btn_logarActionPerformed

    private void btn_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_configActionPerformed

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
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_config;
    private javax.swing.JButton btn_logar;
    private javax.swing.JComboBox cmb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JLabel lbl_tit_sdro;
    private javax.swing.JPasswordField txp_senha;
    private javax.swing.JTextField txt_login;
    // End of variables declaration//GEN-END:variables
}
