package ua.com.dpointtt.classroomproject.entity;

import jakarta.persistence.Column;
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
    @Column(name = "string_id")
    private String stringId;
    @Column(name = "classroom_name")
    private String classroomName;
    @Column(name = "classroom_description")
    private String classroomDescription;
}
