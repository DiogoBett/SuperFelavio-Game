package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.superfelavio.Direction;
import org.academiadecodigo.tropadelete.superfelavio.Game;
import org.academiadecodigo.tropadelete.superfelavio.Sound;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.PowerUp.PowerUpType;

public class Player extends GameObject {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 80;
    private static final int SPEED = 10;
    private static final int HEALTH = 20;

    private boolean jump;

    private Sound beerSound;
    private Sound phillSound;


    public Player() {
        super(HEALTH,
                SPEED,
                new Rectangle(Game.WALL_RIGHT/2, Game.GROUND_Y-100, WIDTH, HEIGHT),
                new Picture((Game.WALL_RIGHT/2) -15 , Game.GROUND_Y - 130, "resources/images/flavio.png"),
                new Picture (Game.WALL_RIGHT/2 - 15, Game.GROUND_Y - 130, "resources/images/flavioLeft.png"));
        jumpHeight = hitbox.getY() - 40;
        this.jump = false;
        this.beerSound = new Sound("/resources/sound/beerSound.wav");
        this.phillSound = new Sound ("/resources/sound/phillSound.wav");
    }

    @Override
    public void moveY() {
        if(!jump && currentY == Direction.UP){
            jump = true;
        }
        super.moveY();

        if (super.getHeight() > Game.GROUND_Y && jump){
            jump = false;
        }
    }

    public boolean isJump() {
        return jump;
    }

    public void powerUp(PowerUpType type) {
        switch(type) {
            case BEER:
                jumpHeight -= 5;
                beerSound.play(true);
                break;

            case PHILL:
                health += 5;
                phillSound.play(true);
                if(health > HEALTH) {
                    health = HEALTH;
                }
                break;
        }
    }

}
