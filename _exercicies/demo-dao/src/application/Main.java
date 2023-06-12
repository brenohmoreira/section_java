package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        departmentDao.insert(new Department(null, "Cosméticos"));

        Department dep1 = departmentDao.findById(6);
        dep1.setName("MarianaDepartment");
        departmentDao.update(dep1);

        System.out.print("Enter id for delete test: ");
        int id = input.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");


        List<Department> departments = departmentDao.findAll();

        for(Department department : departments) {
            System.out.println(department);
        }
        input.close();
    }
}
