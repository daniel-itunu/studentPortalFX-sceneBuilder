package sample.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public final class Database {
    public static ObservableList<String> studentList = FXCollections.observableArrayList();

    public static List<String> getStudentList() {
        return studentList;
    }
}
