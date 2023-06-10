package com.example.carbon.domain;

import java.io.Serializable;
import java.util.Date;

public class Nxyj implements Serializable {
    private int id;
    private String pointname;
    private String pointaddress;
    private float timepower;
    private float timevoltage;
    private String state;
    private Date Reportingtime;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointname() {
        return pointname;
    }

    public void setPointname(String pointname) {
        this.pointname = pointname;
    }

    public String getPointaddress() {
        return pointaddress;
    }

    public void setPointaddress(String pointaddress) {
        this.pointaddress = pointaddress;
    }

    public float getTimepower() {
        return timepower;
    }

    public void setTimepower(float timepower) {
        this.timepower = timepower;
    }

    public float getTimevoltage() {
        return timevoltage;
    }

    public void setTimevoltage(float timevoltage) {
        this.timevoltage = timevoltage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getReportingtime() {
        return Reportingtime;
    }

    public void setReportingtime(Date reportingtime) {
        Reportingtime = reportingtime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Nxyj{" +
                "id=" + id +
                ", pointname='" + pointname + '\'' +
                ", pointaddress='" + pointaddress + '\'' +
                ", timepower=" + timepower +
                ", timevoltage=" + timevoltage +
                ", state='" + state + '\'' +
                ", Reportingtime=" + Reportingtime +
                ", notes='" + notes + '\'' +
                '}';
    }
}
