package ua.com.dpointtt.classroomproject.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository; - спринг его не видит
import org.springframework.stereotype.Repository;
import ua.com.dpointtt.classroomproject.entity.Message;

@Repository
public interface MessageRepository extends R2dbcRepository<Message, Long> {

}
