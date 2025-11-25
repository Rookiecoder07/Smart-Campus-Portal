package dao;

import model.Student;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insert(Student s) {
        String query = "INSERT INTO students (name, course, semester, userID) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, s.getName());
            stmt.setString(2, s.getCourse());
            stmt.setInt(3, s.getSemester());
            stmt.setInt(4, s.getId()); // userID = student user id
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("studentID"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getInt("semester")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
