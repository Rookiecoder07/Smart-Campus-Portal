package servlet;

import dao.FeedbackDAO;
import model.Feedback;
import model.User;  // Import directly
import model.Student;  // Import directly
import javax.servlet.ServletException;                  // MISSING IMPORT ✔
import javax.servlet.annotation.WebServlet;        
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

public class FeedbackServlet extends HttpServlet {
    private FeedbackDAO feedbackDAO = new FeedbackDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user instanceof Student) {
                String message = request.getParameter("message");
                if (message != null && !message.isEmpty()) {
                    Feedback feedback = new Feedback(0, user.getId(), message, new Date(System.currentTimeMillis()));
                    feedbackDAO.insert(feedback);
                    response.sendRedirect("feedbackSubmitted.jsp");
                } else {
                    response.sendRedirect("error.jsp?msg=Empty message");
                }
            } else {
                response.sendRedirect("error.jsp?msg=Not a student");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?msg=Server error");
        }
    }
}
