package application;

import database.DB;

import java.sql.Connection;

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

        Connection connection = DB.getConnection();

        DB.closeConnection();
    }
}
