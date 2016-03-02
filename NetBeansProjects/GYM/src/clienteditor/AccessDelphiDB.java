/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;
import java.sql.*;
import java.io.*;

/**
 *
 * @author jonny
 */
public class AccessDelphiDB {
    Connection cnn;
    Statement stmt;
    ResultSet res;
    
    String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
    static String user = "winter342", passwd = "c3m4p2s";
    public AccessDelphiDB(String usr, String pwd) {
      try {
            user = usr; passwd = pwd;
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
            stmt = cnn.createStatement();
      } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
   }
    
   public static void main(String argv[]) {
       String sql;
       
       AccessDelphiDB ex3 = new AccessDelphiDB( user, passwd);
       
   }
   void executeSQL(String sql) {
       
   }
   
   protected void finalize() {
       
   }

}
