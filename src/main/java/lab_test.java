

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/lab_test")
public class lab_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private lab_testDAO lab_testDAO;

    public lab_test() {
        super();
        // Initialize LabBookingDAO
        this.lab_testDAO = new lab_testDAO(getConnection());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Not implemented for this example
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testId = request.getParameter("test_id");
        String testName = request.getParameter("test_name");
        String description = request.getParameter("description");

        if (testId != null && testName != null && description != null) {
            if (lab_testDAO.addLabTest(testId, testName, description)) {
                // Adding lab test successful
                response.getWriter().println("Lab test added successfully!");
            } else {
                // Adding lab test failed
                response.getWriter().println("Failed to add lab test!");
            }
        } else {
            // Parameters missing
            response.getWriter().println("Missing parameters!");
        }
    }

    // Method to get database connection (you need to implement this)
    private Connection getConnection() {
        // Implement your method to get a database connection
        // Return the Connection object
        return null;
    }
}