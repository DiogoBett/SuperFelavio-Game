package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;

public class Game {

    private Player felavio;
    private Cats[] cats;
    private Rectangle canvas;

    public Game(Player felavio, Cats[] cats) {
        this.felavio = felavio;
        this.cats = cats;
    }

    public void start() {

        Rectangle canvas = new Rectangle(10, 10, 400, 1000);
        canvas.draw();

        while (true) {

            felavio.move();

            for (int i = 0; i < cats.length; i++) {

                cats[i].move();

            }
        }


    }
}
