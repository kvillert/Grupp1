package controller;

import org.jbox2d.common.Vec2;

import view.WorldView;

import model.World;

public class WorldController {
	private InGameController inGameController;
	private model.World world;
	private WorldView worldView;
	
	public WorldController(InGameController inGameController) {
		this.inGameController = inGameController;
		this.world = new World(inGameController.getCharacterController().getCharacter(), 800, 500);
		this.worldView = new WorldView(world, inGameController.getCharacterController().getCharacterView());
	}
	
	public model.World getWorld() {
		return world;
	}

	public WorldView getWorldView() {
		return worldView;
	}

	public void moveBodyRight() {
		//add force to move right
	      worldView.getCharacterBody().applyLinearImpulse(new Vec2(10, 0), worldView.getCharacterBody().getPosition());
	}
	
	public void moveBodyLeft() {
		//add force to move left
		 worldView.getCharacterBody().applyLinearImpulse(new Vec2(-10, 0), worldView.getCharacterBody().getPosition());
	}
	
	public void updateSlickShape() {
		worldView.getCharacterView().getSlickShape().setX(worldView.getCharacterBody().getPosition().x);
		worldView.getCharacterView().getSlickShape().setY(worldView.getCharacterBody().getPosition().y);	}
}