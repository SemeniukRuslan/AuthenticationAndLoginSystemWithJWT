-- Create the roles table
CREATE TABLE roles
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

-- Insert initial roles data
INSERT INTO roles (name)
VALUES ('ROLE_USER');
INSERT INTO roles (name)
VALUES ('ROLE_MODERATOR');
INSERT INTO roles (name)
VALUES ('ROLE_ADMIN');

-- Create the users table
CREATE TABLE users
(
    id       BIGINT NOT NULL AUTO_INCREMENT,
    email    VARCHAR(50) UNIQUE,
    password VARCHAR(120),
    username VARCHAR(20) UNIQUE,
    PRIMARY KEY (id)
);

-- Create the user_roles table
CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);