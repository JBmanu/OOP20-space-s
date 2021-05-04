package model.gameObject.asteroid;


import java.awt.Dimension;
import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.Movement;
import model.common.P2d;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.environment.Point2D;

public class Asteroid extends AbstractGameObject {
	
	public Asteroid(EngineImage engineImage, Integer life,Integer damage, Dimension dim,
					P2d point, Movement movement, V2d vel, Optional<Weapon> weapon) {
		super(engineImage, life, damage, point, movement, vel, weapon);
	}


	@Override
	public String toString() {
		return "Asteroid { " + super.toString() + " }";
	}
}