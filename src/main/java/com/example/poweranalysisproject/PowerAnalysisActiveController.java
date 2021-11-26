package com.example.poweranalysisproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

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

    @FXML
    private void initialize()
    {
        currentStatusText.setText("Power Analysis Active on " + Main.currUser.getName() + " computer");
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
            Main.navigateToNewPage("power-analysis-portal");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }




}
