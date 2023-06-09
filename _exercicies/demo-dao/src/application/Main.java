package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Main {
    public static void main(String[] args) {
        // DaoFactory vai instanciar SellerDaoJDBC passando a conexão para o construtor de SellerDaoJDBC
        SellerDao sellerDao = DaoFactory.createSellerDao();

        // sellerDao.findById(Integer id) retorna um Seller
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
