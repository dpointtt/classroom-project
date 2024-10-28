package ua.com.dpointtt.classroomproject.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Task;
import ua.com.dpointtt.classroomproject.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Mono<Task> add(Task task) {
        return taskRepository.save(task);
    }

    public Flux<Task> getAll(){
        return taskRepository.findAll();
    }

    public Mono<Task> deleteOne(Long id){
        return taskRepository.findById(id).doOnSuccess(taskRepository::delete);
    }

    @Transactional
    public Mono<Task> updateOne(Task task){
        return taskRepository.save(task);
    }

}
