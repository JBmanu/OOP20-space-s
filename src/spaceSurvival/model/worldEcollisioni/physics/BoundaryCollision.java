package spaceSurvival.model.worldEcollisioni.physics;

import spaceSurvival.model.common.P2d;

public class BoundaryCollision {

	public enum CollisionEdge { TOP, BOTTOM, LEFT, RIGHT }
	private CollisionEdge edge;
	private P2d where;
	
	public BoundaryCollision(CollisionEdge edge, P2d where){
		this.edge = edge; 
		this.where = where;
	}
	
	public CollisionEdge getEdge(){
		return edge;
	}
	
	public P2d getWhere(){
		return where;
	}

	@Override
	public String toString() {
		return "BoundaryCollision{" +
				"edge=" + edge +
				", where=" + where +
				'}';
	}
}