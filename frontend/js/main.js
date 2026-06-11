document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    const errorMessage = document.getElementById('error-message');

    if (loginForm) {
        loginForm.addEventListener('submit', (e) => {
            e.preventDefault();
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const role = document.querySelector('input[name="role"]:checked').value;

            // Mock login logic
            if (email && password) {
                // Store user info in localStorage
                const user = {
                    email: email,
                    role: role,
                    name: email.split('@')[0].charAt(0).toUpperCase() + email.split('@')[0].slice(1)
                };
                localStorage.setItem('user', JSON.stringify(user));
                
                // Redirect to dashboard
                window.location.href = 'dashboard.html';
            } else {
                errorMessage.textContent = 'Please enter both email and password.';
            }
        });
    }

    // Dashboard logic
    if (window.location.pathname.includes('dashboard.html')) {
        const user = JSON.parse(localStorage.getItem('user'));
        if (!user) {
            window.location.href = 'index.html';
            return;
        }

        // Update UI with user info
        document.getElementById('userName').textContent = user.name;
        document.getElementById('userRole').textContent = user.role.charAt(0).toUpperCase() + user.role.slice(1);
        
        // Show/hide sections based on role
        renderDashboardContent(user.role);
    }
});

function renderDashboardContent(role) {
    const contentArea = document.getElementById('dashboardContent');
    let html = '';

    if (role === 'student') {
        html = `
            <div class="dashboard-cards">
                <div class="card">
                    <div class="card-header">
                        <h3><i class="fas fa-calendar-check"></i> Attendance Record</h3>
                    </div>
                    <div class="table-container">
                        <table>
                            <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr><td>2026-06-10</td><td><span class="status-present">Present</span></td></tr>
                                <tr><td>2026-06-09</td><td><span class="status-present">Present</span></td></tr>
                                <tr><td>2026-06-08</td><td><span class="status-absent">Absent</span></td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h3><i class="fas fa-poll-h"></i> Exam Results</h3>
                    </div>
                    <div class="table-container">
                        <table>
                            <thead>
                                <tr>
                                    <th>Subject</th>
                                    <th>Marks</th>
                                    <th>Grade</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr><td>Mathematics</td><td>85</td><td>A</td></tr>
                                <tr><td>Physics</td><td>78</td><td>B+</td></tr>
                                <tr><td>Computer Science</td><td>92</td><td>A+</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        `;
    } else if (role === 'faculty') {
        html = `
            <div class="dashboard-cards">
                <div class="card">
                    <div class="card-header">
                        <h3><i class="fas fa-users"></i> Manage Attendance</h3>
                    </div>
                    <p>Mark attendance for your classes.</p>
                    <button class="action-btn">Open Attendance Sheet</button>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h3><i class="fas fa-bullhorn"></i> Post Announcement</h3>
                    </div>
                    <textarea placeholder="Type your announcement here..."></textarea>
                    <button class="action-btn">Post to Portal</button>
                </div>
            </div>
        `;
    } else if (role === 'admin') {
        html = `
            <div class="dashboard-cards">
                <div class="card">
                    <div class="card-header">
                        <h3><i class="fas fa-user-plus"></i> User Management</h3>
                    </div>
                    <div class="stats">
                        <p>Total Students: 1,240</p>
                        <p>Total Faculty: 85</p>
                    </div>
                    <button class="action-btn">Add New User</button>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h3><i class="fas fa-database"></i> System Logs</h3>
                    </div>
                    <div class="table-container">
                        <table>
                            <thead>
                                <tr>
                                    <th>Time</th>
                                    <th>Action</th>
                                    <th>User</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr><td>10:45 AM</td><td>Login</td><td>admin_01</td></tr>
                                <tr><td>09:30 AM</td><td>Update Grades</td><td>faculty_smith</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        `;
    }

    contentArea.innerHTML = html;
}

function logout() {
    localStorage.removeItem('user');
    window.location.href = 'index.html';
}
