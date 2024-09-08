package com.jads.data.mapper;

import com.jads.data.entity.ProductEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is our product row mapper
 */
public class ProductRowMapper implements RowMapper<ProductEntity> {

	/**
	 * Map row method
	 */
    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductEntity(
                rs.getLong("Id"),
                rs.getString("OrderNo"),
                rs.getString("ProductName"),
                rs.getDouble("Price"),
                rs.getInt("Quantity")
        );
    }
}
