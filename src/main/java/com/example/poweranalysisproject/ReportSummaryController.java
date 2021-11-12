package com.example.poweranalysisproject;

import javafx.fxml.FXML;

import java.io.IOException;

public class ReportSummaryController extends Controller{
    @FXML
    protected void goToUserPool() throws IOException {
        Main.navigateToNewPage("user-pool");
    }
}
