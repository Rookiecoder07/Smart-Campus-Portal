package dao;

import model.Faculty;
import util.DBUtil;
import java.sql.*;

public class FacultyDAO {
    public void insert(Faculty f) {
        String query = "INSERT INTO faculty (name, department, userID) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, f.getName());
            stmt.setString(2, f.getDepartment());
            stmt.setInt(3, f.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}