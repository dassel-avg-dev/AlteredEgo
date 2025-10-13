package main;
import gameutils.*;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    private static final int delayValue = 50;

    public static void main(String[] args) {
        ConsoleOutput CO = new ConsoleOutput();
        Player player = new Player();
        Enemy enemy = new Enemy();

        CO.gameTitle();

        while(true) {
            try {
                CO.playOrExitMenu();
                char playOrExit = scanner.next().charAt(0);
                playOrExit = Character.toUpperCase(playOrExit);
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
                System.out.println("\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        }

        int playerChoice = 0;
        while(true) {
            try {
                CO.characterChoices();
                playerChoice = scanner.nextInt();
                if(playerChoice < 1 || playerChoice > 5) {
                    throw new InputMismatchException();
                }
                else {
                    break;
                }
            }
            catch(InputMismatchException error) {
                System.out.println("\t\tInvalid Input. Try again!");
                scanner.nextLine();
            }
        }

        switch(playerChoice) {
            case 1 -> player = new Player("Cosmic Dassel", "Provoked Punch", "Bug Overflow", "Overclock");
            case 2 -> player = new Player("Khylle The Reaper", "Karate Kick", "Flying Food", "Voice of Destruction");
            case 3 -> player = new Player("Earl", "Knee Strike", "Double Kick", "Dodge");
            case 4 -> player = new Player("The One John", "Upper Cut", "Counterpalm", "Flaring Punches");
            case 5 -> player = new Player("And Rew", "Dragon Fist", "Dragon First Missiles", "Dragon's Verdict of Demise");
        }

        int enemyChoice = 0;
        while(true) {
            try {
                CO.enemyCharacterChoices();
                enemyChoice = scanner.nextInt();
                break;
            }
            catch(InputMismatchException e) {
                System.out.println("\t\tInvalid Input, Try Again!");
                scanner.nextLine();
            }
        }

        switch(enemyChoice) {
            case 1 -> enemy = new Enemy("Kaniel Outis", "Image Burn", "Spirit Compression", "Sanity Drain");
            case 2 -> enemy = new Enemy("Van Berskville", "Stab", "Parry", "Fang Sword Style");
            case 3 -> enemy = new Enemy("Asta Clover", "Arcane Blast", "Whirlwind", "Block");
            case 4 -> enemy = new Enemy("JF Void", "Void Chop", "Void Deflect", "Void Stagger Palm");
            case 5 -> enemy = new Enemy("Deidre", "Lightning Cut", "Thunder Cleave", "Final Turn");
        }

        boolean isRunning = true;
        do {
            int playerSkillChoice = 0, enemySkillChoice = 0, newPlayerMana = 0, newEnemyMana = 0;

            System.out.println();
            //show both health and Mana
            System.out.println("------------------- Current Status -------------------");
            CO.printWithDelay("\n[" + player.getName() + "] Health: " + player.getHitpoints(), delayValue);
            CO.printWithDelay("\n[" + player.getName() + "] Mana: " + player.getMana(), delayValue);

            boolean playerActed = false;

            while(!playerActed) {

                while(true) {
                    try {
                        CO.playerSkillChoices(player);
                        playerSkillChoice = scanner.nextInt();
                        if(playerSkillChoice < 0 || playerSkillChoice > 3) {
                            throw new InputMismatchException();
                        }
                        else {
                            break;
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("\t\tInvalid Input, Try Again!");
                        scanner.nextLine();
                    }
                }

                switch(playerSkillChoice) {
                    case 0 -> {
                        enemy.setHitpoints(player.basicAttack());
                        playerActed = true;
                    }
                    case 1 -> {
                        if (player.getSkillOneCooldown() > 0) {
                            CO.printWithDelay("\n" + player.getSkillOneName() + " is on cooldown! Choose again.", delayValue);
                            break;
                        }
                        else if (!player.isSkillOneUsable()) {
                            CO.printWithDelay("\nNot enough mana to use " + player.getSkillOneName() + "! Choose again.", delayValue);
                            break;
                        }
                        enemy.setHitpoints(player.skillOne());
                        player.reduceMana(player.getSKillOneManaUsage());
                        player.activateSkillOneCooldown();
                        playerActed = true;
                    }
                    case 2 -> {
                        if (player.getSkillTwoCooldown() > 0) {
                            CO.printWithDelay("\n" + player.getSkillTwoName() + " is on cooldown! Choose again.", delayValue);
                            break;
                        }
                        else if (!player.isSkillTwoUsable()) {
                            CO.printWithDelay("\nNot enough mana to use " + player.getSkillTwoName() + "! Choose again.", delayValue);
                            break;
                        }
                        enemy.setHitpoints(player.skillTwo());
                        player.reduceMana(player.getSKillTwoManaUsage());
                        player.activateSkillTwoCooldown();
                        playerActed = true;
                    }
                    case 3 -> {
                        if (player.getSkillThreeCooldown() > 0) {
                            CO.printWithDelay("\n" + player.getSkillThreeName() + " is on cooldown! Choose again.", delayValue);
                            break;
                        }
                        else if (!player.isSkillThreeUsable()) {
                            CO.printWithDelay("\nNot enough mana to use " + player.getSkillThreeName() + "! Choose again.", delayValue);
                            break;
                        }
                        enemy.setHitpoints(player.skillThree());
                        player.reduceMana(player.getSKillThreeManaUsage());
                        player.activateSkillThreeCooldown();
                        playerActed = true;
                    }
                }
            }

            if (enemy.getHitpoints() <= 0) {
                CO.printWithDelay("\n" + enemy.getName() + " has been defeated!", delayValue);
                break;
            }

            newPlayerMana = random.nextInt(25, 51);
            player.increaseMana(newPlayerMana);

            CO.printWithDelay("\n" + player.getName() + " regenerates " + newPlayerMana + " mana. (Mana: " + player.getMana() + ")", delayValue);

            System.out.println();
            System.out.println("------------------ Current Status ------------------");
            CO.printWithDelay("\n[" + enemy.getName() + "] Health: " + enemy.getHitpoints(), delayValue);
            CO.printWithDelay("\n[" + enemy.getName() + "] Mana: " + enemy.getMana(), delayValue);

            enemySkillChoice = random.nextInt(0, 4);
            CO.enemyRandomSkillChoice(enemy);

            switch(enemySkillChoice) {
                case 0 -> {
                    player.setHitpoints(enemy.basicAttack());
                }
                case 1 -> {
                    if (enemy.getSkillOneCooldown() == 0 && enemy.isSkillOneUsable()) {
                        player.setHitpoints(enemy.skillOne());
                        enemy.reduceMana(enemy.getSKillOneManaUsage());
                        enemy.activateSkillOneCooldown();
                    }
                    else if (enemy.getSkillOneCooldown() > 0) {
                        CO.printWithDelay("\n" + enemy.getName() + "'s " + enemy.getSkillOneName() + " is on cooldown!", delayValue);
                        player.setHitpoints(enemy.basicAttack());
                    }
                    else {
                        CO.printWithDelay("\n" + enemy.getName() + " tried to use " + enemy.getSkillOneName() + " but didn't have enough mana.", delayValue);
                        player.setHitpoints(enemy.basicAttack());
                    }
                }
                case 2 -> {
                    if (enemy.getSkillTwoCooldown() == 0 && enemy.isSkillTwoUsable()) {
                        player.setHitpoints(enemy.skillTwo());
                        enemy.reduceMana(enemy.getSKillTwoManaUsage());
                        enemy.activateSkillTwoCooldown();
                    }
                    else if (enemy.getSkillTwoCooldown() > 0) {
                        CO.printWithDelay("\n" + enemy.getName() + "'s " + enemy.getSkillTwoName() + " is on cooldown!", delayValue);
                        player.setHitpoints(enemy.basicAttack());
                    }
                    else {
                        CO.printWithDelay("\n" + enemy.getName() + " tried to use " + enemy.getSkillTwoName() + " but didn't have enough mana.", delayValue);
                        player.setHitpoints(enemy.basicAttack());
                    }
                }
                case 3 -> {
                    if (enemy.getSkillThreeCooldown() == 0 && enemy.isSkillThreeUsable()) {
                        player.setHitpoints(enemy.skillThree());
                        enemy.reduceMana(enemy.getSKillThreeManaUsage());
                        enemy.activateSkillThreeCooldown();
                    }
                    else if (enemy.getSkillThreeCooldown() > 0) {
                        CO.printWithDelay("\n" + enemy.getName() + "'s " + enemy.getSkillThreeName() + " is on cooldown!", delayValue);
                        player.setHitpoints(enemy.basicAttack());
                    }
                    else {
                        CO.printWithDelay("\n" + enemy.getName() + " tried to use " + enemy.getSkillThreeName() + " but didn't have enough mana.", delayValue);
                        player.setHitpoints(enemy.basicAttack());
                    }
                }
            }

            newEnemyMana = random.nextInt(10, 21);
            enemy.increaseMana(newEnemyMana);

            CO.printWithDelay("\n" + enemy.getName() + " regenerates " + newEnemyMana + " mana. (Mana: " + enemy.getMana() + ")", delayValue);

            player.reduceSkillOneCooldown();
            player.reduceSkillTwoCooldown();
            player.reduceSkillThreeCooldown();

            enemy.reduceSkillOneCooldown();
            enemy.reduceSkillTwoCooldown();
            enemy.reduceSkillThreeCooldown();

            if(player.getHitpoints() <= 0 || enemy.getHitpoints() <= 0) {
                isRunning = false;
            }

        } while(isRunning);

        if(player.getHitpoints() > 0) {
            CO.printWithDelay("\n" +player.getName()+ " wins!",90);
        }
        else {
            CO.printWithDelay("\n" +enemy.getName()+ " wins!",90);
        }

        scanner.close();
    }

}