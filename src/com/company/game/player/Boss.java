package com.company.game.player;

public class Boss extends GameEntity {
    boolean stunned;
    public Boss(int damage, int health) {
        super(damage, health);
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }
}