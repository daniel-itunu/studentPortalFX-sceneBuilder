package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.SceneOneController;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(SceneOneController.class.getResource("sceneOne.fxml"));
        primaryStage.setTitle("Registration portal");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
    }
}
