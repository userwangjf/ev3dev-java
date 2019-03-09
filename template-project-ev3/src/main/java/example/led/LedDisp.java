package example.led;

import ev3dev.actuators.ev3.EV3Led;
import lejos.hardware.LED;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LedDisp {

    public static Logger LOGGER = LoggerFactory.getLogger(example.robotics.ev3.actuator.LEDPatternsExample.class);

    public static void main(String[] args) {

        LOGGER.info("Example with EV3 Led patterns");

        leftPatterns();
        rightPatterns();

    }

    public static void leftPatterns(){

        LOGGER.info("Left patterns");

        LED led = new EV3Led(EV3Led.LEFT);
        for(int i=0;i<9;i++) {
            System.out.println("LED Pattern: " + i);
            led.setPattern(i);
            Delay.msDelay(1000);
        }
        led.setPattern(0);
        Delay.msDelay(1000);
    }

    public static void rightPatterns(){

        LOGGER.info("Right patterns");

        LED led = new EV3Led(EV3Led.RIGHT);

        for(int i=0;i<9;i++) {
            System.out.println("LED Pattern: " + i);
            led.setPattern(i);
            Delay.msDelay(1000);
        }
        led.setPattern(0);
        Delay.msDelay(1000);

    }

}
