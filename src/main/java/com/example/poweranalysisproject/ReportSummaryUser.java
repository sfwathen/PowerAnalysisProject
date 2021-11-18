package com.example.poweranalysisproject;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ReportSummaryUser {
    private SimpleStringProperty userName;
    private SimpleDoubleProperty userMemory;
    private SimpleDoubleProperty userCPU;
    private SimpleDoubleProperty userDisk;
    private SimpleBooleanProperty userFlagged;

    public ReportSummaryUser(String userName, double userMemory, double userCPU, double userDisk, boolean userFlagged) {
        this.userName = new SimpleStringProperty(userName);
        this.userMemory = new SimpleDoubleProperty(userMemory);
        this.userCPU = new SimpleDoubleProperty(userCPU);
        this.userDisk = new SimpleDoubleProperty(userDisk);
        this.userFlagged = new SimpleBooleanProperty(userFlagged);
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName = new SimpleStringProperty(userName);
    }

    public double getUserMemory() {
        return userMemory.get();
    }

    public void setUserMemory(double userMemory) {
        this.userMemory = new SimpleDoubleProperty(userMemory);
    }

    public double getUserCPU() {
        return userCPU.get();
    }

    public void setUserCPU(double userCPU) {
        this.userCPU = new SimpleDoubleProperty(userCPU);
    }

    public double getUserDisk() {
        return userDisk.get();
    }

    public void setUserDisk(double userDisk) {
        this.userDisk = new SimpleDoubleProperty(userDisk);
    }

    public boolean isUserFlagged() {
        return userFlagged.get();
    }

    public void setUserFlagged(boolean userFlagged) {
        this.userFlagged = new SimpleBooleanProperty(userFlagged);
    }
}
