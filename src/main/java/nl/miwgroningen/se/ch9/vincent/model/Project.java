package nl.miwgroningen.se.ch9.vincent.model;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Projects to log time for
 */
public class Project {

    private Optional<Long> projectId;
    private String projectName;
    private String projectCode;

    public Project(Long projectId, String projectName, String projectCode) {
        this.projectId = Optional.of(projectId);
        this.projectName = projectName;
        this.projectCode = projectCode;
    }

    public Project(String projectName, String projectCode) {
        this(null, projectName, projectCode);
    }

    public Optional<Long> getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = Optional.of(projectId);
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }
}
