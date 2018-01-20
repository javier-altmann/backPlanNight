package conf;

import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Singleton
public class ConnectionDB {

    private Connection connection;
    final Logger logger = LoggerFactory.getLogger(ConnectionDB.class);

    public Connection getConnection() {
        try {
            
            connection = DriverManager.getConnection(
                    " root",
                    "",
                    " jdbc:mysql://localhost/test");
        } catch (SQLException e) {
            logger.error("Conexión error", e);
        }

        return connection;
    }
}
