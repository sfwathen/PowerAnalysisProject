package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class PowerAnalysisPortalController extends Controller{
    @FXML
    protected void goToUserPool() throws IOException {
        Main.NavigateToNewPage("user-pool");
    }

    @FXML
    protected void goToActivePowerAnalysis() throws IOException {
        Main.NavigateToNewPage("power-analysis-active");
    }
}
