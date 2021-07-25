
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import oracle.jdbc.pool.OracleDataSource;
import oracle.net.aso.l;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ammr6
 */
public class cutomerProg extends javax.swing.JFrame {

    /**
     * Creates new form cutomerProg
     */
    Connection con;
    int c_number;
    CardLayout cardLayout;
    CardLayout cardLayout1;
    farmerPnlcard farmPnlcard;
    int row1;
    int col1;
    int Rank;
    String ssn="";
    boolean pas=false;
    OracleDataSource o;
    public static ArrayList <farmerPnlcard> farms = new ArrayList <farmerPnlcard> ();

    public cutomerProg(int c_number) {
        initComponents();
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        Component FarmerIntro1;
        this.setLocationRelativeTo(null);
        Farmsbtn.setBackground(new Color(77,148,95));
        jPanel11.setBackground(new Color(142,180,152));
        homeCustomer.setBackground(new Color(68,131,84));
        jPanel12.setBackground(new Color(68,131,84));
        String Str="<html><u>change Password.</u></html>";
        ChangePass.setText(Str);
        jInternalFrame1.setVisible(false);
        setVisFalse(jLabel25,OPlbl,OPtxt,OPsep);
        setVisFalse(jLabel25,NPlbl, NPtxt,NPsep);
        setVisFalse(jLabel25,RNPlbl, RNPtxt, RNPsep);
        cardLayout =(CardLayout)(jPanel6.getLayout());
        cardLayout1=(CardLayout)(farmsPnl.getLayout());
        cardLayout1.show(farmsPnl,"card2");
        this.c_number=c_number;
        try {
            o=new OracleDataSource();
            o.setURL("jdbc:oracle:thin:@//localhost:1521/orcl");
            o.setUser("myfarmproj");
            o.setPassword("654321");
            con= o.getConnection(); 
            Statement stmt = con.createStatement();
            ResultSet ss =stmt.executeQuery("select * from client where client_number ="+this.c_number);
             while (ss.next()) {
               email.setText(ss.getString("c_email"));
               name.setText("Hello "+ ss.getString("first_name"));
               Addresstxt.setText(ss.getString("street"));
               jTextField3.setText(ss.getString("last_name"));
               jTextField4.setText(ss.getString("first_name"));
           
             }
             ResultSet sr =stmt.executeQuery("select * from client_number where super_client_number =" + c_number);
             while (sr.next()) {
               PNtxt.setText(""+sr.getString("phone_number"));
               jTextField5.setText(sr.getString("tel_number"));
               
             }
        } catch (SQLException ex) {
            Logger.getLogger(cutomerProg.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            OracleDataSource ora=new OracleDataSource();
            ora.setURL("jdbc:oracle:thin:@//localhost:1521/orcl");
            ora.setUser("myfarmproj");
            ora.setPassword("654321");
            con= ora.getConnection(); 
            Statement stmt = con.createStatement();
            ResultSet FarmerResult =stmt.executeQuery("select * from farmer,farmer_number where farmer.SSN = farmer_number.super_ssn ");
            while(FarmerResult.next()){
                farmPnlcard =new farmerPnlcard();
                farmPnlcard.setFarmerName(FarmerResult.getString(1)+FarmerResult.getString(2));
                farmPnlcard.setAddress(FarmerResult.getString(6)+","+FarmerResult.getString(7));
                farmPnlcard.setPhone(String.valueOf(FarmerResult.getInt(10)));
                ssn= ""+FarmerResult.getString("ssn");
                farmPnlcard.setSSN(ssn);
                this.jPanel7.add(farmPnlcard.getpanel());
                farms.add(farmPnlcard);
                MouseHandler l =new MouseHandler();
                farmPnlcard.getpanel().addMouseListener(l);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
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
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        homeCustomer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        Farmsbtn = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        farmsPnl = new javax.swing.JPanel();
        farmDetil = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        FarmnameDetilPnl = new javax.swing.JLabel();
        AddressDetailPn = new javax.swing.JLabel();
        TelPhoneDetailPnl = new javax.swing.JLabel();
        PhoneNumDetailPnl = new javax.swing.JLabel();
        rate = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        button2 = new java.awt.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        homePnl = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PNtxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Addresstxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        editLabel1 = new javax.swing.JLabel();
        editLabel = new javax.swing.JLabel();
        ChangePass = new javax.swing.JLabel();
        OPlbl = new javax.swing.JLabel();
        OPtxt = new javax.swing.JPasswordField();
        OPsep = new javax.swing.JSeparator();
        NPlbl = new javax.swing.JLabel();
        NPtxt = new javax.swing.JPasswordField();
        NPsep = new javax.swing.JSeparator();
        RNPlbl = new javax.swing.JLabel();
        RNPtxt = new javax.swing.JPasswordField();
        RNPsep = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 246, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 119, 68));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 180, 11));

