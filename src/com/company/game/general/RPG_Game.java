package com.company.game.general;

import com.company.game.player.*;
public class RPG_Game {

    private static int r = 1;

    public static boolean isFinished(Boss boss, Hero[] heroes){
        if (boss.getHealth() < 0){
            System.out.println("__________________________________");
            System.out.println("Heroes won!");
            return true;
        }
        boolean isFinished = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                isFinished = false;
                break;
            }
        }
        if (isFinished){
            System.out.println("__________________________________");
            System.out.println("Boss won!");
        }
        return isFinished;
    }

    public static void printStatistic(Boss boss, Hero[] heroes){
        System.out.println("__________________________________");
        System.out.println("Round: " + r);
        System.out.println("__________________________________");
        r++;
        System.out.println("Boss health: " + boss.getHealth() + ".");
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0){
                System.out.println(heroes[i].getClass().getSimpleName() + " Dead.");
            } else System.out.println(heroes[i].getClass().getSimpleName() + " health: " + heroes[i].getHealth() + ".");
        }
    }

    public static void bossHit(Boss boss, Hero[] heroes) {
        System.out.println("__________________________________");
        if (!boss.isStunned()){
            if (is(heroes, Tank.class)){
                for (int i = 0; i < heroes.length; i++) {
                    if (heroes[i].getHealth() > 0) {
                        if (heroes[i].getClass().getSimpleName() == "Tank"){
                            heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                            if (heroes[i].getHealth() <= 0) {
                                System.out.println(heroes[i].getClass().getSimpleName() + " DIED!");
                                continue;
                        }
                        } else {
                            if (heroes[5].getHealth() > 0) {
                                heroes[5].setHealth(heroes[5].getHealth() - boss.getDamage() / 5);
                                heroes[i].setHealth(heroes[i].getHealth() - 4 * boss.getDamage() / 5);
                                if (heroes[5].getHealth() <= 0) {
                                    System.out.println("Tank DIED!");
                                }
                                if (heroes[i].getHealth() <= 0) {
                                    System.out.println(heroes[i].getClass().getSimpleName() + " DIED!");
                                }
                                continue;
                            } else heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                            if (heroes[i].getHealth() <= 0) {
                                System.out.println(heroes[i].getClass().getSimpleName() + " DIED!");
                            }
                        }
                    }
                }
            }else for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                    if (heroes[i].getHealth() <= 0) {
                        System.out.println(heroes[i].getClass().getSimpleName() + " DIED!");
                    }
                }
            }
        }
        boss.setStunned(false);
    }

    public static void heroesHit(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getClass().getSimpleName() != "Warrior"){
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                if (boss.getHealth() <= 0){
                    System.out.println("Boss died!!!");
                }
            }
        }
    }

    public static void heroesApplyAbility(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0){
                heroes[i].applyPowerAbility(boss, heroes);
            }
        }
    }

    public static void round(Boss boss, Hero[] heroes){
        bossHit(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplyAbility(boss, heroes);
        printStatistic(boss, heroes);
    }

    public static boolean is(Hero[] heroes, Class hero){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getClass() == hero){
                return true;
            }
        }
        return false;
    }
    public static void startGame(){

        Boss boss = new Boss(50, 2000);
        Hero warrior = new Warrior(25, 300);
        Hero magic = new Magic(15, 200, 5);
        Hero hunter = new Hunter(20, 250);
        Hero medic = new Medic(10, 200, 15);
        Hero thor = new Thor( 20, 250);
        Hero tank = new Tank(5, 500);

        Hero[] heroes = {warrior, magic, hunter, medic, thor, tank};

        printStatistic(boss, heroes);
        while (!isFinished(boss, heroes)){
           round(boss, heroes);
        }
    }
}
