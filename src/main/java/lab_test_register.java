

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


@WebServlet("/lab_test_register")
public class lab_test_register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private lab_test_registerDAO lab_test_registerDAO;

    public lab_test_register() {
        super();
        // Initialize LabTestRegisterDAO
        this.lab_test_registerDAO = new lab_test_registerDAO(getConnection());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Not implemented for this example
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String patientName = request.getParameter("patient_name");
        String doctorName = request.getParameter("doctor_name");
        String testType = request.getParameter("test_type");
        String testSampleId = request.getParameter("test_sample_id");

        if (patientName != null && doctorName != null && testType != null && testSampleId != null) {
            if (lab_test_registerDAO.addLabTestRegistration(patientName, doctorName, testType, testSampleId)) {
                // Registration successful
                response.getWriter().println("Lab test registration successful!");
            } else {
                // Registration failed
                response.getWriter().println("Failed to register lab test!");
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