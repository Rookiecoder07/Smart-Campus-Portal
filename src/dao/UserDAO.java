package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Admin;
import model.Faculty;
import model.Student;
import model.User;
import util.DBUtil;

public class UserDAO {

    public static User authenticate(String email, String password) {

        String query = "SELECT * FROM users WHERE email=? AND password=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                String role = rs.getString("role");
                int userID = rs.getInt("id");

                // =================== STUDENT ===================
                if (role.equals("student")) {

                    String sQuery = "SELECT * FROM students WHERE userID=?";
                    PreparedStatement ps = conn.prepareStatement(sQuery);
                    ps.setInt(1, userID);

                    ResultSet rs2 = ps.executeQuery();

                    if (rs2.next()) {
                        return new Student(
                                rs2.getInt("studentID"),
                                rs2.getString("name"),
                                rs2.getString("course"),
                                rs2.getInt("semester")
                        );
                    }
                }

                // =================== ADMIN ===================
                if (role.equals("admin")) {
                    return new Admin(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            "admin"
                    );
                }

                // =================== FACULTY ===================
                if (role.equals("faculty")) {
                    return new Faculty(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            "faculty"
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
