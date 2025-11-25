package controller;

import dao.AttendanceDAO;
import dao.ResultDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Attendance;
import model.Result;

import java.util.List;

public class StudentDashboardController {
    @FXML private TableView<Attendance> attendanceTable;
    @FXML private TableView<Result> resultsTable;

    private AttendanceDAO attendanceDAO = new AttendanceDAO();
    private ResultDAO resultDAO = new ResultDAO();
    @FXML
    private <ActionEvent> void handleLogout(ActionEvent event) {
        // Your logout logic here
        System.out.println("Logout clicked!");
    }

    @FXML
    private void initialize() {
        // Load data for student ID 1 (hardcoded for demo)
        List<Attendance> attendance = attendanceDAO.getByStudent(1);
        attendanceTable.setItems(FXCollections.observableArrayList(attendance));

        List<Result> results = resultDAO.getByStudent(1);
        resultsTable.setItems(FXCollections.observableArrayList(results));
    }

    public void handleLogout(ActionEvent actionEvent) {

    }
}