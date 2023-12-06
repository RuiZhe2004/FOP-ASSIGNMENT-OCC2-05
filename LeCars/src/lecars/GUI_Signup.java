/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lecars;

import lecars.GUI_Login;

/**
 *
 * @author User
 */
public class GUI_Signup extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Signup
     */
    public GUI_Signup() {
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

        jRegistration = new javax.swing.JLabel();
        jfullname = new javax.swing.JLabel();
        jnamebox = new javax.swing.JTextField();
        jPassword = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jhaveaccount = new javax.swing.JLabel();
        jSignup = new javax.swing.JButton();
        jLogin = new javax.swing.JButton();
        jshowpw = new javax.swing.JCheckBox();
        jRetypepwField2 = new javax.swing.JPasswordField();
        jRetypepassword = new javax.swing.JLabel();
        jsecretkey = new javax.swing.JLabel();
        jsecretkeyField3 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRegistration.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jRegistration.setForeground(new java.awt.Color(255, 51, 51));
        jRegistration.setText("Employee Registration");

        jfullname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jfullname.setText("Full Name:");

        jnamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnameboxActionPerformed(evt);
            }
        });

        jPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPassword.setText("Password:");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jhaveaccount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jhaveaccount.setText("I've an account");

        jSignup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jSignup.setForeground(new java.awt.Color(255, 51, 51));
        jSignup.setText("Sign Up");
        jSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSignupActionPerformed(evt);
            }
        });

        jLogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLogin.setText("Login");
        jLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginActionPerformed(evt);
            }
        });

        jshowpw.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jshowpw.setText("Show Password");
        jshowpw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jshowpwActionPerformed(evt);
            }
        });

        jRetypepwField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRetypepwField2ActionPerformed(evt);
            }
        });

        jRetypepassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRetypepassword.setText("Retype password:");

        jsecretkey.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jsecretkey.setText("Secret key:");

        jsecretkeyField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsecretkeyField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jshowpw)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jhaveaccount)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                            .addComponent(jSignup))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jRegistration)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRetypepassword, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jfullname)
                                        .addComponent(jsecretkey))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jnamebox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                        .addComponent(jRetypepwField2)
                                        .addComponent(jsecretkeyField3))))
                            .addGap(28, 28, 28))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jRegistration)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnamebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jfullname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRetypepwField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRetypepassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsecretkeyField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsecretkey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jshowpw)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogin)
                    .addComponent(jhaveaccount)
                    .addComponent(jSignup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnameboxActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSignupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSignupActionPerformed

    private void jLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginActionPerformed
        // TODO add your handling code here:
        GUI_Login GUI_LoginFrame=new GUI_Login();
        GUI_LoginFrame.setVisible(true);
        GUI_LoginFrame.pack();
        GUI_LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLoginActionPerformed

    private void jshowpwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jshowpwActionPerformed
        // TODO add your handling code here:
        if(jshowpw.isSelected()){
            jPasswordField1.setEchoChar((char)0);
            jRetypepwField2.setEchoChar((char)0);
            jsecretkeyField3.setEchoChar((char)0);
        }
        else{
            jPasswordField1.setEchoChar('*');
            jRetypepwField2.setEchoChar('*');
            jsecretkeyField3.setEchoChar('*');
        }
    }//GEN-LAST:event_jshowpwActionPerformed

    private void jRetypepwField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRetypepwField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRetypepwField2ActionPerformed

    private void jsecretkeyField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsecretkeyField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jsecretkeyField3ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jLogin;
    private javax.swing.JLabel jPassword;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel jRegistration;
    private javax.swing.JLabel jRetypepassword;
    private javax.swing.JPasswordField jRetypepwField2;
    private javax.swing.JButton jSignup;
    private javax.swing.JLabel jfullname;
    private javax.swing.JLabel jhaveaccount;
    private javax.swing.JTextField jnamebox;
    private javax.swing.JLabel jsecretkey;
    private javax.swing.JPasswordField jsecretkeyField3;
    private javax.swing.JCheckBox jshowpw;
    // End of variables declaration//GEN-END:variables
}
