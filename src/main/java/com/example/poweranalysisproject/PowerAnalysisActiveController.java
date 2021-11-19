package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class PowerAnalysisActiveController extends Controller{
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
}
