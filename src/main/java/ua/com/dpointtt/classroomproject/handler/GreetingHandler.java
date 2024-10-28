package ua.com.dpointtt.classroomproject.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Client;
import ua.com.dpointtt.classroomproject.entity.Greeting;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request){

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));

    }

    public Mono<ServerResponse> users(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("User Page")));
    }

//    public Mono<ServerResponse> register(ServerRequest request){
//        return ServerResponse
//                .ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(new Greeting("Successfully registered!")));
//    }

    public Mono<ServerResponse> admin(ServerRequest request) {

        // fake users
        Flux<Client> users = Flux.
                just(
                        new Client(1L, "Ihor", "Vihorkov", 35),
                        new Client(2L, "Eve", "Sqwore", 22),
                        new Client(3L, "Monkey", "King", 12)
                );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(users, Client.class);
    }

}
