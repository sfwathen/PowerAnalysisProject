package com.example.poweranalysisproject;

public class Threshold {

    private int cpuThreshold;
    private int diskThreshold;
    private int memThreshold;

    public Threshold(int verifiedCPUThreshold, int verifiedDiskThreshold, int verifiedMemThreshold) {
        cpuThreshold = verifiedCPUThreshold;
        diskThreshold = verifiedDiskThreshold;
        memThreshold = verifiedMemThreshold;
    }

    public int getMemThreshold() {
        return memThreshold;
    }

    public int getCpuThreshold() {
        return cpuThreshold;
    }

    public int getDiskThreshold() {
        return diskThreshold;
    }
}
