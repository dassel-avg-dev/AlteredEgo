package gameutils;

public abstract class GameCharacter {
    private String name;
    private int hitpoints;
    private int mana;

    // if no value passed in the constructor
    public GameCharacter() {
        this.name = "Unknown";
        this.hitpoints = 500;
        this.mana = 200;
    }

    public GameCharacter(String name) {
        this.name = name;
        this.hitpoints = 500;
        this.mana = 200;
    }

    public String getName() {
        return name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int getMana() {
        return mana;
    }

    public void setHitpoints(int newHitpoints) {
        if(this.hitpoints - newHitpoints <= 0) {
            this.hitpoints = 0;
        } else {
            this.hitpoints -= newHitpoints;
        }
    }

    public void reduceMana(int newMana) {
        if(this.mana - newMana <= 0) {
            this.mana = 0;
        }
        else {
            this.mana -= newMana;
        }

    }

    public void increaseMana(int newMana) {
        if(newMana + this.mana > 200) {
            this.mana = 200;
        }
        else {
            this.mana += newMana;
        }
    }


}
