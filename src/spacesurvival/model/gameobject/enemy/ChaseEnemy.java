package spacesurvival.model.gameobject.enemy;

import java.util.List;
import java.util.Optional;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.weapon.Weapon;

import spacesurvival.model.EngineImage;
import spacesurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spacesurvival.model.worldEcollisioni.physics.components.PhysicsComponent;

public class ChaseEnemy extends MainGameObject {
	
    public ChaseEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final List<String> animation) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.setAnimation(animation);
    }
	
    public ChaseEnemy(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
    }
	
    @Override
    public String toString() {
        return "ChaseEnemy { " + super.toString() + " }";
    }

}