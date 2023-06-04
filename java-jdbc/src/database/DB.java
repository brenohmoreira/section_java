package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection == null) {
            try {
                // O que retorna do método estático loadProperties em props
                Properties props = loadProperties();

                String url = props.getProperty("dburl");

                // Conectando
                connection = DriverManager.getConnection(url, props);
            }
            catch(SQLException error) {
                throw new DbException(error.getMessage());
            }
        }

        return connection;
    }

    /*
     * Properties: nativo do JAVA
     * Basicamente, falamos para ele ler o arquivo .properties com fs e retornar o que foi lido
     */
    private static Properties loadProperties() {
        try(FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException error) {
            throw new DbException(error.getMessage());
        }
    }

    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            }
            catch(SQLException error) {
                throw new DbException(error.getMessage());
            }
        }
    }
}
