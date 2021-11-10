package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class PowerAnalysisPortalController {
    @FXML
    protected void goToUserPool() throws IOException {
        Main.NavigateToNewPage("user-pool");
    }
}
