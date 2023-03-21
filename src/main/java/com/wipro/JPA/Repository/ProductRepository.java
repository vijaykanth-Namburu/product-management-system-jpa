package com.wipro.JPA.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.JPA.Model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{

     
}
