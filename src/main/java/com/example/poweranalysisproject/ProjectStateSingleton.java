package com.example.poweranalysisproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;

public class ProjectStateSingleton {
    private static final ProjectStateSingleton psSingleton = new ProjectStateSingleton();

    private boolean enabled = true;
    private Report currReport;
    private UserProfile currUserProfile;
    private UserProfile defaultUserProfile = new UserProfile("Davide", "building 1", "room 2", "CSC");
    private Threshold customThreshold;
    private Threshold defaultThreshold = new Threshold(75,700, 14);

    public boolean isDefaultAnalysis() {
        return defaultAnalysis;
    }

    public void setDefaultAnalysis(boolean defaultAnalysis) {
        this.defaultAnalysis = defaultAnalysis;
    }

    private boolean defaultAnalysis = false;

    private ObservableList<Report> reportsList = FXCollections.observableArrayList(
    );



    private List<ObservableList<ReportSummaryUser>> reportList = FXCollections.observableArrayList(
    );

    public ObservableList<ReportSummaryUser> getReportList() {
        return reportList.get(Integer.parseInt(currReport.getReportID()) - 1);
    }

    public void addToReportSummaryUser(ReportSummaryUser summaryUser) {
        reportList.add(FXCollections.observableArrayList(summaryUser));
    }


    public ObservableList<Report> getReportsList() {
        return reportsList;
    }

    public void addToReportsList(Report newReport) {
        reportsList.add(newReport);
    }

    private ProjectStateSingleton() {}

    public static ProjectStateSingleton getInstance() {
        return psSingleton;
    }

    public Report getCurrReport() {
        return currReport;
    }

    public void setCurrReport(Report newCurrReport) {
        currReport = newCurrReport;
    }

    public void setCurrUserProfile(UserProfile user)
    {
        currUserProfile = user;
    }

    public UserProfile getCurrUserProfile()
    {
        return currUserProfile;
    }

    public Threshold getCustomThreshold() {
        return customThreshold;
    }

    public void setCustomThreshold(Threshold customThreshold) {
        this.customThreshold = customThreshold;
    }

    public Threshold getDefaultThreshold() {
        return defaultThreshold;
    }

    public void setDefaultThreshold(Threshold defaultThreshold) {
        this.defaultThreshold = defaultThreshold;
    }

    public void setEnabled() {this.enabled = true; }

    public void setDisabled() {this.enabled = false; }

    public boolean getEnabled() {return this.enabled; }

    public UserProfile getDefaultUserProfile() {return this.defaultUserProfile;}


}
