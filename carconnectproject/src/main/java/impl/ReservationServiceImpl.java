package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ReservartionService;
import entity.Reservation;
import util.DBConnectUtil;

public class ReservationServiceImpl implements ReservartionService{

	@Override
	public Reservation getReservationById(int reservationId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Reservation rsv = null;
		try {
			pstmt=con.prepareStatement("select * from reservation where ReservationID=?");
			pstmt.setInt(1, reservationId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				rsv = new Reservation(rs.getInt("ReservationID"),rs.getInt("CustomerID"),rs.getInt("VehicleID"),rs.getString("StartDate"),rs.getString("EndDate"),rs.getDouble("TotalCost"),rs.getString("Status"));
			}else {
				System.out.println("No data available");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while finding Reservation details");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error occurred while closing connection");
			}
		}
		return rsv;
	}

	@Override
	public ArrayList<Reservation> getReservationsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		Reservation rsv = null;
		ArrayList<Reservation> al = new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select * from reservation where CustomerID=?");
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				rsv = new Reservation(rs.getInt("ReservationID"),rs.getInt("CustomerID"),rs.getInt("VehicleID"),rs.getString("StartDate"),rs.getString("EndDate"),rs.getDouble("TotalCost"),rs.getString("Status"));
				al.add(rsv);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while finding Reservation details");
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
	public String createReservation(Reservation reservationData) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("insert into reservation values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, reservationData.getReservationID());
			pstmt.setInt(2, reservationData.getCustomerID());
			pstmt.setInt(3, reservationData.getVehicleID());
			pstmt.setString(4,reservationData.getStartDate());
			pstmt.setString(5, reservationData.getEndDate());
			pstmt.setDouble(6, reservationData.getTotalCost());
			pstmt.setString(7, reservationData.getStatus());
			
			pstmt.executeUpdate();

            rs = "Data successfully added to database";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while inserting Reservation details.....";
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
	public String updateReservation(Reservation reservationData,int reservationId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("update reservation set CustomerID=?,VehicleID=?,StartDate=?,EndDate=?,TotalCost=?,Status=? where ReservationID=?");
			
			pstmt.setInt(1, reservationData.getCustomerID());
			pstmt.setInt(2, reservationData.getVehicleID());
			pstmt.setString(3,reservationData.getStartDate());
			pstmt.setString(4, reservationData.getEndDate());
			pstmt.setDouble(5, reservationData.getTotalCost());
			pstmt.setString(6, reservationData.getStatus());
			pstmt.setInt(7, reservationId);
			
			pstmt.executeUpdate();
			
			rs = "Data successfully updated to database";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while updating Reservation details.....";
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
	public String cancelReservation(int reservationId) {
		// TODO Auto-generated method stub
		Connection con = DBConnectUtil.getConnection();
		PreparedStatement pstmt=null;
		String rs;
		try {
			pstmt=con.prepareStatement("update reservation set Status='Cancelled' where ReservationID=?");
			
			pstmt.setInt(1, reservationId);
			
			pstmt.executeUpdate();
			
			rs = "Reservation successfully cancelled";
		}catch(SQLException ex) {
			ex.printStackTrace();
			rs="Error while cancelling Reservation details.....";
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

}
