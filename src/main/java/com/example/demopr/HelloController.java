package com.example.demopr;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML
    private VBox root;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        function();
    }

    public void function() {
        HBox newHBox = new HBox();
        newHBox.setMinWidth(200);
        newHBox.setSpacing(20);
        newHBox.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-padding: 20;");

        VBox leftColumn = new VBox();
        Label labelType = new Label("ТИП | ...");
        Label labelDirector = new Label("Директор ...");
        Label labelPhone = new Label("Телефон ...");
        Label labelRating = new Label("Рейтинг: ...");

        leftColumn.getChildren().addAll(labelType, labelDirector, labelPhone, labelRating);
        newHBox.getChildren().addAll(leftColumn);

        newHBox.setOnMouseClicked(mouseEvent -> {
            System.out.println("CLICK!");
        });

        newHBox.setOnMouseEntered(mouseEvent -> {
            newHBox.setStyle("-fx-background-color: #67BA80; -fx-border-width: 1; -fx-padding: 20;");
        });

        newHBox.setOnMouseExited(mouseEvent -> {
            newHBox.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 1; -fx-padding: 20;");
        });

        root.getChildren().addAll(newHBox);
    }
}