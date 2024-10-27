package ua.com.dpointtt.classroomproject.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import ua.com.dpointtt.classroomproject.entity.Task;

@Repository
public interface TaskRepository extends R2dbcRepository<Task, Long> {

}
