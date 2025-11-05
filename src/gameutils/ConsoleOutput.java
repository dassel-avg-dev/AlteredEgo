package gameutils;

import java.util.*;

public class ConsoleOutput {
    static final int slowDelayPreset = 120;
    static final int mediumDelayPreset = 80;
    static final int fastDelayPreset = 40;
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

    public void gameTitle() {
        printWithDelay("---------------- WELCOME TO ALTERED EGO ----------------", fastDelayPreset);
        printWithDelay("--------- Fight Your Other Side or Suffer Forever ------", fastDelayPreset);
    }

    public void loadingScreen() {
        printWithDelay("\n\t\t\t\t\tLOADING GAME CONTENT......", fastDelayPreset);
        System.out.println("1%                                                        100%");
        printWithDelay("[ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ]", 70);
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
        while (true) {
            System.out.println();
            System.out.println("------------------ CHOOSE GAME MODE ------------------");
            System.out.println("\t\t\t[1] Player vs Player");
            System.out.println("\t\t\t[2] Player vs Computer");
            System.out.println("\t\t\t[3] Arcade Mode");
            System.out.println("\t\t\t[4] Random");
            System.out.print("\t\t\tEnter choice (1, 2, 3, or 4): ");
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 4) {
                    throw new InputMismatchException();
                } else if (choice == 4) {
                    choice = random.nextInt(1, 4);
                    break;
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n\t\t\tInvalid Input, Try Again!");
                scanner.nextLine();
            }
        }
        return choice;
    }


    public void playerSkillChoices(Player player) {
        String skillOneDamage = (player.getName().equals("OP Chracter")) ? " (Min: 50 | Max: 50)" : " (Min: 30 | Max: 40)";
        String skillTwoDamage = (player.getName().equals("OP Chracter")) ? " (Min: 100 | Max: 100)" : " (Min: 40 | Max: 50)";
        String skillThreeDamage = (player.getName().equals("OP Chracter")) ? " (Min: 150 | Max: 150)" : " (Min: 100 | Max: 150)";
        System.out.println();
        System.out.println("----------------- CHOOSE SKILL TO USE ------------------");
        System.out.println("\t\t[0] Basic Attack (Min: 20 | Max: 30)");
        System.out.println("\t\t[1] Skill One: " + player.getSkillOneName() + " " + skillOneDamage);
        System.out.println("\t\t[2] SKill Two: " + player.getSkillTwoName() + " " + skillTwoDamage);
        System.out.println("\t\t[3] Skill Three: " + player.getSkillThreeName() + " " + skillThreeDamage);
        System.out.print("\t\tEnter choice (0, 1, 2, or 3): ");
    }

    public void playerCharacterChoices() {
        System.out.println();
        System.out.println("----------------- CHOOSE YOUR CHARACTER ----------------");
        System.out.println("\t\t\t[1] Cosmic Dassel");
        System.out.println("\t\t\t[2] Khylle The Reaper");
        System.out.println("\t\t\t[3] Earl");
        System.out.println("\t\t\t[4] The One John");
        System.out.println("\t\t\t[5] And Rew");
        System.out.println("\t\t\t[6] OP Character");
        System.out.print("\t\t\tEnter choice (1, 2, 3, 4, 5 or 6): ");
    }

    public void playerCharacterChoices(boolean isPVP) {
        System.out.println();
        if (isPVP) {
            System.out.println("----------------- CHOOSE YOUR CHAMPION ----------------");
        } else {
            System.out.println("----------------- CHOOSE YOUR CHARACTER ----------------");
        }
        System.out.println("\t\t\t[1] Cosmic Dassel");
        System.out.println("\t\t\t[2] Khylle The Reaper");
        System.out.println("\t\t\t[3] Earl");
        System.out.println("\t\t\t[4] The One John");
        System.out.println("\t\t\t[5] And Rew");
        System.out.println("\t\t\t[6] OP Character");
        System.out.print("\t\t\tEnter choice (1, 2, 3, 4, 5 or 6): ");
    }


    public void enemyCharacterChoices() {
        System.out.println();
        System.out.println("------------------ CHOOSE YOUR ENEMY ------------------");
        System.out.println("\t\t\t[1] Kaniel Outis");
        System.out.println("\t\t\t[2] Van Berksville");
        System.out.println("\t\t\t[3] Asta Clover");
        System.out.println("\t\t\t[4] JF Void");
        System.out.println("\t\t\t[5] Deidre");
        System.out.print("\t\t\tEnter (1, 2, 3, 4, or 5): ");
    }

    public void enemyCharacterChoices(boolean isPVP) {
        System.out.println();
        if (isPVP) {
            System.out.println("------------------ CHOOSE YOUR CHAMPION ------------------");
        } else {
            System.out.println("------------------ CHOOSE YOUR ENEMY ------------------");
        }
        System.out.println("\t\t\t[1] Kaniel Outis");
        System.out.println("\t\t\t[2] Van Berksville");
        System.out.println("\t\t\t[3] Asta Clover");
        System.out.println("\t\t\t[4] JF Void");
        System.out.println("\t\t\t[5] Deidre");
        System.out.print("\t\t\tEnter (1, 2, 3, 4, or 5): ");
    }

    public void showRoundHeader(int round) {
        System.out.println();
        System.out.println("==================== Match — Round " + round + " ====================");
        System.out.println();
    }

    //show player and enemy cd
    public void showBothCooldownsAndResources(Player player, Enemy enemy) {
        final int smallDelay = 25;

        //player
        printWithDelay("[Player] " + player.getName() + "\n", smallDelay);
        System.out.println("--------------------------------------");
        printWithDelay("\t\t[0] Basic Attack", smallDelay);
        printWithDelay("\t\tCD: READY | Mana: —", smallDelay);

        System.out.println("--------------------------------------");
        printWithDelay("\t\t" + "[1] " + player.getSkillOneName(), smallDelay);
        printWithDelay("\t\tCD: " + (player.getSkillOneCooldown() == 0 ? "READY" : player.getSkillOneCooldown() + " Turns") + " | Mana: " + player.getSkillOneManaUsage(), smallDelay);

        System.out.println("--------------------------------------");
        printWithDelay("\t\t" + "[2] " + player.getSkillTwoName(), smallDelay);
        printWithDelay("\t\tCD: " + (player.getSkillTwoCooldown() == 0 ? "READY" : player.getSkillTwoCooldown() + " Turns") + " | Mana: " + player.getSkillTwoManaUsage(), smallDelay);

        System.out.println("--------------------------------------");
        printWithDelay("\t\t" + "[3] " + player.getSkillThreeName(), smallDelay);
        printWithDelay("\t\tCD: " + (player.getSkillThreeCooldown() == 0 ? "READY" : player.getSkillThreeCooldown() + " Turns") + " | Mana: " + player.getSkillThreeManaUsage(), smallDelay);
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println();

        //enemy
        printWithDelay("[Enemy] " + enemy.getName() + "\n", smallDelay);
        System.out.println("--------------------------------------");
        printWithDelay("\t\t[0] Basic Attack", smallDelay);
        printWithDelay("\t\tCD: READY | Mana: —", smallDelay);

        System.out.println("--------------------------------------");
        printWithDelay("\t\t" + "[1] " + enemy.getSkillOneName(), smallDelay);
        printWithDelay("\t\tCD: " + (enemy.getSkillOneCooldown() == 0 ? "READY" : enemy.getSkillOneCooldown() + " Turns") + " | Mana: " + enemy.getSkillOneManaUsage(), smallDelay);

        System.out.println("--------------------------------------");
        printWithDelay("\t\t" + "[2] " + enemy.getSkillTwoName(), smallDelay);
        printWithDelay("\t\tCD: " + (enemy.getSkillTwoCooldown() == 0 ? "READY" : enemy.getSkillTwoCooldown() + " Turns") + " | Mana: " + enemy.getSkillTwoManaUsage(), smallDelay);

        System.out.println("--------------------------------------");
        printWithDelay("\t\t" + "[3] " + enemy.getSkillThreeName(), smallDelay);
        printWithDelay("\t\tCD: " + (enemy.getSkillThreeCooldown() == 0 ? "READY" : enemy.getSkillThreeCooldown() + " Turns") + " | Mana: " + enemy.getSkillThreeManaUsage(), smallDelay);
        System.out.println("--------------------------------------\n");
        System.out.println("========================================================");
        System.out.println();
    }

    private String formatSkillLine(String skillLabel, String midLabel, int cdValue, String rightLabel) {
        String cdString = (cdValue <= 0) ? "Ready" : cdValue + " turn(s)";
        return String.format("\t%s %s: %s \t%s", skillLabel, midLabel, cdString, rightLabel);
    }

    public void showRoundStatus(int round, Player player, Enemy enemy) {
        showRoundHeader(round);
        showBothCooldownsAndResources(player, enemy);
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
                } else {
                    break;
                }
            } catch (InputMismatchException error) {
                System.out.println("\n\t\t\tInvalid Input. Try again!");
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
                } else {
                    break;
                }
            } catch (InputMismatchException error) {
                System.out.println("\n\t\t\tInvalid Input. Try again!");
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("\n\t\t\tInvalid Input, Try Again!");
                scanner.nextLine();
            }
        }
        return enemyChoice;
    }

    // display monologue for player or skip the whole monologue
    public void printOrSkipNarrativeSegment(Player player) {
        // '0' is a placeholder to avoid null pointer exception
        char skipSegmentChoice = '0';
        do {
            try {
                System.out.print("\n\t\t\tSkip narrative segment (Y / N): ");
                skipSegmentChoice = scanner.next().toUpperCase().charAt(0);
                if (skipSegmentChoice == 'N') {
                    specialEncounterMonologue(player);
                    break;
                } else if (skipSegmentChoice != 'Y') {
                    System.out.println("\n\t\t\tInvalid Input. Try again!");
                } else {
                    break;
                }
            } catch (InputMismatchException error) {
                System.out.println("\n\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        } while (skipSegmentChoice != 'Y');
    }

    // display monologue for enemy or skip the whole monologue
    public void printOrSkipNarrativeSegment(Enemy enemy) {
        // '0' is a placeholder to avoid null pointer exception
        char skipSegmentChoice = '0';
        do {
            try {
                System.out.print("\n\t\t\tSkip narrative segment (Y / N): ");
                skipSegmentChoice = scanner.next().toUpperCase().charAt(0);
                if (skipSegmentChoice == 'N') {
                    specialEncounterMonologue(enemy);
                    break;
                } else if (skipSegmentChoice != 'Y') {
                    System.out.println("\n\t\t\tInvalid Input. Try again!");
                } else {
                    break;
                }
            } catch (InputMismatchException error) {
                System.out.println("\n\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        } while (skipSegmentChoice != 'Y');
    }

    public void enemySkillChoices(Enemy enemy) {
        System.out.println();
        System.out.println("------------- " + enemy.getName() + "'s Skills: ------------");
        System.out.println("\t\t[0] Basic Attack (Min: 20 | Max: 30)");
        System.out.println("\t\t[1] Skill One: " + enemy.getSkillOneName() + " (Min: 30 | Max: 40)");
        System.out.println("\t\t[2] Skill Two: " + enemy.getSkillTwoName() + " (Min: 40 | Max: 50)");
        System.out.println("\t\t[3] Skill Three: " + enemy.getSkillThreeName() + " (Min: 100 | Max: 150)");
        System.out.println();
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
                System.out.println("\n\t\t\tInvalid Input, Try Again!");
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
                            printWithDelay("\nDeidre: ", fastDelayPreset);
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
                    case 0 -> printWithDelay("Cosmic Dassel: I'm gonna put some bug in your eye.", fastDelayPreset);
                    case 1 ->
                            printWithDelay("Cosmic Dassel: Look at little binary junior, gonna cry?", fastDelayPreset);
                    case 2 ->
                            printWithDelay("Cosmic Dassel: Systems fail, error emerge, let thy bugs control, Bug Overflow", fastDelayPreset);
                    case 3 ->
                            printWithDelay("Cosmic Dassel: Spend, Invest, Dominate, Overclock amplify my being", fastDelayPreset);
                }
            }

            case "Khylle The Reaper" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Khylle The Reaper: Basic attack to test you", fastDelayPreset);
                    case 1 -> printWithDelay("Khylle The Reaper: Karate Kick to your soul", fastDelayPreset);
                    case 2 ->
                            printWithDelay("Khylle The Reaper: Grave of gluttony let them cower thy souls, Flying food", fastDelayPreset);
                    case 3 ->
                            printWithDelay("Khylle The Reaper: Hear, your Eulogy, Voice of Destruction", fastDelayPreset);
                }
            }

            case "Earl" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Earl: Haiyah!", fastDelayPreset);
                    case 1 -> printWithDelay("Earl: One order of Knee Strike coming right up", fastDelayPreset);
                    case 2 -> printWithDelay("Earl: On the double, double kick", fastDelayPreset);
                    case 3 -> printWithDelay("Earl: (Dodge).... Too slow", fastDelayPreset);
                }
            }

            case "The One John" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("The One John: Normal Punch!", fastDelayPreset);
                    case 1 -> printWithDelay("The One John: Your open!, Uppercut", fastDelayPreset);
                    case 2 -> printWithDelay("The One John: You'll hurt yourself, Counterpalm", fastDelayPreset);
                    case 3 -> printWithDelay("The One John: Ora ora ora ora ora ora ora ora!", fastDelayPreset);
                }
            }

            case "And Rew" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("And Rew: Baby dragon punch!", fastDelayPreset);
                    case 1 -> printWithDelay("And Rew: Take this, Dragon Punch", fastDelayPreset);
                    case 2 -> printWithDelay("And Rew: Let thy dragons find the mark, Dragon Missle", fastDelayPreset);
                    case 3 ->
                            printWithDelay("And Rew: All thy existence bow thy verdict; I call, I decided, I rule... Dragon's Verdict of Demise! ", fastDelayPreset);
                }
            }
        }
    }

    public void enemySkillUseMonologue(Enemy enemy, int skillChoice) {
        switch (enemy.getName()) {
            case "Kaniel Outis" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Kaniel Outis: Take this basic attack!", fastDelayPreset);
                    case 1 ->
                            printWithDelay("Kaniel Outis: Burn everything, let this burn into you, Image Burn", fastDelayPreset);
                    case 2 -> printWithDelay("Kaniel Outis: Squeeze thy soul till nothing", fastDelayPreset);
                    case 3 ->
                            printWithDelay("Kaniel Outis: All vision, All minds... Succumb to despair", fastDelayPreset);
                }
            }
            case "Van Berskville" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Van Berskville: Tch!", fastDelayPreset);
                    case 1 -> printWithDelay("Van Berskville: Straight to heart", fastDelayPreset);
                    case 2 -> printWithDelay("Van Berskville: Getsuga Tenshoo!", fastDelayPreset);
                    case 3 -> printWithDelay("Van Berskville: Hidden Move, Fang Sword Style", fastDelayPreset);
                }
            }
            case "Asta Clover" -> {
                switch (skillChoice) {
                    case 0 ->
                            printWithDelay("Asta Clover: Not giving up is my magic!, Take this!....'HEADBUTTS'", fastDelayPreset);
                    case 1 ->
                            printWithDelay("Asta Clover: Not yet, not yet! I SAID NOT YET! SLASH... SLASH...", fastDelayPreset);
                    case 2 ->
                            printWithDelay("Asta Clover: If my previous attack had no effect, then eat this. SLASH SLASH", fastDelayPreset);
                    case 3 ->
                            printWithDelay("Asta Clover: Lets Go, Liebe. You and Me against the world...", fastDelayPreset);
                }
            }
            case "JF Void" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("JF Void: Hungry?, Eat My Knuckle Sandwich", fastDelayPreset);
                    case 1 -> printWithDelay("JF Void: Return to nothing", fastDelayPreset);
                    case 2 -> printWithDelay("JF Void: I bend reality for fun, Void deflect", fastDelayPreset);
                    case 3 -> printWithDelay("JF Void: One move, one death", fastDelayPreset);
                }
            }
            case "Deidre" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Deidre: Slash!", fastDelayPreset);
                    case 1 -> printWithDelay("Deidre: 1 sword style iai, Lightning cut", fastDelayPreset);
                    case 2 -> printWithDelay("Deidre: 2 handed 1 Sword Style, Thunder Cleave", fastDelayPreset);
                    case 3 -> printWithDelay("Deidre: With this I'll finish everything, Final Turn", fastDelayPreset);
                }
            }
        }
    }

    public static void player2SkillChoice(Enemy enemy) {
        System.out.println();
        System.out.println("------------------ CHOOSE SKILL TO USE -----------------");
        System.out.println("\t\t[0] Basic Attack (Min: 20 | Max: 30)");
        System.out.println("\t\t[1] Skill One: " + enemy.getSkillOneName() + " (Min: 30 | Max: 40)");
        System.out.println("\t\t[2] Skill Two: " + enemy.getSkillTwoName() + " (Min: 40 | Max: 50)");
        System.out.println("\t\t[3] Skill Three: " + enemy.getSkillThreeName() + " (Min: 100 | Max: 150)");
        System.out.print("\t\tEnter choice (0, 1, 2, or 3): ");
    }

    public void pvpBattleGameMode() {
        Player player = new Player();
        Enemy enemy = new Enemy();
        boolean isPVP = true;


        int playerChoice = playerCharacterChoiceInputHandler(isPVP);
        switch (playerChoice) {
            case 1 -> player = new Player("Cosmic Dassel", "Provoked Punch", "Bug Overflow", "Overclock");
            case 2 -> player = new Player("Khylle The Reaper", "Karate Kick", "Flying Food", "Voice of Destruction");
            case 3 -> player = new Player("Earl", "Knee Strike", "Double Kick", "Dodge");
            case 4 -> player = new Player("The One John", "Upper Cut", "Counterpalm", "Flaring Punches");
            case 5 ->
                    player = new Player("And Rew", "Dragon Fist", "Dragon First Missiles", "Dragon's Verdict of Demise");
            case 6 -> player = new OPCharacter("OP Character", "OP Skill One", "OP Skill Two", "OP Skill Three");
        }

        int enemyChoice = enemyCharacterChoiceInputHandler(isPVP);
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
        int player1Win = 0;
        int player2Win = 0;

        do {

            printWithDelay("\n-------------------- Round " + round + " Starts --------------------", fastDelayPreset);

            printOrSkipNarrativeSegment(player);
            printOrSkipNarrativeSegment(enemy);

            if (playerChoice == enemyChoice) {
                specialEncounterCounterPart(player, enemy);
            }

            isRunning = true;

            do {
                int playerSkillChoice = 0, enemySkillChoice = 0, newPlayerMana = 0, newEnemyMana = 0;

                showRoundStatus(round, player, enemy);

                System.out.println();
                System.out.println("----------------- Player 1 Current Status --------------");
                printWithDelay("\n[" + player.getName() + "] Health: " + player.getHitpoints(), fastDelayPreset);
                printWithDelay("\n[" + player.getName() + "] Mana: " + player.getMana(), fastDelayPreset);

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
                            System.out.println("\n\t\tInvalid Input, Try Again!");
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
                printWithDelay("\n[" + enemy.getName() + "] Health: " + enemy.getHitpoints(), fastDelayPreset);
                printWithDelay("\n[" + enemy.getName() + "] Mana: " + enemy.getMana(), fastDelayPreset);

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
                            System.out.println("\n\t\tInvalid Input, Try Again!");
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
                }
            } while (isRunning);

            if (player.getHitpoints() > 0) {
                player1Win++;
                printWithDelay("\n" + player.getName() + " wins Round " + round + "!\n\n", mediumDelayPreset);
            } else {
                player2Win++;
                printWithDelay("\n" + enemy.getName() + " wins Round " + round + "!\n\n", mediumDelayPreset);
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
                            break;
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
                            System.exit(0);
                        } else {
                            throw new InputMismatchException();
                        }
                    } catch (InputMismatchException error) {
                        System.out.println("\n\t\tInvalid Input. Try again!");
                        scanner.nextLine();
                    }
                }
            }
        } while (ans != 'N' && round <= 3);
    }

    public void playerVsComputerBattleGameMode() {
        Player player = new Player();
        Enemy enemy = new Enemy();

        int playerChoice = playerCharacterChoiceInputHandler();
        switch (playerChoice) {
            case 1 -> player = new Player("Cosmic Dassel", "Provoked Punch", "Bug Overflow", "Overclock");
            case 2 -> player = new Player("Khylle The Reaper", "Karate Kick", "Flying Food", "Voice of Destruction");
            case 3 -> player = new Player("Earl", "Knee Strike", "Double Kick", "Dodge");
            case 4 -> player = new Player("The One John", "Upper Cut", "Counterpalm", "Flaring Punches");
            case 5 ->
                    player = new Player("And Rew", "Dragon Fist", "Dragon First Missiles", "Dragon's Verdict of Demise");
            case 6 -> player = new OPCharacter("OP Character", "OP Skill One", "OP Skill Two", "OP Skill Three");

        }

        printOrSkipNarrativeSegment(player);

        int enemyChoice = enemyCharacterChoiceInputHandler();
        switch (enemyChoice) {
            case 1 -> enemy = new Enemy("Kaniel Outis", "Image Burn", "Spirit Compression", "Sanity Drain");
            case 2 -> enemy = new Enemy("Van Berskville", "Stab", "Getsuga", "Fang Sword Style");
            case 3 ->
                    enemy = new Enemy("Asta Clover", "Demon Slayer Slash", "Demon Dweller Double Slash", "Demon Union");
            case 4 -> enemy = new Enemy("JF Void", "Void Chop", "Void Deflect", "Void Stagger Palm");
            case 5 -> enemy = new Enemy("Deidre", "Lightning Cut", "Thunder Cleave", "Final Turn");
        }

        printOrSkipNarrativeSegment(enemy);
        specialEncounterCounterPart(player, enemy);

        int round = 1;
        boolean isRunning = true;
        do {
            int playerSkillChoice = 0, enemySkillChoice = 0, newPlayerMana = 0, newEnemyMana = 0;

            showRoundStatus(round, player, enemy);

            System.out.println();
            //show both health and Mana
            System.out.println("------------------- Current Status -------------------");
            printWithDelay("\n[" + player.getName() + "] Health: " + player.getHitpoints(), fastDelayPreset);
            printWithDelay("\n[" + player.getName() + "] Mana: " + player.getMana(), fastDelayPreset);

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
                        System.out.println("\n\t\tInvalid Input, Try Again!");
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
            System.out.println("------------------ Current Status ------------------");
            printWithDelay("\n[" + enemy.getName() + "] Health: " + enemy.getHitpoints(), fastDelayPreset);
            printWithDelay("\n[" + enemy.getName() + "] Mana: " + enemy.getMana(), fastDelayPreset);

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

            newEnemyMana = random.nextInt(10, 21);
            enemy.increaseMana(newEnemyMana);

            printWithDelay("\n" + enemy.getName() + " regenerates " + newEnemyMana + " mana. (Mana: " + enemy.getMana() + ")", fastDelayPreset);

            player.reduceSkillOneCooldown();
            player.reduceSkillTwoCooldown();
            player.reduceSkillThreeCooldown();

            enemy.reduceSkillOneCooldown();
            enemy.reduceSkillTwoCooldown();
            enemy.reduceSkillThreeCooldown();
            round++;

            if (player.getHitpoints() <= 0 || enemy.getHitpoints() <= 0) {
                isRunning = false;
            }

        } while (isRunning);

        if (player.getHitpoints() > 0) {
            printWithDelay("\n" + player.getName() + " wins!\n\n", mediumDelayPreset);
        } else {
            printWithDelay("\n" + enemy.getName() + " wins!\n\n", mediumDelayPreset);
        }

    }

    public void arcadeBattleGameMode() {
        System.out.println("PLAYER VS COMPUTER BATTLE GAME MODE LOGIC HERE....");
    }


}
