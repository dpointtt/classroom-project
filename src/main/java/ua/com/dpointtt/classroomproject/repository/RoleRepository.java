package ua.com.dpointtt.classroomproject.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Role;

@Repository
public interface RoleRepository extends R2dbcRepository<Role, Long> {
    @Query("SELECT * FROM roles WHERE id = :id")
    Mono<Role> findById(Long id);
}
