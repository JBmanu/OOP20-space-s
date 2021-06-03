package spaceSurvival.model.gameObject.mainGameObject;

import java.util.Optional;

import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class FireEnemy extends MainGameObject {

	public FireEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                     final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
                     final int impactDamage, final Optional<Weapon> weapon, final int score) {
		
		super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon, score);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
	}

	@Override
	public String toString() {
		return "FireEnemy { " + super.toString() + " }";
	}

}
