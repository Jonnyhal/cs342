/*
 * Copyright (c) 2010, Oracle.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  * Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package clienteditor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Information about one client.
 * 
 * @author Jiri Vagner, Jan Stola
 */
public class Client {
    
    /** First name of the client. */
    private String firstName;
    /** Surname of the client. */
    private String lname;
    /** Nickname of the client. */
    private String nickname;
    /** Age of the client. */
    private int age;
    /** Sex of the client (0 - female, 1 - male). */
    private char sex;
    /** Street address of client */
    private String street;
    /** E-mail of the client. */
    private String email;
    /** City of client **/
    private String city;
    /** State of client **/
    private String state;
    /** Zip of client **/
    private int zip;  
    /** Phone number of client **/
    private int phone;
    private String date;
    private String DOB;
    /** Email for client **/
    // <editor-fold defaultstate="collapsed" desc="PropertyChange Stuff">
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Get Methods">
    public String getDOB() {
        
        return DOB;
    }
    public String getDate() {
        return date;
    }
    public int getPhone() {
        return phone;
    }
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lname;
    }

    public String getNickname() {
        return nickname;
    }
    
    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public char getSex() {
        return sex;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public int getZip() {
        return zip;
    }
    
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Set Methods">
    public void setDOB(String DOB) {
        String oldDOB = this.DOB;
        this.DOB = DOB;
        changeSupport.firePropertyChange("DOB", oldDOB, DOB);
    }
    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("Date", oldDate, date);
    }
    public void setPhone(int phone) {
        int oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("Phone number", oldPhone, phone);
    }
    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }
    
    public void setLastName(String lname) {
        String oldLastName = this.lname;
        this.lname = lname;
        changeSupport.firePropertyChange("surname", oldLastName, lname);
    }

    public void setNickname(String nickname) {
        String oldNickname = this.nickname;
        this.nickname = nickname;
        changeSupport.firePropertyChange("nickname", oldNickname, nickname);
    }

    public void setAge(int age) {
        int oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }
    public void setStreet(String street) {
        String oldStreet = this.street;
        this.street = street;
        changeSupport.firePropertyChange("street", oldStreet, street);
    }

    public void setSex(char sex) {
        char oldSex = this.sex;
        this.sex = sex;
        changeSupport.firePropertyChange("sex", oldSex, sex);
    }
    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city",oldCity, city);
    }
    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
        changeSupport.firePropertyChange("state",oldState, state);
    }
    public void setZip(int zip) {
        int oldZip = this.zip;
        this.zip = zip;
        changeSupport.firePropertyChange("zip", oldZip, zip);
    }
    

    // </editor-fold>
    
    public static Client createClient() {
        Client client = new Client();
        
        /*client.setFirstName("George");
        client.setSurname("Foo");
        client.setNickname("Juraj");
        client.setAge(30);
        
        client.setEmail("g.foo@foo.org");
        client.setWeb("https://beansbinding.dev.java.net");
        client.setIm("ICQ: 53 25 89 76");
        
        client.setSex(1);
        client.setMaritalStatus(2);
        */
        return client;
    }
}

