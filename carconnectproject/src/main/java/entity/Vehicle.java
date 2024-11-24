package entity;

public class Vehicle {
      
	  int VehicleID;
	  String Model;
	  String Make;
	  int Year;
	  String Color;
	  String RegistrationNo;
	  int Availability;
	  double DailyRate;
	  
	  public Vehicle(int vehicleID, String model, String make, int year, String color, String registrationNo,
			int availability, double dailyRate) {
		
		this.VehicleID = vehicleID;
		this.Model = model;
		this.Make = make;
		this.Year = year;
		this.Color = color;
		this.RegistrationNo = registrationNo;
		this.Availability = availability;
		this.DailyRate = dailyRate;
	}

	public int getVehicleID() {
		return VehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.VehicleID = vehicleID;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		this.Model = model;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		this.Make = make;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		this.Year = year;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		this.Color = color;
	}

	public String getRegistrationNo() {
		return RegistrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.RegistrationNo = registrationNo;
	}

	public int getAvailability() {
		return Availability;
	}

	public void setAvailability(int availability) {
		this.Availability = availability;
	}

	public double getDailyRate() {
		return DailyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.DailyRate = dailyRate;
	}
	
	@Override
	public String toString() {
		return "VehicleID=" + VehicleID + ", Model=" + Model + ", Make=" + Make + ", Year=" + Year + ", Color="
				+ Color + ", RegistrationNo=" + RegistrationNo + ", Availability=" + Availability + ", DailyRate="
				+ DailyRate;
	}
}
