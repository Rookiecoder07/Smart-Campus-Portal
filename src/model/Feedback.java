package model;

import java.sql.Date;

public class Feedback {
    private int feedbackID;
    private int studentID;
    private String message;
    private Date submittedOn;

    public Feedback(int feedbackID, int studentID, String message, Date submittedOn) {
        this.feedbackID = feedbackID;
        this.studentID = studentID;
        this.message = message;
        this.submittedOn = submittedOn;
    }

    public String getMessage() { return message; }
    public int getStudentID() { return studentID; }
    public Date getSubmittedOn() { return submittedOn; }
    public int getFeedbackID() { return feedbackID; }
}