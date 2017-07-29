package io.dailydev.r3vl.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.dailydev.r3vl.api.model.User;
import io.dailydev.r3vl.api.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserResource {
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAllUsers() {
		
		return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);
	}
	
}
