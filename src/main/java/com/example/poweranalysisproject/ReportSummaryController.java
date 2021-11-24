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

public class ReportSummaryController extends Controller implements Initializable {
    public TableView<ReportSummaryUser> reportTable;
    public TableColumn<ReportSummaryUser, String> colName;
    public TableColumn<ReportSummaryUser, Double> colMemory;
    public TableColumn<ReportSummaryUser, Double> colCPU;
    public TableColumn<ReportSummaryUser, Double> colDisk;
    public TableColumn<ReportSummaryUser, Boolean> colFlagged;

    @FXML
    protected void goToUserPool() throws IOException {
        Main.navigateToNewPage("user-pool");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        colMemory.setCellValueFactory(new PropertyValueFactory<>("UserMemory"));
        colCPU.setCellValueFactory(new PropertyValueFactory<>("UserCPU"));
        colDisk.setCellValueFactory(new PropertyValueFactory<>("UserDisk"));
        colFlagged.setCellValueFactory(new PropertyValueFactory<>("UserFlagged"));
        reportTable.setItems(reportList);
    }

    ObservableList<ReportSummaryUser> reportList = FXCollections.observableArrayList(
            new ReportSummaryUser("Collin", 423.5, 2.43, 52.387, true)
    );
}
