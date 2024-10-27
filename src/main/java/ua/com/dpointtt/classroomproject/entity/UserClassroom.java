package ua.com.dpointtt.classroomproject.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_classroom")
public class UserClassroom {
    @Id
    private Long id;
    private Long appUserId;
    private Long classroomId;
    private String userType;
    private float overallPoints;
}
