package com.example.poweranalysisproject;

import javafx.beans.property.SimpleStringProperty;

public class Report {
    private SimpleStringProperty reportID;
    private SimpleStringProperty reportStartDate;
    private SimpleStringProperty reportEndDate;
    private SimpleStringProperty reportSupervisor;

    public Report(String reportID, String reportStartDate, String reportEndDate, String reportSupervisor) {
        this.reportID = new SimpleStringProperty(reportID);
        this.reportStartDate = new SimpleStringProperty(reportStartDate);
        this.reportEndDate = new SimpleStringProperty(reportEndDate);
        this.reportSupervisor = new SimpleStringProperty(reportSupervisor);
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
}
