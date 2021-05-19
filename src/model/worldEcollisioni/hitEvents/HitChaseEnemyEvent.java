package model.worldEcollisioni.hitEvents;

import model.gameObject.MainGameObject;
import model.worldEcollisioni.WorldEvent;

public class HitChaseEnemyEvent implements WorldEvent {

	private MainGameObject chaseEnemy;
	
	public HitChaseEnemyEvent(MainGameObject obj){
		this.chaseEnemy = obj;
	}
	
	public MainGameObject getCollisionObj(){
		return this.chaseEnemy;
	}
	
}