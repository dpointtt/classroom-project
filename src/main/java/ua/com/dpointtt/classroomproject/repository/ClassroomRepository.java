package ua.com.dpointtt.classroomproject.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Classroom;

@Repository
public interface ClassroomRepository extends R2dbcRepository<Classroom, Long> {
    Mono<Classroom> findByStringId(String stringId);
}
