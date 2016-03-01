/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 *
 * @author jonny
 */
public class DataLoader {
    Connection		cnn = null;
   PreparedStatement	pStmt = null;
   Statement		stmt = null;
   ResultSet		res = null ;
   ResultSetMetaData	meta = null;
   String		tableName = null,
			colSepChars;
   int			fieldCount;
   int			insertSucc = 0, insertFail = 0, lineNo = 0;;

   String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";

   public DataLoader(String user, String passwd) {
      try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
            cnn = DriverManager.getConnection(url, user, passwd);
      } catch (SQLException e ) { e.printStackTrace(); System.exit(-1); }
   }
    
   void buildPreparedStatement(String line) {
       StringTokenizer tkz = new StringTokenizer(line, colSepChars);
       /**
        *  Skip "TABLENAME", get table name and number of fields.
        *  Build INSERT statement, and prepare the insert statement.
        */
       tableName = tkz.nextToken();
       tableName = tkz.nextToken().trim();
       fieldCount = Integer.parseInt(tkz.nextToken().trim());
       StringBuffer buf = new StringBuffer();
       buf.append("INSERT INTO " + tableName + " VALUES(?");
       for ( int i = 1; i < fieldCount; i++ ) buf.append(", ?");
       buf.append(")");
       try {
		// if ( pStmt != null ) pStmt.close();
       		pStmt = cnn.prepareStatement(buf.toString());
		// The Java document says that it is positive to access
		// ResultSetMeta data before the statement is executed. However,
		// Oracle 8.05 has not implemented that. The statement doesn't
		// work.  meta = pStmt.getMetaData(); 
		
       		System.out.println("SQL statement: " + buf.toString());
		//
	        // In order to know the types of columns, execute SELECT
		// statement. It is inefficient.
		if ( stmt == null ) stmt = cnn.createStatement();
       		res  = stmt.executeQuery("select * from " + tableName);
		meta = res.getMetaData();
		res.close();
       } catch ( SQLException e ) { e.printStackTrace(); return; }

   }
   
   boolean addRecordToCurrentTable(int lineNo, String line ) {
      SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      String [] words = line.split("\\" + colSepChars);
      String colStr = null;
      try {
	pStmt.clearParameters();
	boolean isNull ;
	// System.out.printf("Field No\tField Value From File\n");
	for ( int i = 1; i <= fieldCount; i ++ ) {
		// System.out.printf("Column is being processed: %5d\t\t |%s|\n", i, words[i-1]); 
		colStr = words[i-1];

		if ( colStr != null )  colStr = colStr.trim() ;
		
		isNull =  colStr == null || colStr.length() < 1  || colStr.toUpperCase().compareTo("NULL") == 0;
		switch( meta.getColumnType(i) ) {
		   case Types.DATE:
			if ( isNull ) pStmt.setDate(i, null); 
			else pStmt.setDate(i, java.sql.Date.valueOf(colStr));
			break;
		   case Types.TIME:
			if ( isNull ) pStmt.setTime(i, null);
			else pStmt.setTime(i, Time.valueOf( colStr));
			break;
		   case Types.TIMESTAMP: // Oracle DATE type is TIMESTAMP type.
			if ( isNull ) pStmt.setTimestamp(i, null); 
			else { ParsePosition pp = new ParsePosition(0);
			       java.util.Date dt = fmt.parse( colStr, pp );
			       Timestamp ts = new Timestamp( dt.getTime() );
			       pStmt.setTimestamp(i, ts);
			}
			break;
		   default :
			pStmt.setString(i, colStr);
			break;
		}
	}

	pStmt.execute();
	return true;
      } catch ( Exception e ) {
	     if ( insertFail < 3 )  
		System.out.printf( "\n\t%s\tOn line %d: < %s >\n" , e.getMessage(), lineNo, line.trim() ); 
	     return false;
      }
   }
   
   protected void printInsertionInfo() {
      System.out.println();
      if ( insertSucc > 0 )
	System.out.print( insertSucc + " records inserted " );
      if ( insertFail > 0 )
	System.out.print("  " + insertFail +  " records failed" );
      if ( insertSucc > 0 || insertFail > 0 ) 
	System.out.println(" in table " + tableName + "\n\n");
   }
   
   protected void quit() {
      try {
      pStmt.close();
      stmt.close();
      // res.close();
      cnn.close();
      System.exit(0);
      } catch (SQLException e) {}
      try { super.finalize(); } catch (Throwable e) {}
   }
   
}
