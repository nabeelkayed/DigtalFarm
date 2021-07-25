
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.pool.OracleDataSource;
import oracle.net.aso.h;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ammr6
 */
public class farmerprog extends javax.swing.JFrame {

    private Component FarmerIntro1;
    CardLayout cardLayout;
    CardLayout cardLayout1;
    CardLayout cardLayout2;
    CardLayout cardLayout3;
    CardLayout cardLayout4;
    CardLayout cardLayout5;
    CardLayout cardLayout6;
    int row,row1;
    int col,col1;
    String ssn="";
    Connection con;
    String oldphone;
    OracleDataSource o;
    boolean pas;
    /**
     * Creates new form farmerprog
     */
    public farmerprog(String ssn) {
        initComponents();
        this.setLocationRelativeTo(FarmerIntro1);
        showDate();
        showTime();
        jLabel17.setVisible(false);
        String Str="<html><u>change Password.</u></html>";
        ChangPass.setText(Str);
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        jTable1.getTableHeader().setBackground(new Color(142,180,152));
        jTable1.getTableHeader().setForeground(Color.BLACK);
        cardLayout=(CardLayout)(PanelCard.getLayout());
        //cardLayout1=(CardLayout)(CustomerPanel.getLayout());
        cardLayout5=(CardLayout)(DepartMentPanel.getLayout());
        cardLayout2=(CardLayout)(InternalCard.getLayout());
        cardLayout3=(CardLayout)(Internalcard1.getLayout());
        cardLayout4=(CardLayout)(Internalcard4.getLayout());
        cardLayout6=(CardLayout)(HomePanel.getLayout());
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        oldPassLbl.setVisible(false);
        oldPassTxt.setVisible(false);
        NewPassLbl.setVisible(false);
        NewPassTxt.setVisible(false);
        ReapetLbl.setVisible(false);
        RNewPassLbl.setVisible(false);
        RnewPassTxr.setVisible(false);
        pas=false;
        this.ssn=ssn;
        cardLayout.show(PanelCard,"HomePanel");
        cardLayout6.show(HomePanel,"card2");
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int countrowJtable1=jTable1.getRowCount();
        for(int i=countrowJtable1-1;i>=0;i--){
            model.removeRow(i);
        }
        
        try {
            o=new OracleDataSource();
            o.setURL("jdbc:oracle:thin:@//localhost:1521/orcl");
            o.setUser("myfarmproj");
            o.setPassword("654321");
            con= o.getConnection(); 
           
             ResultSet ss,rr;
             String g="";
             Statement stmta =con.createStatement();
             ss =stmta.executeQuery("select * from farmer f , farmer_number fn where fn.super_ssn = f.ssn and ssn ="+this.ssn);
             while (ss.next()) {
                 jLabel23.setText(ss.getString("first_name")+" "+ss.getString("last_name"));
                 jLabel25.setText(ss.getString("City")+"_"+ss.getString("street"));
                 jLabel16.setText("0"+ss.getString("tel_city_intro")+"-"+ss.getString("tel_number"));
                 jLabel19.setText("Hello "+ss.getString("first_name"));
                 jLabel81.setText("0"+ss.getString("phone_number"));
             }
          /*  Statement stmtan =con.createStatement();

             rr= stmtan.executeQuery("select * from farmer_number where super_ssn ="+this.ssn);
              while (rr.next()) {
                 EditTelTxt.setText(rr.getString(3));
                 editPhonTxt.setText(rr.getString(1));
                 
             }
             con.close();*/
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
   
         try{//home table
            con= o.getConnection();
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select * from client c,client_bill cb,client_number cn where c.client_number = cb.super_client_number"
                    + " and c.client_number = cn.super_client_number and super_ssn="+this.ssn);
                   int count = 0;
                       while (rs.next()) {
                          model.addRow(new Object[]{rs.getString("BILL_NUM"),rs.getString("FIRST_NAME")+rs.getString("LAST_NAME"),rs.getString("PHONE_NUMBER"),rs.getString("Street")+"_"+rs.getString("city")
                          ,rs.getDouble("TOTAL_PRICE"),rs.getDate("SOLD_DATE")});
                        } 
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    void showDate(){
    Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
        datelabel.setText(s.format(d));
    }
    void showTime(){
      new Timer(0, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent arg0) {
              Date d=new Date();
              SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss a");
              Timelabel.setText(s.format(d));
          }
      }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField41 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        BtnPnls = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        HomePanelButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sider1 = new javax.swing.JPanel();
        MoneyPanelbutton = new javax.swing.JPanel();
        sider2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        DepatmentPanelButton = new javax.swing.JPanel();
        sider4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        EmployeePanelButton = new javax.swing.JPanel();
        sider5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        plantsPanelButton = new javax.swing.JPanel();
        sider6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        LogOutPanelButton = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        SettingPanelButton = new javax.swing.JPanel();
        sider7 = new javax.swing.JPanel();
        SettingLbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Timelabel = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        PanelCard = new javax.swing.JPanel();
        HomePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        EditEmailTxt = new javax.swing.JTextField();
        StreetTXt = new javax.swing.JTextField();
        EditTelTxt = new javax.swing.JTextField();
        editPhonTxt = new javax.swing.JTextField();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        ChangPass = new javax.swing.JLabel();
        oldPassLbl = new javax.swing.JLabel();
        NewPassLbl = new javax.swing.JLabel();
        ReapetLbl = new javax.swing.JLabel();
        RNewPassLbl = new javax.swing.JLabel();
        oldPassTxt = new javax.swing.JTextField();
        NewPassTxt = new javax.swing.JTextField();
        RnewPassTxr = new javax.swing.JTextField();
        jSeparator28 = new javax.swing.JSeparator();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        edit1 = new javax.swing.JLabel();
        edit2 = new javax.swing.JLabel();
        edit3 = new javax.swing.JLabel();
        edit4 = new javax.swing.JLabel();
        edit5 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        FnameTxt = new javax.swing.JTextField();
        edit6 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel83 = new javax.swing.JLabel();
        LnameTxt = new javax.swing.JTextField();
        jSeparator32 = new javax.swing.JSeparator();
        edit7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        MoneyCalPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jSeparator33 = new javax.swing.JSeparator();
        DepartMentPanel = new javax.swing.JPanel();
        DepartmentHome = new javax.swing.JPanel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        Internalcard4 = new javax.swing.JPanel();
        RemoveDepartmentPnl = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        UpdateDepartment = new javax.swing.JPanel();
        jTextField57 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jTextField60 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jTextField61 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jTextField62 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel119 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        UpdateAddDepartmentPnl = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        SearchDepartmentTxt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        UpdatedepartmentBtn = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        AddDepartmentBtn = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        RmoveDepartmentBtn = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        EployeePanel = new javax.swing.JPanel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        InternalCard = new javax.swing.JPanel();
        updateAddPnl = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        DismissBtn = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        SaveBtn1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel122 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        RemovePnl = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        saveBtn1 = new javax.swing.JButton();
        DismissBtn1 = new javax.swing.JButton();
        UpdateemployeePnl = new javax.swing.JPanel();
        jTextField48 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jTextField49 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        SaveBtn2 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel103 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField7 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jTextField69 = new javax.swing.JTextField();
        SearchEmploTxt = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        UpdatePnlBtn = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        AddPnlBtn1 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        RemovePnlBtn1 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        PlantsPanel = new javax.swing.JPanel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        Internalcard1 = new javax.swing.JPanel();
        UpdateAddPlantPnl = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        DismissPantBtn = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        RemovePlantPnl = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        UpdatePlantPnl = new javax.swing.JPanel();
        jTextField63 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jTextField64 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jTextField65 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jTextField66 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jTextField68 = new javax.swing.JTextField();
        jTextField70 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jTextField71 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel116 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        UpdatePlantBtn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        AddPlantBtn = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        RmovePlantBtn = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();

        jTextField41.setText("jTextField41");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 246, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnPnls.setBackground(new java.awt.Color(51, 119, 68));
        BtnPnls.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sakkal Majalla", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 246, 242));
        jLabel1.setText("Digital Farm");
        BtnPnls.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 15));
        BtnPnls.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 82, 288, 10));

        HomePanelButton.setBackground(new java.awt.Color(77, 148, 95));
        HomePanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homepanelbutton(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 246, 242));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer_32px.png"))); // NOI18N
        jLabel3.setText("Home");

        sider1.setBackground(new java.awt.Color(142, 180, 152));

        javax.swing.GroupLayout sider1Layout = new javax.swing.GroupLayout(sider1);
        sider1.setLayout(sider1Layout);
        sider1Layout.setHorizontalGroup(
            sider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sider1Layout.setVerticalGroup(
            sider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout HomePanelButtonLayout = new javax.swing.GroupLayout(HomePanelButton);
        HomePanelButton.setLayout(HomePanelButtonLayout);
        HomePanelButtonLayout.setHorizontalGroup(
            HomePanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelButtonLayout.createSequentialGroup()
                .addComponent(sider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        HomePanelButtonLayout.setVerticalGroup(
            HomePanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelButtonLayout.createSequentialGroup()
                .addGroup(HomePanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnPnls.add(HomePanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 310, 50));

        MoneyPanelbutton.setBackground(new java.awt.Color(68, 131, 84));
        MoneyPanelbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MoneyPanel(evt);
            }
        });

        sider2.setBackground(new java.awt.Color(68, 131, 84));

        javax.swing.GroupLayout sider2Layout = new javax.swing.GroupLayout(sider2);
        sider2.setLayout(sider2Layout);
        sider2Layout.setHorizontalGroup(
            sider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sider2Layout.setVerticalGroup(
            sider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(249, 246, 242));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/money_32px.png"))); // NOI18N
        jLabel2.setText("  Money calculation");

        javax.swing.GroupLayout MoneyPanelbuttonLayout = new javax.swing.GroupLayout(MoneyPanelbutton);
        MoneyPanelbutton.setLayout(MoneyPanelbuttonLayout);
        MoneyPanelbuttonLayout.setHorizontalGroup(
            MoneyPanelbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MoneyPanelbuttonLayout.createSequentialGroup()
                .addComponent(sider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        MoneyPanelbuttonLayout.setVerticalGroup(
            MoneyPanelbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MoneyPanelbuttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnPnls.add(MoneyPanelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 310, 50));

        DepatmentPanelButton.setBackground(new java.awt.Color(68, 131, 84));
        DepatmentPanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                departmentPanel(evt);
            }
        });

        sider4.setBackground(new java.awt.Color(68, 131, 84));

        javax.swing.GroupLayout sider4Layout = new javax.swing.GroupLayout(sider4);
        sider4.setLayout(sider4Layout);
        sider4Layout.setHorizontalGroup(
            sider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sider4Layout.setVerticalGroup(
            sider4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(249, 246, 242));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/department_32px.png"))); // NOI18N
        jLabel8.setText("Departments");

        javax.swing.GroupLayout DepatmentPanelButtonLayout = new javax.swing.GroupLayout(DepatmentPanelButton);
        DepatmentPanelButton.setLayout(DepatmentPanelButtonLayout);
        DepatmentPanelButtonLayout.setHorizontalGroup(
            DepatmentPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DepatmentPanelButtonLayout.createSequentialGroup()
                .addComponent(sider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel8)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        DepatmentPanelButtonLayout.setVerticalGroup(
            DepatmentPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sider4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        BtnPnls.add(DepatmentPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 310, 50));

        EmployeePanelButton.setBackground(new java.awt.Color(68, 131, 84));
        EmployeePanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                employeePanel(evt);
            }
        });

        sider5.setBackground(new java.awt.Color(68, 131, 84));

        javax.swing.GroupLayout sider5Layout = new javax.swing.GroupLayout(sider5);
        sider5.setLayout(sider5Layout);
        sider5Layout.setHorizontalGroup(
            sider5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sider5Layout.setVerticalGroup(
            sider5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(249, 246, 242));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee_32px.png"))); // NOI18N
        jLabel10.setText("Employees");

        javax.swing.GroupLayout EmployeePanelButtonLayout = new javax.swing.GroupLayout(EmployeePanelButton);
        EmployeePanelButton.setLayout(EmployeePanelButtonLayout);
        EmployeePanelButtonLayout.setHorizontalGroup(
            EmployeePanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeePanelButtonLayout.createSequentialGroup()
                .addComponent(sider5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel10)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        EmployeePanelButtonLayout.setVerticalGroup(
            EmployeePanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeePanelButtonLayout.createSequentialGroup()
                .addComponent(sider5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeePanelButtonLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnPnls.add(EmployeePanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 310, -1));

        plantsPanelButton.setBackground(new java.awt.Color(68, 131, 84));
        plantsPanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                plantsPanel(evt);
            }
        });

        sider6.setBackground(new java.awt.Color(68, 131, 84));

        javax.swing.GroupLayout sider6Layout = new javax.swing.GroupLayout(sider6);
        sider6.setLayout(sider6Layout);
        sider6Layout.setHorizontalGroup(
            sider6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sider6Layout.setVerticalGroup(
            sider6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(249, 246, 242));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carbohydrates_32px.png"))); // NOI18N
        jLabel12.setText("Plants");

        javax.swing.GroupLayout plantsPanelButtonLayout = new javax.swing.GroupLayout(plantsPanelButton);
        plantsPanelButton.setLayout(plantsPanelButtonLayout);
        plantsPanelButtonLayout.setHorizontalGroup(
            plantsPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plantsPanelButtonLayout.createSequentialGroup()
                .addComponent(sider6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        plantsPanelButtonLayout.setVerticalGroup(
            plantsPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plantsPanelButtonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sider6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BtnPnls.add(plantsPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 310, 50));

        LogOutPanelButton.setBackground(new java.awt.Color(68, 131, 84));
        LogOutPanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogOutPanelButtonMousePressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(249, 246, 242));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sign_out_32px.png"))); // NOI18N
        jLabel14.setText("Log out");

        javax.swing.GroupLayout LogOutPanelButtonLayout = new javax.swing.GroupLayout(LogOutPanelButton);
        LogOutPanelButton.setLayout(LogOutPanelButtonLayout);
        LogOutPanelButtonLayout.setHorizontalGroup(
            LogOutPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogOutPanelButtonLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        LogOutPanelButtonLayout.setVerticalGroup(
            LogOutPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        BtnPnls.add(LogOutPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 310, 50));

        SettingPanelButton.setBackground(new java.awt.Color(68, 131, 84));
        SettingPanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SettingPanelButtonMousePressed(evt);
            }
        });

        sider7.setBackground(new java.awt.Color(68, 131, 84));

        javax.swing.GroupLayout sider7Layout = new javax.swing.GroupLayout(sider7);
        sider7.setLayout(sider7Layout);
        sider7Layout.setHorizontalGroup(
            sider7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        sider7Layout.setVerticalGroup(
            sider7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        SettingLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SettingLbl.setForeground(new java.awt.Color(249, 242, 246));
        SettingLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings_32px.png"))); // NOI18N
        SettingLbl.setText("Settings");

        javax.swing.GroupLayout SettingPanelButtonLayout = new javax.swing.GroupLayout(SettingPanelButton);
        SettingPanelButton.setLayout(SettingPanelButtonLayout);
        SettingPanelButtonLayout.setHorizontalGroup(
            SettingPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingPanelButtonLayout.createSequentialGroup()
                .addComponent(sider7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SettingLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        SettingPanelButtonLayout.setVerticalGroup(
            SettingPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingPanelButtonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(SettingPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SettingLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sider7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        BtnPnls.add(SettingPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 310, 50));

        jPanel1.add(BtnPnls, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 641));

        jPanel3.setBackground(new java.awt.Color(66, 155, 88));
        jPanel3.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(249, 246, 242));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telephone_25px.png"))); // NOI18N
        jLabel16.setText("0000000000");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(530, 80, 150, 25);

        jLabel17.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(249, 246, 242));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rating_25px.png"))); // NOI18N
        jLabel17.setText("5 / ");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(530, 180, 150, 25);

        jPanel18.setBackground(new java.awt.Color(54, 104, 67));
        jPanel18.setForeground(new java.awt.Color(68, 102, 76));

        jLabel19.setFont(new java.awt.Font("Sakkal Majalla", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(249, 246, 242));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/male_user_64px.png"))); // NOI18N
        jLabel19.setText("Hello");

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(249, 246, 242));
        jLabel124.setText("X");
        jLabel124.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel124MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
                .addComponent(jLabel124)
                .addGap(18, 18, 18))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel18);
        jPanel18.setBounds(-10, 0, 780, 70);
        jPanel3.add(jLabel21);
        jLabel21.setBounds(710, 110, 30, 30);

        jLabel23.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(249, 246, 242));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/name_25px.png"))); // NOI18N
        jLabel23.setText("jLabel23");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(80, 80, 180, 30);

        jLabel25.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(249, 246, 242));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/address_25px.png"))); // NOI18N
        jLabel25.setText("jLabel25");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(80, 120, 160, 25);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar_32px.png"))); // NOI18N
        jPanel3.add(jLabel26);
        jLabel26.setBounds(80, 170, 30, 40);

        Timelabel.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        Timelabel.setForeground(new java.awt.Color(249, 246, 242));
        Timelabel.setText("Time");
        jPanel3.add(Timelabel);
        Timelabel.setBounds(120, 190, 160, 30);

        datelabel.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        datelabel.setForeground(new java.awt.Color(249, 246, 242));
        datelabel.setText("Date");
        jPanel3.add(datelabel);
        datelabel.setBounds(120, 150, 160, 40);

        jLabel81.setFont(new java.awt.Font("Sakkal Majalla", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(249, 246, 242));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phonelink_ring_25px.png"))); // NOI18N
        jLabel81.setText("0590000000");
        jPanel3.add(jLabel81);
        jLabel81.setBounds(530, 130, 150, 25);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 770, 230));

        PanelCard.setBackground(new java.awt.Color(249, 246, 242));
        PanelCard.setLayout(new java.awt.CardLayout());

        HomePanel.setBackground(new java.awt.Color(249, 246, 242));
        HomePanel.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(249, 246, 242));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("E-mail :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("City :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Street :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Tel-Phone number :");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel120.setText("Phone_Number :");
        jPanel2.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        EditEmailTxt.setBackground(new java.awt.Color(249, 246, 242));
        EditEmailTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EditEmailTxt.setBorder(null);
        jPanel2.add(EditEmailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 176, 20));

        StreetTXt.setBackground(new java.awt.Color(249, 246, 242));
        StreetTXt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StreetTXt.setBorder(null);
        jPanel2.add(StreetTXt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 180, 20));

        EditTelTxt.setBackground(new java.awt.Color(249, 246, 242));
        EditTelTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        EditTelTxt.setBorder(null);
        jPanel2.add(EditTelTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 160, 30));

        editPhonTxt.setBackground(new java.awt.Color(249, 246, 242));
        editPhonTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editPhonTxt.setBorder(null);
        jPanel2.add(editPhonTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 180, 30));
        jPanel2.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, 10));
        jPanel2.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 180, 10));
        jPanel2.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 160, 10));
        jPanel2.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 190, 20));

        jComboBox4.setBackground(new java.awt.Color(249, 246, 242));
        jComboBox4.setEditable(true);
        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nablus", "Hebron", "Jurosalem", "beathlehem", "Jenin", "Khan Younes", "Ramallah & Berih", "Rafah", "Selfeet", "South Gaza", "Tubas", "Tulkarem", "Gaza", "Qalqilya", "Jericho" }));
        jComboBox4.setBorder(null);
        jComboBox4.setEnabled(false);
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 180, 30));

        jComboBox5.setEditable(true);
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09", "02", "04", "08" }));
        jComboBox5.setBorder(null);
        jComboBox5.setEnabled(false);
        jPanel2.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 60, 40));

        ChangPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ChangPass.setText("jLabel122");
        ChangPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ChangPassMousePressed(evt);
            }
        });
        jPanel2.add(ChangPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 240, -1));

        oldPassLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        oldPassLbl.setText("Old Password :");
        jPanel2.add(oldPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        NewPassLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NewPassLbl.setText("New Password :");
        jPanel2.add(NewPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        ReapetLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ReapetLbl.setText("Reapet ");
        jPanel2.add(ReapetLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        RNewPassLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RNewPassLbl.setText("New Password :");
        jPanel2.add(RNewPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 127, -1, 30));

        oldPassTxt.setBackground(new java.awt.Color(249, 246, 242));
        oldPassTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        oldPassTxt.setBorder(null);
        jPanel2.add(oldPassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 160, 20));

        NewPassTxt.setBackground(new java.awt.Color(249, 246, 242));
        NewPassTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NewPassTxt.setBorder(null);
        jPanel2.add(NewPassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 160, 20));

        RnewPassTxr.setBackground(new java.awt.Color(249, 246, 242));
        RnewPassTxr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RnewPassTxr.setBorder(null);
        jPanel2.add(RnewPassTxr, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 160, 20));
        jPanel2.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 160, -1));
        jPanel2.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 160, -1));
        jPanel2.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 160, 10));

        jButton1.setBackground(new java.awt.Color(51, 119, 68));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 90, 40));

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 0, 0));
        jLabel121.setText("Delete account ");
        jPanel2.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 90, 30));

        edit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_25pxg.png"))); // NOI18N
        edit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit1MousePressed(evt);
            }
        });
        jPanel2.add(edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        edit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_25pxg.png"))); // NOI18N
        edit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit2MousePressed(evt);
            }
        });
        jPanel2.add(edit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        edit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_25pxg.png"))); // NOI18N
        edit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit3MousePressed(evt);
            }
        });
        jPanel2.add(edit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        edit4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_25pxg.png"))); // NOI18N
        edit4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit4MousePressed(evt);
            }
        });
        jPanel2.add(edit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        edit5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_25pxg.png"))); // NOI18N
        edit5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit5MousePressed(evt);
            }
        });
        jPanel2.add(edit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("First name :");
        jPanel2.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        FnameTxt.setBackground(new java.awt.Color(249, 246, 242));
        FnameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FnameTxt.setBorder(null);
        jPanel2.add(FnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, 20));

        edit6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_25pxg.png"))); // NOI18N
        edit6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit6MousePressed(evt);
            }
        });
        jPanel2.add(edit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));
        jPanel2.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 180, 10));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel83.setText("Last name :");
        jPanel2.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        LnameTxt.setBackground(new java.awt.Color(249, 246, 242));
        LnameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LnameTxt.setBorder(null);
        jPanel2.add(LnameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 180, 20));
        jPanel2.add(jSeparator32, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 180, 10));

        edit7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_25pxg.png"))); // NOI18N
        edit7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit7MousePressed(evt);
            }
        });
        jPanel2.add(edit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        HomePanel.add(jPanel2, "card3");

        jPanel4.setBackground(new java.awt.Color(249, 246, 242));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(249, 246, 242));
        jTable1.setFont(new java.awt.Font("Sakkal Majalla", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "bill number", "Customer name", "Phone number", "Adress", "Total Price", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(51, 119, 68));
        jTable1.setSelectionForeground(new java.awt.Color(249, 246, 242));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 760, 369));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search_20px.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jTextField13.setBackground(new java.awt.Color(249, 246, 242));
        jTextField13.setBorder(null);
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });
        jPanel4.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 10, 210, 20));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 220, 10));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Filter", "Bill Number", "Customer Name", "Date" }));
        jComboBox1.setBorder(null);
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 180, -1));

        HomePanel.add(jPanel4, "card2");

        PanelCard.add(HomePanel, "HomePanel");

        MoneyCalPanel.setBackground(new java.awt.Color(249, 246, 242));
        MoneyCalPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Department No.", "Fertilizer cost", "Water cost", "Seeds cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setRowHeight(30);
        jScrollPane8.setViewportView(jTable6);

        MoneyCalPanel.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 199, 760, 200));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sales in farm :");
        MoneyCalPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 90, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Water cost in farm :");
        MoneyCalPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Fertilizer cost in farm :");
        MoneyCalPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Profit in farm :");
        MoneyCalPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Seeds cost in farm :");
        MoneyCalPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(249, 246, 242));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setBorder(null);
        MoneyCalPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 170, 20));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(249, 246, 242));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.setBorder(null);
        MoneyCalPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 160, 20));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(249, 246, 242));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField3.setBorder(null);
        MoneyCalPanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 160, 20));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(249, 246, 242));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField4.setBorder(null);
        MoneyCalPanel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 160, 20));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(249, 246, 242));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField5.setBorder(null);
        MoneyCalPanel.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 180, 20));
        MoneyCalPanel.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 170, 10));
        MoneyCalPanel.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 160, 10));
        MoneyCalPanel.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 160, 10));
        MoneyCalPanel.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 160, 10));
        MoneyCalPanel.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 180, 10));

        jLabel86.setText("Water Price :");
        MoneyCalPanel.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 80, 20));

        jLabel87.setText("Fertilizer Price :");
        MoneyCalPanel.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 80, -1));

        jLabel88.setText("Tax :");
        MoneyCalPanel.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 30, -1));

        jTextField23.setBackground(new java.awt.Color(249, 246, 242));
        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField23.setBorder(null);
        MoneyCalPanel.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 170, 20));

        jTextField40.setBackground(new java.awt.Color(249, 246, 242));
        jTextField40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField40.setBorder(null);
        MoneyCalPanel.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 170, 20));

        jTextField42.setBackground(new java.awt.Color(249, 246, 242));
        jTextField42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField42.setBorder(null);
        MoneyCalPanel.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 170, 20));
        MoneyCalPanel.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 170, 10));
        MoneyCalPanel.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 170, 10));
        MoneyCalPanel.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 170, 10));

        jButton2.setBackground(new java.awt.Color(51, 119, 68));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Save ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        MoneyCalPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 110, 70, -1));

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel90.setText("Total Salary : ");
        MoneyCalPanel.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jTextField44.setEditable(false);
        jTextField44.setBackground(new java.awt.Color(249, 246, 242));
        jTextField44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField44.setBorder(null);
        MoneyCalPanel.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 180, 20));
        MoneyCalPanel.add(jSeparator33, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 180, 10));

        PanelCard.add(MoneyCalPanel, "MoneyCalPanel");

        DepartMentPanel.setBackground(new java.awt.Color(249, 246, 242));
        DepartMentPanel.setLayout(new java.awt.CardLayout());

        DepartmentHome.setBackground(new java.awt.Color(249, 246, 242));
        DepartmentHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame4.setVisible(true);

        Internalcard4.setLayout(new java.awt.CardLayout());

        RemoveDepartmentPnl.setBackground(new java.awt.Color(249, 246, 242));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(51, 119, 68));
        jLabel79.setText("Rmove Department");

        jLabel80.setText("Department No. :");

        jTextField39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton8.setBackground(new java.awt.Color(51, 119, 68));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("Remove");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(51, 119, 68));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("Dismiss");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RemoveDepartmentPnlLayout = new javax.swing.GroupLayout(RemoveDepartmentPnl);
        RemoveDepartmentPnl.setLayout(RemoveDepartmentPnlLayout);
        RemoveDepartmentPnlLayout.setHorizontalGroup(
            RemoveDepartmentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RemoveDepartmentPnlLayout.createSequentialGroup()
                .addGroup(RemoveDepartmentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RemoveDepartmentPnlLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RemoveDepartmentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(RemoveDepartmentPnlLayout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RemoveDepartmentPnlLayout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(jLabel80)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        RemoveDepartmentPnlLayout.setVerticalGroup(
            RemoveDepartmentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RemoveDepartmentPnlLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(RemoveDepartmentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(RemoveDepartmentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        Internalcard4.add(RemoveDepartmentPnl, "RemoveDepartmentPnl");

        UpdateDepartment.setBackground(new java.awt.Color(249, 246, 242));
        UpdateDepartment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField57.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateDepartment.add(jTextField57, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 145, -1));

        jLabel104.setText("Department NO. :");
        UpdateDepartment.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jButton14.setBackground(new java.awt.Color(51, 119, 68));
        jButton14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton14.setText("Search");
        jButton14.setBorder(null);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        UpdateDepartment.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 95, 31));

        jTextField58.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateDepartment.add(jTextField58, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 145, -1));

        jTextField59.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateDepartment.add(jTextField59, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 145, -1));

        jLabel105.setText("Manager ssn :");
        UpdateDepartment.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jLabel106.setText("Location :");
        UpdateDepartment.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jTextField60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateDepartment.add(jTextField60, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 145, -1));

        jLabel107.setText("Crop Type :");
        UpdateDepartment.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 100, 90, 20));

        jTextField61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateDepartment.add(jTextField61, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 149, -1));

        jLabel108.setText("Crop Number :");
        UpdateDepartment.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        jLabel109.setText("water needed / liter:");
        UpdateDepartment.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        jTextField62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateDepartment.add(jTextField62, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 149, -1));

        jButton15.setBackground(new java.awt.Color(51, 119, 68));
        jButton15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton15.setText("Update");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        UpdateDepartment.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 90, 30));

        jButton16.setBackground(new java.awt.Color(51, 119, 68));
        jButton16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton16.setText("Dismiss");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        UpdateDepartment.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 90, 30));

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(51, 119, 68));
        jLabel119.setText("Update department");
        UpdateDepartment.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel77.setText("Fertilizer need / unit :");
        UpdateDepartment.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 120, 20));

        jTextField38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateDepartment.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 150, -1));

        Internalcard4.add(UpdateDepartment, "card4");

        UpdateAddDepartmentPnl.setBackground(new java.awt.Color(249, 246, 242));
        UpdateAddDepartmentPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setText("Department NO. :");
        UpdateAddDepartmentPnl.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel73.setText("Location :");
        UpdateAddDepartmentPnl.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel74.setText("Manager SSN :");
        UpdateAddDepartmentPnl.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 20));

        jLabel75.setText("Crop Type :");
        UpdateAddDepartmentPnl.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel76.setText("Crop Number :");
        UpdateAddDepartmentPnl.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        jTextField33.setEditable(false);
        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateAddDepartmentPnl.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 150, -1));

        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateAddDepartmentPnl.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 150, -1));

        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateAddDepartmentPnl.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 150, -1));

        jTextField36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField36ActionPerformed(evt);
            }
        });
        UpdateAddDepartmentPnl.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 150, -1));

        jTextField37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateAddDepartmentPnl.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 149, -1));

        jButton7.setBackground(new java.awt.Color(51, 119, 68));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Dismiss");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        UpdateAddDepartmentPnl.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 96, 31));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(51, 119, 68));
        jLabel78.setText("Add Department");
        UpdateAddDepartmentPnl.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 11, 278, 51));

        jButton10.setBackground(new java.awt.Color(51, 119, 68));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setText("Save");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        UpdateAddDepartmentPnl.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 95, 31));

        jLabel62.setText("Water neede / liter :");
        UpdateAddDepartmentPnl.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateAddDepartmentPnl.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 150, -1));

        jLabel85.setText("Fertilizer need /unit :");
        UpdateAddDepartmentPnl.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        UpdateAddDepartmentPnl.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 150, -1));

        Internalcard4.add(UpdateAddDepartmentPnl, "UpdateAddDepartmentPnl");

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Internalcard4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Internalcard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        DepartmentHome.add(jInternalFrame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 640, 340));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search_20px.png"))); // NOI18N
        DepartmentHome.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        SearchDepartmentTxt.setBackground(new java.awt.Color(249, 246, 242));
        SearchDepartmentTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchDepartmentTxt.setBorder(null);
        SearchDepartmentTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchDepartmentTxtKeyReleased(evt);
            }
        });
        DepartmentHome.add(SearchDepartmentTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, -1));
        DepartmentHome.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 260, 10));

        jComboBox2.setBackground(new java.awt.Color(249, 246, 242));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select filter", "Department NO.", "Manager SSN", "Crop Type" }));
        jComboBox2.setBorder(null);
        DepartmentHome.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 140, -1));

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Department NO.", "Location", "Manger SSN", "Crop Type", "Crop Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(30);
        jScrollPane3.setViewportView(jTable3);

        DepartmentHome.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 740, 270));

        UpdatedepartmentBtn.setBackground(new java.awt.Color(233, 222, 208));
        UpdatedepartmentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdatedepartmentBtnMousePressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update_25px.png"))); // NOI18N
        jLabel38.setText("Update");

        javax.swing.GroupLayout UpdatedepartmentBtnLayout = new javax.swing.GroupLayout(UpdatedepartmentBtn);
        UpdatedepartmentBtn.setLayout(UpdatedepartmentBtnLayout);
        UpdatedepartmentBtnLayout.setHorizontalGroup(
            UpdatedepartmentBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatedepartmentBtnLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        UpdatedepartmentBtnLayout.setVerticalGroup(
            UpdatedepartmentBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatedepartmentBtnLayout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        DepartmentHome.add(UpdatedepartmentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 40));

        AddDepartmentBtn.setBackground(new java.awt.Color(233, 222, 208));
        AddDepartmentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddDepartmentBtnMousePressed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_new_25px.png"))); // NOI18N
        jLabel39.setText("Add");

        javax.swing.GroupLayout AddDepartmentBtnLayout = new javax.swing.GroupLayout(AddDepartmentBtn);
        AddDepartmentBtn.setLayout(AddDepartmentBtnLayout);
        AddDepartmentBtnLayout.setHorizontalGroup(
            AddDepartmentBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddDepartmentBtnLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        AddDepartmentBtnLayout.setVerticalGroup(
            AddDepartmentBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddDepartmentBtnLayout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DepartmentHome.add(AddDepartmentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 210, 40));

        RmoveDepartmentBtn.setBackground(new java.awt.Color(233, 222, 208));
        RmoveDepartmentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RmoveDepartmentBtnMousePressed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove_25px.png"))); // NOI18N
        jLabel40.setText("Remove");

        javax.swing.GroupLayout RmoveDepartmentBtnLayout = new javax.swing.GroupLayout(RmoveDepartmentBtn);
        RmoveDepartmentBtn.setLayout(RmoveDepartmentBtnLayout);
        RmoveDepartmentBtnLayout.setHorizontalGroup(
            RmoveDepartmentBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RmoveDepartmentBtnLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        RmoveDepartmentBtnLayout.setVerticalGroup(
            RmoveDepartmentBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        DepartmentHome.add(RmoveDepartmentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 210, 40));

        DepartMentPanel.add(DepartmentHome, "DepartmentHome");

        PanelCard.add(DepartMentPanel, "DepartMentPanel");

        EployeePanel.setBackground(new java.awt.Color(249, 246, 242));
        EployeePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame2.setVisible(true);

        InternalCard.setLayout(new java.awt.CardLayout());

        updateAddPnl.setBackground(new java.awt.Color(249, 246, 242));
        updateAddPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setText("First Name :");
        updateAddPnl.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 58, 80, 22));

        jLabel22.setText("Work NO. :");
        updateAddPnl.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 90, 20));

        jLabel24.setText("Phone Number :");
        updateAddPnl.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, 20));

        jLabel45.setText("City :");
        updateAddPnl.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, 20));

        jLabel46.setText("Job :");
        updateAddPnl.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 90, 20));

        jLabel47.setText("Salary :");
        updateAddPnl.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 90, 20));

        jLabel48.setText("Department NO. :");
        updateAddPnl.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, 20));

        jLabel49.setText("Shift :");
        updateAddPnl.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 90, -1));

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 58, 142, -1));

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 142, -1));

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 142, -1));

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 142, -1));

        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 115, -1));

        jTextField25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 115, -1));

        jTextField26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 115, -1));

        jTextField27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 115, -1));

        DismissBtn.setBackground(new java.awt.Color(51, 119, 68));
        DismissBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DismissBtn.setText("Dismiss");
        DismissBtn.setBorder(null);
        DismissBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DismissBtnActionPerformed(evt);
            }
        });
        updateAddPnl.add(DismissBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 115, 34));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 119, 68));
        jLabel53.setText("Add Employee");
        updateAddPnl.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 11, 160, 41));

        jLabel91.setText("Street :");
        updateAddPnl.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jTextField47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 120, -1));

        jLabel92.setText("Birth Date :");
        updateAddPnl.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 90, 20));

        SaveBtn1.setBackground(new java.awt.Color(51, 119, 68));
        SaveBtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaveBtn1.setText("Save");
        SaveBtn1.setBorder(null);
        SaveBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtn1ActionPerformed(evt);
            }
        });
        updateAddPnl.add(SaveBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 108, 34));
        updateAddPnl.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 120, -1));

        jLabel122.setText("SSN:");
        updateAddPnl.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 140, -1));

        jLabel89.setText("Last Name:");
        updateAddPnl.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 20));

        jTextField43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        updateAddPnl.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 140, -1));

        InternalCard.add(updateAddPnl, "updateAddPnl");
        updateAddPnl.getAccessibleContext().setAccessibleName("");

        RemovePnl.setBackground(new java.awt.Color(249, 246, 242));

        jLabel50.setText("Name :");

        jLabel51.setText("Work NO. :");

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        saveBtn1.setBackground(new java.awt.Color(51, 119, 68));
        saveBtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveBtn1.setText("Remove");
        saveBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn1ActionPerformed(evt);
            }
        });

        DismissBtn1.setBackground(new java.awt.Color(51, 119, 68));
        DismissBtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DismissBtn1.setText("Dismiss");
        DismissBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DismissBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RemovePnlLayout = new javax.swing.GroupLayout(RemovePnl);
        RemovePnl.setLayout(RemovePnlLayout);
        RemovePnlLayout.setHorizontalGroup(
            RemovePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RemovePnlLayout.createSequentialGroup()
                .addGroup(RemovePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RemovePnlLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(RemovePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50))
                        .addGap(18, 18, 18)
                        .addGroup(RemovePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField28)
                            .addComponent(jTextField29, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                    .addGroup(RemovePnlLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(saveBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(DismissBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        RemovePnlLayout.setVerticalGroup(
            RemovePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RemovePnlLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(RemovePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RemovePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(RemovePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(DismissBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        InternalCard.add(RemovePnl, "RemovePnl");

        UpdateemployeePnl.setBackground(new java.awt.Color(249, 246, 242));

        jTextField48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel93.setText("First Name :");

        jTextField49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel94.setText("Work NO. :");

        jTextField50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel95.setText("Phone Number :");

        jLabel96.setText("City :");

        jTextField51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField52.setEditable(false);
        jTextField52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel97.setText("SSN :");

        jTextField53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel98.setText("Job :");

        jLabel99.setText("Salary :");

        jTextField54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel100.setText("Department NO. :");

        jLabel101.setText("Shift :");

        jTextField55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField56.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel102.setText("Birth Date :");

        SaveBtn2.setBackground(new java.awt.Color(51, 119, 68));
        SaveBtn2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaveBtn2.setText("Search");
        SaveBtn2.setBorder(null);
        SaveBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtn2ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(51, 119, 68));
        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(51, 119, 68));
        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setText("Dismiss");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(51, 119, 68));
        jLabel103.setText("Update Employee");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel123.setText("Street :");

        jLabel125.setText("Last Name :");

        jTextField69.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout UpdateemployeePnlLayout = new javax.swing.GroupLayout(UpdateemployeePnl);
        UpdateemployeePnl.setLayout(UpdateemployeePnlLayout);
        UpdateemployeePnlLayout.setHorizontalGroup(
            UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateemployeePnlLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103)
                    .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaveBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateemployeePnlLayout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                                .addComponent(jLabel100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                                .addComponent(jLabel99)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                                .addComponent(jLabel95)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UpdateemployeePnlLayout.createSequentialGroup()
                                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                                .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                                        .addComponent(jLabel101)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateemployeePnlLayout.createSequentialGroup()
                                        .addComponent(jLabel102)
                                        .addGap(55, 55, 55)))
                                .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField55, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                                .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel123))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField7)
                                    .addComponent(jTextField51, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))))
                    .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );
        UpdateemployeePnlLayout.setVerticalGroup(
            UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103)
                    .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel125))
                            .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel93)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel95)
                            .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UpdateemployeePnlLayout.createSequentialGroup()
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel96))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel97))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel98))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel99))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel100))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel101))
                        .addGap(8, 8, 8)
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel102)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UpdateemployeePnlLayout.createSequentialGroup()
                        .addGroup(UpdateemployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );

        InternalCard.add(UpdateemployeePnl, "UpdateemployeePnl");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InternalCard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InternalCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EployeePanel.add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 700, 370));

        SearchEmploTxt.setBackground(new java.awt.Color(249, 246, 242));
        SearchEmploTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchEmploTxt.setBorder(null);
        SearchEmploTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchEmploTxtKeyReleased(evt);
            }
        });
        EployeePanel.add(SearchEmploTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 310, 30));

        jSeparator7.setForeground(new java.awt.Color(102, 102, 102));
        EployeePanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 310, 20));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search_20px.png"))); // NOI18N
        EployeePanel.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Work NO.", "SSN", "Phone Number", "Address", "Birth Date", "Job", "Shift", "Salary", "Department NO.", "Manager"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setOpaque(false);
        jTable2.setRowHeight(30);
        jScrollPane4.setViewportView(jTable2);

        EployeePanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 760, 300));

        UpdatePnlBtn.setBackground(new java.awt.Color(233, 222, 208));
        UpdatePnlBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdatePnlBtnMousePressed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update_25px.png"))); // NOI18N
        jLabel58.setText("Update");

        javax.swing.GroupLayout UpdatePnlBtnLayout = new javax.swing.GroupLayout(UpdatePnlBtn);
        UpdatePnlBtn.setLayout(UpdatePnlBtnLayout);
        UpdatePnlBtnLayout.setHorizontalGroup(
            UpdatePnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePnlBtnLayout.createSequentialGroup()
                .addGroup(UpdatePnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdatePnlBtnLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel57))
                    .addGroup(UpdatePnlBtnLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        UpdatePnlBtnLayout.setVerticalGroup(
            UpdatePnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePnlBtnLayout.createSequentialGroup()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        EployeePanel.add(UpdatePnlBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 210, 40));

        AddPnlBtn1.setBackground(new java.awt.Color(233, 222, 208));
        AddPnlBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddPnlBtn1MousePressed(evt);
            }
        });
        AddPnlBtn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_new_25px.png"))); // NOI18N
        jLabel61.setText("Add");
        AddPnlBtn1.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 40));

        EployeePanel.add(AddPnlBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 210, 40));

        RemovePnlBtn1.setBackground(new java.awt.Color(233, 222, 208));
        RemovePnlBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RemovePnlBtn1MousePressed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove_25px.png"))); // NOI18N
        jLabel63.setText("Remove");

        javax.swing.GroupLayout RemovePnlBtn1Layout = new javax.swing.GroupLayout(RemovePnlBtn1);
        RemovePnlBtn1.setLayout(RemovePnlBtn1Layout);
        RemovePnlBtn1Layout.setHorizontalGroup(
            RemovePnlBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RemovePnlBtn1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel63)
                .addGap(51, 51, 51))
        );
        RemovePnlBtn1Layout.setVerticalGroup(
            RemovePnlBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        EployeePanel.add(RemovePnlBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 210, 40));

        jComboBox6.setBackground(new java.awt.Color(249, 246, 242));
        jComboBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Filter", "Employee name", "Work NO.", "Department No.", "Job" }));
        jComboBox6.setBorder(null);
        EployeePanel.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 150, -1));

        PanelCard.add(EployeePanel, "EployeePanel");

        PlantsPanel.setBackground(new java.awt.Color(249, 246, 242));
        PlantsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame3.setVisible(true);

        Internalcard1.setLayout(new java.awt.CardLayout());

        UpdateAddPlantPnl.setBackground(new java.awt.Color(249, 246, 242));

        jLabel54.setText("Plant Name :");

        jLabel55.setText("Barcode :");

        jLabel59.setText("Selling Price :");

        jLabel60.setText("Seeds Price :");

        jLabel64.setText("Season :");

        jLabel65.setText("Humidity :");

        jLabel66.setText("Department :");

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField17.setEditable(false);
        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(51, 119, 68));
        jLabel68.setText("Add Plant");

        jButton3.setBackground(new java.awt.Color(51, 119, 68));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Save");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        DismissPantBtn.setBackground(new java.awt.Color(51, 119, 68));
        DismissPantBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DismissPantBtn.setText("Dismiss");
        DismissPantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DismissPantBtnActionPerformed(evt);
            }
        });

        jLabel84.setText("Quntity :");

        javax.swing.GroupLayout UpdateAddPlantPnlLayout = new javax.swing.GroupLayout(UpdateAddPlantPnl);
        UpdateAddPlantPnl.setLayout(UpdateAddPlantPnlLayout);
        UpdateAddPlantPnlLayout.setHorizontalGroup(
            UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateAddPlantPnlLayout.createSequentialGroup()
                .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UpdateAddPlantPnlLayout.createSequentialGroup()
                        .addContainerGap(182, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DismissPantBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateAddPlantPnlLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel55)
                            .addComponent(jLabel54)
                            .addComponent(jLabel60))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField16)
                            .addComponent(jTextField17)
                            .addComponent(jTextField18)
                            .addComponent(jTextField19, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                            .addComponent(jLabel84))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField20)
                    .addComponent(jTextField21)
                    .addComponent(jTextField22)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateAddPlantPnlLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        UpdateAddPlantPnlLayout.setVerticalGroup(
            UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateAddPlantPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateAddPlantPnlLayout.createSequentialGroup()
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UpdateAddPlantPnlLayout.createSequentialGroup()
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(UpdateAddPlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DismissPantBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        Internalcard1.add(UpdateAddPlantPnl, "UpdateAddplantPnl");

        RemovePlantPnl.setBackground(new java.awt.Color(249, 246, 242));

        jLabel69.setText("Plant Name :");

        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel70.setText("Barcode :");

        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton5.setBackground(new java.awt.Color(51, 119, 68));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Remove");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 119, 68));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Dismiss");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(51, 119, 68));
        jLabel71.setText("Remove Plant");

        javax.swing.GroupLayout RemovePlantPnlLayout = new javax.swing.GroupLayout(RemovePlantPnl);
        RemovePlantPnl.setLayout(RemovePlantPnlLayout);
        RemovePlantPnlLayout.setHorizontalGroup(
            RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RemovePlantPnlLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RemovePlantPnlLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RemovePlantPnlLayout.createSequentialGroup()
                        .addGroup(RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addComponent(jTextField31)))))
                .addGap(189, 189, 189))
        );
        RemovePlantPnlLayout.setVerticalGroup(
            RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RemovePlantPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(RemovePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        Internalcard1.add(RemovePlantPnl, "RemovePlantPnl");

        UpdatePlantPnl.setBackground(new java.awt.Color(249, 246, 242));

        jTextField63.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel110.setText("Barcode :");

        jTextField64.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel111.setText("Seeds Price :");

        jTextField65.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel112.setText("Season :");

        jLabel113.setText("Humidity :");

        jTextField66.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField67.setEditable(false);
        jTextField67.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel114.setText("Department :");

        jLabel115.setText("Plant Name :");

        jTextField68.setEditable(false);
        jTextField68.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField70.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel117.setText("Number of Plant :");

        jTextField71.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel118.setText("Selling Price :");

        jButton4.setBackground(new java.awt.Color(51, 119, 68));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(51, 119, 68));
        jButton17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton17.setText("Dismiss");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(51, 119, 68));
        jButton18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton18.setText("Search");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(51, 119, 68));
        jLabel116.setText("Update Plant");

        javax.swing.GroupLayout UpdatePlantPnlLayout = new javax.swing.GroupLayout(UpdatePlantPnl);
        UpdatePlantPnl.setLayout(UpdatePlantPnlLayout);
        UpdatePlantPnlLayout.setHorizontalGroup(
            UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePlantPnlLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel110)
                                .addGap(18, 18, 18)
                                .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88))
                            .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel116)
                                    .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(100, 100, 100)))
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel115)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UpdatePlantPnlLayout.createSequentialGroup()
                                .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel118))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField64)
                                        .addComponent(jTextField65)
                                        .addComponent(jTextField66)
                                        .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel117)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        UpdatePlantPnlLayout.setVerticalGroup(
            UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdatePlantPnlLayout.createSequentialGroup()
                .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel115))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel117)
                            .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel118)
                            .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel112)
                            .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel113)
                            .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel116)
                        .addGap(54, 54, 54)
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel110))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))
                    .addGroup(UpdatePlantPnlLayout.createSequentialGroup()
                        .addGroup(UpdatePlantPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel114)
                            .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        Internalcard1.add(UpdatePlantPnl, "card4");

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Internalcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Internalcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PlantsPanel.add(jInternalFrame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 570, 310));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search_20px.png"))); // NOI18N
        PlantsPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jTextField15.setBackground(new java.awt.Color(249, 246, 242));
        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setBorder(null);
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField15KeyReleased(evt);
            }
        });
        PlantsPanel.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 11, 270, -1));
        PlantsPanel.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 270, 20));

        jComboBox3.setBackground(new java.awt.Color(249, 246, 242));
        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Filter", "Plant name", "Barcode", "Department" }));
        jComboBox3.setBorder(null);
        PlantsPanel.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 130, -1));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Plant Name", "Barcode", "Seeds Price", "Selling Price", "Quntity", "Season", "Humidity", "Department"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(30);
        jScrollPane6.setViewportView(jTable4);

        PlantsPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 760, 270));

        UpdatePlantBtn.setBackground(new java.awt.Color(233, 222, 208));
        UpdatePlantBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdatePlantBtnMousePressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update_25px.png"))); // NOI18N
        jLabel42.setText("Update");

        javax.swing.GroupLayout UpdatePlantBtnLayout = new javax.swing.GroupLayout(UpdatePlantBtn);
        UpdatePlantBtn.setLayout(UpdatePlantBtnLayout);
        UpdatePlantBtnLayout.setHorizontalGroup(
            UpdatePlantBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdatePlantBtnLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        UpdatePlantBtnLayout.setVerticalGroup(
            UpdatePlantBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        PlantsPanel.add(UpdatePlantBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 210, 40));

        AddPlantBtn.setBackground(new java.awt.Color(233, 222, 208));
        AddPlantBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddPlantBtnMousePressed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_new_25px.png"))); // NOI18N
        jLabel43.setText("Add");

        javax.swing.GroupLayout AddPlantBtnLayout = new javax.swing.GroupLayout(AddPlantBtn);
        AddPlantBtn.setLayout(AddPlantBtnLayout);
        AddPlantBtnLayout.setHorizontalGroup(
            AddPlantBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPlantBtnLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel43)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        AddPlantBtnLayout.setVerticalGroup(
            AddPlantBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        PlantsPanel.add(AddPlantBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 210, 40));

        RmovePlantBtn.setBackground(new java.awt.Color(233, 222, 208));
        RmovePlantBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RmovePlantBtnMousePressed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove_25px.png"))); // NOI18N
        jLabel44.setText("Remove");

        javax.swing.GroupLayout RmovePlantBtnLayout = new javax.swing.GroupLayout(RmovePlantBtn);
        RmovePlantBtn.setLayout(RmovePlantBtnLayout);
        RmovePlantBtnLayout.setHorizontalGroup(
            RmovePlantBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RmovePlantBtnLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel44)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        RmovePlantBtnLayout.setVerticalGroup(
            RmovePlantBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RmovePlantBtnLayout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        PlantsPanel.add(RmovePlantBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 210, 40));

        PanelCard.add(PlantsPanel, "PlantPanel");

        jPanel1.add(PanelCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 770, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1076, 641));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homepanelbutton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepanelbutton
        // TODO add your handling code here:
        setcolor(HomePanelButton, sider1);
        resetColor(MoneyPanelbutton, sider2);
       // resetColor(clientpanelbutton, sider3);
        resetColor(DepatmentPanelButton, sider4);
        resetColor(EmployeePanelButton, sider5);
        resetColor(plantsPanelButton,sider6);
        resetColor(SettingPanelButton, sider7);
        cardLayout.show(PanelCard,"HomePanel");
        cardLayout6.show(HomePanel,"card2");
        
        
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int countrowJtable1=jTable1.getRowCount();
        for(int i=countrowJtable1-1;i>=0;i--){
            model.removeRow(i);
        }
        
         try{//home table
            con= o.getConnection();
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select * from client c,client_bill cb,client_number cn where c.client_number = cb.super_client_number"
                    + " and c.client_number = cn.super_client_number and super_ssn="+this.ssn);
                   int count = 0;
                       while (rs.next()) {
                          model.addRow(new Object[]{rs.getString("BILL_NUM"),rs.getString("FIRST_NAME")+rs.getString("LAST_NAME"),rs.getString("PHONE_NUMBER"),rs.getString("Street")+"_"+rs.getString("city")
                          ,rs.getDouble("TOTAL_PRICE"),rs.getDate("SOLD_DATE")});
                        } 
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_homepanelbutton

    private void MoneyPanel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoneyPanel
        // TODO add your handling code here:
        setcolor(MoneyPanelbutton, sider2);
        resetColor(HomePanelButton, sider1);
        resetColor(DepatmentPanelButton, sider4);
        resetColor(EmployeePanelButton, sider5);
        resetColor(plantsPanelButton,sider6);
        resetColor(SettingPanelButton, sider7);
        cardLayout.show(PanelCard,"MoneyCalPanel");
        DefaultTableModel model=(DefaultTableModel)jTable6.getModel();
        int countrowJtable1=jTable6.getRowCount();
        for(int i=countrowJtable1-1;i>=0;i--){
            model.removeRow(i);
        }
        try{
            con= o.getConnection();
            Statement stmta =con.createStatement();
         ResultSet rslt1;
         double waterp=0;
         double ferp=0;
         double tax=0;
         Statement stmt65=con.createStatement();
         ResultSet rs65 =stmt65.executeQuery("select * from farmer where ssn = " + this.ssn);
         while(rs65.next()){
             waterp = rs65.getDouble("water_Price");
              ferp = rs65.getDouble("FERTILIZER_PRICE");
               tax =rs65.getDouble("taxes");
         }
            rslt1 = stmta.executeQuery("select * from department d,planets p,farmer_planets fp where d.d_number=p.super_d_number and p.p_barcode=fp.super_p_barcode and d.super_ssn="+this.ssn +" and fp.super_ssn = "+this.ssn);
            while(rslt1.next()){
                
                model.addRow(new Object[]{rslt1.getString("d_number"),rslt1.getDouble("FERTILIZER_NEEDED_LITER")*ferp
                ,waterp * rslt1.getDouble("WATER_NEEDED_LITER"),rslt1.getDouble("CROP_NUMBER")*rslt1.getDouble("SEEDS_PRICE")});
            }
        
         jTextField23.setText(""+waterp);
         jTextField40.setText(ferp+"");
         jTextField42.setText(tax+"");
            
            ResultSet rs;
            rs = stmta.executeQuery("select * from client_bill where super_ssn="+this.ssn);
                   double count = 0;
                       while (rs.next()) {
                           count=count+rs.getDouble("TOTAL_PRICE");
                       
                        } 
                       jTextField1.setText(""+count);
                       
             DefaultTableModel model2=(DefaultTableModel)jTable6.getModel();
             int row6=jTable6.getRowCount();
             double count1=0;
             for(int i=row6-1;i>=0;i--){
                 count1=count1+Double.parseDouble(""+model2.getValueAt(i, 3));
             }
            jTextField4.setText(""+count1);
            Statement stmt9=con.createStatement();
            ResultSet set9;
            double salary=0;
            set9=stmt9.executeQuery("select salary from employee where super_ssn = "+this.ssn);
            while (set9.next())
            {
                salary=salary+set9.getDouble("salary");
            }
            jTextField44.setText(""+salary);
           DefaultTableModel model1=(DefaultTableModel)jTable6.getModel();
           int rowjTable6=jTable6.getRowCount();
           double waterFarm=0;
           double FerFarm=0;
           for(int i=rowjTable6-1;i>=0;i--){
            waterFarm=waterFarm + Double.parseDouble(""+model.getValueAt(i,2));
            FerFarm=FerFarm + Double.parseDouble(""+model.getValueAt(i,1));
           }
            jTextField2.setText(""+waterFarm);
            jTextField3.setText(""+FerFarm);
            double profit=Double.parseDouble(jTextField1.getText())-(Double.parseDouble(jTextField44.getText())+Double.parseDouble(jTextField2.getText())+Double.parseDouble(jTextField3.getText())+Double.parseDouble(jTextField4.getText()));
            jTextField5.setText(""+profit);
           
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_MoneyPanel

    private void departmentPanel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentPanel
        // TODO add your handling code here:
        setcolor(DepatmentPanelButton, sider4);
        resetColor(MoneyPanelbutton, sider2);
//        resetColor(clientpanelbutton, sider3);
        resetColor(HomePanelButton, sider1);
        resetColor(EmployeePanelButton, sider5);
        resetColor(plantsPanelButton,sider6);
        resetColor(SettingPanelButton, sider7);
        cardLayout.show(PanelCard,"DepartMentPanel");
        cardLayout5.show(DepartMentPanel,"DepartmentHome");
        this.jInternalFrame4.setVisible(false);
        
        //when press on this Pnl remove all content of JTable and readd it
        DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
        int countRow=jTable3.getRowCount();
        for(int i=countRow-1;i>=0;i--){
            model.removeRow(i);
        }
        //add to the table
        try{
            con= o.getConnection();
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select * from department where super_ssn="+this.ssn);
                       while (rs.next()) {
                                    model.addRow(new Object[]{rs.getString("D_NUMBER"),rs.getString("D_LOCATION"),rs.getString("MANEGER_SSN")
                                    ,rs.getString("CROP_TYPE"),rs.getInt("CROP_NUMBER")});                        } 
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_departmentPanel

    private void employeePanel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeePanel
        // TODO add your handling code here:
        setcolor(EmployeePanelButton, sider5);
        resetColor(MoneyPanelbutton, sider2);
//        resetColor(clientpanelbutton, sider3);
        resetColor(DepatmentPanelButton, sider4);
        resetColor(HomePanelButton, sider1);
        resetColor(plantsPanelButton,sider6);
        resetColor(SettingPanelButton, sider7);
        cardLayout.show(PanelCard,"EployeePanel");
        jInternalFrame2.setVisible(false);
        
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        int countrowJtable1=jTable2.getRowCount();
        for(int i=countrowJtable1-1;i>=0;i--){
            model.removeRow(i);
        }
        
         try{//home table
            con= o.getConnection();
            Statement stmta =con.createStatement();
            ResultSet rst;
           // Statement stmta1 =con.createStatement();
            //ResultSet rst1;
            //boolean manager=false;
            rst = stmta.executeQuery("select * from employee where super_ssn="+this.ssn);
                   int count = 0;
                   //rst1=stmta1.executeQuery("select maneger_ssn from department where maneger_ssn = "+rst.getString("ssn")+" and super_ssn = "+this.ssn);
                       while (rst.next()) {
                        //rst1=stmta1.executeQuery("select maneger_ssn from department where maneger_ssn = "+rst.getString("ssn")+" and super_ssn = "+this.ssn);
                            
                            
                     /*         while(rst1.next())
                            {
                                count++;
                            }
                              System.out.print(count);
                             manager=false;
                             if( count==1)
                              manager=true;*/
                             
                                     model.addRow(new Object[]{rst.getString("FIRST_NAME")+rst.getString("LAST_NAME"),rst.getString("WORK_NUMBER"),rst.getString("SSN")
                                    ,"0"+rst.getString("PHONE_NUMBER"),rst.getString("STREET")+"_"+rst.getString("CITY"),rst.getDate("B_DATE"),rst.getString("JOP_DICRIBTION")
                                    ,rst.getString("SHIFT"),rst.getDouble("SALARY"),rst.getString("SUPER_D_NUMBER"),/*manager*/});
                           
                                }    
                con.close();
    } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_employeePanel

    private void plantsPanel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plantsPanel
        // TODO add your handling code here:
        setcolor(plantsPanelButton,sider6);
        resetColor(MoneyPanelbutton, sider2);
//        resetColor(clientpanelbutton, sider3);
        resetColor(DepatmentPanelButton, sider4);
        resetColor(EmployeePanelButton, sider5);
        resetColor(HomePanelButton,sider1);
        resetColor(SettingPanelButton, sider7);
        cardLayout.show(PanelCard,"PlantPanel");
        this.jInternalFrame3.setVisible(false);
        try{
   
            con=o.getConnection();
            Statement stmt;
            stmt =con.createStatement();
            
             DefaultTableModel model=(DefaultTableModel)jTable4.getModel();
                    int countrowJtable1=jTable4.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
        
                    try{//update planet Table

                        ResultSet rs;
                        rs = stmt.executeQuery("select * from farmer_planets,planets where p_barcode=super_p_barcode and super_ssn='"+this.ssn+"'");//every thing in plant
                            int count = 0;
                            while (rs.next()) {
                                    model.addRow(new Object[]{rs.getString("P_NAME"),rs.getString("P_BARCODE"),rs.getDouble("SEEDS_PRICE")
                                    ,rs.getDouble("SELLING_PRICE"),rs.getInt("NO_OF_PLANT"),rs.getString("AGRICULTURE_SEASON"),rs.getDouble("HUMIDITY_PER")
                                    ,rs.getString("SUPER_D_NUMBER")});
                                    } 
                         
                    } catch (SQLException ex) {
                        Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   con.commit();
                   con.close();
                   this.jInternalFrame3.setVisible(false);
           
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        
        /*DefaultTableModel model =(DefaultTableModel)jTable4.getModel();
        int countrow=jTable4.getRowCount();
        for(int i=countrow-1;i>=0;i--){
            model.removeRow(i);
        }
        try{
            con= o.getConnection();
            
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select * from planets where super_ssn="+this.ssn);
                       while (rs.next()) {
                               model.addRow(new Object[]{});
                        } 
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
    }//GEN-LAST:event_plantsPanel

    private void LogOutPanelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutPanelButtonMousePressed
        // TODO add your handling code here:
        Object[] options = {"Yes", "Cancel"};
        int n = JOptionPane.showOptionDialog(this,
                "Did you want to log out ?","log out",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if (n == JOptionPane.YES_OPTION) {
            new FarmerIntro1("farmer").setVisible(true);
            this.dispose();
}
        else{
            this.setVisible(true);
        }
    }//GEN-LAST:event_LogOutPanelButtonMousePressed

//when press on this Pnl show on table the custmer who complete
//handle for labal to back to another Pnl
    private void UpdatePnlBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdatePnlBtnMousePressed
        // TODO add your handling code here:
        jInternalFrame2.setVisible(true);
        cardLayout2.show(InternalCard,"UpdateemployeePnl");
         this.jTextField48.setText("");
        this.jTextField49.setText("");
        this.jTextField69.setText("");
        this.jTextField50.setText("");
        this.jTextField51.setText("");
        this.jTextField7.setText("");
        this.jTextField52.setText("");
        this.jTextField53.setText("");
        this.jTextField54.setText("");
        this.jTextField55.setText("");
        this.jTextField56.setText("");
        this.jDateChooser2.setCalendar(null);
    }//GEN-LAST:event_UpdatePnlBtnMousePressed

    private void AddPnlBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPnlBtn1MousePressed
        // TODO add your handling code here:
        jInternalFrame2.setVisible(true);
        cardLayout2.show(InternalCard,"updateAddPnl");
         this.jTextField8.setText("");
        this.jTextField9.setText("");
        this.jTextField10.setText("");
        this.jTextField12.setText("");
        this.jTextField24.setText("");
        this.jTextField25.setText("");
        this.jTextField26.setText("");
        this.jTextField27.setText("");
        this.jTextField43.setText("");
        this.jTextField12.setText("");
        this.jTextField6.setText("");
        this.jTextField47.setText("");
        this.jDateChooser1.setCalendar(null);

    }//GEN-LAST:event_AddPnlBtn1MousePressed

    private void RemovePnlBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemovePnlBtn1MousePressed
        // TODO add your handling code here:
        jInternalFrame2.setVisible(true);
        cardLayout2.show(InternalCard,"RemovePnl");
    }//GEN-LAST:event_RemovePnlBtn1MousePressed

    private void DismissBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DismissBtnActionPerformed
        // TODO add your handling code here:
        this.jTextField8.setText("");
        this.jTextField9.setText("");
        this.jTextField10.setText("");
        this.jTextField12.setText("");
        this.jTextField24.setText("");
        this.jTextField25.setText("");
        this.jTextField26.setText("");
        this.jTextField27.setText("");
        this.jInternalFrame2.setVisible(false);
    }//GEN-LAST:event_DismissBtnActionPerformed

    private void DismissBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DismissBtn1ActionPerformed
        // TODO add your handling code here:
        this.jTextField28.setText("");
        this.jTextField29.setText("");
        this.jInternalFrame2.setVisible(false);
    }//GEN-LAST:event_DismissBtn1ActionPerformed

    private void UpdatePlantBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdatePlantBtnMousePressed
        // TODO add your handling code here:
        jInternalFrame3.setVisible(true);
        cardLayout3.show(Internalcard1,"card4");
              this.jTextField63.setText("");
              this.jTextField68.setText("");
              this.jTextField70.setText("");
              this.jTextField71.setText("");
              this.jTextField64.setText("");
              this.jTextField65.setText("");
              this.jTextField66.setText("");
              this.jTextField67.setText("");
    }//GEN-LAST:event_UpdatePlantBtnMousePressed

    private void AddPlantBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPlantBtnMousePressed
        // TODO add your handling code here:
        jInternalFrame3.setVisible(true);
        cardLayout3.show(Internalcard1,"UpdateAddplantPnl");
        this.jTextField16.setText("");
        this.jTextField17.setText("");
        this.jTextField18.setText("");
        this.jTextField19.setText("");
        this.jTextField20.setText("");
        this.jTextField21.setText("");
        this.jTextField22.setText("");
        this.jTextField30.setText("");
        /*try {
            con =o.getConnection();
            Statement stmt=con.createStatement();
            ResultSet r=stmt.executeQuery("select p_barcode from planets where p_barcode=p_barcode.currval" );
            int p_barcode=0;
            while (r.next()){
                p_barcode=Integer.parseInt(r.getString("p_parcode"))+1;
                jTextField17.setText(p_barcode+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }//GEN-LAST:event_AddPlantBtnMousePressed

    private void DismissPantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DismissPantBtnActionPerformed
        // TODO add your handling code here:
        this.jTextField16.setText("");
        this.jTextField17.setText("");
        this.jTextField18.setText("");
        this.jTextField19.setText("");
        this.jTextField20.setText("");
        this.jTextField21.setText("");
        this.jTextField22.setText("");
        this.jTextField30.setText("");
        jInternalFrame3.setVisible(false);
    }//GEN-LAST:event_DismissPantBtnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.jTextField31.setText("");
        this.jTextField32.setText("");
        jInternalFrame3.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void RmovePlantBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RmovePlantBtnMousePressed
        // TODO add your handling code here:
        jInternalFrame3.setVisible(true);
        cardLayout3.show(Internalcard1,"RemovePlantPnl");
        this.jLabel71.setText("Remove Plant");
        this.jTextField31.setText("");
        this.jTextField32.setText("");
    }//GEN-LAST:event_RmovePlantBtnMousePressed

    private void UpdatedepartmentBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdatedepartmentBtnMousePressed
        // TODO add your handling code here:
        jInternalFrame4.setVisible(true);
        cardLayout4.show(Internalcard4,"card4");
                jTextField59.setText("");
                jTextField58.setText("");
                jTextField61.setText("");
                jTextField60.setText("");
                jTextField62.setText("");
                jTextField38.setText("");
                jTextField57.setText("");

    }//GEN-LAST:event_UpdatedepartmentBtnMousePressed

    private void AddDepartmentBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddDepartmentBtnMousePressed
        // TODO add your handling code here:
        jInternalFrame4.setVisible(true);
        cardLayout4.show(Internalcard4,"UpdateAddDepartmentPnl");
       jTextField33.setText("");
                jTextField34.setText("");
                jTextField35.setText("");
                jTextField36.setText("");
                jTextField37.setText("");
                jTextField11.setText("");
                jTextField14.setText("");
    }//GEN-LAST:event_AddDepartmentBtnMousePressed

    private void RmoveDepartmentBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RmoveDepartmentBtnMousePressed
        // TODO add your handling code here:
        jInternalFrame4.setVisible(true);
        jTextField39.setText("");
    }//GEN-LAST:event_RmoveDepartmentBtnMousePressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.jTextField39.setText("");
        this.jInternalFrame4.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.jTextField33.setText("");
        this.jTextField34.setText("");
        this.jTextField35.setText("");
        this.jTextField36.setText("");
        this.jTextField37.setText("");
       
        this.jInternalFrame4.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void SaveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtn2ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
        /**/con= o.getConnection();
            String a="";
            String b="";
            String c="";
            String d="";
            String e="";
            Date f=null;
            long g=0;
            String h="";
            String i="";
            String j="";
            String k="";
            String l="";
           

            
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select * from employee where work_number="+
                    jTextField49.getText());
                   int count = 0;
                       while (rs.next()) {
                              count++;
                               a=rs.getString(1);
                               b=rs.getString(2);
                               c=rs.getString(3);
                               d=rs.getString(4);
                               e=rs.getString(5);
                               f=rs.getDate(6);
                               g=rs.getLong(7);
                               h=rs.getString(8);
                               i=rs.getString(9);
                               j=rs.getString(10);
                               k=rs.getString(11);
                               l=rs.getString(12);
                              

                        } 
              if (count==0)
              JOptionPane.showMessageDialog(null,"This worke number is not exist.");
              else {
                jTextField48.setText(a+"");
                jTextField69.setText(""+b);
               
                jTextField50.setText(d+"");
                oldphone=jTextField50.getText();
                jTextField52.setText(e+"");
                jTextField54.setText(g+"");
                jTextField55.setText(h+"");
                jTextField53.setText(i+"");
                jTextField56.setText(j+"");
                jTextField7.setText(k+"");
                jTextField51.setText(l);
                jDateChooser2.setDate(f); }
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveBtn2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
         try{
            con= o.getConnection();
            String a="";
            String b="";
            String c="";
            long d=0;
            long e=0;
            long f=0;
            String g="";
            String h="";
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select * from department where d_number="+
                    jTextField57.getText());
                   int count = 0;
                       while (rs.next()) {
                               count++;
                               a=rs.getString(1);
                               b=rs.getString(2);
                               c=rs.getString(3);
                               d=rs.getLong(4);
                               e=rs.getLong(5);
                               f=rs.getLong(6);
                               g=rs.getString(7);
                               h=rs.getString(8);
                        } 
              if (count==0)
              JOptionPane.showMessageDialog(null,"This department doesn't not exist.");
              else {
                jTextField59.setText(""+a);
                jTextField58.setText(""+b);
                jTextField61.setText(e+"");
                jTextField60.setText(g+"");
                jTextField62.setText(d+"");
                jTextField38.setText(f+"");
                

                             
                
                }
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTextField36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField36ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        this.jTextField57.setText("");
        this.jTextField58.setText("");
        this.jTextField59.setText("");
        this.jTextField60.setText("");
        this.jTextField61.setText("");
        this.jTextField62.setText("");
        this.jInternalFrame4.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        this.jTextField48.setText("");
        this.jTextField49.setText("");
        this.jTextField50.setText("");
        this.jTextField51.setText("");
        this.jTextField52.setText("");
        this.jTextField53.setText("");
        this.jTextField54.setText("");
        this.jTextField55.setText("");
        this.jTextField56.setText("");
        jInternalFrame2.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        this.jTextField63.setText("");
        this.jTextField64.setText("");
        this.jTextField65.setText("");
        this.jTextField66.setText("");
        this.jTextField67.setText("");
        this.jTextField68.setText("");
        this.jTextField70.setText("");
        this.jTextField71.setText("");
        this.jInternalFrame3.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void ChangPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangPassMousePressed
        // TODO add your handling code here:
        oldPassLbl.setVisible(true);
        oldPassTxt.setVisible(true);
        NewPassLbl.setVisible(true);
        NewPassTxt.setVisible(true);
        ReapetLbl.setVisible(true);
        RNewPassLbl.setVisible(true);
        RnewPassTxr.setVisible(true);
        this.jSeparator28.setVisible(true);
        this.jSeparator29.setVisible(true);
        this.jSeparator30.setVisible(true);
        pas=true;
    }//GEN-LAST:event_ChangPassMousePressed

    private void edit1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit1MousePressed
        // TODO add your handling code here:
        EditEmailTxt.setEditable(true);
    }//GEN-LAST:event_edit1MousePressed

    private void edit2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit2MousePressed
        // TODO add your handling code here:
        jComboBox4.setEnabled(true);
    }//GEN-LAST:event_edit2MousePressed

    private void edit3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit3MousePressed
        // TODO add your handling code here:
        StreetTXt.setEditable(true);
    }//GEN-LAST:event_edit3MousePressed

    private void edit4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit4MousePressed
        // TODO add your handling code here:
        EditTelTxt.setEditable(true);
    }//GEN-LAST:event_edit4MousePressed

    private void edit5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit5MousePressed
        // TODO add your handling code here:
        editPhonTxt.setEditable(true);
    }//GEN-LAST:event_edit5MousePressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

         //add to the database
         try{
            con= o.getConnection();
            Statement stmt;
            stmt = con.createStatement();
            String n="";
            if (jTextField11.getText().equals("") | jTextField14.getText().equals("") |
                jTextField34.getText().equals("") | /*jTextField35.getText().equals("")| */
                jTextField36.getText().equals("")| jTextField37.getText().equals(""))
                JOptionPane.showMessageDialog(null,"There is an empty fieldes");
            else {
              /*  Statement stmt1 =con.createStatement();
                ResultSet rs1=stmt1.executeQuery("select ssn from employee where ssn =  "+ jTextField35.getText() +" and super_ssn = "+this.ssn);
                int count1=0;
                while(rs1.next()){
                    count1++;
                }
                if(count1==0)
                    JOptionPane.showMessageDialog(null,"the employee with maneger ssn doesn't exist ");
                else{
                    Statement stmt2 =con.createStatement();
                ResultSet rs2=stmt2.executeQuery("select maneger_ssn from department where maneger_ssn =  "+ jTextField35.getText() +" and super_ssn = "+this.ssn);
                int count2=0;
                while(rs2.next()){
                    count2++;
                }
                if(count2==1)
                    JOptionPane.showMessageDialog(null,"the manger is a manger is manger in another department  ");
                else{*/
                    
                    n = "insert into department values('"+jTextField35.getText()+"','"+jTextField34.getText()+
                       "',d_number.nextval,"+jTextField11.getText()+","+jTextField37.getText()+","+jTextField14.getText()+
                       ",'"+jTextField36.getText()+"','"+this.ssn+"')";
                   stmt.executeUpdate(n);
         //delete frome table
         DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
                    int countrowJtable1=jTable3.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
                //add to table
                    try{

                        ResultSet rs;
                        rs = stmt.executeQuery("select * from department where super_ssn='"+this.ssn+"'");//every thing in plant
                            int count = 0;
                            while (rs.next()) {
                                    model.addRow(new Object[]{rs.getString("D_NUMBER"),rs.getString("D_LOCATION"),rs.getString("MANEGER_SSN")
                                    ,rs.getString("CROP_TYPE"),rs.getInt("CROP_NUMBER")});
                                    } 
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                   con.commit();
                   con.close();
                   JOptionPane.showMessageDialog(null,"The department was added successfully."); 
                      jInternalFrame4.setVisible(false);
                    
               // }//here2
                //}//here1
             
                    
                  }
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        //remove from table
         
        //remove from the database         
        try {
            con= o.getConnection();
            int a=0;
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select d_number from department where d_number="+
                    jTextField39.getText());
                   int count = 0;
                       while (rs.next()) {
                              count++;
                               a=rs.getInt("d_number"); 
                        } 
             
             
        if (jTextField39.getText().equals(""))
            JOptionPane.showMessageDialog(null,"There is an empty field.");
        else if (count==0)
              JOptionPane.showMessageDialog(null,"This department doesn't exist.");
        else {
            stmta.executeUpdate("delete from department where d_number="+a);
              JOptionPane.showMessageDialog(null,"The department was deleted successfully.");
              jInternalFrame4.setVisible(false);
          DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
                    int countrowJtable1=jTable3.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }


// add to the table     
         ResultSet rst;
         rst = stmta.executeQuery("select * from department where super_ssn='"+this.ssn+"'");//every thing in plant
         while (rst.next()) {
                           model.addRow(new Object[]{rst.getString("D_NUMBER"),rst.getString("D_LOCATION"),rst.getString("MANEGER_SSN")
                                    ,rst.getString("CROP_TYPE"),rst.getInt("CROP_NUMBER")});
                                    } 
        }
        
         con.commit();
         con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    private void jButton151ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
         try {
             con= o.getConnection();
             Statement stmta =con.createStatement();
             String g="update department " + 
                                "set maneger_name ='"+jTextField59.getText()+"'"+
                                ",d_location ='"+jTextField58.getText()+
                               /* ", selling_price  ="+ jTextField71.getText()+
                                ", water_needed_liter ="+ jTextField64.getText()+
                                ", agriculture_season ='"+ jTextField65.getText()+
                                "', humidity_per ="+ jTextField66.getText()+
                                ", d_number ="+jTextField67.getText()+*/"'where d_number="+jTextField57.getText();
                  
              stmta.executeUpdate(g);
              JOptionPane.showMessageDialog(null,"The department information was updated successfully.");
              con.commit();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        
      //Update the database
        try {
            con=o.getConnection();
             Statement stmt1 =con.createStatement();
                ResultSet rs1=stmt1.executeQuery("select ssn from employee where ssn =  "+ jTextField59.getText() +" and super_ssn = "+this.ssn);
                int count1=0;
                while(rs1.next()){
                    count1++;
                }
                if(count1==0)
                    JOptionPane.showMessageDialog(null,"the employee with maneger ssn doesn't exist ");
                else{
                    Statement stmt2 =con.createStatement();
                ResultSet rs2=stmt2.executeQuery("select maneger_ssn from department where maneger_ssn =  "+ jTextField59.getText() +" and super_ssn = "+this.ssn);
                int count2=0;
                while(rs2.next()){
                    count2++;
                }
                if(count2==1)
                    JOptionPane.showMessageDialog(null,"the manger is a manger is manger in another department  ");
                else{
            
             con= o.getConnection();
             Statement stmta =con.createStatement();
             String g="update department " + 
                                "set maneger_ssn ='"+jTextField59.getText()+"'"+
                                ",d_location ='"+jTextField58.getText()+"',crop_type ='"+jTextField60.getText()+"',crop_number="+
                                 jTextField61.getText()+
                                "where d_number="+jTextField57.getText();
                  
              stmta.executeUpdate(g);
              //remove from table
          DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
                    int countrowJtable1=jTable3.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
               // add to the table     
               ResultSet rst;
               rst = stmta.executeQuery("select * from department where super_ssn='"+this.ssn+"'");//every thing in plant
               while (rst.next()) {
                           model.addRow(new Object[]{rst.getString("D_NUMBER"),rst.getString("D_LOCATION"),rst.getString("MANEGER_SSN")
                                    ,rst.getString("CROP_TYPE"),rst.getInt("CROP_NUMBER")});
                                    } 

              JOptionPane.showMessageDialog(null,"The department information was updated successfully.");
              jInternalFrame4.setVisible(false);
              con.commit();
              con.close();}
        }} catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void SaveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtn1ActionPerformed
        // TODO add your handling code here:
        
        //add to the database            
        try {
            con= o.getConnection();
            Statement stmt,stmt1;
            stmt = con.createStatement();
            stmt1 = con.createStatement();
            String n="";
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String k =sdf.format(jDateChooser1.getDate());
            //format format =
            if (jTextField8.getText().equals("")|jTextField43.getText().equals("")|
                jTextField10.getText().equals("")| jTextField12.getText().equals("") |
                jTextField24.getText().equals("")| jTextField25.getText().equals("")|
                jTextField27.getText().equals("")| jTextField26.getText().equals("")|
                jTextField47.getText().equals("")|jTextField6.getText().equals("")|jDateChooser1.getDate()==null)
                JOptionPane.showMessageDialog(null,"There is an empty fieldes");
            else {
                Statement stmtant ;
                int o=0;
                    stmtant = con.createStatement();
                ResultSet set= stmtant.executeQuery("select phone_number from employee where super_ssn = "
                        +this.ssn +" and phone_number = "+jTextField10.getText());
                while (set.next()){
                    o++;
                }
                if(o!=0)
                   JOptionPane.showMessageDialog(null,"This phone number is exist.");
                else{
                    Statement stmtan ;
                int p=0;
                    stmtan = con.createStatement();
                ResultSet set1= stmtan.executeQuery("select ssn from employee where super_ssn = "
                        +this.ssn +" and ssn = "+jTextField47.getText());
                while (set1.next()){
                    p++;
                }
                if(p!=0)
                   JOptionPane.showMessageDialog(null,"This ssn is exist.");
                else {
                      Statement stmtan1 ;
                int t=0;
                    stmtan1 = con.createStatement();
                ResultSet set2= stmtan1.executeQuery("select d_number from department where super_ssn = "
                        +this.ssn +" and d_number = "+jTextField26.getText());
                while (set2.next()){
                    t++;
                }
                if(t==0){
                      JOptionPane.showMessageDialog(null,"This Department Doesn't exist");
 
                } else {
                   n = "insert into employee values('"+jTextField8.getText()+"','"+jTextField43.getText()+"',e_number.nextval,'"+ jTextField10.getText()+
                   "','"+jTextField47.getText()+"',{d'"+k+"'},"+jTextField25.getText()+",'"+jTextField27.getText()+"','"
                   + jTextField24.getText()+"','"+ jTextField26.getText()+"','"+jTextField6.getText()+"','"+jTextField12.getText()+"','"+this.ssn+"')";
                  
                    stmt.executeUpdate(n);
                    JOptionPane.showMessageDialog(null,"The employee was added successfully.");
                    jInternalFrame2.setVisible(false);  
                }
                }
                }
                           
                    int count=0;
                    boolean manager=false;
                    //add to the table
                   //delet from table
                    DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
                    int countrowJtable1=jTable2.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
                        ResultSet rs;
                        ResultSet r;
                        rs = stmt.executeQuery("select * from employee where super_ssn = "+this.ssn);//every thing in plant  
                            while (rs.next()) {
                               
                            r=stmt1.executeQuery("select maneger_ssn from department where maneger_ssn= "+rs.getString("ssn")+" and super_ssn = "+this.ssn);
                            while(r.next())
                            {
                                count++;
                            }
                            manager=false;
                             if( count!=1)
                              manager=true;
                             
                                    model.addRow(new Object[]{rs.getString("FIRST_NAME")+rs.getString("LAST_NAME"),rs.getString("WORK_NUMBER"),rs.getString("SSN")
                                    ,"0"+rs.getString("PHONE_NUMBER"),rs.getString("STREET")+"_"+rs.getString("CITY"),rs.getDate("B_DATE"),rs.getString("JOP_DICRIBTION")
                                    ,rs.getString("SHIFT"),rs.getDouble("SALARY"),rs.getString("SUPER_D_NUMBER"),manager});
                           
                                }
                   con.commit();
                   con.close();
                    }
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
       }/**/
    }//GEN-LAST:event_SaveBtn1ActionPerformed

    private void saveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn1ActionPerformed
        // TODO add your handling code here:  
         //delet from table
       
          //delete from database          
          try {
            con= o.getConnection();
            String a="";
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select work_number from employee where work_number="+
                   jTextField29.getText());
                   int count = 0;
                       while (rs.next()) {
                              count++;
                              a=rs.getString("work_number");
                             
                        } 
             
             
        if (jTextField28.getText().equals("")|jTextField29.getText().equals(""))
            JOptionPane.showMessageDialog(null,"There is an empty field.");
        else if (count==0)
              JOptionPane.showMessageDialog(null,"This worke number is not exist.");
        else {
            stmta.executeUpdate("delete from employee where work_number="+a);
              JOptionPane.showMessageDialog(null,"The employee was deleted successfully.");
              jInternalFrame2.setVisible(false);
                DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
                    int countrowJtable1=jTable2.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
              //add to the table
                        boolean manager =false;
                        ResultSet rst;
                        ResultSet rst1;
                        Statement stmta1=con.createStatement();
                        rst = stmta.executeQuery("select * from employee where super_ssn = "+this.ssn);//every thing in plant  
                            while (rst.next()) {
                               
                            rst1=stmta1.executeQuery("select maneger_ssn from department where maneger_ssn = "+rst.getString("ssn")+" and super_ssn = "+this.ssn);
                            
                            
                              while(rst1.next())
                            {
                                count++;
                            }
                             manager=false;
                             if( count!=0)
                              manager=true;
                             
                                     model.addRow(new Object[]{rst.getString("FIRST_NAME")+rst.getString("LAST_NAME"),rst.getString("WORK_NUMBER"),rst.getString("SSN")
                                    ,"0"+rst.getString("PHONE_NUMBER"),rst.getString("STREET")+"_"+rst.getString("CITY"),rst.getDate("B_DATE"),rst.getString("JOP_DICRIBTION")
                                    ,rst.getString("SHIFT"),rst.getDouble("SALARY"),rst.getString("SUPER_D_NUMBER"),manager});
                           
                                }
                  }

         con.commit();
         con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }/**/
    }//GEN-LAST:event_saveBtn1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
     
                
         //update the database
         try {
             con= o.getConnection();
               Statement stmtant ;
                int o=0;
                String phone="";
                
                    stmtant = con.createStatement();
                    ResultSet set= stmtant.executeQuery("select phone_number from employee where super_ssn = "
                        +this.ssn +" and phone_number = "+jTextField50.getText());
                    
                while (set.next()){
                    o++;
                    phone = set.getString("phone_number");
                }
                if(o==1 && !(phone.equals(oldphone)) )
                   JOptionPane.showMessageDialog(null,"This phone number is exist.");
                /*
                else{
                    Statement stmtan ;
                int p=0;
                    stmtan = con.createStatement();
                ResultSet set1= stmtan.executeQuery("select ssn from employee where super_ssn = "
                        +this.ssn +" and ssn = "+jTextField47.getText());
                while (set1.next()){
                    p++;
                }
                if(p!=0)
                   JOptionPane.showMessageDialog(null,"This ssn is exist.");*/
                else {
                      Statement stmtan1 ;
                int t=0;
                    stmtan1 = con.createStatement();
                ResultSet set2= stmtan1.executeQuery("select d_number from department where super_ssn = "
                        +this.ssn +" and d_number = "+jTextField56.getText());
                while (set2.next()){
                    t++;
                }
                if(t==0)
                   JOptionPane.showMessageDialog(null,"This department is not exist.");
                else {
                   Statement stmta =con.createStatement();
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
             String a=sdf.format(jDateChooser2.getDate());

             String g="update employee " + 
                                "set first_name ='"+jTextField48.getText() +"'"+
                                ",last_name ='"+jTextField69.getText()+
                                "', phone_number  = '"+ jTextField50.getText()+
                                "', SSN  ='"+ jTextField52.getText()+
                                "', B_Date ="+ "{d'"+a+"'}"+
                                ", Salary ="+ jTextField54.getText()+
                                ", shift ='"+ jTextField55.getText()+ "'"+
                                ", jop_dicribtion ='"+jTextField53.getText()+"',"+
                                " city ='"+jTextField51.getText()+"'"+
                                ",street ='"+jTextField7.getText()+
                                "',super_d_number = '" + jTextField56.getText()+"' where work_number = "+jTextField49.getText();
              stmta.executeUpdate(g);
              JOptionPane.showMessageDialog(null,"The employee information was updated successfully.");
              jInternalFrame2.setVisible(false);
                }
                           }         
//////////00///
                    
            
               //delete frome table
                     DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
                    int countrowJtable1=jTable2.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
              //add to the table
                       Statement stmtan5 =con.createStatement();
                        Statement stmtan6 =con.createStatement();

                       int count=0;
                        boolean manager =false;
                        ResultSet rst;
                        ResultSet rst1;
                        rst = stmtan5.executeQuery("select * from employee where super_ssn= "+this.ssn );//every thing in plant  
                            while (rst.next()) {
                               
                            rst1=stmtan6.executeQuery("select maneger_ssn from department where maneger_ssn= "+rst.getString("SSN")+" and super_ssn = "+this.ssn);
                            while(rst1.next())
                            {
                                count++;
                            }
                            manager=false;
                             if( count==1)
                              manager=true;
                             
                                     model.addRow(new Object[]{rst.getString("FIRST_NAME")+rst.getString("LAST_NAME")
                                    ,rst.getString("WORK_NUMBER"),rst.getString("SSN")
                                    ,"0"+rst.getString("PHONE_NUMBER"),rst.getString("STREET")+"_"+rst.getString("CITY")
                                    ,rst.getDate("B_DATE"),rst.getString("JOP_DICRIBTION")
                                    ,rst.getString("SHIFT"),rst.getDouble("SALARY"),rst.getString("SUPER_D_NUMBER"),manager});
                           
                                }
              
              con.commit();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            con= o.getConnection();
            Statement stmt;
            stmt = con.createStatement();
            String n="";
            if (jTextField16.getText().equals("")|
                jTextField18.getText().equals("")|
                jTextField19.getText().equals("")| jTextField20.getText().equals("")|
                jTextField21.getText().equals("")| jTextField22.getText().equals("")| jTextField30.getText().equals(""))
                JOptionPane.showMessageDialog(null,"There is an empty fieldes");
              
            else {
                ResultSet resultSet;
              
                int count1=0;
                String crop="";
                int quantity=0;
                resultSet =stmt.executeQuery("select * from department where d_number = "+jTextField30.getText()+ " and super_ssn = "+this.ssn);
              while(resultSet.next()){
                  count1++;
                  crop =resultSet.getString("crop_type");
                  quantity=resultSet.getInt("crop_number");
              }
                
              if (count1==1 && jTextField16.getText().equals(crop) && jTextField20.getText().equals(""+quantity))
                  
                 {Statement stmt3;
                  stmt3 = con.createStatement();
                  boolean f=false;
                  ResultSet set3=stmt.executeQuery("select p_name from planets p , farmer_planets fp where fp.super_p_barcode = p.p_barcode and fp.super_ssn = "+this.ssn);
           while(set3.next()){
               if (set3.getString("p_name").equals(jTextField16.getText())){
                   f=true;
               break;}
               
           }
           if (f)
               JOptionPane.showMessageDialog(null,"The planet is already exist.");
           else{ 
                  n = "insert into planets values( p_barcode.nextval,'"+jTextField16.getText()+"',"+jTextField18.getText()+
                       ",'"+ jTextField21.getText()+ "',"+jTextField22.getText()+","+jTextField20.getText()+
                       ",'"+jTextField30.getText()+"',"+jTextField19.getText()+")";
                   stmt.executeUpdate(n);
                   stmt.executeUpdate("insert into farmer_planets values(p_barcode.currval,'"+this.ssn+"')");  
                   JOptionPane.showMessageDialog(null,"The planet was added successfully.");
                   this.jInternalFrame3.setVisible(false);}}
              else 
                    JOptionPane.showMessageDialog(null,"This department number is not exist or the crop type doesn't match \n or the quantity doesn't match.");
                 
                    DefaultTableModel model=(DefaultTableModel)jTable4.getModel();
                    int countrowJtable1=jTable4.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
        
                    try{//update planet Table

                        ResultSet rs;
                        rs = stmt.executeQuery("select * from farmer_planets fb,planets p where p.p_barcode=fb.super_p_barcode and  fb.super_ssn ='"+this.ssn+"'");//every thing in plant
                            int count = 0;
                            while (rs.next()) {
                                    model.addRow(new Object[]{rs.getString("P_NAME"),rs.getString("P_BARCODE"),rs.getDouble("SEEDS_PRICE")
                                    ,rs.getDouble("SELLING_PRICE"),rs.getInt("NO_OF_PLANT"),rs.getString("AGRICULTURE_SEASON"),rs.getDouble("HUMIDITY_PER")
                                    ,rs.getString("SUPER_D_NUMBER")});
                                    } 
                         // con.close(); //masaht al close la ino b3ml close t7t
                    } catch (SQLException ex) {
                        Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   con.commit();
                   con.close();
                 
                   
            }
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            con= o.getConnection();
            int a=0;
            String namePlantString="";
           
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select p_barcode,P_NAME from planets where p_barcode="+
                    jTextField32.getText());
                   int count = 0;
                       while (rs.next()) {
                              count++;
                               a=rs.getInt("p_barcode");
                               namePlantString=rs.getString("P_NAME");
                        } 
             
             
        if (jTextField31.getText().equals("")|jTextField32.getText().equals(""))
            JOptionPane.showMessageDialog(null,"There is an empty field.");
        else if (count==0)
              JOptionPane.showMessageDialog(null,"This barcode doesn't exist.");
        else if(!jTextField31.getText().equals(namePlantString))
            JOptionPane.showMessageDialog(null,"The name does not compatible with Barcode");
        else {
            stmta.executeUpdate("delete from planets where p_barcode="+a);
            DefaultTableModel model=(DefaultTableModel)jTable4.getModel();
            int countrowJtable1=jTable4.getRowCount();
            for(int i=countrowJtable1-1;i>=0;i--){
                model.removeRow(i);
            }
        
            try{//update planet Table

                ResultSet rslt;
                rslt = stmta.executeQuery("select * from farmer_planets fp,planets p where p.p_barcode= fp.super_p_barcode and super_ssn='"+this.ssn+"'");//every thing in plant
                       // int count = 0;
                    while (rslt.next()) {
                            model.addRow(new Object[]{rslt.getString("P_NAME"),rslt.getString("P_BARCODE"),rslt.getDouble("SEEDS_PRICE")
                            ,rslt.getDouble("SELLING_PRICE"),rslt.getInt("NO_OF_PLANT"),rslt.getString("AGRICULTURE_SEASON"),rslt.getDouble("HUMIDITY_PER")
                                ,rslt.getString("SUPER_D_NUMBER")});
                          } 
                // con.close(); //masaht al close la ino b3ml close t7t
              } catch (SQLException ex) {
                 Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
             }
              JOptionPane.showMessageDialog(null,"The planet was deleted successfully.");
              this.jInternalFrame3.setVisible(false);
        }
         con.commit();
         con.close();
     

        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
         try{
            con= o.getConnection();
            String a="";
            String b="";
            long c=0;
            String d="";
            long e=0;
            long f=0;
            String g="";
            long h=0;
            
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select * from planets where p_barcode="+
                    jTextField63.getText());
                   int count = 0;
                       while (rs.next()) {
                              count++;
                               a=rs.getString(1);
                               b=rs.getString(2);
                               c=rs.getLong(3);
                               d=rs.getString(4);
                               e=rs.getLong(5);
                               f=rs.getLong(6);
                               g=rs.getString(7);
                               h=rs.getLong(8);
                              

                        } 
              if (count==0)
              JOptionPane.showMessageDialog(null,"This barcode doesn't not exist.");
              else {
                jTextField68.setText(b+"");
                jTextField70.setText(f+"");
                jTextField71.setText(c+"");
                jTextField64.setText(h+"");
                jTextField65.setText(d+"");
                jTextField66.setText(e+"");
                jTextField67.setText(g+"");
                }
                con.close();/**/
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
      
        try {
            // TODO add your handling code here:
            Connection con1=o.getConnection();
            Statement stmt=con1.createStatement();
             ResultSet resultSet;
                int count1=0;
                int quantity=0;

                resultSet =stmt.executeQuery("select * from department d where d_number= "+jTextField67.getText()+" and d.super_ssn= "+this.ssn);
              while(resultSet.next()){
                  count1++;
                  quantity=resultSet.getInt("crop_number");

              }
              if (count1==1)
                  
              {
             String f ="update department set crop_number = '"+jTextField70.getText()+"' where d_number = '"+jTextField67.getText()+"'";;
             String g="update planets " + 
                                "set p_name ='"+jTextField68.getText()+"'"+
                                ",selling_price ="+jTextField71.getText()+
                                ", AGRICULTURE_SEASON = '"+ jTextField65.getText()+"'"+
                                ", HUMIDITY_PER ="+ jTextField66.getText()+
                                ", NO_OF_PLANT ="+ jTextField70.getText()+
                                ", SUPER_D_NUMBER ='"+ jTextField67.getText()+"'"+
                                ", SEEDS_PRICE ="+jTextField64.getText()+"where P_BARCODE='"+jTextField63.getText()+"'";
                  
              stmt.executeUpdate(g);
              stmt.executeUpdate(f);
              con1.commit();
              con1.close();
              JOptionPane.showMessageDialog(null,"The planet information was updated successfully.");
              this.jInternalFrame3.setVisible(false);


              }
              else 
                 JOptionPane.showMessageDialog(null,"This department number is not exist or the crop type doesn't match.");

        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         try {
             
              
           //remove all content in JTable4 and reAdd on it by executeQuery   
        DefaultTableModel model=(DefaultTableModel)jTable4.getModel();
        int countrowJtable1=jTable4.getRowCount();
        for(int i=countrowJtable1-1;i>=0;i--){
            model.removeRow(i);
        }
        
         try{//update planet Table
             con = o.getConnection();
             Statement stmta =con.createStatement();

            ResultSet rs;
            rs = stmta.executeQuery("select * from farmer_planets,planets where p_barcode=super_p_barcode and super_ssn='"+this.ssn+"'");//every thing in plant
                   int count = 0;
                   while (rs.next()) {
                          model.addRow(new Object[]{rs.getString("P_NAME"),rs.getString("P_BARCODE"),rs.getDouble("SEEDS_PRICE")
                          ,rs.getDouble("SELLING_PRICE"),rs.getInt("NO_OF_PLANT"),rs.getString("AGRICULTURE_SEASON"),rs.getDouble("HUMIDITY_PER")
                          ,rs.getString("SUPER_D_NUMBER")});
                        } 
              
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
              
              
              con.commit();
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ResultSet ss;
        String g="";
        try {
             con= o.getConnection();
             Statement stmta =con.createStatement();
             if (pas & (oldPassTxt.getText().equals("")| NewPassTxt.getText().equals("")|
                 RnewPassTxr.getText().equals("")))
                  JOptionPane.showMessageDialog(null,"There is an empty fields.");
             else{
        
             ss =stmta.executeQuery("select * from farmer where ssn ="+this.ssn);
             while (ss.next()) {
               if (pas &!(ss.getString("f_password").equals(oldPassTxt.getText())))
                     JOptionPane.showMessageDialog(null,"The old password is not correct.");
               else if (pas & !(NewPassTxt.getText().equals(RnewPassTxr.getText())))
                     JOptionPane.showMessageDialog(null,"The new password desn't match.");
               else 
                  if (pas)
                      g="update farmer " + 
                                "set f_email ='"+EditEmailTxt.getText()+"'"+
                                /*",City ='"+jComboBox4.getSelectedItem()+
                                "'*/", Street  ='"+ StreetTXt.getText()+
                                "', f_password ='"+ RnewPassTxr.getText()+"'where ssn="+this.ssn;
                  else
                      g="update farmer " + 
                                "set f_email ='"+EditEmailTxt.getText()+"'"+
                                /*",City ='"+jComboBox4.getSelectedItem()+
                                "'*/", Street  ='"+ StreetTXt.getText()+
                                "'"/*, f_password ='"+ RnewPassTxr.getText()*/+"where ssn="+this.ssn;
                   stmta.executeUpdate(g);
                   JOptionPane.showMessageDialog(null,"The farmer information was changed successfully.");
             }  
              con.commit();
              con.close();
        }} catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        String CityComboString=jComboBox4.getSelectedItem().toString();
        if(CityComboString.equals("Nablus")||CityComboString.equals("Tubas")||CityComboString.equals("Tulkarem")||CityComboString.equals("Qalqilya")||CityComboString.equals("Selfeet")){
            jComboBox5.setSelectedItem("09");
        }
        if(CityComboString.equals("Ramallah & Berih")||CityComboString.equals("Jericho")||CityComboString.equals("Jurosalem")||CityComboString.equals("beathlehem")||CityComboString.equals("Hebron")){
            jComboBox5.setSelectedItem("02");
        }
        if(CityComboString.equals("Jenin")){
            jComboBox5.setSelectedItem("04");
        }
        if(CityComboString.equals("Khan Younes")||CityComboString.equals("Rafah")||CityComboString.equals("South Gaza")||CityComboString.equals("Gaza")){
            jComboBox5.setSelectedItem("08");
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jTextField15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyReleased
        // TODO add your handling code here:
         if (jTextField15.getText().equals("")|jComboBox3.getSelectedItem().equals("Select Filter")){
            try {
                //delete frome table
                con= o.getConnection();
               // Statement stmta =con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
               
         DefaultTableModel model=(DefaultTableModel)jTable4.getModel();
                    int countrowJtable1=jTable4.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
                //add to table
                    try{
              con= o.getConnection();
               int a=0;
               Statement stmta =con.createStatement();
               ResultSet rs; 
         
               
               rs= stmta.executeQuery("select * from farmer_planets fp , planets p where p.p_barcode= fp.super_p_barcode and fp.super_ssn="+this.ssn);
               while (rs.next()) {
                       //table code
                             model.addRow(new Object[]{rs.getString("P_NAME"),rs.getString("P_BARCODE"),rs.getDouble("SEEDS_PRICE")
                                    ,rs.getDouble("SELLING_PRICE"),rs.getInt("NO_OF_PLANT"),rs.getString("AGRICULTURE_SEASON"),rs.getDouble("HUMIDITY_PER")
                                    ,rs.getString("SUPER_D_NUMBER")});
                        } 
               con.close();}
        catch(SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }

                   //end unselected
                  
        } 

        else {
        DefaultTableModel model =(DefaultTableModel)jTable4.getModel();
        int countrow=jTable4.getRowCount();
        for(int i=countrow-1;i>=0;i--){
            model.removeRow(i);
        }    
        //add to table
        try {
            con= o.getConnection();
            
               Statement stmta =con.createStatement();
               ResultSet rs; 
               String isselection="";
                
               if(jComboBox3.getSelectedItem().equals("Plant name"))
                   isselection="p_name";
               if(jComboBox3.getSelectedItem().equals("Barcode"))
                   isselection="p_barcode";
               if(jComboBox3.getSelectedItem().equals("Department"))
                   isselection="super_d_number";
                             // rs= stmta.executeQuery("select * from department where "+ isselection+"like'"+SearchDepartmentTxt.getText()+"%' and super_ssn="+this.ssn);

               rs= stmta.executeQuery("select * from farmer_planets fp,planets p where p.p_barcode=fp.super_p_barcode and fp.super_ssn="+this.ssn+" and " +isselection +" like '"+jTextField15.getText()+"%'");
               while (rs.next()) {
                      
                     model.addRow(new Object[]{rs.getString("P_NAME"),rs.getString("P_BARCODE"),rs.getDouble("SEEDS_PRICE")
                                    ,rs.getDouble("SELLING_PRICE"),rs.getInt("NO_OF_PLANT"),rs.getString("AGRICULTURE_SEASON"),rs.getDouble("HUMIDITY_PER")
                                    ,rs.getString("SUPER_D_NUMBER")});
               } 
               con.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }                                 
       
    }//GEN-LAST:event_jTextField15KeyReleased

    private void SettingPanelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingPanelButtonMousePressed
        // TODO add your handling code here:
        setcolor(SettingPanelButton, sider7);
        resetColor(MoneyPanelbutton, sider2);
//        resetColor(clientpanelbutton, sider3);
        resetColor(DepatmentPanelButton, sider4);
        resetColor(EmployeePanelButton, sider5);
        resetColor(plantsPanelButton,sider6);
        resetColor(HomePanelButton, sider1);
        cardLayout.show(PanelCard,"HomePanel");
        cardLayout6.show(HomePanel,"card3");
        oldPassLbl.setVisible(false);
        oldPassTxt.setVisible(false);
        NewPassLbl.setVisible(false);
        NewPassTxt.setVisible(false);
        ReapetLbl.setVisible(false);
        RNewPassLbl.setVisible(false);
        RnewPassTxr.setVisible(false);
        this.jSeparator28.setVisible(false);
        this.jSeparator29.setVisible(false);
        this.jSeparator30.setVisible(false);
    }//GEN-LAST:event_SettingPanelButtonMousePressed

    private void jLabel124MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel124MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel124MousePressed

    private void edit6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit6MousePressed
        // TODO add your handling code here:
        FnameTxt.setEditable(true);
    }//GEN-LAST:event_edit6MousePressed

    private void edit7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit7MousePressed
        // TODO add your handling code here:
        LnameTxt.setEditable(true);
    }//GEN-LAST:event_edit7MousePressed

    private void SearchDepartmentTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchDepartmentTxtKeyReleased
        // TODO add your handling code here:
        //remove from table
        if (SearchDepartmentTxt.getText().equals("")|jComboBox2.getSelectedItem().equals("Select filter")){
            try {
                //delete frome table
                con= o.getConnection();
                Statement stmta =con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
               
         DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
                    int countrowJtable1=jTable3.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
                //add to table
                    try{

                        ResultSet rs;
                        con= o.getConnection();
                        Statement stmta =con.createStatement();
                        rs = stmta.executeQuery("select * from department where super_ssn='"+this.ssn+"'");//every thing in plant
                            int count = 0;
                            while (rs.next()) {
                                    model.addRow(new Object[]{rs.getString("D_NUMBER"),rs.getString("D_LOCATION"),rs.getString("MANEGER_SSN")
                                    ,rs.getString("CROP_TYPE"),rs.getInt("CROP_NUMBER")});
                                    } 
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                  
        } 

        else {
        DefaultTableModel model =(DefaultTableModel)jTable3.getModel();
        int countrow=jTable3.getRowCount();
        for(int i=countrow-1;i>=0;i--){
            model.removeRow(i);
        }    
        //add to table
        try {
            con= o.getConnection();
            int a=0;
               Statement stmta =con.createStatement();
               ResultSet rs; 
               String isselection="";
               
               if(jComboBox2.getSelectedItem().equals("Department NO."))
                   isselection="d_number";
               if(jComboBox2.getSelectedItem().equals("Manager SSN"))
                   isselection="maneger_ssn";
               if(jComboBox2.getSelectedItem().equals("Crop Type"))
                   isselection="crop_type";
               //  rs= stmta.executeQuery("select * from farmer_planets fp,planets pand fp.super_ssn="+this.ssn+" and " +isselection +" like '"+jTextField15.getText()+"%'");
               rs= stmta.executeQuery("select * from department where "+ isselection+" like '"+SearchDepartmentTxt.getText()+"%' and super_ssn="+this.ssn);
               while (rs.next()) {
                      
                       model.addRow(new Object[]{rs.getString("D_NUMBER"),rs.getString("D_LOCATION"),rs.getString("MANEGER_SSN")
                                    ,rs.getString("CROP_TYPE"),rs.getInt("CROP_NUMBER")});
               } 
               con.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }//GEN-LAST:event_SearchDepartmentTxtKeyReleased
    }
    private void SearchEmploTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchEmploTxtKeyReleased
        // TODO add your handling code here:
                //remove from table
        if (SearchEmploTxt.getText().equals("")|jComboBox6.getSelectedItem().equals("Select Filter")){
            try {
                //delete frome table
                con= o.getConnection();
                Statement stmta =con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
               
         DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
                    int countrowJtable1=jTable2.getRowCount();
                    for(int i=countrowJtable1-1;i>=0;i--){
                        model.removeRow(i);
                    }
                //add to table
                    try{

                        ResultSet rst;
                        con= o.getConnection();
                        Statement stmta =con.createStatement();
                        Statement stmta1=con.createStatement();
                       ResultSet rst1;
                       boolean manager=false;
                        rst = stmta.executeQuery("select * from employee where super_ssn="+this.ssn);//every thing in plant
                            int count = 0;
                            while (rst.next()) {
                                 rst1=stmta1.executeQuery("select maneger_ssn from department where maneger_ssn = "+rst.getString("ssn")+" and super_ssn = "+this.ssn);
                            
                            
                              while(rst1.next())
                            {
                                count++;
                            }
                             manager=false;
                             if( count!=0)
                              manager=true;
                             
                                     model.addRow(new Object[]{rst.getString("FIRST_NAME")+rst.getString("LAST_NAME"),rst.getString("WORK_NUMBER"),rst.getString("SSN")
                                    ,"0"+rst.getString("PHONE_NUMBER"),rst.getString("STREET")+"_"+rst.getString("CITY"),rst.getDate("B_DATE"),rst.getString("JOP_DICRIBTION")
                                    ,rst.getString("SHIFT"),rst.getDouble("SALARY"),rst.getString("SUPER_D_NUMBER"),manager});                                    } 
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                  
        } 

        else {
        DefaultTableModel model =(DefaultTableModel)jTable2.getModel();
        int countrow=jTable2.getRowCount();
        for(int i=countrow-1;i>=0;i--){
            model.removeRow(i);
        }    
        //add to table
        try {
            con= o.getConnection();
            int a=0;
               Statement stmta =con.createStatement();
               ResultSet rst1; 
               String isselection="";
               
               if(jComboBox6.getSelectedItem().equals("Employee name"))
                   isselection="first_name";
               if(jComboBox6.getSelectedItem().equals("Work NO."))
                   isselection="work_number";
               if(jComboBox6.getSelectedItem().equals("Department No."))
                   isselection="super_d_number";
               if(jComboBox6.getSelectedItem().equals("Job"))
                   isselection="jop_dicribtion";
               //  rs= stmta.executeQuery("select * from employeewhere super_ssn="+this.ssn+" and " +isselection +" like '"+SearchEmploTxt.getText()+"%'");
               rst1= stmta.executeQuery("select * from employee where "+ isselection+" like '"+SearchEmploTxt.getText()+"%' and super_ssn="+this.ssn);
               while (rst1.next()) {
                      
                       model.addRow(new Object[]{rst1.getString("FIRST_NAME")+rst1.getString("LAST_NAME")
                                    ,rst1.getString("WORK_NUMBER"),rst1.getString("SSN")
                                    ,"0"+rst1.getString("PHONE_NUMBER"),rst1.getString("STREET")+"_"+rst1.getString("CITY")
                                    ,rst1.getDate("B_DATE"),rst1.getString("JOP_DICRIBTION")
                                    ,rst1.getString("SHIFT"),rst1.getDouble("SALARY"),rst1.getString("SUPER_D_NUMBER"),/*manager*/});
               } 
               con.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    } 
    }//GEN-LAST:event_SearchEmploTxtKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            con= o.getConnection();
            Statement stmt;
            stmt = con.createStatement();
            String n="";
            if (jTextField23.getText().equals("")|
                jTextField40.getText().equals("")|
                jTextField42.getText().equals(""))
                JOptionPane.showMessageDialog(null,"There is an empty fieldes");
            else {
                   String g="update farmer " + 
                                "set taxes ="+jTextField42.getText()+
                                ",water_price ="+jTextField23.getText()+
                                ", fertilizer_price = "+ jTextField40.getText()+
                                "where ssn ='"+this.ssn+"'";
                  
              stmt.executeUpdate(g);
              con.commit();
              con.close();
            }}
            catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model=(DefaultTableModel)jTable6.getModel();
        int countrowJtable1=jTable6.getRowCount();
        for(int i=countrowJtable1-1;i>=0;i--){
            model.removeRow(i);
        }
        try{
            con= o.getConnection();
            Statement stmta =con.createStatement();
         ResultSet rslt1;
         
          double waterp=0;
         double ferp=0;
         double tax=0;
         Statement stmt65=con.createStatement();
         ResultSet rs65 =stmt65.executeQuery("select * from farmer where ssn = " + this.ssn);
         while(rs65.next()){
             waterp = rs65.getDouble("water_Price");
              ferp = rs65.getDouble("FERTILIZER_PRICE");
               tax =rs65.getDouble("taxes");
         }
            rslt1 = stmta.executeQuery("select * from department d,planets p,farmer_planets fp where d.d_number=p.super_d_number and p.p_barcode=fp.super_p_barcode and d.super_ssn="+this.ssn +" and fp.super_ssn = "+this.ssn);
            while(rslt1.next()){
                
                model.addRow(new Object[]{rslt1.getString("d_number"),rslt1.getDouble("FERTILIZER_NEEDED_LITER")*ferp
                ,waterp * rslt1.getDouble("WATER_NEEDED_LITER"),rslt1.getDouble("CROP_NUMBER")*rslt1.getDouble("SEEDS_PRICE")});
            }
            
            ResultSet rs;
            rs = stmta.executeQuery("select * from client_bill where super_ssn="+this.ssn);
                   double count = 0;
                       while (rs.next()) {
                           count=count+rs.getDouble("TOTAL_PRICE");
                          
                        } 
                       jTextField1.setText(""+count);
                       
             ResultSet rslt;
            rslt = stmta.executeQuery("select * from planets p,farmer_planets fp where p.p_barcode=fp.super_p_barcode and fp.super_ssn="+this.ssn);
            double count1=0;
            while(rslt.next()){
                count1=count1+rslt.getDouble("SEEDS_PRICE");
            }
            jTextField4.setText(""+count1);
            Statement stmt9=con.createStatement();
            ResultSet set9;
            double salary=0;
            set9=stmt9.executeQuery("select salary from employee where super_ssn = "+this.ssn);
            while (set9.next())
            {
                salary=salary+set9.getDouble("salary");
            }
            jTextField44.setText(""+salary);
           DefaultTableModel model1=(DefaultTableModel)jTable6.getModel();
           int rowjTable6=jTable6.getRowCount();
           double waterFarm=0;
           double FerFarm=0;
           for(int i=rowjTable6-1;i>=0;i--){
            waterFarm=waterFarm + Double.parseDouble(""+model.getValueAt(i,2));
            FerFarm=FerFarm + Double.parseDouble(""+model.getValueAt(i,1));
           }
            jTextField2.setText(""+waterFarm);
            jTextField3.setText(""+FerFarm);
            double profit=Double.parseDouble(jTextField1.getText())-(Double.parseDouble(jTextField44.getText())+Double.parseDouble(jTextField2.getText())+Double.parseDouble(jTextField3.getText())+Double.parseDouble(jTextField4.getText()));
            jTextField5.setText(""+profit);
           
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        // TODO add your handling code here:
        
        if (jTextField13.getText().equals("") || jComboBox1.getSelectedItem().equals("Select Filter")){
           
         DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int countrowJtable1=jTable1.getRowCount();
        for(int i=countrowJtable1-1;i>=0;i--){
            model.removeRow(i);
        }
         try{//home table
            con= o.getConnection();
            Statement stmta =con.createStatement();
            ResultSet rs;
            rs = stmta.executeQuery("select * from client c,client_bill cb,client_number cn where c.client_number = cb.super_client_number"
                    + " and c.client_number = cn.super_client_number and super_ssn="+this.ssn);
                   int count = 0;
                       while (rs.next()) {
                          model.addRow(new Object[]{rs.getString("BILL_NUM"),rs.getString("FIRST_NAME")+rs.getString("LAST_NAME"),rs.getString("PHONE_NUMBER"),rs.getString("Street")+"_"+rs.getString("city")
                          ,rs.getDouble("TOTAL_PRICE"),rs.getDate("SOLD_DATE")});
                        } 
        } catch (SQLException ex) {
            Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         else {//Select Filter, Bill Number, Customer Number, Date
             //Select Filter, Select Filter, Bill Number, Customer Number, Date, Customer Number, Date
              String f= "";
            //  Select Filter, Bill Number, Customer Number, Date
         if (jComboBox1.getSelectedItem().equals("Bill Number"))
             f="bill_num";
         if (jComboBox1.getSelectedItem().equals("Customer Name"))
             f="First_Name";
         if (jComboBox1.getSelectedItem().equals("Date"))
             f="sold_date";
         ResultSet rt;
         try{
          DefaultTableModel model3=(DefaultTableModel)jTable1.getModel();
        int countrowJtable1=jTable1.getRowCount();
        for(int i=countrowJtable1-1;i>=0;i--){
            model3.removeRow(i);
        }
        con=o.getConnection();
         Statement stmt123=con.createStatement();
          rt= stmt123.executeQuery("select * from client c,client_bill cb,client_number cn where c.client_number = cb.super_client_number"
                    + " and c.client_number = cn.super_client_number and super_ssn="+this.ssn+ " and "+ f+" like '"+jTextField13.getText()+"%'");
         while(rt.next()){
             System.err.println(jTextField13.getText());
             System.out.println(rt.getDate("SOLD_DATE"));
              model3.addRow(new Object[]{rt.getString("BILL_NUM"),rt.getString("FIRST_NAME")+rt.getString("LAST_NAME"),rt.getString("PHONE_NUMBER"),rt.getString("Street")+"_"+rt.getString("city")
                          ,rt.getDouble("TOTAL_PRICE"),rt.getDate("SOLD_DATE")});
         }
           con.close();
         }   catch (SQLException ex) {  
                 Logger.getLogger(farmerprog.class.getName()).log(Level.SEVERE, null, ex);
             }  
         }
    }//GEN-LAST:event_jTextField13KeyReleased

    
    //***
    //****
    //****
    //*****
    //**
    //**
    //-****
    //***
    //forPnlButton
    void setcolor(JPanel panel1,JPanel panel2){
        panel1.setBackground(new Color(77,148,95));
        panel2.setBackground(new Color(142,180,152));
    }
    void resetColor(JPanel panel1,JPanel panel2){
        panel1.setBackground(new Color(68,131,84));
        panel2.setBackground(new Color(68,131,84));
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
            java.util.logging.Logger.getLogger(farmerprog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(farmerprog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(farmerprog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(farmerprog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new farmerprog("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddDepartmentBtn;
    private javax.swing.JPanel AddPlantBtn;
    private javax.swing.JPanel AddPnlBtn1;
    private javax.swing.JPanel BtnPnls;
    private javax.swing.JLabel ChangPass;
    private javax.swing.JPanel DepartMentPanel;
    private javax.swing.JPanel DepartmentHome;
    private javax.swing.JPanel DepatmentPanelButton;
    private javax.swing.JButton DismissBtn;
    private javax.swing.JButton DismissBtn1;
    private javax.swing.JButton DismissPantBtn;
    private javax.swing.JTextField EditEmailTxt;
    private javax.swing.JTextField EditTelTxt;
    private javax.swing.JPanel EmployeePanelButton;
    private javax.swing.JPanel EployeePanel;
    private javax.swing.JTextField FnameTxt;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JPanel HomePanelButton;
    private javax.swing.JPanel InternalCard;
    private javax.swing.JPanel Internalcard1;
    private javax.swing.JPanel Internalcard4;
    private javax.swing.JTextField LnameTxt;
    private javax.swing.JPanel LogOutPanelButton;
    private javax.swing.JPanel MoneyCalPanel;
    private javax.swing.JPanel MoneyPanelbutton;
    private javax.swing.JLabel NewPassLbl;
    private javax.swing.JTextField NewPassTxt;
    private javax.swing.JPanel PanelCard;
    private javax.swing.JPanel PlantsPanel;
    private javax.swing.JLabel RNewPassLbl;
    private javax.swing.JLabel ReapetLbl;
    private javax.swing.JPanel RemoveDepartmentPnl;
    private javax.swing.JPanel RemovePlantPnl;
    private javax.swing.JPanel RemovePnl;
    private javax.swing.JPanel RemovePnlBtn1;
    private javax.swing.JPanel RmoveDepartmentBtn;
    private javax.swing.JPanel RmovePlantBtn;
    private javax.swing.JTextField RnewPassTxr;
    private javax.swing.JButton SaveBtn1;
    private javax.swing.JButton SaveBtn2;
    private javax.swing.JTextField SearchDepartmentTxt;
    private javax.swing.JTextField SearchEmploTxt;
    private javax.swing.JLabel SettingLbl;
    private javax.swing.JPanel SettingPanelButton;
    private javax.swing.JTextField StreetTXt;
    private javax.swing.JLabel Timelabel;
    private javax.swing.JPanel UpdateAddDepartmentPnl;
    private javax.swing.JPanel UpdateAddPlantPnl;
    private javax.swing.JPanel UpdateDepartment;
    private javax.swing.JPanel UpdatePlantBtn;
    private javax.swing.JPanel UpdatePlantPnl;
    private javax.swing.JPanel UpdatePnlBtn;
    private javax.swing.JPanel UpdatedepartmentBtn;
    private javax.swing.JPanel UpdateemployeePnl;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel edit1;
    private javax.swing.JLabel edit2;
    private javax.swing.JLabel edit3;
    private javax.swing.JLabel edit4;
    private javax.swing.JLabel edit5;
    private javax.swing.JLabel edit6;
    private javax.swing.JLabel edit7;
    private javax.swing.JTextField editPhonTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel oldPassLbl;
    private javax.swing.JTextField oldPassTxt;
    private javax.swing.JPanel plantsPanelButton;
    private javax.swing.JButton saveBtn1;
    private javax.swing.JPanel sider1;
    private javax.swing.JPanel sider2;
    private javax.swing.JPanel sider4;
    private javax.swing.JPanel sider5;
    private javax.swing.JPanel sider6;
    private javax.swing.JPanel sider7;
    private javax.swing.JPanel updateAddPnl;
    // End of variables declaration//GEN-END:variables
}
