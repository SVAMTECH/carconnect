package impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entity.Customer;

class CustomerServiceImplTest {

	@Test
	void testCustomerUpdate() {
		 Scanner sc = new Scanner(System.in);
		 CustomerServiceImpl cs = new CustomerServiceImpl();
		 String actual = null;
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
		 
		 actual = cs.updateCustomer(ad,id);
		 }catch(IOException e) {
			 e.printStackTrace();
			 System.out.println("Error occurred while reading string input");
		 }
		 String expected = "Data successfully updated to database";
		 Assertions.assertEquals(expected, actual);
	}

}
