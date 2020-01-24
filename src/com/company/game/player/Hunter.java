package com.company.game.player;

public class Hunter extends Hero implements PowerAbility {

    public Hunter(int damage, int health) {
        super(damage, health, PowerType.SPIKES);
    }

    @Override
    public void applyPowerAbility(Boss boss, Hero[] heroes) {
        if (getHealth() > 0){
            boss.setHealth(boss.getHealth() - getDamage() + 4*boss.getDamage()/5);
        }
    }
}
