package com.jads.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jads.data.entity.ProductEntity;
import com.jads.data.entity.UserEntity;
import com.jads.data.repository.UserRepository;
import com.jads.model.ProductModel;

/**
 * This method handles all of our users in the SQL database
 */
@Service
public class UserDataService implements DataAccessInterface<UserEntity>
{
    @Autowired
    private UserRepository userRepository;
    
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
    /**
     * Non-Default constructor for constructor injection.
     */
    public UserDataService(UserRepository userRepository, DataSource dataSource) 
    {
        this.userRepository = userRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
	
    
    /**
     * This method searches for a user by its user name
     * @param email
     * @return
     */
	public UserEntity findyByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
    
   
    
    /**
     * Retrieves all of the users from a Specified SQL Database table
     */
	@Override
	public List<UserEntity> findAll() 
	{
        List<UserEntity> users = new ArrayList<>();
        try {
            // Get all the Entity Orders
            Iterable<UserEntity> orderIterable = userRepository.findAll();

            // Convert to a List and return the List
            orderIterable.forEach(users::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return the List
        return users;
	}

	
    /**
     * Adds a new user to the Specified SQL Database table
     */
	@Override
	public boolean create(UserEntity user) 
	{
		String sql = "INSERT INTO users(FirstName, LastName, PhoneNumber, Username, Email, Password) VALUES(?, ?, ?, ?, ?, ?)";
		try
		{
			jdbcTemplateObject.update(sql, user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getUsername(), user.getEmail(), user.getPassword());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<ProductEntity> getOneById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
