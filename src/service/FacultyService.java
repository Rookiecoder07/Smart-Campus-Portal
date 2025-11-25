package service;

import model.Faculty;
import dao.FacultyDAO;

public class FacultyService {
    private FacultyDAO facultyDAO = new FacultyDAO();

    public void addFaculty(Faculty faculty) {
        facultyDAO.insert(faculty);
    }
}