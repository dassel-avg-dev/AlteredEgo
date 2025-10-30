package gameutils;
import java.util.*;

public class ConsoleOutput {
    static final int delayValue = 50;
    static final int slowDelayPreset = 300;
    static final int mediumDelayPreset = 150 ;
    static final int fastDelayPreset = 40;
    static Scanner scanner = new Scanner(System.in);
    public ConsoleOutput() { }

    // prints every character with delay
    public static void printWithDelay(String text, int delay) {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(delay);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public void gameTitle() {
        printWithDelay("---------------- WELCOME TO ALTERED EGO ----------------", delayValue);
        printWithDelay("--------- Fight Your Other Side or Suffer Forever ------", delayValue);
    }

    public void loadingScreen() {
        printWithDelay("\n\t\t\t\t\tLOADING GAME CONTENT......",50);
        System.out.println("1%                                                        100%");
        printWithDelay("[ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ]", 70);
    }

    public void playOrExitMenu() {
        System.out.print("\n\t\t\tPress 'P' to Play or 'X' to Exit: ");
    }

    public void printPlayOrExitMenu() {
        while(true) {
            try {
                playOrExitMenu();
                char playOrExit = scanner.next().toUpperCase().charAt(0);
                if(playOrExit == 'X') {
                    System.exit(1);
                }
                else if(playOrExit == 'P'){
                    break;
                }
                else {
                    throw new InputMismatchException();
                }
            }
            catch(InputMismatchException error) {
                System.out.println("\n\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        }
    }

    public void playerSkillChoices(Player player) {
        System.out.println();
        System.out.println("----------------- Choose Skill to use ------------------");
        System.out.println("\t\t[0] Basic Attack");
        System.out.println("\t\t[1] Skill One: " + player.getSkillOneName());
        System.out.println("\t\t[2] SKill Two: " + player.getSkillTwoName());
        System.out.println("\t\t[3] Skill Three: " + player.getSkillThreeName());
        System.out.print("\t\tEnter choice (0, 1, 2, or 3): ");
    }

    public void characterChoices() {
        System.out.println();
        System.out.println("----------------- Choose Your Character ----------------");
        System.out.println("\t\t[1] Cosmic Dassel");
        System.out.println("\t\t[2] Khylle The Reaper");
        System.out.println("\t\t[3] Earl");
        System.out.println("\t\t[4] The One John");
        System.out.println("\t\t[5] And Rew");
        System.out.println("\t\t[6] OP Character");
        System.out.print("\t\tEnter choice (1, 2, 3, 4, 5 or 6): ");
    }

    public void enemyCharacterChoices() {
        System.out.println();
        System.out.println("------------------ Choose Your Enemy ------------------");
        System.out.println("\t\t[1] Kaniel Outis");
        System.out.println("\t\t[2] Van Berksville");
        System.out.println("\t\t[3] Asta Clover");
        System.out.println("\t\t[4] JF Void");
        System.out.println("\t\t[5] Deidre");
        System.out.print("\t\tEnter (1, 2, 3, 4, or 5): ");
    }

    // wrap up function for player character choice integer input
    public int playerCharacterChoiceInputHandler() {
        int playerChoice = 0;
        while(true) {
            try {
                characterChoices();
                playerChoice = scanner.nextInt();
                if(playerChoice < 1 || playerChoice > 6) {
                    throw new InputMismatchException();
                }
                else {
                    break;
                }
            }
            catch(InputMismatchException error) {
                System.out.println("\n\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        }
        return playerChoice;
    }

    // wrap up function for enemy character choice integer input
    public int enemyCharacterChoiceInputHandler() {
        int enemyChoice = 0;
        while(true) {
            try {
                enemyCharacterChoices();
                enemyChoice = scanner.nextInt();
                break;
            }
            catch(InputMismatchException e) {
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
                System.out.print("\nSkip narrative segment (Y / N): ");
                skipSegmentChoice = scanner.next().toUpperCase().charAt(0);
                if (skipSegmentChoice == 'N') {
                    specialEncounterMonologue(player);
                    break;
                }
                else if (skipSegmentChoice != 'Y') {
                    System.out.println("\n\t\t\tInvalid Input. Try again!");
                }
                else {
                    break;
                }
            }
            catch (InputMismatchException error) {
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
                System.out.print("\nSkip narrative segment (Y / N): ");
                skipSegmentChoice = scanner.next().toUpperCase().charAt(0);
                if (skipSegmentChoice == 'N') {
                    specialEncounterMonologue(enemy);
                    break;
                }
                else if (skipSegmentChoice != 'Y') {
                    System.out.println("\n\t\t\tInvalid Input. Try again!");
                }
                else {
                    break;
                }
            }
            catch (InputMismatchException error) {
                System.out.println("\n\t\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        } while (skipSegmentChoice != 'Y');
    }

    public void enemyRandomSkillChoice(Enemy enemy) {
        System.out.println();
        System.out.println("------------- " +enemy.getName()+"'s Skills: ------------");
        System.out.println("\t\t[0] Basic Attack");
        System.out.println("\t\t[1] Skill One: " + enemy.getSkillOneName());
        System.out.println("\t\t[2] Skill Two: " + enemy.getSkillTwoName());
        System.out.println("\t\t[3] Skill Three: " + enemy.getSkillThreeName());
        System.out.println();
        printWithDelay(enemy.getName()+ " is preparing for a counter attack..........", delayValue);
    }

    public void specialEncounterMonologue(Player player) {
        System.out.println();
        switch (player.getName()) {
            case "Cosmic Dassel" -> printWithDelay("Cosmic Dassel: You're funny, I'll buy you!", 50);
            case "Khylle The Reaper" -> printWithDelay("Khylle The Reaper: I came to reap... but I was hungry", 50);
            case "Earl" -> printWithDelay("Earl: You chose me? Good boy", 50);
            case "The One John" -> printWithDelay("The One John: Help? Help yourself", 50);
            case "And Rew" -> printWithDelay("And Rew: Oh hell nah why me", 50);
        }
    }

    public void specialEncounterMonologue(Enemy enemy) {
        System.out.println();
        switch (enemy.getName()) {
            case "Kaniel Outis" -> printWithDelay("Kaniel Outis: Who are you to decided to battle me?", 50);

            case "Van Berskville" -> printWithDelay("Van Berskville: I'll take my revenge!", 50);

            case "Asta Clover" -> printWithDelay("Asta Clover: I'll become the wizard king!", 50);

            case "JF Void" -> printWithDelay("JF Void: All path ends to nothing", 50);

            case "Deidre" -> printWithDelay("Deidre: I am the storm that is approaching", 50);

        }
    }

    public void specialEncounterCounterPart(Player player, Enemy enemy) {
        System.out.println();
        printWithDelay("\t\t\tINTERACTION PHASE\n", 50);
        switch (player.getName()) {
            case "Cosmic Dassel" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        printWithDelay("Cosmic Dassel: You're not even worth buying", 50);
                        printWithDelay("Kaniel Outis: You dare put a price on me? I'll make you regret it", 50);
                    }
                    case "Van Berskville" -> {
                        printWithDelay("Cosmic Dassel: I could use a mercenary — I'll buy you", 50);
                        printWithDelay("Van Berskville: I'll accept your limbs as down payment", 50);
                    }
                    case "Asta Clover" -> {
                        printWithDelay("Cosmic Dassel: I'll buy you, cash or check?", 50);
                        printWithDelay("Asta Clover: You'll be paying by your head", 50);
                    }
                    case "JF Void" -> {
                        printWithDelay("Cosmic Dassel: I wouldn't even bother buying you for a discount", 50);
                        printWithDelay("JF Void: Save your money for your funeral", 50);
                    }
                    case "Deidre" -> {
                        printWithDelay("Cosmic Dassel: Time is money and you're wasting mine", 50);
                        printWithDelay("Deidre: I'll end your time", 50);
                    }
                }
            }

            case "Khylle The Reaper" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        printWithDelay("Khylle The Reaper: I will reap your soul", 50);
                        printWithDelay("Kaniel Outis: You will need more than that to scare me", 50);
                    }
                    case "Van Berskville" -> {
                        printWithDelay("Khylle The Reaper: Your thirst for revenge will satisfy me", 50);
                        printWithDelay("Van Berskville: Stand between me and my revenge and I'll send you to your maker!", 50);
                    }
                    case "Asta Clover" -> {
                        printWithDelay("Khylle The Reaper: You'll end your journey here", 50);
                        printWithDelay("Asta Clover: My journey just begun", 50);
                    }
                    case "JF Void" -> {
                        printWithDelay("Khylle The Reaper: You smell of fear... I'm getting hungry", 50);
                        printWithDelay("JF Void: Fear you? I'll shred you into nothing", 50);
                    }
                    case "Deidre" -> {
                        printWithDelay("Khylle The Reaper: I will kill you", 50);
                        printWithDelay("Deidre: You can't kill what's already dead", 50);
                    }
                }
            }

            case "Earl" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        printWithDelay("Earl: It doesn't have to be this way", 50);
                        printWithDelay("Kaniel Outis: Knave, kneel before me", 50);
                    }
                    case "Van Berskville" -> {
                        printWithDelay("Earl: You got a scary face right there", 50);
                        printWithDelay("Van Berskville: Your death will assist me in my revenge", 50);
                    }
                    case "Asta Clover" -> {
                        printWithDelay("Earl: You? This gonna be worth it", 50);
                        printWithDelay("Asta Clover: Let's fight till we die!", 50);
                    }
                    case "JF Void" -> {
                        printWithDelay("Earl: This is gonna be a pain in the ass", 50);
                        printWithDelay("JF Void: Here I am, wasting my time with a weakling", 50);
                    }
                    case "Deidre" -> {
                        printWithDelay("Earl: You look familiar", 50);
                        printWithDelay("Deidre: Don't compare me to the likes of him", 50);
                    }
                }
            }

            case "The One John" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        printWithDelay("The One John: What the hell are you?", 50);
                        printWithDelay("Kaniel Outis: You're greatest demise", 50);
                    }
                    case "Van Berskville" -> {
                        printWithDelay("The One John: Revenge won’t save you", 50);
                        printWithDelay("Van Berskville: Then I'll kill you", 50);
                    }
                    case "Asta Clover" -> {
                        printWithDelay("The One John: This is gonna be easy", 50);
                        printWithDelay("Asta Clover: I'll make sure to cut you slowly", 50);
                    }
                    case "JF Void" -> {
                        printWithDelay("The One John: The strongest have arrived", 50);
                        printWithDelay("JF Void: 3 draws, no wins and loses, today will be your downfall", 50);
                    }
                    case "Deidre" -> {
                        printWithDelay("The One John: This is gonna be pain in the ass", 50);
                        printWithDelay("Deidre: All bark and no bite", 50);
                    }
                }
            }

