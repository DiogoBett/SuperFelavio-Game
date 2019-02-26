package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;

public class CollisionDetector {

    private Player felavio;
    private Cats[] cats;
    private Rectangle player;

    public CollisionDetector(Player felavio, Cats[] cats) {
        this.felavio = felavio;
        this.cats = cats;
        player = felavio.getobjectHitbox();
    }

    public void collisionDetect() {

    }
}
