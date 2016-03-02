/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;
import javax.swing.JOptionPane;

/**
 *
 * @author jonny
 */
public class Members extends javax.swing.JDialog {
    private Client client = Client.createClient();
    /**
     * Creates new form Member
     */
    public Members(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private void initComponents() {

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
        contactPanel = new javax.swing.JPanel();
        nicknameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        webLabel = new javax.swing.JLabel();
        imLabel = new javax.swing.JLabel();
        CardNumber = new javax.swing.JTextField();
        NameOnCard = new javax.swing.JTextField();
        DateOfPayment = new javax.swing.JTextField();
        TotalPayment = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        usernameLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        clientInfoLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        clientInfoLabel.setText("Member:"); // NOI18N

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

        javax.swing.GroupLayout personalPanelLayout = new javax.swing.GroupLayout(personalPanel);
        personalPanel.setLayout(personalPanelLayout);
        personalPanelLayout.setHorizontalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel)
                            .addComponent(surnameLabel)
                            .addComponent(maritalStatusLabel)
                            .addComponent(sexLabel)
                            .addComponent(ageLabel)
                            .addComponent(sexLabel1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(6, 6, 6)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LastName)
                            .addComponent(StreetAddr)
                            .addComponent(City)
                            .addComponent(State)
                            .addComponent(Zip)
                            .addComponent(PhoneNumber)
                            .addComponent(Email)
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(personalPanelLayout.createSequentialGroup()
                                        .addComponent(maleRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(femaleRadioButton))
                                    .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 122, Short.MAX_VALUE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CancelButton))
                .addGap(24, 24, 24))
        );

        clientInfoPane.addTab("Personal Info", personalPanel);

        contactPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nicknameLabel.setText("Card Number:"); // NOI18N

        emailLabel.setText("Name on Card:"); // NOI18N

        webLabel.setText("Date of Payment:"); // NOI18N

        imLabel.setText("Total Payment:"); // NOI18N

        CardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardNumberActionPerformed(evt);
            }
        });

        NameOnCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameOnCardActionPerformed(evt);
            }
        });

        DateOfPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateOfPaymentActionPerformed(evt);
            }
        });

        TotalPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contactPanelLayout = new javax.swing.GroupLayout(contactPanel);
        contactPanel.setLayout(contactPanelLayout);
        contactPanelLayout.setHorizontalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nicknameLabel)
                    .addComponent(emailLabel)
                    .addComponent(webLabel)
                    .addComponent(imLabel))
                .addGap(24, 24, 24)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CardNumber)
                    .addComponent(NameOnCard, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(DateOfPayment)
                    .addComponent(TotalPayment))
                .addContainerGap())
        );
        contactPanelLayout.setVerticalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicknameLabel)
                    .addComponent(CardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(NameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(webLabel)
                    .addComponent(DateOfPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imLabel)
                    .addComponent(TotalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        clientInfoPane.addTab("Payment Info", contactPanel);

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
                .addGap(18, 18, 18)
                .addComponent(clientInfoPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
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

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        // TODO add your handling code here:
        //************************************
        //If(this button is marked)
        //{
            //    set the sex to male
            //}
        //************************************
        client.setSex(1);

    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        // TODO add your handling code here:
        //************************************
        //If(this button is marked)
        //{
            //    set the sex to female
            //}
        //************************************
        client.setSex(0);
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        /*
        saves all of the fields into the database
        and closes the window
        */
        /** First Name **/
        String fname = firstName.getText();
        client.setFirstName(fname);
        if (client.getFirstName() == null) {
            JOptionPane.showMessageDialog(null, "Please enter a First Name");
        }
        /** Last Name **/
        String lname = LastName.getText();
        client.setLastName(lname);
        if (LastName.getText() == null) {
            JOptionPane.showMessageDialog(null, "Please enter a Last Name");
        }

        String street = StreetAddr.getText();
        client.setStreet(street);
        if (client.getStreet() == null) {
            // JOptionPane.showMessageDialog(null, "Please enter a Street Addr");
        }
        String city = City.getText();
        client.setCity(city);
        if (client.getCity() == null) {
            //JOptionPane.showMessageDialog(null, "Please enter a City");
        }
        String state = State.getText();
        client.setState(state);
        if (client.getLastName() == null) {
            // JOptionPane.showMessageDialog(null, "Please enter a State");
        }
        if (Zip.getText() != null) {
            int zip = Integer.parseInt(Zip.getText());
            client.setZip(zip);
        }
        if (client.getLastName() == null) {
            //OptionPane.showMessageDialog(null, "Please enter a Zip");
        }
        String phone = PhoneNumber.getText();
        client.setPhone(phone);
        if (client.getPhone() == null) {
            //JOptionPane.showMessageDialog(null, "Please enter a Phone Number");
        }
        String email = Email.getText();
        client.setEmail(email);
        if (client.getEmail() == null) {
            //JOptionPane.showMessageDialog(null, "Please enter an Email");
        }
        if (client.getLastName() != null && client.getFirstName() != null
            && client.getStreet() != null && client.getCity() != null
            && client.getState() != null && Zip.getText() != null
            && client.getPhone() != null && Email.getText() != null){
            JOptionPane.showMessageDialog(null,"Welcome to Fitness 21 " +fname+" "+lname);
        }
        dispose();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
       
        dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void DateOfBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateOfBirthActionPerformed
        // TODO add your handling code here:
        /*
        //************************************
        //adds the members date of birth
        //try to figure out how to accept the format mm/dd/yyyy
        //***********possible way to accept date***********
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        String day = dayFormat.format(Date.parse(payback.creationDate.date));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        String month = monthFormat.format(Date.parse(payback.creationDate.date));

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String year = yearFormat.format(Date.parse(payback.creationDate.date));
        //*************************************************
        //
        //possible formula to check age
        //int m, d , y, sum;
        //sum = m + d + y;
        //if(sum > date_required_to_go_to_gym)
        //  accept user into database
        //else
        //  give user an error("You are too young to go to the gym")
        //************************************
        */
    }//GEN-LAST:event_DateOfBirthActionPerformed

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

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
        // TODO add your handling code here:
        //************************************
        /*
        Accept a string for the city attribute
        */
        String city = City.getText();
        client.setCity(city);
    }//GEN-LAST:event_CityActionPerformed

    private void StateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateActionPerformed
        // TODO add your handling code here:
        /*
        Accept a string for the state attribute
        */
        String state = State.getText();
        client.setState(state);
    }//GEN-LAST:event_StateActionPerformed

    private void ZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipActionPerformed
        // TODO add your handling code here:
        /*
        accept an integer for the zip attribute
        */
        int zip = Integer.parseInt(Zip.getText());
        client.setZip(zip);
        JOptionPane.showMessageDialog(null,"Your Zip is: " + zip);
    }//GEN-LAST:event_ZipActionPerformed

    private void PhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNumberActionPerformed
        // TODO add your handling code here:
        /*
        probably accept this as a string since no arithmetic will be used
        into the phone number attribute for members
        */
        String phone = PhoneNumber.getText();
        client.setPhone(phone);
    }//GEN-LAST:event_PhoneNumberActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
        /*
        accept as a string for the email attribute for members
        */
        String email = Email.getText();
        client.setEmail(email);
    }//GEN-LAST:event_EmailActionPerformed

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

    private void CardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardNumberActionPerformed
        // TODO add your handling code here:
        /*
        accept as an integer for the card number attribute for members
        */
    }//GEN-LAST:event_CardNumberActionPerformed

    private void NameOnCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameOnCardActionPerformed
        // TODO add your handling code here:
        /*
        Accept this as a string for the name on card attribute for members
        */
    }//GEN-LAST:event_NameOnCardActionPerformed

    private void DateOfPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateOfPaymentActionPerformed
        // TODO add your handling code here:
        /*
        try to figure out how to accept the format mm/dd/yyyy

        possible formula for finding out the date

        int m, d, y, sum;
        sum = m + d + y;

        if we can get this working then we can figure out when their next
        payment is due.
        ***********possible way to accept date***********
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        String day = dayFormat.format(Date.parse(payback.creationDate.date));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        String month = monthFormat.format(Date.parse(payback.creationDate.date));

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String year = yearFormat.format(Date.parse(payback.creationDate.date));
        *************************************************
        */
    }//GEN-LAST:event_DateOfPaymentActionPerformed

    private void TotalPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalPaymentActionPerformed
        // TODO add your handling code here:
        /*
        accept an integer but make sure that when you cout theres
        a dollar sign.
        ex- cout << "$" << total;
        */
    }//GEN-LAST:event_TotalPaymentActionPerformed


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
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Members dialog = new Members(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField CardNumber;
    private javax.swing.JTextField City;
    private javax.swing.JTextField DateOfBirth;
    private javax.swing.JTextField DateOfPayment;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField LastName;
    private javax.swing.JTextField NameOnCard;
    private javax.swing.JTextField PhoneNumber;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField StartDate;
    private javax.swing.JTextField State;
    private javax.swing.JTextField StreetAddr;
    private javax.swing.JTextField TotalPayment;
    private javax.swing.JTextField Zip;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel clientInfoLabel;
    private javax.swing.JTabbedPane clientInfoPane;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel imLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JLabel maritalStatusLabel;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JPanel personalPanel;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JLabel sexLabel1;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel webLabel;
    // End of variables declaration//GEN-END:variables
}
