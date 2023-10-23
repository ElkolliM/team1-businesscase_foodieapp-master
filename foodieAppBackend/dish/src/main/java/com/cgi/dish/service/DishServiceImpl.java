//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cgi.dish.service;

import com.cgi.dish.exception.DishAlreadyExistsException;
import com.cgi.dish.exception.DishNotFoundException;
import com.cgi.dish.model.Dish;
import com.cgi.dish.repository.DishRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements DishService {

    
    private DishRepository dishRepo;
   
    
    @Autowired
    public DishServiceImpl(DishRepository dishRepo) {
		
		this.dishRepo = dishRepo;
	}

	public Dish addDish(Dish dish) throws DishAlreadyExistsException {
        Optional<Dish> dishOptional = this.dishRepo.findById(dish.getDishId());
        if (dishOptional.isEmpty()) {
            this.dishRepo.save(dish);
            return dish;
        } else {
            throw new DishAlreadyExistsException();
        }
    }

    public Dish getDish(String dishId) throws DishNotFoundException {
        Optional<Dish> dishOptional = this.dishRepo.findById(dishId);
        if (dishOptional.isEmpty()) {
            throw new DishNotFoundException();
        } else {
            return (Dish)dishOptional.get();
        }
    }

    public List<Dish> getAllDish() {
        return dishRepo.findAll();
    }

    public Dish updateDish(Dish dish)  throws DishNotFoundException {
        Optional<Dish> dishOptional = this.dishRepo.findById(dish.getDishId());
        if (dishOptional.isPresent()) {
            return dishRepo.save(dish);
        } else {
            throw new RuntimeException("");
        }
    }

    public void deleteDish(String dishId) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepo.findById(dishId);
        if (dishById==null) {
            throw new DishNotFoundException();
        } else {
            this.dishRepo.deleteById(dishId);
        }
    }
}
