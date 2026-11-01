package gameutils;

import java.util.Random;

public abstract class GameCharacter implements Skills {
    public static final int fastDelayPreset = 40;
    public static final int mediumDelayPreset = 80;
    public static final int slowDelayPreset = 120;

    protected final Random random = new Random();
    private String name;
    private int hitpoints;
    private int maxHitpoints;
    private int mana;
    private int maxMana;
    private int basicMinDamage;
    private int basicMaxDamage;
    private Skill skillOne;
    private Skill skillTwo;
    private Skill skillThree;
    private boolean defeated;

    public GameCharacter() {
        this("Unknown", "Unknown", "Unknown", "Unknown");
    }

    public GameCharacter(String name) {
        this(name, "Unknown", "Unknown", "Unknown");
    }

    public GameCharacter(String name, String skillOneName, String skillTwoName, String skillThreeName) {
        this(
                name,
                500,
                200,
                40,
                50,
                new Skill(skillOneName, 50, 60, 25, 2),
                new Skill(skillTwoName, 60, 70, 50, 3),
                new Skill(skillThreeName, 100, 150, 100, 5)
        );
    }

    public GameCharacter(
            String name,
            int maxHitpoints,
            int maxMana,
            int basicMinDamage,
            int basicMaxDamage,
            Skill skillOne,
            Skill skillTwo,
            Skill skillThree
    ) {
        this.name = name;
        this.maxHitpoints = Math.max(1, maxHitpoints);
        this.hitpoints = this.maxHitpoints;
        this.maxMana = Math.max(0, maxMana);
        this.mana = this.maxMana;
        this.basicMinDamage = basicMinDamage;
        this.basicMaxDamage = basicMaxDamage;
        this.skillOne = skillOne;
        this.skillTwo = skillTwo;
        this.skillThree = skillThree;
        this.defeated = false;
    }

