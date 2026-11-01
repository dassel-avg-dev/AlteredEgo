package gameutils;

import java.util.*;

public class ConsoleOutput {
    static final int slowDelayPreset = 120;
    static final int mediumDelayPreset = 80;
    static final int fastDelayPreset = 15;
    static final int len = 60;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public ConsoleOutput() {
    }

    // Prints every character with delay
    public static void printWithDelay(String text, int delay) {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void printCenter(String text, int length) {
        if (text == null) text = "";
        if (length <= text.length()) {
            System.out.println(text.substring(0, Math.min(text.length(), length)));
            return;
        }

        int totalPadding = length - text.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        String line = " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
        System.out.println(line);
    }

    public static void printCenter(String text, int length, char fillChar) {
        if (text == null) text = "";
        if (length <= text.length()) {
            System.out.println(text.substring(0, Math.min(text.length(), length)));
            return;
        }

        int totalPadding = length - text.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        String line = String.valueOf(fillChar).repeat(leftPadding)
                + text
                + String.valueOf(fillChar).repeat(rightPadding);

        System.out.println(line);
    }

    public static void printCenter(String text, int length, char fillChar, int delay) {
        if (text == null) text = "";

        if (length <= text.length()) {
            text = text.substring(0, Math.min(text.length(), length));
        } else {
            int totalPadding = length - text.length();
            int leftPadding = totalPadding / 2;
            int rightPadding = totalPadding - leftPadding;

            text = String.valueOf(fillChar).repeat(leftPadding)
                    + text
                    + String.valueOf(fillChar).repeat(rightPadding);
        }

        if (text.length() < length) {
            text += String.valueOf(fillChar).repeat(length - text.length());
        } else if (text.length() > length) {
            text = text.substring(0, length);
        }

        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public void gameTitle() {
        System.out.println();
        System.out.println(AsciiArtAssets.getGameTitleBanner());
    }

    public void printEndCredits() {
        System.out.println();
        printWithDelay(AsciiArtAssets.getEndCreditsBanner(), 2);
    }

    public void loadingScreen() {
        System.out.println();
        System.out.println(AsciiArtAssets.getCursedConsoleArt());
        printWithDelay(ConsoleTheme.BRIGHT_CYAN + "\n          [SYSTEM] INITIALIZING ALTERED EGO TERMINAL ARENA......" + ConsoleTheme.RESET, fastDelayPreset);
        System.out.println(ConsoleTheme.BRIGHT_CYAN + "          1%                                                        100%" + ConsoleTheme.RESET);
        System.out.print("          " + ConsoleTheme.BRIGHT_GREEN);
        printWithDelay("[============================================================]" + ConsoleTheme.RESET, 12);
    }

    // ==================== Reusable Input Helpers ====================

    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            try {
                if (prompt != null && !prompt.isEmpty()) {
                    System.out.print(prompt);
                }
                int val = scanner.nextInt();
                if (val < min || val > max) {
                    throw new InputMismatchException();
                }
                return val;
            } catch (InputMismatchException e) {
                System.out.println(ConsoleTheme.BRIGHT_RED + "\n\t\t\t\t[!] Invalid Input, Try Again!" + ConsoleTheme.RESET);
                scanner.nextLine();
            }
        }
    }

