import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JdbcExample {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/yourdatabase"; // Replace 'yourdatabase' with your database name
        String user = "yourusername"; // Replace with your database username
        String password = "yourpassword"; // Replace with your database password

        // Initialize connection, statement, and result set
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load and register JDBC driver (for MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);

            // Create a statement object
            statement = connection.createStatement();

            // Execute a query
            String query = "SELECT * FROM yourtable"; // Replace 'yourtable' with your table name
            resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // Replace 'id' with your column name
                String name = resultSet.getString("name"); // Replace 'name' with your column name
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
