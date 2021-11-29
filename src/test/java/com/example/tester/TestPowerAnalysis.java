package com.example.tester;


import com.example.poweranalysisproject.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.junit.Test;
import javafx.scene.control.TextField;

import static org.junit.jupiter.api.Assertions.*;

public class TestPowerAnalysis {

    final String BUILDING_5 = "Building 5";
    final String BUILDING_6 = "Building 6";
    final String BUILDING_7 = "Building 5";
    final String MATTEO_NAME = "Matteo";
    final String ROOM_3 = "Room 3";
    final String ROOM_5 = "Room 5";
    final String ROOM_6 = "Room 6";
    final String EE = "EE";

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
                false, threshold, new UserProfile(MATTEO_NAME, BUILDING_5, ROOM_3, "SW"));
        Report reportTwo = new Report(null, null, null, null,
                false, threshold, new UserProfile("MatteoOne", BUILDING_6, ROOM_5, "CPE"));
        Report reportThree = new Report(null, null, null, null,
                false, threshold, new UserProfile("MatteoTwo", BUILDING_6, ROOM_6, EE));

        assertEquals(4, Report.getId());
        assertNotEquals(reportOne, reportTwo);
        assertNotEquals(reportTwo, reportThree);
        assertNotEquals(reportOne, reportThree);
    }

    @Test
    public void testUserProfileName()
    {
        UserProfile user = new UserProfile(MATTEO_NAME, BUILDING_5, ROOM_3, "SW");
        assertEquals(user.getName(), MATTEO_NAME);
    }

    @Test
    public void testUserProfileBuilding()
    {
        UserProfile user = new UserProfile("Davide", BUILDING_6, "Room 9", "CPE");
        user.setBuilding(BUILDING_7);
        assertEquals(user.getBuilding(), BUILDING_7);
    }

    @Test
    public void testUserProfileRoom()
    {
        UserProfile user = new UserProfile(MATTEO_NAME, BUILDING_7, ROOM_6, "CS");
        assertEquals(user.getRoom(), ROOM_6);
    }

    @Test
    public void testUserProfileDepartment()
    {
        UserProfile user = new UserProfile("Davide1", BUILDING_5, ROOM_3, EE);
        user.setDepartment(EE);
        assertEquals(user.getDepartment(), EE);
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
