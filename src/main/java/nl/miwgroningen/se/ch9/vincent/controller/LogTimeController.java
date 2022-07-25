package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Controller voor de pagina waarop log gestart en gestopt worden
 */
public class LogTimeController {

    private TimeLog timeLog = null;
    @FXML private Label previousLog;

    public void toggleLog(ActionEvent actionEvent) {
        if (timeLog == null) {
            timeLog = new TimeLog();
        } else {
            String event = "test";
            timeLog.endLog(event);
            previousLog.setText(timeLog.toString());
            timeLog = null;
        }
    }
}
