package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

public class Player extends GameObject {
    private static final int HEALTH = 7;

    private boolean jump;


    public Player() {
        super(HEALTH);
        this.jump = false;
    }

    public void jump() {

    }

    public boolean isJump() {
        return jump;
    }


    //Power Ups are NOT MVP
}
