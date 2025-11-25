package model;

import java.sql.Date;

public class Announcement {
    private int announceID;
    private int facultyID;
    private String content;
    private Date date;  // This field is now "used" via getter

    public Announcement(int announceID, int facultyID, String content, Date date) {
        this.announceID = announceID;
        this.facultyID = facultyID;
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {  // Added getter to use the field
        return date;
    }

    public int getFacultyID() {
        return facultyID;
    }
    public int getAnnounceID() {
        return announceID;
    }
}
