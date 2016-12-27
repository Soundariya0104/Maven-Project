package com.niit.controller.daoimpl;

import com.niit.controller.dao.UserDAO;

public class UserDAOImpl implements UserDAO{
	public boolean isValidCredentials(String id,String password){
	System.out.println("in the isvalidcredentials method of sample");
	if(id.equals("niit")&&password.equals("niit@123"))
	{
		return true;
	}
	else{
		return false;
	}
	}

}
