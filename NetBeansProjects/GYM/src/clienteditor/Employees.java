
    /**

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     *

    // Variables declaration - do not modify                     
    // End of variables declaration                   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;

import javax.swing.JOptionPane;
import java.sql.*;
import static clienteditor.AccessDelphiDB.*;

/**
 *
 * @author jonny
 */
public class Employees extends javax.swing.JDialog {

    private Client client = Client.createClient();

    /**
     * Creates new form Employees
     */
    public Employees(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        NewTrainerProgram = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        usernameLabel = new javax.swing.JLabel();
        clientInfoLabel = new javax.swing.JLabel();
        clientInfoPane = new javax.swing.JTabbedPane();
        personalPanel = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        sexLabel = new javax.swing.JLabel();
        maritalStatusLabel = new javax.swing.JLabel();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        ageLabel = new javax.swing.JLabel();
        sexLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        DateOfBirth = new javax.swing.JTextField();
        StreetAddr = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        State = new javax.swing.JTextField();
        Zip = new javax.swing.JTextField();
        PhoneNumber = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        StartDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        EndDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        EmpType = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Hourly = new javax.swing.JTextField();

        NewTrainerProgram.setText("New Trainer Program");
        NewTrainerProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewTrainerProgramActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        usernameLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        clientInfoLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        clientInfoLabel.setText("Employees:"); // NOI18N

        clientInfoPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        personalPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        firstNameLabel.setText("First Name:"); // NOI18N

        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });

        surnameLabel.setText("Last Name:"); // NOI18N

        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });

        sexLabel.setText("Sex:"); // NOI18N

        maritalStatusLabel.setText("Date Of Birth:"); // NOI18N

        maleRadioButton.setText("male"); // NOI18N
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        femaleRadioButton.setText("female"); // NOI18N
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        ageLabel.setText("Street Addr:"); // NOI18N

        sexLabel1.setText("City:"); // NOI18N

        jLabel1.setText("State:");

        jLabel2.setText("Zip:");

        jLabel3.setText("Phone Num:");

        jLabel4.setText("Email:");

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        DateOfBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateOfBirthActionPerformed(evt);
            }
        });

        StreetAddr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StreetAddrActionPerformed(evt);
            }
        });

        City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityActionPerformed(evt);
            }
        });

        State.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StateActionPerformed(evt);
            }
        });

        Zip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipActionPerformed(evt);
            }
        });

        PhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneNumberActionPerformed(evt);
            }
        });

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        jLabel5.setText("Start Date:");

        StartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartDateActionPerformed(evt);
            }
        });

        jLabel6.setText("End Date:");

        EndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndDateActionPerformed(evt);
            }
        });

        jLabel7.setText("Type:");

        EmpType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpTypeActionPerformed(evt);
            }
        });

        jLabel8.setText("Hourly Pay:");

        Hourly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HourlyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout personalPanelLayout = new javax.swing.GroupLayout(personalPanel);
        personalPanel.setLayout(personalPanelLayout);
        personalPanelLayout.setHorizontalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel)
                                    .addComponent(surnameLabel)
                                    .addComponent(maritalStatusLabel)
                                    .addComponent(sexLabel)
                                    .addComponent(ageLabel)
                                    .addComponent(sexLabel1)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(6, 6, 6)
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(State, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(firstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                    .addComponent(LastName)
                                    .addComponent(StreetAddr)
                                    .addComponent(City)
                                    .addGroup(personalPanelLayout.createSequentialGroup()
                                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(personalPanelLayout.createSequentialGroup()
                                                .addComponent(maleRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(femaleRadioButton))
                                            .addComponent(DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(Zip)))
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(personalPanelLayout.createSequentialGroup()
                                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(StartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                            .addComponent(EmpType))
                                        .addGap(18, 18, 18)
                                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(personalPanelLayout.createSequentialGroup()
                                                .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(Hourly)))
                                    .addComponent(Email, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(PhoneNumber))))))
                .addContainerGap())
        );
        personalPanelLayout.setVerticalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel)
                    .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maritalStatusLabel)
                    .addComponent(DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexLabel)
                    .addComponent(maleRadioButton)
                    .addComponent(femaleRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(StreetAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexLabel1)
                    .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(State, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Zip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(EmpType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(Hourly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CancelButton))
                .addGap(24, 24, 24))
        );

        clientInfoPane.addTab("Personal Info", personalPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(clientInfoPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientInfoPane, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewTrainerProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewTrainerProgramActionPerformed
        // TODO add your handling code here:
        /*
        try to figure out how to open up a new window that allows for the
        new trainer program to be accepted.

        **if possible**
        if the member doesnt have a training program dont put a
        trainer program tab and then once a member has added a trainer
        program add the trainer program tab.
        ***************

        */
    }//GEN-LAST:event_NewTrainerProgramActionPerformed

    private void HourlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HourlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HourlyActionPerformed

    private void EmpTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpTypeActionPerformed

    private void EndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EndDateActionPerformed

    private void StartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartDateActionPerformed
        // TODO add your handling code here:
        /*
        ***********possible way to accept date***********
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        String day = dayFormat.format(Date.parse(payback.creationDate.date));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        String month = monthFormat.format(Date.parse(payback.creationDate.date));

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String year = yearFormat.format(Date.parse(payback.creationDate.date));
        *************************************************
        */
    }//GEN-LAST:event_StartDateActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
        /*
        accept as a string for the email attribute for members
        */
        String email = Email.getText();
        client.setEmail(email);
    }//GEN-LAST:event_EmailActionPerformed

    private void PhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNumberActionPerformed
        // TODO add your handling code here:
        /*
        probably accept this as a string since no arithmetic will be used
        into the phone number attribute for members
        */
        int phone = Integer.parseInt(PhoneNumber.getText());
        client.setPhone(phone);
    }//GEN-LAST:event_PhoneNumberActionPerformed

    private void ZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipActionPerformed
        // TODO add your handling code here:
        /*
        accept an integer for the zip attribute
        */
        int zip = Integer.parseInt(Zip.getText());
        client.setZip(zip);
        JOptionPane.showMessageDialog(null,"Your Zip is: " + zip);
    }//GEN-LAST:event_ZipActionPerformed

    private void StateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateActionPerformed
        // TODO add your handling code here:
        /*
        Accept a string for the state attribute
        */
        String state = State.getText();
        client.setState(state);
    }//GEN-LAST:event_StateActionPerformed

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
        // TODO add your handling code here:
        //************************************
        /*
        Accept a string for the city attribute
        */
        String city = City.getText();
        client.setCity(city);
    }//GEN-LAST:event_CityActionPerformed

    private void StreetAddrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StreetAddrActionPerformed
        // TODO add your handling code here:
        //************************************
        /*
        probably best to accept a this as a string since int and chars
        are used.
        */
        //************************************
        String street = StreetAddr.getText();
        client.setStreet(street);
    }//GEN-LAST:event_StreetAddrActionPerformed

    private void DateOfBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateOfBirthActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_DateOfBirthActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        /*
        cancels the new member and closes out the window without saving
        anything
        possible trouble:
        -when cancel is pressed and there are fields that arent empty
        are we going to have to set everything to NULL or will it
        just not save it.
        */
        dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        /*
        saves all of the fields into the database
        and closes the window
        */
        Connection cnn;
        String fname = firstName.getText();
        String lname = LastName.getText();
        String dob = DateOfBirth.getText();
        String street = StreetAddr.getText();
        String city = City.getText();
        String state = State.getText();
        int zip = Integer.parseInt(Zip.getText());
        String phone = (PhoneNumber.getText());
        String email = Email.getText();
        String etype = EmpType.getText();
        float hrly = Float.parseFloat(Hourly.getText());
        char sex = client.getSex();
        String sdate = StartDate.getText();
        try {
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            //user = usr; passwd = pwd;
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = cnn.createStatement();
            int ssn = 111111111;
            int id = 0;
            ResultSet rs = stmt.executeQuery("Select m.empid from B_employee m");
            while(rs.next()) {
                id = rs.getInt("empId");
            }
            id++;
            db.executeSQL("INSERT into B_Employee values("+id+",'"+fname+"','"+lname+"','"+etype+"',"
                    + "to_date('"+dob+"', 'mm/dd/yyyy'),'"+sex+"','"+street+"','"+city+"','"+state+"',"
                    +zip+","+phone+","+ssn+","+hrly+",to_date('"+sdate+"', 'mm/dd/yyyy'), null)");
            Gym.updateEmployeeTable();
            Gym.updateEmpTrainerTable();
            cnn.close();
      } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
        dispose();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        // TODO add your handling code here:
        //************************************
        //If(this button is marked)
        //{
            //    set the sex to female
            //}
        //************************************
        char fsex = 'F';
        client.setSex(fsex);
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        // TODO add your handling code here:
        //************************************
        //If(this button is marked)
        //{
            //    set the sex to male
            //}
        //************************************
        char msex = 'M';
        client.setSex(msex);
    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
        //************************************
        //accept a string into the attribute Last name for a member
        //************************************
        //if(not a string)
        //  dont let the user save and mark this field for user to change
        String lname = LastName.getText();
        client.setLastName(lname);
    }//GEN-LAST:event_LastNameActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
        //************************************
        //accept a string into the attribute First name for a member
        //************************************
        //if(not a string)
        //  dont let the user save and mark this field for user to change
        String fname = firstName.getText();
        client.setFirstName(fname);

        if (firstName.getText() == null) {
            JOptionPane.showMessageDialog(null, "Please enter a First Name");
        }
    }//GEN-LAST:event_firstNameActionPerformed

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
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Employees dialog = new Employees(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField City;
    private javax.swing.JTextField DateOfBirth;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField EmpType;
    private javax.swing.JTextField EndDate;
    private javax.swing.JTextField Hourly;
    private javax.swing.JTextField LastName;
    private javax.swing.JButton NewTrainerProgram;
    private javax.swing.JTextField PhoneNumber;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField StartDate;
    private javax.swing.JTextField State;
    private javax.swing.JTextField StreetAddr;
    private javax.swing.JTextField Zip;
    private javax.swing.JLabel ageLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel clientInfoLabel;
    private javax.swing.JTabbedPane clientInfoPane;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JLabel maritalStatusLabel;
    private javax.swing.JPanel personalPanel;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JLabel sexLabel1;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}

