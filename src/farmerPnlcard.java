
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amrooxdd
 */
public class farmerPnlcard extends javax.swing.JFrame {

    /**
     * Creates new form farmerPnlcard
     */
    public farmerPnlcard() {
        initComponents();
        this.SSn.setVisible(false);
        jLabel1.setVisible(false);
        RankLbl.setVisible(false);
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
        RankLbl = new javax.swing.JLabel();
        SSn = new javax.swing.JLabel();
        farmname = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        Phone = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(212, 188, 162));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 10, 1, new java.awt.Color(249, 246, 242)));
        jPanel1.setMaximumSize(new java.awt.Dimension(850, 150));
        jPanel1.setMinimumSize(new java.awt.Dimension(850, 150));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(249, 246, 242));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 246, 242));
        jLabel1.setText("5/");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 20));

        RankLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RankLbl.setForeground(new java.awt.Color(249, 246, 242));
        RankLbl.setText("0");
        jPanel1.add(RankLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 30, 20));

        SSn.setText("SSn");
        jPanel1.add(SSn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 60, -1));

        farmname.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        farmname.setForeground(new java.awt.Color(249, 246, 242));
        farmname.setText("Farm Name");
        jPanel1.add(farmname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, 50));

        address.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        address.setForeground(new java.awt.Color(249, 246, 242));
        address.setText("Address");
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 250, -1));

        Phone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Phone.setForeground(new java.awt.Color(249, 242, 246));
        Phone.setText("Phone ");
        jPanel1.add(Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 220, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Farmland-Agriculture-Farm-Field-Cropland-1867212.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    public JPanel getpanel(){
        return jPanel1;
    }
    //setter & getter for farm name
    public void setFarmerName(String farmnameString){
        this.farmname.setText(farmnameString);
    }
    
    public String getFarmerName(){
        return farmname.getText();
    }
    
    
    //setter & getter for address lbl
    public void setAddress(String AddressString){
        this.address.setText(AddressString);
    }
    public String getAddress(){
        return address.getText();
    }
    
    //setter & getter for phone 
    public void setPhone(String PhoneString){
        this.Phone.setText(PhoneString);
    }
    public String getPhone(){
        return Phone.getText();
    }
    
    
    //setter &getter for SSN
    public void setSSN(String SSN){
        this.SSn.setText(String.valueOf(SSN));
    }
    
    public String getSSN(){
        return SSn.getText();
    }
    public void setRank(int Rank){
        this.RankLbl.setText(String.valueOf(Rank));
    }
    
    public int getRank(){
        return Integer.parseInt(RankLbl.getText());
    }
    
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
            java.util.logging.Logger.getLogger(farmerPnlcard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(farmerPnlcard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(farmerPnlcard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(farmerPnlcard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new farmerPnlcard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Phone;
    private javax.swing.JLabel RankLbl;
    private javax.swing.JLabel SSn;
    private javax.swing.JLabel address;
    private javax.swing.JLabel farmname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}