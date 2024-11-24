package main;

import impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.Admin;
import entity.Customer;
import entity.Reservation;
import entity.Vehicle;

public class MainModule {
	
	 public void insert() {
		 Scanner sc = new Scanner(System.in);
		 VehicleServiceImpl vs = new VehicleServiceImpl();
		 
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
		 
		 System.out.println(vs.addVehicle(v));
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
	 }
	 
	 public void insertAdmin() {
		 Scanner sc = new Scanner(System.in);
		 AdminServiceImpl as = new AdminServiceImpl();
		 
		 try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
		 System.out.println("Enter the Admin details");
		 System.out.println("Enter Admin ID : ");
		 int id = sc.nextInt();
		 System.out.println("Enter First Name : ");
		 String fname = reader.readLine();
		 System.out.println("Enter Last Name : ");
		 String lname = reader.readLine();
		 System.out.println("Enter Email : ");
		 String email = reader.readLine();
		 System.out.println("Enter Phone Number : ");
		 String phone = reader.readLine();
		 System.out.println("Enter User name : ");
		 String uname = reader.readLine();
		 System.out.println("Enter Password : ");
		 String ps = reader.readLine();
		 System.out.println("Enter Admin Role : ");
		 String role = reader.readLine();
		 
		 LocalDate currentDate = LocalDate.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     String jd = currentDate.format(formatter);
		 
		 Admin ad = new Admin(id,fname,lname,email,phone,uname,ps,role,jd);
		 
		 System.out.println(as.registerAdmin(ad));
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
	 }
	 
	 private void insertCustomer() {
			// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 CustomerServiceImpl cs = new CustomerServiceImpl();
		 
		 try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
		 System.out.println("Enter the User details");
		 System.out.println("Enter User ID : ");
		 int id = sc.nextInt();
		 System.out.println("Enter First Name : ");
		 String fname = reader.readLine();
		 System.out.println("Enter Last Name : ");
		 String lname = reader.readLine();
		 System.out.println("Enter Email : ");
		 String email = reader.readLine();
		 System.out.println("Enter Phone Number : ");
		 String phone = reader.readLine();
		 System.out.println("Enter User Address : ");
		 String add = reader.readLine();
		 System.out.println("Enter User name : ");
		 String uname = reader.readLine();
		 System.out.println("Enter Password : ");
		 String ps = reader.readLine();
		 
		 
		 LocalDate currentDate = LocalDate.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     String jd = currentDate.format(formatter);
		 
		 Customer ad = new Customer(id,fname,lname,email,phone,add,uname,ps,jd);
		 
		 System.out.println(cs.registerCustomer(ad));
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
		}
	 
	 public void getadminbyId() {
		 AdminServiceImpl ad = new AdminServiceImpl();
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Admin ID :");
		 int n = sc.nextInt();
		 Admin rs = ad.getAdminById(n);
		 System.out.println(rs.toString());
	 }
	 
	 public void getadminbyUsername() {
		 AdminServiceImpl ad = new AdminServiceImpl();
			
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter User name :");
		 String n = sc.next();
		 Admin rs = ad.getAdminByUsername(n);
		 System.out.println(rs.toString());
	 }
	 
	 public void updateAdmin() {
		 
	 }
	 
	 public void deleteAdmin() {
		 AdminServiceImpl ad = new AdminServiceImpl();
			
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Admin ID to delete:");
		 int n = sc.nextInt();
		 String rs = ad.deleteAdmin(n);
		 System.out.println(rs);
	 }
	 
	 public void addVehicle() {
		 Scanner sc = new Scanner(System.in);
		 VehicleServiceImpl vs = new VehicleServiceImpl();
		 
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
		 
		 System.out.println(vs.addVehicle(v));
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
	 }
	 
	 public void removeVehicle() {
		 VehicleServiceImpl vs = new VehicleServiceImpl();
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter vehicle ID to delete:");
		 int n = sc.nextInt();
		 String rs = vs.removeVehicle(n);
		 System.out.println(rs);
	 }
	 
