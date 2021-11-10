package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class PowerAnalysisPortalController extends Controller{
    @FXML
    protected void goToUserPool() throws IOException {
        Main.NavigateToNewPage("user-pool");
    }
}
