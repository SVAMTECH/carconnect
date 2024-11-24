package entity;

public class Customer {
     
	  int CustomerID;
	  String FirstName;
	  String LastName;
	  String Email;
	  String PhoneNo;
	  String Address;
	  String Username;
	  String Password;
	  String RegistrationDate;
	  
	  public Customer(int customerID, String firstName, String lastName, String email, String phoneNo, String address,
			String username, String password, String registrationDate) {
	
		this.CustomerID = customerID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.PhoneNo = phoneNo;
		this.Address = address;
		this.Username = username;
		this.Password = password;
		this.RegistrationDate = registrationDate;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		this.CustomerID = customerID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.PhoneNo = phoneNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getRegistrationDate() {
		return RegistrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.RegistrationDate = registrationDate;
	}
	  
	public String toString() {
		
		return " ID : "+CustomerID+ ", Name : "+FirstName+" "+LastName+", Email : "+Email+", Phone no : "+PhoneNo+", Username : "+Username+", Password : "+Password+", Role : "+Address+", RegisteredDate : "+RegistrationDate;
		
	} 
	  
}
