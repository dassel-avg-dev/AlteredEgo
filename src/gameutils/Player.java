package gameutils;
import java.util.*;

public class Player extends GameCharacter implements Skills {
    static final int fastDelayPreset = 40;
    static final int mediumDelayPreset = 80;
    static final int slowDelayPreset = 120;
    public Random random = new Random();
    public ConsoleOutput CO = new ConsoleOutput();
    private String skillOneName;
    private String skillTwoName;
    private String skillThreeName;
    private int skillOneCooldown;
    private int skillTwoCooldown;
    private int skillThreeCooldown;
    private int skillOneManaUsage;
    private int skillTwoManaUsage;
    private int skillThreeManaUsage;
    private int resetSkillOneCooldown;
    private int resetSkillTwoCooldown;
    private int resetSkillThreeCooldown;

    public Player() {
        super("Unknown");
        this.skillOneName = "Unknown";
        this.skillTwoName = "Unknown";
        this.skillThreeName = "Unknown";
        this.skillOneCooldown = 0;
        this.skillTwoCooldown = 0;
        this.skillThreeCooldown = 0;
        this.skillOneManaUsage = 25;
        this.skillTwoManaUsage = 50;
        this.skillThreeManaUsage = 100;
        this.resetSkillOneCooldown = this.skillOneCooldown;
        this.resetSkillTwoCooldown = this.skillTwoCooldown;
        this.resetSkillThreeCooldown = this.skillThreeCooldown;
    }

    public Player(String characterName) {
        super(characterName);
        this.skillOneName = "Unknown";
        this.skillTwoName = "Unknown";
        this.skillThreeName = "Unknown";
        this.skillOneCooldown = 0;
        this.skillTwoCooldown = 0;
        this.skillThreeCooldown = 0;
        this.skillOneManaUsage = 25;
        this.skillTwoManaUsage = 50;
        this.skillThreeManaUsage = 100;
        this.resetSkillOneCooldown = this.skillOneCooldown;
        this.resetSkillTwoCooldown = this.skillTwoCooldown;
        this.resetSkillThreeCooldown = this.skillThreeCooldown;
    }

    public Player(String characterName, String skillOneName, String skillTwoName, String skillThreeName) {
        super(characterName);
        this.skillOneName = skillOneName;
        this.skillTwoName = skillTwoName;
        this.skillThreeName = skillThreeName;
        this.skillOneCooldown = 0;
        this.skillTwoCooldown = 0;
        this.skillThreeCooldown = 0;
        this.skillOneManaUsage = 25;
        this.skillTwoManaUsage = 50;
        this.skillThreeManaUsage = 100;
        this.resetSkillOneCooldown = this.skillOneCooldown;
        this.resetSkillTwoCooldown = this.skillTwoCooldown;
        this.resetSkillThreeCooldown = this.skillThreeCooldown;
    }

    public void setSkillOneName(String skillOneName) {
        this.skillOneName = skillOneName;
    }

    public void setSkillTwoName(String skillTwoName) {
        this.skillTwoName = skillTwoName;
    }

    public void setSkillThreeName(String skillThreeName) {
        this.skillThreeName = skillThreeName;
    }

    public String getSkillOneName() {
        return skillOneName;
    }

    public String getSkillTwoName() {
        return skillTwoName;
    }

    public void setSkillOneCooldown(int skillOneCooldown) {
        this.skillOneCooldown  = skillOneCooldown;
    }

    public void setSkillTwoCooldown(int skillTwoCooldown) {
        this.skillTwoCooldown  = skillTwoCooldown;
    }

    public void setSkillThreeCooldown(int skilThreeCooldown) {
        this.skillThreeCooldown  = skillThreeCooldown;
    }

    public String getSkillThreeName() {
        return skillThreeName;
    }

    public int getSkillOneCooldown() {
        return skillOneCooldown;
    }

    public int getSkillTwoCooldown() {
        return skillTwoCooldown;
    }

    public int getSkillThreeCooldown() {
        return skillThreeCooldown;
    }

    public void reduceSkillOneCooldown() {
        if (this.skillOneCooldown > 0) {
            this.skillOneCooldown--;
        }
    }

    public void reduceSkillTwoCooldown() {
        if (this.skillTwoCooldown > 0) {
            this.skillTwoCooldown--;
        }
    }

    public void reduceSkillThreeCooldown() {
        if (this.skillThreeCooldown > 0) {
            this.skillThreeCooldown--;
        }
    }

    @Override
    public int basicAttack() {
        int damage = random.nextInt(20, 31);
        CO.printWithDelay("\n"+getName()+ " used Basic Attack: " +damage+ " worth of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillOne() {
        int damage = random.nextInt(30, 41);
        CO.printWithDelay("\n"+getName()+ " used Skill One: " +getSkillOneName()+ ", worth " +damage+ " of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillTwo() {
        int damage = random.nextInt(40, 51);
        CO.printWithDelay("\n"+getName()+ " used Skill Two: " +getSkillTwoName()+ ", worth " +damage+ " of damage!", fastDelayPreset);
        return damage;
    }

    @Override
    public int skillThree() {
        int damage = random.nextInt(100, 151);
        CO.printWithDelay("\n"+getName()+ " used Skill Three: " +getSkillThreeName()+ ", worth " +damage+ " of damage!", fastDelayPreset);
        return damage;
    }

    public void activateSkillOneCooldown() {
        this.skillOneCooldown = 2;
    }
    public void activateSkillTwoCooldown(){
        this.skillTwoCooldown = 3;
    }
    public void activateSkillThreeCooldown() {
        this.skillThreeCooldown = 5;
    }

    public int getSkillOneManaUsage() {
        return skillOneManaUsage;
    }

    public int getSkillTwoManaUsage() {
        return skillTwoManaUsage;
    }

    public int getSkillThreeManaUsage() {
        return skillThreeManaUsage;
    }

    public boolean isSkillOneUsable() {
        return (getMana() >= this.skillOneManaUsage) ? true : false;
    }

    public boolean isSkillTwoUsable() {
        return (getMana() >= this.skillTwoManaUsage) ? true : false;
    }

    public boolean isSkillThreeUsable() {
        return (getMana() >= this.skillThreeManaUsage) ? true : false;
    }

    public void resetCoolDown() {
        this.skillOneCooldown = resetSkillOneCooldown;
        this.skillTwoCooldown = resetSkillTwoCooldown;
        this.skillThreeCooldown = resetSkillThreeCooldown;
    }

}