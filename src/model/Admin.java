package model;

public class Admin extends User {

    public Admin(int id, String name, String email, String role) {
        super(id, name, email, role);
    }

    @Override
    public void dashboard() {
        // Admin dashboard logic
        getRole();
    }
}
