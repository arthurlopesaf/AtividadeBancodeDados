module com.example.telita {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.telita to javafx.fxml;
    exports com.example.telita;
}