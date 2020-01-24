package com.company.game.player;

public class Tank extends Hero implements PowerAbility {

    public Tank(int damage, int health) {
        super(damage, health, PowerType.DEFENSE);
    }

    @Override
    public void applyPowerAbility(Boss boss, Hero[] heroes) {
        if (getHealth() > 0){

        }
    }
}
