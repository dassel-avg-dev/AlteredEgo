package gameutils;

public class Player extends GameCharacter {

    public Player() {
        super();
    }

    public Player(String characterName) {
        super(characterName);
    }

    public Player(String characterName, String skillOneName, String skillTwoName, String skillThreeName) {
        super(characterName, skillOneName, skillTwoName, skillThreeName);
    }

    public Player(
            String characterName,
            int maxHitpoints,
            int maxMana,
            int basicMinDamage,
            int basicMaxDamage,
            Skill skillOne,
            Skill skillTwo,
            Skill skillThree
    ) {
        super(characterName, maxHitpoints, maxMana, basicMinDamage, basicMaxDamage, skillOne, skillTwo, skillThree);
    }

    @Override
    public int skillThree() {
        int damage = super.skillThree();
        if ("Dodge".equals(getSkillThreeName())) {
            heal(35);
            ConsoleOutput.printWithDelay(
                    getName() + " recovered 35 HP while dodging and countering! (HP: " + getHitpoints() + "/" + getMaxHitpoints() + ")",
                    fastDelayPreset
            );
        }
        return damage;
    }

    public static Player createByChoice(int choice) {
        return switch (choice) {
            case 0 -> new OPCharacter();
            case 1 -> new Player(
                    "Cosmic Dassel",
                    500,
                    220,
                    40,
                    50,
                    new Skill("Provoked Punch", 52, 62, 25, 2),
                    new Skill("Bug Overflow", 64, 74, 50, 3),
                    new Skill("Overclock", 110, 150, 100, 5)
            );
            case 2 -> new Player(
                    "Khylle The Reaper",
                    480,
                    200,
                    42,
                    52,
                    new Skill("Karate Kick", 54, 64, 25, 2),
                    new Skill("Flying Food", 65, 78, 50, 3),
                    new Skill("Voice of Destruction", 115, 160, 100, 5)
            );
            case 3 -> new Player(
                    "Earl",
                    520,
                    200,
                    40,
                    50,
                    new Skill("Knee Strike", 50, 62, 25, 2),
                    new Skill("Double Kick", 62, 74, 50, 3),
                    new Skill("Dodge", 100, 140, 90, 4)
            );
            case 4 -> new Player(
                    "The One John",
                    550,
                    190,
                    44,
                    52,
                    new Skill("Upper Cut", 52, 62, 25, 2),
                    new Skill("Counterpalm", 62, 72, 50, 3),
                    new Skill("Flaring Punches", 105, 150, 100, 5)
            );
            case 5 -> new Player(
                    "And Rew",
                    490,
                    230,
                    40,
                    48,
                    new Skill("Dragon Fist", 52, 64, 25, 2),
                    new Skill("Dragon Fist Missiles", 65, 76, 50, 3),
                    new Skill("Dragon's Verdict of Demise", 112, 155, 100, 5)
            );
            default -> createByChoice(1);
        };
    }
}
