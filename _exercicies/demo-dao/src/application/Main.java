package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // DaoFactory vai instanciar SellerDaoJDBC passando a conexão para o construtor de SellerDaoJDBC
        SellerDao sellerDao = DaoFactory.createSellerDao();

        // sellerDao.findById(Integer id) retorna um Seller
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        Department department = new Department(2, "Exemplo");
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        List<Seller> listAll = new ArrayList<>();

        listAll = sellerDao.findAll();

        for(Seller obj : listAll) {
            System.out.println(obj);
        }

        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted new id = " + newSeller.getId());

        seller = sellerDao.findById(1);

        seller.setName("Marta Wayne");
        sellerDao.update(seller);
        System.out.println("Updated! -> " + seller);
    }
}
