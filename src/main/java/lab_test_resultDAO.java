import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class lab_test_resultDAO {
	private Connection connection;

    public lab_test_resultDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addLabTestResult(int labRegisterId, String patientName, String result) {
        String query = "INSERT INTO lab_test_result (lab_register_id, patient_name, result) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, labRegisterId);
            preparedStatement.setString(2, patientName);
            preparedStatement.setString(3, result);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}