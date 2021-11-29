package com.example.tester;


import com.example.poweranalysisproject.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.junit.Test;
import javafx.scene.control.TextField;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPowerAnalysis {

    @Test
    public void loopOneCheckTitleConverter() {
        String pageName = Main.toUpperCase("my tester page");
        assertEquals("My Tester Page", pageName);
    }

    @Test
    public void loopTwoCheckTitleConverter() {
        String pageName = Main.toUpperCase("this test verifies the usage of our title converter");
        assertEquals("This Test Verifies The Usage Of Our Title Converter", pageName);
    }

//    @Test
//    public void testIdCounter()
//    {
//        Report report = new Report(null, null, null, null,
//                false, null, null);
//        Report reportOne = new Report(null, null, null, null,
//                false, null, null);
//        Report reportTwo = new Report(null, null, null, null,
//                false, null, null);
//        assertEquals(Report.getId(), 3);
//
//    }

    @Test
    public void testUserProfileName() {
        UserProfile user = new UserProfile("Matteo", "Building 5", "Room 3", "SW");
        assertEquals(user.getName(), "Matteo");
    }

    @Test
    public void testUserProfileBuilding() {
        UserProfile user = new UserProfile("Matteo", "Building 5", "Room 3", "SW");
        user.setBuilding("Building 6");
        assertEquals(user.getBuilding(), "Building 6");
    }

    @Test
    public void testUserProfileRoom() {
        UserProfile user = new UserProfile("Matteo", "Building 5", "Room 3", "SW");
        assertEquals(user.getRoom(), "Room 3");
    }

    @Test
    public void testUserProfileDepartment() {
        UserProfile user = new UserProfile("Matteo", "Building 5", "Room 3", "SW");
        user.setDepartment("CS");
        assertEquals(user.getDepartment(), "CS");
    }

    @Test
    public void testThresholdCpu() {
        Threshold threshold = new Threshold(5,40, 45);
        assertEquals(threshold.getCpuThreshold(), 5);
    }

    @Test
    public void testThresholdDisk() {
        Threshold threshold = new Threshold(5,40, 45);
        assertEquals(threshold.getDiskThreshold(), 40);
    }

    @Test
    public void testThresholdMem() {
        Threshold threshold = new Threshold(5,40, 45);
        assertEquals(threshold.getMemThreshold(), 45);
    }

    @Test
    public void testFormatID() {
        int testID = 1;
        String formatted_id = Report.formatID(testID);
        assertEquals("000001",formatted_id);
    }

}
