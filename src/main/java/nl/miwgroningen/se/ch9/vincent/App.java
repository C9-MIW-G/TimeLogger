package nl.miwgroningen.se.ch9.vincent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nl.miwgroningen.se.ch9.vincent.controller.Loadable;
import nl.miwgroningen.se.ch9.vincent.controller.LogHistoryController;
import nl.miwgroningen.se.ch9.vincent.controller.MenuController;
import nl.miwgroningen.se.ch9.vincent.controller.ShowLogController;
import nl.miwgroningen.se.ch9.vincent.database.mysql.DBAccess;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

import java.io.IOException;
import java.util.Arrays;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static DBAccess dbAccess = null;

    @Override
    public void start(Stage stage) {
        scene = new Scene(new BorderPane(), 640, 480);
        stage.setScene(scene);
        stage.show();

        loadScene("LogTime");
    }

    static void loadScene(String fxml, Object... args) {
        var borderPane = new BorderPane();

        borderPane.setTop(MenuController.getMenu());

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/views/" + fxml + ".fxml"));
        Parent fxmlParent;
        try {
            fxmlParent = fxmlLoader.load();

            if (fxmlLoader.getController() instanceof Loadable) {
                Loadable loadableController = fxmlLoader.getController();
                loadableController.load(args);
            }

            borderPane.setCenter(fxmlParent);
        } catch (IOException e) {
            System.err.printf("Unable to load FXML: %s with arguments: %S%n",
                    fxml, Arrays.toString(args));
        }

        scene.setRoot(borderPane);
    }

    public static void showLogTime() {
        loadScene("LogTime");
    }

    public static void showTimeLog(TimeLog timeLog) {
        loadScene("ShowLog", timeLog);
    }

    public static void showLogHistory() {
        loadScene("LogHistory");
    }

    public static DBAccess getDbAccess() {
        if (dbAccess == null) {
            dbAccess = new DBAccess("TimeLogger", "userTimeLogger", "pwTimeLogger");
        }
        return dbAccess;
    }

    public static void main(String[] args) {
        launch();
    }

}