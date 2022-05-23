package com.vai.uxremotecontrol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application  {
    private double x, y;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("remote.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Vai Virtual Remote");

        //make the frame draggable and undecorated
        stage.initStyle(StageStyle.UNDECORATED);
        ((Parent)fxmlLoader.getRoot()).setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        ((Parent)fxmlLoader.getRoot()).setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        //set logo
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("vaiLogo.png")));

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}