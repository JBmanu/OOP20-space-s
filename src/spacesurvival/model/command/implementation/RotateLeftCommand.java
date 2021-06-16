package spacesurvival.model.command.implementation;

import java.awt.geom.AffineTransform;

import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;

public class RotateLeftCommand implements CommandGameObject {

    /** 
     * Rotate left the ship.
     * @param ship the controlled ship 
     * 
     */

    @Override
    public void execute(final SpaceShipSingleton ship) {
        final AffineTransform transform = ship.getTransform();
        transform.rotate(Math.toRadians(-GameObjectUtils.SPACESHIP_ROTATION), ship.getSize().getWidth() / 2, ship.getSize().getHeight() / 2);
        ship.setTransform(transform);
    }

//		public static void main (String[] args) {
//			AffineTransform transform = new AffineTransform();
//			Rectangle rectangle = new Rectangle(30,50);
//			transform.rotate(Math.toRadians(45), rectangle.getX() + rectangle.width/2, rectangle.getY() + rectangle.height/2);
//			g2.fill(transformed);
//		}
 
}