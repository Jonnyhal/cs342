/*
 * Copyright (c) 2010, Oracle.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  * Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package clienteditor;
import static clienteditor.AccessDelphiDB.*;
import static clienteditor.AccessDelphiDB.url;
import java.io.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;
/**
 * Form that allows editing of information about one client.
 *
 * @author Jiri Vagner, Jan Stola
 */
//import java.util.*;
//import javax.swing.JOptionPane;

public class Gym extends javax.swing.JPanel {
    private Client client = Client.createClient();
    static Connection cnn;
    Vector selectedCells = new Vector<int[]>();

    public Gym() {
        initComponents();
        //bindingGroup.addBindingListener(new LoggingBindingListener(validationMsgLabel));
        updateMemTable();
        updateMem2Table();
        updateTrainerProTable();
        trainerTable();
        updateEmployeeTable();
        updateEmpTrainerTable();
    }
    private void trainerTable() {
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "select b from b_employee b where b.etype = 'Trainer'";
            st=cnn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            empTrainerTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e){
        }
    }
    static public void updateMemTable() {
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "select * from b_members";
            st=cnn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            MemTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e){
        }
    }
    static public void updateMem2Table() {
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "select b.memid, b.fname, b.lname from b_members b";
            st=cnn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            memTrainingTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e){
        }
    }
    static public void updateTrainerProTable() {
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "select * from b_mixedtp";
            st=cnn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            TPTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
        }
    }
    static public void updateEmployeeTable() {
      try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "select * from b_employee";
            st=cnn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            empTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
        }  
    }
     static public void updateEmpTrainerTable() {
      try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "select e.empid,e.efname,e.elname,e.etype from b_employee e where e.etype = 'Trainer'";
            st=cnn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            empTrainerTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
        }  
    }
    static public void memTrainSelect(int proid, String sdate, String edate) {
        
        try {
            int selectedRow = memTrainingTable.getSelectedRow();
            int memid = Integer.parseInt( MemTable.getValueAt(selectedRow, 0).toString());
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "insert into b_trains values("+memid+","+proid+",to_date('"+sdate+"', 'mm/dd/yyyy'),to_date('"+edate+"', 'mm/dd/yyyy'))";
            db.executeSQL(sql);
        } catch (Exception e) {
        }
        
    }
    static public void empTrainSelect(int proid, String sdate) {
        int selectedRow = empTrainerTable.getSelectedRow();
        int empid = Integer.parseInt( empTrainerTable.getValueAt(selectedRow, 0).toString());
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            Statement st = null;
            ResultSet rs = null;
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            String sql = "insert into b_makes values("+empid+","+proid+",to_date('"+sdate+"', 'mm/dd/yyyy'))";
            db.executeSQL(sql);
        } catch (Exception e) {
        }
    }
    
    /**
     * Returns <code>Client</code> being edited.
     * 
     * @return <code>Client</code> being edited.
     */
    public Client getClient() {
        return client;
    }
       
    
    /** 
     * Sets client to edit.
     * 
     * @param client client to edit.
     */
    public void setClient(Client client) {
        Client oldClient = this.client;
        this.client = client;
        firePropertyChange("client", oldClient, client);
    }

    /**
     *
     * @return
     */
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        sexButtonGroup = new javax.swing.ButtonGroup();
        validationMsgLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        entityManager0 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01PU").createEntityManager();
        bMembersQuery = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT b FROM B_Members b");
        bMembersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : bMembersQuery.getResultList();
        b_MembersQuery = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT b FROM B_Members b");
        b_MembersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : b_MembersQuery.getResultList();
        b_EmployeeQuery = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT b FROM B_Employee b");
        b_EmployeeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : b_EmployeeQuery.getResultList();
        b_MembersQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT b FROM B_Members b");
        b_MembersList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : b_MembersQuery1.getResultList();
        b_MembersQuery2 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT b FROM B_Members b");
        b_MembersList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : b_MembersQuery2.getResultList();
        memTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        memUpdateButton = new javax.swing.JButton();
        memNewbutton = new javax.swing.JButton();
        memDeleteButton = new javax.swing.JButton();
        memSearchButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        MemTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memTrainingTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        MemSearchTP = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        empTrainerTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        MemSearchTP1 = new javax.swing.JTextField();
        memTrainingProg = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        MemFirstLabel2 = new javax.swing.JLabel();
        equName = new javax.swing.JTextField();
        memLastLabel2 = new javax.swing.JLabel();
        equCost = new javax.swing.JTextField();
        memDoblabel2 = new javax.swing.JLabel();
        equManu = new javax.swing.JTextField();
        memSexLabel2 = new javax.swing.JLabel();
        equRepair = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        MemTable2 = new javax.swing.JTable();
        equSave = new javax.swing.JButton();
        equNew = new javax.swing.JButton();
        equDelete = new javax.swing.JButton();
        equSearch = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        IncomeSDate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        IncomeEDate = new javax.swing.JTextField();
        incomeReport = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        reportMemSDate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        reportMemEDate = new javax.swing.JTextField();
        MemJoinedReport = new javax.swing.JButton();
        empNewbutton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        clientInfoLabel = new javax.swing.JLabel();
        clientInfoLabel1 = new javax.swing.JLabel();
        QuitButton = new javax.swing.JButton();

        validationMsgLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        validationMsgLabel.setForeground(new java.awt.Color(255, 0, 0));

        jScrollPane2.setViewportView(jTree1);

        memUpdateButton.setText("Update");
        memUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memUpdateButtonActionPerformed(evt);
            }
        });

        memNewbutton.setText("New");
        memNewbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memNewbuttonActionPerformed(evt);
            }
        });

        memDeleteButton.setText("Delete");

        memSearchButton.setText("Search");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable2);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, b_MembersList, MemTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${memid}"));
        columnBinding.setColumnName("Memid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fname}"));
        columnBinding.setColumnName("Fname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lname}"));
        columnBinding.setColumnName("Lname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${city}"));
        columnBinding.setColumnName("City");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${state}"));
        columnBinding.setColumnName("State");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${zip}"));
        columnBinding.setColumnName("Zip");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dob}"));
        columnBinding.setColumnName("Dob");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sex}"));
        columnBinding.setColumnName("Sex");
        columnBinding.setColumnClass(Character.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${phone}"));
        columnBinding.setColumnName("Phone");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sdate}"));
        columnBinding.setColumnName("Sdate");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        MemTable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                MemTableComponentAdded(evt);
            }
        });
        MemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemTableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(MemTable);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane9)
            .add(jPanel1Layout.createSequentialGroup()
                .add(495, 495, 495)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(memDeleteButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(memNewbutton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(memUpdateButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(memSearchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(495, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(43, 43, 43)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(memNewbutton)
                    .add(memUpdateButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(memSearchButton)
                    .add(memDeleteButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 28, Short.MAX_VALUE)
                .add(jScrollPane9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 365, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        memTab.addTab("Front Desk", jPanel1);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, b_MembersList1, memTrainingTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${memid}"));
        columnBinding.setColumnName("Memid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fname}"));
        columnBinding.setColumnName("Fname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lname}"));
        columnBinding.setColumnName("Lname");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        memTrainingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memTrainingTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memTrainingTable);

        jLabel2.setText("Member search:");

        MemSearchTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemSearchTPActionPerformed(evt);
            }
        });

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, b_EmployeeList, empTrainerTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${empid}"));
        columnBinding.setColumnName("Empid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${efname}"));
        columnBinding.setColumnName("Efname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${elname}"));
        columnBinding.setColumnName("Elname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${etype}"));
        columnBinding.setColumnName("Etype");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        empTrainerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTrainerTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(empTrainerTable);

        jLabel3.setText("Trainer search:");

        memTrainingProg.setText("Training Program");
        memTrainingProg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memTrainingProgActionPerformed(evt);
            }
        });

        TPTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TPTable);

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane3)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(MemSearchTP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 330, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 452, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(24, 24, 24)
                                .add(memTrainingProg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 23, Short.MAX_VALUE))
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(122, 122, 122)))
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel6Layout.createSequentialGroup()
                                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(MemSearchTP1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 330, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(MemSearchTP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(MemSearchTP1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(0, 188, Short.MAX_VALUE)
                        .add(memTrainingProg))
                    .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .add(38, 38, 38)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 187, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        memTab.addTab("Trainers", jPanel6);

        MemFirstLabel2.setText("Name:");

        memLastLabel2.setText("Cost:");

        memDoblabel2.setText("Manufacturer:");

        memSexLabel2.setText("Needs Repair (Y/N):");

        jScrollPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane4MousePressed(evt);
            }
        });

        MemTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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
                "Equipment ID", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MemTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(MemTable2);
        if (MemTable2.getColumnModel().getColumnCount() > 0) {
            MemTable2.getColumnModel().getColumn(0).setResizable(false);
            MemTable2.getColumnModel().getColumn(1).setResizable(false);
        }

        equSave.setText("Save");

        equNew.setText("New");

        equDelete.setText("Delete");

        equSearch.setText("Search");

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE)
            .add(jPanel7Layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(equDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(equNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(28, 28, 28)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(equSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(equSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(68, 68, 68)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel7Layout.createSequentialGroup()
                        .add(memDoblabel2)
                        .add(38, 38, 38))
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(MemFirstLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(memLastLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(memSexLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(equRepair, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, equName)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, equManu)
                    .add(equCost))
                .add(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(MemFirstLabel2)
                    .add(equName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(equNew)
                    .add(equSave))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(equManu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(memDoblabel2))
                .add(2, 2, 2)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(memLastLabel2)
                        .add(equDelete)
                        .add(equSearch))
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(equCost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(equRepair, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(memSexLabel2))))
                .add(18, 18, 18)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
        );

        memTab.addTab("Maintenance", jPanel7);

        jLabel12.setText("Create a report for Gyms income from Starting Date:");

        jLabel13.setText("to Ending Date:");

        IncomeEDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncomeEDateActionPerformed(evt);
            }
        });

        incomeReport.setText("Create Report");

        jLabel14.setText("Create a report for how many Members joined from Starting Date:");

        jLabel15.setText("to Ending Date:");

        MemJoinedReport.setText("Create Report");

        empNewbutton.setText("New");
        empNewbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNewbuttonActionPerformed(evt);
            }
        });

        empTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(empTable);

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(jScrollPane7)
                        .addContainerGap())
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel9Layout.createSequentialGroup()
                                .add(jLabel12)
                                .add(111, 111, 111))
                            .add(jPanel9Layout.createSequentialGroup()
                                .add(jLabel14)
                                .add(31, 31, 31)))
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(IncomeSDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .add(reportMemSDate))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel9Layout.createSequentialGroup()
                                .add(jLabel13)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(IncomeEDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                            .add(jPanel9Layout.createSequentialGroup()
                                .add(jLabel15)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(reportMemEDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 85, Short.MAX_VALUE)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(incomeReport, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .add(MemJoinedReport, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(64, 64, 64))
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(empNewbutton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(IncomeSDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel13)
                    .add(IncomeEDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(incomeReport))
                .add(18, 18, 18)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(reportMemSDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel15)
                        .add(reportMemEDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(MemJoinedReport))
                    .add(jLabel14))
                .add(25, 25, 25)
                .add(empNewbutton)
                .add(18, 18, 18)
                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        memTab.addTab("Manager", jPanel9);

        clientInfoLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        clientInfoLabel.setText("                    R.E.P.S"); // NOI18N

        clientInfoLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        clientInfoLabel1.setText("(Record Entry Processing System)"); // NOI18N

        QuitButton.setText("Quit");
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(clientInfoLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(350, 350, 350)
                        .add(QuitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(clientInfoLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 761, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(clientInfoLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(QuitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(clientInfoLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(memTab))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(memTab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_QuitButtonActionPerformed

    private void jScrollPane4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane4MousePressed

    private void IncomeEDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncomeEDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IncomeEDateActionPerformed

    private void memNewbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memNewbuttonActionPerformed
        // TODO add your handling code here:
        Members member = new Members(new javax.swing.JFrame(), true);
        member.setVisible(true);
        
    }//GEN-LAST:event_memNewbuttonActionPerformed

    private void empNewbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empNewbuttonActionPerformed
        // TODO add your handling code here:
        Employees emp = new Employees(new javax.swing.JFrame(), true);
        emp.setVisible(true);
    }//GEN-LAST:event_empNewbuttonActionPerformed

    private void memTrainingProgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memTrainingProgActionPerformed
        // TODO add your handling code here

        Training training = new Training(new javax.swing.JFrame(), true);
        training.setVisible(true);
    }//GEN-LAST:event_memTrainingProgActionPerformed

    private void MemSearchTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemSearchTPActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MemSearchTPActionPerformed

    private void MemTableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_MemTableComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_MemTableComponentAdded

    private void memUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memUpdateButtonActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_memUpdateButtonActionPerformed

    private void MemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemTableMouseClicked
        // TODO add your handling code here:
        //MemTable.getSelectedRow();
        
        int row = MemTable.rowAtPoint(evt.getPoint());
        int col = 0;
        int memid = Integer.parseInt( MemTable.getValueAt(row, col).toString());
    }//GEN-LAST:event_MemTableMouseClicked

    private void empTrainerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTrainerTableMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_empTrainerTableMouseClicked

    private void memTrainingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memTrainingTableMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_memTrainingTableMouseClicked
    
    /**
     //* @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
    public static void main(String argv[]) throws IOException {
       try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      //String user = "cs342", passwd = "c3m4p2s";
     /* //user = ScreenIO.promptForString(  "        Oracle user name: ");
      //passwd = ScreenIO.promptForString("    Oracle user password: ");
      DataLoader ldr = new DataLoader(user, passwd); // get connected, and create stmt.
      ldr.colSepChars = ScreenIO.promptForString("   Colum Separating char: ");

      boolean    succ;
      String  line = null, fileName = null;
      String  upperCaseLine = null;
      fileName = ScreenIO.promptForString("Enter the data file name: ");
      BufferedReader spFile = new BufferedReader(new FileReader(fileName));
      while ( (line = spFile.readLine()) != null ) {
	 if ( line.trim().equals("") ) continue;      // skip blank line.
	 upperCaseLine = line.trim().toUpperCase();
         if ( upperCaseLine.indexOf("TABLENAME") == 0 || 
	      upperCaseLine.indexOf("TABLE NAME") == 0 ) {
		ldr.printInsertionInfo();
            	ldr.buildPreparedStatement(line);
	    	ldr.insertSucc = 0;
	    	ldr.insertFail = 0;
	 }
         else {
		succ = ldr.addRecordToCurrentTable(ldr.lineNo, line);
		if ( succ ) ldr.insertSucc ++;
		else ldr.insertFail ++;
              }
	ldr.lineNo ++;
      }
      ldr.printInsertionInfo();
      ldr.quit();
   */

        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame frame = new javax.swing.JFrame("Client Editor");
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Gym());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IncomeEDate;
    private javax.swing.JTextField IncomeSDate;
    private javax.swing.JLabel MemFirstLabel2;
    private javax.swing.JButton MemJoinedReport;
    private javax.swing.JTextField MemSearchTP;
    private javax.swing.JTextField MemSearchTP1;
    //private javax.swing.JTable MemTable;
   // private javax.swing.JTable MemTable2;
    private javax.swing.JButton QuitButton;
    //private javax.swing.JTable TPTable;
    private java.util.List<clienteditor.B_Members> bMembersList;
    private javax.persistence.Query bMembersQuery;
    private java.util.List<clienteditor.B_Employee> b_EmployeeList;
    private javax.persistence.Query b_EmployeeQuery;
    private java.util.List<clienteditor.B_Members> b_MembersList;
    private java.util.List<clienteditor.B_Members> b_MembersList1;
    private java.util.List<clienteditor.B_Members> b_MembersList2;
    private javax.persistence.Query b_MembersQuery;
    private javax.persistence.Query b_MembersQuery1;
    private javax.persistence.Query b_MembersQuery2;
    private javax.swing.JLabel clientInfoLabel;
    private javax.swing.JLabel clientInfoLabel1;
    private javax.swing.JButton empNewbutton;
   // private javax.swing.JTable empTable;
   // private javax.swing.JTable empTrainerTable;
    private javax.persistence.EntityManager entityManager0;
    private javax.swing.JTextField equCost;
    private javax.swing.JButton equDelete;
    private javax.swing.JTextField equManu;
    private javax.swing.JTextField equName;
    private javax.swing.JButton equNew;
    private javax.swing.JTextField equRepair;
    private javax.swing.JButton equSave;
    private javax.swing.JButton equSearch;
    private javax.swing.JButton incomeReport;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton memDeleteButton;
    private javax.swing.JLabel memDoblabel2;
    private javax.swing.JLabel memLastLabel2;
    private javax.swing.JButton memNewbutton;
    private javax.swing.JButton memSearchButton;
    private javax.swing.JLabel memSexLabel2;
    private javax.swing.JTabbedPane memTab;
    private javax.swing.JButton memTrainingProg;
   // private javax.swing.JTable memTrainingTable;
    private javax.swing.JButton memUpdateButton;
    private javax.swing.JTextField reportMemEDate;
    private javax.swing.JTextField reportMemSDate;
    private javax.swing.ButtonGroup sexButtonGroup;
    private javax.swing.JLabel validationMsgLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    static public javax.swing.JTable empTrainerTable;
    static public javax.swing.JTable MemTable2;
    static public javax.swing.JTable memTrainingTable;
    static public javax.swing.JTable MemTable;
    static public javax.swing.JTable TPTable;
    static public javax.swing.JTable empTable;

}

