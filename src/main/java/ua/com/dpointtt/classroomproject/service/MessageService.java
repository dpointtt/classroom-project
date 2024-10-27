package ua.com.dpointtt.classroomproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.dpointtt.classroomproject.entity.Message;
import ua.com.dpointtt.classroomproject.repository.MessageRepository;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Mono<Message> addOne(Message message){
        return messageRepository.save(message);
    }

    public Flux<Message> list(Long start, Long count){
       return messageRepository.findAll().skip(start).take(count);
    }

}
