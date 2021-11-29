package com.example.poweranalysisproject;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Report {

    private SimpleStringProperty reportID;
    private SimpleStringProperty reportStartDate;
    private SimpleStringProperty reportEndDate;
    private SimpleStringProperty reportSupervisor;

    private final SimpleDoubleProperty memoryTreshold;
    private final SimpleDoubleProperty cpuTreshold;
    private final SimpleDoubleProperty diskTreshold;

    private SimpleDoubleProperty avgMem;
    private SimpleDoubleProperty avgCPU;
    private SimpleDoubleProperty avgDisk;

    private SimpleDoubleProperty highMem;
    private SimpleDoubleProperty highCPU;
    private SimpleDoubleProperty highDisk;

    private SimpleStringProperty flagged;

    private ProjectStateSingleton singleton = ProjectStateSingleton.getInstance();

    private static int id = 1;

    public Report(String reportStartDate, String reportEndDate, String reportSupervisor,
                  String userName, int avgMem, int avgCPU, int avgDisk, int highMem, int highCPU, int highDisk,
                  boolean flagged, Threshold threshold, UserProfile user) {
        this.reportID = new SimpleStringProperty(String.format("%06d", id++));
        this.reportStartDate = new SimpleStringProperty(reportStartDate);
        this.reportEndDate = new SimpleStringProperty(reportEndDate);
        this.reportSupervisor = new SimpleStringProperty(reportSupervisor);


        if (flagged)
            this.flagged = new SimpleStringProperty("True");
        else
            this.flagged = new SimpleStringProperty("False");

        this.avgMem = new SimpleDoubleProperty(avgMem);
        this.avgCPU = new SimpleDoubleProperty(avgCPU);
        this.avgDisk = new SimpleDoubleProperty(avgDisk);

        this.highMem = new SimpleDoubleProperty(highMem);
        this.highCPU = new SimpleDoubleProperty(highCPU);
        this.highDisk = new SimpleDoubleProperty(highDisk);

        this.memoryTreshold = new SimpleDoubleProperty(threshold.getMemThreshold());
        this.cpuTreshold = new SimpleDoubleProperty(threshold.getCpuThreshold());
        this.diskTreshold = new SimpleDoubleProperty(threshold.getDiskThreshold());

        ReportSummaryUser userProfile = new ReportSummaryUser(new SimpleStringProperty(user.getName())
                ,this.highCPU, this.avgCPU, this.highMem, this.avgMem, this.highDisk, this.avgDisk, this.flagged);
        singleton.addToReportSummaryUser(userProfile);
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

    public String isFlagged() {
        return flagged.get();
    }

    public SimpleStringProperty flaggedProperty() {
        return flagged;
    }

    public void setFlagged(String flagged) {
        this.flagged.set(flagged);
    }
}
