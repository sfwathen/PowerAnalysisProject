package com.example.poweranalysisproject;

import javafx.beans.property.SimpleStringProperty;

public class UserProfile {

    private SimpleStringProperty Name;
    private SimpleStringProperty Building;
    private SimpleStringProperty Room;
    private SimpleStringProperty Department;
    private SimpleStringProperty Selected;

    public UserProfile(String name, String building, String room, String department, String selected) {
        this.Name = new SimpleStringProperty(name);
        this.Building = new SimpleStringProperty(building);
        this.Room = new SimpleStringProperty(room);
        this.Department = new SimpleStringProperty(department);
        this.Selected = new SimpleStringProperty(selected);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String name) {
        this.Name = new SimpleStringProperty(name);
    }

    public String getBuilding() {
        return Building.get();
    }

    public void setBuilding(String building) {
        this.Building = new SimpleStringProperty(building);
    }

    public String getRoom() {
        return Room.get();
    }

    public void setRoom(String room) {
        this.Room = new SimpleStringProperty(room);
    }

    public String getDepartment() {
        return Department.get();
    }

    public void setDepartment(String department) {
        this.Department = new SimpleStringProperty(department);
    }

    public String getSelected() {
        return Selected.get();
    }

    public void setSelected(String selected) {
        this.Selected = new SimpleStringProperty(selected);
    }
}
