package com.example.poweranalysisproject;

import javafx.fxml.FXML;
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
            System.out.println("Incorrect username/password combo");
        } else {
            Main.navigateToNewPage("power-analysis-portal");
        }
    }
}
