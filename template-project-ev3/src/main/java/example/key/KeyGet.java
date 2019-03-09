package example.key;

import ev3dev.sensors.EV3Key;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import lejos.utility.Delay;

public class KeyGet implements KeyListener {

    public static void main(String[] args) {
        KeyGet keyGet = new KeyGet();
    }

    public KeyGet() {
        EV3Key key = new EV3Key(EV3Key.BUTTON_ALL);
        key.addKeyListener(this);

        Delay.msDelay(10000);
    }


    @Override
    public void keyPressed(Key k) {
        System.out.println("keyPressed");
    }

    @Override
    public void keyReleased(Key k) {
        System.out.println("keyReleased");
    }
}
