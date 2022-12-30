import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.boots.controller.AdminController;
import com.boots.controller.RegistrationController;
import com.boots.controller.UserController;
import com.boots.service.UserService;
import com.boots.service.shapes.GraphShapes;

@SpringBootTest
public class ContextTest {
    @Autowired
    AdminController aController;
    @Autowired
    UserController uController;
    @Autowired
    RegistrationController rController;

    @Test
    void controllerContextLoads() {
        assertThat(aController).isNotNull();
        assertThat(uController).isNotNull();
        assertThat(rController).isNotNull();
    }

    @Autowired
    UserService uService;
    @Autowired
    GraphShapes gsService;

    @Test
    void serviceContextLoads(){
        assertThat(uService).isNotNull();
        assertThat(gsService).isNotNull();
    }

}
