package com.example.tester;

import com.example.poweranalysisproject.Threshold;
import com.example.poweranalysisproject.ValidateSettingInput;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.junit.Test;
import javafx.scene.control.TextField;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPowerAnalysis {
    @FXML
    TextField diskThreshold = new TextField();
    
    @Test
    public void testCpuLowThreshold()  {

       // TextField cpuThreshold = new TextField("Hello");
//        cpuThreshold.setText("0");
//        TextField diskThreshold = new TextField();
        diskThreshold.setText("50");
//        TextField memoryThreshold = new TextField();
//        memoryThreshold.setText("5");
//
//
//        Threshold validCpuThreshold = ValidateSettingInput.validateSettings(cpuThreshold, memoryThreshold, diskThreshold);
//        assertTrue(validCpuThreshold != null);
    }

    @Test
    public void testCpuHighThreshold()  {
        TextField cpuThreshold = new TextField("17");
        TextField diskThreshold = new TextField("50");
        TextField memoryThreshold = new TextField("100");

        Threshold validCpuThreshold = ValidateSettingInput.validateSettings(cpuThreshold, memoryThreshold, diskThreshold);
        assertTrue(validCpuThreshold != null);
    }

    @Test
    public void testDiskLowThreshold()  {
        TextField cpuThreshold = new TextField("0");
        TextField diskThreshold = new TextField("100");
        TextField memoryThreshold = new TextField("100");

        Threshold validCpuThreshold = ValidateSettingInput.validateSettings(cpuThreshold, memoryThreshold, diskThreshold);
        assertTrue(validCpuThreshold != null);
    }


}
