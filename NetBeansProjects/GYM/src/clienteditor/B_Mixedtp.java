/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;


/**
 *
 * @author jonny
 */
@Entity
@Table(name = "B_MIXEDTP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "B_Mixedtp.findAll", query = "SELECT b FROM B_Mixedtp b"),
    @NamedQuery(name = "B_Mixedtp.findByProid", query = "SELECT b FROM B_Mixedtp b WHERE b.proid = :proid"),
    @NamedQuery(name = "B_Mixedtp.findByFname", query = "SELECT b FROM B_Mixedtp b WHERE b.fname = :fname"),
    @NamedQuery(name = "B_Mixedtp.findByEfname", query = "SELECT b FROM B_Mixedtp b WHERE b.efname = :efname"),
    @NamedQuery(name = "B_Mixedtp.findByEmpid", query = "SELECT b FROM B_Mixedtp b WHERE b.empid = :empid")})
public class B_Mixedtp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROID", nullable = false)
    private int proid;
    @Basic(optional = false)
    @Column(name = "FNAME", nullable = false, length = 20)
    private String fname;
    @Basic(optional = false)
    @Column(name = "EFNAME", nullable = false, length = 40)
    private String efname;
    @Basic(optional = false)
    @Column(name = "EMPID", nullable = false)
    private int empid;

    public B_Mixedtp() {
    }

    public int getProid() {
        return proid;
    }

    public void setProid(int proid) {
        this.proid = proid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEfname() {
        return efname;
    }

    public void setEfname(String efname) {
        this.efname = efname;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }
    
}
