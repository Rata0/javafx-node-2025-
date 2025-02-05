module com.example.demopr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires static lombok;

    opens com.example.demopr to javafx.fxml;
    exports com.example.demopr;
}