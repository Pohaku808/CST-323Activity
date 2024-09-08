package com.jads.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.jads.data.entity.UserEntity;

/**
 * The users database table repository
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> 
{
	/**
	 * Finds a user by user name
	 * @param email
	 * @return
	 */
	UserEntity findByUsername(String email);
}