	 public void updateVehicledetails() {
		 Scanner sc = new Scanner(System.in);
		 VehicleServiceImpl vs = new VehicleServiceImpl();
		 
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
		 
		 System.out.println(vs.updateVehicle(v,id));
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
	 }
	 
	 public void updateCustomer() {
		 Scanner sc = new Scanner(System.in);
		 CustomerServiceImpl cs = new CustomerServiceImpl();
		 
		 try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
		 System.out.println("Enter the User details");
		 System.out.println("Enter User ID : ");
		 int id = sc.nextInt();
		 System.out.println("Enter First Name : ");
		 String fname = reader.readLine();
		 System.out.println("Enter Last Name : ");
		 String lname = reader.readLine();
		 System.out.println("Enter Email : ");
		 String email = reader.readLine();
		 System.out.println("Enter Phone Number : ");
		 String phone = reader.readLine();
		 System.out.println("Enter User Address : ");
		 String add = reader.readLine();
		 System.out.println("Enter User name : ");
		 String uname = reader.readLine();
		 System.out.println("Enter Password : ");
		 String ps = reader.readLine();
		 
		 
		 LocalDate currentDate = LocalDate.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     String jd = currentDate.format(formatter);
		 
		 Customer ad = new Customer(id,fname,lname,email,phone,add,uname,ps,jd);
		 
		 System.out.println(cs.updateCustomer(ad,id));
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
	 }
	 
	 public void deleteCustomer() {
		 Scanner sc = new Scanner(System.in);
		 CustomerServiceImpl cs = new CustomerServiceImpl();
		 System.out.println("Enter Customer ID to delete:");
		 int n = sc.nextInt();
		 String rs = cs.deleteCustomer(n);
		 System.out.println(rs);
	 }
	 
	 public void getAvailableVehicle () {
		 VehicleServiceImpl vs = new VehicleServiceImpl();
		 List<Vehicle> vl = new ArrayList<>();
		 vl = vs.getAvailableVehicles();
		 for(Vehicle v:vl) {
			System.out.println(v.toString());
		 }
	 }
	 
