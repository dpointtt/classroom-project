package ua.com.dpointtt.classroomproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@ComponentScan("ua.com.dpointtt")
@EnableR2dbcRepositories
public class ClassroomProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassroomProjectApplication.class, args);
    }

}
