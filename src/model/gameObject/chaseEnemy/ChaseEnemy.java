package model.gameObject.chaseEnemy;

import java.util.Optional;

import model.gameObject.AbstractGameObject;
import model.gameObject.GameObjectUtils;
import model.gameObject.Movement;
import model.common.P2d;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public class ChaseEnemy extends AbstractGameObject {
	
	public ChaseEnemy(EngineImage engineImage, Integer life,Integer damage, P2d position,
			 Movement movement, V2d vel, Optional<Weapon> weapon, BoundingBox bb,
			 PhysicsComponent phys) {
		super(engineImage, life, damage, position, movement, vel, weapon, bb, phys);
		this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage));
	
	}
	@Override
	public String toString() {
		return "ChaseEnemy { " + super.toString() + " }";
	}
	

}
