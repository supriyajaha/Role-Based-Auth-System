DROP DATABASE IF EXISTS role_system;
CREATE DATABASE IF NOT EXISTS role_system;
USE role_system;
DROP TABLE IF EXISTS domain_user;
DROP TABLE IF EXISTS action_type;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS resource;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS role_action_type;
DROP TABLE IF EXISTS resource_role;

CREATE TABLE domain_user(
    user_id    int unsigned NOT NULL auto_increment,
    username  varchar(20) UNIQUE NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE action_type(
    action_type_id        int unsigned NOT NULL auto_increment,
    action_type_name varchar(20) UNIQUE NOT NULL,
    PRIMARY KEY(action_type_id)
);

CREATE TABLE role(
    role_id        int unsigned NOT NULL auto_increment,
    role_name varchar(20) UNIQUE NOT NULL,
    PRIMARY KEY(role_id)
);

CREATE TABLE resource(
    resource_id    int unsigned NOT NULL auto_increment,
    resource_name  varchar(20) UNIQUE NOT NULL,
    PRIMARY KEY(resource_id)
);

CREATE TABLE user_role_resource(
    user_role_id int unsigned NOT NULL auto_increment,
    user_id     int unsigned,
    role_id    int unsigned,
    resource_id int Unsigned,
    PRIMARY  KEY(user_role_id),
    FOREIGN KEY(user_id) REFERENCES domain_user(user_id) ON DELETE CASCADE,
    FOREIGN KEY(role_id) REFERENCES role(role_id) ON DELETE CASCADE,
    FOREIGN KEY(resource_id) REFERENCES resource(resource_id) ON DELETE CASCADE
);

CREATE TABLE role_action_type(
    role_action_type_id int unsigned NOT NULL auto_increment,
    action_type_id    int unsigned,
    role_id     int unsigned,
    PRIMARY  KEY(role_action_type_id),
    FOREIGN KEY(action_type_id) REFERENCES action_type(action_type_id) ON DELETE CASCADE,
    FOREIGN KEY(role_id) REFERENCES role(role_id) ON DELETE CASCADE
);

INSERT INTO domain_user(username)
VALUES ("dylan_locus"),("robin_locus"),("manu_locus"),("sameer_locus");

INSERT INTO action_type(action_type_name)
VALUES ("read"),("create"),("delete"),("update");

INSERT INTO resource(resource_name)
VALUES ("file_team_a"),("file_team_b");

INSERT INTO role(role_name)
VALUES ("admin"),("guest"),("employee_team_a"),("employee_team_b");

INSERT INTO user_role_resource (user_id,role_id,resource_id)
VALUES (1,1,1),(1,1,2),(2,2,1),(2,2,2),(3,3,1),(3,2,4),(4,2,1),(4,4,4);

INSERT INTO role_action_type (role_id,action_type_id)
VALUES (1,1),(1,2),(1,3),(1,4),(2,1),(3,1),(3,4),(4,1),(4,2);

