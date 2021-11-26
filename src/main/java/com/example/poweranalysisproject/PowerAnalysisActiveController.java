package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class PowerAnalysisActiveController extends Controller{

    @FXML
    public Label startTime;

    @FXML
    private void initialize()
    {
        startTime.setText(Main.currUser.getName());
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
