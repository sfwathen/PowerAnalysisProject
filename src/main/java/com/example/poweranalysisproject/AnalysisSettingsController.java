package com.example.poweranalysisproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AnalysisSettingsController extends Controller{

    private int verifiedCPUThreshold;
    private int verifiedMemThreshold;
    private int verifiedDiskThreshold;

    private final String inValid = "Not Valid!";

    @FXML
    private TextField cpuThreshold;

    @FXML
    private TextField diskThreshold;

    @FXML
    private TextField memoryThreshold;

    @FXML
    private DatePicker textFieldEndDate;

    @FXML
    private DatePicker textFieldStartDate;

    @FXML
    private CheckBox currTimeCheckBox;

    @FXML
    protected void clickButtonScheduleAnalysis() throws IOException {
        // Before it navigates, do error checking for the Dates, etc...
        // Set
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }

    @FXML
    protected void goBack() throws IOException {
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void logOut() throws IOException {
        Main.navigateToNewPage("log-in");
    }

    @FXML
    protected void goToUserPool() throws IOException {

        boolean cpuValid = validateCPUThreshold();
        boolean memValid = validateMemThreshold();
        boolean diskValid = validateDiskThreshold();

        if (cpuValid && memValid && diskValid) {
            Threshold threshold = new Threshold(verifiedCPUThreshold, verifiedDiskThreshold, verifiedMemThreshold);
            ProjectStateSingleton.getInstance().setCustomThreshold(threshold);
            Main.navigateToNewPage("user-pool");
        }
    }

    private boolean validateDiskThreshold() {
        boolean valid = true;

        String diskText = diskThreshold.getText();

        try
        {
            int disk = Integer.parseInt(diskText);
            if (disk < 0 || disk > 1000)
                valid = false;
            else
                verifiedDiskThreshold = disk;
        }
        catch (Exception e)
        {
            valid = false;
        }

        if (!valid)
            diskThreshold.setText(inValid);

        return valid;
    }

    private boolean validateMemThreshold() {
        boolean valid = true;

        String memoryText = memoryThreshold.getText();

        try
        {
            int mem = Integer.parseInt(memoryText);
            if (mem < 0 || mem > 16)
                valid = false;
            else
                verifiedMemThreshold = mem;
        }
        catch (Exception e)
        {
            valid = false;
        }

        if (!valid)
            memoryThreshold.setText(inValid);

        return valid;
    }

    private boolean validateCPUThreshold() {

        boolean valid = true;

        String cpuText = cpuThreshold.getText();

        try
        {
            int cpu = Integer.parseInt(cpuText);
            if (cpu < 0 || cpu > 100)
                valid = false;
            else
                verifiedCPUThreshold = cpu;
        }
        catch (Exception e)
        {
            valid = false;
        }

        if (!valid)
            cpuThreshold.setText(inValid);

        return valid;
    }
}