    public String getName() {
        return name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int getMaxHitpoints() {
        return maxHitpoints;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void takeDamage(int damage) {
        this.hitpoints = Math.max(0, this.hitpoints - Math.max(0, damage));
    }

    public void setHitpoints(int newHitpoints) {
        this.hitpoints = Math.max(0, newHitpoints);
        if (newHitpoints > this.maxHitpoints) {
            this.maxHitpoints = newHitpoints;
        }
    }

    public void setMaxHitpoints(int maxHitpoints) {
        this.maxHitpoints = Math.max(1, maxHitpoints);
    }

    public void setMana(int newMana) {
        this.mana = Math.max(0, newMana);
        if (newMana > this.maxMana) {
            this.maxMana = newMana;
        }
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = Math.max(0, maxMana);
    }

    public void reduceMana(int amount) {
        this.mana = Math.max(0, this.mana - Math.max(0, amount));
    }

    public void increaseMana(int amount) {
        this.mana = Math.min(this.maxMana, this.mana + Math.max(0, amount));
    }

    public void heal(int amount) {
        this.hitpoints = Math.min(this.maxHitpoints, this.hitpoints + Math.max(0, amount));
    }

    public void resetStats() {
        this.hitpoints = this.maxHitpoints;
        this.mana = this.maxMana;
        this.defeated = false;
    }

    public Skill getSkill(int index) {
        return switch (index) {
            case 1 -> skillOne;
            case 2 -> skillTwo;
            case 3 -> skillThree;
            default -> null;
        };
    }

    public int getBasicMinDamage() {
        return basicMinDamage;
    }

    public int getBasicMaxDamage() {
        return basicMaxDamage;
    }

    public String getDamageRange(int skillIndex) {
        if (skillIndex == 0) {
            return "(Min: " + basicMinDamage + " | Max: " + basicMaxDamage + ")";
        }
        Skill skill = getSkill(skillIndex);
        if (skill != null) {
            return skill.getDamageRangeString();
        }
        return "(Min: ? | Max: ?)";
    }

    public String getSkillOneName() {
        return skillOne.getName();
    }

    public String getSkillTwoName() {
        return skillTwo.getName();
    }

    public String getSkillThreeName() {
        return skillThree.getName();
    }

    public void setSkillOneName(String skillOneName) {
        this.skillOne.setName(skillOneName);
    }

    public void setSkillTwoName(String skillTwoName) {
        this.skillTwo.setName(skillTwoName);
    }

    public void setSkillThreeName(String skillThreeName) {
        this.skillThree.setName(skillThreeName);
    }

    public int getSkillOneCooldown() {
        return skillOne.getCurrentCooldown();
    }

    public int getSkillTwoCooldown() {
        return skillTwo.getCurrentCooldown();
    }

    public int getSkillThreeCooldown() {
        return skillThree.getCurrentCooldown();
    }

    public void setSkillOneCooldown(int skillOneCooldown) {
        this.skillOne.setCurrentCooldown(skillOneCooldown);
    }

    public void setSkillTwoCooldown(int skillTwoCooldown) {
        this.skillTwo.setCurrentCooldown(skillTwoCooldown);
    }

    public void setSkillThreeCooldown(int skillThreeCooldown) {
        this.skillThree.setCurrentCooldown(skillThreeCooldown);
    }

    public void reduceSkillOneCooldown() {
        this.skillOne.reduceCooldown();
    }

    public void reduceSkillTwoCooldown() {
        this.skillTwo.reduceCooldown();
    }

    public void reduceSkillThreeCooldown() {
        this.skillThree.reduceCooldown();
    }

    public void reduceAllCooldowns() {
        reduceSkillOneCooldown();
        reduceSkillTwoCooldown();
        reduceSkillThreeCooldown();
    }

    public void activateSkillOneCooldown() {
        this.skillOne.activateCooldown();
    }

    public void activateSkillTwoCooldown() {
        this.skillTwo.activateCooldown();
    }

    public void activateSkillThreeCooldown() {
        this.skillThree.activateCooldown();
    }

    public int getSkillOneManaUsage() {
        return skillOne.getManaCost();
    }

    public int getSkillTwoManaUsage() {
        return skillTwo.getManaCost();
    }

    public int getSkillThreeManaUsage() {
        return skillThree.getManaCost();
    }

    public boolean isSkillOneUsable() {
        return getMana() >= skillOne.getManaCost();
    }

    public boolean isSkillTwoUsable() {
        return getMana() >= skillTwo.getManaCost();
    }

    public boolean isSkillThreeUsable() {
        return getMana() >= skillThree.getManaCost();
    }

    public boolean isSkillReadyAndAffordable(int skillIndex) {
        if (skillIndex == 0) {
            return true;
        }
        Skill skill = getSkill(skillIndex);
        return skill != null && skill.isUsable(getMana());
    }

    public void resetCoolDown() {
        skillOne.resetCooldown();
        skillTwo.resetCooldown();
        skillThree.resetCooldown();
    }

    public boolean isDefeated() {
        return this.defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    @Override
    public int basicAttack() {
        int damage = basicMinDamage >= basicMaxDamage
                ? basicMinDamage
                : random.nextInt(basicMinDamage, basicMaxDamage + 1);
        ConsoleOutput.printWithDelay("\n" + getName() + " used Basic Attack: " + damage + " worth of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillOne() {
        int damage = skillOne.rollDamage(random);
        ConsoleOutput.printWithDelay("\n" + getName() + " used Skill One: " + getSkillOneName() + ", worth " + damage + " of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillTwo() {
        int damage = skillTwo.rollDamage(random);
        ConsoleOutput.printWithDelay("\n" + getName() + " used Skill Two: " + getSkillTwoName() + ", worth " + damage + " of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillThree() {
        int damage = skillThree.rollDamage(random);
        ConsoleOutput.printWithDelay("\n" + getName() + " used Skill Three: " + getSkillThreeName() + ", worth " + damage + " of damage!", fastDelayPreset);
        return damage;
    }

    public int useSkill(int skillIndex) {
        return switch (skillIndex) {
            case 0 -> basicAttack();
            case 1 -> {
                int dmg = skillOne();
                reduceMana(getSkillOneManaUsage());
                activateSkillOneCooldown();
                yield dmg;
            }
            case 2 -> {
                int dmg = skillTwo();
                reduceMana(getSkillTwoManaUsage());
                activateSkillTwoCooldown();
                yield dmg;
            }
            case 3 -> {
                int dmg = skillThree();
                reduceMana(getSkillThreeManaUsage());
                activateSkillThreeCooldown();
                yield dmg;
            }
            default -> basicAttack();
        };
    }
}
