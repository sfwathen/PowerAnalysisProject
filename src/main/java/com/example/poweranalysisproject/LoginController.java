package com.example.poweranalysisproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController extends Controller {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    @FXML
    protected void goToHomePage() throws IOException {
        if (usernameTextField.getText().length() == 0 || passwordTextField.getText().length() == 0) {
            usernameTextField.setStyle("-fx-text-box-border: #FF0000");
            passwordTextField.setStyle("-fx-text-box-border: #FF0000");
            Alert fail = new Alert(Alert.AlertType.ERROR);
            fail.setHeaderText("Log In Failed");
            fail.setContentText("Please Enter a Valid Username & Password");
            fail.showAndWait();
        } else {
            Main.navigateToNewPage("power-analysis-portal");
        }
    }
}
