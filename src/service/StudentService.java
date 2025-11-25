package service;

import model.Student;
import dao.StudentDAO;
import java.util.List;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();

    public void addStudent(Student student) {
        studentDAO.insert(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }
}