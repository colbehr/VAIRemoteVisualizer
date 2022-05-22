package com.vai.uxremotecontrol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application  {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("remote.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Vai Virtual Remote");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch();

    }
}