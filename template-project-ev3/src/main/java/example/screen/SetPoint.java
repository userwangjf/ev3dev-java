package example.screen;

import ev3dev.actuators.LCD;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;

import java.util.Set;

public class SetPoint {

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(String[] args) {

        SetPoint setPoint = new SetPoint();
    }


    public SetPoint() {
        lcd.clear();
        lcd.setColor(100,100,100);
        for(int x=0;x<200;x++) {
            lcd.setPixel(x,20,255);
            lcd.refresh();
            Delay.msDelay(200);
        }
    }

}
