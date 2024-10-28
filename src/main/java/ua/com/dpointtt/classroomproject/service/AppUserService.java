package ua.com.dpointtt.classroomproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.AppUser;
import ua.com.dpointtt.classroomproject.entity.AppUserRegister;
import ua.com.dpointtt.classroomproject.repository.AppUserRepository;
import ua.com.dpointtt.classroomproject.repository.AppUserRolesRepository;
import ua.com.dpointtt.classroomproject.repository.RoleRepository;

import java.util.HashSet;

@Service
public class AppUserService implements ReactiveUserDetailsService {
    private final AppUserRepository appUserRepository;
    private final AppUserRolesRepository appUserRolesRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository, AppUserRolesRepository appUserRolesRepository, RoleRepository roleRepository){
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
        this.appUserRolesRepository = appUserRolesRepository;
    }

    public Flux<GrantedAuthority> getAuthorities(Long userId) {
        return appUserRolesRepository.findRoleIdsByAppUserId(userId)
                .flatMap(roleRepository::findById)
                .map(role -> role).cast(GrantedAuthority.class);
    }

    @Override
    public Mono<UserDetails> findByUsername(String email) {

        return appUserRepository.findByEmail(email)
                .flatMap(user ->
                        getAuthorities(user.getId())
                                .collectList()
                                .map(authorities -> {
                                    user.setAuthorities(new HashSet<>(authorities));
                                    return user;
                                })
                );
    }

    @Transactional
    public Mono<AppUser> registerUser(AppUserRegister appUserRegister) {
        return appUserRepository.existsAppUserByEmail(appUserRegister.email()).flatMap(exists -> {
            if (exists) {
                return Mono.error(new IllegalArgumentException("Email already in use"));
            } else {
                AppUser newUser = AppUser.builder()
                        .firstName(appUserRegister.firstName())
                        .lastName(appUserRegister.lastName())
                        .email(appUserRegister.email())
                        .password(appUserRegister.password())
                        .build();
                return appUserRepository.save(newUser).flatMap(appUser -> appUserRolesRepository.adjustRole(appUser.getId()).thenReturn(appUser));
            }
        });
    }
}
