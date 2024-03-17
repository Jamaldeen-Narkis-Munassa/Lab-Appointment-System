import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class lab_bookingDAO {
    private Connection connection;

    public lab_bookingDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean bookLab(String labTest, String doctorName, String datetime) {
        String query = "INSERT INTO lab_booking (lab_test, doctor_name, datetime) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, labTest);
            preparedStatement.setString(2, doctorName);
            preparedStatement.setString(3, datetime);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
