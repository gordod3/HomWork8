package com.company.game.player;

public class Medic extends Hero implements PowerAbility {
    private int healPoint;
    public Medic(int damage, int health, int healPoint) {
        super(damage, health, PowerType.HEAL);
        this.healPoint = healPoint;
    }

    @Override
    public void applyPowerAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this != heroes[i] && heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoint);
            }
        }
    }
}
