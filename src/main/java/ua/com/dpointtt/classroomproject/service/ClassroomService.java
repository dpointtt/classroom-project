package ua.com.dpointtt.classroomproject.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Classroom;
import ua.com.dpointtt.classroomproject.repository.ClassroomRepository;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    public Mono<Classroom> add(Classroom classroom) {
//        classroom.setUserClassrooms(Collections.emptySet());
//        classroom.setTasks(Collections.emptyList());
        return classroomRepository.save(classroom);
    }

    public Mono<Classroom> getByStringId(String stringId){
        return classroomRepository.findByStringId(stringId);
    }

    public Mono<Classroom> getById(Long id){
        return classroomRepository.findById(id);
    }

    public Flux<Classroom> getAll(){
        return classroomRepository.findAll();
    }

    public Mono<Classroom> deleteOne(Long id){
        return classroomRepository.findById(id).doOnSuccess(classroomRepository::delete);
    }

    @Transactional
    public Mono<Classroom> updateOne(Classroom classroom){
        return classroomRepository.save(classroom);
    }

}
