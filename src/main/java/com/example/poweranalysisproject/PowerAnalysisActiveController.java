package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class PowerAnalysisActiveController {
    @FXML
    protected void goHome() throws IOException {
        Main.NavigateToNewPage("power-analysis-active");
    }
}
