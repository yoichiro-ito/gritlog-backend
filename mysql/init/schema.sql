-- db
CREATE DATABASE IF NOT EXISTS gritlog
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci;
USE gritlog;

-- アカウント
CREATE TABLE account (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 name_kanji_kana VARCHAR(50) NOT NULL,
 name_kana VARCHAR(50) NOT NULL,
 name_alphabet VARCHAR(50),
 login_id VARCHAR(255) NOT NULL,
 password VARCHAR(255),
 initial_password VARCHAR(255),
 email VARCHAR(255),
 password_attempts INT DEFAULT 0,
 login_failure_at DATETIME,
 locked_at DATETIME,
 changed_password_at DATETIME,
 deleted_at DATETIME,
 created_by BIGINT,
 updated_by BIGINT,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

CREATE TABLE role (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL,
 code VARCHAR(50) NOT NULL,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

CREATE TABLE account_role (
 account_id BIGINT NOT NULL,
 role_id BIGINT NOT NULL,
 PRIMARY KEY (account_id, role_id),
 KEY idx_account_role_role (role_id),
 CONSTRAINT fk_account_role_account FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE,
 CONSTRAINT fk_account_role_role FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 目標
CREATE TABLE goal (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 account_id BIGINT NOT NULL,
 status VARCHAR(32) NOT NULL,
 main_goal_title VARCHAR(100) NOT NULL,
 main_goal_description VARCHAR(200),
 start_date DATE,
 end_date DATE,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 KEY idx_goal_account (account_id),
 CONSTRAINT fk_goal_account FOREIGN KEY (account_id) REFERENCES account(id)
) ENGINE=InnoDB;

CREATE TABLE sub_goal (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 goal_id BIGINT NOT NULL,
 category VARCHAR(32) NOT NULL,
 title VARCHAR(100) NOT NULL,
 description VARCHAR(200),
 order_no INT NOT NULL DEFAULT 0,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 KEY idx_sub_goal_goal (goal_id),
 CONSTRAINT fk_sub_goal_goal FOREIGN KEY (goal_id) REFERENCES goal(id)
) ENGINE=InnoDB;

CREATE TABLE action_plan (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 sub_goal_id BIGINT NOT NULL,
 plan_when VARCHAR(100) NOT NULL,
 plan_what VARCHAR(100) NOT NULL,
 plan_how VARCHAR(200) NOT NULL,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 KEY idx_action_plan_sub_goal (sub_goal_id),
 CONSTRAINT fk_action_plan_sub_goal FOREIGN KEY (sub_goal_id) REFERENCES sub_goal(id)
) ENGINE=InnoDB;

-- 振り返り
CREATE TABLE reflection (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 account_id BIGINT NOT NULL,
 sub_goal_id BIGINT NOT NULL,
 evaluation_score INT NOT NULL,
 comment VARCHAR(1000),
 is_public TINYINT(1) NOT NULL,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 KEY idx_reflection_account (account_id),
 KEY idx_reflection_sub_goal (sub_goal_id),
 CONSTRAINT fk_reflection_account FOREIGN KEY (account_id) REFERENCES account(id),
 CONSTRAINT fk_reflection_sub_goal FOREIGN KEY (sub_goal_id) REFERENCES sub_goal(id)
) ENGINE=InnoDB;

CREATE TABLE comment (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 reflection_id BIGINT NOT NULL,
 author_account_id BIGINT NOT NULL,
 parent_comment_id BIGINT,
 body VARCHAR(1000) NOT NULL,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 KEY idx_comment_reflection (reflection_id),
 KEY idx_comment_author (author_account_id),
 KEY idx_comment_parent (parent_comment_id),
 CONSTRAINT fk_comment_reflection FOREIGN KEY (reflection_id) REFERENCES reflection(id),
 CONSTRAINT fk_comment_author FOREIGN KEY (author_account_id) REFERENCES account(id),
 CONSTRAINT fk_comment_parent FOREIGN KEY (parent_comment_id) REFERENCES comment(id)
) ENGINE=InnoDB;

/*
-- reactions
CREATE TABLE reaction (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 target_type VARCHAR(16) NOT NULL,
 target_id BIGINT NOT NULL,
 account_id BIGINT NOT NULL,
 emoji VARCHAR(64) NOT NULL,
 created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 KEY idx_reaction_target (target_type, target_id),
 CONSTRAINT fk_reaction_account FOREIGN KEY (account_id) REFERENCES account(id)
) ENGINE=InnoDB;
*/
