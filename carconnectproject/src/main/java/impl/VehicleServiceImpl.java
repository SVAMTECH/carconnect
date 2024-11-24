package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.VehicleService;
import entity.Vehicle;
import exception.VehicleNotFoundException;
import util.DBConnectUtil;

public class VehicleServiceImpl implements VehicleService {

	@Override
	public Vehicle getVehicleById(int vehicleId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Vehicle vh = null;
		try {
			pstmt=con.prepareStatement("select * from vehicle where VehicleID=?");
			pstmt.setInt(1, vehicleId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vh = new Vehicle(rs.getInt("VehicleID"),rs.getString("Model"),rs.getString("Make"),rs.getInt("Year"),rs.getString("Color"),rs.getString("RegistrationNumber"),rs.getInt("Availability"),rs.getDouble("DailyRate"));
			}else {
				try {
				System.out.println("No data available");
				throw new VehicleNotFoundException("Vehicle not found");
				}catch(VehicleNotFoundException e) {
					System.err.println("Vehicle not found");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while finding Vehicle details");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return vh;
	}

	@Override
	public ArrayList<Vehicle> getAvailableVehicles() {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Vehicle vh = null;
		ArrayList<Vehicle> al = new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select * from vehicle where Availability=1");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vh = new Vehicle(rs.getInt("VehicleID"),rs.getString("Model"),rs.getString("Make"),rs.getInt("Year"),rs.getString("Color"),rs.getString("RegistrationNumber"),rs.getInt("Availability"),rs.getDouble("DailyRate"));
				al.add(vh);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error while finding Available Vehicle details");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return al;
	}

	@Override
	public String addVehicle(Vehicle vehicleData) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("insert into vehicle values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, vehicleData.getVehicleID());
			pstmt.setString(2, vehicleData.getModel());
			pstmt.setString(3, vehicleData.getMake());
			pstmt.setInt(4,vehicleData.getYear());
			pstmt.setString(5, vehicleData.getColor());
			pstmt.setString(6, vehicleData.getRegistrationNo());
			pstmt.setInt(7, vehicleData.getAvailability());
			pstmt.setDouble(8, vehicleData.getDailyRate());
			pstmt.executeUpdate();

            rs = "Data successfully added to database";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while inserting Vehicle details.....";
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
	public String updateVehicle(Vehicle vehicleData,int vehicleId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("update vehicle set Model=?,Make=?,Year=?,Color=?,RegistrationNumber=?,Availability=?,DailyRate=? where VehicleID=?");
			pstmt.setString(1, vehicleData.getModel());
			pstmt.setString(2, vehicleData.getMake());
			pstmt.setInt(3,vehicleData.getYear());
			pstmt.setString(4, vehicleData.getColor());
			pstmt.setString(5, vehicleData.getRegistrationNo());
			pstmt.setInt(6, vehicleData.getAvailability());
			pstmt.setDouble(7, vehicleData.getDailyRate());
			pstmt.setInt(8, vehicleId);
			pstmt.executeUpdate();
			
			rs = "Data successfully updated to database";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while updating Vehicle details.....";
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
	public String removeVehicle(int vehicleId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("delete from vehicle where VehicleID=?");
			pstmt.setInt(1, vehicleId);
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
      
}
