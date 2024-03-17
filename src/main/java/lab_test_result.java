import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab_test_result")
public class lab_test_result extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private lab_test_resultDAO lab_test_resultDAO;

	    public lab_test_result() {
	        super();
	        // Initialize LabTestResultDAO
	        this.lab_test_resultDAO = new lab_test_resultDAO(getConnection());
	    }

	    protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int labRegisterId = Integer.parseInt(request.getParameter("lab_register_id"));
	        String patientName = request.getParameter("patient_name");
	        String result = request.getParameter("result");

	        if (patientName != null && result != null) {
	            if (lab_test_resultDAO.addLabTestResult(labRegisterId, patientName, result)) {
	                // Result added successfully
	                response.getWriter().println("Lab test result added successfully!");
	            } else {
	                // Failed to add result
	                response.getWriter().println("Failed to add lab test result!");
	            }
	        } else {
	            // Parameters missing
	            response.getWriter().println("Missing parameters!");
	        }
	    }

	    private Connection getConnection() {
	        // Implement your method to get a database connection
	        // Return the Connection object
	        return null;
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
