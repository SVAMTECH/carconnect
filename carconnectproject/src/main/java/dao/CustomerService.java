package dao;

import entity.Customer;

public interface CustomerService {
        
	   public Customer getCustomerById(int customerId);
	   public Customer getCustomerByUsername(String username);
	   public String registerCustomer(Customer customerData);
	   public String updateCustomer(Customer customerData,int customerId);
	   public String deleteCustomer(int customerId);
	   
	   public boolean authenticate(String Username,String Password);
}
