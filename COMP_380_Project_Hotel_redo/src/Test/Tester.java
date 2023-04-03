//package Test;
//
//import Entities.Customer;
//import Entities.Employee;
//import Entities.HotelRoom;
//import Entities.Reservation;
//
//import java.sql.SQLException;
//import java.util.Calendar;
//
//import Controller.HotelController;
//
//public class Tester {
//
//	public static void main(String[] args) {
//		Customer customer = new Customer();
//		Employee employee = new Employee();
//		HotelRoom room = new HotelRoom();
//		Reservation reservation = new Reservation();
//
//		customer.setFirstName("John");
//		customer.setLastName("Doe");
//		customer.setPhoneNumber(0000000000);
//		customer.setAddress("1234 Null St.");
//		customer.setEmail("null@gmail.com");
//		customer.setCreditCardNumber(0000000000);
//
//		employee.setFirstName("Jane");
//		employee.setLastName("Dawn");
//		employee.setPhoneNumber(1111111111);
//		employee.setAddress("5678 Null St.");
//		employee.setEmail("null2@csun.edu");
//		employee.setPassword("Password234@N");
//
//		room.setRoomName("Single");
//		room.setAvailability(false);
//
//		reservation.setDate(null);
//		reservation.setCustomerName("ABCD");
//		reservation.setRoomNumber(1);
//
//
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.YEAR, 2023);
//		calendar.set(Calendar.DAY_OF_MONTH, 1);
//		calendar.set(Calendar.MONTH, 4); // January = 0, February = 1, March = 2, April = 3, May = 4, ...
//
//		java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
//
//
//		try {
//			HotelController.insertIntoCustomerTable(customer);
//			//HotelController.insertIntoEmployeeTable(employee);
//			//System.out.println(HotelController.authenticateEmployee("Jane Dawn", "Password234@N"));
//			//HotelController.removeFromCustomerTable("Jane Dawn", "Password234@N", "John Doe");
//
//			//HotelController.removeFromEmployeeTable("Jane Dawn", "Password234@N", "Jane Dawn");
//			Customer customer2 = HotelController.findCustomer("John Doe");
//			System.out.println(customer2.getFirstName());
//
//			Employee employee2 = HotelController.findEmployee("Jane Dawn");
//			System.out.println(employee2.getFirstName());
//
//			//HotelController.insertIntoHotelRoomTable(room);
//			//HotelController.insertIntoHotelRoomTable("Double", false);
//			//HotelController.insertIntoHotelRoomTable("King", true);
//			//HotelController.insertIntoHotelRoomTable("Queen", false);
//
//			HotelController.insertIntoReservationTable(customer, room, date);
//
//			//HotelRoom room2 = HotelController.findHotelRoom(2);
//			//System.out.println(room2.getRoomName());
//
//			//Reservation reservation2 = HotelController.findReservation("John Doe");
//			//System.out.println(reservation2.getCustomerName());
//
//
//
//			//HotelController.removeFromHotelRoomsTable("Jane Dawn", "Password234@N", 1);
//			//HotelController.removeFromHotelRoomsTable("Jane Dawn", "Password234@N", 2);
//			//HotelController.removeFromHotelRoomsTable("Jane Dawn", "Password234@N", 3);
//			//HotelController.removeFromHotelRoomsTable("Jane Dawn", "Password234@N", 4);
//
//			//HotelController.newReservation(customer, room, date);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//}
