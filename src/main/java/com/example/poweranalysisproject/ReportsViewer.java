package com.example.poweranalysisproject;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ReportsViewer extends Controller{

    @FXML
    private ScrollBar ViewReportsScrollBar;

    @FXML
    private TableView<?> ViewReportsTable;

    @FXML
    void tableMouseClicked(MouseEvent event) throws IOException {
        Main.navigateToNewPage("report-summary");
    }

}
