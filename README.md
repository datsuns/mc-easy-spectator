# Easy Spectator

Minecraft Mod (Fabric & NeoForge for Minecraft 26.3) that forces spectator mode upon death respawn and resets spawn point back to the world spawn location.

## Features

- **Forced Spectator on Death Respawn**:
  - Automatically switches the player to `SPECTATOR` mode when respawning from death (`keepEverything == false`).
  - Does **not** trigger when returning from the End portal after defeating the Ender Dragon (`keepEverything == true`).
- **Ignore & Reset Personal Spawn Point**:
  - Clears personal bed / respawn anchor configuration so players safely respawn at the world initial spawn point in the Overworld.
  - Can be toggled in the configuration if you prefer respawning at your bed in spectator mode.
- **In-Game Configuration Screen**:
  - Integrated with **ModMenu** (Fabric) and the native **Mods List Config** button (NeoForge).
  - Built with vanilla `Screen` widgets, requiring zero external config libraries (e.g. Cloth Config).

## Configuration Options

Saved in `config/mc_easy_spectator.properties`:

| Option | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `enabled` | `boolean` | `true` | Enables or disables the mod's death respawn spectator feature. |
| `ignoreSpawnPoint` | `boolean` | `true` | `ON`: Clears bed spawn and respawns at world spawn point.<br>`OFF`: Respawns at registered bed/anchor. |

## License

MIT License
