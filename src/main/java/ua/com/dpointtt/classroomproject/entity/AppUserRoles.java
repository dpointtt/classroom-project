package ua.com.dpointtt.classroomproject.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "app_user_roles")
public class AppUserRoles {
    @Id
    private Long id;
    private Long role_id;
    private Long app_user_id;
}
