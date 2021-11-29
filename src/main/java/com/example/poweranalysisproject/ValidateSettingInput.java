package com.example.poweranalysisproject;

import javafx.scene.control.TextField;

public class ValidateSettingInput {

    private static final String inValid = "Not Valid!";

    public static Threshold validateSettings(TextField cpuThreshold, TextField memoryThreshold, TextField diskThreshold) {
        int cpuValid = validateCPUThreshold(cpuThreshold);
        int memValid = validateMemThreshold(memoryThreshold);
        int diskValid = validateDiskThreshold(diskThreshold);

        Threshold threshold = null;

        if (cpuValid > 0 && memValid > 0 && diskValid > 0) {

            threshold = new Threshold(cpuValid, diskValid, memValid);
        }

        return threshold;
    }

    private static int validateDiskThreshold(TextField diskThreshold) {
        int valid;

        try
        {
            int disk = Integer.parseInt(diskThreshold.getText());
            if (disk < 0 || disk > 1000)
                valid = -1;
            else
                valid = disk;
        }
        catch (Exception e)
        {
            valid = -1;
        }

        if (valid < 0)
            diskThreshold.setText(inValid);

        return valid;
    }

    private static int validateMemThreshold(TextField memoryThreshold) {
        int valid;

        try
        {
            int mem = Integer.parseInt(memoryThreshold.getText());
            if (mem < 0 || mem > 16)
                valid = -1;
            else
                valid = mem;
        }
        catch (Exception e)
        {
            valid = -1;
        }

        if (valid < 0)
            memoryThreshold.setText(inValid);

        return valid;
    }

    private static int validateCPUThreshold(TextField cpuThreshold) {

        int valid;

        try
        {
            int cpu = Integer.parseInt(cpuThreshold.getText());
            if (cpu < 0 || cpu > 100)
                valid = -1;
            else
                valid = cpu;
        }
        catch (Exception e)
        {
            valid = -1;
        }

        if (valid < 0)
            cpuThreshold.setText("Not Valid!");

        return valid;
    }

}
