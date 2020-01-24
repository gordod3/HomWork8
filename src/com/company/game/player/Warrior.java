package com.company.game.player;

import java.util.Random;

public class Warrior extends Hero implements PowerAbility {
    public Warrior(int damage, int health) {
        super(damage, health, PowerType.CRITICAL_STRIKE);
    }

    @Override
    public void applyPowerAbility(Boss boss, Hero[] heroes) {
        if(getHealth() > 0){
            Random random = new Random();
            int multiplier = random.nextInt(2) + 2;
            boss.setHealth(boss.getHealth() - getDamage() * multiplier);
        }
    }

}

