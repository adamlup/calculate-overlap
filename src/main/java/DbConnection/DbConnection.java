package DbConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

        private final String databaseName = "pokemon";
        private Connection connection;

        public Connection getConnection() {

            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s.db", databaseName));
                System.out.println("database connected");
            } catch (Exception e) {
                System.out.println("Problem with db connection");
                System.out.println(e);
                return null;
            }
            return connection;
        }

        public void closeConnection() throws SQLException {
            connection.close();
        }
}
