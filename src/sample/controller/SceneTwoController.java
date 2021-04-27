package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.repository.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneTwoController implements Initializable {

    @FXML
    private ListView<String> listView;

    @FXML
    private Button removeButton;

    @FXML
    private Button backButton;

    private Stage stage = null;

    public void removeButtonActionHandler(ActionEvent actionEvent) throws IOException {
        if (Database.getStudentList().size() > 0) {
            Object obj = listView.getSelectionModel().getSelectedItem();
            Database.getStudentList().remove(obj);
            Parent root = null;
            try {
                root = FXMLLoader.load(SceneTwoController.class.getResource("sceneTwo.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = (Stage) removeButton.getScene().getWindow();
            stage.setScene(new Scene(root, 750, 500));
            stage.show();
        } else {
            Dialog<String> dialog = new Dialog();
            dialog.setTitle("message");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("No student data available");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
    }

    public void backButtonActionHandler(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(SceneOneController.class.getResource("sceneOne.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(new Scene(root, 750, 500));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setAlignment(Pos.TOP_LEFT);
        listView.getItems().addAll(Database.getStudentList());
    }
}