	 public void bookVehicle () {
		 Scanner sc = new Scanner(System.in);
		 ReservationServiceImpl rsv = new ReservationServiceImpl();
		 VehicleServiceImpl vs = new VehicleServiceImpl();
		 
		 try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
		 System.out.println("Enter the booking details");
		 System.out.println("Enter Reservation ID : ");
		 int id = sc.nextInt();
		 System.out.println("Enter Customer ID : ");
		 int cid = sc.nextInt();
		 System.out.println("Enter Vehicle ID : ");
		 int vid = sc.nextInt();
		 System.out.println("Enter Start date : ");
		 String sdate = reader.readLine();
		 System.out.println("Enter End date : ");
		 String edate = reader.readLine();
		 
		 Vehicle vehicle = vs.getVehicleById(vid);
		 double cost = vehicle.getDailyRate();
         
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 
		 Date d1 = null;
		try {
			d1 = sdf.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         Date d2 = null;
		try {
			d2 = sdf.parse(edate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         long difference_In_Time = d2.getTime() - d1.getTime();
         long daycount = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
         double totalcost = cost*(daycount+1);
         
         
		 Reservation rs = new Reservation(id,cid,vid,sdate,edate,totalcost,"Active");
		 
		 System.out.println(rsv.createReservation(rs));
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
	 }
	 
	 public void cancelVehicle() {
		 ReservationServiceImpl rsv = new ReservationServiceImpl();
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter Reservation ID :");
		 int n = sc.nextInt();
		 String s = rsv.cancelReservation(n);
		 System.out.println(s);
	 }
	 
	 public void getVehiclebyid() {
		 VehicleServiceImpl vs = new VehicleServiceImpl();
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter vehicle id:");
		 int n = sc.nextInt();
		 Vehicle s = null;
		 try{
		 s = vs.getVehicleById(n);
		 System.out.println(s.toString());
	    }catch(NullPointerException e) {
	    	System.out.println("Output is null");
	    }
	    	
	 }
	 
	 public void adminfunctions() {
		    MainModule mm = new MainModule();
		    Scanner sc = new Scanner(System.in);
		    
	        do {
	       
	          System.out.println("To get admin by id - 1");
	          System.out.println("To get admin by username - 2");
	          System.out.println("To Update Admin details - 3");
	          System.out.println("To delete Admin - 4");
	          System.out.println("To add Vehicle details - 5");
	          System.out.println("To remove Vehicle details - 6");
	          System.out.println("To update Vehicle details - 7");
	          System.out.println("To get Vehicle by id - 8");
	          
	          int n = sc.nextInt();
	          
	          switch(n) {
		          case 1:
		        	   mm.getadminbyId();
		        	    break; 
		          case 2:
		        	   mm.getadminbyUsername();
		        	    break;
		          case 3:
		        	   mm.updateAdmin();
		        	    break;
		          case 4:
		        	   mm.deleteAdmin();
		        	    break;
		          case 5:
		        	   mm.addVehicle();
		        	    break;
		          case 6:
		        	   mm.removeVehicle();
		        	    break;
		          case 7:
		        	   mm.updateVehicledetails();
		        	    break;
		          case 8:
		        	  mm.getVehiclebyid();
		        	  break;
		          default:
		        	  System.out.println("Invalid input");
	          }
	            
	        } while (true);
			 
		 
	 }
	 
	 
	 public void customerfunctions() {
		 Scanner sc = new Scanner(System.in);
		 MainModule mm = new MainModule();
		    
		    
	        do {
	        	
	        	
	          System.out.println("To Update Customer details - 1");
	          System.out.println("To delete Customer - 2");
	          System.out.println("To see available Vehicle details - 3");
	          System.out.println("To book a Vehicle - 4");
	          System.out.println("To cancel a Vehicle - 5");
		      int  n = sc.nextInt();
		          
	         
	          switch(n) {
		          case 1:
		        	   mm.updateCustomer();
		        	    break; 
		          case 2:
		        	   mm.deleteCustomer();
		        	    break;
		          case 3:
		        	   mm.getAvailableVehicle();
		        	    break;
		          case 4:
		        	   mm.bookVehicle();
		        	    break;
		          case 5:
		        	   mm.cancelVehicle();
		        	    break;
		          default:
		        	  System.out.println("Invalid input");
		          
	          }
	            
	        } while (true);
			 
		 
	 }
      
	 public static void main(String args[]) {
         
		 Scanner sc = new Scanner(System.in);
		 AdminServiceImpl as = new  AdminServiceImpl();
		 CustomerServiceImpl cs = new CustomerServiceImpl();
		 System.out.println("Admin 1\nUser 2\n");
		 MainModule mn = new MainModule();
		 int in = sc.nextInt();
		 
		 if(in == 1) {
			 System.out.println("Login 1\nRegister 2\n");
			 int inp = sc.nextInt();
			 if(inp==1) {
			    System.out.println("Enter User name :");
			    String un = sc.next();
			    System.out.println("Enter Admin password :");
			    String ps = sc.next();
			    boolean r = as.authenticate(un,ps);
			    
			    if(r) {
			    	mn.adminfunctions();
			    }else {
			    	System.out.println("Admin not found");
			    }
			 }else {
				 mn.insertAdmin();
				 mn.adminfunctions();
			 }
			 
			
		 }else {
			 System.out.println("Login 1\nRegister 2\n");
			 int inp = sc.nextInt();
			 if(inp==1) {
			    System.out.println("Enter user name :");
			    String un = sc.next();
			    System.out.println("Enter user password :");
			    String ps = sc.next();
			    boolean r = cs.authenticate(un,ps);
			    
			    if(r) {
			    	mn.customerfunctions();
			    }else {
			    	System.out.println("User not found");
			    }
			 }else {
				 mn.insertCustomer();
				 mn.customerfunctions();
			 }
		 }
		 
	 }

	
}
