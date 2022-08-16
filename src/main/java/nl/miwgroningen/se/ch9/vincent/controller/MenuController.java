package nl.miwgroningen.se.ch9.vincent.controller;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import nl.miwgroningen.se.ch9.vincent.App;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Create manu and handle its functions
 */
public class MenuController {

    public static MenuBar getMenu() {
        var projectMenu = new Menu("Project");
        var manageProjectsMenuItem = new MenuItem("Manage projects");
        manageProjectsMenuItem.setOnAction((actionEvent -> App.showManageProjects()));
        projectMenu.getItems().addAll(manageProjectsMenuItem);

        var createLogMenuItem = new MenuItem("Create new log");
        createLogMenuItem.setOnAction((actionEvent) -> App.showLogTime());
        var logHistoryMenuItem = new MenuItem("Log history");
        logHistoryMenuItem.setOnAction((actionEvent) -> App.showLogHistory());
        var logMenu = new Menu("Log");
        logMenu.getItems().addAll(createLogMenuItem, logHistoryMenuItem);

        return new MenuBar(logMenu, projectMenu);
    }
}
