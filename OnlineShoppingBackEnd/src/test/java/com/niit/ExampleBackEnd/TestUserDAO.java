package com.niit.ExampleBackEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class TestUserDAO {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestUserDAO(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO=(UserDAO) context.getBean("userDAOImpl");
		user =(User) context.getBean("user");
	}
	public boolean validate(String id,String pwd){
		if(userDAO.validate(id, pwd)==null){
			System.out.println("User does not exit");
		
			return false;
		}
		else
		{
			System.out.println("User exit with credentials");
		return true;
		
	}
	}public static void main(String args[]){
		TestUserDAO t=new TestUserDAO();
		t.validate("Nivas", "nivas");
	}
}
