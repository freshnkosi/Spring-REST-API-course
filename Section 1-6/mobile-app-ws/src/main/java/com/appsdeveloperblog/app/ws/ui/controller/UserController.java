package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value="page",defaultValue = "1") int page,
			@RequestParam(value="limit",defaultValue = "50") int limit) {
		
		return "get users was called with page = "+ page + " and limit = "+ limit;
	}
	
	
	@GetMapping(path="/{userId}",
			produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE } )
	
	public ResponseEntity <UserRest> getUser(@PathVariable String userId) {
		
		UserRest returnValue = new UserRest();
		returnValue.setEmail("test@test.com");
		returnValue.setFirstName("Fresh");
		returnValue.setLastName("Nkosi");
		
		return new ResponseEntity <UserRest> (returnValue, HttpStatus.OK);
	}
	
	@PostMapping (consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE },
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	
	public ResponseEntity <UserRest> createUser(@RequestBody UserDetailsRequestModel UserDetails) {
		
		 UserRest returnValue = new UserRest();
		returnValue.setEmail(UserDetails.getEmail());
		returnValue.setFirstName(UserDetails.getFirstName());
		returnValue.setLastName(UserDetails.getLastName());
		
		return new ResponseEntity <UserRest> ( returnValue,HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		
		return "delete user was called";
	}
}
