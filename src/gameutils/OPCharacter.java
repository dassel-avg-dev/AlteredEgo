package gameutils;

public class OPCharacter extends Player implements Skills {

    public OPCharacter() {
        super();
    }

    public OPCharacter(String characterName, String skillOneName, String skillTwoName, String skillThreeName) {
        super(characterName, skillOneName, skillTwoName, skillThreeName);
    }

    @Override
    public int basicAttack() {
        int damage = 50;
        CO.printWithDelay("\n"+getName()+ " used Basic Attack: worth " +damage+ ", worth of damage!", delayValue);
        return damage;
    }

    @Override
    public int skillOne() {
        int damage = 100;
        CO.printWithDelay("\n"+getName()+ " used Skill One: " +getSkillOneName()+ ", worth " +damage+ " of damage!", delayValue);
        return damage;
    }

    @Override
    public int skillTwo() {
        int damage = 150;
        CO.printWithDelay("\n"+getName()+ " used Skill Two: " +getSkillTwoName()+ ", worth " +damage+ " of damage!", delayValue);
        return damage;
    }

    @Override
    public int skillThree() {
        int damage = 200;
        CO.printWithDelay("\n"+getName()+ " used Skill Three: " +getSkillThreeName()+ ", worth " +damage+ " of damage!", delayValue);
        return damage;
    }

}
