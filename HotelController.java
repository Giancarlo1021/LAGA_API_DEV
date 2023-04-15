package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import net.javaguides.postgresql.JDBCPostgreSQLConnect;
import Entities.Customer;
import Entities.Employee;
import Entities.HotelRoom;
import Entities.Reservation;

public class HotelController {
	private JDBCPostgreSQLConnect connection;

	// FIND ITEMS IN TABLES
	public static Customer findCustomer(String fullName) {
		String SQL = "SELECT fullname,phonenumber,email,address,creditcardnumber FROM customer WHERE fullname = ?";
		Customer newCustomer = new Customer();
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, fullName);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			String fullName2 = rs.getString("fullname");
			newCustomer.setFirstName(fullName2.substring(0, fullName2.indexOf(' ')));
			newCustomer.setLastName(fullName2.substring(fullName2.indexOf(' ') + 1));
			newCustomer.setPhoneNumber(rs.getInt("phonenumber"));
			newCustomer.setEmail(rs.getString("email"));
			newCustomer.setAddress(rs.getString("address"));
			newCustomer.setCreditCardNumber(rs.getInt("creditcardnumber"));
			
			return newCustomer;
						
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			newCustomer.setFirstName("N/A");
			newCustomer.setLastName("N/A");
			newCustomer.setPhoneNumber(0);
			newCustomer.setEmail("N/A");
			newCustomer.setAddress("N/A");
			newCustomer.setCreditCardNumber(0);
			
