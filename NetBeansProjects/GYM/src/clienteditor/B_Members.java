/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonny
 */
@Entity
@Table(name = "B_MEMBERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "B_Members.findAll", query = "SELECT b FROM B_Members b"),
    @NamedQuery(name = "B_Members.findByMemid", query = "SELECT b FROM B_Members b WHERE b.memid = :memid"),
    @NamedQuery(name = "B_Members.findByFname", query = "SELECT b FROM B_Members b WHERE b.fname = :fname"),
    @NamedQuery(name = "B_Members.findByLname", query = "SELECT b FROM B_Members b WHERE b.lname = :lname"),
    @NamedQuery(name = "B_Members.findByDob", query = "SELECT b FROM B_Members b WHERE b.dob = :dob"),
    @NamedQuery(name = "B_Members.findBySex", query = "SELECT b FROM B_Members b WHERE b.sex = :sex"),
    @NamedQuery(name = "B_Members.findByAddress", query = "SELECT b FROM B_Members b WHERE b.address = :address"),
    @NamedQuery(name = "B_Members.findByCity", query = "SELECT b FROM B_Members b WHERE b.city = :city"),
    @NamedQuery(name = "B_Members.findByState", query = "SELECT b FROM B_Members b WHERE b.state = :state"),
    @NamedQuery(name = "B_Members.findByZip", query = "SELECT b FROM B_Members b WHERE b.zip = :zip"),
    @NamedQuery(name = "B_Members.findByPhone", query = "SELECT b FROM B_Members b WHERE b.phone = :phone"),
    @NamedQuery(name = "B_Members.findByEmail", query = "SELECT b FROM B_Members b WHERE b.email = :email"),
    @NamedQuery(name = "B_Members.findBySdate", query = "SELECT b FROM B_Members b WHERE b.sdate = :sdate"),
    @NamedQuery(name = "B_Members.findByEdate", query = "SELECT b FROM B_Members b WHERE b.edate = :edate")})
public class B_Members implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MEMID", nullable = false)
    private Integer memid;
    @Basic(optional = false)
    @Column(name = "FNAME", nullable = false, length = 20)
    private String fname;
    @Basic(optional = false)
    @Column(name = "LNAME", nullable = false, length = 20)
    private String lname;
    @Basic(optional = false)
    @Column(name = "DOB", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "SEX", nullable = false)
    private Character sex;
    @Basic(optional = false)
    @Column(name = "ADDRESS", nullable = false, length = 40)
    private String address;
    @Basic(optional = false)
    @Column(name = "CITY", nullable = false, length = 20)
    private String city;
    @Basic(optional = false)
    @Column(name = "STATE", nullable = false, length = 20)
    private String state;
    @Basic(optional = false)
    @Column(name = "ZIP", nullable = false)
    private int zip;
    @Basic(optional = false)
    @Column(name = "PHONE", nullable = false)
    private long phone;
    @Column(name = "EMAIL", length = 40)
    private String email;
    @Basic(optional = false)
    @Column(name = "SDATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sdate;
    @Column(name = "EDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edate;

    public B_Members() {
    }

    public B_Members(Integer memid) {
        this.memid = memid;
    }

    public B_Members(Integer memid, String fname, String lname, Date dob, Character sex, String address, String city, String state, int zip, long phone, Date sdate) {
        this.memid = memid;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.sdate = sdate;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        Integer oldMemid = this.memid;
        this.memid = memid;
        changeSupport.firePropertyChange("memid", oldMemid, memid);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        String oldFname = this.fname;
        this.fname = fname;
        changeSupport.firePropertyChange("fname", oldFname, fname);
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        String oldLname = this.lname;
        this.lname = lname;
        changeSupport.firePropertyChange("lname", oldLname, lname);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        Date oldDob = this.dob;
        this.dob = dob;
        changeSupport.firePropertyChange("dob", oldDob, dob);
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        Character oldSex = this.sex;
        this.sex = sex;
        changeSupport.firePropertyChange("sex", oldSex, sex);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
        changeSupport.firePropertyChange("state", oldState, state);
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        int oldZip = this.zip;
        this.zip = zip;
        changeSupport.firePropertyChange("zip", oldZip, zip);
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        long oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        Date oldSdate = this.sdate;
        this.sdate = sdate;
        changeSupport.firePropertyChange("sdate", oldSdate, sdate);
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        Date oldEdate = this.edate;
        this.edate = edate;
        changeSupport.firePropertyChange("edate", oldEdate, edate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memid != null ? memid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof B_Members)) {
            return false;
        }
        B_Members other = (B_Members) object;
        if ((this.memid == null && other.memid != null) || (this.memid != null && !this.memid.equals(other.memid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clienteditor.B_Members[ memid=" + memid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
