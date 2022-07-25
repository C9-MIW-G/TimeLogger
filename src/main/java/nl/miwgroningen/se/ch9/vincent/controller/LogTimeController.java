package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nl.miwgroningen.se.ch9.vincent.App;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Controller voor de pagina waarop log gestart en gestopt worden
 */
public class LogTimeController {


    private TimeLog timeLog = null;
    @FXML
    private TextField eventField;
    @FXML
    private Button toggleLog;
    @FXML
    private Label previousLog;

    public void toggleLog(ActionEvent actionEvent) {
        if (timeLog == null) {
            timeLog = new TimeLog();
            toggleLog.setText("Stop Log");
        } else {
            timeLog.endLog(eventField.getText());

//            previousLog.setText(timeLog.toString());
//            timeLog = null;
//            toggleLog.setText("Start Log");
            App.showTimeLog(timeLog);
        }
    }
}
