package HotelPacket;

import java.sql.Driver;
import java.sql.DriverManager;

public class Guests {
	
public static boolean createGuestsTable() {
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Guests "+
		"(id INTEGER not NULL, "
				+"guest_name VARCHAR(20)not NULL, "
				+ " guest_phone VARCHAR(20)not NULL, "
				+"guest_accompanying_members INTEGER not NULL,"
				+"guest_payment_amount INTEGER not NULL,"
				+"room_id"+"REFRENCE Rooms(id),"
				+"hotel_id+"+"REFRENCE Hotels(id),"
				+ " created_date Date not NULL, " 
				+" updated_date Date , " +
				"is_Active Boolean not NULL , " +
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


}
