package com.cgi.dish.service;

import com.cgi.dish.exception.DishAlreadyExistsException;
import com.cgi.dish.exception.DishNotFoundException;
import com.cgi.dish.model.Dish;
import com.cgi.dish.repository.DishRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class DishServiceTest {
    @Mock
    private DishRepository dishRepository;
    @InjectMocks
    private DishServiceImpl dishService;
    private Dish dish;
    private List<Dish> dishList;
    Optional<Dish> options;

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        dish = new Dish();
        dish.setDishId("001");
        dish.setDishName("sushi");
        dish.setDishPrice(200);
        dish.setDishDetails("with protein");
        dish.setDishImage("URL IMAGE");
        dishList = new ArrayList<>();
        dishList.add(dish);
        options = Optional.of(dish);
    }




   /*@Test
   public void addDishTestSuccess() throws Exception {
       when(dishRepository.insert(dish)).thenReturn(dish);
       Dish saveddish = dishService.addDish(dish);
       assertThat(saveddish,is(dish));

   }*/



/*

    @Test
    @Rollback(true)
    public void addDishTestFailure() throws DishAlreadyExistsException {
        when(dishRepository.findOne(any())).thenReturn(options);
        assertThrows(DishAlreadyExistsException.class , () -> dishService.addDish(dish));
        verify(dishRepository, times(1)).insert(dish);
        verify(dishRepository, times(0)).save(any());

    }


    @Test
    @Rollback(true)
    public void testGetDishSuccess() throws DishNotFoundException {
        when(dishRepository.findById(any())).thenReturn(Optional.of(dish));
        assertEquals(dish, dishService.getDish(dish.getDishId()));
        verify(dishRepository, times(1)).findById(any());

    }



    @Test
    @Rollback(true)
    public void testGetDishFailure() throws DishNotFoundException {
        when(dishRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(DishNotFoundException.class, () -> dishService.getDish(dish.getDishId()));
        verify(dishRepository, times(1)).findById(any());

    }


    @Test
    public void updateDishTestSuccess() throws DishNotFoundException {
        when(dishRepository.findById("001")).thenReturn(options);
        dish.setDishName("dish dish");
        dishList.add(dish);
        Dish fetchedDish = dishService.updateDish(dish);
       // assertEquals(dish.getDishName(),"dish dish");
        assertEquals(this.dish, is(fetchedDish));

    }


   */
/* @Test
    public void deleteDishSuccess() throws Exception {
        when(dishRepository.findById(dish.getDishId())).thenReturn(options);
        when(dishRepository.save(dish)).thenReturn(dish);
        Dish flag = dishService.deleteDish("1");
        assertThat(true, is(flag));
    }

*//*

    @Test
    @Rollback(true)
    public void testDeleteDishSuccess() throws DishNotFoundException {
        when(dishRepository.findOne(any())).thenReturn(options);
        dishService.deleteDish(dish.getDishId());

        verify(dishRepository, times(1)).findOne(any());
        verify(dishRepository, times(1)).deleteById(any());

    }







*/




















}
