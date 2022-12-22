package com.learn.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learn.demo.Dao.ProductRepository;
import com.learn.demo.Service.ProductService;
import com.learn.demo.model.Product;
import com.learn.demo.model.ResponseObject;

import ch.qos.logback.core.net.SyslogOutputStream;

//import lombok.eclipse.*;
//package com.learn.demo.controller;
@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/v1/Product")
public class ProductController {
	
	@Autowired
	private ProductRepository repository; 
	@Autowired
	private ProductService productService;
	@GetMapping("")
	public ResponseEntity<ResponseObject> getAllProduct(){
		Iterable<Product> list = productService.findAll();
		if (list.iterator().hasNext()) return ResponseEntity.status(HttpStatus.OK).body( 
				new ResponseObject("ok", "found them all",list));
		else
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body( 
				new ResponseObject("ok",  "not found",null));
	}

	@PostMapping("/add")
	//@PutMapping("/add")
	public ResponseEntity<ResponseObject> addProduct(@RequestBody Product product) {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok","successfully added product",productService.save(product))) ;
		
	
	}
	
	
	@DeleteMapping("/delete")
public ResponseEntity<ResponseObject> deleteProductById(@RequestParam("id") Long id) {
		ResponseEntity<ResponseObject> resul ;
		boolean check = productService.isExist(id);
		if (check) {
			
			resul = ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok"," delete successfully",null ));
			productService.remove(id);
		}
		else
			resul= ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("ok","This product does not exist",null ));
	
		return resul;
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<ResponseObject> findProductById( @PathVariable("id") Long id) {
		
		Optional<Product> foundProduct=productService.findById(id) ; //
		if (foundProduct.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok"," query successfully",foundProduct));
		}
		else 
			return ResponseEntity.status(HttpStatus.METHOD_FAILURE).body(new ResponseObject("failed","query failed",foundProduct));
		//return productService.findById(id);
	}
	@GetMapping("/api")
	public List<Product> testApi() {
		return repository.findAll();
		
	}
	@PutMapping("/update")
	ResponseEntity<ResponseObject> update(@RequestBody Product product){
		ResponseEntity<ResponseObject> resul ;

		Long id = product.getID();
		Optional<Product> list = productService.findById(id);
		if (list.isEmpty()) resul =ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new ResponseObject("failed","Not found",null));
		else
			resul= ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("successfully","updated",productService.save(product)));
		return resul;
		
	}
	


}
