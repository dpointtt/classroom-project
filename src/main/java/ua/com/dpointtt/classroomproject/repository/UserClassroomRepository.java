package ua.com.dpointtt.classroomproject.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import ua.com.dpointtt.classroomproject.entity.UserClassroom;

@Repository
public interface UserClassroomRepository extends R2dbcRepository<UserClassroom, Long> {
}
