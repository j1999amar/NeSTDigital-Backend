package com.example.nestdigital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leavecount")
public class LeaveCountModel {
    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private String year;
    private String sickLeave;
    private String causualLeave;
    private String splLeave;

    public LeaveCountModel() {
    }

    public LeaveCountModel(int id, int empid, String year, String sickLeave, String causualLeave, String splLeave) {
        this.id = id;
        this.empid = empid;
        this.year = year;
        this.sickLeave = sickLeave;
        this.causualLeave = causualLeave;
        this.splLeave = splLeave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(String sickLeave) {
        this.sickLeave = sickLeave;
    }

    public String getCausualLeave() {
        return causualLeave;
    }

    public void setCausualLeave(String causualLeave) {
        this.causualLeave = causualLeave;
    }

    public String getSplLeave() {
        return splLeave;
    }

    public void setSplLeave(String splLeave) {
        this.splLeave = splLeave;
    }
}
