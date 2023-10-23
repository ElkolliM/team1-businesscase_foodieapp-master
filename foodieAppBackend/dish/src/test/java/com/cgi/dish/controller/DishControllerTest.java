package com.cgi.dish.controller;

import com.cgi.dish.exception.DishNotFoundException;
import com.cgi.dish.model.Dish;
import com.cgi.dish.service.DishServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*

@SpringBootTest
class DishControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Dish dish;
    private List<Dish> dishList;

    @MockBean
    DishServiceImpl dishService;

    @InjectMocks
    DishController dishController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dishList = new ArrayList<>();
        mockMvc = MockMvcBuilders.standaloneSetup(dishController).build();
        dish = new Dish("1", "sushi", "200", "many", "url");
        Dish dish1 = new Dish("2", "burger", "150", "many1", "url2");
        Dish dish2 = new Dish("3", "buger2", "100", "many", "url3");
        dishList.add(dish1);
        dishList.add(dish2);
    }

    @Test
    public void getAllDishSuccess() throws Exception {

        when(dishService.getAllDish()).thenReturn(dishList);
        mockMvc.perform(get("/api/v1/dish").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void getByDishIdSuccess() throws Exception {

        when(dishService.getDish("1")).thenReturn(dish);
        mockMvc.perform(get("/api/v1/dish/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void addDishSuccess() throws Exception {

        when(dishService.addDish(any())).thenReturn(dish);
        mockMvc.perform(post("/api/v1/news").contentType(MediaType.APPLICATION_JSON).content(asJsonString(dish)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void updateDishSuccess() throws Exception {

        when(dishService.updateDish(any())).thenReturn(dish);
        mockMvc.perform(put("/api/v1/news/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(dish)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void updatedishFailure() throws Exception {

        when(dishService.updateDish(any())).thenThrow(DishNotFoundException.class);
        mockMvc.perform(put("/api/v1/news/2").contentType(MediaType.APPLICATION_JSON).content(asJsonString(dish)))
                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());

    }



    @Test
    public void deleteDishSuccess() throws Exception {
        doNothing().when(dishService).deleteDish(any());
        mockMvc.perform(delete("/api/v1/news/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
*/



