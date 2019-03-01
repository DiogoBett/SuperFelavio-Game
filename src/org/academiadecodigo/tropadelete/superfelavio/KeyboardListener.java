package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;


public class KeyboardListener implements KeyboardHandler {
    private static final int[] controls = {
            KeyboardEvent.KEY_RIGHT,
            KeyboardEvent.KEY_LEFT,
            KeyboardEvent.KEY_SPACE
    };
    private Player felavio;


    public KeyboardListener(Player movable) {
        felavio = movable;

        Keyboard keyboard = new Keyboard(this);
        for (int i = 0; i < controls.length; i++) {
            subscribe(controls[i], keyboard, KeyboardEventType.KEY_PRESSED);
            subscribe(controls[i], keyboard, KeyboardEventType.KEY_RELEASED);

        }
    }

    private void subscribe(int key, Keyboard keyboard, KeyboardEventType typeEvent) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(typeEvent);
        keyboard.addEventListener(event);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE && !felavio.isJump()) {
           felavio.setCurrentY(Direction.UP);
            return;
        }
        felavio.setCurrentX(Direction.keysToDirection(keyboardEvent));
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        felavio.setCurrentX(null);

    }
}
