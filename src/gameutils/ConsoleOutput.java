package gameutils;

public class ConsoleOutput {
    private static final int delayValue = 50;
    public ConsoleOutput() { }

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

    public void playOrExitMenu() {
        System.out.print("\n\t\tPress 'P' to Play or 'X' to Exit: ");
    }

    public void characterChoices() {
        System.out.println();
        System.out.println("----------------- Choose Your Character ----------------");
        System.out.println("\t\t[1] Cosmic Dassel");
        System.out.println("\t\t[2] Khylle The Reaper");
        System.out.println("\t\t[3] Earl");
        System.out.println("\t\t[4] The One John");
        System.out.println("\t\t[5] And Rew");
        System.out.print("\t\tEnter choice (1, 2, 3, 4, or 5): ");
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

//    public void printManaStatus(Enemy enemy, ArrayList<String> playerSkills) {
//
//    }
//
//    public void specialEncounterMonologue(Player player) {
//        System.out.println();
//    }
//
//    public void specialEncounterMonologue(Enemy enemy) {
//        System.out.println();
//    }


}
