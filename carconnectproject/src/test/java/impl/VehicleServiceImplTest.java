package impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entity.Vehicle;

class VehicleServiceImplTest {

	@Test
	void testgetVehicle() {
		VehicleServiceImpl vs = new VehicleServiceImpl();
		List<Vehicle> vl = vs.getAvailableVehicles();
		boolean actual = vl.isEmpty();
		boolean expected = false;
		Assertions.assertEquals(expected,actual);
	}
   
	@Test
	void testaddVehicle() {
		Scanner sc = new Scanner(System.in);
		VehicleServiceImpl vs = new VehicleServiceImpl();
		 String actual = null;
		 try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
		 System.out.println("Enter the vehicle details");
		 System.out.println("Enter Vehicle ID : ");
		 int id = sc.nextInt();
		 System.out.println("Enter Vehicle Model : ");
		 String model = reader.readLine();
		 System.out.println("Enter Vehicle Make : ");
		 String make = reader.readLine();
		 System.out.println("Enter Vehicle Year : ");
		 int year = sc.nextInt();
		 System.out.println("Enter Vehicle Color : ");
		 String color = reader.readLine();
		 System.out.println("Enter Vehicle RegistrationNo : ");
		 String rno = reader.readLine();
		 System.out.println("Enter Vehicle Availabilty : ");
		 int av = sc.nextInt();
		 System.out.println("Enter Vehicle DailyRate : ");
		 double dr = sc.nextDouble();
		 
		 Vehicle v = new Vehicle(id,model,make,year,color,rno,av,dr);
		 
		 actual = vs.addVehicle(v);
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
	 
		String expected = "Data successfully added to database";
		Assertions.assertEquals(expected,actual);
	}
	
	@Test
	void testUpdateVehicle() {
		Scanner sc = new Scanner(System.in);
		VehicleServiceImpl vs = new VehicleServiceImpl();
		 String actual = null;
		 try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
		 System.out.println("Enter the vehicle details");
		 System.out.println("Enter Vehicle ID : ");
		 int id = sc.nextInt();
		 System.out.println("Enter Vehicle Model : ");
		 String model = reader.readLine();
		 System.out.println("Enter Vehicle Make : ");
		 String make = reader.readLine();
		 System.out.println("Enter Vehicle Year : ");
		 int year = sc.nextInt();
		 System.out.println("Enter Vehicle Color : ");
		 String color = reader.readLine();
		 System.out.println("Enter Vehicle RegistrationNo : ");
		 String rno = reader.readLine();
		 System.out.println("Enter Vehicle Availabilty : ");
		 int av = sc.nextInt();
		 System.out.println("Enter Vehicle DailyRate : ");
		 double dr = sc.nextDouble();
		 
		 Vehicle v = new Vehicle(id,model,make,year,color,rno,av,dr);
		 
		 actual = vs.updateVehicle(v,id);
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
	 
		String expected = "Data successfully updated to database";
		Assertions.assertEquals(expected,actual);
	}
}
