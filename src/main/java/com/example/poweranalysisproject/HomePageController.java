package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class HomePageController {

    @FXML
    protected void onPowerAnalysisPortalClick() throws IOException {
        Main.NavigateToNewPage("power-analysis-portal.fxml");
    }
}
