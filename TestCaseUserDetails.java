package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.UserDetailsDAO;

import com.niit.shoppingcart.model.UserDetails;

public class TestCaseUserDetails {
AnnotationConfigApplicationContext context;
@Autowired
UserDetailsDAO  userDetailsDAO;
@Autowired
UserDetails userDetails;
	@Before
	public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.niit.shoppingcart");
			context.refresh();
		userDetailsDAO=(UserDetailsDAO) context.getBean("userDetailsDAO");
		userDetails= (UserDetails) context.getBean("userDetails");
	}
	@Test
	public void addUserDetailsTest(){
		userDetails.setId("US_003");
		userDetails.setName("Kavya");
		userDetails.setEmail("kavyameduri@gmail.com");
		userDetails.setPassword("kavya447");
		userDetails.setContact("903210813");
		userDetails.setAddress("vanastalipuram hyd");
		assertEquals("addUserDetailsTest",userDetailsDAO.save(userDetails),true);
	}
@Test
public void deleteuser(){
	userDetails.setId("US_001");
	assertEquals("deleteuser",userDetailsDAO.delete(userDetails),true);
}
@Test
public void getUser(){
	userDetails=userDetailsDAO.get("US_003");
	assertEquals("updateUser",userDetails.getName(),"M.kavya");

}
@Test
public void listUser(){
	assertEquals("listUser",userDetailsDAO.list().size(),1);

}
@Test
public void update(){
	userDetails.setId("US_003");
	userDetails.setName("M.kavya");
	userDetails.setEmail("medurikavya@gmail.com");
	userDetails.setPassword("kavya47");
	userDetails.setContact("9948656576");
	userDetails.setAddress("ngocolony,hyd");
	assertEquals("update",userDetailsDAO.update(userDetails),true);
} 
} 
