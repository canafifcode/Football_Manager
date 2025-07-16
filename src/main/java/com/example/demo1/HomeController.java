package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1620, 800, Color.DARKGREY);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1620, 800, Color.DARKGREY);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void switchToSignUp(ActionEvent event) {
        try {
            URL fxmlLocation = getClass().getResource("signup.fxml");
            if (fxmlLocation == null) {
                System.out.println("signup.fxml not found!");
                return;
            }
            URL imageLocation = getClass().getResource("bg.jpg");
            if (imageLocation == null) {
                System.out.println("bg.jpg not found!");
                return;
            }
            root = FXMLLoader.load(fxmlLocation);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root, 1620, 800, Color.DARKGREY);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1620, 800, Color.DARKGREY);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
    }
}