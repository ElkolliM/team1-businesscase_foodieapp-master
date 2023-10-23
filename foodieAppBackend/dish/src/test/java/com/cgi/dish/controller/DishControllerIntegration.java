

import com.cgi.dish.model.Dish;
import com.mongodb.assertions.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
/*

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DishControllerIntegration {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
     @Test
    void TestDishService(){
       List<Dish> dishs = testRestTemplate.getForObject("http://127.0.0.1:"+port+"/dishs", List.class);
        Assertions.assertNotNull(dishs);

    }
}
*/
