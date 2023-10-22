-- CREATE TABLE IF NOT EXISTS project ( id BIGINT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(100), description VARCHAR(100))
CREATE TABLE IF NOT EXISTS task (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        title VARCHAR(255) NOT NULL,
        date DATE NOT NULL,
        is_done BOOLEAN NOT NULL,
        project_id BIGINT,
        FOREIGN KEY (project_id) REFERENCES project(id)
        );