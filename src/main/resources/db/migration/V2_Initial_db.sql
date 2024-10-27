CREATE TABLE IF NOT EXISTS app_user
(
    id         BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR(45) NOT NULL,
    last_name  VARCHAR(45) NOT NULL,
    email      VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS classroom
(
    id                    BIGINT       NOT NULL GENERATED ALWAYS AS IDENTITY,
    string_id             VARCHAR(45)  NOT NULL,
    classroom_name        VARCHAR(45)  NOT NULL,
    classroom_description VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_classroom
(
    classroom_id  BIGINT           NOT NULL,
    app_user_id   BIGINT           NOT NULL,
    app_user_type VARCHAR(15)      NOT NULL,
    points        DOUBLE PRECISION NULL,
    PRIMARY KEY (classroom_id, app_user_id),
    CONSTRAINT fk_user_classroom_classroom
        FOREIGN KEY (classroom_id)
            REFERENCES classroom (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_user_classroom_app_user1
        FOREIGN KEY (app_user_id)
            REFERENCES app_user (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS task
(
    id               BIGINT           NOT NULL GENERATED ALWAYS AS IDENTITY,
    task_title       VARCHAR(45)      NOT NULL,
    task_description VARCHAR(255)     NULL,
    task_type        VARCHAR(15)      NULL,
    task_expires     TIMESTAMP(0)     NOT NULL,
    task_points      DOUBLE PRECISION NULL,
    classroom_id     BIGINT           NOT NULL,
    PRIMARY KEY (id, classroom_id),
    CONSTRAINT fk_task_classroom1
        FOREIGN KEY (classroom_id)
            REFERENCES classroom (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);