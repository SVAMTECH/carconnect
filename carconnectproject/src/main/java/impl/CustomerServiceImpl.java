package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CustomerService;
import entity.Admin;
import entity.Customer;
import exception.AuthenticationException;
import util.DBConnectUtil;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Customer c = null;
		try {
			pstmt=con.prepareStatement("select * from customer where customerID=?");
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				c = new Customer(rs.getInt("customerID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Email"),rs.getString("PhoneNumber"),rs.getString("Address"),rs.getString("Username"),rs.getString("Password"),rs.getString("RegistrationDate"));
			}else {
				System.out.println("No data available");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while finding Customer details");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return c;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Customer c = null;
		try {
			pstmt=con.prepareStatement("select * from customer where Username=?");
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				c = new Customer(rs.getInt("customerID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Email"),rs.getString("PhoneNumber"),rs.getString("Address"),rs.getString("Username"),rs.getString("Password"),rs.getString("RegistrationDate"));
			}else {
				System.out.println("No data available");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while finding Customer details");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return c;
	}

	@Override
	public String registerCustomer(Customer customerData) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, customerData.getCustomerID());
			pstmt.setString(2, customerData.getFirstName());
			pstmt.setString(3, customerData.getLastName());
			pstmt.setString(4,customerData.getEmail());
			pstmt.setString(5, customerData.getPhoneNo());
			pstmt.setString(6, customerData.getAddress());
			pstmt.setString(7, customerData.getUsername());
			pstmt.setString(8, customerData.getPassword());
			pstmt.setString(9, customerData.getRegistrationDate());
			pstmt.executeUpdate();

            rs = "Data successfully added to database";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while inserting customer details.....";
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return rs;
	}

	@Override
	public String updateCustomer(Customer customerData,int customerId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("update customer set FirstName=?,LastName=?,Email=?,PhoneNumber=?,Address=?,Username=?,Password=?,RegistrationDate=? where customerID=?");
			pstmt.setString(1, customerData.getFirstName());
			pstmt.setString(2, customerData.getLastName());
			pstmt.setString(3,customerData.getEmail());
			pstmt.setString(4, customerData.getPhoneNo());
			pstmt.setString(5, customerData.getAddress());
			pstmt.setString(6, customerData.getUsername());
			pstmt.setString(7, customerData.getPassword());
			pstmt.setString(8, customerData.getRegistrationDate());
			pstmt.setInt(9, customerId);
			pstmt.executeUpdate();

            rs = "Data successfully updated to database";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while updating customer details.....";
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return rs;
	}

	@Override
	public String deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("delete from customer where customerID=?");
			pstmt.setInt(1, customerId);
			pstmt.executeUpdate();
			rs = "Successfully deleted";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs = "Error occurred while removing the data";
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return rs;
	}

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Admin ad = null;
		boolean r = true;
		try {
			pstmt=con.prepareStatement("select * from customer where Username=? and Password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				r = true;
				
			}else {
				try {
				r = false;
				throw new AuthenticationException("User not found");
				}catch(AuthenticationException e) {
					System.err.println("user not found");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while finding Admin details");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return r;
	}

}
