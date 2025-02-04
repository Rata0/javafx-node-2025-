module com.example.demopr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.demopr to javafx.fxml;
    exports com.example.demopr;
}