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

    // prints every character with delay
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
        int rightPadding = totalPadding - leftPadding; // ensures total = length

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
        int rightPadding = totalPadding - leftPadding; // ensures exact total length

        String line = String.valueOf(fillChar).repeat(leftPadding)
                + text
                + String.valueOf(fillChar).repeat(rightPadding);

        System.out.println(line);
    }

    public static void printCenter(String text, int length, char fillChar, int delay) {
        if (text == null) text = "";

        // If text is longer than desired width, trim it
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

        // Ensure text has exact total length
        if (text.length() < length) {
            text += String.valueOf(fillChar).repeat(length - text.length());
        } else if (text.length() > length) {
            text = text.substring(0, length);
        }

        // Print one character at a time with delay
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // move to next line
    }

    public void gameTitle() {
        String purple = "\u001B[35m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        String title = """
                
                
                             █████╗ ██╗  ████████╗███████╗██████╗ ███████╗██████╗
                            ██╔══██╗██║  ╚══██╔══╝██╔════╝██╔══██╗██╔════╝██╔══██╗
                            ███████║██║     ██║   █████╗  ██████╔╝█████╗  ██║  ██║
                            ██╔══██║██║     ██║   ██╔══╝  ██╔══██╗██╔══╝  ██║  ██║
                            ██║  ██║███████╗██║   ███████╗██║  ██║███████╗██████╔╝
                            ╚═╝  ╚═╝╚══════╝╚═╝   ╚══════╝╚═╝  ╚═╝╚══════╝╚═════╝
                
                            ███████╗ ██████╗  ██████╗                            
                            ██╔════╝██╔════╝ ██╔═══██╗                           
                            █████╗  ██║  ███╗██║   ██║                           
                            ██╔══╝  ██║   ██║██║   ██║                           
                            ███████╗╚██████╔╝╚██████╔╝                           
                            ╚══════╝ ╚═════╝  ╚═════╝            
                
                            BY: SHELL SYNDICATE SOFTWARE CO. LTD
                """;
        System.out.println(purple + title + reset);
    }

    public void printEndCredits() {
        String purple = "\u001B[35m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        String text = """
                
                            ████████╗██╗  ██╗███████╗
                            ╚══██╔══╝██║  ██║██╔════╝
                               ██║   ███████║█████╗  
                               ██║   ██╔══██║██╔══╝  
                               ██║   ██║  ██║███████╗
                               ╚═╝   ╚═╝  ╚═╝╚══════╝
                
                            ███████╗███╗   ██╗██████╗
                            ██╔════╝████╗  ██║██╔══██╗
                            █████╗  ██╔██╗ ██║██║  ██║
                            ██╔══╝  ██║╚██╗██║██║  ██║
                            ███████╗██║ ╚████║██████╔╝
                            ╚══════╝╚═╝  ╚═══╝╚═════╝
                
                """;
        printWithDelay(purple + text + reset, 5);
    }

    public void loadingScreen() {
        printWithDelay("\n\t\t\t\t\tLOADING GAME CONTENT......", fastDelayPreset);
        System.out.println("1%                                                        100%");
        printWithDelay("[||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||]", 30);
    }

    public void playOrExitMenu() {
        System.out.print("\n\t\t\tPress 'P' to Play or 'X' to Exit: ");
    }

    public void printPlayOrExitMenu() {
        while (true) {
            try {
                playOrExitMenu();
                char playOrExit = scanner.next().toUpperCase().charAt(0);
                if (playOrExit == 'X') {
                    System.exit(1);
                } else if (playOrExit == 'P') {
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException error) {
                System.out.println("\n\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        }
    }

    public int gameModeChoiceInputHandler() {
        int choice = -1;
        String tabs = "\t\t\t";
        while (true) {
            String text = """
                    
                    ------------------ CHOOSE GAME MODE ------------------
                    
                                   [1] Player vs Player
                                   [2] Player vs Computer
                                   [3] Arcade Mode
                                   [4] Random
                    """;
            System.out.println(text);
            System.out.print(tabs + "Enter choice (1, 2, 3, or 4): ");
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 4)
                    throw new InputMismatchException();
                if (choice == 4)
                    choice = random.nextInt(1, 4);
                break;
            } catch (InputMismatchException e) {
                System.out.println("\n\t\t\t\tInvalid Input, Try Again!");
                scanner.nextLine();
            }
        }
        return choice;
    }


    public void playerSkillChoices(Player player) {
        System.out.println();
        System.out.println("----------------- CHOOSE SKILL TO USE ------------------\n");
        for (int i = 0; i <= 3; i++) {
            printSkillDisplay(player, i);
        }
        System.out.print("\t\t\tEnter choice (0, 1, 2, or 3): ");
    }

    public void playerCharacterChoices() {
        String tabs = "\t\t\t";
        String text = """
                     
                    ----------------- CHOOSE YOUR CHARACTER ----------------
                     
                                    [1] Cosmic Dassel
                                    [2] Khylle The Reaper
                                    [3] Earl
                                    [4] The One John
                                    [5] And Rew
                                    [5] And Rew
                                    [6] Random
                    """;
        System.out.println(text);
        System.out.print(tabs + "Enter choice (1, 2, 3, 4, 5 or 6): ");
    }

    public void playerCharacterChoices(boolean isPVP) {
        String tabs = "\t\t\t";
        if (isPVP) {
            String text = """
                    
                    ----------------- CHOOSE YOUR CHAMPION ----------------
                    
                                    [1] Cosmic Dassel
                                    [2] Khylle The Reaper
                                    [3] Earl
                                    [4] The One John
                                    [5] And Rew
                                    [6] Random
                    """;
            System.out.println(text);
            System.out.print(tabs + "Enter choice (1, 2, 3, 4, 5 or 6): ");
        }
    }


    public void enemyCharacterChoices() {
        String tabs = "\t\t\t";
        String text = """
                    
                    ----------------- CHOOSE YOUR ENEMY ----------------
                    
                                    [1] Kaniel Outis
                                    [2] Van Berksville
                                    [3] Asta Clover
                                    [4] JF Void
                                    [5] Deidre
                                    [6] Random
                    """;
        System.out.println(text);
        System.out.print(tabs + "Enter (1, 2, 3, 4, 5, or 6): ");
    }

    public void enemyCharacterChoices(boolean isPVP) {
        String tabs = "\t\t\t";
        if (isPVP) {
            String text = """
                    
                    ----------------- CHOOSE YOUR CHAMPION ----------------
                    
                                    [1] Kaniel Outis
                                    [2] Van Berksville
                                    [3] Asta Clover
                                    [4] JF Void
                                    [5] Deidre
                                    [6] Random
                    """;
            System.out.println(text);
            System.out.print(tabs + "Enter choice (1, 2, 3, 4, 5 or 6): ");
        }
    }

    public void showRoundHeader(int roundNumber, int turnNumber) {
        System.out.println("\n\n==================== Round " + roundNumber + " - Turn " + turnNumber + " ====================");
    }

    private static void printSkillDisplay(Player character, int skillIndex) {
        String tabs = "\t\t\t\t";
        System.out.println(tabs + formatSkillLabel(character, skillIndex));
        System.out.println(tabs + getDamageRange(character, skillIndex));

        String cooldown = formatCooldownValue(getSkillCooldownValue(character, skillIndex));
        String mana = formatManaCost(getSkillManaCost(character, skillIndex));

        System.out.println(tabs + "CD: " + cooldown + " | Mana: " + mana);
        System.out.println();
    }

    private static String formatSkillLabel(Player character, int skillIndex) {
        return "[" + skillIndex + "] " + getSkillDisplayName(character, skillIndex);
    }

    private static String getSkillDisplayName(Player character, int skillIndex) {
        return switch (skillIndex) {
            case 0 -> "Basic Attack";
            case 1 -> "Skill One: " + character.getSkillOneName();
            case 2 -> "Skill Two: " + character.getSkillTwoName();
            case 3 -> "Skill Three: " + character.getSkillThreeName();
            default -> "Unknown Skill";
        };
    }

    private static int getSkillCooldownValue(Player character, int skillIndex) {
        return switch (skillIndex) {
            case 1 -> character.getSkillOneCooldown();
            case 2 -> character.getSkillTwoCooldown();
            case 3 -> character.getSkillThreeCooldown();
            default -> 0;
        };
    }

    private static int getSkillManaCost(Player character, int skillIndex) {
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

    private static String getDamageRange(Player character, int skillIndex) {
        boolean isOP = "OP Character".equals(character.getName());
        return switch (skillIndex) {
            case 0 -> isOP ? "(Min: 50 | Max: 50)" : "(Min: 40 | Max: 50)";
            case 1 -> isOP ? "(Min: 100 | Max: 100)" : "(Min: 50 | Max: 60)";
            case 2 -> isOP ? "(Min: 150 | Max: 150)" : "(Min: 60 | Max: 70)";
            case 3 -> isOP ? "(Min: 500 | Max: 500)" : "(Min: 100 | Max: 150)";
            default -> "(Min: ? | Max: ?)";
        };
    }

    public void showRoundStatus(int matchNumber, int turnNumber, Player player, Enemy enemy) {
        showRoundHeader(matchNumber, turnNumber);
    }

    // wrap up function for player character choice integer input
    public int playerCharacterChoiceInputHandler() {
        int playerChoice = 0;
        while (true) {
            try {
                playerCharacterChoices();
                playerChoice = scanner.nextInt();
                if (playerChoice < 1 || playerChoice > 6) {
                    throw new InputMismatchException();
                } else if (playerChoice == 6) {
                    // random values from 1 to 5, 6 is an out of bounds value
                    playerChoice = random.nextInt(1, 6);
                }
                break;
            } catch (InputMismatchException error) {
                System.out.println("\n\t\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        }
        return playerChoice;
    }

    public int playerCharacterChoiceInputHandler(boolean isPVP) {
        int playerChoice = 0;
        while (true) {
            try {
                if (isPVP) {
                    printWithDelay("\n\t\t\tPlayer 1: CHOOSE YOUR CHARACTER......", fastDelayPreset);
                }
                playerCharacterChoices(isPVP);
                playerChoice = scanner.nextInt();
                if (playerChoice < 1 || playerChoice > 6) {
                    throw new InputMismatchException();
                } else if (playerChoice == 6) {
                    playerChoice = random.nextInt(1, 6);
                }
                break;
            } catch (InputMismatchException error) {
                System.out.println("\n\t\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        }
        return playerChoice;
    }

    // wrap up function for enemy character choice integer input
    public int enemyCharacterChoiceInputHandler() {
        int enemyChoice = 0;
        while (true) {
            try {
                enemyCharacterChoices();
                enemyChoice = scanner.nextInt();
                if (enemyChoice < 1 || enemyChoice > 6) {
                    throw new InputMismatchException();
                } else if(enemyChoice == 6) {
                    enemyChoice = random.nextInt(1, 6);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\n\t\t\tInvalid Input, Try Again!");
                scanner.nextLine();
            }
        }
        return enemyChoice;
    }

    public int enemyCharacterChoiceInputHandler(boolean isPVP) {
        int enemyChoice = 0;
        while (true) {
            try {
                if (isPVP) {
                    printWithDelay("\n\t\t\tPlayer 2: CHOOSE YOUR CHARACTER........", fastDelayPreset);
                }
                enemyCharacterChoices(isPVP);
                enemyChoice = scanner.nextInt();
                if (enemyChoice < 1 || enemyChoice > 6) {
                    throw new InputMismatchException();
                } else if (enemyChoice == 6) {
                    enemyChoice = random.nextInt(1, 6);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("\n\t\t\t\tInvalid Input, Try Again!");
                scanner.nextLine();
            }
        }
        return enemyChoice;
    }

    // display monologue for player or skip the whole monologue
    public void printOrSkipNarrativeSegment(Player player, Enemy enemy) {
        // '0' is a placeholder to avoid null pointer exception
        char skipSegmentChoice = '0';
        do {
            try {
                System.out.print("\n\t\t\tSkip narrative segment (Y / N): ");
                skipSegmentChoice = scanner.next().toUpperCase().charAt(0);
                if (skipSegmentChoice == 'N') {
                    specialEncounterMonologue(player);
                    specialEncounterMonologue(enemy);
                    break;
                } else if (skipSegmentChoice != 'Y') {
                    System.out.println("\n\t\t\t\tInvalid Input. Try again!");
                } else {
                    break;
                }
            } catch (InputMismatchException error) {
                System.out.println("\n\t\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        } while (skipSegmentChoice != 'Y');
    }


    public void enemySkillChoices(Enemy enemy) {
        System.out.println();
        System.out.println("------------- " + enemy.getName() + "'s Skills: ------------\n");
        for (int i = 0; i <= 3; i++) {
            printSkillDisplay(enemy, i);
        }
        printWithDelay(enemy.getName() + " is preparing for a counter attack..........", fastDelayPreset);
    }

    public void specialEncounterMonologue(Player player) {
        System.out.println();
        switch (player.getName()) {
            case "Cosmic Dassel" -> printWithDelay("Cosmic Dassel: You're funny, I'll buy you!", fastDelayPreset);
            case "Khylle The Reaper" ->
                    printWithDelay("Khylle The Reaper: I came to reap... but I was hungry", fastDelayPreset);
            case "Earl" -> printWithDelay("Earl: You chose me? Good boy", fastDelayPreset);
            case "The One John" -> printWithDelay("The One John: Help? Help yourself", fastDelayPreset);
            case "And Rew" -> printWithDelay("And Rew: Oh hell nah why me", fastDelayPreset);
        }
    }

    public void specialEncounterMonologue(Enemy enemy) {
        System.out.println();
        switch (enemy.getName()) {
            case "Kaniel Outis" ->
                    printWithDelay("Kaniel Outis: Who are you to decided to battle me?", fastDelayPreset);

            case "Van Berskville" -> printWithDelay("Van Berskville: I'll take my revenge!", fastDelayPreset);

            case "Asta Clover" -> printWithDelay("Asta Clover: I'll become the wizard king!", fastDelayPreset);

            case "JF Void" -> printWithDelay("JF Void: All path ends to nothing", fastDelayPreset);

            case "Deidre" -> printWithDelay("Deidre: I am the storm that is approaching", fastDelayPreset);

        }
    }

    public void specialEncounterCounterPart(Player player, Enemy enemy) {
        System.out.println();
        printWithDelay("\t\t\t\tSPECIAL ENCOUNTER.....\n", fastDelayPreset);

        char choice = '0';
        while (true) {
            try {
                System.out.print("\n\t\t\tSkip Narrative Segment? (Y / N): ");
                choice = scanner.next().toUpperCase().charAt(0);
                if (choice == 'Y' || choice == 'N') {
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("\n\t\t\t\tInvalid Input, Try Again!");
                scanner.nextLine();
            }
        }

        if (choice == 'N') {
            switch (player.getName()) {
                case "Cosmic Dassel" -> {
                    switch (enemy.getName()) {
                        case "Kaniel Outis" -> {
                            printWithDelay("\nCosmic Dassel: You're not even worth buying", fastDelayPreset);
                            printWithDelay("\nKaniel Outis: You dare put a price on me? I'll make you regret it", fastDelayPreset);
                        }
                        case "Van Berskville" -> {
                            printWithDelay("\nCosmic Dassel: I could use a mercenary — I'll buy you", fastDelayPreset);
                            printWithDelay("\nVan Berskville: I'll accept your limbs as down payment", fastDelayPreset);
                        }
                        case "Asta Clover" -> {
                            printWithDelay("\nCosmic Dassel: I'll buy you, cash or check?", fastDelayPreset);
                            printWithDelay("\nAsta Clover: You'll be paying by your head", fastDelayPreset);
                        }
                        case "JF Void" -> {
                            printWithDelay("\nCosmic Dassel: I wouldn't even bother buying you for a discount", fastDelayPreset);
                            printWithDelay("\nJF Void: Save your money for your funeral", fastDelayPreset);
                        }
                        case "Deidre" -> {
                            printWithDelay("\nCosmic Dassel: Time is money and you're wasting mine", fastDelayPreset);
                            printWithDelay("\nDeidre: I'll end your time", fastDelayPreset);
                        }
                    }
                }

                case "Khylle The Reaper" -> {
                    switch (enemy.getName()) {
                        case "Kaniel Outis" -> {
                            printWithDelay("\nKhylle The Reaper: I will reap your soul", fastDelayPreset);
                            printWithDelay("\nKaniel Outis: You will need more than that to scare me", fastDelayPreset);
                        }
                        case "Van Berskville" -> {
                            printWithDelay("\nKhylle The Reaper: Your thirst for revenge will satisfy me", fastDelayPreset);
                            printWithDelay("\nVan Berskville: Stand between me and my revenge and I'll send you to your maker!", fastDelayPreset);
                        }
                        case "Asta Clover" -> {
                            printWithDelay("\nKhylle The Reaper: You'll end your journey here", fastDelayPreset);
                            printWithDelay("\nAsta Clover: My journey just begun", fastDelayPreset);
                        }
                        case "JF Void" -> {
                            printWithDelay("\nKhylle The Reaper: You smell of fear... I'm getting hungry", fastDelayPreset);
                            printWithDelay("JF Void: Fear you? I'll shred you into nothing", fastDelayPreset);
                        }
                        case "Deidre" -> {
                            printWithDelay("\nKhylle The Reaper: I will kill you", fastDelayPreset);
                            printWithDelay("\nDeidre: You can't kill what's already dead", fastDelayPreset);
                        }
                    }
                }

                case "Earl" -> {
                    switch (enemy.getName()) {
                        case "Kaniel Outis" -> {
                            printWithDelay("\nEarl: It doesn't have to be this way", fastDelayPreset);
                            printWithDelay("\nKaniel Outis: Knave, kneel before me", fastDelayPreset);
                        }
                        case "Van Berskville" -> {
                            printWithDelay("\nEarl: You got a scary face right there", fastDelayPreset);
                            printWithDelay("\nVan Berskville: Your death will assist me in my revenge", fastDelayPreset);
                        }
                        case "Asta Clover" -> {
                            printWithDelay("\nEarl: You? This gonna be worth it", fastDelayPreset);
                            printWithDelay("\nAsta Clover: Let's fight till we die!", fastDelayPreset);
                        }
                        case "JF Void" -> {
                            printWithDelay("\nEarl: This is gonna be a pain in the ass", fastDelayPreset);
                            printWithDelay("\nJF Void: Here I am, wasting my time with a weakling", fastDelayPreset);
                        }
                        case "Deidre" -> {
                            printWithDelay("\nEarl: You look familiar", fastDelayPreset);
                            printWithDelay("\nDeidre: Don't compare me to the likes of him", fastDelayPreset);
                        }
                    }
                }

                case "The One John" -> {
                    switch (enemy.getName()) {
                        case "Kaniel Outis" -> {
                            printWithDelay("\nThe One John: What the hell are you?", fastDelayPreset);
                            printWithDelay("\nKaniel Outis: You're greatest demise", fastDelayPreset);
                        }
                        case "Van Berskville" -> {
                            printWithDelay("\nThe One John: Revenge won’t save you", fastDelayPreset);
                            printWithDelay("\nVan Berskville: Then I'll kill you", fastDelayPreset);
                        }
                        case "Asta Clover" -> {
                            printWithDelay("\nThe One John: This is gonna be easy", fastDelayPreset);
                            printWithDelay("\nAsta Clover: I'll make sure to cut you slowly", fastDelayPreset);
                        }
                        case "JF Void" -> {
                            printWithDelay("\nThe One John: The strongest have arrived", fastDelayPreset);
                            printWithDelay("\nJF Void: 3 draws, no wins and loses, today will be your downfall", fastDelayPreset);
                        }
                        case "Deidre" -> {
                            printWithDelay("\nThe One John: This is gonna be pain in the ass", fastDelayPreset);
                            printWithDelay("\nDeidre: All bark and no bite", fastDelayPreset);
                        }
                    }
                }

                case "And Rew" -> {
                    switch (enemy.getName()) {
                        case "Kaniel Outis" -> {
                            printWithDelay("\nAnd Rew: All I see is a walking dead man", fastDelayPreset);
                            printWithDelay("\nKaniel Outis: ", fastDelayPreset);
                        }
                        case "Van Berskville" -> {
                            printWithDelay("\nAnd Rew: ooohhh... vengeful guy i see", fastDelayPreset);
                            printWithDelay("\nVan Berskville: Your a dead man I'm sending you straight to hell", fastDelayPreset);
                        }
                        case "Asta Clover" -> {
                            printWithDelay("\nAnd Rew: Another guy who just won't give up", fastDelayPreset);
                            printWithDelay("\nAsta Clover: I'll break your neck", fastDelayPreset);
                        }
                        case "JF Void" -> {
                            printWithDelay("\nAnd Rew: You look strong, but I'm stronger", fastDelayPreset);
                            printWithDelay("\nJF Void: I'll erase you from the history", fastDelayPreset);
                        }
                        case "Deidre" -> {
                            printWithDelay("\nAnd Rew: Another relic", fastDelayPreset);
                            printWithDelay("\nDeidre: This place isn't big enough for the two of us.", fastDelayPreset);
                        }
                    }
                }
                default -> printWithDelay("\nThe atmosphere changed as they tense up......", fastDelayPreset);
            }
        }
    }

    public void playerSkillUseMonologue(Player player, int skillChoice) {
        System.out.println();
        switch (player.getName()) {
            case "Cosmic Dassel" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nCosmic Dassel: I'm gonna put some bug in your eye.", fastDelayPreset);
                    case 1 ->
                            printWithDelay("\nCosmic Dassel: Look at little binary junior, gonna cry?", fastDelayPreset);
                    case 2 ->
                            printWithDelay("\nCosmic Dassel: Systems fail, error emerge, let thy bugs control, Bug Overflow", fastDelayPreset);
                    case 3 ->
                            printWithDelay("\nCosmic Dassel: Spend, Invest, Dominate, Overclock amplify my being", fastDelayPreset);
                }
            }

            case "Khylle The Reaper" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nKhylle The Reaper: Basic attack to test you", fastDelayPreset);
                    case 1 -> printWithDelay("\nKhylle The Reaper: Karate Kick to your soul", fastDelayPreset);
                    case 2 ->
                            printWithDelay("\nKhylle The Reaper: Grave of gluttony let them cower thy souls, Flying food", fastDelayPreset);
                    case 3 ->
                            printWithDelay("\nKhylle The Reaper: Hear, your Eulogy, Voice of Destruction", fastDelayPreset);
                }
            }

            case "Earl" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nEarl: Haiyah!", fastDelayPreset);
                    case 1 -> printWithDelay("\nEarl: One order of Knee Strike coming right up", fastDelayPreset);
                    case 2 -> printWithDelay("\nEarl: On the double, double kick", fastDelayPreset);
                    case 3 -> printWithDelay("\nEarl: (Dodge).... Too slow", fastDelayPreset);
                }
            }

            case "The One John" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nThe One John: Normal Punch!", fastDelayPreset);
                    case 1 -> printWithDelay("\nThe One John: Your open!, Uppercut", fastDelayPreset);
                    case 2 -> printWithDelay("\nThe One John: You'll hurt yourself, Counterpalm", fastDelayPreset);
                    case 3 -> printWithDelay("\nThe One John: Ora ora ora ora ora ora ora ora!", fastDelayPreset);
                }
            }

            case "And Rew" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nAnd Rew: Baby dragon punch!", fastDelayPreset);
                    case 1 -> printWithDelay("\nAnd Rew: Take this, Dragon Punch", fastDelayPreset);
                    case 2 ->
                            printWithDelay("\nAnd Rew: Let thy dragons find the mark, Dragon Missle", fastDelayPreset);
                    case 3 ->
                            printWithDelay("\nAnd Rew: All thy existence bow thy verdict; I call, I decided, I rule... Dragon's Verdict of Demise! ", fastDelayPreset);
                }
            }
        }
    }

    public void enemySkillUseMonologue(Enemy enemy, int skillChoice) {
        switch (enemy.getName()) {
            case "Kaniel Outis" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nKaniel Outis: Take this basic attack!", fastDelayPreset);
                    case 1 ->
                            printWithDelay("\nKaniel Outis: Burn everything, let this burn into you, Image Burn", fastDelayPreset);
                    case 2 -> printWithDelay("\nKaniel Outis: Squeeze thy soul till nothing", fastDelayPreset);
                    case 3 ->
                            printWithDelay("\nKaniel Outis: All vision, All minds... Succumb to despair", fastDelayPreset);
                }
            }
            case "Van Berskville" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nVan Berskville: Tch!", fastDelayPreset);
                    case 1 -> printWithDelay("\nVan Berskville: Straight to heart", fastDelayPreset);
                    case 2 -> printWithDelay("\nVan Berskville: Getsuga Tenshoo!", fastDelayPreset);
                    case 3 -> printWithDelay("\nVan Berskville: Hidden Move, Fang Sword Style", fastDelayPreset);
                }
            }
            case "Asta Clover" -> {
                switch (skillChoice) {
                    case 0 ->
                            printWithDelay("\nAsta Clover: Not giving up is my magic!, Take this!....'HEADBUTTS'", fastDelayPreset);
                    case 1 ->
                            printWithDelay("\nAsta Clover: Not yet, not yet! I SAID NOT YET! SLASH... SLASH...", fastDelayPreset);
                    case 2 ->
                            printWithDelay("\nAsta Clover: If my previous attack had no effect, then eat this. SLASH SLASH", fastDelayPreset);
                    case 3 ->
                            printWithDelay("\nAsta Clover: Lets Go, Liebe. You and Me against the world...", fastDelayPreset);
                }
            }
            case "JF Void" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nJF Void: Hungry?, Eat My Knuckle Sandwich", fastDelayPreset);
                    case 1 -> printWithDelay("\nJF Void: Return to nothing", fastDelayPreset);
                    case 2 -> printWithDelay("\nJF Void: I bend reality for fun, Void deflect", fastDelayPreset);
                    case 3 -> printWithDelay("\nJF Void: One move, one death", fastDelayPreset);
                }
            }
            case "Deidre" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("\nDeidre: Slash!", fastDelayPreset);
                    case 1 -> printWithDelay("\nDeidre: 1 sword style iai, Lightning cut", fastDelayPreset);
                    case 2 -> printWithDelay("\nDeidre: 2 handed 1 Sword Style, Thunder Cleave", fastDelayPreset);
                    case 3 -> printWithDelay("\nDeidre: With this I'll finish everything, Final Turn", fastDelayPreset);
                }
            }
        }
    }

    public static void player2SkillChoice(Enemy enemy) {
        System.out.println();
        System.out.println("------------------ CHOOSE SKILL TO USE -----------------\n");
        for (int i = 0; i <= 3; i++) {
            printSkillDisplay(enemy, i);
        }
        System.out.print("\t\t\tEnter choice (0, 1, 2, or 3): ");
    }

    public void pvpBattleGameMode() {
        Player player = new Player();
        Enemy enemy = new Enemy();

        boolean isPVP = true;
        int len = 58;

        System.out.println();
        printCenter(" [MODE] PLAYER VS PLAYER ", len, '-', fastDelayPreset);
        printCenter(" [SYSTEM] TWO PEOPLE ENTERS, ONE GOES OUT ", len, '-', fastDelayPreset);

        int playerChoice = playerCharacterChoiceInputHandler(isPVP);
        switch (playerChoice) {
            case 1 -> player = new Player("Cosmic Dassel", "Provoked Punch", "Bug Overflow", "Overclock");
            case 2 -> player = new Player("Khylle The Reaper", "Karate Kick", "Flying Food", "Voice of Destruction");
            case 3 -> player = new Player("Earl", "Knee Strike", "Double Kick", "Dodge");
            case 4 -> player = new Player("The One John", "Upper Cut", "Counterpalm", "Flaring Punches");
            case 5 -> player = new Player("And Rew", "Dragon Fist", "Dragon First Missiles", "Dragon's Verdict of Demise");
        }

        int enemyChoice = enemyCharacterChoiceInputHandler(isPVP);
        switch (enemyChoice) {
            case 1 -> enemy = new Enemy("Kaniel Outis", "Image Burn", "Spirit Compression", "Sanity Drain");
            case 2 -> enemy = new Enemy("Van Berskville", "Stab", "Getsuga", "Fang Sword Style");
            case 3 -> enemy = new Enemy("Asta Clover", "Demon Slayer Slash", "Demon Dweller Double Slash", "Demon Union");
            case 4 -> enemy = new Enemy("JF Void", "Void Chop", "Void Deflect", "Void Stagger Palm");
            case 5 -> enemy = new Enemy("Deidre", "Lightning Cut", "Thunder Cleave", "Final Turn");
        }

        int round = 1;
        boolean isRunning = true;
        char ans = 'Y';
        int player1Win = 0;
        int player2Win = 0;

        printOrSkipNarrativeSegment(player, enemy);
        if (playerChoice == enemyChoice) {
            specialEncounterCounterPart(player, enemy);
        }

        do {

            isRunning = true;
            int turn = 1;
            printWithDelay("\n-------------------- Round " + round + " Starts --------------------", fastDelayPreset);

            do {
                int playerSkillChoice = 0, enemySkillChoice = 0, newPlayerMana = 0, newEnemyMana = 0;

                showRoundStatus(round, turn, player, enemy);

                System.out.println();
                System.out.println("----------------- Player 1 Current Status --------------");
                printWithDelay("\n[Player 1] " + player.getName(), fastDelayPreset);
                printWithDelay("\nHealth: " + player.getHitpoints(), fastDelayPreset);
                printWithDelay("Mana: " + player.getMana(), fastDelayPreset);

                boolean playerActed = false;
                while (!playerActed) {
                    while (true) {
                        try {
                            playerSkillChoices(player);
                            playerSkillChoice = scanner.nextInt();
                            if (playerSkillChoice < 0 || playerSkillChoice > 3) {
                                throw new InputMismatchException();
                            } else
                                break;
                        } catch (InputMismatchException e) {
                            System.out.println("\n\t\t\t\tInvalid Input, Try Again!");
                            scanner.nextLine();
                        }
                    }

                    playerSkillUseMonologue(player, playerSkillChoice);

                    switch (playerSkillChoice) {
                        case 0 -> {
                            enemy.setHitpoints(player.basicAttack());
                            playerActed = true;
                        }
                        case 1 -> {
                            if (player.getSkillOneCooldown() > 0) {
                                printWithDelay("\n" + player.getSkillOneName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!player.isSkillOneUsable()) {
                                printWithDelay("\nNot enough mana to use " + player.getSkillOneName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                enemy.setHitpoints(player.skillOne());
                                player.reduceMana(player.getSkillOneManaUsage());
                                player.activateSkillOneCooldown();
                                playerActed = true;
                            }
                        }
                        case 2 -> {
                            if (player.getSkillTwoCooldown() > 0) {
                                printWithDelay("\n" + player.getSkillTwoName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!player.isSkillTwoUsable()) {
                                printWithDelay("\nNot enough mana to use " + player.getSkillTwoName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                enemy.setHitpoints(player.skillTwo());
                                player.reduceMana(player.getSkillTwoManaUsage());
                                player.activateSkillTwoCooldown();
                                playerActed = true;
                            }
                        }
                        case 3 -> {
                            if (player.getSkillThreeCooldown() > 0) {
                                printWithDelay("\n" + player.getSkillThreeName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!player.isSkillThreeUsable()) {
                                printWithDelay("\nNot enough mana to use " + player.getSkillThreeName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                enemy.setHitpoints(player.skillThree());
                                player.reduceMana(player.getSkillThreeManaUsage());
                                player.activateSkillThreeCooldown();
                                playerActed = true;
                            }
                        }
                    }
                }

                if (enemy.getHitpoints() <= 0) {
                    printWithDelay("\n" + enemy.getName() + " has been defeated!", fastDelayPreset);
                    break;
                }

                newPlayerMana = random.nextInt(25, 51);
                player.increaseMana(newPlayerMana);
                printWithDelay("\n" + player.getName() + " regenerates " + newPlayerMana + " mana. (Mana: " + player.getMana() + ")", fastDelayPreset);

                System.out.println();
                System.out.println("----------------- Player 2 Current Status --------------");
                printWithDelay("\n[Player 2] " + enemy.getName(), fastDelayPreset);
                printWithDelay("\nHealth: " + enemy.getHitpoints(), fastDelayPreset);
                printWithDelay("Mana: " + enemy.getMana(), fastDelayPreset);

                boolean enemyActed = false;
                while (!enemyActed) {
                    while (true) {
                        try {
                            player2SkillChoice(enemy);
                            enemySkillChoice = scanner.nextInt();
                            if (enemySkillChoice < 0 || enemySkillChoice > 3) {
                                throw new InputMismatchException();
                            } else
                                break;
                        } catch (InputMismatchException e) {
                            System.out.println("\n\t\t\t\tInvalid Input, Try Again!");
                            scanner.nextLine();
                        }
                    }

                    enemySkillUseMonologue(enemy, enemySkillChoice);

                    switch (enemySkillChoice) {
                        case 0 -> {
                            player.setHitpoints(enemy.basicAttack());
                            enemyActed = true;
                        }
                        case 1 -> {
                            if (enemy.getSkillOneCooldown() > 0) {
                                printWithDelay("\n" + enemy.getSkillOneName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!enemy.isSkillOneUsable()) {
                                printWithDelay("\nNot enough mana to use " + enemy.getSkillOneName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                player.setHitpoints(enemy.skillOne());
                                enemy.reduceMana(enemy.getSkillOneManaUsage());
                                enemy.activateSkillOneCooldown();
                                enemyActed = true;
                            }
                        }
                        case 2 -> {
                            if (enemy.getSkillTwoCooldown() > 0) {
                                printWithDelay("\n" + enemy.getSkillTwoName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!enemy.isSkillTwoUsable()) {
                                printWithDelay("\nNot enough mana to use " + enemy.getSkillTwoName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                player.setHitpoints(enemy.skillTwo());
                                enemy.reduceMana(enemy.getSkillTwoManaUsage());
                                enemy.activateSkillTwoCooldown();
                                enemyActed = true;
                            }
                        }
                        case 3 -> {
                            if (enemy.getSkillThreeCooldown() > 0) {
                                printWithDelay("\n" + enemy.getSkillThreeName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!enemy.isSkillThreeUsable()) {
                                printWithDelay("\nNot enough mana to use " + enemy.getSkillThreeName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                player.setHitpoints(enemy.skillThree());
                                enemy.reduceMana(enemy.getSkillThreeManaUsage());
                                enemy.activateSkillThreeCooldown();
                                enemyActed = true;
                            }
                        }
                    }
                }

                if (player.getHitpoints() <= 0) {
                    printWithDelay("\n" + player.getName() + " has been defeated!", fastDelayPreset);
                    break;
                }

                newEnemyMana = random.nextInt(10, 21);
                enemy.increaseMana(newEnemyMana);
                printWithDelay("\n" + enemy.getName() + " regenerates " + newEnemyMana + " mana. (Mana: " + enemy.getMana() + ")", fastDelayPreset);

                player.reduceSkillOneCooldown();
                player.reduceSkillTwoCooldown();
                player.reduceSkillThreeCooldown();

                enemy.reduceSkillOneCooldown();
                enemy.reduceSkillTwoCooldown();
                enemy.reduceSkillThreeCooldown();

                if (player.getHitpoints() <= 0 || enemy.getHitpoints() <= 0) {
                    isRunning = false;
                } else {
                    turn++;
                }
            } while (isRunning);

            if (player.getHitpoints() > 0) {
                player1Win++;
                printWithDelay("\n" + player.getName() + " wins Round " + round + "!\n\n", fastDelayPreset);
            } else {
                player2Win++;
                printWithDelay("\n" + enemy.getName() + " wins Round " + round + "!\n\n", fastDelayPreset);
            }

            printWithDelay("-------------------- End of Round " + round + " --------------------\n", fastDelayPreset);

            if (round >= 3) {
                printWithDelay("\n==================== Final Results =====================\n", fastDelayPreset);
                printWithDelay(player.getName() + " Wins: " + player1Win + "\n", fastDelayPreset);
                printWithDelay(enemy.getName() + " Wins: " + player2Win + "\n", fastDelayPreset);

                if (player1Win > player2Win)
                    printWithDelay("\n" + player.getName() + " is the Final Winner!\n", fastDelayPreset);
                else if (player2Win > player1Win)
                    printWithDelay("\n" + enemy.getName() + " is the Final Winner!\n", fastDelayPreset);
                else
                    printWithDelay("\n It's a Draw! \n", fastDelayPreset);

                printWithDelay("\nGame Over! Thanks for playing!\n", fastDelayPreset);
                System.exit(0);
            } else {
                while (true) {
                    try {
                        System.out.print("Would you like to proceed to the next round? (Y/N): ");
                        ans = Character.toUpperCase(scanner.next().charAt(0));

                        if (ans == 'Y') {
                            player.resetStats();
                            player.resetCoolDown();
                            enemy.resetStats();
                            enemy.resetCoolDown();
                            round++;
                        } else if (ans == 'N') {
                            printWithDelay("\n==================== Final Results =====================\n", fastDelayPreset);
                            printWithDelay(player.getName() + " Wins: " + player1Win + "\n", fastDelayPreset);
                            printWithDelay(enemy.getName() + " Wins: " + player2Win + "\n", fastDelayPreset);

                            if (player1Win > player2Win)
                                printWithDelay("\n" + player.getName() + " is the Final Winner!\n", fastDelayPreset);
                            else if (player2Win > player1Win)
                                printWithDelay("\n" + enemy.getName() + " is the Final Winner!\n", fastDelayPreset);
                            else
                                printWithDelay("\n It's a Draw! \n", fastDelayPreset);

                            printWithDelay("\nGame Over! Thanks for playing!\n", fastDelayPreset);
                        } else {
                            throw new InputMismatchException();
                        }
                        break;
                    } catch (InputMismatchException error) {
                        System.out.println("\n\t\t\t\tInvalid Input. Try again!");
                        scanner.nextLine();
                    }
                }
            }
        } while (ans != 'N' && round <= 3);
    }

    public void playerVsComputerBattleGameMode() {
        Player player = new Player();
        Enemy enemy = new Enemy();

        System.out.println();
        printCenter(" [MODE] PLAYER VS COMPUTER ", len, '-', fastDelayPreset);
        printCenter(" [SYSTEM] YOU WILL ENCOUNTER AN UNPREDICTABLE OPPONENT ", len, '-', fastDelayPreset);

        int playerChoice = playerCharacterChoiceInputHandler();
        switch (playerChoice) {
            case 1 -> player = new Player("Cosmic Dassel", "Provoked Punch", "Bug Overflow", "Overclock");
            case 2 -> player = new Player("Khylle The Reaper", "Karate Kick", "Flying Food", "Voice of Destruction");
            case 3 -> player = new Player("Earl", "Knee Strike", "Double Kick", "Dodge");
            case 4 -> player = new Player("The One John", "Upper Cut", "Counterpalm", "Flaring Punches");
            case 5 -> player = new Player("And Rew", "Dragon Fist", "Dragon First Missiles", "Dragon's Verdict of Demise");
        }


        int enemyChoice = enemyCharacterChoiceInputHandler();
        switch (enemyChoice) {
            case 1 -> enemy = new Enemy("Kaniel Outis", "Image Burn", "Spirit Compression", "Sanity Drain");
            case 2 -> enemy = new Enemy("Van Berskville", "Stab", "Getsuga", "Fang Sword Style");
            case 3 ->
                    enemy = new Enemy("Asta Clover", "Demon Slayer Slash", "Demon Dweller Double Slash", "Demon Union");
            case 4 -> enemy = new Enemy("JF Void", "Void Chop", "Void Deflect", "Void Stagger Palm");
            case 5 -> enemy = new Enemy("Deidre", "Lightning Cut", "Thunder Cleave", "Final Turn");
        }

        int round = 1;
        boolean isRunning = true;
        char ans = 'Y';
        int playerWin = 0;
        int enemyWin = 0;

        printOrSkipNarrativeSegment(player, enemy);
        if (playerChoice == enemyChoice) {
            specialEncounterCounterPart(player, enemy);
        }

        do {

            isRunning = true;
            int turn = 1;
            printWithDelay("\n-------------------- Round " + round + " Starts --------------------", fastDelayPreset);

            do {
                int playerSkillChoice = 0, enemySkillChoice = 0, newPlayerMana = 0, newEnemyMana = 0;

                showRoundStatus(round, turn, player, enemy);

                System.out.println();
                //show both health and Mana
                System.out.println("------------------- Current Status -------------------");
                printWithDelay("\n[Player] " + player.getName(), fastDelayPreset);
                printWithDelay("\nHealth: " + player.getHitpoints(), fastDelayPreset);
                printWithDelay("Mana: " + player.getMana(), fastDelayPreset);

                boolean playerActed = false;

                while (!playerActed) {

                    while (true) {
                        try {
                            playerSkillChoices(player);
                            playerSkillChoice = scanner.nextInt();
                            if (playerSkillChoice < 0 || playerSkillChoice > 3) {
                                throw new InputMismatchException();
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\n\t\t\t\tInvalid Input, Try Again!");
                            scanner.nextLine();
                        }
                    }

                    // Player Skill Dialogue
                    playerSkillUseMonologue(player, playerSkillChoice);

                    switch (playerSkillChoice) {
                        case 0 -> {
                            enemy.setHitpoints(player.basicAttack());
                            playerActed = true;
                        }
                        case 1 -> {
                            if (player.getSkillOneCooldown() > 0) {
                                printWithDelay("\n" + player.getSkillOneName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!player.isSkillOneUsable()) {
                                printWithDelay("\nNot enough mana to use " + player.getSkillOneName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                enemy.setHitpoints(player.skillOne());
                                player.reduceMana(player.getSkillOneManaUsage());
                                player.activateSkillOneCooldown();
                                playerActed = true;
                            }
                        }
                        case 2 -> {
                            if (player.getSkillTwoCooldown() > 0) {
                                printWithDelay("\n" + player.getSkillTwoName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!player.isSkillTwoUsable()) {
                                printWithDelay("\nNot enough mana to use " + player.getSkillTwoName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                enemy.setHitpoints(player.skillTwo());
                                player.reduceMana(player.getSkillTwoManaUsage());
                                player.activateSkillTwoCooldown();
                                playerActed = true;
                            }
                        }
                        case 3 -> {
                            if (player.getSkillThreeCooldown() > 0) {
                                printWithDelay("\n" + player.getSkillThreeName() + " is on cooldown! Choose again.", fastDelayPreset);
                                break;
                            } else if (!player.isSkillThreeUsable()) {
                                printWithDelay("\nNot enough mana to use " + player.getSkillThreeName() + "! Choose again.", fastDelayPreset);
                                break;
                            } else {
                                enemy.setHitpoints(player.skillThree());
                                player.reduceMana(player.getSkillThreeManaUsage());
                                player.activateSkillThreeCooldown();
                                playerActed = true;
                            }
                        }
                    }
                }

                if (enemy.getHitpoints() <= 0) {
                    printWithDelay("\n" + enemy.getName() + " has been defeated!", fastDelayPreset);
                    break;
                }

                newPlayerMana = random.nextInt(25, 51);
                player.increaseMana(newPlayerMana);

                printWithDelay("\n" + player.getName() + " regenerates " + newPlayerMana + " mana. (Mana: " + player.getMana() + ")", fastDelayPreset);

                System.out.println();
                System.out.println("------------------ CURRENT STATUS ------------------");
                printWithDelay("\n[Computer] " + enemy.getName(), fastDelayPreset);
                printWithDelay("\nHealth: " + enemy.getHitpoints(), fastDelayPreset);
                printWithDelay("Mana: " + enemy.getMana(), fastDelayPreset);

                enemySkillChoice = random.nextInt(0, 4);
                enemySkillChoices(enemy);

                enemySkillUseMonologue(enemy, enemySkillChoice);

                switch (enemySkillChoice) {
                    case 0 -> {
                        player.setHitpoints(enemy.basicAttack());
                    }
                    case 1 -> {
                        if (enemy.getSkillOneCooldown() == 0 && enemy.isSkillOneUsable()) {
                            player.setHitpoints(enemy.skillOne());
                            enemy.reduceMana(enemy.getSkillOneManaUsage());
                            enemy.activateSkillOneCooldown();
                        } else if (enemy.getSkillOneCooldown() > 0) {
                            printWithDelay("\n" + enemy.getName() + "'s " + enemy.getSkillOneName() + " is on cooldown!", fastDelayPreset);
                            player.setHitpoints(enemy.basicAttack());
                        } else {
                            printWithDelay("\n" + enemy.getName() + " tried to use " + enemy.getSkillOneName() + " but didn't have enough mana.", fastDelayPreset);
                            player.setHitpoints(enemy.basicAttack());
                        }
                    }
                    case 2 -> {
                        if (enemy.getSkillTwoCooldown() == 0 && enemy.isSkillTwoUsable()) {
                            player.setHitpoints(enemy.skillTwo());
                            enemy.reduceMana(enemy.getSkillTwoManaUsage());
                            enemy.activateSkillTwoCooldown();
                        } else if (enemy.getSkillTwoCooldown() > 0) {
                            printWithDelay("\n" + enemy.getName() + "'s " + enemy.getSkillTwoName() + " is on cooldown!", fastDelayPreset);
                            player.setHitpoints(enemy.basicAttack());
                        } else {
                            printWithDelay("\n" + enemy.getName() + " tried to use " + enemy.getSkillTwoName() + " but didn't have enough mana.", fastDelayPreset);
                            player.setHitpoints(enemy.basicAttack());
                        }
                    }
                    case 3 -> {
                        if (enemy.getSkillThreeCooldown() == 0 && enemy.isSkillThreeUsable()) {
                            player.setHitpoints(enemy.skillThree());
                            enemy.reduceMana(enemy.getSkillThreeManaUsage());
                            enemy.activateSkillThreeCooldown();
                        } else if (enemy.getSkillThreeCooldown() > 0) {
                            printWithDelay("\n" + enemy.getName() + "'s " + enemy.getSkillThreeName() + " is on cooldown!", fastDelayPreset);
                            player.setHitpoints(enemy.basicAttack());
                        } else {
                            printWithDelay("\n" + enemy.getName() + " tried to use " + enemy.getSkillThreeName() + " but didn't have enough mana.", fastDelayPreset);
                            player.setHitpoints(enemy.basicAttack());
                        }
                    }
                }

                newEnemyMana = random.nextInt(10, 31);
                enemy.increaseMana(newEnemyMana);

                printWithDelay("\n" + enemy.getName() + " regenerates " + newEnemyMana + " mana. (Mana: " + enemy.getMana() + ")", fastDelayPreset);

                player.reduceSkillOneCooldown();
                player.reduceSkillTwoCooldown();
                player.reduceSkillThreeCooldown();

                enemy.reduceSkillOneCooldown();
                enemy.reduceSkillTwoCooldown();
                enemy.reduceSkillThreeCooldown();
                turn++;

                if (player.getHitpoints() <= 0 || enemy.getHitpoints() <= 0) {
                    isRunning = false;
                }

            } while (isRunning);

            if (player.getHitpoints() > 0) {
                playerWin++;
                printWithDelay("\n" + player.getName() + " wins!\n\n", fastDelayPreset);
            } else {
                enemyWin++;
                printWithDelay("\n" + enemy.getName() + " wins!\n\n", fastDelayPreset);
            }

            printWithDelay("-------------------- End of Round " + round + " --------------------\n", fastDelayPreset);

            if (round >= 3) {
                printWithDelay("\n==================== Final Results =====================\n", fastDelayPreset);
                printWithDelay(player.getName() + " Wins: " + playerWin + "\n", fastDelayPreset);
                printWithDelay(enemy.getName() + " Wins: " + enemyWin + "\n", fastDelayPreset);

                if (playerWin > enemyWin)
                    printWithDelay("\n" + player.getName() + " is the Final Winner!\n", fastDelayPreset);
                else if (enemyWin > playerWin)
                    printWithDelay("\n" + enemy.getName() + " is the Final Winner!\n", fastDelayPreset);
                else
                    printWithDelay("\n It's a Draw! \n", fastDelayPreset);

                printWithDelay("\nGame Over! Thanks for playing!\n", fastDelayPreset);
                System.exit(0);
            } else {
                while (true) {
                    try {
                        System.out.print("Would you like to proceed to the next round? (Y/N): ");
                        ans = Character.toUpperCase(scanner.next().charAt(0));

                        if (ans == 'Y') {
                            player.resetStats();
                            player.resetCoolDown();
                            enemy.resetStats();
                            enemy.resetCoolDown();
                            round++;
                        } else if (ans == 'N') {
                            printWithDelay("\n==================== Final Results =====================\n", fastDelayPreset);
                            printWithDelay(player.getName() + " Wins: " + playerWin + "\n", fastDelayPreset);
                            printWithDelay(enemy.getName() + " Wins: " + enemyWin + "\n", fastDelayPreset);

                            if (playerWin > enemyWin)
                                printWithDelay("\n" + player.getName() + " is the Final Winner!\n", fastDelayPreset);
                            else if (enemyWin > playerWin)
                                printWithDelay("\n" + enemy.getName() + " is the Final Winner!\n", fastDelayPreset);
                            else
                                printWithDelay("\n It's a Draw! \n", fastDelayPreset);

                            printWithDelay("\nGame Over! Thanks for playing!\n", fastDelayPreset);
                        } else {
                            throw new InputMismatchException();
                        }
                        break;
                    } catch (InputMismatchException error) {
                        System.out.println("\n\t\t\t\tInvalid Input. Try again!");
                        scanner.nextLine();
                    }
                }
            }
        } while (ans != 'N' && round <= 3);
    }

    public void arcadeBattleGameMode() {
        Player player = null;
        ArrayList<Enemy> enemies = new ArrayList<>(List.of(
                new Enemy("Kaniel Outis", "Image Burn", "Spirit Compression", "Sanity Drain"),
                new Enemy("Van Berskville", "Stab", "Getsuga", "Fang Sword Style"),
                new Enemy("Asta Clover", "Demon Slayer Slash", "Demon Dweller Double Slash", "Demon Union"),
                new Enemy("JF Void", "Void Chop", "Void Deflect", "Void Stagger Palm"),
                new Enemy("Deidre", "Lightning Cut", "Thunder Cleave", "Final Turn")
        ));

        // INTRO
        System.out.println();
        printCenter(" [MODE] ARCADE MODE ", len, '-', fastDelayPreset);
        printCenter(" [SYSTEM] ONE VS ALL, NO GOING OUT.... ", len, '-', fastDelayPreset);
        System.out.println();

        // --- PLAYER CHOICE ---
        int playerChoice = playerCharacterChoiceInputHandler();
        switch (playerChoice) {
            case 1 -> player = new Player("Cosmic Dassel", "Provoked Punch", "Bug Overflow", "Overclock");
            case 2 -> player = new Player("Khylle The Reaper", "Karate Kick", "Flying Food", "Voice of Destruction");
            case 3 -> player = new Player("Earl", "Knee Strike", "Double Kick", "Dodge");
            case 4 -> player = new Player("The One John", "Upper Cut", "Counterpalm", "Flaring Punches");
            case 5 -> player = new Player("And Rew", "Dragon Fist", "Dragon First Missiles", "Dragon's Verdict of Demise");
        }


        int matchCount = 0;
        int wins = 0;


        while (player.getHitpoints() > 0 && !enemies.isEmpty()) {
            System.out.println();
            Enemy enemy = enemies.get(random.nextInt(enemies.size()));
            System.out.println();
            System.out.println("\t\t\tYour next opponent is: " + enemy.getName());


            printOrSkipNarrativeSegment(player, enemy);

            int turnCounter = 1;
            boolean fightActive = true;
            int matchNumber = matchCount + 1;
            while (fightActive && player.getHitpoints() > 0 && enemy.getHitpoints() > 0) {
                showRoundStatus(matchNumber, turnCounter, player, enemy);
                System.out.println();
                System.out.println("------------------- CURRENT STATUS -------------------");
                printWithDelay("\n[Player 1] " + player.getName(), fastDelayPreset);
                printWithDelay("\nHealth: " + player.getHitpoints(), fastDelayPreset);
                printWithDelay("Mana: " + player.getMana(), fastDelayPreset);

                // ---------------- PLAYER TURN ----------------
                boolean playerActed = false;
                while (!playerActed) {
                    try {
                        playerSkillChoices(player);
                        int skillChoice = scanner.nextInt();

                        if (skillChoice < 0 || skillChoice > 3) throw new InputMismatchException();

                        playerSkillUseMonologue(player, skillChoice);

                        switch (skillChoice) {
                            case 0 -> {
                                enemy.setHitpoints(player.basicAttack());
                                playerActed = true;
                            }
                            case 1 -> {
                                if (player.getSkillOneCooldown() > 0)
                                    printWithDelay("\n" + player.getSkillOneName() + " is on cooldown!", fastDelayPreset);
                                else if (!player.isSkillOneUsable())
                                    printWithDelay("\nNot enough mana!", fastDelayPreset);
                                else {
                                    enemy.setHitpoints(player.skillOne());
                                    player.reduceMana(player.getSkillOneManaUsage());
                                    player.activateSkillOneCooldown();
                                    playerActed = true;
                                }
                            }
                            case 2 -> {
                                if (player.getSkillTwoCooldown() > 0)
                                    printWithDelay("\n" + player.getSkillTwoName() + " is on cooldown!", fastDelayPreset);
                                else if (!player.isSkillTwoUsable())
                                    printWithDelay("\nNot enough mana!", fastDelayPreset);
                                else {
                                    enemy.setHitpoints(player.skillTwo());
                                    player.reduceMana(player.getSkillTwoManaUsage());
                                    player.activateSkillTwoCooldown();
                                    playerActed = true;
                                }
                            }
                            case 3 -> {
                                if (player.getSkillThreeCooldown() > 0)
                                    printWithDelay("\n" + player.getSkillThreeName() + " is on cooldown!", fastDelayPreset);
                                else if (!player.isSkillThreeUsable())
                                    printWithDelay("\nNot enough mana!", fastDelayPreset);
                                else {
                                    enemy.setHitpoints(player.skillThree());
                                    player.reduceMana(player.getSkillThreeManaUsage());
                                    player.activateSkillThreeCooldown();
                                    playerActed = true;
                                }
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n\t\t\t\tInvalid Input, Try Again!");
                        scanner.nextLine();
                    }
                }

                if (enemy.getHitpoints() <= 0) {
                    printWithDelay("\n" + enemy.getName() + " has been defeated!", fastDelayPreset);
                    wins++;
                    // base heal
                    int healAmount = 50;
                    // base mana
                    int manaAmount = 20;

                    // base heal multiplied by random multiplier
                    healAmount *= random.nextInt(1, 11);
                    // base mana multiplied by random multiplier
                    manaAmount *= random.nextInt(1, 11);

                    player.heal(healAmount);
                    player.increaseMana(manaAmount);
                    player.resetCoolDown();
                    printWithDelay("\n" + player.getName() + " recovers " + healAmount + " HP after the victory!", fastDelayPreset);
                    printWithDelay("\n" + player.getName() + " recovers " + manaAmount + " Mana after the victory!", fastDelayPreset);
                    System.out.println("\nWins: " + wins + " / 5");
                    enemy.setDefeated(true);
                    enemies.remove(enemy);




                    if (wins == 5) {
                        Enemy ohmaZio = new Enemy("Ohma Zi-O", "Temporal Strike", "Rift Crush", "King's Judgment");
                        ohmaZio.setHitpoints(1000);
                        ohmaZio.setMana(300);
                        ohmaZio.resetCoolDown();
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
                        printWithDelay(text, fastDelayPreset);
                        printFinalBoss();
                        fightFinalBoss(player, ohmaZio, scanner, random);
                        return;
                    }
                    fightActive = false;
                    break;
                }

                // Mana regen after player's turn
                int playerManaRegen = random.nextInt(25, 51);
                player.increaseMana(playerManaRegen);
                printWithDelay("\n" + player.getName() + " regenerates " + playerManaRegen + " mana.", fastDelayPreset);

                // ---------------- ENEMY TURN ----------------
                System.out.println();
                System.out.println("------------------ ENEMY TURN ------------------");
                printWithDelay("\n[Enemy] " + enemy.getName(), fastDelayPreset);
                printWithDelay("\nHealth: " + enemy.getHitpoints(), fastDelayPreset);
                printWithDelay("Mana: " + enemy.getMana(), fastDelayPreset);

                int enemySkillChoice = random.nextInt(0, 4);
                enemySkillUseMonologue(enemy, enemySkillChoice);

                switch (enemySkillChoice) {
                    case 0 -> player.setHitpoints(enemy.basicAttack());
                    case 1 -> {
                        if (enemy.getSkillOneCooldown() == 0 && enemy.isSkillOneUsable()) {
                            player.setHitpoints(enemy.skillOne());
                            enemy.reduceMana(enemy.getSkillOneManaUsage());
                            enemy.activateSkillOneCooldown();
                        } else {
                            player.setHitpoints(enemy.basicAttack());
                        }
                    }
                    case 2 -> {
                        if (enemy.getSkillTwoCooldown() == 0 && enemy.isSkillTwoUsable()) {
                            player.setHitpoints(enemy.skillTwo());
                            enemy.reduceMana(enemy.getSkillTwoManaUsage());
                            enemy.activateSkillTwoCooldown();
                        } else {
                            player.setHitpoints(enemy.basicAttack());
                        }
                    }
                    case 3 -> {
                        if (enemy.getSkillThreeCooldown() == 0 && enemy.isSkillThreeUsable()) {
                            player.setHitpoints(enemy.skillThree());
                            enemy.reduceMana(enemy.getSkillThreeManaUsage());
                            enemy.activateSkillThreeCooldown();
                        } else {
                            player.setHitpoints(enemy.basicAttack());
                        }
                    }
                }

                // Enemy mana regen
                int enemyManaRegen = random.nextInt(10, 21);
                enemy.increaseMana(enemyManaRegen);
                printWithDelay("\n" + enemy.getName() + " regenerates " + enemyManaRegen + " mana.", fastDelayPreset);

                // Reduce cooldowns
                player.reduceSkillOneCooldown();
                player.reduceSkillTwoCooldown();
                player.reduceSkillThreeCooldown();
                enemy.reduceSkillOneCooldown();
                enemy.reduceSkillTwoCooldown();
                enemy.reduceSkillThreeCooldown();

                turnCounter++;

                if (player.getHitpoints() <= 0) {
                    fightActive = false;
                    printWithDelay("\n\t\t\t" + player.getName() + " has been defeated!", fastDelayPreset);
                }
            }

            if (enemy.getHitpoints() <= 0) {
                matchCount++;
            }

            if (player.getHitpoints() <= 0) {
                printWithDelay("\n\t\t\tGame Over. Better luck next time!\n", fastDelayPreset);
                break;
            }
        }

        if (player.getHitpoints() > 0 && enemies.isEmpty()) {
            printWithDelay("\n\t\t\tAll enemies have been defeated! You are the champion!\n", fastDelayPreset);
        }
    }

    public void fightFinalBoss(Player player, Enemy boss, Scanner scanner, Random random) {
        boolean fightActive = true;

        // Intro lines (use printWithDelay if available)
        printWithDelay("\nThe Final Battle Begins!", fastDelayPreset);
        printWithDelay(player.getName() + " VS " + boss.getName(), fastDelayPreset);

        while (fightActive && player.getHitpoints() > 0 && boss.getHitpoints() > 0) {

            // show status (you have showRoundStatus for rounds — reuse a simple status here)
            System.out.println("\n[Player] " + player.getName() + " HP: " + player.getHitpoints() + "  |  [Boss] " + boss.getName() + " HP: " + boss.getHitpoints());

            // --- Player turn (reuse your existing player skill choice flow) ---
            boolean playerActed = false;
            while (!playerActed) {
                try {
                    playerSkillChoices(player);
                    int skillChoice = scanner.nextInt();
                    playerSkillUseMonologue(player, skillChoice);

                    switch (skillChoice) {
                        case 0 -> {
                            boss.setHitpoints(player.basicAttack());
                            playerActed = true;
                        }
                        case 1 -> {
                            if (player.getSkillOneCooldown() > 0) {
                                printWithDelay("\n" + player.getSkillOneName() + " is on cooldown!", fastDelayPreset);
                            } else if (!player.isSkillOneUsable()) {
                                printWithDelay("\nNot enough mana!", fastDelayPreset);
                            } else {
                                boss.setHitpoints(player.skillOne());
                                player.reduceMana(player.getSkillOneManaUsage());
                                player.activateSkillOneCooldown();
                                playerActed = true;
                            }
                        }
                        case 2 -> { /* similar to case 1 for skillTwo */ }
                        case 3 -> { /* similar to case 1 for skillThree */ }
                        default -> {
                            System.out.println("Invalid choice");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input. Try again!");
                    scanner.nextLine();
                }
            }

            // check boss death
            if (boss.getHitpoints() <= 0) {
                printWithDelay("\n" + boss.getName() + " has been defeated!", fastDelayPreset);
                break;
            }


            int enemySkillChoice = random.nextInt(0, 4);
            enemySkillUseMonologue(boss, enemySkillChoice);
            switch (enemySkillChoice) {
                case 0 -> player.setHitpoints(boss.basicAttack());
                case 1 -> {
                    if (boss.getSkillOneCooldown() == 0 && boss.isSkillOneUsable()) {
                        player.setHitpoints(boss.skillOne());
                        boss.reduceMana(boss.getSkillOneManaUsage());
                        boss.activateSkillOneCooldown();
                    } else player.setHitpoints(boss.basicAttack());
                }
                case 2 -> {
                    if (boss.getSkillTwoCooldown() == 0 && boss.isSkillTwoUsable()) {
                        player.setHitpoints(boss.skillTwo());
                        boss.reduceMana(boss.getSkillTwoManaUsage());
                        boss.activateSkillTwoCooldown();
                    } else {
                        player.setHitpoints(boss.basicAttack());
                    }
                }

                case 3 -> {
                    if (boss.getSkillThreeCooldown() == 0 && boss.isSkillThreeUsable()) {
                        player.setHitpoints(boss.skillThree());
                        boss.reduceMana(boss.getSkillThreeManaUsage());
                        boss.activateSkillThreeCooldown();
                    } else {
                        player.setHitpoints(boss.basicAttack());
                    }
                }

            }

            // mana regen + cooldown reduce (reuse patterns)
            int bossManaRegen = random.nextInt(10, 31);
            boss.increaseMana(bossManaRegen);
            player.reduceSkillOneCooldown();
            player.reduceSkillTwoCooldown();
            player.reduceSkillThreeCooldown();
            boss.reduceSkillOneCooldown();
            boss.reduceSkillTwoCooldown();
            boss.reduceSkillThreeCooldown();

            if (player.getHitpoints() <= 0) {
                printWithDelay("\nYou were defeated by " + boss.getName() + "...", fastDelayPreset);
                break;
            }
        }

        // After fight results
        if (player.getHitpoints() > 0 && boss.getHitpoints() <= 0) {
            printWithDelay("\nYOU BEAT THE FINAL BOSS! True ending unlocked!", fastDelayPreset);
        }
    }


    public void printFinalBoss() {
        String purple = "\u001B[35m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        String text = """
                
                  ░██████   ░██                                      ░█████████ ░██          ░██████  
                 ░██   ░██  ░██                                            ░██              ░██   ░██ 
                ░██     ░██ ░████████  ░█████████████   ░██████           ░██   ░██        ░██     ░██
                ░██     ░██ ░██    ░██ ░██   ░██   ░██       ░██        ░███    ░██░██████ ░██     ░██
                ░██     ░██ ░██    ░██ ░██   ░██   ░██  ░███████       ░██      ░██        ░██     ░██
                 ░██   ░██  ░██    ░██ ░██   ░██   ░██ ░██   ░██      ░██       ░██         ░██   ░██ 
                  ░██████   ░██    ░██ ░██   ░██   ░██  ░█████░██    ░█████████ ░██          ░██████  
                
                
                """;
        printWithDelay(purple + text + reset, 5);
    }
}



