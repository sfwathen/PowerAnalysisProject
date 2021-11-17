package com.example.poweranalysisproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsViewer implements Initializable {

    @FXML
    private ScrollBar ViewReportsScrollBar;

    @FXML
    private TableView<Report> ViewReportsTable;

    @FXML
    private TableColumn<Report, String> endDateColumn;

    @FXML
    private TableColumn<Report, String> reportIDColumn;

    @FXML
    private TableColumn<Report, String> startDateColumn;

    @FXML
    private TableColumn<Report, String> supervisorColumn;

    @FXML
    void goHome(ActionEvent event) throws IOException {
        Main.navigateToNewPage("power-analysis-portal");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reportIDColumn.setCellValueFactory(new PropertyValueFactory<>("ReportID"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("ReportStartDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("ReportEndDate"));
        supervisorColumn.setCellValueFactory(new PropertyValueFactory<>("ReportSupervisor"));
        ViewReportsTable.setItems(reportsList);
    }

    private ObservableList<Report> reportsList = FXCollections.observableArrayList(
            new Report("00001", "10-10-2021", "10-11-2021", "Matteo"),
            new Report("00002", "10-12-2021", "10-13-2021", "Matteo"),
            new Report("00003", "09-09-2021", "09-11-2021", "Davide"),
            new Report("00004", "09-23-2021", "09-27-2021", "Matteo"),
            new Report("00005", "12-11-2021", "12-27-2021", "Matteo"),
            new Report("00006", "10-10-2021", "10-30-2021", "Armstrong")
    );

    @FXML
    void tableMouseClicked(MouseEvent event) throws IOException {
        Main.navigateToNewPage("report-summary");
    }

    @FXML
    void viewReports(ActionEvent event) {

    }

}
