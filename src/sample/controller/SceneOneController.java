package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.repository.Database;
import sample.model.Student;

import java.io.IOException;

public class SceneOneController {
    @FXML
    public Label status;
    @FXML
    private TextField emailField;
    @FXML
    private Button registerButton;
    @FXML
    private Button viewListButton;
    private Stage stage = null;


    public void registerButtonActionHandler(ActionEvent actionEvent) {
        if (emailField.getText().isEmpty()) {
            status.setText("email cannot be empty");
            status.setText("");
        } else if (!emailField.getText().matches("^(.+)@(.+)$")) {
            status.setText("invalid email pattern");
        } else {
            Student student = new Student();
            student.setEmail(emailField.getText());
            if (!Database.getStudentList().contains(emailField.getText())) {
                Database.getStudentList().add(student.toString());
                status.setText("student registered successfully!!!");
                try {
                    Parent root = FXMLLoader.load(SceneTwoController.class.getResource("sceneTwo.fxml"));
                    stage = (Stage) registerButton.getScene().getWindow();
                    stage.setScene(new Scene(root, 750, 500));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                status.setText("student already registered!!!");
                return;
            }
        }
    }

    public void viewListButtonActionHandler(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(SceneTwoController.class.getResource("sceneTwo.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage) viewListButton.getScene().getWindow();
        stage.setScene(new Scene(root, 750, 500));
        stage.show();
    }
}
