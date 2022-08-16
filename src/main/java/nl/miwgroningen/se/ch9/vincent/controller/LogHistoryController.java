package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import nl.miwgroningen.se.ch9.vincent.App;
import nl.miwgroningen.se.ch9.vincent.database.mysql.TimeLogDAO;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Show a history of all logs
 */
public class LogHistoryController implements Loadable {

    public ListView<TimeLog> logHistoryListView;

    public void load(Object... args) {
        App.getDbAccess().openConnection();
        TimeLogDAO timeLogDAO = new TimeLogDAO(App.getDbAccess());
        logHistoryListView.getItems().addAll(timeLogDAO.getTimeLogs());
        App.getDbAccess().closeConnection();
    }

    public void goToLogTime(ActionEvent actionEvent) {
        App.showLogTime();
    }
}
