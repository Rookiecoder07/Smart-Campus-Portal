package dao;

import model.Result;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {
    public List<Result> getByStudent(int studentID) {
        List<Result> list = new ArrayList<>();
        String query = "SELECT * FROM results WHERE studentID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Result(rs.getInt("resultID"), rs.getInt("studentID"), rs.getString("subject"), rs.getInt("marks")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertMultiple(List<Result> results) {
        String query = "INSERT INTO results (studentID, subject, marks) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                for (Result r : results) {
                    stmt.setInt(1, r.getStudentID());
                    stmt.setString(2, r.getSubject());
                    stmt.setInt(3, r.getMarks());
                    stmt.addBatch();
                }
                stmt.executeBatch();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}