package com.example.poweranalysisproject;

public class ProjectStateSingleton {
    private static final ProjectStateSingleton psSingleton = new ProjectStateSingleton();

    // Ricardos
    private Report currReport;
    //

    private UserProfile currUserProfile;

    private ProjectStateSingleton() {}

    public static ProjectStateSingleton getInstance() {
        return psSingleton;
    }

    public void setCurrUserProfile(UserProfile user)
    {
        currUserProfile = user;
    }

    public UserProfile getCurrUserProfile()
    {
        return currUserProfile;
    }



}