			return newCustomer;
		}
	}
	
	public static Employee findEmployee(String fullName) {
		String SQL = "SELECT fullname,phonenumber,email,address,password FROM employee WHERE fullname = ?";
		Employee newEmployee = new Employee();
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, fullName);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			String fullName2 = rs.getString("fullname");
			newEmployee.setFirstName(fullName2.substring(0, fullName2.indexOf(' ')));
			newEmployee.setLastName(fullName2.substring(fullName2.indexOf(' ') + 1));
			newEmployee.setPhoneNumber(rs.getInt("phonenumber"));
			newEmployee.setEmail(rs.getString("email"));
			newEmployee.setAddress(rs.getString("address"));
			newEmployee.setPassword(rs.getString("password"));
			
			return newEmployee;
						
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			newEmployee.setFirstName("N/A");
			newEmployee.setLastName("N/A");
			newEmployee.setPhoneNumber(0);
			newEmployee.setEmail("N/A");
			newEmployee.setAddress("N/A");
			newEmployee.setPassword("N/A");
			
			return newEmployee;
		}
	}
	
	public static HotelRoom findHotelRoom(int roomNumber) {
		String SQL = "SELECT roomnumber,room,status FROM hotelrooms WHERE roomnumber = ?";
		HotelRoom newHotelRoom = new HotelRoom();
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setInt(1, roomNumber);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			rs.next();
			newHotelRoom.setRoomNumber(rs.getInt("roomnumber"));
			newHotelRoom.setRoomName(rs.getString("room"));
			newHotelRoom.setAvailability(rs.getBoolean("status"));
			
			return newHotelRoom;
						
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			newHotelRoom.setRoomNumber(-1);
			newHotelRoom.setRoomName("Empty");
			newHotelRoom.setAvailability(true);
			
			return newHotelRoom;
		}
	}
	
	public static Reservation findReservation(String customerName, Date startDate, Date endDate) {
		String SQL = "SELECT startdate,customer,room,enddate,address,city,state,zipcode,creditCardNumber FROM reservations WHERE customer = ? AND startdate = ? AND enddate = ?";
		Reservation newReservation = new Reservation();
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, customerName);
			pstmt.setDate(2, startDate);
			pstmt.setDate(3, endDate);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			newReservation.setStartDate(rs.getDate("startdate"));
			newReservation.setCustomerName(rs.getString("customer"));
			newReservation.setRoomNumber(rs.getInt("room"));
			newReservation.setEndDate(rs.getDate("enddate"));
			newReservation.setAddress(rs.getString("address"));
			newReservation.setCity(rs.getString("city"));
			newReservation.setState(rs.getString("state"));
			newReservation.setZipcode(rs.getInt("zipcode"));
			newReservation.setCreditCardNumber(rs.getInt("creditCardNumber"));
			
			return newReservation;
						
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, 0000);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.MONTH, 1);
			
			newReservation.setStartDate(new java.sql.Date(calendar.getTime().getTime()));
			newReservation.setCustomerName("N/A");
			newReservation.setRoomNumber(-1);
			newReservation.setEndDate(new java.sql.Date(calendar.getTime().getTime()));
			newReservation.setAddress("");
			newReservation.setCity("");
			newReservation.setState("");
			newReservation.setZipcode(0);
			newReservation.setCreditCardNumber(0);
			
			return newReservation;
		}
	}
	public static Reservation findReservation(String customerName, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
		return findReservation(customerName, createDate(startYear, startDay, startMonth), createDate(endYear, endDay, endMonth));

	}
	
	// INSERT INTO TABLES
	public static boolean insertIntoCustomerTable(String fullName, int phoneNumber, String email, String address, int creditCardNumber) throws SQLException {
		String SQL = "INSERT INTO customer(fullname, phonenumber, email, address, creditCardNumber) "
				+ "VALUES(?,?,?,?,?)";
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, fullName);
			pstmt.setInt(2, phoneNumber);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setInt(5, creditCardNumber);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			return false;
		}
	}
	public static boolean insertIntoCustomerTable(Customer customer) throws SQLException {
		return insertIntoCustomerTable(customer.getFirstName() + " " + customer.getLastName(), customer.getPhoneNumber(), customer.getEmail(), customer.getAddress(), customer.getCreditCardNumber());
	}
	
	public static boolean insertIntoEmployeeTable(String fullName, int phoneNumber, String email, String address, String password) throws SQLException {
		String SQL = "INSERT INTO employee(fullname, phonenumber, email, address, password) "
				+ "VALUES(?,?,?,?,?)";
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, fullName);
			pstmt.setInt(2, phoneNumber);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setString(5, password);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			return false;
		}
		
	}
	public static boolean insertIntoEmployeeTable(Employee employee) throws SQLException {
		return insertIntoEmployeeTable(employee.getFirstName() + " " + employee.getLastName(), employee.getPhoneNumber(), employee.getEmail(), employee.getAddress(), employee.getPassword());
	}
	
	public static boolean insertIntoHotelRoomTable(String roomType, boolean bookingStatus) throws SQLException {
		String SQL = "INSERT INTO hotelrooms(room, status) "
				+ "VALUES(?,?)";
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, roomType);
			pstmt.setBoolean(2, bookingStatus);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			return false;
		}
		
	}
	public static boolean insertIntoHotelRoomTable(HotelRoom room) throws SQLException {
		return insertIntoHotelRoomTable(room.getRoomName(), room.getAvailability());
	}
	
	public static boolean insertIntoReservationTable(Customer customer, HotelRoom room, Date startDate, Date endDate, String address, String city, String state, int zipcode, int creditCardNumber) throws SQLException {
		Reservation reservation = findReservation(customer.getFirstName() + " " + customer.getLastName(), startDate, endDate);
		
		if (reservation.getCustomerName() == customer.getFirstName() + " " + customer.getLastName() && 
				(reservation.getStartDate() == startDate || reservation.getEndDate() == endDate)) {
			return false;
		} else {
			String SQL = "INSERT INTO reservations(startDate, customer, room, endDate, address, city, state, zipcode, creditCardNumber) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			
			try (Connection connection = JDBCPostgreSQLConnect.connect();
					PreparedStatement pstmt = connection.prepareStatement(SQL)) {
				
				pstmt.setDate(1, startDate);
				pstmt.setString(2, customer.getFirstName() + " " + customer.getLastName());
				pstmt.setInt(3, room.getRoomNumber());
				pstmt.setDate(4, endDate);
				pstmt.setString(5, address);
				pstmt.setString(6, city);
				pstmt.setString(7, state);
				pstmt.setInt(8, zipcode);
				pstmt.setInt(9, creditCardNumber);
				pstmt.executeUpdate();
				
				return true;			
				
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				
				return false;
			}
		}
	}	
	public static boolean insertIntoReservationTable(Customer customer, HotelRoom room, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear,
			String address, String city, String state, int zipcode, int creditCardNumber) throws SQLException {
		
		return insertIntoReservationTable(customer, room, createDate(startYear, startDay, startMonth), createDate(endYear, endDay, endMonth), 
				address, city, state, zipcode, creditCardNumber);
	}
	public static boolean insertIntoReservationTable(Customer customer, HotelRoom room, Date startDate, Date endDate) throws SQLException {
		return insertIntoReservationTable(customer, room, startDate, endDate, "", "", "", 0, 0);
	}
	public static boolean insertIntoReservationTable(Customer customer, HotelRoom room, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) throws SQLException {
		
		return insertIntoReservationTable(customer, room, createDate(startYear, startDay, startMonth), createDate(endYear, endDay, endMonth), "", "", "", 0, 0);
	}
	
	// UPDATE TABLES
	public static boolean updateCustomerTable(String fullName, int phoneNumber, String email, String address, int id) throws SQLException {
		String SQL = "UPDATE customer SET fullname = ?, phonenumber = ?, email = ?, address = ? WHERE id = ?";
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, fullName);
			pstmt.setInt(2, phoneNumber);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setInt(5, id);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			return false;
		}
		
	}
	public static boolean updateCustomerTable(Customer customer, int id) throws SQLException {
		return updateCustomerTable(customer.getFirstName() + " " + customer.getLastName(), customer.getPhoneNumber(), customer.getEmail(), customer.getAddress(), id);
	}

	public static boolean updateEmployeeTable(String fullName, int phoneNumber, String email, String address, String password, int id) throws SQLException {
		String SQL = "UPDATE employee SET fullname = ?, phonenumber = ?, email = ?, address = ?, password = ? WHERE id = ?";
	
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, fullName);
			pstmt.setInt(2, phoneNumber);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			pstmt.setString(5, password);
			pstmt.setInt(6, id);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			return false;
		}
		
	}
	public static boolean updateEmployeeTable(Employee employee, int id) throws SQLException {
		return updateEmployeeTable(employee.getFirstName() + " " + employee.getLastName(), employee.getPhoneNumber(), employee.getEmail(), employee.getAddress(), employee.getPassword(), id);
	}
	

	public static boolean updateHotelRoomsTable(int roomNumber, String roomType, boolean status) throws SQLException {
		String SQL = "UPDATE hotelrooms SET roomtype = ?, status = ? WHERE roomnumber = ?";
	
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, roomType);
			pstmt.setBoolean(2, status);
			pstmt.setInt(3, roomNumber);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			return false;
		}
		
	}

	public static boolean updateReservationTable(Customer customer, HotelRoom room, int id, Date startDate, Date endDate,
			String address, String city, String state, int zipcode, int creditCardNumber) throws SQLException {
		String SQL = "UPDATE reservations SET startDate = ?, customer = ?, room = ?, endDate = ?, address = ?, city = ?, state = ?, zipcode = ?, creditCardNumber = ? WHERE id = ?";
	
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			

			pstmt.setDate(1, startDate);
			pstmt.setObject(2, customer.getFirstName() + " " + customer.getLastName());
			pstmt.setInt(3, room.getRoomNumber());
			pstmt.setDate(4, endDate);
			pstmt.setString(5, address);
			pstmt.setString(6, city);
			pstmt.setString(7, state);
			pstmt.setInt(8, zipcode);
			pstmt.setInt(9, creditCardNumber);
			pstmt.setInt(10, id);
			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
			return false;
		}
		
	}
	public static boolean updateReservationTable(Customer customer, HotelRoom room, int id, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear, 
			String address, String city, String state, int zipcode, int creditCardNumber) throws SQLException {
		
		return updateReservationTable(customer, room, id, createDate(startYear, startDay, startMonth), createDate(endYear, endDay, endMonth), 
				address, city, state, zipcode, creditCardNumber);
	}
	public static boolean updateReservationTable(Customer customer, HotelRoom room, int id, Date startDate, Date endDate) throws SQLException {
		return updateReservationTable(customer, room, id, startDate, endDate, "", "", "", 0, 0);
	}
	public static boolean updateReservationTable(Customer customer, HotelRoom room, int id, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) throws SQLException {
		
		return updateReservationTable(customer, room, id, createDate(startYear, startDay, startMonth), createDate(endYear, endDay, endMonth));
	}
	
	
	// DELETE FROM TABLES
	public static boolean removeFromCustomerTable(String fullEmployeeName, String password, String fullCustomerName) throws SQLException {
		if (authenticateEmployee(fullEmployeeName, password)) {
			String SQL = "DELETE FROM customer WHERE fullname = ?";
			
			try (Connection connection = JDBCPostgreSQLConnect.connect();
					PreparedStatement pstmt = connection.prepareStatement(SQL)) {
				
				pstmt.setObject(1, fullCustomerName);
				
				pstmt.executeUpdate();
				
				return true;
				
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				
				return false;
			}
		}
		
		return false;
	}

	public static boolean removeFromEmployeeTable(String fullEmployeeName, String password, String fullEmployeeNameToRemove) throws SQLException {
		if ((fullEmployeeName != fullEmployeeNameToRemove) && authenticateEmployee(fullEmployeeName, password)) {
			String SQL = "DELETE FROM employee WHERE fullname = ?";
			
			try (Connection connection = JDBCPostgreSQLConnect.connect();
					PreparedStatement pstmt = connection.prepareStatement(SQL)) {
				
				pstmt.setObject(1, fullEmployeeNameToRemove);
				
				pstmt.executeUpdate();
				
				return true;
				
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				
				return false;
			}
		}
		
		return false;
	}
	
	public static boolean removeFromHotelRoomsTable(String fullEmployeeName, String password, int roomNumber) throws SQLException {
		if (authenticateEmployee(fullEmployeeName, password)) {
			String SQL = "DELETE FROM hotelrooms WHERE roomnumber = ?";
			
			try (Connection connection = JDBCPostgreSQLConnect.connect();
					PreparedStatement pstmt = connection.prepareStatement(SQL)) {
				
				pstmt.setObject(1, roomNumber);
				
				pstmt.executeUpdate();
				
				return true;
				
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				return false;
			}
		}
		
		return false;
	}
	
	public static boolean bookOrDebookRoom(int roomNumber, boolean status) throws SQLException {
		HotelRoom newHotelRoom = findHotelRoom(roomNumber);
		if (newHotelRoom.getRoomName().equals("Empty")) {
			return false;
		} else {
			updateHotelRoomsTable(newHotelRoom.getRoomNumber(), newHotelRoom.getRoomName(), status);
			return true;
		}
	}
	
	public static void removeFromReservationTable(String fullEmployeeName, String password, String customerName) throws SQLException {		
		if (authenticateEmployee(fullEmployeeName, password)) {
			String SQL = "SELECT room FROM reservations WHERE customer = ?";
			
			int roomNumber = -1;
			
			try (Connection connection = JDBCPostgreSQLConnect.connect();
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(SQL)) {
				
				rs.next();
				roomNumber = rs.getInt("room");
								
				bookOrDebookRoom(roomNumber, false);
				
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
			
			SQL = "DELETE FROM reservations WHERE customer = ?";
			
			try (Connection connection = JDBCPostgreSQLConnect.connect();
					PreparedStatement pstmt = connection.prepareStatement(SQL)) {
				
				pstmt.setObject(1, customerName);
				
				pstmt.executeUpdate();
				
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		
	}
	
	
	// Employee Authentication
	private static boolean authenticateEmployee(String fullEmployeeName, String password) {
		String SQL = "SELECT password FROM employee WHERE fullname = ?";
		
		try (Connection connection = JDBCPostgreSQLConnect.connect();
				PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			
			pstmt.setString(1, fullEmployeeName);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			return ((rs.getString(1).equals(password)));
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	// Date Creation
	public static Date createDate(int year, int day, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		
		return new java.sql.Date(calendar.getTime().getTime());
	}
}