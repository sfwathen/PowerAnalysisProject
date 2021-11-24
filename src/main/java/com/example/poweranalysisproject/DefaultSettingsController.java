package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class DefaultSettingsController {

    @FXML
    protected void goToHomePage() throws IOException {
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void goToLoginPage() throws IOException {
        Main.navigateToNewPage("log-in");
    }

    @FXML
    protected void goToReportViewer() throws IOException {
        Main.navigateToNewPage("reports-viewer");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }
}
