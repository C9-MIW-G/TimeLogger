package nl.miwgroningen.se.ch9.vincent.database.mysql;

import nl.miwgroningen.se.ch9.vincent.model.Project;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Read and write TimeLogs to/from DB
 */
public class TimeLogDAO extends AbstractDAO {

    public TimeLogDAO(DBAccess dbAccess) {
        super(dbAccess);
    }

    public void save(TimeLog timeLog) {
        String sql = "INSERT INTO timeLog (event, projectid, startTime, endTime) VALUES (?, ? ,?, ?);";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, timeLog.getEvent());
            if (timeLog.getProject() != null && timeLog.getProject().getProjectId().isPresent()) {
                preparedStatement.setLong(2, timeLog.getProject().getProjectId().get());
            } else {
                preparedStatement.setObject(2, null);
            }
            preparedStatement.setObject(3, timeLog.getStartTime());
            preparedStatement.setObject(4, timeLog.getEndTime());
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            sqlErrorMessage(sqlException);
        }
    }

    public List<TimeLog> getTimeLogs() {
        List<TimeLog> timeLogs = new ArrayList<>();

        String sql = "SELECT startTime, endTime, projectid, event FROM timelog;";
        try {
            setupPreparedStatement(sql);
            try (ResultSet resultSet = executeSelectStatement()) {
                while (resultSet.next()) {
                    LocalDateTime startTime = resultSet.getObject(1, LocalDateTime.class);
                    LocalDateTime endTime = resultSet.getObject(2, LocalDateTime.class);

                    long projectId = resultSet.getLong(3);
                    ProjectDAO projectDAO = new ProjectDAO(dbAccess);
                    Optional<Project> project = projectDAO.get(projectId);
                    if (project.isPresent()) {
                        timeLogs.add(new TimeLog(project.get(), startTime, endTime));
                    } else {
                        String event = resultSet.getString(4);
                        timeLogs.add(new TimeLog(event, startTime, endTime));
                    }
                }
            }
        } catch (SQLException sqlException) {
            sqlErrorMessage(sqlException);
        }

        return timeLogs;
    }

}
