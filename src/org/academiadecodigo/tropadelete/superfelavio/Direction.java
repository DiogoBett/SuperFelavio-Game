package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public enum Direction {

    UP,
    DOWN,
    RIGHT,
    LEFT;

    public static Direction keysToDirection(KeyboardEvent key) {

        switch (key.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                return UP;
            case KeyboardEvent.KEY_RIGHT:
                return RIGHT;
            case KeyboardEvent.KEY_LEFT:
                return LEFT;
        }

        return null;

    }

    public static Direction oppositeDirection(Direction currentDirection) {

        Direction opposite = null;

        switch (currentDirection) {
            case RIGHT:
                opposite = Direction.LEFT;
                break;
            case LEFT:
                opposite = Direction.RIGHT;
                break;
        }

        return opposite;

    }
}
