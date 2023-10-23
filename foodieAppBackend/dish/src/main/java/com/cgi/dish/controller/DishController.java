package com.cgi.dish.controller;

import com.cgi.dish.exception.DishAlreadyExistsException;
import com.cgi.dish.exception.DishNotFoundException;
import com.cgi.dish.model.Dish;
import com.cgi.dish.service.DishServiceImpl;

import java.util.List;

import lombok.AllArgsConstructor;
//<<<<<<< HEAD:dish/src/main/java/com/cgi/dish/controller/DishController.java
//=======
//
//>>>>>>> oussamav3:foodieAppBackend/dish/src/main/java/com/cgi/dish/controller/DishController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping({"/api/v1/dish"})

public class DishController {




		@Autowired

        private DishServiceImpl dishService;


        @GetMapping({"/{dishId}"})
        public ResponseEntity<?> getDishById(@PathVariable("dishId") String dishId) throws DishNotFoundException {
        	
            Dish dishById = this.dishService.getDish(dishId);
            return dishById == null ? new ResponseEntity(dishById, HttpStatus.NOT_FOUND) : new ResponseEntity(dishById, HttpStatus.OK);

        }

        @GetMapping()
        public ResponseEntity<List<Dish>> getAllDishHandler(){
            List<Dish> dish= dishService.getAllDish();
            return new ResponseEntity<List<Dish>>(dish,HttpStatus.OK);

        }

        @PostMapping
        public ResponseEntity<Dish> createDish(@RequestBody Dish dish) throws DishAlreadyExistsException{
            for(Dish alldish: dishService.getAllDish()) {
                if(alldish.getDishId() == dish.getDishId()) {
                    return new ResponseEntity<Dish>(HttpStatus.CONFLICT);
                }
            }
            ResponseEntity<?> responseEntity;		
            dishService.addDish(dish);
            return new ResponseEntity<Dish>(dish, HttpStatus.CREATED);
        }


        @PutMapping({"/{dishId}"})
        public ResponseEntity<Dish> updateDish(@PathVariable("dishId") String dishId, @RequestBody Dish dish) {
            try {
                Dish dishUpdated = this.dishService.updateDish(dish);
                if (dishUpdated != null) {
                    return new ResponseEntity<Dish>(dishUpdated, HttpStatus.OK);
                }
            }
            catch (DishNotFoundException e) {
                return new ResponseEntity<Dish>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Dish>(HttpStatus.NOT_FOUND);
        }

        @DeleteMapping({"/{dishId}"})
        public ResponseEntity<Dish> deleteDish(@PathVariable("dishId") String dishId) {
            try {
                this.dishService.deleteDish(dishId);
                return new ResponseEntity(HttpStatus.OK);
            } catch (DishNotFoundException e) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }
    }


