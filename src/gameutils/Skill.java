package gameutils;

import java.util.Random;

public class Skill {
    private String name;
    private final int minDamage;
    private final int maxDamage;
    private final int manaCost;
    private final int maxCooldown;
    private int currentCooldown;

    public Skill(String name, int minDamage, int maxDamage, int manaCost, int maxCooldown) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.manaCost = manaCost;
        this.maxCooldown = maxCooldown;
        this.currentCooldown = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getMaxCooldown() {
        return maxCooldown;
    }

    public int getCurrentCooldown() {
        return currentCooldown;
    }

    public void setCurrentCooldown(int cooldown) {
        this.currentCooldown = Math.max(0, cooldown);
    }

    public void activateCooldown() {
        this.currentCooldown = this.maxCooldown;
    }

    public void reduceCooldown() {
        if (this.currentCooldown > 0) {
            this.currentCooldown--;
        }
    }

    public void resetCooldown() {
        this.currentCooldown = 0;
    }

    public boolean isReady() {
        return this.currentCooldown <= 0;
    }

    public boolean isUsable(int currentMana) {
        return isReady() && currentMana >= this.manaCost;
    }

    public int rollDamage(Random random) {
        return minDamage >= maxDamage ? minDamage : random.nextInt(minDamage, maxDamage + 1);
    }

    public String getDamageRangeString() {
        return "(Min: " + minDamage + " | Max: " + maxDamage + ")";
    }
}
