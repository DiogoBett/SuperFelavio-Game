package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

import org.academiadecodigo.tropadelete.superfelavio.Direction;

public abstract class GameObject {
    protected int health;
    protected Direction currentDirection;


    public GameObject(int health){
        this.health = health;
        this.currentDirection = null;
    }

    public void move() {

    }

    public void takeDamage (){
        health--;
    }

    public int getHealth() {
        return health;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }
}
