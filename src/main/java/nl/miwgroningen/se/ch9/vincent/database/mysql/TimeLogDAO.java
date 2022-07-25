package nl.miwgroningen.se.ch9.vincent.database.mysql;

import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

import java.sql.SQLException;
import java.sql.Time;

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
        String sql = "INSERT INTO timeLog (event, startTime, endTime) VALUES (?, ? ,?)";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, timeLog.getEvent());
            preparedStatement.setTime(2, Time.valueOf(timeLog.getStartTime().toLocalTime()));
            preparedStatement.setTime(3, Time.valueOf(timeLog.getEndTime().toLocalTime()));
            executeManipulateStatement();
        } catch (SQLException sqlException) {
            System.err.println("An error occurred in SQL: " + sqlException.getMessage());
        }
    }

}
