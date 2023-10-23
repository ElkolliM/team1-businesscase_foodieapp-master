package com.cgi.dish.repository;

import com.cgi.dish.model.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends MongoRepository<Dish,String> {


}
