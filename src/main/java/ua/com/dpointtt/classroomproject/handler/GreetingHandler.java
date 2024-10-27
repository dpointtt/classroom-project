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

    public Mono<ServerResponse> home(ServerRequest request){
        return  ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Main page"));
    }

    public Mono<ServerResponse> getClients(ServerRequest request){
        String start = request.queryParam("start").orElse("0");

        Flux<Client> clients = Flux.just(
                new Client(1L, "Ihor", "Vihorkov", 35),
                new Client(1L, "Eve", "Sqwore", 22),
                new Client(1L, "Monkey", "King", 12)
        )
                .skip(Long.parseLong(start))
                .take(2);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients, Client.class);
    }

}
