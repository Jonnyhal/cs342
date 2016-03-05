/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteditor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "B_EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "B_Employee.findAll", query = "SELECT b FROM B_Employee b WHERE b.etype = 'Trainer'")})
   //@NamedQuery(name = "B_Employee.findByEmpid", query = "SELECT b FROM B_Employee b WHERE b.empid = :empid"),
    //@NamedQuery(name = "B_Employee.findByEfname", query = "SELECT b FROM B_Employee b WHERE b.efname = :efname"),
   // @NamedQuery(name = "B_Employee.findByElname", query = "SELECT b FROM B_Employee b WHERE b.elname = :elname"),
   // @NamedQuery(name = "B_Employee.findByEtype", query = "SELECT b FROM B_Employee b WHERE b.etype = 'Trainer'"),
  //  @NamedQuery(name = "B_Employee.findByDob", query = "SELECT b FROM B_Employee b WHERE b.dob = :dob"),
  //  @NamedQuery(name = "B_Employee.findBySex", query = "SELECT b FROM B_Employee b WHERE b.sex = :sex"),
  //  @NamedQuery(name = "B_Employee.findByAddress", query = "SELECT b FROM B_Employee b WHERE b.address = :address"),
  //  @NamedQuery(name = "B_Employee.findByCity", query = "SELECT b FROM B_Employee b WHERE b.city = :city"),
  //  @NamedQuery(name = "B_Employee.findByState", query = "SELECT b FROM B_Employee b WHERE b.state = :state"),
  //  @NamedQuery(name = "B_Employee.findByZip", query = "SELECT b FROM B_Employee b WHERE b.zip = :zip"),
  //  @NamedQuery(name = "B_Employee.findByPhone", query = "SELECT b FROM B_Employee b WHERE b.phone = :phone"),
  //  @NamedQuery(name = "B_Employee.findBySsn", query = "SELECT b FROM B_Employee b WHERE b.ssn = :ssn"),
  ///  @NamedQuery(name = "B_Employee.findByHrlypay", query = "SELECT b FROM B_Employee b WHERE b.hrlypay = :hrlypay"),
   // @NamedQuery(name = "B_Employee.findBySdate", query = "SELECT b FROM B_Employee b WHERE b.sdate = :sdate"),
   // @NamedQuery(name = "B_Employee.findByEdate", query = "SELECT b FROM B_Employee b WHERE b.edate = :edate")})
public class B_Employee implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPID", nullable = false)
    private Integer empid;
    @Basic(optional = false)
    @Column(name = "EFNAME", nullable = false, length = 40)
    private String efname;
    @Basic(optional = false)
    @Column(name = "ELNAME", nullable = false, length = 40)
    private String elname;
    @Basic(optional = false)
    @Column(name = "ETYPE", nullable = false, length = 20)
    private String etype;
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
    @Basic(optional = false)
    @Column(name = "SSN", nullable = false)
    private int ssn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "HRLYPAY", nullable = false, precision = 10, scale = 2)
    private BigDecimal hrlypay;
    @Basic(optional = false)
    @Column(name = "SDATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sdate;
    @Column(name = "EDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edate;

    public B_Employee() {
    }

    public B_Employee(Integer empid) {
        this.empid = empid;
    }

    public B_Employee(Integer empid, String efname, String elname, String etype, Date dob, Character sex, String address, String city, String state, int zip, long phone, int ssn, BigDecimal hrlypay, Date sdate) {
        this.empid = empid;
        this.efname = efname;
        this.elname = elname;
        this.etype = etype;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.ssn = ssn;
        this.hrlypay = hrlypay;
        this.sdate = sdate;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        Integer oldEmpid = this.empid;
        this.empid = empid;
        changeSupport.firePropertyChange("empid", oldEmpid, empid);
    }

    public String getEfname() {
        return efname;
    }

    public void setEfname(String efname) {
        String oldEfname = this.efname;
        this.efname = efname;
        changeSupport.firePropertyChange("efname", oldEfname, efname);
    }

    public String getElname() {
        return elname;
    }

    public void setElname(String elname) {
        String oldElname = this.elname;
        this.elname = elname;
        changeSupport.firePropertyChange("elname", oldElname, elname);
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        
        String oldEtype = this.etype;
        this.etype = etype;
        changeSupport.firePropertyChange("etype", oldEtype, etype);
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

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        int oldSsn = this.ssn;
        this.ssn = ssn;
        changeSupport.firePropertyChange("ssn", oldSsn, ssn);
    }

    public BigDecimal getHrlypay() {
        return hrlypay;
    }

    public void setHrlypay(BigDecimal hrlypay) {
        BigDecimal oldHrlypay = this.hrlypay;
        this.hrlypay = hrlypay;
        changeSupport.firePropertyChange("hrlypay", oldHrlypay, hrlypay);
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
        hash += (empid != null ? empid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof B_Employee)) {
            return false;
        }
        B_Employee other = (B_Employee) object;
        if ((this.empid == null && other.empid != null) || (this.empid != null && !this.empid.equals(other.empid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clienteditor.B_Employee[ empid=" + empid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
