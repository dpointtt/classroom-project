package ua.com.dpointtt.classroomproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Task;
import ua.com.dpointtt.classroomproject.service.TaskService;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public Flux<Task> getAll(){
        return taskService.getAll();
    }

    @PostMapping
    public Mono<Task> add(@RequestBody Task task){
        return taskService.add(task);
    }

    @DeleteMapping("/{id}")
    public Mono<Task> delete(@PathVariable Long id){
        return taskService.deleteOne(id);
    }

    @PutMapping
    public Mono<Task> update(@RequestBody Task task){
        return taskService.updateOne(task);
    }

}
