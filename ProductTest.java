package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
 context.scan("com.niit");
 context.refresh();
 ProductDAO ProductDAO =(ProductDAO) context.getBean("productDAO");
 Product Product =(Product) context.getBean("product");

Product.setId("MOB_003");
Product.setName("iphone");
Product.setDescription("new features");
Product.setPrice(75080);
if(ProductDAO.save(Product)==true){
	System.out.println("a");
}
else{
	System.out.println("b");
}
	}

}