        jLabel1.setFont(new java.awt.Font("Sakkal Majalla", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digital Farm");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 170, 25));

        homeCustomer.setBackground(new java.awt.Color(68, 131, 84));
        homeCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeCustomerMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sakkal Majalla", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 246, 242));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings_32px.png"))); // NOI18N
        jLabel3.setText("Settings");

        jPanel12.setBackground(new java.awt.Color(68, 131, 84));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout homeCustomerLayout = new javax.swing.GroupLayout(homeCustomer);
        homeCustomer.setLayout(homeCustomerLayout);
        homeCustomerLayout.setHorizontalGroup(
            homeCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeCustomerLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        homeCustomerLayout.setVerticalGroup(
            homeCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeCustomerLayout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(homeCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 230, 40));

        Farmsbtn.setBackground(new java.awt.Color(68, 131, 84));
        Farmsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FarmsbtnMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sakkal Majalla", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Farms");

        jPanel11.setBackground(new java.awt.Color(68, 131, 84));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FarmsbtnLayout = new javax.swing.GroupLayout(Farmsbtn);
        Farmsbtn.setLayout(FarmsbtnLayout);
        FarmsbtnLayout.setHorizontalGroup(
            FarmsbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FarmsbtnLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        FarmsbtnLayout.setVerticalGroup(
            FarmsbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel3.add(Farmsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 40));

        jPanel10.setBackground(new java.awt.Color(68, 131, 84));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(249, 246, 242));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sign_out_32px.png"))); // NOI18N
        jLabel19.setText("Log out");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 230, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 640));

        jPanel2.setBackground(new java.awt.Color(142, 180, 152));

        name.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        name.setText("Hello");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(249, 246, 242));
        jLabel26.setText("X");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel26MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 408, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 0, 850, 40));

        jPanel6.setLayout(new java.awt.CardLayout());

        farmsPnl.setLayout(new java.awt.CardLayout());

        farmDetil.setBackground(new java.awt.Color(249, 246, 242));
        farmDetil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(66, 155, 88));

        FarmnameDetilPnl.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        FarmnameDetilPnl.setForeground(new java.awt.Color(249, 246, 242));
        FarmnameDetilPnl.setText("Farm Name");

        AddressDetailPn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddressDetailPn.setForeground(new java.awt.Color(249, 246, 242));
        AddressDetailPn.setText("Address");

        TelPhoneDetailPnl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TelPhoneDetailPnl.setForeground(new java.awt.Color(249, 246, 242));
        TelPhoneDetailPnl.setText("Tel-Phone");

        PhoneNumDetailPnl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PhoneNumDetailPnl.setForeground(new java.awt.Color(249, 246, 242));
        PhoneNumDetailPnl.setText("Phone Number");

        rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rate.setForeground(new java.awt.Color(249, 246, 242));
        rate.setText("5 /");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(249, 246, 242));
        jLabel21.setText("Farm Rate:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FarmnameDetilPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(230, 230, 230)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PhoneNumDetailPnl)
                    .addComponent(AddressDetailPn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelPhoneDetailPnl))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FarmnameDetilPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressDetailPn))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TelPhoneDetailPnl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(PhoneNumDetailPnl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addGap(25, 25, 25))
        );

        farmDetil.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plant Name", "Price", "Add to Cart"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        farmDetil.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 850, 164));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("The Content of Farm Name");
        farmDetil.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 30));

        jButton3.setBackground(new java.awt.Color(51, 119, 68));
        jButton3.setText("Show purchases");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        farmDetil.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 101, 37));

        jInternalFrame1.setVisible(true);

        jButton4.setBackground(new java.awt.Color(51, 119, 68));
        jButton4.setText("Add to order");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Quntitiy :");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Total Price :");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton2.setBackground(new java.awt.Color(51, 119, 68));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Dismiss");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        farmDetil.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 290, 150));

        farmsPnl.add(farmDetil, "card3");

        jPanel5.setBackground(new java.awt.Color(249, 246, 242));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame2.setVisible(true);

        jPanel9.setBackground(new java.awt.Color(249, 246, 242));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("The order is sent successfully ");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 254, 73));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Please , Rank the farmer !!");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 117, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star_25px.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star_25px.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star_25px.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
        });
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star_25px.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star_25px.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
            }
        });
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        button2.setBackground(new java.awt.Color(51, 119, 68));
        button2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        button2.setLabel("Show Bill");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel9.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 87, -1));

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 290, 380));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plant Name", "Plant Price", "Quntity", "Price", "Remove"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("");
        jTable2.setRowHeight(30);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 850, 263));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Purchases");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 126, 46));

        button1.setBackground(new java.awt.Color(51, 119, 68));
        button1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        button1.setLabel("Send the order");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel5.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, -1, 39));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 119, 68));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back_25px.png"))); // NOI18N
        jLabel18.setText("Back");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, -1));

        farmsPnl.add(jPanel5, "card4");

        jScrollPane2.setBorder(null);

        jPanel7.setBackground(new java.awt.Color(249, 246, 242));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jPanel7);

        farmsPnl.add(jScrollPane2, "card2");

        jPanel6.add(farmsPnl, "card3");

        homePnl.setBackground(new java.awt.Color(249, 246, 242));

        jPanel8.setBackground(new java.awt.Color(77, 148, 95));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(249, 246, 242));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(249, 246, 242));
        jLabel5.setText("E-mail :");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 50, 20));

        email.setBackground(new java.awt.Color(77, 148, 98));
        email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(249, 246, 242));
        email.setBorder(null);
        jPanel8.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 166, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(249, 246, 242));
        jLabel6.setText("Phone Number :");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 30));

        PNtxt.setBackground(new java.awt.Color(77, 148, 98));
        PNtxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PNtxt.setForeground(new java.awt.Color(249, 246, 242));
        PNtxt.setBorder(null);
        jPanel8.add(PNtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 166, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(249, 246, 242));
        jLabel7.setText("Street :");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 60, -1));

        Addresstxt.setBackground(new java.awt.Color(77, 148, 98));
        Addresstxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Addresstxt.setForeground(new java.awt.Color(249, 246, 242));
        Addresstxt.setBorder(null);
        jPanel8.add(Addresstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 170, 20));
        jPanel8.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 130, 10));
        jPanel8.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 170, 10));
        jPanel8.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 170, 10));

        editLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editLabel1MousePressed(evt);
            }
        });
        jPanel8.add(editLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 30, 30));

        editLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editLabelMousePressed(evt);
            }
        });
        jPanel8.add(editLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 30, 30));

        ChangePass.setFont(new java.awt.Font("Sakkal Majalla", 0, 18)); // NOI18N
        ChangePass.setForeground(new java.awt.Color(249, 246, 242));
        ChangePass.setText("jLabel8");
        ChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ChangePassMousePressed(evt);
            }
        });
        jPanel8.add(ChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 280, 40));

        OPlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        OPlbl.setForeground(new java.awt.Color(249, 246, 242));
        OPlbl.setText("Old Password :");
        jPanel8.add(OPlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 100, 20));

        OPtxt.setBackground(new java.awt.Color(77, 148, 95));
        OPtxt.setForeground(new java.awt.Color(249, 246, 242));
        OPtxt.setBorder(null);
        jPanel8.add(OPtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 160, 20));
        jPanel8.add(OPsep, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 160, 20));

        NPlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NPlbl.setForeground(new java.awt.Color(249, 246, 242));
        NPlbl.setText("New Password :");
        jPanel8.add(NPlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 100, 20));

        NPtxt.setBackground(new java.awt.Color(77, 148, 95));
        NPtxt.setForeground(new java.awt.Color(249, 246, 242));
        NPtxt.setBorder(null);
        jPanel8.add(NPtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 160, 20));
        jPanel8.add(NPsep, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 160, 20));

        RNPlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RNPlbl.setForeground(new java.awt.Color(249, 246, 242));
        RNPlbl.setText("New Password :");
        jPanel8.add(RNPlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 100, 20));

        RNPtxt.setBackground(new java.awt.Color(77, 148, 95));
        RNPtxt.setForeground(new java.awt.Color(249, 246, 242));
        RNPtxt.setBorder(null);
        jPanel8.add(RNPtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 160, 20));
        jPanel8.add(RNPsep, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 160, 20));

        jButton1.setBackground(new java.awt.Color(249, 246, 242));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 90, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(249, 246, 242));
        jLabel20.setText("Last Name :");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jTextField3.setBackground(new java.awt.Color(77, 148, 98));
        jTextField3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(249, 246, 242));
        jTextField3.setBorder(null);
        jPanel8.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(249, 246, 242));
        jLabel22.setText("First Name :");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jTextField4.setBackground(new java.awt.Color(77, 148, 98));
        jTextField4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(249, 246, 242));
        jTextField4.setBorder(null);
        jPanel8.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 160, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(249, 246, 242));
        jLabel23.setText("City :");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(249, 246, 242));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nablus", "Hebron", "Jurosalem", "beathlehem", "Jenin", "Khan Younes", "Ramallah & Berih", "Rafah", "Selfeet", "South Gaza", "Tubas", "Tulkarem", "Gaza", "Qalqilya" }));
        jComboBox1.setBorder(null);
        jPanel8.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 170, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(249, 246, 242));
        jLabel24.setText("Tel-Phone :");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09", "02", "04", "08" }));
        jComboBox2.setEnabled(false);
        jPanel8.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 60, 20));

        jTextField5.setBackground(new java.awt.Color(77, 148, 98));
        jTextField5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(249, 246, 242));
        jTextField5.setBorder(null);
        jPanel8.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 130, -1));
        jPanel8.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));
        jPanel8.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 10));
        jPanel8.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 170, 10));
        jPanel8.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, 10));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(249, 246, 242));
        jLabel25.setText("Repeat");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, -1));

        javax.swing.GroupLayout homePnlLayout = new javax.swing.GroupLayout(homePnl);
        homePnl.setLayout(homePnlLayout);
        homePnlLayout.setHorizontalGroup(
            homePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePnlLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        homePnlLayout.setVerticalGroup(
            homePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePnlLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 280, Short.MAX_VALUE))
        );

        jPanel6.add(homePnl, "homePnl");

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 850, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void setVisFalse(JLabel lbl1,JLabel lbl,JPasswordField pass,JSeparator separator){
       lbl.setVisible(false);
       lbl1.setVisible(false);
       pass.setVisible(false);
       separator.setVisible(false);
    }
    private void setVisTrue (JLabel lbl1,JLabel lbl,JPasswordField pass,JSeparator separator){
       lbl.setVisible(true);
       lbl1.setVisible(true);
       pass.setVisible(true);
       separator.setVisible(true);
    }
    private void homeCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeCustomerMousePressed
        // TODO add your handling code here:
        homeCustomer.setBackground(new Color(77,148,95));
        jPanel12.setBackground(new Color(142,180,152));
        Farmsbtn.setBackground(new Color(68,131,84));
        jPanel11.setBackground(new Color(68,131,84));
        cardLayout.show(jPanel6,"homePnl");
        //when press on setting shown the data of customer in txt field
        try {
            OracleDataSource or=new OracleDataSource();
            or.setURL("jdbc:oracle:thin:@//localhost:1521/orcl");
            or.setUser("myfarmproj");
            or.setPassword("654321");
            con= or.getConnection(); 
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from custmoer c ,client_number cn where cn.super_client_number"
                    + "=c.client_number and client_number ='"+this.c_number+"'");
            while(rs.next()){
                jTextField4.setText(rs.getString("FIRST_NAME"));
                jTextField3.setText(rs.getString("LAST_NAME"));
                email.setText(rs.getString("C_EMAIL"));
                Addresstxt.setText(rs.getString("STREET"));
                jTextField5.setText(rs.getString("TEL_NUMBER"));
                PNtxt.setText(rs.getString("PHONE_NUMBER"));
                jComboBox1.setSelectedItem(rs.getString("CITY"));
                jComboBox2.setSelectedItem(rs.getString("TEL_CITY_INTRO"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_homeCustomerMousePressed

    private void FarmsbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FarmsbtnMousePressed
        // TODO add your handling code here:
        Farmsbtn.setBackground(new Color(77,148,95));
        jPanel11.setBackground(new Color(142,180,152));
        homeCustomer.setBackground(new Color(68,131,84));
        jPanel12.setBackground(new Color(68,131,84));
        cardLayout.show(jPanel6,"card3");
        cardLayout1.show(farmsPnl,"card2");
        this.jPanel7.removeAll();

        try {
           OracleDataSource or=new OracleDataSource();
            or.setURL("jdbc:oracle:thin:@//localhost:1521/orcl");
            or.setUser("myfarmproj");
            or.setPassword("654321");
            con= or.getConnection(); 
            Statement stmt = con.createStatement();
            ResultSet FarmerResult =stmt.executeQuery("select * from farmer,farmer_number where farmer.SSN = farmer_number.super_ssn ");
            while(FarmerResult.next()){
                farmPnlcard =new farmerPnlcard();
                farmPnlcard.setFarmerName(FarmerResult.getString(1)+FarmerResult.getString(2));
                farmPnlcard.setAddress(FarmerResult.getString(6)+","+FarmerResult.getString(7));
                farmPnlcard.setPhone(String.valueOf(FarmerResult.getInt(10)));
                farmPnlcard.setRank(FarmerResult.getInt(10));
                ssn= ""+FarmerResult.getString("ssn");
                farmPnlcard.setSSN(ssn);
                this.jPanel7.add(farmPnlcard.getpanel());
                farms.add(farmPnlcard);
                MouseHandler l =new MouseHandler();
                farmPnlcard.getpanel().addMouseListener(l);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_FarmsbtnMousePressed

    private class MouseHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
            for(int i =0; i<farms.size();i++){
             if(farms.get(i).getpanel().equals(e.getSource())){
                
             cardLayout1.show(farmsPnl,"card3");
             try{
             Connection con1;
             con1=o.getConnection();
             Statement stmt1=con1.createStatement();
             ResultSet rs1;
             rs1=stmt1.executeQuery("select * from farmer f, farmer_number fn where fn.super_ssn=f.ssn and f.ssn="+farms.get(i).getSSN());
             while(rs1.next()){
             FarmnameDetilPnl.setText(rs1.getString("FIRST_NAME")+rs1.getString("LAST_NAME"));
             AddressDetailPn.setText(rs1.getString("STREET")+"_"+rs1.getString("CITY"));
             TelPhoneDetailPnl.setText("0"+rs1.getString("TEL_CITY_INTRO")+"-"+rs1.getString("TEL_NUMBER"));
             PhoneNumDetailPnl.setText(rs1.getString("PHONE_NUMBER")); 
             rate.setText(""+rs1.getDouble("FARM_RATE"));
             }
             }catch(SQLException e1){
                 System.err.println(e1);
             }
             FarmnameDetilPnl.setText(farms.get(i).getFarmerName());
             AddressDetailPn.setText(farms.get(i).getAddress());
             //TelPhoneDetailPnl.setText("");
             PhoneNumDetailPnl.setText(farms.get(i).getPhone()); 
             rate.setText(rate.getText()+farms.get(i).getRank());
             try{
            Connection conc;     
            conc = o.getConnection();
            Statement stmta =conc.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select p_name,selling_price from planets p,farmer_planets f where super_ssn= "+farms.get(i).getSSN()+" and p.p_barcode=f.super_p_barcode");
             DefaultTableModel model2=(DefaultTableModel) jTable1.getModel();
            int r=jTable1.getRowCount();
            for(int j=r-1;j>=0;j--){
                model2.removeRow(j);
            }
           DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                       while (rs.next()) {
                          //table code
    
                          model.addRow(new Object[]{rs.getString("p_name"),rs.getDouble("selling_price")});
                        } 
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
             break;
            }}
            
      
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
           
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
         //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    private void editLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLabelMousePressed
        // TODO add your handling code here:
        PNtxt.setEditable(true);
    }//GEN-LAST:event_editLabelMousePressed

    private void editLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLabel1MousePressed
        // TODO add your handling code here:
        Addresstxt.setEditable(true);
    }//GEN-LAST:event_editLabel1MousePressed

    private void ChangePassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassMousePressed
        // TODO add your handling code here:
        setVisTrue(jLabel25,OPlbl, OPtxt,OPsep);
        setVisTrue(jLabel25,NPlbl, NPtxt, NPsep);
        setVisTrue(jLabel25,RNPlbl, RNPtxt, RNPsep);
        pas=true;
        
    }//GEN-LAST:event_ChangePassMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if (pas){
            if(new String(OPtxt.getPassword()).equals("")| new String(NPtxt.getPassword()).equals("")|
                new String(RNPtxt.getPassword()).equals("")|jTextField4.getText().equals("")
                    |jTextField3.getText().equals("")|email.getText().equals("")|Addresstxt.getText().equals("")
                    |jTextField5.getText().equals("")|PNtxt.getText().equals(""))
                 JOptionPane.showMessageDialog(null,"There is an empty fields.");
            
            else if (!(new String(NPtxt.getPassword()).equals(new String(RNPtxt.getPassword()))))
                     JOptionPane.showMessageDialog(null,"The new password doesn't match.");}
       
            try{
            Connection con;     
            con = o.getConnection();
            Statement stmt = con.createStatement();
            ResultSet ss =stmt.executeQuery("select * from client where client_number ="+c_number);
             while (ss.next()) {
                 
               if (pas & !(ss.getString("c_password").equals(new String(OPtxt.getPassword()))))
                     JOptionPane.showMessageDialog(null,"The old password is not correct.");
               else if(pas){
                   stmt.executeUpdate("update client set c_password ='"+new String(NPtxt.getPassword())+"',first_name='"
                   +jTextField4.getText()+"',last_name='"+jTextField3.getText()+"',c_email='"+email.getText()
                   +"',city='"+jComboBox1.getSelectedItem()+"',street='"+Addresstxt.getText()+"' where client_number="+this.c_number);
                   stmt.executeUpdate("update client_number set phone_number='"+PNtxt.getText()+"',tel_city_intro='"+
                           jComboBox2.getSelectedItem()+"',tel_number='"+jTextField5.getText()+"' where super_client_number="+this.c_number);
                   JOptionPane.showMessageDialog(null,"The information was changed successfully.");}
               else {
                   stmt.executeUpdate("update client set first_name='"
                   +jTextField4.getText()+"',last_name='"+jTextField3.getText()+"',c_email='"+email.getText()
                   +"',city='"+jComboBox1.getSelectedItem()+"',street='"+Addresstxt.getText()+"'where client_number="+this.c_number);
                   stmt.executeUpdate("update client_number set phone_number='"+PNtxt.getText()+"',tel_city_intro='"+
                           jComboBox2.getSelectedItem()+"',tel_number='"+jTextField5.getText()+"' where super_client_number="+this.c_number);
                    JOptionPane.showMessageDialog(null,"The information was changed successfully.");

                           }
                   } 
             
              con.commit();
              con.close();
            } catch (SQLException ex) {
            Logger.getLogger(cutomerProg.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
         row1=jTable1.rowAtPoint(evt.getPoint());
         col1=jTable1.columnAtPoint(evt.getPoint());
        
        if(col1<2){
            JOptionPane.showMessageDialog(null,"Press on the Department NO.");
        }else{
            if((Boolean)model.getValueAt(row1, col1)){
                jInternalFrame1.setVisible(true);
                model.setValueAt(Boolean.FALSE, row1,col1);}
           
            }//End inner if
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        int row=jTable2.rowAtPoint(evt.getPoint());
        int col=jTable2.columnAtPoint(evt.getPoint());
        if(col<4){
            JOptionPane.showMessageDialog(null,"if you want to remove the planet /n press on remove");
        }else{
            if((Boolean)model.getValueAt(row, 4)){
               model.removeRow(row);
            }

        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        cardLayout1.show(farmsPnl,"card4");
        jInternalFrame2.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed
//*
    //*
    //*
    //*
    //*
    //*
    //*
//this method for Rank
    public void setColor(JLabel lbl){
        lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star_25pxY.png")));
    }
     public void resetColor(JLabel lbl){
        lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star_25px.png")));
    }
   
    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
        
        this.Rank=1;
        setColor(jLabel13);
        resetColor(jLabel12);
        resetColor(jLabel14);
        resetColor(jLabel15);
        resetColor(jLabel16);
        try {
             con= o.getConnection();
             Statement stmta =con.createStatement();
             String g="update farmer " + 
                                "set farme_rate ='"+this.Rank +
                                "'where ssn="+this.ssn;
                  
              stmta.executeUpdate(g);
              con.commit();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,"Thank you for 5/"+this.Rank);
    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
        this.Rank=2;
        setColor(jLabel12);
        setColor(jLabel13);
        resetColor(jLabel14);
        resetColor(jLabel15);
        resetColor(jLabel16);
         try {
             con= o.getConnection();
             Statement stmta =con.createStatement();
             String g="update farmer " + 
                                "set farme_rate ='"+this.Rank +
                                "'where ssn="+this.ssn;
                  
              stmta.executeUpdate(g);
              con.commit();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(null,"Thank you for 5/"+this.Rank);
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        // TODO add your handling code here:
        this.Rank=3;
        setColor(jLabel14);
        setColor(jLabel12);
        setColor(jLabel13);
        resetColor(jLabel15);
        resetColor(jLabel16);
         try {
             con= o.getConnection();
             Statement stmta =con.createStatement();
             String g="update farmer " + 
                                "set farme_rate ='"+this.Rank +
                                "'where ssn="+this.ssn;
                  
              stmta.executeUpdate(g);
              con.commit();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(null,"Thank you for 5/"+this.Rank);
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        this.Rank=4;
        setColor(jLabel15);
        setColor(jLabel12);
        setColor(jLabel14);
        setColor(jLabel13);
        resetColor(jLabel16);
         try {
             con= o.getConnection();
             Statement stmta =con.createStatement();
             String g="update farmer " + 
                                "set farme_rate ='"+this.Rank +
                                "'where ssn="+this.ssn;
                  
              stmta.executeUpdate(g);
              con.commit();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(null,"Thank you for 5/"+this.Rank);
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
        // TODO add your handling code here:
       this.Rank=5;
        setColor(jLabel13);
        setColor(jLabel12);
        setColor(jLabel14);
        setColor(jLabel15);
        setColor(jLabel16);
         try {
             con= o.getConnection();
             Statement stmta =con.createStatement();
             String g="update farmer " + 
                                "set farme_rate ='"+this.Rank +
                                "'where ssn="+this.ssn;
                  
              stmta.executeUpdate(g);
              con.commit();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(null,"Thank you for 5/"+this.Rank);
    }//GEN-LAST:event_jLabel16MousePressed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
         try{
            con= o.getConnection();
            Statement stmt;
            stmt = con.createStatement();
            String n="";
            String g="";
             Calendar c=Calendar.getInstance();
             SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd");
            Date date =new Date();
            String dateString=f.format(date);
             DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
             int countrow=jTable2.getRowCount();
             if(countrow==0){
                 JOptionPane.showMessageDialog(null,"You Don't have a purchases");
             }
             else{
             double totalprice =0;
                for(int i=countrow-1;i>=0;i--){
                 totalprice=totalprice+Double.parseDouble(""+model.getValueAt(i, 3));
                   
             }
              //n = "insert into client_bill values(b_number.naxtval ,"+totalprice+"{d'"+f.format(c.getTime())+"'},"+this.c_number+","+ssn+
                  //     "'no'"+")";
                  n = "insert into client_bill values(b_number.nextval ,"+totalprice+",{d'"+dateString+"'},'"+this.c_number+"','"+ssn+
                       "','no'"+")";
                 stmt.executeUpdate(n);
                 
             for(int i=countrow-1;i>=0;i--){
                
               
                 g="insert into client_bill_planet values(b_number.currval,'"+model.getValueAt(i, 0)+"',"+model.getValueAt(i,2)+","+model.getValueAt(i,3)+")";
                   stmt.executeUpdate(g);
                   
             }
            
             /*g="insert into client_bill_planet values(b_number.currval,";
                   stmt.executeUpdate(n);*/
                   con.commit();
                   con.close();
                    
        jInternalFrame2.setVisible(true);
         }
         }catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_button1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(!jTextField1.getText().equals("")){
          
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
        DefaultTableModel model1=(DefaultTableModel)jTable2.getModel();
        int countRow=jTable2.getRowCount();
        int countCol=jTable2.getColumnCount();
        String Entry="";
        for(int i=0;i<2;i++){
            String e=jTable1.getValueAt(row1, i).toString();
            Entry=Entry+" "+e;
        }
        int i;
        
        boolean flag=true;
        for(i=0;i<countRow;i++){
            String rowEntry = "";
            for(int j=0;j<2;j++){
                rowEntry=rowEntry+" "+jTable2.getValueAt(i,j)+"";
            }
            if(rowEntry.equalsIgnoreCase(Entry)){
               // jTable2.setValueAt(Double.parseDouble(jTable2.getValueAt(i, 2)+"")+Double.parseDouble(jTextField1.getText()),i,2);
               //jTable2.setValueAt(Double.parseDouble(""+model.getValueAt(row1, 1))*Double.parseDouble(jTextField1.getText())+Double.parseDouble(jTable2.getValueAt(i, 3)+""), i, 3);
               jTable2.setValueAt(Double.parseDouble(jTable2.getValueAt(i,2)+"")+Double.parseDouble(jTextField1.getText()), i,2);
               jTable2.setValueAt(Double.parseDouble(jTable2.getValueAt(i,3)+"")+Double.parseDouble(jTextField2.getText()), i,3);
                flag=false;
                
            }/*else{
                model1.addRow(new Object[]{model.getValueAt(row1, 0).toString(),model.getValueAt(row1, 1),jTextField1.getText()});
            }*/
        }
        if(flag&&countRow!=0){
            model1.addRow(new Object[]{
            model.getValueAt(row1, 0),model.getValueAt(row1, 1),jTextField1.getText(),Double.parseDouble(""+Double.parseDouble(model.getValueAt(row1, 1)+""))*Double.parseDouble(jTextField1.getText())});
        }
            if(countRow==0)
             model1.addRow(new Object[]{model.getValueAt(row1, 0),model.getValueAt(row1, 1),jTextField1.getText(),Double.parseDouble(""+Double.parseDouble(model.getValueAt(row1, 1)+""))*Double.parseDouble(jTextField1.getText())});
          jInternalFrame1.setVisible(false);
           jTextField1.setText("");
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        try{
        if(jTextField1.getText().equals(""))
             jTextField2.setText("");
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        double totalPrice=Integer.parseInt(jTextField1.getText())*Double.parseDouble(model.getValueAt(row1,1).toString());
        jTextField2.setText(""+totalPrice);}
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Please Write a real Quntity");
        }
   
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jInternalFrame1.setVisible(false);
        jTextField1.setText("");
        jTextField2.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        // TODO add your handling code here:
        cardLayout1.show(farmsPnl,"card3");
        jInternalFrame1.setVisible(false);
    }//GEN-LAST:event_jLabel18MousePressed

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
        // TODO add your handling code here:
        Object options []={"yes","cancel"};
        int n = JOptionPane.showOptionDialog(this,
                "Did you want to log out ?","log out",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
       if(n==JOptionPane.YES_OPTION){
        new FarmerIntro1("Customer").setVisible(true);
        this.setVisible(false);
       }
       else{
           this.setVisible(true);
       }
    }//GEN-LAST:event_jPanel10MousePressed

    private void jLabel26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel26MousePressed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        Connection con;
        try {
            con = o.getConnection();
            InputStream input =new FileInputStream("bill1.jrxml");
            JasperDesign jd= JRXmlLoader.load(input);
            Statement stmt =con.createStatement();
            ResultSet rs=stmt.executeQuery("select max (bill_num) from client_bill where super_client_number = "+this.c_number+ " and super_ssn = "+this.ssn);
           String billNum="";
            while (rs.next()) {
               billNum=rs.getString(1);
            }
            //String sql="select * from client_bill_planet cbp, client_bill cb where cbp.super_bill_num = cb.bill_num and cb.super_ssn =  "+ this.ssn +" and cb.SUPER_CLIENT_NUMBER = "+this.c_number;
            String sql="select * from client_bill_planet cbp, client_bill cb where cbp.super_bill_num = cb.bill_num and cb.super_ssn =  "+ this.ssn +" and cb.SUPER_CLIENT_NUMBER = "+this.c_number+"and bill_num = "+billNum;
        //JasperReport jr= JasperCompileManager.compileReport(jd);
            JRDesignQuery newQ =new JRDesignQuery();
            newQ.setText(sql);
            jd.setQuery(newQ);
            JasperReport jr= JasperCompileManager.compileReport(jd);
        JasperPrint jp=JasperFillManager.fillReport(jr,null,con);
        JFrame frame= new JFrame("Bill");
        frame.getContentPane().add(new JRViewer(jp));
        frame.pack();
        frame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(cutomerProg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(cutomerProg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(cutomerProg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(cutomerProg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cutomerProg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cutomerProg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cutomerProg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cutomerProg(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressDetailPn;
    private javax.swing.JTextField Addresstxt;
    private javax.swing.JLabel ChangePass;
    private javax.swing.JLabel FarmnameDetilPnl;
    private javax.swing.JPanel Farmsbtn;
    private javax.swing.JLabel NPlbl;
    private javax.swing.JSeparator NPsep;
    private javax.swing.JPasswordField NPtxt;
    private javax.swing.JLabel OPlbl;
    private javax.swing.JSeparator OPsep;
    private javax.swing.JPasswordField OPtxt;
    private javax.swing.JTextField PNtxt;
    private javax.swing.JLabel PhoneNumDetailPnl;
    private javax.swing.JLabel RNPlbl;
    private javax.swing.JSeparator RNPsep;
    private javax.swing.JPasswordField RNPtxt;
    private javax.swing.JLabel TelPhoneDetailPnl;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel editLabel;
    private javax.swing.JLabel editLabel1;
    private javax.swing.JTextField email;
    private javax.swing.JPanel farmDetil;
    private javax.swing.JPanel farmsPnl;
    private javax.swing.JPanel homeCustomer;
    private javax.swing.JPanel homePnl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel name;
    private javax.swing.JLabel rate;
    // End of variables declaration//GEN-END:variables
}


