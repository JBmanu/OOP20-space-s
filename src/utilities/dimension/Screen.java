package utilities.dimension;

import model.common.P2d;

import java.awt.*;

public class Screen {
    private static final float PROPORTION_BIG= 1.1F;
    private static final float PROPORTION_MEDIUM = 1.6F;
    private static final float PROPORTION_MINI = 2.7F;

    public static final Point POINT_ZERO = new Point(0, 0);

    public static final Dimension FULLSCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH_FULL_SCREEN = (int) FULLSCREEN.getWidth();
    public static final int HEIGHT_FULL_SCREEN = (int) FULLSCREEN.getHeight();
    public static final P2d POINT_CENTER_FULLSCREEN = new P2d(WIDTH_FULL_SCREEN / 2, HEIGHT_FULL_SCREEN / 2);
    public static final Rectangle RECTANGLE_FULLSCREEN = new Rectangle(POINT_ZERO, FULLSCREEN);


    public static final int WIDTH_BIG = (int) (FULLSCREEN.width / PROPORTION_BIG);
    public static final int HEIGHT_BIG = (int) (FULLSCREEN.height / PROPORTION_BIG);
    public static final int CENTER_X_BIG = (int) (POINT_CENTER_FULLSCREEN.getX() - (WIDTH_BIG / 2));
    public static final int CENTER_Y_BIG = (int) (POINT_CENTER_FULLSCREEN.getY() - (HEIGHT_BIG / 2));

    public static final Dimension DIMENSION_BIG = new Dimension(WIDTH_BIG, HEIGHT_BIG);
    public static final Point POINT_CENTER_BIG = new Point(CENTER_X_BIG, CENTER_Y_BIG);
    public static final Rectangle RECTANGLE_BIG = new Rectangle(POINT_CENTER_BIG, DIMENSION_BIG);


    public static final int WIDTH_MEDIUM = (int) (FULLSCREEN.width / PROPORTION_MEDIUM);
    public static final int HEIGHT_MEDIUM = (int) (FULLSCREEN.height / PROPORTION_MEDIUM);
    public static final int CENTER_X_MEDIUM = (int) (POINT_CENTER_FULLSCREEN.getX() - (WIDTH_MEDIUM / 2));
    public static final int CENTER_Y_MEDIUM = (int) (POINT_CENTER_FULLSCREEN.getY() - (HEIGHT_MEDIUM / 2));

    public static final Dimension DIMENSION_MEDIUM = new Dimension(WIDTH_MEDIUM, HEIGHT_MEDIUM);
    public static final Point POINT_CENTER_MEDIUM = new Point(CENTER_X_MEDIUM, CENTER_Y_MEDIUM);
    public static final Rectangle RECTANGLE_MEDIUM = new Rectangle(POINT_CENTER_MEDIUM, DIMENSION_MEDIUM);


    public static final int WIDTH_MINI = (int) (FULLSCREEN.width / PROPORTION_MINI);
    public static final int HEIGHT_MINI = (int) (FULLSCREEN.height / PROPORTION_MINI);
    public static final int CENTER_X_MINI = (int) (POINT_CENTER_FULLSCREEN.getX() - (WIDTH_MINI / 2));
    public static final int CENTER_Y_MINI = (int) (POINT_CENTER_FULLSCREEN.getY() - (HEIGHT_MINI / 2));

    public static final Dimension DIMENSION_MINI = new Dimension(WIDTH_MINI, HEIGHT_MINI);
    public static final Point POINT_CENTER_MINI = new Point(CENTER_X_MINI, CENTER_Y_MINI);
    public static final Rectangle RECTANGLE_MINI = new Rectangle(POINT_CENTER_MINI, DIMENSION_MINI);


    public static int scaleRespectTo(final int scaleOf, final int respectTo){
        return scaleOf * respectTo / 1000;
    }
}