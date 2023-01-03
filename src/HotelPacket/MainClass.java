package HotelPacket;

import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) throws SQLException {

		Hotels hotel = new Hotels();
		hotel.readFromTable();
		
		
		System.out.println("========================================");
		System.out.println("_          1-Create Tables             _");
		System.out.println("_          2-read From Table           _");
		System.out.println("_          3-Get By Id                 _");
		System.out.println("_          4-Update By Id              _");
		System.out.println("_          5-Delete By Id              _");
		System.out.println("_          6-MakeIs Active False By Id _");
		System.out.println("_          7-Insert Into Table         _");
		System.out.println("========================================");
		


	}

}
