package ua.com.dpointtt.classroomproject.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import ua.com.dpointtt.classroomproject.entity.AppUser;

@Repository
public interface AppUserRepository extends R2dbcRepository<AppUser, Long> {

}
