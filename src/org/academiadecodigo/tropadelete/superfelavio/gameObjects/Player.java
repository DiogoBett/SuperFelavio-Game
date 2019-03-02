package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.superfelavio.Direction;
import org.academiadecodigo.tropadelete.superfelavio.Game;

public class Player extends GameObject {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 40;
    private static final int SPEED = 10;


    private static final int HEALTH = 7;

    private boolean jump;


    public Player() {
        super(HEALTH, SPEED,new Rectangle(Game.WALL_RIGHT/2, Game.GROUND_Y-100, WIDTH, HEIGHT),new Picture(Game.WALL_RIGHT/2, Game.GROUND_Y-100, "resources/Cat Sprites.png"));
        this.jump = false;

    }

    @Override
    public void moveY() {
        if(!jump && currentY == Direction.UP){
            jump = true;
            jumpHeight = hitbox.getY() - 60;
        }
        if(jumpHeight >= hitbox.getY()){
            currentY = null;
        }
        super.moveY();

        if (super.getHeight() > Game.GROUND_Y && jump){
            jump = false;
        }
    }

    public boolean isJump() {
        return jump;
    }


    //Power Ups are NOT MVP
}
