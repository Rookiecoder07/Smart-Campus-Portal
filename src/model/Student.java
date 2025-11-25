package model;

public class Student extends User {

    private String course;
    private int semester;

    public Student(int id, String name, String course, int semester) {
        super(id, name, null, "student"); // email is null since it's not in students table
        this.course = course;
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    @Override
    public void dashboard() {

    }
}
