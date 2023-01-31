import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassicModels {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root","test");
			System.out.println("Successful Connection to Mysql ");
			Statement stmt = connection.createStatement();
			String query1 = "SELECT customers.customerNumber,customers.customerName,SUM(orderdetails.priceEach * orderdetails.quantityOrdered) AS total_order_cost FROM customers INNER JOIN orders ON customers.customerNumber = orders.customerNumber INNER JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber WHERE orders.orderDate BETWEEN '2003-02-01' AND '2003-05-01' GROUP BY customers.customerNumber ORDER BY total_order_cost DESC Limit 1";

			String query2 = "SELECT customers.customerName, SUM(orderdetails.priceEach * orderdetails.quantityOrdered) AS total_cost, orders.orderDate FROM customers JOIN orders ON customers.customerNumber = orders.customerNumber JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber WHERE orders.orderDate BETWEEN '2003-02-01' AND '2003-05-01' GROUP BY customers.customerName, orders.orderDate ORDER BY total_cost DESC LIMIT 1";

			String query3 = "SELECT\n" + " customers.customerName,\n"
					+ " SUM(orderdetails.priceEach * orderdetails.quantityOrdered) AS total_cost,\n"
					+ " orders.orderDate\n" + "FROM\n" + " customers\n"
					+ " JOIN orders ON customers.customerNumber = orders.customerNumber\n"
					+ " JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber\n" + "WHERE\n"
					+ " orders.orderDate BETWEEN '2003-02-01' AND '2003-05-01'\n" + "GROUP BY\n"
					+ " customers.customerName, orders.orderDate\n" + "ORDER BY\n" + " total_cost DESC\n" + "LIMIT 5;";

			String query4 = "SELECT\n" + " customers.customerName,\n"
					+ " SUM(orderdetails.priceEach * orderdetails.quantityOrdered) AS total_cost,\n"
					+ " orders.orderDate\n" + "FROM\n" + " customers\n"
					+ " JOIN orders ON customers.customerNumber = orders.customerNumber\n"
					+ " JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber\n" + "WHERE\n"
					+ " orders.orderDate BETWEEN '2003-02-01' AND '2003-05-01'\n" + "GROUP BY\n"
					+ " customers.customerName, orders.orderDate\n" + "ORDER BY\n" + " total_cost DESC;";

			String query5 = "SELECT concat(customers.contactFirstName,customers.contactLastName)as contactFullName,sum(orderdetails.priceEach * orderdetails.quantityOrdered) as totalCredits,\n"
					+ " date(orders.orderDate) as date\n" + "FROM\n" + " customers\n"
					+ " JOIN orders ON customers.customerNumber = orders.customerNumber\n"
					+ " JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber\n" + "WHERE\n"
					+ " orders.orderDate BETWEEN '2003-02-01' AND '2003-05-01'\n" + "GROUP BY\n"
					+ " customers.customerNumber, date(orders.orderDate)\n" + "ORDER BY\n" + " totalCredits DESC;";
			System.out.println("Query 1\n");
			print(stmt.executeQuery(query1));
			System.out.println("Query 2\n");
			print(stmt.executeQuery(query2));
			System.out.println("Query 3\n");
			print(stmt.executeQuery(query3));
			System.out.println("Query 4\n");
			print(stmt.executeQuery(query4));
			System.out.println("Query 5\n");
			print(stmt.executeQuery(query5));
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void print(ResultSet executeQuery) {
		try {
			while (executeQuery.next()) {
				System.out.println("");
				System.out.println(executeQuery.getString(1) + " | " + executeQuery.getString(2) + " | "
						+ executeQuery.getString(3));
			}
			System.out.println("======================================================================\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}