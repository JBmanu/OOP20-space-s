package spacesurvival.view.utilities;

import java.awt.*;
import java.net.URL;

public class DesignGraphics {
    public static String ROUND_STRING = "Round ";
    public static String SCORE_STRING = "Score: ";
    public static String ENEMIES_STRING = "Enemies";
    public static String INIT_TIMER_STRING = "00:00:00";

    public static final int SIZE_FONT_END = 200;
    public static final int SIZE_FONT_H0 = 100;
    public static final int SIZE_FONT_H1 = 60;
    public static final int SIZE_FONT_H2 = 35;
    public static final int SIZE_FONT_H3 = 30;
    public static final int SIZE_FONT_H4 = 25;
    public static final int SIZE_FONT_H5 = 20;
    public static final int SIZE_FONT_H6 = 15;

    public static final int SIZE_IMAGE_MEDIUM = 70;
    public static final int SIZE_IMAGE_SMALL = 50;

    public static final String TYPE_FONT_STANDARD = "Helvetica";

    public static final Font FONT_BIG_STANDARD = new Font(TYPE_FONT_STANDARD, Font.BOLD, SIZE_FONT_H3);
    public static final Font FONT_MEDIUM_STANDARD = new Font(TYPE_FONT_STANDARD, Font.BOLD, SIZE_FONT_H4);
    public static final Font FONT_MICRO_STANDARD = new Font(TYPE_FONT_STANDARD, Font.BOLD, SIZE_FONT_H5);
    public static final Font FONT_SMALL_STANDARD = new Font(TYPE_FONT_STANDARD, Font.BOLD, SIZE_FONT_H6);

    public static final int SIZE_COLUMNS_TEXT = 10;

    public static final Color COLOR_1 = new Color(90, 165, 232);
    public static final Color COLOR_2 = new Color(128, 213, 255);
    public static final Color COLOR_3 = new Color(148, 233, 255);
    public static final Color COLOR_4 = new Color(58, 241, 255);
    public static final Color COLOR_OPACITY_BLACK = new Color(0, 0, 0, 80);

    public static Font getFontForTitle(final int size){
        final URL fontUrl = ClassLoader.getSystemResource("font/mainFont.ttf");
        Font myFont = null;
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
            myFont = myFont.deriveFont(Font.PLAIN, size);
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myFont);
        } catch (Exception e) {
            System.err.println("Path font no found");
        }

        return myFont;
    }

    public static Font getFontForGame(final int size){
        final URL fontUrl = ClassLoader.getSystemResource("font/game.ttf");
        Font myFont = null;
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
            myFont = myFont.deriveFont(Font.PLAIN,size);
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myFont);
        } catch (Exception e) {
            System.err.println("Path font no found");
        }

        return myFont;
    }

    public static Font getFontForDead(final int size){
        final URL fontUrl = ClassLoader.getSystemResource("font/CHILLER.TTF");
        Font myFont = null;
        try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
            myFont = myFont.deriveFont(Font.PLAIN, size);
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(myFont);
        } catch (Exception e) {
            System.err.println("Path font no found");
        }
        return myFont;
    }

}
