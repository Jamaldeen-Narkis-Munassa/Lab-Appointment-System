
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class lab_test_registerDAO {
	 private Connection connection;

	    public lab_test_registerDAO(Connection connection) {
	        this.connection = connection;
	    }

	    // Method to add a lab test registration
	    public boolean addLabTestRegistration(String patientName, String doctorName, String testType, String testSampleId) {
	        String query = "INSERT INTO lab_test_register (patient_name, doctor_name, test_type, test_sample_id) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, patientName);
	            preparedStatement.setString(2, doctorName);
	            preparedStatement.setString(3, testType);
	            preparedStatement.setString(4, testSampleId);
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    // Method to retrieve lab test registration details by ID
	    public lab_test_registerDAO getLabTestRegistrationById(int id) {
	        // Implementation required to retrieve lab test registration details by ID
	        return null; // Replace this with actual implementation
	    }

	    // Method to update lab test registration details
	    public boolean updatelab_test_registerDAO(int id, String patientName, String doctorName, String testType, String testSampleId) {
	        // Implementation required to update lab test registration details
	        return false; // Replace this with actual implementation
	    }

	    // Method to delete lab test registration
	    public boolean deletelab_test_registerDAO(int id) {
	        // Implementation required to delete lab test registration
	        return false; // Replace this with actual implementation
	    }
	}