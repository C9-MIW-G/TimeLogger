package nl.miwgroningen.se.ch9.vincent.database.mysql;

import nl.miwgroningen.se.ch9.vincent.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Read and write projects to/from DB
 */
public class ProjectDAO extends AbstractDAO {

    public ProjectDAO(DBAccess dbAccess) {
        super(dbAccess);
    }

    public void save(Project project) {
        String sql = "INSERT INTO project (projectname, projectcode) VALUES (?, ?);";

        try {
            setupPreparedStatementWithKey(sql);

            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getProjectCode());

            long projectId = executeInsertStatementWithKey();

            project.setProjectId(projectId);
        } catch (SQLException sqlException) {
            sqlErrorMessage(sqlException);
        }
    }

    public Optional<Project> get(long projectId) {
        String sql = "SELECT projectid, projectname, projectcode FROM project WHERE projectid = ?;";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setLong(1, projectId);
            ResultSet resultSet = executeSelectStatement();
            if (resultSet.first()) {
                return Optional.of(get(resultSet));
            }
        } catch (SQLException sqlException) {
            sqlErrorMessage(sqlException);
        }
        return Optional.empty();
    }

    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT projectid, projectname, projectcode FROM project;";

        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                projects.add(get(resultSet));
            }
        } catch (SQLException sqlException) {
            sqlErrorMessage(sqlException);
        }

        return projects;
    }

    private Project get(ResultSet resultSet) throws SQLException {
        long projectId = resultSet.getLong("projectid");
        String projectName = resultSet.getString("projectname");
        String projectCode = resultSet.getString("projectcode");
        return new Project(projectId, projectName, projectCode);
    }

}
