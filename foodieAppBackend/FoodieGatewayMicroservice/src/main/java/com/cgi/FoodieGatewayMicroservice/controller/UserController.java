package com.cgi.FoodieGatewayMicroservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.FoodieGatewayMicroservice.Model.User;
import com.cgi.FoodieGatewayMicroservice.dto.UserDTO;
import com.cgi.FoodieGatewayMicroservice.exception.UserAlreadyExistsException;
import com.cgi.FoodieGatewayMicroservice.repository.UserRepository;
import com.cgi.FoodieGatewayMicroservice.service.AuthenticationService;

	@RestController
	@RequestMapping(value = "/api/v1")
	public class UserController {
			@Autowired
			private AuthenticationService service;
			@Autowired
			private UserRepository repo;
			@PostMapping(value = "/register")
			public ResponseEntity<?> registerNewUserHandler( @RequestBody User user){
				
				ResponseEntity<?> responseEntity;		
				try {
					User newUser = service.addNewUser(user);
					responseEntity = new ResponseEntity<User>(newUser,HttpStatus.CREATED);
				} catch (UserAlreadyExistsException e) {
					responseEntity = new ResponseEntity<String>("user already exists",HttpStatus.CONFLICT);
				}
				
				return responseEntity;
			}
			@GetMapping("/user/{userid}")
			public ResponseEntity<Boolean> veriferUserHandler(@PathVariable("userid") int userid) {
				ResponseEntity<Boolean> responseEntity;
				User user=repo.findById(userid).get();
				boolean result=service.verifyUser(user.getEmail(), user.getPassword());
				responseEntity = new ResponseEntity<Boolean>(result,HttpStatus.OK);
				return responseEntity;
			}
			@GetMapping("/user/{email}")
			public ResponseEntity<?> getuserhandler(@PathVariable("email") String email) {
				ResponseEntity<?> responseEntity;
				
				boolean result=service.getUser(email);
				responseEntity = new ResponseEntity<Boolean>(result,HttpStatus.OK);
				return responseEntity;
			}
			@GetMapping("/users")
			public ResponseEntity<?> getall(){
				ResponseEntity<?> responseEntity;
				responseEntity = new ResponseEntity<List<User>>(service.getall(),HttpStatus.OK);
				return responseEntity;
			}
			@PostMapping("/login")
			public ResponseEntity<?> loginHandler(@RequestBody UserDTO user ){
				
				ResponseEntity<?> responseEntity;
				
				Map<String, String> tokenMap = new HashMap<>();
				
				boolean isUserValid = service.verifyUser(user.getEmail(),user.getPassword());
				
				if(isUserValid) {		
					String token = service.generateToken(user.getEmail());
					tokenMap.put("token", token);
					responseEntity = new ResponseEntity<Map<String, String>>(tokenMap,HttpStatus.OK);
				} else {
					tokenMap.clear();
					tokenMap.put("token", null);
					tokenMap.put("message", "email or password is invalid");
					responseEntity = new ResponseEntity<Map<String,String>>(tokenMap,HttpStatus.FORBIDDEN);
				}
				return responseEntity;
				
			}
			@PostMapping("/auth")
			public ResponseEntity<?> authHandler(@RequestHeader("Authorization") String token ){
				ResponseEntity<?> responseEntity;
				Map<Object,Object> result= service.isUserAuthenticated(token);
			
					responseEntity = new ResponseEntity<Map<Object, Object>>(result,HttpStatus.OK);
				
				return responseEntity;
				
			}
}
