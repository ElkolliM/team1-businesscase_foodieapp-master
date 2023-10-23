package com.cgi.FoodieGatewayMicroservice.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.FoodieGatewayMicroservice.Model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
	public Optional<User> findByEmailAndPassword(String email, String password);
	public Optional<User> findById(int userId);
	public Optional<User> findByEmail(String email);
}
