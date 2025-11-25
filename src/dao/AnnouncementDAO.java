package dao;

import model.Announcement;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDAO {
    public List<Announcement> getAll() {
        List<Announcement> list = new ArrayList<>();
        String query = "SELECT * FROM announcements";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Announcement(rs.getInt("announceID"), rs.getInt("facultyID"), rs.getString("content"), rs.getDate("date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Announcement a) {
        String query = "INSERT INTO announcements (facultyID, content, date) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, a.getFacultyID());
            stmt.setString(2, a.getContent());
            stmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}