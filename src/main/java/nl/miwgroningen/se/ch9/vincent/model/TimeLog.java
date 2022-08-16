package nl.miwgroningen.se.ch9.vincent.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Keep track of what I worked on and for how long
 */
public class TimeLog {
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private String event = null;
    private Project project = null;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeLog(String event, LocalDateTime startTime, LocalDateTime endTime) {
        this.event = event;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeLog(Project project, LocalDateTime startTime, LocalDateTime endTime) {
        this.project = project;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeLog() {
        this((String) null, LocalDateTime.now(), null);
    }

    public void endLog(String event) {
        this.event = event;
        endLog();
    }

    public void endLog(Project project) {
        this.project = project;
        endLog();
    }

    private void endLog() {
        this.endTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("event: %s\nstartTime: %s, endTime: %s",
                project != null ? project : this.event,
                this.startTime.format(timeFormatter), this.endTime.format(timeFormatter));
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getEvent() {
        return event;
    }

    public Project getProject() {
        return project;
    }
}
