package spaceSurvival.model.worldEcollisioni.physics.components;

import java.util.Optional;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.PickableGameObject;
import spaceSurvival.model.GUI.game.World;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;

public class PickablePhysicsComponent implements PhysicsComponent {
	
	@Override
	public void update(int dt, GameObject obj, World w) {
		RectBoundingBox bbox = (RectBoundingBox) obj.getBoundingBox();
		Optional<PickableGameObject> perk = w.checkCollisionWithPickables(obj.getPosition(), bbox);
		//collisioni con perks
//		if (perk.isPresent()) {
//			w.notifyWorldEvent(new HitPickableEvent(perk.get()));
//			System.out.println("Preso il PERK Fratellì");
//		}
//		
	}

}
