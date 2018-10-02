package model;

import java.util.ArrayList;

public interface IPoductDAO {

	boolean insertProduct(Product p);

	ArrayList<Product> getProducts();

	Product getProduct(int id);

	boolean updateProduct(Product p);

	boolean deleteProduct(Product p);

}