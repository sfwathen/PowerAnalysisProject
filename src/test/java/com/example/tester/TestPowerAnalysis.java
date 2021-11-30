package com.example.tester;

import com.example.poweranalysisproject.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.junit.Test;
import javafx.scene.control.TextField;

import static org.junit.jupiter.api.Assertions.*;

public class TestPowerAnalysis {

    static final String BUILDING5 = "Building 5";
    static final String BUILDING6 = "Building 6";
    static final String BUILDING7 = "Building 7";
    static final String MATTEONAME = "Matteo";
    static final String ROOM3 = "Room 3";
    static final String ROOM5 = "Room 5";
    static final String ROOM6 = "Room 6";
    static final String EE = "ee";

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
        Report.setId(1);

        for (int i = 0; i < 3; i++)
        {
            new Report(null, null, null, null,
                    false, threshold, new UserProfile(MATTEONAME, BUILDING5, ROOM3
                    , "SW"));
        }
        assertEquals(4, Report.getId());
    }

    @Test
    public void testFormatID() {
        int testID = 1;
        String formattedID = Report.formatID(testID);
        assertEquals("000001",formattedID);
    }

    @Test
    public void testFormatIDTwo() {
        int testID = 111;
        String formattedID = Report.formatID(testID);
        assertEquals("000111",formattedID);
    }

    @Test
    public void testFormatIDThree() {
        int testID = 34567;
        String formattedID = Report.formatID(testID);
        assertEquals("034567",formattedID);
    }

    @Test
    public void testUserProfileName()
    {
        UserProfile user = new UserProfile(MATTEONAME, BUILDING5, ROOM3
                , "SW");
        assertEquals(user.getName(), MATTEONAME);
    }

    @Test
    public void testUserProfileBuilding()
    {
        UserProfile user = new UserProfile("Davide", BUILDING6, "Room 9", EE);
        user.setBuilding(BUILDING7);
        assertEquals(user.getBuilding(), BUILDING7);
    }

    @Test
    public void testUserProfileRoom()
    {
        UserProfile user = new UserProfile(MATTEONAME, BUILDING7, ROOM6, "CS");
        assertEquals(user.getRoom(), ROOM6);
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
    public void testCpuThresholdValidatorValid()
    {
        int valid = ValidateSettingInput.validateCPUThreshold("10");
        assertTrue(valid > 0);
    }

    @Test
    public void testCpuThresholdValidatorInValid()
    {
        int valid = ValidateSettingInput.validateCPUThreshold("111");
        assertTrue(valid == -1);
    }

    @Test
    public void testMemThresholdValidatorValid()
    {
        int valid = ValidateSettingInput.validateMemThreshold("15");
        assertTrue(valid > 0);
    }

    @Test
    public void testMemThresholdValidatorInValid()
    {
        int valid = ValidateSettingInput.validateMemThreshold("-1");
        assertTrue(valid == -1);
    }

    @Test
    public void testDiskThresholdValidatorValid()
    {
        int valid = ValidateSettingInput.validateDiskThreshold("567");
        assertTrue(valid > 0);
    }

    @Test
    public void testDiskThresholdValidatorInValid()
    {
        int valid = ValidateSettingInput.validateDiskThreshold("1001");
        assertTrue(valid == -1);
    }








}
