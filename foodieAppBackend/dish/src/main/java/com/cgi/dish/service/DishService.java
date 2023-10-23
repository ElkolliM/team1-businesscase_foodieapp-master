package com.cgi.dish.service;

import com.cgi.dish.exception.DishAlreadyExistsException;
import com.cgi.dish.exception.DishNotFoundException;
import com.cgi.dish.model.Dish;

import java.util.List;

public interface DishService {

    public Dish addDish(Dish dish) throws DishAlreadyExistsException;
    public Dish getDish(String dishId) throws DishNotFoundException;
    public List<Dish> getAllDish();

    public Dish updateDish(Dish dish) throws DishNotFoundException;
    public void deleteDish(String dishId) throws DishNotFoundException;
}
