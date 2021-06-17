
package spacesurvival.model.gameobject.weapon;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.Effect;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.MovableGameObject;
import spacesurvival.model.gameobject.enemy.FireableObject;
import spacesurvival.model.movement.FixedMovement;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;

public class Bullet extends MovableGameObject {

    private int damage;
    private Effect effect;
    private Weapon originWeapon;
    
    public Bullet() {
        // TODO Auto-generated constructor stub
    }
	
    public Bullet(final EngineImage engineImage, final P2d position, final BoundingBox bb, final PhysicsComponent phys,
            final V2d velocity, final int damage, final Effect effect, final Weapon originWeapon) {
        super(engineImage, position, bb, phys, velocity, new FixedMovement());
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.damage = damage;
        this.setEffect(effect);
        this.setOriginWeapon(originWeapon);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(final int damage) {
        this.damage = damage;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(final Effect effect) {
        this.effect = effect;
    }

    public Weapon getOriginWeapon() {
        return originWeapon;
    }

    public void setOriginWeapon(final Weapon originWeapon) {
        this.originWeapon = originWeapon;
    }

    public FireableObject getShooter() {
        return this.originWeapon.getOwner();
    }
	
}
