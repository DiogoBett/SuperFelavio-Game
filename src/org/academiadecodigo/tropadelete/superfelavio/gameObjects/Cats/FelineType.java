package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

public enum FelineType {
    NORMAL(1,6,"resources/images/cat.png", "resources/images/catLeft.png"),
    BLACKCAT(2, 4, "resources/images/black-cat.png", "resources/images/black-cat-left.png");

    private int health;
    private int speed;
    private String rightpic;
    private String leftpic;

    FelineType(int health, int speed, String rightpic, String leftpic) {
        this.health = health;
        this.speed = speed;
        this.rightpic = rightpic;
        this.leftpic = leftpic;
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
}
