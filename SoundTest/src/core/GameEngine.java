package core;

import java.util.LinkedList;
import CommandProva.model.*;
import CommandProva.graphics.*;
import CommandProva.input.*;

public class GameEngine implements WorldEventListener {

	private long period = 10; 	
	private Scene view;
	private LinkedList<WorldEvent> eventQueue;
	private GameState gameState;
	private MovementKeyListener controller;
	
	public GameEngine(){
		eventQueue = new LinkedList<WorldEvent>();
	}
	
	public void initGame(){
		gameState = new GameState(this);
		controller =  new MovementKeyListener(gameState.getWorld().getShip());
		view = new SwingScene(gameState, controller, 600, 600, 20,20);
	}
	
	public void mainLoop(){
		long lastTime = System.currentTimeMillis();
		while (!gameState.isGameOver()) {
			long current = System.currentTimeMillis();
			int elapsed = (int)(current - lastTime);
			//processInput();
			updateGame(elapsed);
			render();
			waitForNextFrame(current);
			lastTime = current;
		}
		renderGameOver();
	}

	protected void waitForNextFrame(long current){
		long dt = System.currentTimeMillis() - current;
		if (dt < period){
			try {
				Thread.sleep(period-dt);
			} catch (Exception ex){}
		}
	}
	
//	protected void processInput(){
//		gameState.getWorld().getShip().updateInput(controller);
//	}
	
	protected void updateGame(int elapsed){
		gameState.getWorld().updateState(elapsed);
		checkEvents();
	}
	
	protected void checkEvents(){
		World scene = gameState.getWorld();
		eventQueue.stream().forEach(ev -> {
			if (ev instanceof HitPickUpEvent){
				HitPickUpEvent cev = (HitPickUpEvent) ev;
				scene.removePickUp(cev.getCollisionObj());
				gameState.incScore();
			} else if (ev instanceof HitWallEvent){
				// HitBorderEvent bev = (HitBorderEvent) ev;
				gameState.decScore();
			}
		});
		eventQueue.clear();
	}
	
	protected void render(){
		view.render();
	}

	protected void renderGameOver(){
		view.renderGameOver();
	}

	@Override
	public void notifyEvent(WorldEvent ev) {
		eventQueue.add(ev);
	}
}
