package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

public enum FelineType {
    NORMAL(1,7,"resources/images/cat.png", "resources/images/catLeft.png", 10, 25,30),
    BLACKCAT(2, 5, "resources/images/black-cat.png", "resources/images/black-cat-left.png", 20, 25,30); /*,
    LION(5,3,"resources/images/rightLion.png", "resources/images/lion.png", 50, 30,30),
    SEALION(9,1,"resources/images/sealionRight.png", "resources/images/sealion.png", 100,65,30); */

    private int health;
    private int speed;
    private String rightpic;
    private String leftpic;
    private int scoreGain;
    private int Width;
    private int Height;

    FelineType(int health, int speed, String rightpic, String leftpic, int scoreGain, int Width, int Heigth) {
        this.health = health;
        this.speed = speed;
        this.rightpic = rightpic;
        this.leftpic = leftpic;
        this.scoreGain = scoreGain;
        this.Width = Width;
        this.Height = Heigth;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public String getRightpic() {
        return rightpic;
    }

    public String getLeftpic() {
        return leftpic;
    }

    public int getScoreGain() {
        return scoreGain;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }
}
