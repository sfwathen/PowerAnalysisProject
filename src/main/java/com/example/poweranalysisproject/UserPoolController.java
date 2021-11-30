package com.example.poweranalysisproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserPoolController extends Controller implements Initializable {

    @FXML
    protected TableView<UserProfile> table;

    @FXML
    protected TableColumn<UserProfile, String> name;

    @FXML
    protected TableColumn<UserProfile, String> building;

    @FXML
    protected TableColumn<UserProfile, String> room;

    @FXML
    protected TableColumn<UserProfile, String> department;

    @FXML
    protected TableColumn<UserProfile, String> selected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        building.setCellValueFactory(new PropertyValueFactory<>("Building"));
        room.setCellValueFactory(new PropertyValueFactory<>("Room"));
        department.setCellValueFactory(new PropertyValueFactory<>("Department"));
        table.setItems(observableList);
    }

    ObservableList<UserProfile> observableList = FXCollections.observableArrayList(
               new UserProfile("Collin", "10A", "5", "CPE"),
            new UserProfile("Noah", "15C", "10", "SW"),
            new UserProfile("Sam", "5B", "4", "CS"),
            new UserProfile("Ricardo", "22A", "11", "CS"),
            new UserProfile("Davide", "1E", "1", "CSE")
    );

    @FXML
    protected void goBack() throws IOException {
        Main.navigateToNewPage("analysis-settings");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }

    @FXML
    protected void logOut() throws IOException {
        Main.navigateToNewPage("log-in");
    }

    @FXML
    protected void beginAnalysis() throws IOException, InterruptedException {

        Main.navigateToNewPage("power-analysis-active", ProjectStateSingleton.getInstance().getDefaultUserProfile());
    }

    @FXML
    void handleRowClick(MouseEvent event) throws IOException, InterruptedException {
        UserProfile user = table.getSelectionModel().getSelectedItem();
        if (event.getClickCount() == 2 && user != null) {
            Main.navigateToNewPage("power-analysis-active", user);
        }
    }
}
