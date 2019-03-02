package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

public class CatFactory {

    public static Cats spawnCats(int health, int catStartPosition) {
        return new Cats(health, catStartPosition);
    }

}
