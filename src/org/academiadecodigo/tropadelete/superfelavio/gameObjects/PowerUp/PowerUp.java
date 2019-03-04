package org.academiadecodigo.tropadelete.superfelavio.gameObjects.PowerUp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.superfelavio.Game;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.GameObject;

public class PowerUp extends GameObject {

    private final static int WIDTH = 10;
    private final static int HEIGHT = 20;

    private final static int HEALTH = 1;
    private final static int SPEED = 0;

    private PowerUpType type;

    public PowerUp(int startpoint, PowerUpType type) {
        super(HEALTH,
                SPEED,
                new Rectangle(startpoint, Game.GROUND_Y  , WIDTH, HEIGHT),
                new Picture(startpoint, Game.GROUND_Y - HEIGHT - 30, type.getSymbol()),
                null);
        this.type = type;
    }

    public PowerUpType getType() {
        return type;
    }

    @Override
    public void show() {
        rightPic.draw();
    }

    @Override
    public void hide() {
        rightPic.delete();
    }

}
