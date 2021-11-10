package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class Controller {

    @FXML
    protected void goHome() throws IOException {
        Main.NavigateToNewPage("power-analysis-portal");
    }

}
