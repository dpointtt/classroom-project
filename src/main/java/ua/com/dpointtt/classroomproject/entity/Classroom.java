package ua.com.dpointtt.classroomproject.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "classroom")
public class Classroom {
    @Id
    private Long id;
    private String stringId;
    private String classroomName;
    private String classroomDescription;
}
