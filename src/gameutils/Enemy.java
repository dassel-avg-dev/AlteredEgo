package gameutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends GameCharacter {

    public Enemy() {
        super();
    }

    public Enemy(String characterName) {
        super(characterName);
    }

    public Enemy(String characterName, String skillOneName, String skillTwoName, String skillThreeName) {
        super(characterName, skillOneName, skillTwoName, skillThreeName);
    }

    public Enemy(
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

    public static Enemy createByChoice(int choice) {
        return switch (choice) {
            case 1 -> new Enemy(
                    "Kaniel Outis",
                    500,
                    220,
                    40,
                    50,
                    new Skill("Image Burn", 52, 62, 25, 2),
                    new Skill("Spirit Compression", 64, 74, 50, 3),
                    new Skill("Sanity Drain", 110, 150, 100, 5)
            );
            case 2 -> new Enemy(
                    "Van Berksville",
                    520,
                    200,
                    42,
                    52,
                    new Skill("Stab", 52, 64, 25, 2),
                    new Skill("Getsuga", 64, 76, 50, 3),
                    new Skill("Fang Sword Style", 110, 152, 100, 5)
            );
            case 3 -> new Enemy(
                    "Asta Clover",
                    530,
                    190,
                    44,
                    52,
                    new Skill("Demon Slayer Slash", 54, 64, 25, 2),
                    new Skill("Demon Dweller Double Slash", 64, 74, 50, 3),
                    new Skill("Demon Union", 112, 155, 100, 5)
            );
            case 4 -> new Enemy(
                    "JF Void",
                    500,
                    220,
                    40,
                    50,
                    new Skill("Void Chop", 52, 62, 25, 2),
                    new Skill("Void Deflect", 62, 74, 50, 3),
                    new Skill("Void Stagger Palm", 108, 150, 100, 5)
            );
            case 5 -> new Enemy(
                    "Deidre",
                    490,
                    210,
                    42,
                    52,
                    new Skill("Lightning Cut", 54, 64, 25, 2),
                    new Skill("Thunder Cleave", 65, 76, 50, 3),
                    new Skill("Final Turn", 115, 158, 100, 5)
            );
            default -> createByChoice(1);
        };
    }

    public static ArrayList<Enemy> createArcadeRoster() {
        ArrayList<Enemy> roster = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            roster.add(createByChoice(i));
        }
        return roster;
    }

    public static Enemy createFinalBoss() {
        return new Enemy(
                "Ohma Zi-O",
                1000,
                300,
                50,
                65,
                new Skill("Temporal Strike", 65, 80, 25, 2),
                new Skill("Rift Crush", 80, 100, 50, 3),
                new Skill("King's Judgment", 130, 180, 100, 5)
        );
    }

    public int chooseSmartSkill() {
        return chooseSmartSkill(this.random);
    }

    public int chooseSmartSkill(Random random) {
        List<Integer> weightedChoices = new ArrayList<>();
        weightedChoices.add(0);

        for (int skillIndex = 1; skillIndex <= 3; skillIndex++) {
            if (isSkillReadyAndAffordable(skillIndex)) {
                int weight = skillIndex + 1;
                for (int w = 0; w < weight; w++) {
                    weightedChoices.add(skillIndex);
                }
            }
        }

        Random rng = random != null ? random : this.random;
        return weightedChoices.get(rng.nextInt(weightedChoices.size()));
    }
}
