package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		
				AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		 context.scan("com.niit");
		 context.refresh();
		 SupplierDAO SupplierDAO =(SupplierDAO) context.getBean("supplierDAO");
		 Supplier Supplier =(Supplier) context.getBean("supplier");

		Supplier.setId("SUP_002");
		Supplier.setName("SANGEETHA");
		Supplier.setLocation("chennai");
		
		if(SupplierDAO.save(Supplier)==true){
			System.out.println("success");
		}
		else{
			System.out.println("failure");
		}
			}

		


	}


