# Object-Oriented Programming 1 Game Project

## Altered Ego: A Text-Based Turn-Based RPG Written in Java

**Developer:** Shell Syndicate Software Co. Ltd  
**Genre:** Sci-Fi, Turn-Based Strategy / RPG

---

## Background Story

Five random people bought the same old game console in a store on the same day. This game console contained an unnamed game, and when they tried to play it, they were absorbed into a digital world where they faced their **Altered Egos**. The only way to escape is to defeat their opposite self—or be trapped inside the console forever.

---

## Game Modes

1. **Player vs. Player (PvP — Best-of-3)**
   - Two local players select their champions from the Hero and Altered Ego rosters and battle head-to-head across up to 3 rounds.
   - Features special narrative encounters and unique counterpart banters when rivals clash.

2. **Player vs. Computer (PvC — Best-of-3)**
   - Battle against a smart AI opponent across a Best-of-3 series.
   - The AI dynamically evaluates its available mana and active skill cooldowns to execute optimal counterattacks.

3. **Arcade Mode (1v5 Survival Gauntlet + Secret Final Boss)**
   - Take one champion through a relentless gauntlet against all five Altered Ego enemies in randomized order.
   - Recover a random multiplier of HP and Mana between victories.
   - **Secret Final Boss:** Defeating all 5 Altered Egos tears open a dimensional rift, summoning **Ohma Zi-O**, the Demon King of Time (`1000 HP`, `300 Mana`), for the true ending.

4. **Random Mode**
   - Lets fate decide which game mode you are thrown into.

---

## Characters & Altered Ego Counterparts

All standard playable characters and enemies start with **500 HP** and **200 Mana**.

### Playable Heroes vs. Altered Ego Enemies

| # | Playable Hero | Hero Skills (Skill 1 / Skill 2 / Ultimate) | Altered Ego Counterpart | Enemy Skills (Skill 1 / Skill 2 / Ultimate) |
| :-: | :--- | :--- | :--- | :--- |
| **[1]** | **Cosmic Dassel** | Provoked Punch / Bug Overflow / Overclock | **Kaniel Outis** | Image Burn / Spirit Compression / Sanity Drain |
| **[2]** | **Khylle The Reaper** | Karate Kick / Flying Food / Voice of Destruction | **Van Berksville** | Stab / Getsuga / Fang Sword Style |
| **[3]** | **Earl** | Knee Strike / Double Kick / Dodge | **Asta Clover** | Demon Slayer Slash / Demon Dweller Double Slash / Demon Union |
| **[4]** | **The One John** | Upper Cut / Counterpalm / Flaring Punches | **JF Void** | Void Chop / Void Deflect / Void Stagger Palm |
| **[5]** | **And Rew** | Dragon Fist / Dragon Fist Missiles / Dragon's Verdict of Demise | **Deidre** | Lightning Cut / Thunder Cleave / Final Turn |

### Skill Breakdown & Combat Mechanics

| Action | Input | Standard Damage | OP Character Damage | Mana Cost | Cooldown |
| :--- | :-: | :-: | :-: | :-: | :-: |
| **Basic Attack** | `[0]` | 40 – 50 | 50 | 0 | None |
| **Skill One** | `[1]` | 50 – 60 | 100 | 25 | 2 Turns |
| **Skill Two** | `[2]` | 60 – 70 | 150 | 50 | 3 Turns |
| **Skill Three (Ultimate)** | `[3]` | 100 – 150 | 500 | 100 | 5 Turns |

### Secret Characters & Bosses

- **`[0]` OP Character (Playable Easter Egg):** Entering `0` at the Player Character Selection prompt unlocks the hidden developer character (`1000 HP`, `500 Mana`) equipped with `One Tap`, `System Wipe`, and `Admin Override`.
- **Ohma Zi-O (Arcade Final Boss):** Appears after clearing all 5 rounds in Arcade Mode (`1000 HP`, `300 Mana`) wielding `Temporal Strike`, `Rift Crush`, and `King's Judgment`.

