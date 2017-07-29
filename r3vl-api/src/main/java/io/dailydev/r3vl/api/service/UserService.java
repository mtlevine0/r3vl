package io.dailydev.r3vl.api.service;

import java.util.List;
import java.util.Set;

import io.dailydev.r3vl.api.model.User;

public interface UserService {
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public User deleteUser(User user);
	
	public List<User> findAllUsers();
	
	public User findByUsername(String username);
	
	public void save(User user);

}
