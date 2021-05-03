package model.gameElement.fireEnemy;

import java.awt.Dimension;
import java.util.Optional;

import model.gameElement.AbstractGameObject;
import model.gameElement.Movement;
import model.gameElement.V2d;
import model.gameElement.weapon.Weapon;
import model.image.EngineImage;
import model.environment.Point2D;

public class FireEnemy extends AbstractGameObject {

	public FireEnemy(EngineImage engineImage, Integer life,Integer damage, Dimension dim, Point2D point, Movement movement, V2d vel, Optional<Weapon> weapon) {
		super(engineImage, life, damage, point, movement, vel, weapon);
	}

	@Override
	public String toString() {
		return "FireEnemy { " + super.toString() + " }";
	}

}
