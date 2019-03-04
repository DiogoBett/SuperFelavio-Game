package org.academiadecodigo.tropadelete.superfelavio.gameObjects.PowerUp;

public enum PowerUpType {
    BEER("resources/images/beer.png"),
    PHILL("resources/images/phill.png");

    private String symbol;

    PowerUpType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