---

## Project Architecture & OOP Principles

```text
AlteredEgo/
└── src/
    ├── main/
    │   └── Main.java                # Entry point and top-level game loop
    └── gameutils/
        ├── GameCharacter.java       # Abstract base class for all combatants
        ├── Skills.java              # Interface defining combat actions
        ├── Skill.java               # Encapsulated skill model (damage, mana, cooldown)
        ├── Player.java              # Playable character implementation
        ├── Enemy.java               # Enemy / Altered Ego implementation
        ├── OPCharacter.java         # Secret overpowered character subclass
        ├── DialogueManager.java     # Centralized character & encounter dialogue system
        ├── ConsoleTheme.java        # ANSI colors, HP/MP bars, and layout helpers
        ├── AsciiArtAssets.java      # ASCII banners, portraits, and combat animations
        ├── BattleHudRenderer.java   # Split-screen HUD, VS screen, and skill deck rendering
        └── ConsoleOutput.java       # UI orchestration, input validation, and battle engine
```

- **Abstraction:** `GameCharacter` serves as an abstract foundation managing shared combat state (`name`, `hitpoints`, `mana`, `maxHitpoints`, `maxMana`, healing, and stat resets), while `Skills` defines the contract (`basicAttack()`, `skillOne()`, `skillTwo()`, `skillThree()`) required of every combatant.
- **Inheritance:** `Player` and `Enemy` both extend `GameCharacter`, while `OPCharacter` extends `Player`, specializing stats and combat behavior without duplicating core state management.
- **Encapsulation:** `Skill` encapsulates skill metadata (name, minimum/maximum damage, mana cost, max cooldown, and current cooldown timer) behind clean getters and state-mutation helpers. `GameCharacter` protects health and mana invariants with bounded mutators.
- **Polymorphism:** `OPCharacter` overrides the skill execution methods from `Player` (`Skills` interface) to deliver deterministic high-damage attacks while seamlessly participating in any battle mode that accepts a `Player` or `GameCharacter`.
- **Separation of Concerns:** `DialogueManager` isolates all character intro monologues, 25 counterpart dialogue exchanges, and skill activation voice lines, while `ConsoleTheme`, `AsciiArtAssets`, and `BattleHudRenderer` handle presentation independently of game logic in `ConsoleOutput`.

---

## How to Compile and Run

### Prerequisites
- **Java Development Kit (JDK):** Java 17 or higher recommended.

### Option 1: Command Line (CLI)

Clone the repository and compile the sources from the project root:

```bash
git clone https://github.com/dassel-avg-dev/AlteredEgo.git
cd AlteredEgo
javac -encoding UTF-8 -d out src/gameutils/*.java src/main/Main.java
java -cp out main.Main
```

> **Windows tip:** run the game from **Windows Terminal**, PowerShell 7, or any terminal with ANSI color support so the HUD colors and ASCII art render correctly.

### Option 2: IntelliJ IDEA

1. Open **IntelliJ IDEA** and select **File -> Open...**, then choose the `AlteredEgo` project directory.
2. Ensure `src` is marked as the **Sources Root** and a valid **Project SDK (JDK 17+)** is configured under **File -> Project Structure**.
3. Ensure the run configuration has **VM options** `-Dfile.encoding=UTF-8` and enable **ANSI colors** in the console if prompted.
4. Open `src/main/Main.java` and click the green **Run** icon next to `public static void main(String[] args)`.

### Option 3: Visual Studio Code

1. Install the **Extension Pack for Java**.
2. Open the `AlteredEgo` folder in VS Code.
3. Open `src/main/Main.java` and click **Run** above `public static void main(String[] args)`.

---

## Members

- **Dassel Bacaltos** (Project Manager)
- **Daven Khylle Famat**
- **Francis Earl Brigoli**
- **Alieyandrew Juhanes Idala**
- **John Fiel Amancio** (Former Member)
