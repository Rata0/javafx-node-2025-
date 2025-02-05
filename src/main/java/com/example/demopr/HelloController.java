package com.example.demopr;

import com.example.demopr.dao.SupplierDAO;
import com.example.demopr.model.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HelloController {
    @FXML
    private VBox root;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        SupplierDAO supplierDAO = new SupplierDAO(connection);
        List<Supplier> suppliers = supplierDAO.getAllSupplier();

        for (Supplier supplier : suppliers) {
            renderSupplier(supplier);
        }

    }

    public void renderSupplier(Supplier supplier) {
        HBox newHBox = new HBox();
        newHBox.setMinWidth(200);
        newHBox.setSpacing(20);
        newHBox.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-padding: 20;");

        VBox leftColumn = new VBox();

        Label labelType = new Label(supplier.getType());
        Label labelDirector = new Label(supplier.getDirector());
        Label labelPhone = new Label(supplier.getPhone());
        Label labelRating = new Label(String.valueOf(supplier.getRating()));

        leftColumn.getChildren().addAll(labelType, labelDirector, labelPhone, labelRating);
        newHBox.getChildren().addAll(leftColumn);

        newHBox.setOnMouseClicked(mouseEvent -> {
            System.out.println("CLICK!");
        });

        newHBox.setOnMouseEntered(mouseEvent -> {
            newHBox.setStyle("-fx-background-color: #67BA80; -fx-border-color: black; -fx-border-width: 1; -fx-padding: 20;");
        });

        newHBox.setOnMouseExited(mouseEvent -> {
            newHBox.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 1; -fx-padding: 20;");
        });

        root.getChildren().addAll(newHBox);
    }
}