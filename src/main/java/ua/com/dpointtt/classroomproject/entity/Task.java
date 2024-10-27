package ua.com.dpointtt.classroomproject.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    private Long id;
    private String taskTitle;
    private String taskType;
    private String taskDescription;
    private LocalDateTime taskExpires;
    private float taskPoints;
    private Long classroomId;
}
