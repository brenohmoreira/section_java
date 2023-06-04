package application;

import database.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        /*
         * JDBC é a API nativa do Java para utilizar bancos de dados: java.sql e javax.sql
         *
         * O JDBC utiliza um esquema de drivers que permite uma portabilidade gigantesca. A ideia é que o seu código
         * passa para um JDBC driver manager. Esse driver vai fazer a conversão do código escrito para o código do banco
         * desejado. Assim sendo, um mesmo código java utilizando a API JDBC pode ser usada para qualquer banco de dados
         * relacional.
         *
         * - Baixar MYSQL
         * - Baixar MYSQL Java Connector (pesquisa java connector 8)
         * - Criar uma pasta para armazenar as libs externas (fiz a pasta java-libs em C://)
         * - Agora adicione como uma biblioteca externa na IDE (aqui é em file > project structure > libraries)
         *      Se seu arquivo for fora de C:// (ex: D://), vai precisar colocar o connector dentro de uma pasta fila na raiz do projeto
         *      e adicionar a lib externa dentro
         * - Criar arquivo db.properties (possui um exemplo nesse projeto) na raiz do projeto com as informações do db
         *      Fazemos isso por proteção. O ideal é isso não ser mostrado em .gitignore, mas deixarei nesse projeto
         * - Criar exceção de database personalizada
         */

        /*
         * Demo: recuperar dados
         *
         * Duas classes da API:
         *      Statement: prepara a consulta. Nós utilizemos um objeto Statement para realizar a consulta e armazenamos
         *      em um objeto ResultSet os dados da consulta realizada.
         *      ResultSet: retorna uma tabela com os dados. Podemos chamar métodos que ajudam a percorrer a tabela
         *          - Tabela começa em 1. O 0 seria como se fosse os nomes da tabela
         *          - beforeFirst() move para a linha 0 0
         *          - next() move para a próxima linha
         *          - first() move para a linha 1, se houver
         *          - absolute(int) move para a linha específicada
         */

        Statement statement = null;
        ResultSet data = null;
        Connection connection = DB.getConnection();

        try {
            statement = connection.createStatement();
            data = statement.executeQuery("SELECT * FROM department");

            // Enquanto existir um próximo. Retorna false se chegar no último. Se tiver um, retorna true e o index muda para o próximo
            while (data.next()) {
                System.out.println(data.getInt("Id") + ": " + data.getString("Name"));
            }
        } catch (SQLException error) {
            System.out.println(error);
        } finally {
            DB.closeResultSet(data);
            DB.closeStatement(statement);
            // Eu fecharia o DB aqui, mas não posso, pois irei utilizar outras querys
        }

        /*
         * Vejamos agora como INSERIR DADOS
         */

        PreparedStatement pS = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try
        {
            // 5 interrogações, pois são 5 variáveis. A primeira para name, a segunda para email, etc.
            // A parte do generated_keys é opcional, é uma sobrecarga do método prepareStatement. Ele retorna a primary-key/ID da row inserida
            pS = connection.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            pS.setString(1, "Breno");
            pS.setString(2, "brenodeabreu2004@gmail.com");
            pS.setDate(3, new java.sql.Date(sdf.parse("10/12/2022").getTime()));
            pS.setDouble(4, 3000.0);
            pS.setInt(5, 4);

            // Executa a query e retorna o valor de linhas afetadas
            int rowsAffected = pS.executeUpdate();

            if(rowsAffected > 0)
            {
                ResultSet rs = pS.getGeneratedKeys();

                // No caso de houver mais de um valor, podemos percorrer rs
                while(rs.next())
                {
                    // É uma tabela de uma coluna só, então apenas dizemos que queremos a coluna 1
                    System.out.println("Id: " + rs.getInt(1));
                }
            }
            else
            {
                System.out.println("No rows affected");
            }
        }
        catch(SQLException error)
        {
            System.out.println(error.getMessage());
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            DB.closeStatement(pS);
            DB.closeConnection();
        }
    }
}
