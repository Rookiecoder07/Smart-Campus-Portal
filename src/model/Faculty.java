package model;

public class Faculty extends User {

    public Faculty(int id, String name, String email, String role) {
        super(id, name, email, role);
    }

    @Override
    public void dashboard() {
        // Faculty dashboard logic
    }

    public String getDepartment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartment'");
    }
}
