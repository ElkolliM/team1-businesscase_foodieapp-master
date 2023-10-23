package com.cgi.FoodieGatewayMicroservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.FoodieGatewayMicroservice.Model.User;
import com.cgi.FoodieGatewayMicroservice.dto.UserDTO;
import com.cgi.FoodieGatewayMicroservice.exception.UserAlreadyExistsException;
import com.cgi.FoodieGatewayMicroservice.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class AuthenticationService {
	@Autowired
	private UserRepository repo;
	public User addNewUser(User user) throws UserAlreadyExistsException  {
		
		Optional<User> userop =  repo.findById(user.getUserId());
		
		if (userop.isEmpty()) {
			
			repo.save(user);
			return user;
		}
		throw new UserAlreadyExistsException();
	}
	public Boolean verifyUser(String email, String password) {
		return repo.findByEmailAndPassword(email, password).isPresent();
	}
	public Boolean getUser(String email) {
		return repo.findByEmail(email).isPresent();
	}
	public List<User> getall(){
		return repo.findAll();
	}
	
	public String generateToken(String email) {
		User userop =repo.findByEmail(email).get();
		Map<String,Object> claim= new HashMap<>();
		claim.put("role", userop.getRole());
		String Token;
		Token = Jwts.builder()
				.setSubject(email)
				.addClaims(claim)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 50000000))
				.signWith(SignatureAlgorithm.HS256, "cgicanada")
				.compact();
		
		return Token;
	}
	public Map<Object,Object> isUserAuthenticated(String token1) {
		String token = token1.split(" ")[1];
		String claim = "";
		Claims claims = Jwts.parser()
				.setSigningKey("cgicanada")
				.parseClaimsJws(token)
				.getBody();
		claim = claims.getSubject();
		Object role="";
		role=claims.get("role");
		Map<Object,Object> result= new HashMap<>();
		boolean isAuthenticated =repo.findByEmail(claim).isPresent();
		 result.put("isAuthenticated",isAuthenticated);	
		 result.put("role", role);
		return result;
	}
}
