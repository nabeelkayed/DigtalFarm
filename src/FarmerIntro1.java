

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ammr6
 */
public class FarmerIntro1 extends javax.swing.JFrame {

    private Component Entro;
            static String F_C="";
            Connection con;
    /**
     * Creates new form FarmerIntro1
     */
    public FarmerIntro1(String F_C) {
        initComponents();
        this.F_C=F_C;
        //initComponents();
        try {
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
            con= DriverManager.getConnection (url, "myfarmproj", "654321");
        } catch (SQLException ex) {
            Logger.getLogger(FarmerIntro.class.getName()).log(Level.SEVERE, null, ex);
        }
        String Str="<html><u>I don't have an account.</u></html>";
        Noaccount.setText(Str);
        this.setLocationRelativeTo(Entro);
        
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
        jLabel6 = new javax.swing.JLabel();
        Backlabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        button1 = new java.awt.Button();
        Noaccount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("digital farm");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1076, 641));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(212, 188, 162));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(212, 188, 162));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, -1, 40));

        Backlabel.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        Backlabel.setForeground(new java.awt.Color(51, 119, 68));
        Backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back_25px.png"))); // NOI18N
        Backlabel.setText("Back");
        Backlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BacklabelMouseClicked(evt);
            }
        });
        jPanel1.add(Backlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_DataBase-final.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 500, 410));

        jLabel3.setBackground(new java.awt.Color(51, 119, 68));
        jLabel3.setFont(new java.awt.Font("Arabic Typesetting", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 119, 68));
        jLabel3.setText("E-mail :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 70, 36));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 219, 36));

        jLabel4.setFont(new java.awt.Font("Arabic Typesetting", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 119, 68));
        jLabel4.setText("Password :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 110, 37));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 219, 36));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 500, 16));

        button1.setBackground(new java.awt.Color(51, 119, 68));
        button1.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        button1.setForeground(new java.awt.Color(249, 246, 242));
        button1.setLabel("Log in");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 127, 36));

        Noaccount.setFont(new java.awt.Font("Sakkal Majalla", 0, 18)); // NOI18N
        Noaccount.setForeground(new java.awt.Color(51, 119, 68));
        Noaccount.setText("jLabel7");
        Noaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoaccountMouseClicked(evt);
            }
        });
        jPanel1.add(Noaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 340, 24));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/digital_crop.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 540, 640));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmland-Agriculture-Farm-Field-Cropland-1867212.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 540, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1076, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void BacklabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BacklabelMouseClicked
        // TODO add your handling code here:
        new Entro().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BacklabelMouseClicked

    private void NoaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoaccountMouseClicked
        // TODO add your handling code here:
        new FarmerIntro(this.F_C).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_NoaccountMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        Statement stmt;
        String pass = "";
        String SSN="";
        int c_number=0;
        try {
            stmt = con.createStatement();
        
        if (email.getText().equals("")|new String(password.getPassword()).equals(""))
              JOptionPane.showMessageDialog(null,"There ia an empty fildes.");

        else if (F_C.equals("customer")){
                ResultSet rs= stmt.executeQuery("select c_email,c_password, client_number from client where c_email='"
                    +email.getText()+"'");
            int count = 0;
            while (rs.next()) {
             count++;
             pass= rs.getString("c_password");
             c_number=rs.getInt("client_number");
            } 
            if (count==0)
               JOptionPane.showMessageDialog(null,"This email is not exist.");
            else if (!(pass.equals(new String(password.getPassword()))))
                     JOptionPane.showMessageDialog(null,"The password is not correct.");
            else 
            {
                new cutomerProg(c_number).setVisible(true);
                this.setVisible(false);
            }
        }
        else{
                ResultSet rs= stmt.executeQuery("select f_email, f_password, ssn from farmer where f_email='"
                    +email.getText()+"'");
            int count = 0;
            while (rs.next()) {
             count++;
             pass= rs.getString("f_password");
            SSN =rs.getString("ssn");
            } 
            if (count==0)
               JOptionPane.showMessageDialog(null,"This email is not exist.");
            else if (!(pass.equals(new String(password.getPassword()))))
                      JOptionPane.showMessageDialog(null,"The password is not correct.");
            else 
            {
                new farmerprog(SSN).setVisible(true);
                this.setVisible(false);
            }
        }}
        catch (SQLException ex) {
            Logger.getLogger(FarmerIntro1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed

    
        
        
    
    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MousePressed

    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(FarmerIntro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmerIntro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmerIntro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmerIntro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FarmerIntro1(F_C).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backlabel;
    private javax.swing.JLabel Noaccount;
    private java.awt.Button button1;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables

}