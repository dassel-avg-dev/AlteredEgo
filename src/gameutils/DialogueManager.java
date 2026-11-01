package gameutils;

/**
 * Manages character intro monologues, counterpart encounter dialogues,
 * and skill activation monologues for all playable characters, enemies, and bosses.
 */
public class DialogueManager {
    private static final int DEFAULT_DELAY = 15;

    private DialogueManager() {
        // Utility class
    }

    public static void printIntroMonologue(GameCharacter character) {
        printIntroMonologue(character, DEFAULT_DELAY);
    }

    public static void printIntroMonologue(GameCharacter character, int delay) {
        if (character == null || character.getName() == null) {
            return;
        }
        System.out.println();
        switch (character.getName()) {
            case "Cosmic Dassel" ->
                    ConsoleOutput.printWithDelay("Cosmic Dassel: You're funny, I'll buy you!", delay);
            case "Khylle The Reaper" ->
                    ConsoleOutput.printWithDelay("Khylle The Reaper: I came to reap... but I was hungry", delay);
            case "Earl" ->
                    ConsoleOutput.printWithDelay("Earl: You chose me? Good boy", delay);
            case "The One John" ->
                    ConsoleOutput.printWithDelay("The One John: Help? Help yourself", delay);
            case "And Rew" ->
                    ConsoleOutput.printWithDelay("And Rew: Oh hell nah why me", delay);
            case "OP Character" ->
                    ConsoleOutput.printWithDelay("OP Character: Admin privileges enabled. Deleting opposition...", delay);
            case "Kaniel Outis" ->
                    ConsoleOutput.printWithDelay("Kaniel Outis: Who are you to decide to battle me?", delay);
            case "Van Berksville", "Van Berskville" ->
                    ConsoleOutput.printWithDelay("Van Berksville: I'll take my revenge!", delay);
            case "Asta Clover" ->
                    ConsoleOutput.printWithDelay("Asta Clover: I'll become the wizard king!", delay);
            case "JF Void" ->
                    ConsoleOutput.printWithDelay("JF Void: All paths end in nothing", delay);
            case "Deidre" ->
                    ConsoleOutput.printWithDelay("Deidre: I am the storm that is approaching", delay);
            case "Ohma Zi-O" ->
                    ConsoleOutput.printWithDelay("Ohma Zi-O: Rejoice! You stand before the Demon King of Time!", delay);
        }
    }

    public static boolean isDirectCounterpart(GameCharacter player, GameCharacter enemy) {
        if (player == null || enemy == null || player.getName() == null || enemy.getName() == null) {
            return false;
        }
        String playerName = player.getName();
        String enemyName = enemy.getName();

        return switch (playerName) {
            case "Cosmic Dassel" -> "Kaniel Outis".equals(enemyName);
            case "Khylle The Reaper" -> "Van Berksville".equals(enemyName) || "Van Berskville".equals(enemyName);
            case "Earl" -> "Asta Clover".equals(enemyName);
            case "The One John" -> "JF Void".equals(enemyName);
            case "And Rew" -> "Deidre".equals(enemyName);
            default -> false;
        };
    }

    public static void printCounterpartDialogue(GameCharacter player, GameCharacter enemy) {
        printCounterpartDialogue(player, enemy, DEFAULT_DELAY);
    }

