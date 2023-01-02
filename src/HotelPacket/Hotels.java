package HotelPacket;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hotels {
	
	public static boolean createTable() {
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Hotels "+
		"(id INTEGER not NULL, "
				+ " hotel_name  VARCHAR(8), "
				+ " hotel_location VARCHAR(8), "
				+ " created_date Date not null, " +
				" updated_date Date , " +
				"is_Active Boolean not null , " +
				" PRIMARY KEY ( id ))";
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
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		return false;

	      
	}

		public static void readFromTable() {

		// take input from user to see how many users you have to print on console

		// use SELECT query and ResultSets for showing
			
			

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

		public void insertIntoTable() {

		// take input from user how many number of rows are to be inserted

		// input data in database using INSERT query in a loop

		// Random rn = new Random();

		// Integer numberToAdd = rn.nextInt(100);

		// For string columns use: "yourName" + numberToAdd;

		// For Integer columns use: numberToAdd

		// For Boolean columns use: true

		}

}
