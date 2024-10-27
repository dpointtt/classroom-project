package ua.com.dpointtt.classroomproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// TODO: add relationships (when database will be ready)
public class Classroom {
    private Long id;
    private String stringId;
    private String classroomName;
    private String classroomDescription;
    private AppUser[] teachers;
    private AppUser[] students;
    private Task[] tasks;
}
