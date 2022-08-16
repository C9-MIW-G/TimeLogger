package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.scene.control.ListView;
import nl.miwgroningen.se.ch9.vincent.App;
import nl.miwgroningen.se.ch9.vincent.database.mysql.ProjectDAO;
import nl.miwgroningen.se.ch9.vincent.model.Project;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class ManageProjectsController implements Loadable {
    public ListView<Project> projectListView;

    @Override
    public void load(Object... args) {
        App.getDbAccess().openConnection();
        ProjectDAO projectDAO = new ProjectDAO(App.getDbAccess());
        projectListView.getItems().addAll(projectDAO.getAll());
        App.getDbAccess().closeConnection();
    }

    public void deleteProject() {
        App.getDbAccess().openConnection();
        ProjectDAO projectDAO = new ProjectDAO(App.getDbAccess());
        projectDAO.delete(projectListView.getSelectionModel().getSelectedItem());
        App.getDbAccess().closeConnection();

        App.showManageProjects();
    }

    public void editProject() {
        App.showEditProject(projectListView.getSelectionModel().getSelectedItem());
    }

    public void createProject() {
        App.showCreateProject();
    }


}
