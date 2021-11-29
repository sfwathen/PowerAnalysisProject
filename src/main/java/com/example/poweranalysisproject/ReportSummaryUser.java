package com.example.poweranalysisproject;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ReportSummaryUser {
    private SimpleStringProperty userName;
    private UsageMetrics metrics;
    private SimpleStringProperty userFlagged;



    public ReportSummaryUser(SimpleStringProperty userName, UsageMetrics metrics, SimpleStringProperty userFlagged) {
        this.userName = userName;
        this.metrics = metrics;
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
        return this.metrics.getHighMem();
    }

    public void setHighMem(double highMem) {
        this.metrics.setHighMem(highMem);
    }

    public double getAvgMem() {
        return this.metrics.getAvgMem();
    }

    public SimpleDoubleProperty avgMemProperty() {
        return this.metrics.avgMemProperty();
    }

    public void setAvgMem(double avgMem) {
        this.metrics.setAvgMem(avgMem);
    }

    public double getHighCpu() {
        return this.metrics.getHighCpu();
    }

    public SimpleDoubleProperty highCpuProperty() {
        return this.metrics.highCpuProperty();
    }

    public void setHighCpu(double highCpu) {
        this.metrics.setHighCpu(highCpu);
    }

    public double getAvgCpu() {
        return this.metrics.getAvgCpu();
    }

    public SimpleDoubleProperty avgCpuProperty() {
        return this.metrics.avgCpuProperty();
    }

    public void setAvgCpu(double avgCpu) {
        this.metrics.setAvgCpu(avgCpu);
    }

    public double getHighDisk() {
        return this.metrics.getHighDisk();
    }

    public SimpleDoubleProperty highDiskProperty() {
        return this.metrics.highDiskProperty();
    }

    public void setHighDisk(double highDisk) {
        this.metrics.setHighDisk(highDisk);
    }

    public double getAvgDisk() {
        return this.metrics.getAvgDisk();
    }

    public SimpleDoubleProperty avgDiskProperty() {
        return this.metrics.avgDiskProperty();
    }

    public void setAvgDisk(double avgDisk) {
        this.metrics.setAvgDisk(avgDisk);
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

