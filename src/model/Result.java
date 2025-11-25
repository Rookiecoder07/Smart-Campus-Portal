package model;

public class Result {
    private int resultID;
    private int studentID;
    private String subject;
    private int marks;

    public Result(int resultID, int studentID, String subject, int marks) {
        this.resultID = resultID;
        this.studentID = studentID;
        this.subject = subject;
        this.marks = marks;
    }

    public String getSubject() { return subject; }
    public int getMarks() { return marks; }
    public int getStudentID() { return studentID; }
    public int getResultID() { return resultID; }
}