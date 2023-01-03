package HotelPacket;

import java.sql.Driver;
import java.sql.DriverManager;

public class Rooms {
	
public static boolean createRoomsTable() {
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Rooms "+
		"(id INTEGER not NULL, "
				+ " Room_type_id " +"REFRENCE Room_Type(id)," 
				+"hotel_id"+"REFRENCE Hotels(id)," 
				+ " created_date Date, " +
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

}
