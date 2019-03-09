package example.screen;

import ev3dev.actuators.LCD;
import ev3dev.hardware.EV3DevDistro;
import ev3dev.hardware.EV3DevDistros;
import ev3dev.utils.Brickman;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.TextLCD;
import lejos.utility.Delay;


import java.awt.*;

public class ShowFont {

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(String[] args) {
        ShowFont showFont = new ShowFont();
    }

    public ShowFont() {

        if(EV3DevDistros.getInstance().getDistro().equals(EV3DevDistro.JESSIE)) {
            Brickman.disable();
        }

        //listFont();


        //lcd.setColor(Color.BLACK);
        lcd.setColor(255,255,255);
        lcd.drawRect(0,0, lcd.getWidth(), lcd.getHeight());
        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());
        System.out.println("clear screen");
        Delay.msDelay(2000);

        lcd.setFont(new Font("Monospaced",Font.PLAIN,16));
        //lcd.setColor(Color.WHITE);
        lcd.setColor(0,0,0);
        lcd.drawString("Hello World", (lcd.getWidth()/ 2)-30, lcd.getHeight()/2, 0);
        lcd.refresh();
        System.out.println("drawString");

        Delay.msDelay(5000);

    }

    public void listFont() {
        System.out.println("List Font");

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

        // Get all font family name in a String[]
        String[] fontNames = env.getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            System.out.println("Font: " + fontName);
        }

        // Construct all Font instance (with font size of 1)
        Font[] fonts = env.getAllFonts();
        for (Font font : fonts) {
            System.out.println("Font: " + font);
        }
    }

}
