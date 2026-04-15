# sdd-demo

Kotlin マイクロサービス開発用リポジトリ。Quarkus + Gradle + PostgreSQL 構成。

## 技術スタック

| 項目 | 内容 |
|---|---|
| 言語 | Kotlin 2.0 |
| フレームワーク | Quarkus 3.17 |
| ビルドツール | Gradle 8.10 (Kotlin DSL) |
| JVM | Java 21 |
| データベース | PostgreSQL 16 |

## プロジェクト構成

```
service/                    # Quarkus マイクロサービス
├── build.gradle.kts
├── gradle.properties
├── settings.gradle.kts
└── src/
    ├── main/
    │   ├── kotlin/com/example/service/
    │   │   ├── entity/         # JPA エンティティ
    │   │   ├── repository/     # Panache リポジトリ
    │   │   └── resource/       # REST エンドポイント
    │   └── resources/
    │       └── application.properties
    └── test/kotlin/com/example/service/
```

## 開発環境の起動

devcontainer が起動すると以下のサービスが自動起動します。

- **PostgreSQL**: `localhost:5432` (user: `appuser`, db: `appdb`)
- **Quarkus Dev Server**: `localhost:8080` (ライブリロード有効)

### 手動起動

```bash
# PostgreSQL のみ起動
gitpod automations service start postgres

# Quarkus dev mode 起動
cd service && ./gradlew quarkusDev
```

## API エンドポイント

| メソッド | パス | 説明 |
|---|---|---|
| GET | `/items` | 一覧取得 |
| GET | `/items/{id}` | 1件取得 |
| POST | `/items` | 作成 |
| PUT | `/items/{id}` | 更新 |
| DELETE | `/items/{id}` | 削除 |
| GET | `/q/health/ready` | ヘルスチェック |

## テスト実行

```bash
cd service && ./gradlew test
```
