package org.academiadecodigo.tropadelete.superfelavio.gameObjects.PowerUp;

public class PowerUpFactory {

    public static PowerUp spawnPowerUp(int startPosition){
        int random = (int) (Math.random() * PowerUpType.values().length);
        PowerUpType powerUpType = PowerUpType.values()[random];
        return new PowerUp(startPosition,powerUpType);
    }
}
