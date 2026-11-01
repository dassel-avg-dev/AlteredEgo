package main;

import gameutils.ConsoleOutput;

public class Main {

    public static void main(String[] args) {
        ConsoleOutput CO = new ConsoleOutput();

        boolean gameIsRunning = true;
        while (gameIsRunning) {
            CO.gameTitle();
            CO.loadingScreen();

            if (!CO.promptPlayOrExit()) {
                break;
            }

            int gameModeChoice = CO.gameModeChoiceInputHandler();

            switch (gameModeChoice) {
                case 1 -> CO.pvpBattleGameMode();
                case 2 -> CO.playerVsComputerBattleGameMode();
                case 3 -> CO.arcadeBattleGameMode();
            }

            gameIsRunning = CO.promptPlayAgain();
        }

        CO.printEndCredits();
    }
}
