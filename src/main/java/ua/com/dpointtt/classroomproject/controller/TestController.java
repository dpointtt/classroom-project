package ua.com.dpointtt.classroomproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.dpointtt.classroomproject.entity.Client;

@RestController
public class TestController {

    @GetMapping("/clients")
    public Flux<Client> getClients() {
        return Flux.just(
                new Client(1L, "Ihor", "Vihorkov", 35),
                new Client(1L, "Eve", "Sqwore", 22),
                new Client(1L, "Monkey", "King", 12)
        )
                .skip(0)
                .take(2);
    }

}
