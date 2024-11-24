package dao;

import entity.Admin;

public interface AdminService {
     
	    public Admin getAdminById(int adminId);
	    public Admin getAdminByUsername(String username);
	    public String registerAdmin(Admin adminData);
	    public String updateAdmin(Admin adminData,int adminId);
	    public String deleteAdmin(int adminId);
	    
	    public boolean authenticate(String Username,String Password);
	    
}
