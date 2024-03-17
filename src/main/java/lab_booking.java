import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/lab_booking")
public class lab_booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private lab_bookingDAO labBookingDAO;

    public lab_booking() {
        super();
        // Initialize lab_bookingDAO
        this.labBookingDAO = new lab_bookingDAO(getConnection());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Not implemented for this example
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String labTest = request.getParameter("lab_test");
        String doctorName = request.getParameter("doctor_name");
        String datetime = request.getParameter("datetime");

        if (labTest != null && doctorName != null && datetime != null) {
            if (labBookingDAO.bookLab(labTest, doctorName, datetime)) {
                // Booking successful
                response.getWriter().println("Lab booking successful!");
            } else {
                // Booking failed
                response.getWriter().println("Failed to book lab!");
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