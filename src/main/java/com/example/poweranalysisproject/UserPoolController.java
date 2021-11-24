package com.example.poweranalysisproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserPoolController extends Controller implements Initializable {

    public TableView<UserProfile> table;

    public TableColumn<UserProfile, String> Name;
    public TableColumn<UserProfile, String> Building;
    public TableColumn<UserProfile, String> Room;
    public TableColumn<UserProfile, String> Department;
    public TableColumn<UserProfile, String> Selected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Building.setCellValueFactory(new PropertyValueFactory<>("Building"));
        Room.setCellValueFactory(new PropertyValueFactory<>("Room"));
        Department.setCellValueFactory(new PropertyValueFactory<>("Department"));
        Selected.setCellValueFactory(new PropertyValueFactory<>("Selected"));
        table.setItems(observableList);
    }

    ObservableList<UserProfile> observableList = FXCollections.observableArrayList(
               new UserProfile("Collin", "10A", "5", "CS", "Yes"),
            new UserProfile("Noah", "10A", "5", "CS", "No"),
            new UserProfile("Sam", "10A", "5", "CS", "Yes"),
            new UserProfile("Ricardo", "10A", "5", "CS", "No"),
            new UserProfile("Davide", "10A", "5", "CS", "Yes")



    );

    @FXML
    protected void continueOn() throws IOException {
        Main.navigateToNewPage("analysis-settings");
    }

    @FXML
    protected void goBack() throws IOException {
        Main.navigateToNewPage("power-analysis-portal");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }
}
