package example;

import ev3dev.actuators.LCD;
import ev3dev.actuators.ev3.EV3Led;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.hardware.display.SystemDisplay;
import ev3dev.sensors.Battery;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class MyFirstRobot {

    private static GraphicsLCD lcd = LCD.getInstance();

    public static void clear(){
        //lcd.setColor(Color.WHITE);
        lcd.setColor(255,255,255);
        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());

    }

    public static void main(final String[] args){

        System.out.println("Creating Motor A & B");
        final EV3LargeRegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.A);
        final EV3LargeRegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.B);

        //SystemDisplay.initializeRealDisplay().switchToTextMode();

        clear();
        Delay.msDelay(5000);
//        lcd.setColor(0,0,0);
//        lcd.drawRect(0,0, lcd.getWidth(), lcd.getHeight());
//        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());
//        lcd.refresh();

        lcd.setColor(0,0,0);
        lcd.drawString("Hello World", 50,50, 0);
        lcd.refresh();

        Delay.msDelay(5000);

        //To Stop the motor in case of pkill java for example
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("Emergency Stop");
                motorLeft.stop();
                motorRight.stop();
            }
        }));

        System.out.println("Defining the Stop mode");
        motorLeft.brake();
        motorRight.brake();

        System.out.println("Defining motor speed");
        final int motorSpeed = 200;
        motorLeft.setSpeed(motorSpeed);
        motorRight.setSpeed(motorSpeed);

        System.out.println("Go Forward with the motors");
        motorLeft.forward();
        motorRight.forward();

        Delay.msDelay(2000);

        System.out.println("Stop motors");
        motorLeft.stop();
        motorRight.stop();

        System.out.println("Go Backward with the motors");
        motorLeft.backward();
        motorRight.backward();

        Delay.msDelay(2000);

        System.out.println("Stop motors");
        motorLeft.stop();
        motorRight.stop();

        System.out.println("Checking Battery");
        System.out.println("Votage: " + Battery.getInstance().getVoltage());

        System.exit(0);
    }
}
