package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class ProfileController extends Controller {
    @FXML
    protected void goToHomePage() throws IOException {
        Main.NavigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void goToLoginPage() throws IOException {
        Main.NavigateToNewPage("log-in");
    }
}