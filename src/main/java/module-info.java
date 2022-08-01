module nl.miwgroningen.se.ch9.vincent {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens nl.miwgroningen.se.ch9.vincent.controller to javafx.fxml;
    exports nl.miwgroningen.se.ch9.vincent;
    exports nl.miwgroningen.se.ch9.vincent.model;
    exports nl.miwgroningen.se.ch9.vincent.database.mysql;
}
