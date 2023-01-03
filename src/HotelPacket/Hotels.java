package HotelPacket;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hotels {

	public static boolean createTable() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER not NULL, " + " hotel_name  VARCHAR(8), "
				+ " hotel_location VARCHAR(8), " + " created_date Date not null, " + " updated_date Date , "
				+ "is_Active Boolean not null , " + " PRIMARY KEY ( id ))";
		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			java.sql.Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return false;

	}

	public static void readFromTable() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		Scanner sc = new Scanner(System.in);

		// take input from user to see how many users you have to print on console

		System.out.println("how many users you want to print on console?");
		int s = sc.nextInt();

		// use SELECT query and ResultSets for showing
		String sql = "SELECT * FROM hotels";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			ResultSet resultSet = st.executeQuery(sql);

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String hotelName = resultSet.getString("hotel_name");
			}
		} catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}

	public static void getById() {

		// take id input from the user
		

		// print on console

		// use SELECT query and ResultSets for showing

	}

	public static void updateById() {

		// take id input from the user

		// print on console

		// use Update query and ResultSets for showing

	}

	public static void deleteById() {

		// take id input from the user

		// use Delete query

	}

	public static void makeIsActiveFalseById() {

		// take id input from the user

		// use Update query and just update 'is_Active' column

	}

	public static boolean insertIntoTable() {

		Scanner sa = new Scanner(System.in);

		// take input from user how many number of rows are to be inserted
		System.out.println("How many number of rows you want to add?");
		int a = sa.nextInt();

		// input data in database using INSERT query in a loop

		// Random rn = new Random();

		// Integer numberToAdd = rn.nextInt(100);

		// For string columns use: "yourName" + numberToAdd;

		// For Integer columns use: numberToAdd

		// For Boolean columns use: true

		return false;

	}

}