    public boolean readYesNo(String prompt) {
        while (true) {
            try {
                if (prompt != null && !prompt.isEmpty()) {
                    System.out.print(prompt);
                }
                char choice = scanner.next().toUpperCase().charAt(0);
                if (choice == 'Y') {
                    return true;
                } else if (choice == 'N') {
                    return false;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println(ConsoleTheme.BRIGHT_RED + "\n\t\t\t\t[!] Invalid Input. Try again!" + ConsoleTheme.RESET);
                scanner.nextLine();
            }
        }
    }

    public boolean promptPlayAgain() {
        boolean playAgain = readYesNo(ConsoleTheme.BRIGHT_YELLOW + "\n\t\t\tWOULD YOU LIKE TO PLAY AGAIN? (Y / N): " + ConsoleTheme.RESET);
        if (playAgain) {
            System.out.println("\n\n\n");
        }
        return playAgain;
    }

    public void playOrExitMenu() {
        System.out.print(ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD
                + "\n          >>> Press [P] to Enter the Arena or [X] to Exit: " + ConsoleTheme.RESET);
    }

    public boolean promptPlayOrExit() {
        while (true) {
            try {
                playOrExitMenu();
                char playOrExit = scanner.next().toUpperCase().charAt(0);
                if (playOrExit == 'P') {
                    return true;
                } else if (playOrExit == 'X') {
                    return false;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException error) {
                System.out.println(ConsoleTheme.BRIGHT_RED + "\n\t\t\t[!] Invalid Input. Try again!" + ConsoleTheme.RESET);
                scanner.nextLine();
            }
        }
    }

    public void printPlayOrExitMenu() {
        if (!promptPlayOrExit()) {
            printEndCredits();
            System.exit(0);
        }
    }

    // ==================== Menus & Selection Handlers ====================

    public int gameModeChoiceInputHandler() {
        BattleHudRenderer.renderGameModeMenu();
        int choice = readIntInRange(ConsoleTheme.BRIGHT_YELLOW + "\n          >>> Enter mode choice (1, 2, 3, or 4): " + ConsoleTheme.RESET, 1, 4);
        if (choice == 4) {
            choice = random.nextInt(1, 4);
            String modeName = switch (choice) {
                case 1 -> "PLAYER VS PLAYER";
                case 2 -> "PLAYER VS COMPUTER";
                default -> "ARCADE MODE (THE GAUNTLET)";
            };
            printWithDelay(ConsoleTheme.BRIGHT_PURPLE + "          [FATE WHEEL] Random mode selected: " + modeName + "!" + ConsoleTheme.RESET, fastDelayPreset);
        }
        return choice;
    }

    public void playerCharacterChoices() {
        BattleHudRenderer.renderCharacterSelectScreen(false, false, "CHOOSE YOUR HERO FIGHTER");
    }

    public void playerCharacterChoices(boolean isPVP) {
        String header = isPVP ? "PLAYER 1: CHOOSE YOUR CHAMPION" : "CHOOSE YOUR HERO FIGHTER";
        BattleHudRenderer.renderCharacterSelectScreen(false, isPVP, header);
    }

    public void enemyCharacterChoices() {
        BattleHudRenderer.renderCharacterSelectScreen(true, false, "CHOOSE YOUR ALTERED EGO OPPONENT");
    }

    public void enemyCharacterChoices(boolean isPVP) {
        String header = isPVP ? "PLAYER 2: CHOOSE YOUR CHAMPION" : "CHOOSE YOUR ALTERED EGO OPPONENT";
        BattleHudRenderer.renderCharacterSelectScreen(true, isPVP, header);
    }

    public int playerCharacterChoiceInputHandler() {
        return playerCharacterChoiceInputHandler(false);
    }

    public int playerCharacterChoiceInputHandler(boolean isPVP) {
        if (isPVP) {
            printWithDelay(ConsoleTheme.BRIGHT_CYAN + "\n          >>> Player 1: SELECT YOUR FIGHTER <<<" + ConsoleTheme.RESET, fastDelayPreset);
        }
        playerCharacterChoices(isPVP);
        int playerChoice = readIntInRange(ConsoleTheme.BRIGHT_YELLOW + "\n          >>> Enter fighter choice (1-5, or 6 for Random): " + ConsoleTheme.RESET, 0, 6);
        if (playerChoice == 6) {
            playerChoice = random.nextInt(1, 6);
        }
        return playerChoice;
    }

    public int enemyCharacterChoiceInputHandler() {
        return enemyCharacterChoiceInputHandler(false);
    }

    public int enemyCharacterChoiceInputHandler(boolean isPVP) {
        if (isPVP) {
            printWithDelay(ConsoleTheme.BRIGHT_RED + "\n          >>> Player 2: SELECT YOUR FIGHTER <<<" + ConsoleTheme.RESET, fastDelayPreset);
        }
        enemyCharacterChoices(isPVP);
        int enemyChoice = readIntInRange(ConsoleTheme.BRIGHT_YELLOW + "\n          >>> Enter fighter choice (1-5, or 6 for Random): " + ConsoleTheme.RESET, 1, 6);
        if (enemyChoice == 6) {
            enemyChoice = random.nextInt(1, 6);
        }
        return enemyChoice;
    }

    // ==================== Skill Display & Formatting ====================

    public void showRoundHeader(int roundNumber, int turnNumber) {
        System.out.println(ConsoleTheme.BRIGHT_YELLOW + "\n  +==================== ROUND " + roundNumber
                + " - TURN " + turnNumber + " ====================+" + ConsoleTheme.RESET);
    }

    public void showRoundStatus(int matchNumber, int turnNumber, GameCharacter player, GameCharacter enemy) {
        BattleHudRenderer.renderSplitBattleHud(
                "BATTLE ARENA",
                matchNumber,
                turnNumber,
                player,
                "Player",
                enemy,
                "Opponent",
                0,
                0,
                false
        );
    }

    public void playerSkillChoices(GameCharacter character) {
        BattleHudRenderer.renderSkillDeckGrid(character);
    }

    public static void player2SkillChoice(GameCharacter character) {
        BattleHudRenderer.renderSkillDeckGrid(character);
    }

    public void enemySkillChoices(GameCharacter enemy) {
        printWithDelay(ConsoleTheme.BRIGHT_RED + "\n  >>> " + enemy.getName()
                + " is analyzing your stance and preparing a counter-attack..." + ConsoleTheme.RESET, fastDelayPreset);
    }

    private static void printSkillDisplay(GameCharacter character, int skillIndex) {
        String tabs = "\t\t\t\t";
        System.out.println(tabs + formatSkillLabel(character, skillIndex));
        System.out.println(tabs + getDamageRange(character, skillIndex));

        String cooldown = formatCooldownValue(getSkillCooldownValue(character, skillIndex));
        String mana = formatManaCost(getSkillManaCost(character, skillIndex));

        System.out.println(tabs + "CD: " + cooldown + " | Mana: " + mana);
        System.out.println();
    }

    private static String formatSkillLabel(GameCharacter character, int skillIndex) {
        return "[" + skillIndex + "] " + getSkillDisplayName(character, skillIndex);
    }

    private static String getSkillDisplayName(GameCharacter character, int skillIndex) {
        return switch (skillIndex) {
            case 0 -> "Basic Attack";
            case 1 -> "Skill One: " + character.getSkillOneName();
            case 2 -> "Skill Two: " + character.getSkillTwoName();
            case 3 -> "Skill Three: " + character.getSkillThreeName();
            default -> "Unknown Skill";
        };
    }

    private static String getRawSkillName(GameCharacter character, int skillIndex) {
        return switch (skillIndex) {
            case 0 -> "Basic Attack";
            case 1 -> character.getSkillOneName();
            case 2 -> character.getSkillTwoName();
            case 3 -> character.getSkillThreeName();
            default -> "Attack";
        };
    }

    private static int getSkillCooldownValue(GameCharacter character, int skillIndex) {
        return switch (skillIndex) {
            case 1 -> character.getSkillOneCooldown();
            case 2 -> character.getSkillTwoCooldown();
            case 3 -> character.getSkillThreeCooldown();
            default -> 0;
        };
    }

    private static int getSkillManaCost(GameCharacter character, int skillIndex) {
        return switch (skillIndex) {
            case 1 -> character.getSkillOneManaUsage();
            case 2 -> character.getSkillTwoManaUsage();
            case 3 -> character.getSkillThreeManaUsage();
            default -> 0;
        };
    }

    private static String formatCooldownValue(int cooldown) {
        if (cooldown <= 0) {
            return "READY";
        }
        return cooldown == 1 ? "1 Turn" : cooldown + " Turns";
    }

    private static String formatManaCost(int manaCost) {
        return manaCost <= 0 ? "-" : String.valueOf(manaCost);
    }

    private static String getDamageRange(GameCharacter character, int skillIndex) {
        return character.getDamageRange(skillIndex);
    }

    // ==================== Narrative & Dialogue Delegation ====================

    public void printOrSkipNarrativeSegment(GameCharacter player, GameCharacter enemy) {
        boolean isCounterpart = DialogueManager.isDirectCounterpart(player, enemy);
        BattleHudRenderer.renderVsSplashScreen(player, enemy, isCounterpart);

        boolean skip = readYesNo(ConsoleTheme.BRIGHT_YELLOW + "\n          >>> Skip narrative segment? (Y / N): " + ConsoleTheme.RESET);
        if (!skip) {
            if (isCounterpart) {
                System.out.println();
                printWithDelay(ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD
                        + "          [!] SPECIAL COUNTERPART ENCOUNTER [!]" + ConsoleTheme.RESET, fastDelayPreset);
            }
            DialogueManager.printIntroMonologue(player, fastDelayPreset);
            DialogueManager.printIntroMonologue(enemy, fastDelayPreset);
            DialogueManager.printCounterpartDialogue(player, enemy, fastDelayPreset);
        }
    }

    public void specialEncounterMonologue(GameCharacter character) {
        DialogueManager.printIntroMonologue(character, fastDelayPreset);
    }

    public void specialEncounterCounterPart(GameCharacter player, GameCharacter enemy) {
        System.out.println();
        printWithDelay("\t\t\t\tSPECIAL ENCOUNTER.....\n", fastDelayPreset);
        if (!readYesNo("\n\t\t\tSkip Narrative Segment? (Y / N): ")) {
            DialogueManager.printCounterpartDialogue(player, enemy, fastDelayPreset);
        }
    }

    public void playerSkillUseMonologue(GameCharacter character, int skillChoice) {
        DialogueManager.printSkillUseMonologue(character, skillChoice, fastDelayPreset);
    }

    public void enemySkillUseMonologue(GameCharacter character, int skillChoice) {
        DialogueManager.printSkillUseMonologue(character, skillChoice, fastDelayPreset);
    }

    // ==================== Unified Turn & Match Execution ====================

    private void executeHumanTurn(GameCharacter attacker, GameCharacter defender, String label) {
        String atkColor = ConsoleTheme.getCharacterColor(attacker.getName());
        System.out.println(ConsoleTheme.BRIGHT_CYAN + "\n  >>> [" + label + "'s Turn] "
                + atkColor + ConsoleTheme.BOLD + attacker.getName() + ConsoleTheme.RESET
                + ConsoleTheme.GRAY + " (HP: " + attacker.getHitpoints() + "/" + attacker.getMaxHitpoints()
                + " | MP: " + attacker.getMana() + "/" + attacker.getMaxMana() + ")" + ConsoleTheme.RESET);

        while (true) {
            playerSkillChoices(attacker);
            int skillChoice = readIntInRange(ConsoleTheme.BRIGHT_YELLOW
                    + "\n          >>> Select skill [0] Basic, [1] Skill 1, [2] Skill 2, [3] Ultimate: " + ConsoleTheme.RESET, 0, 3);

            int cooldown = getSkillCooldownValue(attacker, skillChoice);
            if (cooldown > 0) {
                String skillName = getRawSkillName(attacker, skillChoice);
                printWithDelay(ConsoleTheme.BRIGHT_RED + "\n          [!] " + skillName
                        + " is on cooldown (" + cooldown + "T left)! Choose again." + ConsoleTheme.RESET, fastDelayPreset);
                continue;
            }

            boolean enoughMana = switch (skillChoice) {
                case 0 -> true;
                case 1 -> attacker.isSkillOneUsable();
                case 2 -> attacker.isSkillTwoUsable();
                case 3 -> attacker.isSkillThreeUsable();
                default -> false;
            };
            if (!enoughMana) {
                String skillName = getRawSkillName(attacker, skillChoice);
                printWithDelay(ConsoleTheme.BRIGHT_RED + "\n          [!] Not enough mana to use "
                        + skillName + "! Choose again." + ConsoleTheme.RESET, fastDelayPreset);
                continue;
            }

            String skillName = getRawSkillName(attacker, skillChoice);
            DialogueManager.printSkillUseMonologue(attacker, skillChoice, fastDelayPreset);
            int damage = attacker.useSkill(skillChoice);
            defender.takeDamage(damage);
            AsciiArtAssets.printAttackAnimation(attacker, defender, skillChoice, skillName, damage, 5);
            break;
        }
    }

    private void executeComputerTurn(Enemy ai, GameCharacter defender, String label, boolean showSkillMenu) {
        String aiColor = ConsoleTheme.getCharacterColor(ai.getName());
        System.out.println(ConsoleTheme.BRIGHT_RED + "\n  >>> [" + label + "'s Turn] "
                + aiColor + ConsoleTheme.BOLD + ai.getName() + ConsoleTheme.RESET
                + ConsoleTheme.GRAY + " (HP: " + ai.getHitpoints() + "/" + ai.getMaxHitpoints()
                + " | MP: " + ai.getMana() + "/" + ai.getMaxMana() + ")" + ConsoleTheme.RESET);

        if (showSkillMenu) {
            enemySkillChoices(ai);
        }

        int skillChoice = ai.chooseSmartSkill(random);
        String skillName = getRawSkillName(ai, skillChoice);
        DialogueManager.printSkillUseMonologue(ai, skillChoice, fastDelayPreset);
        int damage = ai.useSkill(skillChoice);
        defender.takeDamage(damage);
        AsciiArtAssets.printAttackAnimation(ai, defender, skillChoice, skillName, damage, 5);
    }

    private void regenerateTurnMana(GameCharacter character, int amount) {
        character.increaseMana(amount);
        printWithDelay(ConsoleTheme.BRIGHT_CYAN + "  [+] " + character.getName() + " regenerates +" + amount + " MP. (MP: "
                + character.getMana() + "/" + character.getMaxMana() + ")" + ConsoleTheme.RESET, fastDelayPreset);
    }

    private void printFinalResults(GameCharacter fighter1, GameCharacter fighter2, int fighter1Wins, int fighter2Wins) {
        boolean player1Won = fighter1Wins >= fighter2Wins;
        BattleHudRenderer.renderMatchResultScreen(fighter1, fighter2, fighter1Wins, fighter2Wins, player1Won);
        printWithDelay(ConsoleTheme.BRIGHT_CYAN + "\n          Game Over! Thanks for playing Altered Ego!\n" + ConsoleTheme.RESET, fastDelayPreset);
    }

    private void runBestOfThreeMatch(Player player, Enemy enemy, boolean isPVP) {
        int round = 1;
        int player1Wins = 0;
        int player2Wins = 0;
        String player1Label = isPVP ? "Player 1" : "Player";
        String player2Label = isPVP ? "Player 2" : "Computer";
        String modeLabel = isPVP ? "PVP DUEL (BO3)" : "PVE DUEL (BO3)";

        while (round <= 3 && player1Wins < 2 && player2Wins < 2) {
            int turn = 1;
            boolean player1First = (round % 2 != 0);
            printWithDelay(ConsoleTheme.BRIGHT_YELLOW + "\n  +-------------------- ROUND " + round + " STARTS --------------------+" + ConsoleTheme.RESET, fastDelayPreset);

            while (player.getHitpoints() > 0 && enemy.getHitpoints() > 0) {
                BattleHudRenderer.renderSplitBattleHud(
                        modeLabel,
                        round,
                        turn,
                        player,
                        player1Label,
                        enemy,
                        player2Label,
                        player1Wins,
                        player2Wins,
                        true
                );

                if (player1First) {
                    executeHumanTurn(player, enemy, player1Label);
                    if (enemy.getHitpoints() <= 0) {
                        printWithDelay(ConsoleTheme.BRIGHT_GREEN + "\n  [*] " + enemy.getName() + " has been defeated!" + ConsoleTheme.RESET, fastDelayPreset);
                        break;
                    }
                    regenerateTurnMana(player, random.nextInt(25, 51));

                    if (isPVP) {
                        BattleHudRenderer.renderSplitBattleHud(
                                modeLabel,
                                round,
                                turn,
                                player,
                                player1Label,
                                enemy,
                                player2Label,
                                player1Wins,
                                player2Wins,
                                true
                        );
                        executeHumanTurn(enemy, player, player2Label);
                    } else {
                        executeComputerTurn(enemy, player, player2Label, true);
                    }
                    if (player.getHitpoints() <= 0) {
                        printWithDelay(ConsoleTheme.BRIGHT_RED + "\n  [!] " + player.getName() + " has been defeated!" + ConsoleTheme.RESET, fastDelayPreset);
                        break;
                    }
                    regenerateTurnMana(enemy, random.nextInt(25, 51));
                } else {
                    if (isPVP) {
                        executeHumanTurn(enemy, player, player2Label);
                    } else {
                        executeComputerTurn(enemy, player, player2Label, true);
                    }
                    if (player.getHitpoints() <= 0) {
                        printWithDelay(ConsoleTheme.BRIGHT_RED + "\n  [!] " + player.getName() + " has been defeated!" + ConsoleTheme.RESET, fastDelayPreset);
                        break;
                    }
                    regenerateTurnMana(enemy, random.nextInt(25, 51));

                    BattleHudRenderer.renderSplitBattleHud(
                            modeLabel,
                            round,
                            turn,
                            player,
                            player1Label,
                            enemy,
                            player2Label,
                            player1Wins,
                            player2Wins,
                            true
                    );
                    executeHumanTurn(player, enemy, player1Label);
                    if (enemy.getHitpoints() <= 0) {
                        printWithDelay(ConsoleTheme.BRIGHT_GREEN + "\n  [*] " + enemy.getName() + " has been defeated!" + ConsoleTheme.RESET, fastDelayPreset);
                        break;
                    }
                    regenerateTurnMana(player, random.nextInt(25, 51));
                }

                player.reduceAllCooldowns();
                enemy.reduceAllCooldowns();
                turn++;
            }

            if (player.getHitpoints() > 0) {
                player1Wins++;
                printWithDelay(ConsoleTheme.BRIGHT_GREEN + ConsoleTheme.BOLD + "\n  >>> " + player.getName() + " wins Round " + round + "! <<<\n" + ConsoleTheme.RESET, fastDelayPreset);
            } else {
                player2Wins++;
                printWithDelay(ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD + "\n  >>> " + enemy.getName() + " wins Round " + round + "! <<<\n" + ConsoleTheme.RESET, fastDelayPreset);
            }

            printWithDelay(ConsoleTheme.GRAY + "  +-------------------- END OF ROUND " + round + " --------------------+\n" + ConsoleTheme.RESET, fastDelayPreset);

            if (round >= 3 || player1Wins >= 2 || player2Wins >= 2) {
                break;
            }

            boolean proceed = readYesNo(ConsoleTheme.BRIGHT_YELLOW + "          >>> Proceed to the next round? (Y / N): " + ConsoleTheme.RESET);
            if (proceed) {
                player.resetStats();
                player.resetCoolDown();
                enemy.resetStats();
                enemy.resetCoolDown();
                round++;
            } else {
                break;
            }
        }

        printFinalResults(player, enemy, player1Wins, player2Wins);
    }

    // ==================== Game Modes ====================

    public void pvpBattleGameMode() {
        int bannerLen = 58;
        System.out.println();
        printCenter(" [MODE] PLAYER VS PLAYER ", bannerLen, '-', fastDelayPreset);
        printCenter(" [SYSTEM] TWO PEOPLE ENTERS, ONE GOES OUT ", bannerLen, '-', fastDelayPreset);

        int playerChoice = playerCharacterChoiceInputHandler(true);
        Player player = Player.createByChoice(playerChoice);

        int enemyChoice = enemyCharacterChoiceInputHandler(true);
        Enemy enemy = Enemy.createByChoice(enemyChoice);

        printOrSkipNarrativeSegment(player, enemy);
        runBestOfThreeMatch(player, enemy, true);
    }

    public void playerVsComputerBattleGameMode() {
        System.out.println();
        printCenter(" [MODE] PLAYER VS COMPUTER ", len, '-', fastDelayPreset);
        printCenter(" [SYSTEM] YOU WILL ENCOUNTER AN UNPREDICTABLE OPPONENT ", len, '-', fastDelayPreset);

        int playerChoice = playerCharacterChoiceInputHandler(false);
        Player player = Player.createByChoice(playerChoice);

        int enemyChoice = enemyCharacterChoiceInputHandler(false);
        Enemy enemy = Enemy.createByChoice(enemyChoice);

        printOrSkipNarrativeSegment(player, enemy);
        runBestOfThreeMatch(player, enemy, false);
    }

    public void arcadeBattleGameMode() {
        System.out.println();
        printCenter(" [MODE] ARCADE MODE ", len, '-', fastDelayPreset);
        printCenter(" [SYSTEM] ONE VS ALL, NO GOING OUT.... ", len, '-', fastDelayPreset);
        System.out.println();

        int playerChoice = playerCharacterChoiceInputHandler(false);
        Player player = Player.createByChoice(playerChoice);
        ArrayList<Enemy> enemies = Enemy.createArcadeRoster();

        int matchCount = 0;
        int wins = 0;

        while (player.getHitpoints() > 0 && !enemies.isEmpty()) {
            Enemy enemy = enemies.get(random.nextInt(enemies.size()));
            int matchNumber = matchCount + 1;

            BattleHudRenderer.renderArcadeTower(matchNumber, wins, enemies, enemy);
            System.out.println(ConsoleTheme.BRIGHT_YELLOW + "\n          >>> STAGE " + matchNumber
                    + " CHALLENGER: " + ConsoleTheme.BOLD + enemy.getName() + ConsoleTheme.RESET);

            printOrSkipNarrativeSegment(player, enemy);

            int turnCounter = 1;
            while (player.getHitpoints() > 0 && enemy.getHitpoints() > 0) {
                BattleHudRenderer.renderSplitBattleHud(
                        "ARCADE STAGE " + matchNumber + "/5",
                        matchNumber,
                        turnCounter,
                        player,
                        "Hero",
                        enemy,
                        "Stage " + matchNumber,
                        wins,
                        0,
                        false
                );

                executeHumanTurn(player, enemy, "Player 1");

                if (enemy.getHitpoints() <= 0) {
                    printWithDelay(ConsoleTheme.BRIGHT_GREEN + ConsoleTheme.BOLD
                            + "\n  [*] STAGE " + matchNumber + " CLEARED! " + enemy.getName() + " has been defeated!" + ConsoleTheme.RESET, fastDelayPreset);
                    wins++;

                    int healAmount = 50 * random.nextInt(1, 11);
                    int manaAmount = 20 * random.nextInt(1, 11);

                    player.heal(healAmount);
                    player.increaseMana(manaAmount);
                    player.resetCoolDown();
                    printWithDelay(ConsoleTheme.BRIGHT_GREEN + "  [+] " + player.getName() + " recovers +" + healAmount + " HP after the victory!" + ConsoleTheme.RESET, fastDelayPreset);
                    printWithDelay(ConsoleTheme.BRIGHT_CYAN + "  [+] " + player.getName() + " recovers +" + manaAmount + " MP after the victory!" + ConsoleTheme.RESET, fastDelayPreset);
                    System.out.println(ConsoleTheme.BRIGHT_YELLOW + "\n  >>> Arcade Tower Progress: " + wins + " / 5 Wins <<<" + ConsoleTheme.RESET);
                    enemy.setDefeated(true);
                    enemies.remove(enemy);

                    if (wins == 5) {
                        Enemy ohmaZio = Enemy.createFinalBoss();
                        player.resetCoolDown();

                        String text = """
                                
                                
                                Initiating ending game sequence
                                ......................
                                fail fail fail fail fail fail error 404
                                
                                The atmosphere has shifted...
                                Time has stopped...
                                A giant rift appeared!!!
                                
                                Blessing of Time!
                                Highest!
                                Best!
                                Strongest King!

                                """;
                        printWithDelay(ConsoleTheme.BRIGHT_RED + text + ConsoleTheme.RESET, fastDelayPreset);
                        BattleHudRenderer.renderArcadeTower(6, wins, enemies, ohmaZio);
                        printFinalBoss();
                        fightFinalBoss(player, ohmaZio, scanner, random);
                        return;
                    }
                    break;
                }

                regenerateTurnMana(player, random.nextInt(25, 51));

                executeComputerTurn(enemy, player, "Enemy", false);

                if (player.getHitpoints() <= 0) {
                    printWithDelay(ConsoleTheme.BRIGHT_RED + "\n\t\t\t" + player.getName() + " has been defeated!" + ConsoleTheme.RESET, fastDelayPreset);
                    break;
                }

                regenerateTurnMana(enemy, random.nextInt(10, 21));

                player.reduceAllCooldowns();
                enemy.reduceAllCooldowns();

                turnCounter++;
            }

            if (enemy.getHitpoints() <= 0) {
                matchCount++;
            }

            if (player.getHitpoints() <= 0) {
                System.out.println(AsciiArtAssets.getDefeatSkullArt());
                printWithDelay(ConsoleTheme.BRIGHT_RED + "\n\t\t\tGame Over. Better luck next time!\n" + ConsoleTheme.RESET, fastDelayPreset);
                break;
            }
        }

        if (player.getHitpoints() > 0 && enemies.isEmpty()) {
            System.out.println(AsciiArtAssets.getVictoryTrophyArt());
            printWithDelay(ConsoleTheme.BRIGHT_YELLOW + "\n\t\t\tAll enemies have been defeated! You are the champion!\n" + ConsoleTheme.RESET, fastDelayPreset);
        }
    }

    public void fightFinalBoss(Player player, Enemy boss, Scanner scanner, Random random) {
        printWithDelay(ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + "\n          >>> THE FINAL BATTLE BEGINS: TIME RIFT SINGULARITY <<<" + ConsoleTheme.RESET, fastDelayPreset);
        BattleHudRenderer.renderVsSplashScreen(player, boss, false);
        DialogueManager.printIntroMonologue(boss, fastDelayPreset);

        int turn = 1;
        while (player.getHitpoints() > 0 && boss.getHitpoints() > 0) {
            BattleHudRenderer.renderSplitBattleHud(
                    "FINAL BOSS: STAGE 6",
                    6,
                    turn,
                    player,
                    "Challenger",
                    boss,
                    "Demon King",
                    5,
                    0,
                    false
            );

            executeHumanTurn(player, boss, "Player");

            if (boss.getHitpoints() <= 0) {
                printWithDelay(ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD
                        + "\n  [*] " + boss.getName() + " has been vanquished!" + ConsoleTheme.RESET, fastDelayPreset);
                break;
            }

            regenerateTurnMana(player, random.nextInt(25, 51));

            executeComputerTurn(boss, player, "Final Boss", false);

            if (player.getHitpoints() <= 0) {
                printWithDelay(ConsoleTheme.BRIGHT_RED + "\n  [!] You were defeated by " + boss.getName() + "..." + ConsoleTheme.RESET, fastDelayPreset);
                break;
            }

            regenerateTurnMana(boss, random.nextInt(20, 41));

            player.reduceAllCooldowns();
            boss.reduceAllCooldowns();
            turn++;
        }

        if (player.getHitpoints() > 0 && boss.getHitpoints() <= 0) {
            BattleHudRenderer.renderMatchResultScreen(player, boss, 6, 0, true);
            printWithDelay(ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD
                    + "\n          >>> YOU BEAT THE FINAL BOSS! TRUE ENDING UNLOCKED! <<<\n" + ConsoleTheme.RESET, fastDelayPreset);
        } else {
            BattleHudRenderer.renderMatchResultScreen(player, boss, 5, 1, false);
        }
    }

    public void printFinalBoss() {
        System.out.println();
        printWithDelay(AsciiArtAssets.getFinalBossBanner(), 2);
    }
}
