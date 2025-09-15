-- DB作成
CREATE DATABASE IF NOT EXISTS gritlog
  CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE DATABASE IF NOT EXISTS gritlog_test
  CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

-- ユーザー（存在しなければ作成）
CREATE USER IF NOT EXISTS 'gritlog'@'localhost' IDENTIFIED BY 'gritlog';
CREATE USER IF NOT EXISTS 'gritlog'@'%'         IDENTIFIED BY 'gritlog';

-- 権限付与（本番相当＆テスト）
GRANT ALL PRIVILEGES ON gritlog.*      TO 'gritlog'@'localhost';
GRANT ALL PRIVILEGES ON gritlog.*      TO 'gritlog'@'%';
GRANT ALL PRIVILEGES ON gritlog_test.* TO 'gritlog'@'localhost';
GRANT ALL PRIVILEGES ON gritlog_test.* TO 'gritlog'@'%';

FLUSH PRIVILEGES;
