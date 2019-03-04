package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

public class CatFactory {

    public static Cats spawnCats(int catStartPosition) {

        int random = (int) (Math.random() * FelineType.values().length);
        FelineType felineType = FelineType.values()[random];


            return new Cats(felineType.getHealth(),
                    catStartPosition,
                    felineType.getSpeed(),
                    felineType.getRightpic(),
                    felineType.getLeftpic());
    }

}
