package model.dao.impl;

import database.DB;
import database.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(obj.getDate().getTime()));
            preparedStatement.setDouble(4, obj.getBaseSalary());
            preparedStatement.setInt(5, obj.getDepartment().getId());

            // Executa a mudança. Não vamos precisar de nenhum dos valores, se não poderíamos armazenar em um resultSet
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Criando um resultSet para armazenar as keys geradas (Ids)
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    obj.setId(id);
                }

                DB.closeStatement(preparedStatement);
                DB.closeResultSet(resultSet);
            }
            else {
                throw new DbException("Erro inesperado: nenhuma linha afetada");
            }
        }
        catch(SQLException MySQLError) {
            throw new DbException(MySQLError.getMessage());
        }
    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try
        {
            /*
             * Selecione toda tabela seller e o nome do departamento em que, para o WHERE ?, junção seller INNER JOIN department
             * o seller.DepartmentId = department.Id. Resumindo, ele vai procurar o seller.Id = ? dentro do resultado da JOIN seller + department
             * que atende seller.DepartmentId = department.Id e exibir a seller inteira e o nome do departamento.
             */
            preparedStatement = connection.prepareStatement("SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?");

            preparedStatement.setInt(1, id);

            /*
             * Isso está em formato de tabela. Porém em Java SEMPRE queremos associar à objetos.
             */
            resultSet = preparedStatement.executeQuery();

            // Pode retornar nulo ou não, se tiver algo
            if(resultSet.next()) {
                Department department = new Department(resultSet.getInt("DepartmentId"), resultSet.getString("DepName"));
                Seller seller = new Seller(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Email"), resultSet.getDate("BirthDate"), resultSet.getDouble("BaseSalary"), department);

                return seller;
            }

            return null;
        }
        catch (SQLException mySQLError) {
            throw new DbException(mySQLError.getMessage());
        }
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id ORDER BY Name");

            resultSet = preparedStatement.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while(resultSet.next()) {

                Department dep = map.get(resultSet.getInt("DepartmentId"));

                if(dep == null) {
                    dep = new Department(resultSet.getInt("DepartmentId"), resultSet.getString("DepName"));
                    map.put(resultSet.getInt("DepartmentId"), dep);
                }

                Seller seller = new Seller(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Email"), resultSet.getDate("BirthDate"), resultSet.getDouble("BaseSalary"), dep);

                list.add(seller);
            }

            return list;

        }
        catch(SQLException mySQLException) {
            throw new DbException(mySQLException.getMessage());
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE DepartmentId = ? ORDER BY Name");

            preparedStatement.setInt(1, department.getId());

            resultSet = preparedStatement.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while(resultSet.next()) {

                Department dep = map.get(resultSet.getInt("DepartmentId"));

                // Se não existir. Crie e armazene para que na próxima use o MESMO DEPARTAMENTO
                /*
                 * Isso faz com que não tenha um dep instanciado para cada seller, mas sim um único dep para todos os sellers relacionados
                 */
                if(dep == null) {
                    dep = new Department(resultSet.getInt("DepartmentId"), resultSet.getString("DepName"));
                    map.put(resultSet.getInt("DepartmentId"), dep);
                }

                Seller seller = new Seller(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Email"), resultSet.getDate("BirthDate"), resultSet.getDouble("BaseSalary"), dep);

                list.add(seller);
            }

            return list;
        }
        catch(SQLException mySQLError) {
            throw new DbException(mySQLError.getMessage());
        }
    }
}
