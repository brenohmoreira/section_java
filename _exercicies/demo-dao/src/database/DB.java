package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection == null) {
            try
            {
                Properties props = loadProperties();

                String url = props.getProperty("dburl");

                connection = DriverManager.getConnection(url, props);
            }
            catch(SQLException error)
            {
                throw new DbException(error.getMessage());
            }
        }

        return connection;
    }

    private static Properties loadProperties() {
        try(FileInputStream fs = new FileInputStream("db.properties"))
        {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException error)
        {
            throw new DbException(error.getMessage());
        }
    }

    public static void closeConnection() {
        if(connection != null) {
            try
            {
                connection.close();
            }
            catch(SQLException error) {
                throw new DbException(error.getMessage());
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null)
        {
            try
            {
                statement.close();
            }
            catch(SQLException error)
            {
                throw new DbException(error.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet data) {
        if (data != null)
        {
            try
            {
                data.close();
            }
            catch (SQLException error)
            {
                throw new DbException(error.getMessage());
            }
        }
    }
}
