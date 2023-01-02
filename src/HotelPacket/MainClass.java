package HotelPacket;

public class MainClass {

	public static void main(String[] args) {


		Hotels hotel=new Hotels();
		hotel.createTable();
		hotel.readFromTable();
		
		Employee_Type employeetype = new Employee_Type();
		employeetype.createEmployeeTypeTable();

	}

}
