CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message VARCHAR(255) NOT NULL,
    dateCreated DATETIME NOT NULL,
    status ENUM('OPEN', 'CLOSED', 'DELETED') NOT NULL,
    curso_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES cursos(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
