package com.example.poweranalysisproject;

import javafx.scene.control.TextField;

public class ValidateSettingInput {

    private static final String inValid = "Not Valid!";

    public static int validateDiskThreshold(TextField diskThreshold) {
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

    public static int validateMemThreshold(TextField memoryThreshold) {
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

    public static int validateCPUThreshold(TextField cpuThreshold) {

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
