package ua.com.dpointtt.classroomproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    // TODO: main user class
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Classroom[] classrooms;
}
