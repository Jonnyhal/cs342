/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;
import java.sql.*;
import static clienteditor.AccessDelphiDB.*;
import static clienteditor.Gym.TrainSelect;
import static clienteditor.Gym.edittag;
import java.awt.Container;
import static java.lang.System.out;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.design.JasperDesign;


/**
 *
 * @author jonny
 */
public class Training extends javax.swing.JDialog {
    private Train train = Train.createTrain();
    Connection cnn;
    
    /**
     * Creates new form Training
     */
    public Training(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        int proid = GetProId();
        //ActTable(proid);
        ActUpdate(proid);
        if (edittag == 1) {
            setFields(TrainSelect());
        }
    }
    public void setFields(int proid) {
        //if (edittag == 1) {
        //TrainProName.setText("This is a Test");
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
           
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = cnn.createStatement();
            int id = 0;
            int height = 0, sweight = 0, eweight = 0, sbmi = 0,ebmi = 0;
            String name = null, focus = null;
            ResultSet rs = stmt.executeQuery("Select p.* from B_Training p where p.proid = "+proid);
            rs.next();
            id = rs.getInt("proid");
            height = rs.getInt("memheight");
            sweight = rs.getInt("memstartweight");
            eweight = rs.getInt("memendweight");
            sbmi = rs.getInt("StartBMI");
            ebmi = rs.getInt("EndBMI");
            name = rs.getString("Name");
            focus = rs.getString("Focus");
            Training.TrainProName.setText(name);
            Training.TrainProFocus.setText(focus);
            TrainProHeight.setText(Integer.toString(height));
            TrainProSWeight.setText(Integer.toString(sweight));
            TrainProEWeight.setText(Integer.toString(eweight));
            TrainProSBMI.setText(Integer.toString(sbmi));
            TrainProEBMI.setText(Integer.toString(ebmi));
            
            String sdate, edate;
            ResultSet rst = stmt.executeQuery("Select p.* from B_Trains p where p.proid = "+proid);
            rst.next();
            sdate = rst.getString("sdate");
            edate = rst.getString("edate");
            String nsdate = sdate.substring(0, sdate.length() - 8);
            String nedate = edate.substring(0, edate.length() - 8);
            TrainSDate.setText(nsdate);
            TrainEDate.setText(nedate);
            Training.ActUpdate(id);
        } catch (Exception e) {e.printStackTrace(); System.exit(-1);}
       // }
       

    }
    public int GetProId() {
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            Connection cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "Select p.proid from B_training p";
            st=cnn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            int id = 0;
            while(rs.next()) {
                id = rs.getInt("proid");
            }
            //id++;
            return id;
        } catch (Exception e){
            e.printStackTrace(); System.exit(-1);
        }
        return 0;
    }
    static public void ActUpdate(int proid) {
         try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            Connection cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "select a.proid, a.actid, a.actname,a.time,a.reps,a.sets"
                    + ",a.slimit,a.climit from b_actview a where a.proid = "+proid+" order by a.actid";
            st=cnn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            ActTable.setModel(DbUtils.resultSetToTableModel(rs));
            cnn.close();
         } catch (Exception e){
             e.printStackTrace(); System.exit(-1);
         }
    }
    private void showJasper() {
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            JasperDesign d = JasperManager.loadXmlDesign("//home/jonny/NetBeansProjects/GYM/src/clienteditor/trainReport.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(d);
            int proid = TrainSelect();
            HashMap param = new HashMap();
            param.put("proid", proid);
            JasperPrint print = JasperFillManager.fillReport(jr, param, cnn);
            JFrame frame = new JFrame("Report");
            frame.getContentPane().add(new JRViewer(print));
            frame.pack();
            frame.setVisible(true);
            cnn.close();

         } catch (Exception e){
             e.printStackTrace(); System.exit(-1);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        TrainProName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TrainProFocus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TrainProHeight = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TrainProSWeight = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TrainProEWeight = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TrainProSBMI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TrainProEBMI = new javax.swing.JTextField();
        ProSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TrainingProgramReport = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        TrainSDate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TrainEDate = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ActTable = new javax.swing.JTable();
        NewActivity = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ActName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ActTime = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ActSets = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ActReps = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ActSLimit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ActCLimit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TrainProName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainProNameActionPerformed(evt);
            }
        });

        jLabel6.setText("Program Name:");

        jLabel7.setText("Program Focus:");

        TrainProFocus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainProFocusActionPerformed(evt);
            }
        });

        jLabel1.setText("Height");

        TrainProHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainProHeightActionPerformed(evt);
            }
        });

        jLabel2.setText("Starting Weight:");

        TrainProSWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainProSWeightActionPerformed(evt);
            }
        });

        jLabel3.setText("Ending Weight:");

        TrainProEWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainProEWeightActionPerformed(evt);
            }
        });

        jLabel4.setText("Start BMI:");

        TrainProSBMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainProSBMIActionPerformed(evt);
            }
        });

        jLabel5.setText("End BMI:");

        TrainProEBMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainProEBMIActionPerformed(evt);
            }
        });

        ProSave.setText("Save");
        ProSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProSaveActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TrainingProgramReport.setText("Training Program Report");
        TrainingProgramReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainingProgramReportActionPerformed(evt);
            }
        });

        jLabel14.setText("Start Date:");

        TrainSDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainSDateActionPerformed(evt);
            }
        });

        jLabel15.setText("End Date:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TrainingProgramReport)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TrainProSWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(TrainSDate, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TrainProSBMI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(44, 44, 44)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TrainProEWeight)
                                            .addComponent(TrainProEBMI)
                                            .addComponent(TrainEDate)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TrainProHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TrainProFocus, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(TrainProName, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TrainProName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TrainProFocus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TrainProHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TrainProSWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TrainProSBMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(TrainSDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TrainProEWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TrainProEBMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(TrainEDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProSave)
                    .addComponent(jButton2)
                    .addComponent(TrainingProgramReport))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Program Info", jPanel2);

        ActTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ActTable);

        NewActivity.setText("Insert New Activity");
        NewActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActivityActionPerformed(evt);
            }
        });

        jLabel8.setText("Activity Name:");

        ActName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActNameActionPerformed(evt);
            }
        });

        jLabel9.setText("Time(min):");

        ActTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActTimeActionPerformed(evt);
            }
        });

        jLabel10.setText("Sets:");

        ActSets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActSetsActionPerformed(evt);
            }
        });

        jLabel11.setText("Reps:");

        ActReps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActRepsActionPerformed(evt);
            }
        });

        jLabel12.setText("Starting Limit:");

        ActSLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActSLimitActionPerformed(evt);
            }
        });

        jLabel13.setText("Current Limit:");

        ActCLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActCLimitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ActName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActTime, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActSLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ActSets, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(ActReps)
                            .addComponent(ActCLimit)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(NewActivity)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ActName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(ActTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(ActReps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ActSLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(ActCLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(NewActivity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Activitys", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ProSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProSaveActionPerformed
        // TODO add your handling code here:
        //Trainer Program
        String pname = TrainProName.getText();
        String focus = TrainProFocus.getText();
        int height = Integer.parseInt(TrainProHeight.getText());
        int sweight = Integer.parseInt(TrainProSWeight.getText());
        int sbmi = Integer.parseInt(TrainProSBMI.getText());
        int ebmi = 0; 
        int eweight = 0; 
        String sdate = TrainSDate.getText();
        String edate = TrainEDate.getText();
        //Activity
        if (TrainProEBMI.getText() != null) {
            ebmi = Integer.parseInt(TrainProEBMI.getText());
        }
        if (TrainProEWeight.getText() != null) {
            eweight = Integer.parseInt(TrainProEWeight.getText());
        }
          try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = cnn.createStatement();
            int id = 0;
            ResultSet rs = stmt.executeQuery("Select p.proid from B_Training p");
            while(rs.next()) {
                id = rs.getInt("proid");
            }
            if (Gym.edittag == 0) {
            
                id++;
            }
            train.setProId(id);
            if (Gym.updateval == 0) {
            db.executeSQL("INSERT into B_Training values("+id+","+height+","+sweight+","+eweight+","+sbmi+
                    ","+ebmi+",'"+pname+"','"+focus+"')");
            } 
            if (Gym.updateval == 1) {
                pname = TrainProName.getText();
                focus = TrainProFocus.getText();
                height = Integer.parseInt(TrainProHeight.getText());
                sweight = Integer.parseInt(TrainProSWeight.getText());
                sbmi = Integer.parseInt(TrainProSBMI.getText());
                ebmi = Integer.parseInt(TrainProEBMI.getText()); 
                eweight = Integer.parseInt(TrainProEWeight.getText());
                db.executeSQL ("Update B_Training set MemHeight = "+height+", "
                        + "MemStartWeight="+sweight+", MemEndWeight="+eweight+","
                        + "Startbmi="+sbmi+",Endbmi="+ebmi+",Name='"+pname+"',"
                        + "Focus='"+focus+"' where Proid="+TrainSelect());
            }
            out.println("ebmi is "+ebmi);

          if (Gym.edittag == 0) {  
          Gym.empTrainSelect(id, sdate);
          Gym.memTrainSelect(id,sdate,edate);
          ActUpdate(id);
          cnn.close();
          }
          Gym.updateTrainerProTable();
      } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
        

      dispose();
    }//GEN-LAST:event_ProSaveActionPerformed

    private void TrainProNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainProNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TrainProNameActionPerformed

    private void TrainProFocusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainProFocusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainProFocusActionPerformed

    private void TrainProHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainProHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainProHeightActionPerformed

    private void TrainProSWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainProSWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainProSWeightActionPerformed

    private void TrainProSBMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainProSBMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainProSBMIActionPerformed

    private void TrainProEWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainProEWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainProEWeightActionPerformed

    private void TrainProEBMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainProEBMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainProEBMIActionPerformed

    private void ActNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActNameActionPerformed

    private void ActTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActTimeActionPerformed

    private void ActSLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActSLimitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActSLimitActionPerformed

    private void ActSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActSetsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActSetsActionPerformed

    private void ActRepsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActRepsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActRepsActionPerformed

    private void ActCLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActCLimitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActCLimitActionPerformed

    private void NewActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActivityActionPerformed
        // TODO add your handling code here:
        String actname = ActName.getText();
        int time = Integer.parseInt(ActTime.getText());
        int slimit = Integer.parseInt(ActSLimit.getText());
        int climit = Integer.parseInt(ActCLimit.getText());
        int sets = Integer.parseInt(ActSets.getText());
        int reps = Integer.parseInt(ActReps.getText());
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            //user = usr; passwd = pwd;
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = cnn.createStatement();
            int proid = 0;
            int actid = 0;
            //ResultSet rs = stmt.executeQuery("Select p.proid from B_Training p");
            ResultSet rst = stmt.executeQuery("Select a.actId from b_activity a");
            while(rst.next()) {
                actid = rst.getInt("actid");
            }
            proid =  TrainSelect();
            actid++;
            String actsql = "Insert into b_activity values ("+actid+",'"+actname+"')";
            db.executeSQL(actsql);
            String invsql = "Insert into b_involves values ("+proid+","+actid+","+slimit+","+climit+","+time+","
                    + ""+reps+","+sets+")";
            db.executeSQL(invsql);
            ActUpdate(proid);
            cnn.close();
      } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
        //ActTable(GetProId());
    }//GEN-LAST:event_NewActivityActionPerformed

    private void TrainSDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainSDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainSDateActionPerformed

    private void TrainingProgramReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainingProgramReportActionPerformed
        // TODO add your handling code here:
        showJasper();
    }//GEN-LAST:event_TrainingProgramReportActionPerformed

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
            java.util.logging.Logger.getLogger(Training.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Training.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Training.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Training.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Training dialog = new Training(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /*private javax.swing.JTextField ActCLimit;
    private javax.swing.JTextField ActName;
    private javax.swing.JTextField ActReps;
    private javax.swing.JTextField ActSLimit;
    private javax.swing.JTextField ActSets;
    private javax.swing.JTable ActTable;
    private javax.swing.JTextField ActTime;*/
    private javax.swing.JButton NewActivity;
    private javax.swing.JButton ProSave;/*
    private javax.swing.JTextField TrainEDate;
    private javax.swing.JTextField TrainProEBMI;
    private javax.swing.JTextField TrainProEWeight;
    private javax.swing.JTextField TrainProFocus;
    private javax.swing.JTextField TrainProHeight;
    private javax.swing.JTextField TrainProName;
    private javax.swing.JTextField TrainProSBMI;
    private javax.swing.JTextField TrainProSWeight;
    private javax.swing.JTextField TrainSDate;*/
    private javax.swing.JButton TrainingProgramReport;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    static public javax.swing.JTable ActTable;
    static public javax.swing.JTextField ActCLimit;
    static public javax.swing.JTextField ActName;
    static public javax.swing.JTextField ActReps;
    static public javax.swing.JTextField ActSLimit;
    static public javax.swing.JTextField ActSets;
    static public javax.swing.JTextField ActTime;
    static public javax.swing.JTextField TrainEDate;
    static public javax.swing.JTextField TrainProEBMI;
    static public javax.swing.JTextField TrainProEWeight;
    static public javax.swing.JTextField TrainProFocus;
    static public javax.swing.JTextField TrainProHeight;
    static public javax.swing.JTextField TrainProName;
    static public javax.swing.JTextField TrainProSBMI;
    static public javax.swing.JTextField TrainProSWeight;
    static public javax.swing.JTextField TrainSDate;
}
