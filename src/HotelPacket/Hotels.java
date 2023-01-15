package HotelPacket;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
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
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
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
		String sql = "SELECT * FROM Hotels";

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

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Scanner sa = new Scanner(System.in);
		System.out.println("id input from the user:");
		int user = sa.nextInt();
		String sql = "select * from Hotels where id =" + user;
		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 0;
			while (resultSet.next() && count < user) {
				Integer id = resultSet.getInt(1);
				String hotel_name = resultSet.getString(2);
				String hotel_location = resultSet.getString(3);
				Date created_date = resultSet.getDate(4);
				Date updated_date = resultSet.getDate(5);
				Boolean is_Active = resultSet.getBoolean(6);
				System.out.println(id + 1 + " " + hotel_name + 1 + " " + hotel_location + 1 + " " + created_date + 1
						+ " " + updated_date + 1 + " " + is_Active);
				count++;
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void updateById() {

		// take id input from the user

		// print on console

		// use Update query and ResultSets for showing
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
			}
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is created successfully:");
			stmt = (Statement) conn.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter any id to Update hotel data :");
			int userinput = scanner.nextInt();
			System.out.println("Please Enter the new Hotel name:");
			String hotelname = scanner.next();
			System.out.println("Please Enter the new Hotel location:");
			String hotellocatin = scanner.next();

			Statement st = conn.createStatement();
			String sql = "UPDATE Hotels SET hotel_name='" + hotelname + "',hotel_location='" + hotellocatin
					+ "' WHERE id='" + userinput + "'";
			int result = st.executeUpdate(sql);
			System.out.println("updated  successfully...");
		} catch (SQLException excep) {
			excep.printStackTrace();
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Please check it in the MySQL Table.......");

	}
	
	
	
	
	

	public static void deleteById() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
			}
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is created successfully:");
			stmt = (Statement) conn.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter any id to delete hotel data :");
			int userinput = scanner.nextInt();
			Statement st = conn.createStatement();
			String sql = "delete from Hotels where id ='" + userinput + "'";
			int result = st.executeUpdate(sql);
			System.out.println("Record has been delete in the table successfully..................");
		} catch (SQLException excep) {
			excep.printStackTrace();
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Please check it in the MySQL Table. Record is now delete.......");

	}
	
	
	
	

	public static void makeIsActiveFalseById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			String sql = "UPDATE Hotels SET is_Active=false LIMIT 10 ;";
			int result = st.executeUpdate(sql);
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	
	
	

	public static void insertIntoTable() {

		Scanner sa = new Scanner(System.in);

		System.out.println("How many number of rows you want to add?");
		int a = sa.nextInt();

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		String user = "root";
		String pass = "root";
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		
		String hotel_name = "WEAM";
		String hotel_location = "MUSCAT";
		String created_date = "2022-06-20";
		String updated_date = "2025-05-20";
		int is_Active = 1;

		for (int i = 0; i < a; i++) {

			String sql = "INSERT INTO  Hotels VALUES (" + i + numberToAdd + ",'" + (hotel_name + i) + "','"
					+ (hotel_location + i) + "','" + (created_date + "/" + i) + "','" + (updated_date + "/" + i) + "',"
					+ (is_Active + i) + ")";
			java.sql.Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url, user, pass);
				java.sql.Statement st = conn.createStatement();
				int m = st.executeUpdate(sql);
				if (m >= 1) {
					System.out.println("inserted data successfuly...");

				} else {
					System.out.println(" faild inserted data...");
				}
				conn.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}

		}

	}
	
	
	
	

//	public static void insert10000Hotels() {
//
//	}
//	
//	
//	
//
//	public static void insertOneHotels() {
//		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//		String username = "root";
//		String password = "root";
//		Scanner sa = new Scanner(System.in);
//		System.out.println("Enter how many rows you want:");
//		int user = sa.nextInt();
//		Random rn = new Random();
//		Integer numberToAdd = rn.nextInt(100);
//		String hotel_name = "ISRA";
//		String hotel_location = "MUSCAT";
//		String created_date = "2023-01-10";
//		String updated_date = "2022-05-12";
//		Integer is_Active = 1;
//		for (int i = 1; i <= 1; i++) {
//			String sql = "INSERT INTO  Hotels VALUES (" + i + numberToAdd + ",'" + (hotel_name + i) + "','"
//					+ hotel_location + "','" + created_date + "','" + updated_date + "'," + is_Active + ")";
//			java.sql.Connection conn = null;
//			try {
//				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
//				DriverManager.registerDriver(driver);
//				conn = DriverManager.getConnection(url, username, password);
//				java.sql.Statement st = conn.createStatement();
//				int m = st.executeUpdate(sql);
//				if (m >= 1) {
//					System.out.println("inserted data successfuly...");
//				} else {
//					System.out.println(" faild inserted data...");
//				}
//				conn.close();
//			} catch (Exception ex) {
//				System.err.println(ex);
//			}
//		}
//	}
//	
	
	

//	public static void printTenhotels() {
//
//	}
//	
//	
//	
//	
//
//	public static void makeFirstTenHotelsIsActiveFalse() {
//
//	}
//	
//	
//	

}
