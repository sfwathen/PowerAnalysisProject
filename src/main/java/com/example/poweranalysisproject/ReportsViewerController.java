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
import java.util.Date;
import java.util.ResourceBundle;

public class ReportsViewerController implements Initializable {

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

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
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
            new Report( "10-10-21", "10-11-21", "Matteo"),
            new Report("10-12-21", "10-13-21", "Matteo"),
            new Report( "09-09-21", "09-11-21", "Davide"),
            new Report("09-23-21", "09-27-21", "Matteo"),
            new Report("12-11-21", "12-27-21", "Matteo"),
            new Report( "10-10-21", "10-30-21", "Armstrong")
    );

    @FXML
    void handleRowClick(MouseEvent event) throws IOException {
        Report rowReport = ViewReportsTable.getSelectionModel().getSelectedItem();
        if(event.getClickCount() == 2 && rowReport != null){
            Main.navigateToNewPage("report-summary", rowReport);
        }

    }

    @FXML
    void viewReports(ActionEvent event) {

    }

}
