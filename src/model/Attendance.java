package model;

import java.sql.Date;

public class Attendance {
    private int attendanceID;
    private int studentID;
    private Date date;
    private String status;

    public Attendance(int attendanceID, int studentID, Date date, String status) {
        this.attendanceID = attendanceID;
        this.studentID = studentID;
        this.date = date;
        this.status = status;
    }

    public int getAttendanceID() { return attendanceID; }
    public String getStatus() { return status; }
    public Date getDate() { return date; }
    public int getStudentID() { return studentID; }
}