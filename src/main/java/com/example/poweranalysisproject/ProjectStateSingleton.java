package com.example.poweranalysisproject;

public class ProjectStateSingleton {
    private static final ProjectStateSingleton psSingleton = new ProjectStateSingleton();

    // Ricardos
    private Report currReport;
    //

    private UserProfile currUserProfile;

    private Threshold customThreshold;
    private Threshold defaultThreshold = new Threshold(75,700, 14);



    private ProjectStateSingleton() {}

    public static ProjectStateSingleton getInstance() {
        return psSingleton;
    }

    public Report getCurrReport() {
        return currReport;
    }

    public void setCurrReport(Report newCurrReport) {
        currReport = newCurrReport;
    }

    public void setCurrUserProfile(UserProfile user)
    {
        currUserProfile = user;
    }

    public UserProfile getCurrUserProfile()
    {
        return currUserProfile;
    }

    public Threshold getCustomThreshold() {
        return customThreshold;
    }

    public void setCustomThreshold(Threshold customThreshold) {
        this.customThreshold = customThreshold;
    }

    public Threshold getDefaultThreshold() {
        return defaultThreshold;
    }

    public void setDefaultThreshold(Threshold defaultThreshold) {
        this.defaultThreshold = defaultThreshold;
    }



}
