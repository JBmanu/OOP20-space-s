package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;
import CommandProva.model.GameObject;
import common.V2d;

public class UpReleaseCommand implements CommandMovement {

	@Override
	public void execute(GameObject ship) {
		System.out.println("Release Up");
		
		V2d vel = ship.getCurrentVel();
		ship.setVel(vel.sum(new V2d(0,-15)));

	}

}
