/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;
import static clienteditor.AccessDelphiDB.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import java.awt.BorderLayout;
/**
 *
 * @author jonny
 */

public class MemberTable {
    
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        String s;
        try { 
            
            AccessDelphiDB db = new AccessDelphiDB(user,passwd);
            String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
            String user = "winter342", passwd = "c3m4p2s";
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = cnn.createStatement();
            s = "select * from B_Members";
            rs = st.executeQuery(s);
            ResultSetMetaData rsmt = rs.getMetaData();
            int c = rsmt.getColumnCount();
            Vector column = new Vector(c);
            for (int i=1; i<=c; i++) {
                column.add(rsmt.getColumnName(i));
            }
            Vector data = new Vector();
            Vector row = new Vector();
            while (rs.next())
            {
                row = new Vector(c);
                for (int i=1; i<=c; i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            JFrame frame = new JFrame();
            frame.setSize(500,120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
            JTable table = new JTable(data,column);
            JScrollPane jsp = new JScrollPane(table);
            panel.setLayout(new BorderLayout());
            panel.add(jsp,BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.setVisible(true);
            
        } catch (Exception e ) { e.printStackTrace(); System.exit(-1); }
        finally {
            try{
                st.close();
                rs.close();
                cnn.close();
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Error close");
            }
            }
         
        }
    }

