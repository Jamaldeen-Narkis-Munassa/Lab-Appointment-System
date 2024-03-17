
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class lab_testDAO {
	private Connection connection;

    public lab_testDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addLabTest(String testId, String testName, String description) {
        String query = "INSERT INTO lab_test (test_id, test_name, description) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, testId);
            preparedStatement.setString(2, testName);
            preparedStatement.setString(3, description);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
