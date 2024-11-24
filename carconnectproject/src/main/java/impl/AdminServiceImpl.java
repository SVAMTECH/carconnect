package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AdminService;
import entity.Admin;
import exception.AdminNotFoundException;
import util.DBConnectUtil;

public class AdminServiceImpl implements AdminService {

	@Override
	public Admin getAdminById(int adminId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Admin ad = null;
		try {
			pstmt=con.prepareStatement("select * from admin where AdminID=?");
			pstmt.setInt(1, adminId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				ad = new Admin(rs.getInt("AdminID"),rs.getString("FirstName"),rs.getString("Lastname"),rs.getString("Email"),rs.getString("PhoneNumber"),rs.getString("Username"),rs.getString("Password"),rs.getString("Role"),rs.getString("JoinDate"));
			}else {
				System.out.println("No data available");
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
		return ad;
		
	}

	@Override
	public Admin getAdminByUsername(String username) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Admin ad = null;
		try {
			pstmt=con.prepareStatement("select * from admin where Username=?");
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				ad = new Admin(rs.getInt("AdminID"),rs.getString("FirstName"),rs.getString("Lastname"),rs.getString("Email"),rs.getString("PhoneNumber"),rs.getString("Username"),rs.getString("Password"),rs.getString("Role"),rs.getString("JoinDate"));
			}else {
				System.out.println("No data available");
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
		return ad;
	}

	@Override
	public String registerAdmin(Admin adminData) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("insert into admin values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, adminData.getAdminID());
			pstmt.setString(2, adminData.getFirstName());
			pstmt.setString(3, adminData.getLastName());
			pstmt.setString(4, adminData.getEmail());
			pstmt.setString(5, adminData.getPhoneNo());
			pstmt.setString(6, adminData.getUsername());
			pstmt.setString(7, adminData.getPassword());
			pstmt.setString(8, adminData.getRole());
			pstmt.setString(9, adminData.getJoinDate());
			pstmt.executeUpdate();

            rs = "Data successfully added to database";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while inserting Admin details.....";
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
	public String updateAdmin(Admin adminData,int adminId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("update admin set FirstName=?,Lastname=?,Email=?,PhoneNumber=?,Username=?,Password=?,Role=?,JoinDate=? where AdminID=?");
			pstmt.setString(1, adminData.getFirstName());
			pstmt.setString(2, adminData.getLastName());
			pstmt.setString(3, adminData.getEmail());
			pstmt.setString(4, adminData.getPhoneNo());
			pstmt.setString(5, adminData.getUsername());
			pstmt.setString(6, adminData.getPassword());
			pstmt.setString(7, adminData.getRole());
			pstmt.setString(8, adminData.getJoinDate());
			pstmt.setInt(9, adminId);
			pstmt.executeUpdate();

            rs = "Data successfully updated to database";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while updating Admin details.....";
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
	public String deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("delete from admin where AdminID=?");
			pstmt.setInt(1, adminId);
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
			pstmt=con.prepareStatement("select * from admin where Username=? and Password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				r = true;
			}else {
				try {
				r = false;
				throw new AdminNotFoundException("Admin not found");
				}catch(AdminNotFoundException e) {
					System.err.println("Admin not found");
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
