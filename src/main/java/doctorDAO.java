import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class doctorDAO {
	private Connection connection;

    public doctorDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean registerDoctor(String name, String email, String specialization,int experience_year,int lkId,int phoneNo,  String address) {
        String query = "INSERT INTO `doctor_list` (`doctor_name`, `email`, `specialization`, `experience_year`, `lk_id`, `phone_no`, `address`) VALUES (?, ?, ?, ?, ?, ?, ?)"; // Corrected SQL query
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, specialization);
            preparedStatement.setInt(4, experience_year);
            preparedStatement.setInt(5, lkId);
            preparedStatement.setInt(6, phoneNo);
            preparedStatement.setString(7, address);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}