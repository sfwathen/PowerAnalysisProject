package com.example.poweranalysisproject;

import javafx.scene.control.TextField;

public class ValidateSettingInput {

    private static final String INVALID = "Not Valid!";

    private ValidateSettingInput() {
        throw new IllegalStateException("Utility class");
    }

    public static Threshold validateSettings(TextField cpuThreshold, TextField memoryThreshold, TextField diskThreshold) {
        int cpuValid = validateCPUThreshold(cpuThreshold.getText());
        if (cpuValid < 0)
            cpuThreshold.setText(INVALID);

        int memValid = validateMemThreshold(memoryThreshold.getText());
        if (memValid < 0)
            memoryThreshold.setText(INVALID);

        int diskValid = validateDiskThreshold(diskThreshold.getText());
        if (diskValid < 0)
            diskThreshold.setText(INVALID);

        Threshold threshold = null;

        if (cpuValid > 0 && memValid > 0 && diskValid > 0) {

            threshold = new Threshold(cpuValid, diskValid, memValid);
        }

        return threshold;
    }

    public static int validateDiskThreshold(String  diskThreshold) {
        int valid;

        try
        {
            int disk = Integer.parseInt(diskThreshold);
            if (disk < 1 || disk > 1000)
                valid = -1;
            else
                valid = disk;
        }
        catch (Exception e)
        {
            valid = -1;
        }

        return valid;
    }

    public static int validateMemThreshold(String memoryThreshold) {

        int valid;
        try
        {
            int mem = Integer.parseInt(memoryThreshold);
            if (mem < 1 || mem > 16)
                valid = -1;
            else
                valid = mem;
        }
        catch (Exception e)
        {
            valid = -1;
        }

        return valid;
    }

    public static int validateCPUThreshold(String cpuThreshold) {

        int valid;
        try
        {
            int cpu = Integer.parseInt(cpuThreshold);
            if (cpu < 1 || cpu > 100)
                valid = -1;
            else
                valid = cpu;
        }
        catch (Exception e)
        {
            valid = -1;
        }

        return valid;
    }

}
