package application;

import database.DB;
import database.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Transação
        /*
         * Digamos que o programa execute duas operações query. A primeira funciona, porém, entre a primeira e a segunda
         * acontece uma exception, fazendo a segunda não ser executada. Concorda comigo que a primeira deve voltar a ser
         * o que era antes? Para isso, utilizamos a transação.
         * Primeiro, devemos iniciar o bloco do commit. Para isso, devemos utilizar
         * connection.setAutoCommit(false); -> Fazemos como false para não dar rollback automaticamente.
         * Ao terminar o bloco em questão, utilizamos o connection.commit();
         * Agora, se der um erro, podemos utilizar no catch um connection.rollback();
         */

        Connection connection = null;
        Statement statement = null;

        try
        {
            connection = DB.getConnection();

            statement = connection.createStatement();

            connection.setAutoCommit(false);

            int rowsAffected1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 2");

            // Digamos que aconteça uma exceção no meio das duas. A segunda não vai ser executada!
            int x = 0;
            if(x == 0)
            {
                throw new SQLException("Fake Error");
            }

            int rowsAffected2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3000 WHERE DepartmentId = 3");

            connection.commit();
        }
        catch(SQLException mysqlException)
        {
            try
            {
                connection.rollback();
                throw new DbIntegrityException("Transaction rolled back! Caused by: " + mysqlException.getMessage());
            }
            catch (SQLException error)
            {
                System.out.println(error.getMessage());
            }
        }
        finally
        {
            DB.closeStatement(statement);
            DB.closeConnection();
        }

    }
}
