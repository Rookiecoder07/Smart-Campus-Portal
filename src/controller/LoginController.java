package controller;

import dao.UserDAO;
import exception.InvalidLoginException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.User;
import model.Student;

public class LoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private UserDAO userDAO = new UserDAO();

    @FXML
    public void handleLogin(ActionEvent event) {

        try {
            String email = emailField.getText();
            String password = passwordField.getText();

            // 🔹 Input validation
            if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
                throw new InvalidLoginException("Email and Password cannot be empty");
            }

            // 🔹 Authenticate user
            User user = userDAO.authenticate(email, password);

            if (user == null) {
                throw new InvalidLoginException("Invalid email or password");
            }

            // 🔹 Load dashboard
            loadDashboard(user);

        } catch (InvalidLoginException e) {
            errorLabel.setText(e.getMessage());
        } catch (Exception e) {
            errorLabel.setText("System error. Please try again.");
            e.printStackTrace();
        }
    }

    // 🔹 Dashboard loader (clean separation)
    private void loadDashboard(User user) throws Exception {

        Stage stage = (Stage) emailField.getScene().getWindow();
        Scene scene;

        if (user instanceof Student) {
            scene = new Scene(
                FXMLLoader.load(getClass().getResource("/view/StudentDashboard.fxml"))
            );
        } else if ("admin".equalsIgnoreCase(user.getRole())) {
            scene = new Scene(
                FXMLLoader.load(getClass().getResource("/view/AdminDashboard.fxml"))
            );
        } else if ("faculty".equalsIgnoreCase(user.getRole())) {
            scene = new Scene(
                FXMLLoader.load(getClass().getResource("/view/FacultyDashboard.fxml"))
            );
        } else {
            throw new InvalidLoginException("Unauthorized role");
        }

        stage.setScene(scene);
        stage.show();
    }
}
