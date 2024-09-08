package com.jads.data.repository;

import com.jads.data.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * The products database table repository
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long> 
{
}
