package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import nl.miwgroningen.se.ch9.vincent.App;
import nl.miwgroningen.se.ch9.vincent.database.mysql.ProjectDAO;
import nl.miwgroningen.se.ch9.vincent.database.mysql.TimeLogDAO;
import nl.miwgroningen.se.ch9.vincent.model.Project;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Controller voor de pagina waarop log gestart en gestopt worden
 */
public class LogTimeController implements Loadable {


    public ChoiceBox<Project> projectDropdown;
    private TimeLog timeLog = null;
    @FXML
    private TextField eventField;
    @FXML
    private Button toggleLog;

    public void toggleLog(ActionEvent actionEvent) {
        if (timeLog == null) {
            timeLog = new TimeLog();
            toggleLog.setText("Stop Log");
        } else {
            if (projectDropdown.getSelectionModel().isEmpty()) {
                timeLog.endLog(eventField.getText());
            } else {
                timeLog.endLog(projectDropdown.getSelectionModel().getSelectedItem());
            }

            App.getDbAccess().openConnection();
            TimeLogDAO timeLogDAO = new TimeLogDAO(App.getDbAccess());
            timeLogDAO.save(timeLog);
            App.getDbAccess().closeConnection();

            App.showTimeLog(timeLog);
        }
    }

    @Override
    public void load(Object... args) {
        App.getDbAccess().openConnection();
        ProjectDAO projectDAO = new ProjectDAO(App.getDbAccess());
        projectDropdown.getItems().addAll(projectDAO.getAll());
        App.getDbAccess().closeConnection();
    }
}
