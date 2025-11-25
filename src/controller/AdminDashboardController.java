package controller;

import javafx.fxml.FXMLLoader;
import service.StudentService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class AdminDashboardController {

    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, String> courseColumn;
    @FXML private TableColumn<Student, Integer> semesterColumn;

    private final StudentService studentService = new StudentService();

    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initialize() {
        try {

            // ----- FIX 1: Proper Column Mapping -----
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
            semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));

            // ----- FIX 2: Load Data from Database -----
            List<Student> students = studentService.getAllStudents();

            if (students != null) {
                studentTable.setItems(FXCollections.observableArrayList(students));
            } else {
                System.out.println("Student list is null.");
            }

        } catch (Exception e) {
            System.err.println("Error loading admin dashboard: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
