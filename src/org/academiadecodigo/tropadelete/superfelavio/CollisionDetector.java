package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.PowerUp.PowerUp;

import java.util.Iterator;
import java.util.LinkedList;

public class CollisionDetector {

    private Player felavio;
    private LinkedList<Cats> cats;
    private LinkedList<PowerUp> powerUps;

    public CollisionDetector(Player felavio, LinkedList<Cats> cats, LinkedList<PowerUp> powerUps) {
        this.felavio = felavio;
        this.cats = cats;
        this.powerUps = powerUps;

    }

    public void checkCollisions() {
        collisionDetect();
        /*if (type == null) {
            return;
        }*/
        collisionPowerUp();
    }

    private void collisionDetect() {
        for (Cats cat : cats) {
            if (felavio.checkX(cat) && felavio.checkY(cat) || cat.checkX(felavio) && cat.checkY(felavio)) {
                if (felavio.isJump()) {
                    cat.takeDamage();
                    felavio.setCurrentY(Direction.UP);
                    continue;
                }

                felavio.takeDamage();

            }
        }

    }

    private void collisionPowerUp() {
        Iterator<PowerUp> it = powerUps.iterator();
        while (it.hasNext()) {
            PowerUp power = it.next();
            if (felavio.checkX(power) && felavio.checkY(power)) {
                power.takeDamage();
                felavio.powerUp(power.getType());
                power.hide();
                it.remove();

            }
        }
    }

}
