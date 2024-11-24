package entity;

public class Reservation {
     
	   int ReservationID;
	   int CustomerID;
	   int VehicleID;
	   String StartDate;
	   String EndDate;
	   double TotalCost;
	   String Status;
	   
	   public Reservation(int reservationID, int customerID, int vehicleID, String startDate, String endDate,
			double totalCost, String status) {
		
		this.ReservationID = reservationID;
		this.CustomerID = customerID;
		this.VehicleID = vehicleID;
		this.StartDate = startDate;
		this.EndDate = endDate;
		this.TotalCost = totalCost;
		this.Status = status;
	}

	
	public int getReservationID() {
		return ReservationID;
	}

	
	public void setReservationID(int reservationID) {
		this.ReservationID = reservationID;
	}

	
	public int getCustomerID() {
		return CustomerID;
	}

	
	public void setCustomerID(int customerID) {
		this.CustomerID = customerID;
	}

	
	public int getVehicleID() {
		return VehicleID;
	}

	
	public void setVehicleID(int vehicleID) {
		this.VehicleID = vehicleID;
	}

	
	public String getStartDate() {
		return StartDate;
	}

	
	public void setStartDate(String startDate) {
		this.StartDate = startDate;
	}

	
	public String getEndDate() {
		return EndDate;
	}

	
	public void setEndDate(String endDate) {
		this.EndDate = endDate;
	}

	
	public double getTotalCost() {
		return TotalCost;
	}

	
	public void setTotalCost(double totalCost) {
		this.TotalCost = totalCost;
	}

	
	public String getStatus() {
		return Status;
	}

	
	public void setStatus(String status) {
		this.Status = status;
	}
	
	public String toString() {
		
		return " ReservationID : "+ReservationID+", CustomerID : "+CustomerID+", VehicleID : "+VehicleID+", StartDate : "+StartDate+", EndDate : "+EndDate+", TotalCost : "+TotalCost+", Status : "+Status;
	}
}