            case "And Rew" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        printWithDelay("And Rew: All I see is a walking dead man", 50);
                        printWithDelay("Kaniel Outis: ", 50);
                    }
                    case "Van Berskville" -> {
                        printWithDelay("And Rew: ooohhh... vengeful guy i see", 50);
                        printWithDelay("Van Berskville: Your a dead man I'm sending you straight to hell", 50);
                    }
                    case "Asta Clover" -> {
                        printWithDelay("And Rew: Another guy who just won't give up", 50);
                        printWithDelay("Asta Clover: I'll break your neck", 50);
                    }
                    case "JF Void" -> {
                        printWithDelay("And Rew: You look strong, but I'm stronger", 50);
                        printWithDelay("JF Void: I'll erase you from the history", 50);
                    }
                    case "Deidre" -> {
                        printWithDelay("And Rew: Another relic", 50);
                        printWithDelay("Deidre: ", 50);
                    }
                }
            }

            default -> printWithDelay("The atmosphere changed as they tense up......", 50);
        }
     }

    public void playerSkillUseMonologue(Player player, int skillChoice) {
        System.out.println();
        switch (player.getName()) {
            case "Cosmic Dassel" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Cosmic Dassel: I'm gonna put some bug in your eye.", 50);
                    case 1 -> printWithDelay("Cosmic Dassel: Look at little binary junior, gonna cry?", 50);
                    case 2 -> printWithDelay("Cosmic Dassel: Systems fail, error emerge, let thy bugs control, Bug Overflow", 50);
                    case 3 -> printWithDelay("Cosmic Dassel: Spend, Invest, Dominate, Overclock amplify my being", 50);
                }
            }

            case "Khylle The Reaper" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Khylle The Reaper: Basic attack to test you", 50);
                    case 1 -> printWithDelay("Khylle The Reaper: Karate Kick to your soul", 50);
                    case 2 -> printWithDelay("Khylle The Reaper: Grave of gluttony let them cower thy souls, Flying food", 50);
                    case 3 -> printWithDelay("Khylle The Reaper: Hear, your Eulogy, Voice of Destruction", 50);
                }
            }

            case "Earl" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Earl: Haiyah!", 50);
                    case 1 -> printWithDelay("Earl: One order of Knee Strike coming right up", 50);
                    case 2 -> printWithDelay("Earl: On the double, double kick", 50);
                    case 3 -> printWithDelay("Earl: (Dodge).... Too slow", 50);
                }
            }

            case "The One John" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("The One John: Normal Punch!", 50);
                    case 1 -> printWithDelay("The One John: Your open!, Uppercut", 50);
                    case 2 -> printWithDelay("The One John: You'll hurt yourself, Counterpalm", 50);
                    case 3 -> printWithDelay("The One John: Ora ora ora ora ora ora ora ora!", 50);
                }
            }

            case "And Rew" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("And Rew: Baby dragon punch!", 50);
                    case 1 -> printWithDelay("And Rew: Take this, Dragon Punch", 50);
                    case 2 -> printWithDelay("And Rew: Let thy dragons find the mark, Dragon Missle", 50);
                    case 3 -> printWithDelay("And Rew: All thy existence bow thy verdict; I call, I decided, I rule... Dragon's Verdict of Demise! ", 50);
                }
            }
        }
    }

    public void enemySkillUseMonologue(Enemy enemy, int skillChoice) {
        switch (enemy.getName()) {
            case "Kaniel Outis" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Kaniel Outis: Take this basic attack!", 50);
                    case 1 -> printWithDelay("Kaniel Outis: Burn everything, let this burn into you, Image Burn", 50);
                    case 2 -> printWithDelay("Kaniel Outis: Squeeze thy soul till nothing", 50);
                    case 3 -> printWithDelay("Kaniel Outis: All vision, All minds... Succumb to despair", 50);
                }
            }
            case "Van Berskville" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Van Berskville: Tch!", 50);
                    case 1 -> printWithDelay("Van Berskville: Straight to heart", 50);
                    case 2 -> printWithDelay("Van Berskville: Getsuga Tenshoo!", 50);
                    case 3 -> printWithDelay("Van Berskville: Hidden Move, Fang Sword Style", 50);
                }
            }
            case "Asta Clover" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Asta Clover: Magic Blast", 50);
                    case 1 -> printWithDelay("Asta Clover: Magic ignite!, Arcane Blast", 50);
                    case 2 -> printWithDelay("Asta Clover: Spin, Slash, Strike, Whirlwind", 50);
                    case 3 -> printWithDelay("Asta Clover: (Blocks), no damage", 50);
                }
            }
            case "JF Void" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("JF Void: Hungry?, Eat My Knuckle Sandwich", 50);
                    case 1 -> printWithDelay("JF Void: Return to nothing", 50);
                    case 2 -> printWithDelay("JF Void: I bend reality for fun, Void deflect", 50);
                    case 3 -> printWithDelay("JF Void: One move, one death", 50);
                }
            }
            case "Deidre" -> {
                switch (skillChoice) {
                    case 0 -> printWithDelay("Deidre: Slash!", 50);
                    case 1 -> printWithDelay("Deidre: 1 sword style iai, Lightning cut", 50);
                    case 2 -> printWithDelay("Deidre: 2 handed 1 Sword Style, Thunder Cleave", 50);
                    case 3 -> printWithDelay("Deidre: With this I'll finish everything, Final Turn", 50);
                }
            }
        }
    }

//    public void pvpBattleGameMode(Player player, Enemy enemy) {
//
//    }
//
//    public void playerVsComputerBattleGameMode(Player player, Enemy enemy) {
//
//    }
//
//    public void arcadeBatlleGameMode(Player player, Enemy enemy) {
//
//    }


}
