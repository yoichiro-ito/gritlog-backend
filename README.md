# gritlog-backend



# テスト
## DBセットアップ

### 初回
` docker compose up -d`

- DBを完全にリセットしたいとき（init.sqlを再実行させたい）
` docker compose down -v`

` docker compose up -d` 

### ローカル起動

` ./gradlew :presentation:bootRun`

#### AdminerでローカルのDBを確認

` http://localhost:8081/?server=mysql`

- ログイン情報
  - サーバー：` mysql `
  - ユーザ：` gritlog`
  - パスワード：` gritlog`
  - データベース：` gritlog`