package model.dao.impl;

import database.DB;
import database.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection connection;

    public DepartmentDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO seller(Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, obj.getName());

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();

                obj.setId(resultSet.getInt(1));
            }
        }
        catch(SQLException MySQLError) {
            throw new DbException(MySQLError.getMessage());
        }
        finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {

    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
