package dao;

import java.util.ArrayList;

import entity.Vehicle;

public interface VehicleService {
        
	public Vehicle getVehicleById(int vehicleId);
	public ArrayList<Vehicle> getAvailableVehicles();
	public String addVehicle(Vehicle vehicleData);
	public String updateVehicle(Vehicle vehicleData,int vehicleId);
	public String removeVehicle(int  vehicleId);
}
