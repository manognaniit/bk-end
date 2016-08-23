package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.SupplierDAO;

import com.niit.shoppingcart.model.Supplier;

public class TestCaseSupplier {

@Autowired
SupplierDAO supplierDAO;
@Autowired
Supplier supplier;
AnnotationConfigApplicationContext context;
@Before
public void init(){
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
supplier= (Supplier) context.getBean("supplier");
	
}
@Test
public void addSupplierTestCase(){
	supplier.setId("SUP_001");
	supplier.setName("RELIANCE DIGITAL");
	supplier.setLocation("hyderabad");
	assertEquals("addSupplierTestCase",supplierDAO.save(supplier),true);
	
}
@Test
public void deleteSupplierTestCase(){
	supplier.setId("SUP_002");
	assertEquals("SupplierTestCase",supplierDAO.delete(supplier),true);
	
}@Test
public void updateSupplierTestCase(){
	supplier.setId("SUP_001");
	supplier.setName("RELIANCE");
	supplier.setLocation("hyd");
	assertEquals("updateSupplierTestCase",supplierDAO.update(supplier),true);
	
}
@Test
public void listSupplierTestCase(){
	assertEquals("listSupplierTestCase",supplierDAO.list().size(),1);
}
@Test
public void getSupplierTestCase()
{
	
	
		supplier=supplierDAO.get("SUP_001");
	assertEquals("getProductTestcase",supplier.getName(),"RELIANCE");

	
	
}}
