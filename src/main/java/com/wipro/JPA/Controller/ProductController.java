package com.wipro.JPA.Controller;
import com.wipro.JPA.Model.Product;
import com.wipro.JPA.Service.ProductService;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
     @Autowired
     ProductService service;
     
     @GetMapping("/product/{id}")
     public ResponseEntity<Product> getById(@PathVariable int id)
     {
    	Product p = service.getById(id);
    	return new ResponseEntity<>(p, new HttpHeaders(), HttpStatus.OK);
     }
     
     @GetMapping("/Products")
     public ResponseEntity<List<Product>> getAll()
     {
    	 List<Product> lstP=service.getAllProducts();
    	 return new ResponseEntity<>(lstP,HttpStatus.OK);
     }
     @PostMapping("/add")
     public ResponseEntity<Product> create(@RequestBody Product prod)
     {
    	 Product p = service.createOrUpdate(prod);
    	 return new ResponseEntity<>(p,HttpStatus.OK);		
     }
     
     @PostMapping("/update")
     public ResponseEntity<Product> update(@RequestBody Product prod)
     {
    	 Product p = service.createOrUpdate(prod);
    	 return new ResponseEntity<>(p,HttpStatus.OK);		 
     }
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<String> delete(@PathVariable int id)
     {
    	 service.delete(id);
    	return new ResponseEntity<>("deleted", HttpStatus.OK);	 

     }
}
