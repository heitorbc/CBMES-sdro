/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.es.cb.sdro.view;

import br.gov.es.cb.sdro.control.ControlMilitarAdapter;
import br.gov.es.cb.sdro.model.Unidade;
import br.gov.es.cb.sdro.model.Usuario;
import br.gov.es.cb.sdro.util.Sessao;
import br.gov.es.cb.sdro.util.UsuarioDAO;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


/**
 *
 * @author Heitor
 */
public class Inicial extends javax.swing.JFrame {
    ControlMilitarAdapter controlMilitar;
    private HashMap<String,Integer> mapComboTipoLogin;
    private UsuarioDAO usuarioDAO;
    /**
     * Creates new form inicial
     */
    public Inicial() {
        initComponents();
        controlMilitar = new ControlMilitarAdapter();
        mapComboTipoLogin = new HashMap<>();
        mapComboTipoLogin.put("Unidade", 1);
        mapComboTipoLogin.put("Diretoria", 2);
        mapComboTipoLogin.put("SCO", 3);
        usuarioDAO = new UsuarioDAO();
        //TEstes carregamento militarAdapter
        /*
        //Busca Militar Adaptado por ID
        MilitarAdapter mil = new MilitarAdapter().getMilitarById(1);
        System.out.println(mil.toString());
        */
        /*
        //Busca Todos os Militares
        List<MilitarAdapter> l = new MilitarAdapter().getAllMilitarAdapter();
        for (int i = 0; i < 10; i++) {
            System.out.println(l.get(i).toString());
        }
        */
        /*
        //Busca Militares Por Posto Graduacao
        List<MilitarAdapter> l = new MilitarAdapter().getListMilitarByIdPostoGraduacao(1);
        for (int i = 0; i < 10; i++) {
            System.out.println(l.get(i).toString());
        }
        */
    }
    
    public int getIdTipoLogin(String tipoLogin){
        for (Map.Entry<String, Integer> entry : mapComboTipoLogin.entrySet()) {
            String key = entry.getKey();
            Integer idTipoLogin = entry.getValue();
            if(tipoLogin.equals(key)){
                return idTipoLogin;
            }
        }
        return 0;
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
        jcomboTipoLogin = new javax.swing.JComboBox();
        lbl_login = new javax.swing.JLabel();
        lbl_senha = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lbl_tipo = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnLogar = new javax.swing.JButton();
        btn_config = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N

        lbl_tit_sdro.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_tit_sdro.setText("SDRO-CBMES");

        jcomboTipoLogin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Diretoria", "Unidade", "SCO" }));
        jcomboTipoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboTipoLoginActionPerformed(evt);
            }
        });

        lbl_login.setText("login");

        lbl_senha.setText("senha");

        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });

        lbl_tipo.setText("tipo");

        txtSenha.setText("jPasswordField1");
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
        });
        txtSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSenhaMouseClicked(evt);
            }
        });

        btnLogar.setText("logar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
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
                            .addComponent(txtLogin)
                            .addComponent(jcomboTipoLogin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                    .addComponent(lbl_tit_sdro, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_senha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcomboTipoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogar)
                    .addComponent(btn_config))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void txtSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSenhaMouseClicked
        
    }//GEN-LAST:event_txtSenhaMouseClicked

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        txtSenha.setText("");
    }//GEN-LAST:event_txtSenhaFocusGained

    private void jcomboTipoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboTipoLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboTipoLoginActionPerformed

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        //validação de login e senha!
        
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        Usuario usuario = usuarioDAO.checaLogin(login, senha);
        if(usuario != null){
            Sessao sessao = Sessao.getInstancia();
            String tipoLoginJCombo = jcomboTipoLogin.getSelectedItem().toString();
            int idTipoLogin = getIdTipoLogin(tipoLoginJCombo);
            if(idTipoLogin == usuario.getTipoLogin()){
                if(idTipoLogin == 1){// Login feito por Unidade
                    Unidade unidade = usuario.getIdmilitar().getIdunidade();
                    sessao.setUnidade(unidade);
                }
                
                sessao.setTipoLogin(idTipoLogin);
                
                Principal principal = new Principal();
                principal.inicializa(controlMilitar);
                principal.setVisible(true);
                this.setVisible(false);
            }
            else{
               JOptionPane.showMessageDialog(null, "Login não permitido!!! Por favor selecione o Tipo correspondente."); 
            }
        }
        else{
             JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
        }
        
      
       
    }//GEN-LAST:event_btnLogarActionPerformed

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
    private javax.swing.JButton btnLogar;
    private javax.swing.JButton btn_config;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox jcomboTipoLogin;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JLabel lbl_tit_sdro;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
