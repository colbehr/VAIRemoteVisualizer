package com.vai.uxremotecontrol;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;

import javafx.fxml.FXML;
import javafx.scene.layout.*;

import java.io.IOException;


public class Remote implements NativeMouseListener, NativeKeyListener {
    @FXML
    private GridPane pane;

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
        GlobalScreen.addNativeKeyListener(this);
        GlobalScreen.addNativeMouseListener(this);
    }

    //mouse events
    public void nativeMousePressed(NativeMouseEvent e) {
        //mouse 1 is button 1 mouse 2 is button 2
        if (e.getButton() == 1) {
            button1On();
//            setTimeout(() -> mainBackground(), 100);
        }else if (e.getButton() == 2){
            button2On();
//            setTimeout(() -> mainBackground(), 100);
        }
    }

    //mouse events
    public void nativeMouseReleased(NativeMouseEvent e) {
        //mouse 1 is button 1 mouse 2 is button 2
        if (e.getButton() == 1) {
            mainBackground();
//            setTimeout(() -> mainBackground(), 100);

        }else if (e.getButton() == 2){
            mainBackground();
//            setTimeout(() -> mainBackground(), 100);
        }
    }


    //keyboard events
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getRawCode());
        /* ------
        Utility buttons
        ------ */

        //bind x to close
        if(e.getRawCode() == 88){
            System.exit(1);
        }

        //bind + and - (not numpad) to resize screen
        if(e.getRawCode() == 187){
            System.out.println("Scale Screen Up");
            pane.setPrefWidth(pane.getWidth()*1.3);
            pane.setPrefHeight(pane.getWidth()*1.3);
            pane.getScene().getWindow().setHeight(pane.getHeight()*1.3);
            pane.getScene().getWindow().setWidth(pane.getWidth()*1.3);
        } else if(e.getRawCode() == 189){
            System.out.println("Scale Screen Down");
            pane.setPrefWidth(pane.getWidth()/1.3);
            pane.setPrefHeight(pane.getWidth()/1.3);
            pane.getScene().getWindow().setHeight(pane.getHeight()/1.3);
            pane.getScene().getWindow().setWidth(pane.getWidth()/1.3);
        }
        /* ------
        Remote buttons
        ------ */

        //bind mic to space
        if(e.getRawCode() == 32){
            micButtonOn();
//            setTimeout(() -> mainBackground(), 100);
        }
        //bind sensors to s
        if(e.getRawCode() == 83){
            sensorsOn();
//            setTimeout(() -> mainBackground(), 100);
        }
    }
    //keyboard events
    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + e.getRawCode());
        /* ------
        Remote buttons
        ------ */

        //bind mic to space
        if(e.getRawCode() == 32){
            mainBackground();
        }
        //bind sensors to s
        if(e.getRawCode() == 83){
            mainBackground();
        }
    }

    private void mainBackground() {
        String image = Main.class.getResource("vai.jpg").toExternalForm();
        pane.setStyle("-fx-background-image: url(" + image + " )");
    }
    private void button2On() {
        String image = Main.class.getResource("vai-home.jpg").toExternalForm();
        pane.setStyle("-fx-background-image: url(" + image + " )");
    }

    private void button1On() {
        String image = Main.class.getResource("vai-ok.jpg").toExternalForm();
        pane.setStyle("-fx-background-image: url(" + image + " )");
    }

    private void micButtonOn() {
        String image = Main.class.getResource("vai-mic.jpg").toExternalForm();
        pane.setStyle("-fx-background-image: url(" + image + " )");
    }

    private void sensorsOn() {
        String image = Main.class.getResource("vai.jpg").toExternalForm();
        pane.setStyle("-fx-background-image: url(" + image + " )");
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


}
