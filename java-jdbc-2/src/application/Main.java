package application;

import database.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Atualizar dados

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try
        {
            connection = DB.getConnection();

            preparedStatement = connection.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary + ? WHERE (DepartmentId = ?)");

            preparedStatement.setDouble(1, 300.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch(SQLException mysqlError)
        {
            System.out.println(mysqlError.getMessage());
        }
        finally
        {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
