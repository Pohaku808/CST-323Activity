package com.jads.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jads.data.entity.UserEntity;

/**
 * This class is our user row mapper
 */
public class UserRowMapper implements RowMapper<UserEntity>{

	/**
	 * Map row method
	 */
	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new UserEntity(
				rs.getLong("Id"),
				rs.getString("FirstName"),
				rs.getString("LastName"),
				rs.getString("PhoneNumber"),
				rs.getString("Username"),
				rs.getString("Email"),
				rs.getString("Password")
				);
	
	}

}
