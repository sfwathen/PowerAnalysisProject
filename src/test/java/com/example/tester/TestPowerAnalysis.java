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
    public void loopOneCheckTitleConverter()
    {
        String pageName = Main.toUpperCase("my tester page");
        assertEquals("My Tester Page", pageName);
    }

    @Test
    public void loopTwoCheckTitleConverter()
    {
        String pageName = Main.toUpperCase("this test verifies the usage of our title converter");
        assertEquals("This Test Verifies The Usage Of Our Title Converter", pageName);
    }

    @Test
    public void testIdCounter()
    {
        Threshold threshold = new Threshold(11,79, 33);
        Report reportOne = new Report(null, null, null, null,
                false, threshold, new UserProfile("Matteo", "Building 5", "Room 3", "SW"));
        Report reportTwo = new Report(null, null, null, null,
                false, threshold, new UserProfile("MatteoOne", "Building 6", "Room 5", "CPE"));
        Report reportThree = new Report(null, null, null, null,
                false, threshold, new UserProfile("MatteoTwo", "Building 6", "Room 6", "EE"));

        assertEquals(4, Report.getId());
    }

    @Test
    public void testUserProfileName()
    {
        UserProfile user = new UserProfile("Matteo", "Building 5", "Room 3", "SW");
        assertEquals(user.getName(), "Matteo");
    }

    @Test
    public void testUserProfileBuilding()
    {
        UserProfile user = new UserProfile("Davide", "Building 6", "Room 9", "CPE");
        user.setBuilding("Building 7");
        assertEquals(user.getBuilding(), "Building 7");
    }

    @Test
    public void testUserProfileRoom()
    {
        UserProfile user = new UserProfile("Matteo1", "Building 7", "Room 6", "CS");
        assertEquals(user.getRoom(), "Room 6");
    }

    @Test
    public void testUserProfileDepartment()
    {
        UserProfile user = new UserProfile("Davide1", "Building 5", "Room 3", "EE");
        user.setDepartment("EE");
        assertEquals(user.getDepartment(), "EE");
    }

    @Test
    public void testThresholdCpu()
    {
        Threshold threshold = new Threshold(5,41, 46);
        assertEquals(threshold.getCpuThreshold(), 5);
    }

    @Test
    public void testThresholdDisk()
    {
        Threshold threshold = new Threshold(2,42, 48);
        assertEquals(threshold.getDiskThreshold(), 42);
    }

    @Test
    public void testThresholdMem()
    {
        Threshold threshold = new Threshold(9,45, 48);
        assertEquals(threshold.getMemThreshold(), 48);
    }





}
