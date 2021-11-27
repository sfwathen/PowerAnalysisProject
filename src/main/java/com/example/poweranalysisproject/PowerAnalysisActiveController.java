package com.example.poweranalysisproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
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
    private UserProfile currentUser = singleton.getCurrUserProfile();
    private Threshold currentThreshold;

    @FXML
    private void initialize()
    {
        if (currentUser == null)
        {
            currentThreshold = singleton.getDefaultThreshold();
        }
        else {
            currentThreshold = singleton.getCustomThreshold();

            currentStatusText.setText("Power Analysis Active on " + singleton.getCurrUserProfile().getName() + "'s computer");
        }

        threshCPUText.setText(currentThreshold.getCpuThreshold() + "%");
        threshDiskText.setText(currentThreshold.getDiskThreshold() + " KB");
        threshMemText.setText(currentThreshold.getMemThreshold() + " GB");

        startDataCollection();
    }

    @FXML
    public void updateData(String input)
    {
        int curCPU = (int)(Math.random() * 99) + 1;
        if (curCPU > highCPU)
            highCPU = curCPU;

        int curMem = (int)(Math.random() * 15) + 1;
        if (curMem > highMem)
            highMem = curMem;

        int curDisk = (int) (Math.random() * 999) + 1;
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

    public void endAnalysis(ActionEvent actionEvent) {
        try {
            if (highCPU > currentThreshold.getCpuThreshold() || highDisk > currentThreshold.getDiskThreshold()
                    || highMem > currentThreshold.getMemThreshold())
            {
                flagged = true;
            }

            Report report = new Report(java.time.LocalDate.now().toString(), java.time.LocalDate.now().toString(), "Matteo",
                    currentUser.getName(), avgMem, avgCPU, avgDisk, highMem, highCPU, highDisk, flagged, currentThreshold);
            singleton.addToReportsList(report);
            Main.navigateToNewPage("power-analysis-portal");
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                updateData(Math.random() + "");
            }
        }, 0,1000);
    }


}
