package com.example.poweranalysisproject;

import javafx.beans.property.SimpleStringProperty;

public class UserProfile {

    private SimpleStringProperty name;
    private SimpleStringProperty building;
    private SimpleStringProperty room;
    private SimpleStringProperty department;

    public UserProfile(String name, String building, String room, String department){
        this.name = new SimpleStringProperty(name);
        this.building = new SimpleStringProperty(building);
        this.room = new SimpleStringProperty(room);
        this.department = new SimpleStringProperty(department);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getBuilding() {
        return building.get();
    }

    public void setBuilding(String building) {
        this.building = new SimpleStringProperty(building);
    }

    public String getRoom() {
        return room.get();
    }

    public void setRoom(String room) {
        this.room = new SimpleStringProperty(room);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department = new SimpleStringProperty(department);
    }


}
