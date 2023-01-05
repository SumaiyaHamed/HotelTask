package HotelPacket;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws SQLException {

		Hotels hotel = new Hotels();
		Scanner sc1 = new Scanner(System.in);
		// hotel.readFromTable();

		do {

			System.out.println("================================================");
			System.out.println("_          1-Create Tables                     _");
			System.out.println("_          2-read From Table                   _");
			System.out.println("_          3-Get By Id                         _");
			System.out.println("_          4-Update By Id                      _");
			System.out.println("_          5-Delete By Id                      _");
			System.out.println("_          6-MakeIs Active False By Id         _");
			System.out.println("_          7-Insert Into Table                 _");
			System.out.println("================================================");
			
			System.out.println("         -> please Select Option<-               ");
			int list=sc1.nextInt();


			//int list = 0;
			
			
			switch (list) {
			case 1:
				
				hotel.createTable();

				break;

			case 2:
				
				 hotel.readFromTable();

				break;

			case 3:
				

				break;

			case 4:
				
				hotel.updateById();

				break;

			case 5:
				
				hotel.deleteById();

				break;

			case 6:

				break;

			case 7:
				
				hotel.insertIntoTable();

				break;
			}

		} while (false);

	}

}
