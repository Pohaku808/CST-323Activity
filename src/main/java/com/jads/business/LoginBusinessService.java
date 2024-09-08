package com.jads.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jads.data.UserDataService;
import com.jads.data.entity.UserEntity;
import com.jads.model.UserModel;


/**
 * LoginBusinessService class : This class handles all of our logic for authorizing a user
 */
public class LoginBusinessService implements UserDetailsService
{
    @Autowired
    private UserDataService service;
    
    
    /**
     * This method uses our database for the spring security login authentication.
     */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		// Try to find the User in the database. If not found throw a User Not Found exception
		// else return a Spring Security User.
		UserEntity user = service.findyByUsername(username);
		
		if(user != null)
		{
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getEmail(), user.getPassword(), authorities);
		}
		else
		{
			throw new UsernameNotFoundException("username not found");
		}
	}
    
    
    
	/**
	 * This method authenticates the users login information.
	 * Right now this is done by hard wiring a set email and password.
	 * @param loginModel The users login information (Email and Password)
	 * @return A boolean if the user login info is valid 
	 */
	public boolean processLogin(UserModel userModel) 
	{
        List<UserEntity> userEntity = service.findAll();
        
        List<UserModel> userDomain = new ArrayList<>();

        
        for (UserEntity entity : userEntity) {
            userDomain.add(new UserModel(
                    entity.getId(),
                    entity.getFirstName(),
                    entity.getLastName(),
                    entity.getPhoneNumber(),
                    entity.getUsername(),
                    entity.getEmail(),
                    entity.getPassword()

                ));
        }
        
        for (UserModel user : userDomain) 
        {
    		String password = user.getPassword();
    		String email = user.getEmail();
    		
    		// check if users info is valid
    		if (password.equals(userModel.getPassword()) && email.equals(userModel.getEmail())) 
    		{
    			System.out.println(userModel.getEmail() + ", " + userModel.getPassword());
    			
    			return true;
    		} 
        }
        
		return false;

	}

    /**
     * Initialize method for loginBusinessService Spring Bean
     */
	public void init() 
	{
        System.out.println("Hello from loginBusinessService's init() method.");
	}

    /**
     * Destroy method for loginBusinessService Spring Bean
     */
	public void destroy() 
	{
        System.out.println("Hello from loginBusinessService's destroy() method.");
	}

}
