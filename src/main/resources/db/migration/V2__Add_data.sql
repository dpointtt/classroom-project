INSERT INTO app_user (first_name, last_name, email, password) VALUES ('Denys', 'Tsyshevskyi', 'dpointtt@outlook.com', 'admin');
INSERT INTO app_user (first_name, last_name, email, password) VALUES ('Some', 'Guy', 'random@gmail.com', '1234');

INSERT INTO roles (name) VALUES ('ROLE_User');
INSERT INTO roles (name) VALUES ('ROLE_Admin');

INSERT INTO app_user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO app_user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO app_user_roles (user_id, role_id) VALUES (2, 1);

INSERT INTO classroom (string_id, classroom_name, classroom_description) VALUES ('test', 'Test classroom', 'Classroom description example');
INSERT INTO classroom (string_id, classroom_name, classroom_description) VALUES ('random', 'Random classroom', 'Random classroom description');

INSERT INTO task (task_title, task_description, task_type, task_expires, task_points, classroom_id) VALUES ('Test task', 'Task description', 'DEFAULT', '2024-11-03T03:30:00', 5.0, 1);
INSERT INTO task (task_title, task_description, task_type, task_expires, task_points, classroom_id) VALUES ('Random task', 'Random task description', 'DEFAULT', '2024-11-12T12:45:00', 10.0, 2);

INSERT INTO user_classroom (classroom_id, app_user_id, app_user_type, points) VALUES (1, 1, 'DEFAULT', 0.0);
INSERT INTO user_classroom (classroom_id, app_user_id, app_user_type, points) VALUES (2, 2, 'DEFAULT', 0.0);