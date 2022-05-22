package com.vai.uxremotecontrol;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;


public class Remote implements NativeMouseListener {
    @FXML
    private Circle button1;
    @FXML
    private Circle button2;
    @FXML
    private GridPane layout;
    @FXML
    private AnchorPane pane;

    @FXML
    protected void onButton1On() {
        button1.setFill(Color.AQUA);
    }
    @FXML
    protected void onButton1Off() {
        button1.setFill(Color.DODGERBLUE);
    }
    @FXML
    private void initialize() throws IOException {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        // Add the appropriate listeners.
        GlobalScreen.addNativeMouseListener(this);
        layout.getRowConstraints().add(new RowConstraints(-1, -1, -1, Priority.ALWAYS, VPos.CENTER, false));
        layout.getColumnConstraints().add(new ColumnConstraints(-1, -1, -1, Priority.ALWAYS, HPos.CENTER, false));
    }

    public void nativeMouseClicked(NativeMouseEvent e) {
        if (e.getButton() == 1) {
            onButton1On();
            setTimeout(() -> onButton1Off(), 100);
        }else{
            onButton2On();
            setTimeout(() -> onButton2Off(), 100);
        }
        System.out.println("Mouse Button "+ e.getButton()+" Clicked: " + e.getClickCount() );
    }

    private void onButton2Off() {
        String image = Main.class.getResource("remote.png").toExternalForm();
        pane.setStyle("-fx-background-image: url(" + image + " )");
        button2.setFill(Color.DODGERBLUE);
    }

    private void onButton2On() {
        String image = Main.class.getResource("remote2.png").toExternalForm();
        pane.setStyle("-fx-background-image: url(" + image + " )");
        button2.setFill(Color.AQUA);
    }

    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    public static void MakeStretchy(GridPane root) {
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100);
        root.getColumnConstraints().add(col);
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(100);
        root.getRowConstraints().add(row);
    }
}
