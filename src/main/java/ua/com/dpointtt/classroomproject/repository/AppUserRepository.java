package ua.com.dpointtt.classroomproject.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.AppUser;

@Repository
public interface AppUserRepository extends R2dbcRepository<AppUser, Long> {
    @Query("SELECT id, email, password FROM app_user WHERE email = :email")
    Mono<AppUser> findByEmail(String email);

    Mono<Boolean> existsAppUserByEmail(String email);
}
