package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

public enum FelineType {
    NORMAL(1,6,"resources/images/cat.png", "resources/images/catLeft.png", 10),
    BLACKCAT(2, 4, "resources/images/black-cat.png", "resources/images/black-cat-left.png", 20);

    private int health;
    private int speed;
    private String rightpic;
    private String leftpic;
    private int scoreGain;

    FelineType(int health, int speed, String rightpic, String leftpic, int scoreGain) {
        this.health = health;
        this.speed = speed;
        this.rightpic = rightpic;
        this.leftpic = leftpic;
        this.scoreGain = scoreGain;
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
}
