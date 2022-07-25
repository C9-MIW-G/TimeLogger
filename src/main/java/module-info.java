module nl.miwgroningen.se.ch9.vincent {
    requires javafx.controls;
    requires javafx.fxml;

    opens nl.miwgroningen.se.ch9.vincent.controller to javafx.fxml;
    exports nl.miwgroningen.se.ch9.vincent;
}
