package com.example.poweranalysisproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private Label reportIDText;

    @FXML
    private Label reportSupervisor;

    @FXML
    private Label reportStartTime;

    @FXML
    private Label reportEndTime;

    @FXML
    private Label reportMemoryTreshold;

    @FXML
    private Label reportCPUTreshold;

    @FXML
    private Label reportDiskTreshold;

    @FXML
    protected void goToUserPool() throws IOException {
        Main.navigateToNewPage("user-pool");
    }

    @FXML
    protected void goToSettings() throws IOException {
        Main.navigateToNewPage("default-settings");
    }


    public void updateReportSummaryMetrics() {
        Report currReport = ProjectStateSingleton.getInstance().getCurrReport();

        reportIDText.setText(currReport.getReportID());
        reportSupervisor.setText(currReport.getReportSupervisor());
        reportStartTime.setText(currReport.getReportStartDate());
        reportEndTime.setText(currReport.getReportEndDate());
        reportMemoryTreshold.setText(Double.toString(currReport.getMemoryTreshold()));
        reportCPUTreshold.setText(Double.toString(currReport.getCpuTreshold()));
        reportDiskTreshold.setText(Double.toString(currReport.getDiskTreshold()));
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
