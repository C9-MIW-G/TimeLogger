package nl.miwgroningen.se.ch9.vincent.model;

import java.util.Optional;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Projects to log time for
 */
public class Project {

    private Long projectId;
    private String projectName;
    private String projectCode;

    public Project(Long projectId, String projectName, String projectCode) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCode = projectCode;
    }

    public Project(String projectName, String projectCode) {
        this(null, projectName, projectCode);
    }

    public Optional<Long> getProjectId() {
        if (projectId == null) {
            return Optional.empty();
        }
        return Optional.of(projectId);
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", projectName, projectCode);
    }
}
