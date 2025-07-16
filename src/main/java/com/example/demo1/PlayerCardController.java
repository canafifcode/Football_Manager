package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class PlayerCardController {

    @FXML
    private AnchorPane playerContainer;

    public void loadPlayersForTeam(String teamName) {
        Player playerLoader = new Player("", "", "", "", null, 0);
        List<Player> players = playerLoader.loadPlayersForTeam(teamName);

        if (playerContainer == null) {
            System.out.println("playerContainer is not initialized!");
            return;
        }

        playerContainer.getChildren().clear();

        if (players.isEmpty()) {
            Label noPlayersLabel = new Label("No players found for team: " + teamName);
            noPlayersLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
            AnchorPane.setTopAnchor(noPlayersLabel, 10.0);
            AnchorPane.setLeftAnchor(noPlayersLabel, 10.0);
            playerContainer.getChildren().add(noPlayersLabel);
            return;
        }

        double yOffset = 10.0; // Initial vertical offset
        for (Player player : players) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("playerCard.fxml"));
                AnchorPane card = loader.load();
                PlayerCardItemController itemController = loader.getController();
                itemController.setPlayerData(player);

                // Position the card in the playerContainer
                AnchorPane.setTopAnchor(card, yOffset);
                AnchorPane.setLeftAnchor(card, 10.0);
                playerContainer.getChildren().add(card);

                // Increment yOffset for the next card (card height + spacing)
                yOffset += card.getPrefHeight() + 10.0; // 10px spacing between cards
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error loading playerCard.fxml for player: " + player.getName());
            }
        }
    }

    @FXML
    public void goBack(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage = (Stage) playerContainer.getScene().getWindow();
        Scene scene = new Scene(root, 1620, 800, Color.DARKGREY);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
    }
}