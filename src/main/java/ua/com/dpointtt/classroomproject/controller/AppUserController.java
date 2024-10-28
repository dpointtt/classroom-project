package ua.com.dpointtt.classroomproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.AppUser;
import ua.com.dpointtt.classroomproject.entity.AppUserRegister;
import ua.com.dpointtt.classroomproject.service.AppUserService;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/register")
    Mono<AppUser> register(@RequestBody AppUserRegister appUserRegister){
        return appUserService.registerUser(appUserRegister);
    }

}
