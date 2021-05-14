package model.gameObject.fireEnemy;

import java.util.Optional;

import model.gameObject.GameObjectUtils;
import model.gameObject.MainGameObject;
import model.gameObject.Movement;
import model.common.P2d;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.image.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public class FireEnemy extends MainGameObject {

	public FireEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
			final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
			final int damage, final Optional<Weapon> weapon) {
		
		super(engineImage, position, bb, phys, velocity, movement, life, damage, weapon);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage));
	}

	@Override
	public String toString() {
		return "FireEnemy { " + super.toString() + " }";
	}

}
