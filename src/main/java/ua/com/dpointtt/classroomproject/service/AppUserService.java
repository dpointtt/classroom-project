package ua.com.dpointtt.classroomproject.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.AppUser;
import ua.com.dpointtt.classroomproject.repository.AppUserRepository;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    public Mono<AppUser> add(AppUser classroom) {
        return appUserRepository.save(classroom);
    }

    public Mono<AppUser> getById(Long id){
        return appUserRepository.findById(id);
    }

    public Flux<AppUser> getAll(){
        return appUserRepository.findAll();
    }

    public Mono<AppUser> deleteOne(Long id){
        return appUserRepository.findById(id).doOnSuccess(appUserRepository::delete);
    }

    @Transactional
    public Mono<AppUser> updateOne(AppUser classroom){
        return appUserRepository.save(classroom);
    }
}
