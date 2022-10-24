package PlasticDBConnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlasticDBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/plasticdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

    private Connection connection;

    public PlasticDBConnection(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
