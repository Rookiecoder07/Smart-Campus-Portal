package dao;

import model.Feedback;
import util.DBUtil;
import java.sql.*;

public class FeedbackDAO {
    public void insert(Feedback f) {
        String query = "INSERT INTO feedback (studentID, message, submittedOn) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, f.getStudentID());
            stmt.setString(2, f.getMessage());
            // Feedback#getSubmittedOn() is not defined; use current date instead
            stmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}