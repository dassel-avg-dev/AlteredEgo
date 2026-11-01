package gameutils;

public class OPCharacter extends Player {

    public OPCharacter() {
        this("OP Character", "One Tap", "System Wipe", "Admin Override");
    }

    public OPCharacter(String characterName, String skillOneName, String skillTwoName, String skillThreeName) {
        super(
                characterName,
                1000,
                500,
                50,
                50,
                new Skill(skillOneName, 100, 100, 25, 1),
                new Skill(skillTwoName, 150, 150, 50, 2),
                new Skill(skillThreeName, 500, 500, 100, 3)
        );
    }

    @Override
    public int basicAttack() {
        int damage = 50;
        ConsoleOutput.printWithDelay("\n" + getName() + " used Basic Attack: " + damage + " worth of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillOne() {
        int damage = 100;
        ConsoleOutput.printWithDelay("\n" + getName() + " used Skill One: " + getSkillOneName() + ", worth " + damage + " of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillTwo() {
        int damage = 150;
        ConsoleOutput.printWithDelay("\n" + getName() + " used Skill Two: " + getSkillTwoName() + ", worth " + damage + " of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillThree() {
        int damage = 500;
        ConsoleOutput.printWithDelay("\n" + getName() + " used Skill Three: " + getSkillThreeName() + ", worth " + damage + " of damage!", fastDelayPreset);
        return damage;
    }
}
