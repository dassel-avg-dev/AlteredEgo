package main;

import gameutils.*;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        ConsoleOutput CO = new ConsoleOutput();

        boolean gameIsRunning = true;
        do {
            CO.gameTitle();
            CO.loadingScreen();
            CO.printPlayOrExitMenu();

            int gameModeChoice = CO.gameModeChoiceInputHandler();

            switch (gameModeChoice) {
                case 1 -> CO.pvpBattleGameMode();
                case 2 -> CO.playerVsComputerBattleGameMode();
                case 3 -> CO.arcadeBattleGameMode();
            }

            char playAgainOrExitChoice = '0';
            while (true) {
                try {
                    System.out.print("\n\t\t\tWOULD YOU LIKE TO PLAY AGAIN? (Y / N): ");
                    playAgainOrExitChoice = scanner.next().toUpperCase().charAt(0);
                    if (playAgainOrExitChoice == 'Y') {
                        System.out.println("\n\n\n");
                        break;
                    } else if (playAgainOrExitChoice == 'N') {
                        gameIsRunning = false;
                        break;
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\t\t\tInvalid Input, Try Again!");
                    scanner.nextLine();
                }
            }
        } while (gameIsRunning);

        scanner.close();
    }

}