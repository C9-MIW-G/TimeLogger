package nl.miwgroningen.se.ch9.vincent.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

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

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    public String printableDuration() {
        Duration duration = getDuration();
        return String.format("%d:%02d:%02d",
                duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
    }

    @Override
    public String toString() {
        return String.format("event: %s (duration: %s)\nstartTime: %s, endTime: %s",
                project != null ? project : this.event,
                printableDuration(),
                this.startTime.format(timeFormatter),
                this.endTime.format(timeFormatter));
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
