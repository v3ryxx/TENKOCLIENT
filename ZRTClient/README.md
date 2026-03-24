# ZRT Client — Minecraft 1.21.4 Fabric Mod

## Modules

### Combat
- **KillAura** `[R]` — Auto-attacks nearby entities (range, delay, players only settings)
- **Criticals** — Always lands critical hits
- **Reach** — Extended attack/block range (+1.5 blocks)

### Movement
- **Fly** `[F]` — Fly in survival mode
- **Speed** — Speed effect always active
- **Sprint** — Auto-sprint when moving forward
- **NoFall** — Prevents all fall damage

### Visual
- **ESP** — Entity bounding boxes through walls
- **Tracers** — Lines pointing to nearby entities
- **Fullbright** — Night vision always active
- **Xray** — See ores through blocks

### DonutSMP
- **ChunkFinder** — Detects player bases below deepslate (scores chunks by player blocks)
- **TunnelBaseFinder** — Finds player-dug tunnels at deep levels
- **ClusterFinder** — Finds clusters of valuable player-placed blocks
- **LightFinder** — Detects artificially lit areas underground
- **BaseNotifier** — Chat alert when a base is detected nearby
- **ScoreboardHider** — Hides the server scoreboard
- **AutoTotem** — Auto-equips totem of undying in offhand
- **ChestStealer** — Auto-loots opened chests
- **AntiBot** — Ignores bot players in modules
- **NameProtect** — Hides your name in chat
- **AntiKick** — Prevents AFK kick

### Misc
- **FreeCam** — Smooth detached camera (Astralux-style lerp interpolation)
- **HUD** — Watermark + active module list + FPS

## Controls
- **Right Shift** → Open ClickGUI
- **Left click** module → Toggle on/off
- **Right click** module → Open config panel (settings + keybind)
- In config panel: click keybind row → press a key to bind (ESC = unbind)

## How to Build

### Option 1 — GitHub Actions (easiest, automatic)
1. Create a GitHub account
2. Create a new repository
3. Upload this entire folder
4. Go to Actions tab → the build runs automatically
5. Download `ZRTClient-1.0.0.jar` from the Artifacts

### Option 2 — IntelliJ IDEA (local)
1. Install [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/) (free)
2. Open this folder as a project
3. Wait for Gradle sync to finish
4. Build → Build Artifacts → ZRTClient

### Option 3 — Terminal
```bash
./gradlew build
# Output: build/libs/ZRTClient-1.0.0.jar
```

## Install
Copy `ZRTClient-1.0.0.jar` into `.minecraft/mods/`

**Requires:**
- Minecraft 1.21.4
- Fabric Loader ≥ 0.16.9
- Fabric API
