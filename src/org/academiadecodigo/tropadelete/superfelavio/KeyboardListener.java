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
    private Player felaveo;

    public KeyboardListener (Player movable){
        felaveo = movable;

        Keyboard keyboard = new Keyboard(this);
        for (int i = 0 ; i < controls.length ; i++){
            subscribe(controls[i],keyboard,KeyboardEventType.KEY_PRESSED);
            subscribe(controls[i],keyboard,KeyboardEventType.KEY_RELEASED);

        }
    }

    private void subscribe (int key , Keyboard keyboard,KeyboardEventType typeEvent){
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(typeEvent);
        keyboard.addEventListener(event);
    }




    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
     felaveo.setCurrentDirection(Direction.keysToDirection(keyboardEvent));

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        felaveo.setCurrentDirection(null);

    }
}
