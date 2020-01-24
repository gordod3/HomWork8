package com.company.game.player;

public abstract class Hero extends GameEntity implements PowerAbility {
    private PowerType powerType;

    public Hero(int damage, int health, PowerType powerType) {
        super(damage, health);
        this.powerType = powerType;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }
}







