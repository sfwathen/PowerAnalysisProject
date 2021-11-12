package com.example.poweranalysisproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static final int HEIGHT = 400;
    static final int WIDTH = 600;

    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        startApp(stage);
    }

    public static void startApp(Stage stage) throws IOException {
        Main.stage = stage;
        navigateToNewPage("log-in");
    }

    public static void navigateToNewPage(String pageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(pageName + ".fxml"));
        String name = toUpperCase(pageName.replace('-', ' '));

        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle(name);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static String toUpperCase(String name)
    {
        String[] words = name.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++)
        {
            result += words[i].substring(0,1).toUpperCase() + words[i].substring(1) + " ";
        }

        return result.substring(0, result.length()-1);
    }

    public static void main(String[] args) {
        launch();
    }
}