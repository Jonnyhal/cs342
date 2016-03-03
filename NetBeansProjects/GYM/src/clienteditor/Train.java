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
public class Train {
    /**Program Name */
    private String proName;
    /**Program Focus */
    private String proFocus;
    /**MemHeight*/
    private int height;
    /**Starting Weight*/
    private int sWeight;
    /**EndWeight*/
    private int eWeight;
    /**Start BMI*/
    private int sBMI;
    /**End BMI*/
    private int eBMI;
    /** Activity Name */
    private String actName;
    /** Activity Time*/
    private int time;
    /** Activiy sets. */
    private int sets;
    /** Activity reps*/
    private int reps;
    /** Activity Starting limit*/
    private int slimit;
    /**Activity Current Limit*/
    private int climit;
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
    public String getProName() {
        return proName;
    }
    public String getProFocus() {
        return proFocus;
    }
    public int getHeight() {
        return height;
    }
    public int getSWeight() {
        return sWeight;
    }
    public int getEWeight() {
        return eWeight;
    }
    public int getSBMI() {
        return sBMI;
    }
    public int getEBMI() {
        return eBMI;
    }
    public String getActName() {
        return actName;
    }
    public int getTime() {
        return time;
    }
    public int getSets() {
        return sets;
    }
    public int getReps() {
        return reps;
    }
    public int getSLimit() {
        return slimit;
    }
    public int getCLimit() {
        return climit;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Set Methods">
    public void setProName(String proName) {
        String oldProName = this.proName;
        this.proName = proName;
        changeSupport.firePropertyChange("ProName", oldProName, proName);
    }
    public void setProFocus(String proFocus) {
        String oldProFocus = this.proFocus;
        this.proFocus = proFocus;
        changeSupport.firePropertyChange("ProFocus", oldProFocus, proFocus);
    }
    
    public void setHeight(int height) {
        int oldHeight = this.height;
        this.height = height;
        changeSupport.firePropertyChange("Height", oldHeight, height);
    }

    public void setSWeight(int sWeight) {
        int oldSWeight = this.sWeight;
        this.sWeight = sWeight;
        changeSupport.firePropertyChange("startweight", oldSWeight, sWeight);
    }

    public void setEWeight(int eWeight) {
        int oldEWeight = this.eWeight;
        this.eWeight = eWeight;
        changeSupport.firePropertyChange("endweight", oldEWeight, eWeight);
    }

    public void setSBMI(int sBMI) {
        int oldSBMI = this.sBMI;
        this.sBMI = sBMI;
        changeSupport.firePropertyChange("startBMI", oldSBMI, sBMI);
    }
    public void setEBMI(int eBMI) {
        int oldEBMI = this.eBMI;
        this.eBMI = eBMI;
        changeSupport.firePropertyChange("endBMI", oldEBMI, eBMI);
    }
    public void setActName(String actName) {
        String oldActName = this.actName;
        this.actName = actName;
        changeSupport.firePropertyChange("ActName", oldActName, actName);
    }
    public void setTime(int time) {
        int oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("Time", oldTime, time);
    }
    public void setSets(int sets) {
        int oldSets = this.sets;
        this.sets = sets;
        changeSupport.firePropertyChange("sets", oldSets, sets);
    }
    public void setReps(int reps) {
        int oldReps = this.reps;
        this.reps = reps;
        changeSupport.firePropertyChange("reps", oldReps, reps);
    }
    public void setSLimit(int slimit) {
        int oldSLimit = this.slimit;
        this.slimit = slimit;
        changeSupport.firePropertyChange("startLimit", oldSLimit, slimit);
    }
    public void setCLimit(int climit) {
        int oldCLimit = this.climit;
        this.climit = climit;
        changeSupport.firePropertyChange("currentLimit", oldCLimit, climit);

    }
   

    // </editor-fold>
    
    public static Train createTrain() {
        Train train = new Train();
        
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
        return train;
    }
}

