package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.scene.control.TextField;
import nl.miwgroningen.se.ch9.vincent.App;
import nl.miwgroningen.se.ch9.vincent.database.mysql.ProjectDAO;
import nl.miwgroningen.se.ch9.vincent.model.Project;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class ProjectController implements Loadable {
    public TextField projectNameField;
    public TextField projectCodeField;

    private Project project = null;

    @Override
    public void load(Object... args) {
        if (args.length > 0) {
            if (args[0] instanceof Project) {
                project = (Project) args[0];
                projectNameField.setText(project.getProjectName());
                projectCodeField.setText(project.getProjectCode());
            }
        }
    }


    public void cancel() {
        App.showManageProjects();
    }

    public void saveProject() {
        if (project == null) {
            project = new Project(projectNameField.getText(), projectCodeField.getText());
        } else {
            project.setProjectName(projectNameField.getText());
            project.setProjectCode(projectCodeField.getText());
        }

        App.getDbAccess().openConnection();
        ProjectDAO projectDAO = new ProjectDAO(App.getDbAccess());
        projectDAO.save(project);
        App.getDbAccess().closeConnection();

        App.showManageProjects();
    }
}
