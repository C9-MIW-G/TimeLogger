package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.scene.control.Label;
import nl.miwgroningen.se.ch9.vincent.App;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class ShowLogController implements Loadable {
    public Label startTime;
    public Label endTime;

    public void load(Object... args) {
        if (args.length < 1 || !(args[0] instanceof TimeLog)) {
            throw new IllegalArgumentException("Expected TimeLog object");
        }
        var timeLog = (TimeLog) args[0];
        startTime.setText(timeLog.getStartTime().format(TimeLog.timeFormatter));
        endTime.setText(timeLog.getEndTime().format(TimeLog.timeFormatter));
    }

    public void toLogScene() {
        App.showLogTime();
    }

    public void toLogHistoryScene() {
        App.showLogHistory();
    }
}
