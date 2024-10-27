package ua.com.dpointtt.classroomproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.AppUser;
import ua.com.dpointtt.classroomproject.service.AppUserService;

@RestController
@RequestMapping("/app/users")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    Flux<AppUser> getAll(){
        return appUserService.getAll();
    }

    @GetMapping("/{id}")
    Mono<AppUser> getOne(@PathVariable Long id){
        return appUserService.getById(id);
    }

    @PostMapping
    Mono<AppUser> add(@RequestBody AppUser user){
        return appUserService.add(user);
    }

    @DeleteMapping("/{id}")
    Mono<AppUser> delete(@PathVariable Long id){
        return appUserService.deleteOne(id);
    }

}
