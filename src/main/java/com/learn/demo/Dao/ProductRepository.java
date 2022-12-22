package com.learn.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.learn.demo.model.Product;

@Repository 
@Component
public interface ProductRepository extends JpaRepository<Product,Long>{
	//List<Product> findAllByID(int ID);
	//{
		//return Session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
	//}
	
}
