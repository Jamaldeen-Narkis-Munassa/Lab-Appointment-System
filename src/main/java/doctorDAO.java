import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class doctorDAO {
	private Connection connection;

    public doctorDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean registerDoctor(String name, String email, String specialization,int experience_year,int slmcId,int contactNumber,  String address) {
        String query = "INSERT INTO `doctor` (`name`, `email`, `specialization`, `experience_year`, `slmc_id`, `contact_number`, `address`) VALUES (?, ?, ?, ?, ?, ?, ?)"; // Corrected SQL query
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, specialization);
            preparedStatement.setInt(4, experience_year);
            preparedStatement.setInt(5, slmcId);
            preparedStatement.setInt(6, contactNumber);
            preparedStatement.setString(7, address);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}