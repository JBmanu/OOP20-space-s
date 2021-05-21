package spaceSurvival.model.worldEcollisioni.physics.components;

import java.util.Optional;

import spaceSurvival.model.common.P2d;
import spaceSurvival.model.common.V2d;
import spaceSurvival.model.gameObject.*;
import spaceSurvival.model.gameObject.mainGameObject.Asteroid;
import spaceSurvival.model.GUI.game.World;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class AsteroidPhysicsComponent implements PhysicsComponent {
	
	public void update(int dt, GameObject abstractObj, World w) {
		Asteroid obj = (Asteroid) abstractObj;
		P2d position = obj.getPosition();
		V2d velocity = obj.getVelocity();
		obj.setPosition(position.sum(velocity.mul(0.001 * dt)));
		
		//super.update(dt, obj, w);
		//w.checkBoundaries(obj);
		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		
		Optional<MainGameObject> asteroid = w.checkCollisionWithAsteroids(obj.getPosition(), bbox);
		//collisioni con asteroidi
//		if (asteroid.isPresent()){
//			w.notifyWorldEvent(new HitAsteroidEvent(asteroid.get()));
//			System.out.println("Preso il asteroid Fratellì");
//		}	
	}
}
