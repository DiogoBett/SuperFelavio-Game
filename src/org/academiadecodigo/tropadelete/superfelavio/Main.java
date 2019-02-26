package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;

public class Main {

    public static void main(String[] args) {
        Player felavio = new Player();
        Cats[] kitties = {
                new Cats(1),
                new Cats(1)
        };
        Game game = new Game(felavio, kitties);
        game.start();
    }
}
