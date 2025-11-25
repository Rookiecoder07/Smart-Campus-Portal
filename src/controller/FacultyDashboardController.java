package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Student;
import util.DBUtil;

import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

public class FacultyDashboardController {

    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, Integer> colId;
    @FXML private TableColumn<Student, String> colName;
    @FXML private TableColumn<Student, String> colCourse;
    @FXML private TableColumn<Student, Integer> colSemester;

    @FXML
    public void initialize() {
        setupColumns();
        loadStudents();
    }

    private void setupColumns() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        colSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));
    }

    private void loadStudents() {
        ObservableList<Student> students = FXCollections.observableArrayList();

        try {
            Connection conn = DBUtil.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("studentID"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getInt("semester")
                ));
            }

            studentTable.setItems(students);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
