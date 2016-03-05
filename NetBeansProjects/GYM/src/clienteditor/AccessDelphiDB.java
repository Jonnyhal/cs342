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
    
    static String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
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
       char c = ' ';
       String sql;
       
       AccessDelphiDB ex3 = new AccessDelphiDB( user, passwd);
       ex3.finalize();
   }
   void executeSQL(String sql) {
       try {
            if ( sql.charAt(sql.length() -1) == ';' ) sql = sql.substring(0, sql.length() -1);
          res = stmt.executeQuery(sql);
         } catch (SQLException e) { System.err.println("\nError occured in executing SQL: \n\t" + sql + "\n"); }
   }

       
   
   
   @Override
   protected void finalize() {
       try {
          if ( stmt != null ) stmt.close();
          if ( res != null ) res.close();
          if ( cnn != null ) cnn.close();
          System.out.println("Disconnected from database.");
         } catch (SQLException e) {}
      }
}
