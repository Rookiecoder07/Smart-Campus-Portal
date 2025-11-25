package controller;

import dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.User;
import model.Student;

public class LoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private UserDAO userDAO = new UserDAO();

    @FXML
    private void handleLogin(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        User user = userDAO.authenticate(email, password);

        if (user != null) {

            try {
                Stage stage = (Stage) emailField.getScene().getWindow(); // current stage

                if (user instanceof Student) {
                    // Load student dashboard
                    Scene scene = new Scene(
                        FXMLLoader.load(getClass().getResource("/view/StudentDashboard.fxml"))
                    );
                    stage.setScene(scene);
                    stage.show();
                } 
               else if ("admin".equals(user.getRole())) {
    Scene scene = new Scene(
        FXMLLoader.load(getClass().getResource("/view/AdminDashboard.fxml"))
    );
    stage.setScene(scene);
    stage.show();
}
else if ("faculty".equals(user.getRole())) {
    Scene scene = new Scene(
        FXMLLoader.load(getClass().getResource("/view/FacultyDashboard.fxml"))
    );
    stage.setScene(scene);
    stage.show();
}



            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
        else {
            errorLabel.setText("Invalid credentials");
        }
    }
}
