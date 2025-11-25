package dao;

import model.Attendance;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
    public List<Attendance> getByStudent(int studentID) {
        List<Attendance> list = new ArrayList<>();
        String query = "SELECT * FROM attendance WHERE studentID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Attendance(rs.getInt("attendanceID"), rs.getInt("studentID"), rs.getDate("date"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}