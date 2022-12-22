package com.learn.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.demo.Dao.ProductRepository;
import com.learn.demo.model.Product;


@Service

public class ProductService implements TypeProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	 public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
	
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);//.orElse(null);
	}
	@Override
	public void remove(Long id) {
		productRepository.deleteById(id);
	}
	public boolean isExist(Long id) {
		return productRepository.existsById(id);
	}
}
