package com.example.poweranalysisproject;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Random;

//import java.util.Random;

public class Report {

    private SimpleStringProperty reportID;
    private SimpleStringProperty reportStartDate;
    private SimpleStringProperty reportEndDate;
    private SimpleStringProperty reportSupervisor;

    private SimpleDoubleProperty memoryTreshold;
    private SimpleDoubleProperty cpuTreshold;
    private SimpleDoubleProperty diskTreshold;

    private SimpleBooleanProperty flagged;

    public Report(String reportStartDate, String reportEndDate, String reportSupervisor) {
        this.reportID = generateID();
        this.reportStartDate = new SimpleStringProperty(reportStartDate);
        this.reportEndDate = new SimpleStringProperty(reportEndDate);
        this.reportSupervisor = new SimpleStringProperty(reportSupervisor);

        // When Sam is finished with default settings, fix default tresholds
        this.memoryTreshold = new SimpleDoubleProperty(0);
        this.cpuTreshold = new SimpleDoubleProperty(0);
        this.diskTreshold = new SimpleDoubleProperty(0);
    }

    public SimpleStringProperty generateID(){
        int rnd = new Random().nextInt(999999);;
        return new SimpleStringProperty(String.format("%06d", rnd));
    }

    public String getReportID() {
        return reportID.get();
    }

    public void setReportID(String reportID) {
        this.reportID = new SimpleStringProperty(reportID);
    }

    public String getReportStartDate() {
        return reportStartDate.get();
    }

    public void setReportStartDate(String reportStartDate) {
        this.reportStartDate = new SimpleStringProperty(reportStartDate);
    }

    public String getReportEndDate() {
        return reportEndDate.get();
    }

    public void setReportEndDate(String reportEndDate) {
        this.reportEndDate = new SimpleStringProperty(reportEndDate);
    }

    public String getReportSupervisor() {
        return reportSupervisor.get();
    }

    public void setReportSupervisor(String reportSupervisor) {
        this.reportSupervisor = new SimpleStringProperty(reportSupervisor);
    }

    public double getMemoryTreshold() {
        return memoryTreshold.get();
    }

    public SimpleDoubleProperty memoryTresholdProperty() {
        return memoryTreshold;
    }

    public void setMemoryTreshold(int memoryTreshold) {
        this.memoryTreshold.set(memoryTreshold);
    }

    public double getCpuTreshold() {
        return cpuTreshold.get();
    }

    public SimpleDoubleProperty cpuTresholdProperty() {
        return cpuTreshold;
    }

    public void setCpuTreshold(int cpuTreshold) {
        this.cpuTreshold.set(cpuTreshold);
    }

    public double getDiskTreshold() {
        return diskTreshold.get();
    }

    public SimpleDoubleProperty diskTresholdProperty() {
        return diskTreshold;
    }

    public void setDiskTreshold(int diskTreshold) {
        this.diskTreshold.set(diskTreshold);
    }

    public boolean isFlagged() {
        return flagged.get();
    }

    public SimpleBooleanProperty flaggedProperty() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged.set(flagged);
    }
}
