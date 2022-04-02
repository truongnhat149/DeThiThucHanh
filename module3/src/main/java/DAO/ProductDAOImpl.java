package DAO;

import model.Category;
import model.Product;
import utils.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {

    private static final String INSERT_PRODUCT = "INSERT INTO product (`name`, `price`, `quantity`, `color`, `description` ,`name_category`) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?";
    private static final String SELECT_PRODUCT = "SELECT * FROM product;";
    private static final String DELETE_PRODUCT = "delete from product where id = ?;";
    private static final String UPDATE_PRODUCT = "update product set name = ?,price= ?, quantity =?, color = ?,description = ?, name_category = ?, where id = ?;";

    @Override
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT);
        try (Connection connection = GetConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
        ) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            GetConnection.printSQLException(e);
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = GetConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("name_category");

                product = new Product(name, price, quantity, color, description, category);
            }
        } catch (SQLException e) {
            GetConnection.printSQLException(e);
        }
        return product;
    }

    @Override
    public List<Product> selectAllProduct() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = GetConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("name_category");
                products.add(new Product(id, name, price, quantity, color, description, category));
                System.out.println(products);
            }
        } catch (SQLException e) {
            GetConnection.printSQLException(e);
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = GetConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    //    public List<Category> getAllCategory() {
//        String query = "select * from category";
//        List<Category> listCate = new ArrayList<>();
//        try (Connection conn = new GetConnection().getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                listCate.add(new Category(rs.getInt(1),
//                        rs.getString(2))
//                );
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listCate;
//    }
    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = GetConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, String.valueOf(product.getCategory()));
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
        public List<Category> getAllCategory() {
            String query = "select * from category";
            List<Category> listCate = new ArrayList<>();
            try (Connection connection = new GetConnection().getConnection();
                 PreparedStatement ps = connection.prepareStatement(query)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
//        listCate.add(new Category(rs.getInt(1),rs.getString(2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listCate;
        }

    @Override
    public List<Product> search(String name) {
        return null;
    }
}
