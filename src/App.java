import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "your-username";
        String password = "your-password";

        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Connetion successful, do something with the connection

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}