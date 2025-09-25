-- Accounts
INSERT INTO account (id, name_kanji_kana, name_kana, name_alphabet, login_id, password, initial_password, email, password_attempts, login_failure_at, locked_at, changed_password_at, deleted_at, created_by, updated_by, created_at, updated_at)
VALUES
 (1, '綿貫雅丈', 'ワタヌキマサタケ', 'Masatake Watanuki', 'admin', '$2a$10$abcdefghijklmnopqrstuvABCDEFGHIJKLMNO1234567890abcd', NULL, 'admin@example.com', 0, NULL, NULL, NOW(), NULL, NULL, NULL, NOW(), NOW()),
 (2, 'コーチ太郎', 'コーチタロウ', 'Coach Taro', 'coach', '$2a$10$abcdefghijklmnopqrstuvABCDEFGHIJKLMNO1234567890abcd', NULL, 'coach@example.com', 0, NULL, NULL, NOW(), NULL, NULL, NULL, NOW(), NOW()),
 (3, '選手一郎', 'センシュイチロウ', 'Player Ichiro', 'player1', '$2a$10$abcdefghijklmnopqrstuvABCDEFGHIJKLMNO1234567890abcd', NULL, 'player1@example.com', 0, NULL, NULL, NOW(), NULL, NULL, NULL, NOW(), NOW());

-- Roles
INSERT INTO role (id, name, code, created_at, updated_at)
VALUES
 (1, '管理者', 'ADMIN', NOW(), NOW()),
 (2, '一般ユーザ', 'USER', NOW(), NOW()),
 (3, 'コーチ', 'COACH', NOW(), NOW());

-- Account-Role mapping
INSERT INTO account_role (account_id, role_id) VALUES
 (1, 1), -- admin -> ADMIN
 (1, 2), -- admin -> USER
 (2, 3), -- coach -> COACH
 (3, 2); -- player1 -> USER

-- Goals
INSERT INTO goal (id, account_id, status, main_goal_title, main_goal_description, start_date, end_date, created_at, updated_at)
VALUES
 (1, 3, 'ACTIVE', 'スプリント強化', '30m/60mの短距離改善', CURDATE(), DATE_ADD(CURDATE(), INTERVAL 90 DAY), NOW(), NOW());

-- Sub Goals
INSERT INTO sub_goal (id, goal_id, category, title, description, order_no, created_at, updated_at)
VALUES
 (1, 1, 'PHYSICAL', '下半身パワー', 'スクワットとプライオメトリクス', 1, NOW(), NOW()),
 (2, 1, 'TECHNIQUE', 'スタート反応', 'クラウチングからの初動改善', 2, NOW(), NOW());

-- Action Plans (5W1H の WHEN/WHAT/HOW を文字列で保持)
INSERT INTO action_plan (id, sub_goal_id, plan_when, plan_what, plan_how, created_at, updated_at)
VALUES
 (1, 1, '毎週 月・木 19:00', 'スクワット 5x5', '前回から+2.5kg、動画撮影してフォーム確認', NOW(), NOW()),
 (2, 2, '毎週 水 19:30', 'スタートドリル 10本 x 3セット', 'メトロノーム60bpmで合図→0.2秒以内で踏み出し', NOW(), NOW());

-- Reflections
INSERT INTO reflection (id, account_id, sub_goal_id, evaluation_score, comment, is_public, created_at, updated_at)
VALUES
 (1, 3, 1, 4, 'フォームは安定。ボリュームを少し増やしたい', 1, NOW(), NOW()),
 (2, 3, 2, 3, '反応のばらつきあり。ウォームアップ見直し', 1, NOW(), NOW());

-- Comments
INSERT INTO comment (id, reflection_id, author_account_id, parent_comment_id, body, created_at, updated_at)
VALUES
 (1, 1, 2, NULL, 'いいね。来週はバー速度も計測してみよう。', NOW(), NOW()),
 (2, 2, 2, NULL, 'ドリル前にAスキップを入れて神経系を起こそう。', NOW(), NOW());
