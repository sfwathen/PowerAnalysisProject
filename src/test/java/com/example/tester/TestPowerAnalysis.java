package com.example.tester;

import com.example.poweranalysisproject.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.junit.Test;
import javafx.scene.control.TextField;

import static org.junit.jupiter.api.Assertions.*;

public class TestPowerAnalysis {

    final static String building5 = "Building 5";
    final static String building6 = "Building 6";
    final static String building7 = "Building 7";
    final static String matteoName = "Matteo";
    final static String room3 = "Room 3";
    final static String room5 = "Room 5";
    final static String room6 = "Room 6";
    final static String eeDepartment = "ee";

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
                false, threshold, new UserProfile(matteoName, building5, room3
                , "SW"));
        Report reportTwo = new Report(null, null, null, null,
                false, threshold, new UserProfile("MatteoOne", building6, room5, "CPE"));
        Report reportThreeDepartment = new Report(null, null, null, null,
                false, threshold, new UserProfile("MatteoTwo", building6, room6, eeDepartment));

        assertEquals(4, Report.getId());
        assertNotEquals(reportOne, reportTwo);
        assertNotEquals(reportTwo, reportThreeDepartment);
        assertNotEquals(reportOne, reportThreeDepartment);
    }

    @Test
    public void testUserProfileName()
    {
        UserProfile user = new UserProfile(matteoName, building5, room3
                , "SW");
        assertEquals(user.getName(), matteoName);
    }

    @Test
    public void testUserProfileBuilding()
    {
        UserProfile user = new UserProfile("Davide", building6, "Room 9", eeDepartment);
        user.setBuilding(building7);
        assertEquals(user.getBuilding(), building7);
    }

    @Test
    public void testUserProfileRoom()
    {
        UserProfile user = new UserProfile(matteoName, building7, room6, "CS");
        assertEquals(user.getRoom(), room6);
    }

    @Test
    public void testUserProfileDepartment()
    {
        UserProfile user = new UserProfile("Davide1", building5, room3
                , eeDepartment);
        user.setDepartment(eeDepartment);
        assertEquals(user.getDepartment(), eeDepartment);
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

    @Test
    public void testFormatID() {
        int testID = 1;
        String formattedID = Report.formatID(testID);
        assertEquals("000001",formattedID);
    }

}
