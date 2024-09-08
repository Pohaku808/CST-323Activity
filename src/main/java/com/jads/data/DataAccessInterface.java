package com.jads.data;

import java.util.List;
import java.util.Optional;

import com.jads.data.entity.ProductEntity;
import com.jads.model.ProductModel;

/**
 * Interface for a Data Access Class
 * @param <T>
 */
public interface DataAccessInterface<T> 
{
	/**
	 * Method to find all of an object from the SQL database
	 * @return
	 */
    public List<T> findAll();
    
    /**
     * Method to create a object and add it to the SQL database
     * @param t
     * @return
     */
    public boolean create(T t);
    
    /**
     * Method to update an object in the SQL database
     * @param t
     * @return
     */
    public boolean update(T t);
    
    /**
     * Method to delete an object in the SQl database
     * @param id
     * @return
     */
    public boolean delete(Long id);
    
    /**
     * Method to get an object by id from the SQL database
     * @param id
     * @return
     */
    public Optional<ProductEntity> getOneById(Long id);
    




}
