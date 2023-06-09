package model.dao.impl;

import database.DB;
import database.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller obj) {

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
        return null;
    }
}
