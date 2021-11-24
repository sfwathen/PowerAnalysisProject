package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class PowerAnalysisPortalController extends Controller{
    @FXML
    protected void goToUserPool() throws IOException {
        Main.navigateToNewPage("user-pool");
    }

    @FXML
    protected void goToActivePowerAnalysis() throws IOException {
        Main.navigateToNewPage("power-analysis-active");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }
}
