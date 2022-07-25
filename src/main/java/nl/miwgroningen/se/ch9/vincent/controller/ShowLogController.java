package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.scene.control.Label;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class ShowLogController {
    public Label startTime;
    public Label endTime;

    public void setup(TimeLog timeLog) {
        startTime.setText(timeLog.getStartTime().format(TimeLog.timeFormatter));
        endTime.setText(timeLog.getEndTime().format(TimeLog.timeFormatter));
    }
}
