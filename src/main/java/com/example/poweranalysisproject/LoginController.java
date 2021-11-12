package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class LoginController extends Controller {
    @FXML
    protected void goToHomePage() throws IOException {
        Main.navigateToNewPage("power-analysis-portal");
    }
}
