# Mod Specification - Easy Spectator

## 1. 基本情報 (Metadata)
- **Mod Name**: `Easy Spectator`
- **Mod ID**: `mc_easy_spectator`
- **Package**: `me.datsuns.easyspectator`
- **Minecraft Version**: `26.3`
- **Target Platforms**: Multi-loader (`common` / `fabric` / `neoforge`)

---

## 2. 機能仕様 (Core Features)

### 2.1. 発動条件（死亡リスポーン判定）
- プレイヤーが**死亡してリスポーンしたとき**（`PlayerList.respawn` における `keepEverything == false` / `AFTER_RESPAWN` の `!alive`）のみ発動します。
- **エンダードラゴン討伐後の帰還ポータル通過時**（`keepEverything == true` / `alive == true`）には**発動しません**（バニラ通り元のゲームモード・ベッド登録を維持して帰還します）。

### 2.2. リスポーン時の動作フロー
死亡によるリスポーンが発生した際、設定値に応じて以下の順序で処理を行います。

1. **Mod有効判定 (`enabled`)**:
   - `OFF` (`false`) の場合：Modは何も介入せず、バニラ標準の挙動でリスポーンします。
   - `ON` (`true`, 初期値) の場合：以下の処理を実行します。
2. **スポーン設定の制御 (`ignoreSpawnPoint`)**:
   - `ON` (`true`, 初期値) の場合：
     - リスポーン座標が決定される**前**に、プレイヤー個人のスポーン設定（ベッド／リスポーンアンカーの登録）を消去します。
     - これにより、バニラ標準のリスポーン処理によって**オーバーワールドのワールド初期スポーン地点**へ安全にリスポーンします。
   - `OFF` (`false`) の場合：
     - ベッド／リスポーンアンカーの登録を維持したままリスポーンします（有効なベッド・アンカーがあればその位置へ、なければワールド初期スポーン地点へリスポーンします）。
3. **強制スペクテイターモード化**:
   - リスポーン完了直後のプレイヤーのゲームモードを **`GameType.SPECTATOR`（スペクテイターモード）** に変更します。

---

## 3. 設定項目と設定画面 (Configuration & GUI)

- **設定ファイル**: `config/mc_easy_spectator.properties`
- **設定画面 (GUI)**:
  - バニラ標準の `Screen`（`CycleButton`）で実装し、外部ライブラリ（Cloth Config 等）が未導入でも単体で動作します。
  - **Fabric**: ModMenu の設定ボタンから開閉可能。
  - **NeoForge**: 標準の Mods 一覧画面の「Config」ボタン（`IConfigScreenFactory`）から開閉可能。
- **対応言語**: 日本語 (`ja_jp.json`) / 英語 (`en_us.json`)

| 設定項目 | プロパティキー | 型 | 初期値 | 動作内容 |
| :--- | :--- | :--- | :--- | :--- |
| **Mod Enabled** (Modの有効化) | `enabled` | `boolean` | `true` (`ON`) | `ON`: 死亡リスポーン時にスペクテイター化する<br>`OFF`: バニラ標準のリスポーン挙動にする |
| **Ignore Spawn Point** (スポーン設定を無視) | `ignoreSpawnPoint` | `boolean` | `true` (`ON`) | `ON`: ベッド等の登録を消去し、ワールド初期スポーン地点にリスポーンする<br>`OFF`: ベッド等の登録を維持し、その位置にリスポーンする |
