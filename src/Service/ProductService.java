package Service;

import DAO.ProductDAO;
import JavaBean.Order;
import JavaBean.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public List<Product> selectAll() {
        List<Product> products = productDAO.queryMulti("SELECT * FROM product", Product.class);

        return products;
    }

    public Product getProductById(int id) {
        Product product = productDAO.queryRow("SELECT * FROM product WHERE `id`= ?", Product.class, id);

        return product;
    }

    public Boolean setProduct(Product product) {

        int row = productDAO.update("UPDATE `product` SET `name` = ?, `img` = ?, `information` = ? , `price` = ? WHERE `id` = ?;", product.getName(), product.getImg(), product.getInformation(), product.getPrice(), product.getId());

        return row > 0;

    }

    public Boolean add(Product product) {
        int row = productDAO.update("INSERT INTO `product` (`name`,`img`,`information`,`price`) VALUES(?,?,?,?)",product.getName(),product.getImg(),product.getInformation(),product.getPrice());

        return row > 0;

    }
    public Boolean deleteById(int id) {
        int row = productDAO.update("DELETE FROM `product` WHERE id = ?",id);

        return row > 0;

    }


}
