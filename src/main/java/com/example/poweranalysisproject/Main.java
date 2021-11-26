package com.example.poweranalysisproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    static final int HEIGHT = 400;
    static final int WIDTH = 600;
    static Report currReport;

    static UserProfile currUser;

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        startApp(stage);
    }

    public static void startApp(Stage stage) throws IOException {
        Main.stage = stage;
        currReport = null;
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

    ////// Trying out overloading the navNewPage method
    public static void navigateToNewPage(String pageName, Report newCurrReport) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(pageName + ".fxml"));
        String name = toUpperCase(pageName.replace('-', ' '));
        ///////
        currReport = newCurrReport;
        ///////
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle(name);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void navigateToNewPage(String pageName, UserProfile user) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(pageName + ".fxml"));
        String name = toUpperCase(pageName.replace('-', ' '));

        ///////
        currUser = user;

        ///////
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle(name);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        PowerAnalysisActiveController controller = fxmlLoader.getController();
        controller.updateData("start");

        stage.show();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                controller.updateData(Math.random() + "");
            }
        }, 0,1000);

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