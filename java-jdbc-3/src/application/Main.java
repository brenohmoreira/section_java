package application;

import database.DB;
import database.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Deletar dados

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try
        {
            connection = DB.getConnection();

            preparedStatement = connection.prepareStatement("DELETE FROM department WHERE Id = ?");

            // Vai dar erro que vai ativar nossa exception personalizada
            preparedStatement.setInt(1,1 );

            int rowsAffected = preparedStatement.executeUpdate();
        }
        catch(SQLException mysqlException)
        {
            throw new DbIntegrityException(mysqlException.getMessage());
        }
        finally
        {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}