    public static void printCounterpartDialogue(GameCharacter player, GameCharacter enemy, int delay) {
        if (player == null || enemy == null || player.getName() == null || enemy.getName() == null) {
            return;
        }

        switch (player.getName()) {
            case "Cosmic Dassel" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        ConsoleOutput.printWithDelay("\nCosmic Dassel: You're not even worth buying", delay);
                        ConsoleOutput.printWithDelay("\nKaniel Outis: You dare put a price on me? I'll make you regret it", delay);
                    }
                    case "Van Berksville", "Van Berskville" -> {
                        ConsoleOutput.printWithDelay("\nCosmic Dassel: I could use a mercenary -- I'll buy you", delay);
                        ConsoleOutput.printWithDelay("\nVan Berksville: I'll accept your limbs as down payment", delay);
                    }
                    case "Asta Clover" -> {
                        ConsoleOutput.printWithDelay("\nCosmic Dassel: I'll buy you, cash or check?", delay);
                        ConsoleOutput.printWithDelay("\nAsta Clover: You'll be paying by your head", delay);
                    }
                    case "JF Void" -> {
                        ConsoleOutput.printWithDelay("\nCosmic Dassel: I wouldn't even bother buying you for a discount", delay);
                        ConsoleOutput.printWithDelay("\nJF Void: Save your money for your funeral", delay);
                    }
                    case "Deidre" -> {
                        ConsoleOutput.printWithDelay("\nCosmic Dassel: Time is money and you're wasting mine", delay);
                        ConsoleOutput.printWithDelay("\nDeidre: I'll end your time", delay);
                    }
                    default -> ConsoleOutput.printWithDelay("\nThe atmosphere changed as they tense up......", delay);
                }
            }

            case "Khylle The Reaper" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        ConsoleOutput.printWithDelay("\nKhylle The Reaper: I will reap your soul", delay);
                        ConsoleOutput.printWithDelay("\nKaniel Outis: You will need more than that to scare me", delay);
                    }
                    case "Van Berksville", "Van Berskville" -> {
                        ConsoleOutput.printWithDelay("\nKhylle The Reaper: Your thirst for revenge will satisfy me", delay);
                        ConsoleOutput.printWithDelay("\nVan Berksville: Stand between me and my revenge and I'll send you to your maker!", delay);
                    }
                    case "Asta Clover" -> {
                        ConsoleOutput.printWithDelay("\nKhylle The Reaper: You'll end your journey here", delay);
                        ConsoleOutput.printWithDelay("\nAsta Clover: My journey just begun", delay);
                    }
                    case "JF Void" -> {
                        ConsoleOutput.printWithDelay("\nKhylle The Reaper: You smell of fear... I'm getting hungry", delay);
                        ConsoleOutput.printWithDelay("\nJF Void: Fear you? I'll shred you into nothing", delay);
                    }
                    case "Deidre" -> {
                        ConsoleOutput.printWithDelay("\nKhylle The Reaper: I will kill you", delay);
                        ConsoleOutput.printWithDelay("\nDeidre: You can't kill what's already dead", delay);
                    }
                    default -> ConsoleOutput.printWithDelay("\nThe atmosphere changed as they tense up......", delay);
                }
            }

            case "Earl" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        ConsoleOutput.printWithDelay("\nEarl: It doesn't have to be this way", delay);
                        ConsoleOutput.printWithDelay("\nKaniel Outis: Knave, kneel before me", delay);
                    }
                    case "Van Berksville", "Van Berskville" -> {
                        ConsoleOutput.printWithDelay("\nEarl: You got a scary face right there", delay);
                        ConsoleOutput.printWithDelay("\nVan Berksville: Your death will assist me in my revenge", delay);
                    }
                    case "Asta Clover" -> {
                        ConsoleOutput.printWithDelay("\nEarl: You? This gonna be worth it", delay);
                        ConsoleOutput.printWithDelay("\nAsta Clover: Let's fight till we die!", delay);
                    }
                    case "JF Void" -> {
                        ConsoleOutput.printWithDelay("\nEarl: This is gonna be a pain in the ass", delay);
                        ConsoleOutput.printWithDelay("\nJF Void: Here I am, wasting my time with a weakling", delay);
                    }
                    case "Deidre" -> {
                        ConsoleOutput.printWithDelay("\nEarl: You look familiar", delay);
                        ConsoleOutput.printWithDelay("\nDeidre: Don't compare me to the likes of him", delay);
                    }
                    default -> ConsoleOutput.printWithDelay("\nThe atmosphere changed as they tense up......", delay);
                }
            }

            case "The One John" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        ConsoleOutput.printWithDelay("\nThe One John: What the hell are you?", delay);
                        ConsoleOutput.printWithDelay("\nKaniel Outis: You're greatest demise", delay);
                    }
                    case "Van Berksville", "Van Berskville" -> {
                        ConsoleOutput.printWithDelay("\nThe One John: Revenge won't save you", delay);
                        ConsoleOutput.printWithDelay("\nVan Berksville: Then I'll kill you", delay);
                    }
                    case "Asta Clover" -> {
                        ConsoleOutput.printWithDelay("\nThe One John: This is gonna be easy", delay);
                        ConsoleOutput.printWithDelay("\nAsta Clover: I'll make sure to cut you slowly", delay);
                    }
                    case "JF Void" -> {
                        ConsoleOutput.printWithDelay("\nThe One John: The strongest have arrived", delay);
                        ConsoleOutput.printWithDelay("\nJF Void: 3 draws, no wins and loses, today will be your downfall", delay);
                    }
                    case "Deidre" -> {
                        ConsoleOutput.printWithDelay("\nThe One John: This is gonna be pain in the ass", delay);
                        ConsoleOutput.printWithDelay("\nDeidre: All bark and no bite", delay);
                    }
                    default -> ConsoleOutput.printWithDelay("\nThe atmosphere changed as they tense up......", delay);
                }
            }

            case "And Rew" -> {
                switch (enemy.getName()) {
                    case "Kaniel Outis" -> {
                        ConsoleOutput.printWithDelay("\nAnd Rew: All I see is a walking dead man", delay);
                        ConsoleOutput.printWithDelay("\nKaniel Outis: A dead man? Then let me drag you into the abyss!", delay);
                    }
                    case "Van Berksville", "Van Berskville" -> {
                        ConsoleOutput.printWithDelay("\nAnd Rew: ooohhh... vengeful guy i see", delay);
                        ConsoleOutput.printWithDelay("\nVan Berksville: Your a dead man I'm sending you straight to hell", delay);
                    }
                    case "Asta Clover" -> {
                        ConsoleOutput.printWithDelay("\nAnd Rew: Another guy who just won't give up", delay);
                        ConsoleOutput.printWithDelay("\nAsta Clover: I'll break your neck", delay);
                    }
                    case "JF Void" -> {
                        ConsoleOutput.printWithDelay("\nAnd Rew: You look strong, but I'm stronger", delay);
                        ConsoleOutput.printWithDelay("\nJF Void: I'll erase you from the history", delay);
                    }
                    case "Deidre" -> {
                        ConsoleOutput.printWithDelay("\nAnd Rew: Another relic", delay);
                        ConsoleOutput.printWithDelay("\nDeidre: This place isn't big enough for the two of us.", delay);
                    }
                    default -> ConsoleOutput.printWithDelay("\nThe atmosphere changed as they tense up......", delay);
                }
            }

            default -> ConsoleOutput.printWithDelay("\nThe atmosphere changed as they tense up......", delay);
        }
    }

    public static void printSkillUseMonologue(GameCharacter character, int skillChoice) {
        printSkillUseMonologue(character, skillChoice, DEFAULT_DELAY);
    }

    public static void printSkillUseMonologue(GameCharacter character, int skillChoice, int delay) {
        if (character == null || character.getName() == null) {
            return;
        }

        switch (character.getName()) {
            case "Cosmic Dassel" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nCosmic Dassel: I'm gonna put some bug in your eye.", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nCosmic Dassel: Look at little binary junior, gonna cry?", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nCosmic Dassel: Systems fail, error emerge, let thy bugs control, Bug Overflow", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nCosmic Dassel: Spend, Invest, Dominate, Overclock amplify my being", delay);
                }
            }

            case "Khylle The Reaper" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nKhylle The Reaper: Basic attack to test you", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nKhylle The Reaper: Karate Kick to your soul", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nKhylle The Reaper: Grave of gluttony let them cower thy souls, Flying food", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nKhylle The Reaper: Hear, your Eulogy, Voice of Destruction", delay);
                }
            }

            case "Earl" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nEarl: Haiyah!", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nEarl: One order of Knee Strike coming right up", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nEarl: On the double, double kick", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nEarl: (Dodge).... Too slow", delay);
                }
            }

            case "The One John" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nThe One John: Normal Punch!", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nThe One John: Your open!, Uppercut", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nThe One John: You'll hurt yourself, Counterpalm", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nThe One John: Ora ora ora ora ora ora ora ora!", delay);
                }
            }

            case "And Rew" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nAnd Rew: Baby dragon punch!", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nAnd Rew: Take this, Dragon Punch", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nAnd Rew: Let thy dragons find the mark, Dragon Missle", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nAnd Rew: All thy existence bow thy verdict; I call, I decided, I rule... Dragon's Verdict of Demise! ", delay);
                }
            }

            case "OP Character" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nOP Character: Casual keystroke.", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nOP Character: Executing One Tap!", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nOP Character: Formatting your existence -- System Wipe!", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nOP Character: Sudo rm -rf / -- Admin Override!", delay);
                }
            }

            case "Kaniel Outis" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nKaniel Outis: Take this basic attack!", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nKaniel Outis: Burn everything, let this burn into you, Image Burn", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nKaniel Outis: Squeeze thy soul till nothing", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nKaniel Outis: All vision, All minds... Succumb to despair", delay);
                }
            }

            case "Van Berksville", "Van Berskville" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nVan Berksville: Tch!", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nVan Berksville: Straight to heart", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nVan Berksville: Getsuga Tenshoo!", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nVan Berksville: Hidden Move, Fang Sword Style", delay);
                }
            }

            case "Asta Clover" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nAsta Clover: Not giving up is my magic!, Take this!....'HEADBUTTS'", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nAsta Clover: Not yet, not yet! I SAID NOT YET! SLASH... SLASH...", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nAsta Clover: If my previous attack had no effect, then eat this. SLASH SLASH", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nAsta Clover: Lets Go, Liebe. You and Me against the world...", delay);
                }
            }

            case "JF Void" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nJF Void: Hungry?, Eat My Knuckle Sandwich", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nJF Void: Return to nothing", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nJF Void: I bend reality for fun, Void deflect", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nJF Void: One move, one death", delay);
                }
            }

            case "Deidre" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nDeidre: Slash!", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nDeidre: 1 sword style iai, Lightning cut", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nDeidre: 2 handed 1 Sword Style, Thunder Cleave", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nDeidre: With this I'll finish everything, Final Turn", delay);
                }
            }

            case "Ohma Zi-O" -> {
                switch (skillChoice) {
                    case 0 -> ConsoleOutput.printWithDelay("\nOhma Zi-O: A mere flick of the hand!", delay);
                    case 1 -> ConsoleOutput.printWithDelay("\nOhma Zi-O: Time bends to my command -- Temporal Strike!", delay);
                    case 2 -> ConsoleOutput.printWithDelay("\nOhma Zi-O: Dimensional fabric, shatter -- Rift Crush!", delay);
                    case 3 -> ConsoleOutput.printWithDelay("\nOhma Zi-O: Finale Time! All Riders' power -- King's Judgment!", delay);
                }
            }
        }
    }
}
