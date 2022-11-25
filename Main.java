package com.spring.core.jdbc.main;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.jdbc.dao.CategoryDAO;
import com.spring.core.jdbc.dao.ProductDAO;
import com.spring.core.jdbc.model.Category;
import com.spring.core.jdbc.model.Product;

public class Main {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = null;
		
		try {		
			
			//saving categories
			
			 context =new ClassPathXmlApplicationContext("spring.xml");
				
			CategoryDAO categoryDAO = context.getBean(CategoryDAO.class);
			
			Category c1 = new Category();
			
			int rand = new Random().nextInt(100);
			
			c1.setId(rand);
			c1.setName("Chocolate");
			c1.setDescription("Sweet and savory delicacy");
			
			
			categoryDAO.save(c1);

			
			System.out.println("Category is saved successfully");			
			
			
			
			 //Get by id
			
			Category cat=categoryDAO.getById(rand);
			
			System.out.println("Getting category By Id"+cat);
			
			
			//update
			
			c1.setName("Choco");
			categoryDAO.update(c1);
		
			List<Category> cList=categoryDAO.getAll();
			
			System.out.println(cList);
			
			//delete
			
			categoryDAO.deleteById(rand);
			cList=categoryDAO.getAll();
			
			System.out.println(cList);
			
			//get by name
			Category cat2 = categoryDAO.getByName("Shoe");
			System.out.println("Category by name :" + cat2); 
			
			//get by names
			List<Category> cList2 = categoryDAO.getByNames("C");
			System.out.println(cList2);		
			
			//saving products
			 context =new ClassPathXmlApplicationContext("spring.xml");
				
				ProductDAO productDAO = context.getBean(ProductDAO.class);
				
				Product p1 = new Product();
				
				int rand = new Random().nextInt(100);
				
				p1.setId(rand);
				p1.setName("Dairy Milk");
				p1.setPrice(10.00);
				p1.setUnitsInStock(20);
				p1.setDiscontinued(false);
				
				productDAO.save(p1);
				
				System.out.println("Product is saved successfully");	
		
			//get by id
							
			 Product pro = productDAO.getById(rand);
			 System.out.println("Product by id :" + pro);
			 
			 // update
			
			 p1.setName("Nivia");
			 productDAO.update(p1);  
			
			 List<Product> pList = productDAO.getAll();
			 System.out.println(pList);
			 
			 //delete by id
			 
			 productDAO.deleteById(rand);
			 
			 //getAll
			 
			 pList = productDAO.getAll();
			 System.out.println(pList);
			 
			 
			 //products between price
			 List<Product> pro3 = productDAO.getByBetweenPrice(5, 1000);
				System.out.println(pro3);
				System.out.println();
			
			//get discontinued products		
				List<Product> pro4 = productDAO.getDiscontinuedProducts();
				System.out.println(pro4);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			if(context !=null)
				context.close();
		}

	}

}
