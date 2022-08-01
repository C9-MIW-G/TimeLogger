package nl.miwgroningen.se.ch9.vincent.database.mysql;

import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO timeLog (event, startTime, endTime) VALUES (?, ? ,?);";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, timeLog.getEvent());
            preparedStatement.setObject(2, timeLog.getStartTime());
            preparedStatement.setObject(3, timeLog.getEndTime());
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            sqlErrorMessage(sqlException);
        }
    }

    public List<TimeLog> getTimeLogs() {
        List<TimeLog> timeLogs = new ArrayList<>();

        String sql = "SELECT event, startTime, endTime FROM timelog;";
        try {
            setupPreparedStatement(sql);
            try (ResultSet resultSet = executeSelectStatement()) {
                while (resultSet.next()) {
                    String event = resultSet.getString(1);
                    LocalDateTime startTime = resultSet.getObject(2, LocalDateTime.class);
                    LocalDateTime endTime = resultSet.getObject(3, LocalDateTime.class);

                    timeLogs.add(new TimeLog(event, startTime, endTime));
                }
            }
        } catch (SQLException sqlException) {
            sqlErrorMessage(sqlException);
        }

        return timeLogs;
    }

}
