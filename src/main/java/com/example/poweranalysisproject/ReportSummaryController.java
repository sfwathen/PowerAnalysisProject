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
    @FXML
    private TableColumn<ReportSummaryUser, Double> colAvgCpu;

    @FXML
    private TableColumn<ReportSummaryUser, Double> colAvgDisk;

    @FXML
    private TableColumn<ReportSummaryUser, Double> colAvgMem;

    @FXML
    private TableColumn<ReportSummaryUser, String> colFlagged;

    @FXML
    private TableColumn<ReportSummaryUser, Double> colHighCpu;

    @FXML
    private TableColumn<ReportSummaryUser, Double> colHighDisk;

    @FXML
    private TableColumn<ReportSummaryUser, Double> colHighMem;

    @FXML
    private TableColumn<ReportSummaryUser, String> colName;


    public TableView<ReportSummaryUser> reportTable;

    private ProjectStateSingleton singleton = ProjectStateSingleton.getInstance();

    @FXML
    private Label reportIDText;

    @FXML
    private Label reportSupervisor;

    @FXML
    private Label reportStartTime;

    @FXML
    private Label reportEndTime;

    @FXML
    private Label reportMemoryThreshold;

    @FXML
    private Label reportCPUThreshold;

    @FXML
    private Label reportDiskThreshold;

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
        reportMemoryThreshold.setText(Double.toString(currReport.getMemoryTreshold()));
        reportCPUThreshold.setText(Double.toString(currReport.getCpuTreshold()));
        reportDiskThreshold.setText(Double.toString(currReport.getDiskTreshold()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colHighCpu.setCellValueFactory(new PropertyValueFactory<>("highCpu"));
        colAvgCpu.setCellValueFactory(new PropertyValueFactory<>("avgCpu"));
        colHighMem.setCellValueFactory(new PropertyValueFactory<>("highMem"));
        colAvgMem.setCellValueFactory(new PropertyValueFactory<>("avgMem"));
        colHighDisk.setCellValueFactory(new PropertyValueFactory<>("highDisk"));
        colAvgDisk.setCellValueFactory(new PropertyValueFactory<>("avgDisk"));
        colFlagged.setCellValueFactory(new PropertyValueFactory<>("userFlagged"));

        reportTable.setItems(singleton.getReportList());

    }




}
