package conection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "94915061andril";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/rochaTour";

    public static Connection createConnectionToMysql() throws Exception {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

        return connection;
    }
}
