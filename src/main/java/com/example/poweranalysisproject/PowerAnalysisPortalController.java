package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class PowerAnalysisPortalController extends Controller{

    @FXML
    protected void goToAnalysisSettings() throws IOException {
        Main.navigateToNewPage("analysis-settings");
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
