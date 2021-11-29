package com.example.poweranalysisproject;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PowerAnalysisActiveController extends Controller{

    @FXML
    public Label startTime;
    @FXML
    public Label activeTime;

    @FXML
    private Label curCPUText;

    @FXML
    private Label curDiskText;

    @FXML
    private Label curMemText;

    @FXML
    private Label currentStatusText;

    @FXML
    private Label highCPUText;

    @FXML
    private Label highDiskText;

    @FXML
    private Label highMemText;

    @FXML
    private Label threshCPUText;

    @FXML
    private Label threshDiskText;

    @FXML
    private Label threshMemText;

    private boolean flagged = false;

    private int count = 0;
    
    private int avgCPU = 0;
    private int avgMem = 0;
    private int avgDisk = 0;

    private int highCPU = 0;
    private int highMem = 0;
    private int highDisk = 0;

    private int totalCPU = 0;
    private int totalMem = 0;
    private int totalDisk = 0;

    private ProjectStateSingleton singleton = ProjectStateSingleton.getInstance();
    private UserProfile currentUser;
    private Threshold currentThreshold;

    private Random randomNums = new SecureRandom();

    @FXML
    private void initialize()
    {
        if (ProjectStateSingleton.getInstance().isDefaultAnalysis())
        {
            currentThreshold = singleton.getDefaultThreshold();
            currentUser = singleton.getDefaultUserProfile();
            ProjectStateSingleton.getInstance().setDefaultAnalysis(false);
        }
        else {
            currentThreshold = singleton.getCustomThreshold();
            currentUser = singleton.getCurrUserProfile();


        }
        currentStatusText.setText("Power Analysis Active on " + currentUser.getName() + "'s computer");
        threshCPUText.setText(currentThreshold.getCpuThreshold() + "%");
        threshDiskText.setText(currentThreshold.getDiskThreshold() + " KB");
        threshMemText.setText(currentThreshold.getMemThreshold() + " GB");

        startDataCollection();
    }

    @FXML
    public void updateData()
    {
        int curCPU = (int)(randomNums.nextGaussian() * 16) + 40;
        if (curCPU > 100 || curCPU < 0)
            curCPU = 100 - Math.abs(curCPU);
        if (curCPU > highCPU)
            highCPU = curCPU;

        int curMem = (int)(randomNums.nextGaussian() * 3) + 7;
        if (curMem > 16 || curMem < 0)
            curMem = 16 - Math.abs(curMem);
        if (curMem > highMem)
            highMem = curMem;

        int curDisk = (int) (randomNums.nextGaussian() * 180) + 500;
        if (curDisk > 1000 || curDisk < 0)
            curDisk = 1000 - Math.abs(curDisk);
        if (curDisk > highDisk)
            highDisk = curDisk;
        
        totalCPU += curCPU;
        totalMem += curMem;
        totalDisk += curDisk;

        count++;

        avgCPU = totalCPU / count;
        avgMem = totalMem / count;
        avgDisk = totalDisk / count;

        populatePage(curCPU, curMem, curDisk);
        populateDuration();

    }

    private void populateDuration() {
        if (count < 60)
            Platform.runLater(() -> activeTime.setText("Active for " + count + " seconds"));
        else
            Platform.runLater(() -> activeTime.setText("Active for " + count / 60 + " minutes"));

    }

    private void populatePage(int curCPU, int curMem, int curDisk) {

        Platform.runLater(() -> curCPUText.setText(curCPU + "%"));
        Platform.runLater(() -> curMemText.setText(curMem + " GB"));
        Platform.runLater(() -> curDiskText.setText(curDisk + " KB"));

        Platform.runLater(() -> highCPUText.setText(highCPU + "%"));
        Platform.runLater(() -> highMemText.setText(highMem + " GB"));
        Platform.runLater(() -> highDiskText.setText(highDisk + " KB"));
    }


    @FXML
    protected void goHome()  throws IOException{
        Main.navigateToNewPage("power-analysis-active");
    }

    @FXML
    protected void logOut() throws IOException {
        Main.navigateToNewPage("log-in");
    }

    public void endAnalysis() throws IOException {
        if (highCPU > currentThreshold.getCpuThreshold() || highDisk > currentThreshold.getDiskThreshold()
                || highMem > currentThreshold.getMemThreshold()) {
            flagged = true;
        }

        UsageMetrics usageMetrics = new UsageMetrics(new SimpleDoubleProperty(highMem), new SimpleDoubleProperty(avgMem), new SimpleDoubleProperty(highCPU), new SimpleDoubleProperty(avgCPU), new SimpleDoubleProperty(highDisk), new SimpleDoubleProperty(avgDisk));
        Report report = new Report(java.time.LocalDate.now().toString(), java.time.LocalDate.now().toString(), "Matteo", usageMetrics, flagged, currentThreshold, currentUser);
        singleton.addToReportsList(report);
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }

    public void startDataCollection() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateData();
            }
        }, 0,1000);
    }
}
