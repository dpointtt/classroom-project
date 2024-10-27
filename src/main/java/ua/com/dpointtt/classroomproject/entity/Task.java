package ua.com.dpointtt.classroomproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// TODO: zadanie v classroom
public class Task {
    private Long id;
    private String taskName;
    private TaskType type;
    private String taskDescription;
    private LocalDateTime expires;
    private float points;
}
