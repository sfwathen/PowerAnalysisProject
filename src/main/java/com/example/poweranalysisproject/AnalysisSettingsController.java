package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AnalysisSettingsController extends Controller{
    @FXML
    private TextField CPUTreshold;

    @FXML
    private TextField DiskTreshold;

    @FXML
    private TextField MemoryTreshold;

    @FXML
    private DatePicker textFieldEndDate;

    @FXML
    private DatePicker textFieldStartDate;

    @FXML
    private CheckBox CurrTimeCheckBox;

    @FXML
    protected void clickButtonScheduleAnalysis() throws IOException {
        // Before it navigates, do error checking for the Dates, etc...
        // Set
        Main.NavigateToNewPage("power-analysis-portal");
    }


}



