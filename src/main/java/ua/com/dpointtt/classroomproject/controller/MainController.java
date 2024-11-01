package ua.com.dpointtt.classroomproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Message;
import ua.com.dpointtt.classroomproject.service.MessageService;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MainController {

    private final MessageService messageService;

    @GetMapping
    public Flux<Message> list(@RequestParam(defaultValue = "0") Long start, @RequestParam(defaultValue = "3") Long count) {
        return messageService.list(start, count);
    }

    @PostMapping
    public Mono<Message> create(@RequestBody Message message){
        return messageService.addOne(message);
    }

}
