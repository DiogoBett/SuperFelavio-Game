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

    }
}
