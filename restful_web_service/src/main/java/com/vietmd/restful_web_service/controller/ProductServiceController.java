package com.vietmd.restful_web_service.controller;

import com.vietmd.restful_web_service.exception.ProductNotFoundException;
import com.vietmd.restful_web_service.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product iphone = new Product();
        iphone.setId("1");
        iphone.setName("13 Promax");
        productRepo.put(iphone.getId(),iphone);

        Product samsung = new Product();
        samsung.setId("2");
        samsung.setName("Ultra 12");
        productRepo.put(samsung.getId(),samsung);
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id){
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully",HttpStatus.OK);
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        productRepo.put(product.getId(),product);
        return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        if(!productRepo.containsKey(id))throw new ProductNotFoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id,product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

}
