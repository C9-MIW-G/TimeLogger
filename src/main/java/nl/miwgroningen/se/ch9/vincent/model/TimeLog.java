package nl.miwgroningen.se.ch9.vincent.model;

import java.time.LocalDateTime;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Keep track of what I worked on and for how long
 */
public class TimeLog {
    private String event;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeLog() {
        this.event = null;
        this.startTime = LocalDateTime.now();
        this.endTime = null;
    }

    public void endLog(String event) {
        this.event = event;
        this.endTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("event: %s\nstartTime: %s, endTime: %s", this.event, this.startTime, this.endTime);
    }
}
