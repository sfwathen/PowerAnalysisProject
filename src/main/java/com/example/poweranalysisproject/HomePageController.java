package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class HomePageController extends Controller{

    @FXML
    protected void onPowerAnalysisPortalClick() throws IOException {
        Main.NavigateToNewPage("power-analysis-portal.fxml");
    }
}
