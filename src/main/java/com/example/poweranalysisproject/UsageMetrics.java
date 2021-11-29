package com.example.poweranalysisproject;

import javafx.beans.property.SimpleDoubleProperty;

public class UsageMetrics {
    private SimpleDoubleProperty highMem;
    private SimpleDoubleProperty avgMem;
    private SimpleDoubleProperty highCpu;
    private SimpleDoubleProperty avgCpu;
    private SimpleDoubleProperty highDisk;
    private SimpleDoubleProperty avgDisk;

    public UsageMetrics(SimpleDoubleProperty highMem, SimpleDoubleProperty avgMem, SimpleDoubleProperty highCpu, SimpleDoubleProperty avgCpu, SimpleDoubleProperty highDisk, SimpleDoubleProperty avgDisk) {
        this.highMem = highMem;
        this.avgMem = avgMem;
        this.highCpu = highCpu;
        this.avgCpu = avgCpu;
        this.highDisk = highDisk;
        this.avgDisk = avgDisk;
    }

    public double getHighMem() {
        return highMem.get();
    }

    public SimpleDoubleProperty highMemProperty() {
        return highMem;
    }

    public void setHighMem(double highMem) {
        this.highMem.set(highMem);
    }

    public double getAvgMem() {
        return avgMem.get();
    }

    public SimpleDoubleProperty avgMemProperty() {
        return avgMem;
    }

    public void setAvgMem(double avgMem) {
        this.avgMem.set(avgMem);
    }

    public double getHighCpu() {
        return highCpu.get();
    }

    public SimpleDoubleProperty highCpuProperty() {
        return highCpu;
    }

    public void setHighCpu(double highCpu) {
        this.highCpu.set(highCpu);
    }

    public double getAvgCpu() {
        return avgCpu.get();
    }

    public SimpleDoubleProperty avgCpuProperty() {
        return avgCpu;
    }

    public void setAvgCpu(double avgCpu) {
        this.avgCpu.set(avgCpu);
    }

    public double getHighDisk() {
        return highDisk.get();
    }

    public SimpleDoubleProperty highDiskProperty() {
        return highDisk;
    }

    public void setHighDisk(double highDisk) {
        this.highDisk.set(highDisk);
    }

    public double getAvgDisk() {
        return avgDisk.get();
    }

    public SimpleDoubleProperty avgDiskProperty() {
        return avgDisk;
    }

    public void setAvgDisk(double avgDisk) {
        this.avgDisk.set(avgDisk);
    }
}
