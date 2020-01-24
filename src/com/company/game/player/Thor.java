package com.company.game.player;

import java.util.Random;

public class Thor extends Hero implements PowerAbility {
    public Thor(int damage, int health) {
        super(damage, health, PowerType.STUN);
    }

    @Override
    public void applyPowerAbility(Boss boss, Hero[] heroes) {
        if(getHealth() > 0){
            Random random = new Random();
            int stunChance = random.nextInt(9);
            if (stunChance == 0){
                System.out.println("Thor stunned boss!");
                boss.setStunned(true);
            }
        }
    }

}

