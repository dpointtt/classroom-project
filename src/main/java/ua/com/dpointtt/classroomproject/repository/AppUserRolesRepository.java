package ua.com.dpointtt.classroomproject.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.AppUserRoles;

@Repository
public interface AppUserRolesRepository extends R2dbcRepository<AppUserRoles, Long> {
    @Query("SELECT role_id FROM app_user_roles WHERE user_id = :userId")
    Flux<Long> findRoleIdsByAppUserId(Long userId);

    @Query("INSERT INTO app_user_roles(user_id, role_id) VALUES (:userId, 1)")
    Mono<String> adjustRole(Long userId);
}
