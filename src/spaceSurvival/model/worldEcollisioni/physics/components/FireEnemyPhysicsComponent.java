package spaceSurvival.model.worldEcollisioni.physics.components;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.mainGameObject.FireEnemy;
import spaceSurvival.model.GUI.game.World;

public class FireEnemyPhysicsComponent implements PhysicsComponent {

	@Override
	public void update(int dt, GameObject abstractObj, World w) {
		FireEnemy obj = (FireEnemy) abstractObj;
		P2d position = obj.getPosition();
		V2d velocity = obj.getVelocity();
		obj.setPosition(position.sum(velocity.mul(0.001 * dt)));
	}

}
