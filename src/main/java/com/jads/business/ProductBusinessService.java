package com.jads.business;

import com.jads.data.ProductDataService;
import com.jads.data.entity.ProductEntity;
import com.jads.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ProductBusinessService class : This class handles all of our logic for handling our products from the sql database
 */
@Service
public class ProductBusinessService
{

    @Autowired
    private ProductDataService service;

    /**
     * Gets all of the products from a SQL database table
     * @return List of products
     */
    public List<ProductModel> getAllProducts() 
    {
        // Call the findAll() method on the service class-scoped variable and save the return value in a variable ordersEntity
        List<ProductEntity> productEntity = service.findAll();

        // Create an empty List<OrderModel> in a variable named ordersDomain
        List<ProductModel> productDomain = new ArrayList<>();

        // Iterate over the ordersEntity List and create a new instance of OrderModel
        // from the OrderEntity objects and add the instances of the OrderModel to the ordersDomain List
        for (ProductEntity entity : productEntity) {
            productDomain.add(new ProductModel(
                entity.getId(),
                entity.getOrderNo(),
                entity.getProductName(),
                entity.getPrice(),
                entity.getQuantity()
            ));
        }

        // Return the ordersDomain List
        return productDomain;
    }
    

    /**
     * This method allows the creation of a new product and adds it to 
     * the specified SQL database table
     * @param product A single product
     * @return True if product creation was successful, false if not
     */
    public boolean createProduct(ProductModel product) 
    {
    	ProductEntity newProduct = new ProductEntity(
    			product.getId(),
    			product.getOrderNo(),
    			product.getProductName(),
    			product.getPrice(),
    			product.getQuantity()
    	);
    	
    	boolean check = service.create(newProduct);
    	
    	if(check == true)
    	{
    		return true;
    	}
    	
    	return false;
    }

    
    /**
     * This method deletes a product by id
     * @param id The id of the product to delete
     * @return True is product delete was a success, false if not
     */
    public boolean deleteProductById(Long id) 
    {
    	boolean check = service.delete(id);
    	
    	if(check == true)
    	{
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * This method updates/edits an existing product
     * @param updatedProduct The newly updated product
     * @return True if product update was a success, false if not
     */
    public boolean updateProduct(ProductModel updatedProduct) 
    {
    	ProductEntity newUpdatedEntity = new ProductEntity(
    			updatedProduct.getId(),
    			updatedProduct.getOrderNo(),
    			updatedProduct.getProductName(),
    			updatedProduct.getPrice(),
    			updatedProduct.getQuantity()
    	);
    	
    	boolean check = service.update(newUpdatedEntity);
    	
    	if(check == true)
    	{
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * This method gets a product by id.
     * @param id The id of the product to get
     * @return The selected product
     */
    public ProductModel getProductById(Long id) 
    {    	
    	Optional<ProductEntity> foundEntity = service.getOneById(id);
    	
    	ProductModel foundProduct = new ProductModel(foundEntity.get().getId(), foundEntity.get().getOrderNo(), foundEntity.get().getProductName(), foundEntity.get().getPrice(), foundEntity.get().getQuantity());

    	return foundProduct;
    }
    	

    /**
     * Initialize method for productBusinessService Spring Bean
     */
	public void init() {
		System.out.println("Hello from productBusinessService's init() method.");
		
	}

    /**
     *  Destroy method for productBusinessService Spring Bean
     */
	public void destroy() {
		System.out.println("Hello from productBusinessService's destroy() method.");
		
	}
	


}
