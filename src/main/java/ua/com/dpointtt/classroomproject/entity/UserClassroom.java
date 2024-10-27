package ua.com.dpointtt.classroomproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserClassroom {
    // TODO: соединяющий класс для MANY-MANY конекта в бд
    private Long id;
    private AppUser user;
    private Classroom classroom;
    private AppUserType userType;
    private float overallPoints;
}
