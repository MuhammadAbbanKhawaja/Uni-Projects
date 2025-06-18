package health.and.wellness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlconnect {
    public Connection connection;
    public Statement statement;

    public sqlconnect() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database using your settings
            String url = "jdbc:mysql://localhost:3307/health_and_wellness?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String pwd  = "@12042004";

            connection = DriverManager.getConnection(url, user, pwd);
            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
