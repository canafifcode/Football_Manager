package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerCardItemController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label positionLabel;

    @FXML
    private Label overallLabel;

    @FXML
    private Label statsLabel;

    public void setPlayerData(Player player) {
        nameLabel.setText(player.getName());
        positionLabel.setText(player.getPosition());
        overallLabel.setText("Overall: " + player.getOverall());
        StringBuilder statsText = new StringBuilder("Stats: ");
        player.getStats().forEach((key, value) -> statsText.append(key).append(": ").append(value).append(", "));
        statsLabel.setText(statsText.toString().replaceAll(", $", ""));
    }
}