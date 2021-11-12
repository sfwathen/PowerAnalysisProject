package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class PowerAnalysisActiveController extends Controller{
    @FXML
    protected void goHome()  throws IOException{
        Main.navigateToNewPage("power-analysis-active");
    }
}
