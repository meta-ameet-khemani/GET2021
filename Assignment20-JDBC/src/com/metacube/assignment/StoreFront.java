package com.metacube.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.assignment.model.Category;
import com.metacube.assignment.model.Order;

/**
 * StoreFront manages store front database
 * @author ameet.khemani_metacu
 */
public class StoreFront {

	/**
	 * Used to establish the single connection between this program and database
	 * @return Connection object
	 */
	private static Connection getConnection () {
		
		// create connection object
		Connection con = null;
		try {
			
			// load mysql jdbc dirver
			Class.forName("com.mysql.jdbc.Driver");
			
			// connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront2", "root", "root");
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
		}
		return con;
	}
	
	/**
	 * Used to get the orders of particular user
	 * @param userId as int whose orders are to be fetched
	 * @return as int the number of orders of a user
	 */
	public int getOrders (int userId) {
		String query = "select o.id, o.dateOfOrder, o.amount from orders o join orderitems oi on o.id = oi.orderNumber where o.userId = ? and oi.status = 'Shipped' order by o.dateOfOrder";
		List<Order> orders = new ArrayList<Order>();
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet set = pstmt.executeQuery();
			
			while (set.next()) {
				orders.add(new Order(set.getInt("id"), set.getInt("amount"), set.getString("dateOfOrder")));
			}
			System.out.println("Total orders : " + orders.size());
			for (Order order : orders)
				System.out.println(order);
			con.close();
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return orders.size();
	}
	
	/**
	 * Used to show all categories of store front
	*/
	public void showCategories () {
		String query = "select c.name, count(cc.parentId) from category c left join category cc on cc.id = c.parentId group by cc.id";
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println("Query : " + query);
			ResultSet set = pstmt.executeQuery();
			List<Category> parentList = new ArrayList<Category>();
			while (set.next()) {
				parentList.add(new Category(set.getString(1), set.getInt(2)));
			}
			for (Category category : parentList) {
				System.out.println("Category : " + category.getName() + " Children : " + category.getNumOfChildren());
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Used to set such products to inactive mode which are not ordered in last year
	 * @return number of products which are set to inactive mode
	 */
	public int setInactive () {
		String query = "update product set active = 0 where id not in (select oi.productId from orderitems oi join orders o where o.id = oi.orderNumber"
				+ "and datediff(curdate(), o.dateOfOrder) < 365)";
		
		int inactiveProducts = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println("Query : " + query);
			inactiveProducts = pstmt.executeUpdate();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return inactiveProducts;
	}
	
	/**
	 * Used to add images of a product
	 * @param productId id of product as int whose images to be added
	 * @param images list of images for a particular product
	 * @return number of rows inserted
	 */
	public int addImage (int productId, List<String> images) {
		String query = "insert into image(productId, image) values(?, ?)";
		int[] result = null;
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			con.setAutoCommit(false);
			
			for (int count = 0; count < images.size(); count++) {
				pstmt.setInt(1, productId);
				pstmt.setString(2, images.get(count));
				pstmt.addBatch();
			}
			
			System.out.println("Query is : + " + query);
			
			result = pstmt.executeBatch();
			System.out.println("Number of rows inserted : " + result.length);
			con.commit();
			con.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return result.length;
	}
	
}
