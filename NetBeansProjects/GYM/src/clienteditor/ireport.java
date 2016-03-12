/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;

/**
 *
 * @author jonny*/
import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import static clienteditor.AccessDelphiDB.*;
import java.sql.DriverManager;

 
public class ireport extends JFrame {
 
    HashMap hm = null;
    Connection con = null;
    String reportName;
 
    public ireport() {
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
    }
 
    public ireport(HashMap map) {
        this.hm = map;
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
    }
 
    public ireport(HashMap map, Connection con) {
        this.hm = map;
        this.con = con;
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Report Viewer");
 
    }
 
    public void setReportName(String rptName) {
        this.reportName = rptName;
    }
 
    public void callReport() {
        JasperPrint jasperPrint = generateReport();
        JRViewer viewer = new JRViewer(jasperPrint);
        Container c = getContentPane();
        c.add(viewer);
        this.setVisible(true);
    }
 
    public void callConnectionLessReport() {
        JasperPrint jasperPrint = generateEmptyDataSourceReport();
        JRViewer viewer = new JRViewer(jasperPrint);
        Container c = getContentPane();
        c.add(viewer);
        this.setVisible(true);
    }
 
    public void closeReport() {
        //jasperViewer.setVisible(false);
    }
 
    /** this method will call the report from data source*/
    public JasperPrint generateReport() {
        try {
            if (con == null) {
                try {
                    AccessDelphiDB db = new AccessDelphiDB(user,passwd);
           
                    String url = "jdbc:oracle:thin:@delphi.cs.csubak.edu:1521:dbs01";
                    String user = "winter342", passwd = "c3m4p2s";
                    DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
                    con = DriverManager.getConnection(url, user, passwd);
                     
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            JasperPrint jasperPrint = null;
            if (hm == null) {
                hm = new HashMap();
            }
            try {
                /**You can also test this line if you want to display 
                 * report from any absolute path other than the project root path*/
                //jasperPrint = JasperFillManager.fillReport("F:/testreport/"+reportName+".jasper",hm, con);
                jasperPrint = JasperFillManager.fillReport(reportName + ".jasper", hm, con);
            } catch (JRException e) {
                e.printStackTrace();
            }
            return jasperPrint;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
 
 
    }
 
    /** call this method when your report has an empty data source*/
    public JasperPrint generateEmptyDataSourceReport() {
        try {
            JasperPrint jasperPrint = null;
            if (hm == null) {
                hm = new HashMap();
            }
            try {
                jasperPrint = JasperFillManager.fillReport(reportName + ".jasper", hm, new JREmptyDataSource());
            } catch (JRException e) {
                e.printStackTrace();
            }
            return jasperPrint;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
 
    }
}

