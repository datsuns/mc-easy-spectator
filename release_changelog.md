# Easy Spectator v1.0.0 (Minecraft 26.3) リリースノート / Release Notes

---

## 🇯🇵 日本語

Minecraft **26.3** 向け **Easy Spectator** v1.0.0 の初版リリースへようこそ！

### ✨ 主な機能・ハイライト

- 👻 **死亡リスポーン時の自動スペクテイター化**:
  - プレイヤーが死亡してリスポーンした瞬間に、自動的に `SPECTATOR`（スペクテイターモード）へ移行します。
  - 疑似ハードコアサーバーや、脱落後に仲間を見守りたいマルチプレイに最適です。
- 🧭 **初期スポーン地点への自動帰還**:
  - 死亡リスポーン時に個人のベッド・リスポーンアンカー登録を自動クリアし、オーバーワールドの**ワールド初期スポーン地点**へ安全にリスポーンさせます。
  - 設定を切り替えることで、登録ベッド位置へスペクテイターとして戻ることも可能です。
- 🐉 **エンド帰還時の安全ガード**:
  - エンダードラゴン討伐後の帰還ポータル通過（生還リスポーン）時には発動せず、サバイバルモード・拠点ベッドを維持して通常通り帰還できます。
- ⚙️ **外部ライブラリ不要の軽量設定画面 (GUI)**:
  - バニラ標準の `Screen` で構築されており、Cloth Config 等を追加導入しなくても単体で軽快に動作します。
  - **Fabric**: **ModMenu** の設定画面から遷移可能。
  - **NeoForge**: 組み込み Mods リストの「Config」ボタンから遷移可能。
- 💾 **設定の自動永続化**:
  - 変更した設定は `config/mc_easy_spectator.properties` に自動保存されます。

### 📦 動作環境
- **Minecraft バージョン**: 26.3
- **Java バージョン**: 25+
- **対応 Mod Loader**: Fabric (0.19.3+), NeoForge (26.3.0+)

---

## 🇬🇧 English

Welcome to the initial release of **Easy Spectator** v1.0.0 for Minecraft **26.3**!

### ✨ Highlights & Features

- 👻 **Instant Spectator on Death Respawn**:
  - Automatically switches the player to `SPECTATOR` mode when respawning from death (`keepEverything == false`).
  - Perfect for mini-games, pseudo-hardcore survival, and multiplayer worlds where eliminated players spectate.
- 🧭 **World Spawn Reset**:
  - Clears personal bed / respawn anchor registrations on death, safely sending the player to the Overworld initial world spawn point.
  - Can be toggled in config if you prefer keeping your bed location in spectator mode.
- 🐉 **Dragon Defeat Guard**:
  - Safely ignores end portal return after defeating the Ender Dragon (`keepEverything == true`), returning you home in survival mode.
- ⚙️ **Zero External Dependency Configuration (GUI)**:
  - Built strictly using native vanilla `Screen` widgets — no external config libraries (like Cloth Config) required.
  - **Fabric**: Fully integrated with **ModMenu**.
  - **NeoForge**: Integrated with the native **Mods List Config** button.
- 💾 **Persistent Settings**:
  - Configurations are saved automatically to `config/mc_easy_spectator.properties`.

### 📦 Supported Environment
- **Minecraft Version**: 26.3
- **Java Version**: 25+
- **Supported Mod Loaders**: Fabric (0.19.3+), NeoForge (26.3.0+)
