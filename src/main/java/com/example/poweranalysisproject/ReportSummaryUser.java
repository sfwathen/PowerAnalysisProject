package com.example.poweranalysisproject;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ReportSummaryUser {
    private SimpleStringProperty userName;
    private SimpleDoubleProperty highMem;
    private SimpleDoubleProperty avgMem;
    private SimpleDoubleProperty highCpu;
    private SimpleDoubleProperty avgCpu;
    private SimpleDoubleProperty highDisk;
    private SimpleDoubleProperty avgDisk;
    private SimpleStringProperty userFlagged;



    public ReportSummaryUser(SimpleStringProperty userName, SimpleDoubleProperty highMem, SimpleDoubleProperty avgMem, SimpleDoubleProperty highCpu, SimpleDoubleProperty avgCpu, SimpleDoubleProperty highDisk, SimpleDoubleProperty avgDisk, SimpleStringProperty userFlagged) {
        this.userName = userName;
        this.highMem = highMem;
        this.avgMem = avgMem;
        this.highCpu = highCpu;
        this.avgCpu = avgCpu;
        this.highDisk = highDisk;
        this.avgDisk = avgDisk;
        this.userFlagged = userFlagged;
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public double getHighMem() {
        return highMem.get();
    }

    public SimpleDoubleProperty highMemProperty() {
        return highMem;
    }

    public void setHighMem(double highMem) {
        this.highMem.set(highMem);
    }

    public double getAvgMem() {
        return avgMem.get();
    }

    public SimpleDoubleProperty avgMemProperty() {
        return avgMem;
    }

    public void setAvgMem(double avgMem) {
        this.avgMem.set(avgMem);
    }

    public double getHighCpu() {
        return highCpu.get();
    }

    public SimpleDoubleProperty highCpuProperty() {
        return highCpu;
    }

    public void setHighCpu(double highCpu) {
        this.highCpu.set(highCpu);
    }

    public double getAvgCpu() {
        return avgCpu.get();
    }

    public SimpleDoubleProperty avgCpuProperty() {
        return avgCpu;
    }

    public void setAvgCpu(double avgCpu) {
        this.avgCpu.set(avgCpu);
    }

    public double getHighDisk() {
        return highDisk.get();
    }

    public SimpleDoubleProperty highDiskProperty() {
        return highDisk;
    }

    public void setHighDisk(double highDisk) {
        this.highDisk.set(highDisk);
    }

    public double getAvgDisk() {
        return avgDisk.get();
    }

    public SimpleDoubleProperty avgDiskProperty() {
        return avgDisk;
    }

    public void setAvgDisk(double avgDisk) {
        this.avgDisk.set(avgDisk);
    }

    public String getUserFlagged() {
        return userFlagged.get();
    }

    public SimpleStringProperty userFlaggedProperty() {
        return userFlagged;
    }

    public void setUserFlagged(String userFlagged) {
        this.userFlagged.set(userFlagged);
    }
}

