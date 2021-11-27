package com.example.poweranalysisproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectStateSingleton {
    private static final ProjectStateSingleton psSingleton = new ProjectStateSingleton();

    private Report currReport;
    private UserProfile currUserProfile;
    private Threshold customThreshold;
    private Threshold defaultThreshold = new Threshold(75,700, 14);

    private ObservableList<Report> reportsList = FXCollections.observableArrayList(
//            new Report( "10-10-21", "10-11-21", "Matteo"),
//            new Report("10-12-21", "10-13-21", "Matteo"),
//            new Report( "09-09-21", "09-11-21", "Davide"),
//            new Report("09-23-21", "09-27-21", "Matteo"),
//            new Report("12-11-21", "12-27-21", "Matteo"),
//            new Report( "10-10-21", "10-30-21", "Armstrong")
    );



    private ObservableList<ReportSummaryUser> reportList = FXCollections.observableArrayList(
            //new ReportSummaryUser("Collin", 423.5, 2.43, 52.387, true)
    );

    public ObservableList<ReportSummaryUser> getReportList() {
        return reportList;
    }

    public void addToReportSummaryUser(ReportSummaryUser summaryUser) {
        reportList.add(0,summaryUser);
    }


    public ObservableList<Report> getReportsList() {
        return reportsList;
    }

    public void addToReportsList(Report newReport) {
        reportsList.add(0,newReport);
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



}
