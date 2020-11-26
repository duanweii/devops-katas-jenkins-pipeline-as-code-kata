package devops.katas.adminprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AdminproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminproviderApplication.class, args);
    }
}

@Configuration
class AdminConfiguration {
    @Bean
    AdminService adminService() {
        return new AdminService();
    }
}

class AdminService {
    public Admin retrieveAdmin(int id) {
        return new Admin("firstName [" + id + "]", "lastName [" + id + "]");
    }
}


@RestController
class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/admin/{id}")
    Admin admin(@PathVariable int id) {
        return adminService.retrieveAdmin(id);
    }
}

class Admin {
    private final String firstName;
    private final String lastName;

    public Admin(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}