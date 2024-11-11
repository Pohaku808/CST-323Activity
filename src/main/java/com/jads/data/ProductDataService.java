package com.jads.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jads.data.entity.ProductEntity;
import com.jads.data.repository.ProductRepository;


/**
 * The class handles all of our stores products in the SQL database
 */
@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

    @Autowired
    private ProductRepository productRepository;

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
    
	
	
	
	
	
    /**
     * Non-Default constructor for constructor injection.
     */
    public ProductDataService(ProductRepository productRepository, DataSource dataSource) 
    {
        this.productRepository = productRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    /**
     * Retrieves all of the products from a Specified SQL Database table
     */
    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> product = new ArrayList<>();
        try {
            // Get all the Entity Orders
            Iterable<ProductEntity> orderIterable = productRepository.findAll();

            
            // Convert to a List and return the List
            orderIterable.forEach(product::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return the List
        return product;
    }


    /**
     * Adds a new product to the Specified SQL Database table
     */
    @Override
    public boolean create(ProductEntity product) 
    {
		String sql = "INSERT INTO products(OrderNo, ProductName, Price, Quantity) VALUES(?, ?, ?, ?)";
		try
		{
			jdbcTemplateObject.update(sql, product.getOrderNo(), product.getProductName(), product.getPrice(), product.getQuantity());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
    }

    /**
     * This method updates an existing product in the SQL Database
     */
	@Override
	public boolean update(ProductEntity updatedEntity) 
	{
		/*productRepository.save(updatedEntity);	
		return true;*/
		String sql = "UPDATE products SET OrderNo = ?, ProductName = ?,Price= ?, Quantity = ? WHERE id = ?";
		try
		{
			jdbcTemplateObject.update(sql, updatedEntity.getOrderNo(), updatedEntity.getProductName(), updatedEntity.getPrice(), updatedEntity.getQuantity(), updatedEntity.getId());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method deletes a product from the SQL Database
	 */
	@Override
	public boolean delete(Long id) 
	{
		try 
		{
			productRepository.deleteById(id);
			return true;

		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method gets a single product by its id.
	 */
	@Override
	public Optional<ProductEntity> getOneById(Long id) 
	{
        return productRepository.findById(id);
	}


 
}
