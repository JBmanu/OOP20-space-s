package spaceSurvival.model.gameObject;

import java.util.List;
import java.util.Optional;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.weapon.Weapon;
import spaceSurvival.model.movement.Movement;
import spaceSurvival.model.EngineImage;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.BoundingBox;
import spaceSurvival.model.worldEcollisioni.physics.components.PhysicsComponent;
import spaceSurvival.utilities.pathImage.Skin.SkinShip;
import spaceSurvival.view.game.utilities.PanelGame;

public abstract class MainGameObject extends MovableGameObject {
	private int life;
	private int impactDamage;
	private Status status;
	private Optional<Weapon> weapon;
	private Thread statusThread;
	
	public MainGameObject(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                          final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
                          final int impactDamage, final Optional<Weapon> weapon) {
		super(engineImage, position, bb, phys, velocity, movement);
		this.life = life;
		this.setImpactDamage(impactDamage);
		this.status = Status.NORMAL;
		this.weapon = weapon;
		this.statusThread = new Thread(MainGameObject.this::statusLoop);
		this.statusThread.start();
	}

    public int getLife() {
		return life;
	}

    public void setLife(final int life) {
		this.life = life;
	}
    
    public void increaseLife(final int heal) {
		this.life += heal;
	}
    
	public void decreaseLife(final int damage) {
		this.life -= damage;
		System.out.println(this.getPhys());
		System.out.println("Ahia danno ricevuto: " + damage);
		System.out.println("Vita rimasta: " + this.life);
	}
	
	public int getImpactDamage() {
		return impactDamage;
	}

	public void setImpactDamage(final int impactDamage) {
		this.impactDamage = impactDamage;
	}
	
	public Optional<Weapon> getWeapon() {
		return weapon;
	}

	public void setWeapon(final Optional<Weapon> weapon) {
		this.weapon = weapon;
	}

	public Status getStatus() {
		return this.status;
	}
	
	public void setStatus(final Status status) {
		this.status = status;
	}
	
	public boolean isInvincible() {
		return this.status == Status.INVINCIBLE;
	}
	
	public void statusLoop() {
		while (true) {
			if (this.status != Status.NORMAL) {
				List<String> normalList = getAnimation();
				switch (this.status) {
				case INVINCIBLE:
					setAnimation(SkinShip.LIST_SHIP1);
					waitStatusDuration(GameObjectUtils.INVINCIBLE_DURATION);
					break;
				case ON_FIRE:
					new Thread(MainGameObject.this::onFire).start();
					setAnimation(SkinShip.LIST_SHIP1);
					waitStatusDuration(GameObjectUtils.ON_FIRE_DURATION);
					break;
				case FROZEN:
					new Thread(MainGameObject.this::frozen).start();
					setAnimation(SkinShip.LIST_SHIP1);
					waitStatusDuration(GameObjectUtils.FROZEN_DURATION);
					break;
				case PARALIZED:
					new Thread(MainGameObject.this::paralized).start();
					setAnimation(SkinShip.LIST_SHIP1);
					waitStatusDuration(GameObjectUtils.PARALIZED_DURATION);
					break;
				default:
					break;
				}
				setAnimation(normalList);
				this.status = Status.NORMAL;
			}
		}
	}
	
	public void waitStatusDuration(int milliseconds) {
		try {
			sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void onFire() {
		while (this.status == Status.ON_FIRE) {
			this.decreaseLife(GameObjectUtils.FIRE_DAMAGE);
			try {
				sleep(GameObjectUtils.FIRE_INTERVAL_DAMAGE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void frozen() {
		final V2d initialVel = this.getVelocity();
		this.setVelocity(getVelocity().mul(GameObjectUtils.FROZEN_SLOWDOWN));
		while (this.status == Status.FROZEN);
		this.setVelocity(initialVel);
	}
	
	public void paralized() {
		final V2d initialVel = this.getVelocity();
		this.setVelocity(GameObjectUtils.NO_VEL);
		while (this.status == Status.PARALIZED);
		this.setVelocity(initialVel);

	}

	@Override
	public String toString() {
		return "MainGameObject [life=" + life + ", impactDamage=" + impactDamage + ", state=" + status 
				+ ", weapon=" + weapon + ", " + super.toString() + "]";
	}

}
