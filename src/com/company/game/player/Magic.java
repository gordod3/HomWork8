package com.company.game.player;

public class Magic extends Hero implements PowerAbility {

    private int boost;

    public Magic(int damage, int health, int boost) {
        super(damage, health, PowerType.BOOST);
        this.boost = boost;
    }

    @Override
    public void applyPowerAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this != heroes[i]){
                heroes[i].setDamage(heroes[i].getDamage() + boost);
            }
        }
    }
}
