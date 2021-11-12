package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class Controller {

    @FXML
    protected void goHome() throws IOException {
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void viewReports() throws IOException {
        Main.navigateToNewPage("reports-viewer");
    }

}
