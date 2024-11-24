package entity;


public class Admin {
      
	   int AdminID;  
       String FirstName;
	   String LastName;
	   String Email;
	   String PhoneNo;
	   String Username;
	   String Password;
	   String Role;
	   String JoinDate;
	   
	   public Admin(int adminID, String firstName, String lastName, String email, String phoneNo, String username,
				String password, String role, String joinDate) {
			this.AdminID = adminID;
			this.FirstName = firstName;
			this.LastName = lastName;
			this.Email = email;
			this.PhoneNo = phoneNo;
			this.Username = username;
			this.Password = password;
			this.Role = role;
			this.JoinDate = joinDate;
		   }
	   
	   public int getAdminID() {
			return AdminID;
		}

		public void setAdminID(int adminID) {
			this.AdminID = adminID;
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

		public String getRole() {
			return Role;
		}

		public void setRole(String role) {
			this.Role = role;
		}

		public String getJoinDate() {
			return JoinDate;
		}

		public void setJoinDate(String joinDate) {
			this.JoinDate = joinDate;
		}
	   
		public String toString() {
			
			return " ID : "+AdminID+ ", Name : "+FirstName+" "+LastName+", Email : "+Email+", Phone no : "+PhoneNo+", Username : "+Username+", Password : "+Password+", Role : "+Role+", JoinDate : "+JoinDate;
			
		}
}
