package com.wipro.JPA.Service;
import com.wipro.JPA.Model.Product;
import com.wipro.JPA.Repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
     @Autowired
     ProductRepository repository;
     
     public List<Product>getAllProducts(){
    	 List<Product> lst = (List<Product>)repository.findAll();
    	 if(lst.size()>0)
    		 return lst;
    	 else
    		 return new
    	 ArrayList<Product>();
     }
     
     public Product getById(int id) {
    	 Optional<Product> prod=repository.findById(id);
    	 if(prod.isPresent())
    		 return prod.get();
    	 else
    		 return new Product(0,"",0.0);
     }
     public void delete(int id) {
    	 Optional<Product> prod=repository.findById(id);
    	 if(prod.isPresent())
    		 repository.deleteById(id);
     }
     
     public Product createOrUpdate(Product prod) {
    	 Optional<Product> p = repository.findById(prod.getId());
    	 if(p.isPresent())
    	 {
    		 Product n = p.get();
    		 n.setName(prod.getName());
    		 n.setPrice(prod.getPrice());
    		 return repository.save(n);
    	 }
    	 else
    	 {
    		 prod=repository.save(prod);
    		 return prod;
    	 }
     }
}
