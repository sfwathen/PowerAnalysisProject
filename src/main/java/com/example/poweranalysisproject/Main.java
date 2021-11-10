package com.example.poweranalysisproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    final static int height = 400;
    final static int width = 600;

    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("power-analysis-portal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("HomePage!");
        stage.setScene(scene);
        stage.show();
    }

    public static void NavigateToNewPage(String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(pageName));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle(pageName + "Change");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}