package ua.com.dpointtt.classroomproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Classroom;
import ua.com.dpointtt.classroomproject.service.ClassroomService;

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping
    Flux<Classroom> getAll(){
        return classroomService.getAll();
    }

    @GetMapping("/{id}")
    Mono<Classroom> getOne(@PathVariable Long id){
        return classroomService.getById(id);
    }

    @PostMapping
    Mono<Classroom> add(@RequestBody Classroom classroom){
        return classroomService.add(classroom);
    }

    @PutMapping
    Mono<Classroom> update(@RequestBody Classroom classroom){
        return classroomService.updateOne(classroom);
    }

    @DeleteMapping("/{id}")
    Mono<Classroom> delete(@PathVariable Long id){
        return classroomService.deleteOne(id);
    }
}
