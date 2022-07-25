package nl.miwgroningen.se.ch9.vincent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.miwgroningen.se.ch9.vincent.controller.LogTimeController;
import nl.miwgroningen.se.ch9.vincent.controller.ShowLogController;
import nl.miwgroningen.se.ch9.vincent.model.TimeLog;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("LogTime"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void loadTimeLog() {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/views/LogTime.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            scene.setRoot(parent);
        } catch (IOException e) {
            System.err.println("Unable to load TimeLog screen");
        }
    }

    public static void showTimeLog(TimeLog timeLog) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/views/ShowLog.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            ShowLogController showLogController = fxmlLoader.getController();
            showLogController.setup(timeLog);
            scene.setRoot(parent);
        } catch (IOException e) {
            System.err.println("Unable to load TimeLog screen");
        }
    }

    public static void main(String[] args) {
        launch();
    }

}