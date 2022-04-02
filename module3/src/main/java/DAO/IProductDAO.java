package DAO;
import java.sql.SQLException;
import java.util.List;

import model.Category;
import model.Product;

public interface IProductDAO {
    void insertProduct(Product product) throws SQLException;

    Product selectProduct(int id);

    List<Product> selectAllProduct() throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;

    List<Category> getAllCategory();

    List<Product> search(String name);
}
