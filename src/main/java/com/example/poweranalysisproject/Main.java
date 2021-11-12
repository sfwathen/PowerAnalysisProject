package com.example.poweranalysisproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static final int Height = 400;
    static final int Width = 600;

    static private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("log-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Width, Height);
        stage.setTitle("HomePage!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void navigateToNewPage(String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(pageName + ".fxml"));
        String name = pageName.replace('-', ' ');
        Scene scene = new Scene(fxmlLoader.load(), Width, Height);
        stage.setTitle(name);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}