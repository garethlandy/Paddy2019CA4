package org.gareth.webapp.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.gareth.webapp.beans.*;

public class DBUtils {

	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender, a.Admin, a.Street_Address_1"
				+ ", a.Street_Address_2, a.Town, a.City, a.Country, a.Post_Code" + " from User_Account a " //
				+ " where a.User_Name = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String gender = rs.getString("Gender");
			String admin = rs.getString("Admin");
			String s1 = rs.getString("Street_Address_1");
			String s2 = rs.getString("Street_Address_2");
			String town = rs.getString("Town");
			String city = rs.getString("City");
			String country = rs.getString("Country");
			String postcode = rs.getString("Post_Code");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			user.setAdmin(admin);
			user.setStreet_address_1(s1);
			user.setStreet_address_2(s2);
			user.setTown(town);
			user.setCity(city);
			user.setCountry(country);
			user.setPostcode(postcode);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender, a.Admin from User_Account a "//
				+ " where a.User_Name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			String admin = rs.getString("Admin");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			user.setAdmin(admin);
			return user;
		}
		return null;
	}

	public static List<org.gareth.webapp.beans.ShoppingCart> queryShoppingCart(Connection conn, UserAccount userName)
			throws SQLException {
		/* String sql = "Select a.userName, a.code from Shopping_Cart a"; */
		String sql = "select s.userName, s.code, p.name, p.manufacturer, p.price " + "from shopping_cart s "
				+ "join product p on p.CODE = s.code " + "where s.userName = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName.getUserName());
		ResultSet rs = pstm.executeQuery();
		List<org.gareth.webapp.beans.ShoppingCart> list = new ArrayList<org.gareth.webapp.beans.ShoppingCart>();
		while (rs.next()) {
			String suserName = rs.getString("userName");
			String code = rs.getString("code");
			String pname = rs.getString("name");
			String manu = rs.getString("manufacturer");
			float price = rs.getFloat("Price");

			org.gareth.webapp.beans.ShoppingCart cart = new org.gareth.webapp.beans.ShoppingCart();
			cart.setCode(code);
			cart.setUserName(suserName);
			cart.setManufacturer(manu);
			cart.setName(pname);
			cart.setPrice(price);
			list.add(cart);
		}
		return list;

	}

	public static List<Product> searchProduct(Connection conn, String name) throws SQLException {
		String sql = "Select p.code, p.name, p.price, p.manufacturer, p.Category, p.imageFile, p.stock "
				+ "from Product p where lower(p.name) like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%" + name + "%");
		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("Code");
			String pname = rs.getString("Name");
			float price = rs.getFloat("Price");
			String manufacturer = rs.getString("Manufacturer");
			String category = rs.getString("Category");
			String imageFile = rs.getString("imageFile");
			int stock = rs.getInt("stock");
			Product product = new Product();
			product.setCode(code);
			product.setName(pname);
			product.setPrice(price);
			product.setManufacturer(manufacturer);
			product.setCategory(category);
			product.setImageFile(imageFile);
			product.setStock(stock);
			list.add(product);
		}
		return list;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price, a.Manufacturer, a.Category, a.imageFile, a.stock from Product a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			String manufacturer = rs.getString("Manufacturer");
			String category = rs.getString("Category");
			String imageFile = rs.getString("imageFile");
			int stock = rs.getInt("stock");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			product.setManufacturer(manufacturer);
			product.setCategory(category);
			product.setImageFile(imageFile);
			product.setStock(stock);
			list.add(product);
		}
		return list;
	}

	public static Product findProduct(Connection conn, String code) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price, a.Manufacturer, a.Category, a.imageFile, a.stock from Product a where a.Code=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			String manufacturer = rs.getString("Manufacturer");
			String category = rs.getString("Category");
			String imageFile = rs.getString("imageFile");
			int amountInStock = rs.getInt("stock");
			Product product = new Product(code, name, price, manufacturer, category, imageFile, amountInStock);
			return product;
		}
		return null;
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price =?, manufacturer =?, category =?, stock = ? where Code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		// pstm.setString(3, product.getCode());
		pstm.setString(3, product.getManufacturer());
		pstm.setString(4, product.getCategory());
		pstm.setInt(5, product.getStock());
		pstm.setString(6, product.getCode());

		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(Code, Name, Price, Manufacturer, Category, ImageFile, Stock) values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());
		pstm.setString(4, product.getManufacturer());
		pstm.setString(5, product.getCategory());
		pstm.setString(6, product.getImageFile());
		pstm.setInt(7, product.getStock());

		pstm.executeUpdate();
	}

	public static void insertIntoShoppingCart(Connection conn, org.gareth.webapp.beans.ShoppingCart cart)
			throws SQLException {
		String sql = "Insert into Shopping_Cart(userName,code,paid) values(?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, cart.getUserName());
		pstm.setString(2, cart.getCode());
		pstm.setString(3, "n");
		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product where Code = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);
		System.out.println("xxxx"+code.toString());
		pstm.executeUpdate();
	}

	public static void deleteCartItem(Connection conn, String code, String user) throws SQLException {
		String sql = "Delete From Shopping_Cart where userName = ? and Code = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user);
		pstm.setString(2, code);
		System.out.println("xxxx"+code.toString() + "" + user.toString());
		pstm.executeUpdate();
	}

}
