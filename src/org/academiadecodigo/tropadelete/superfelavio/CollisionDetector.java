package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.GameObject;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;

import java.util.LinkedList;

public class CollisionDetector {

    private Player felavio;
    private LinkedList<Cats> cats;

    public CollisionDetector(Player felavio, LinkedList<Cats> cats) {
        this.felavio = felavio;
        this.cats = cats;

    }

    public void collisionDetect() {
        for (Cats cat : cats) {
            if (felavio.checkX(cat) && felavio.checkY(cat)) {
                if (felavio.isJump()) {
                    cat.takeDamage();
                    felavio.setCurrentY(Direction.UP);
                    continue;
                }

                felavio.takeDamage();

                /*try {
                    felavio.hide();
                    Thread.sleep(50);
                    felavio.show();
                }catch (InterruptedException e){
                    System.out.println("invincibility frames");
                }*/

            }
        }

    }

}
