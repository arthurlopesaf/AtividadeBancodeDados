module org.example.registrochamados {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens org.example.registrochamados to javafx.fxml;
    exports org.example.registrochamados;
}